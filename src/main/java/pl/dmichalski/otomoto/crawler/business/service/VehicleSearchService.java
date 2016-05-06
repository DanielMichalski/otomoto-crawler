package pl.dmichalski.otomoto.crawler.business.service;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import pl.dmichalski.otomoto.crawler.business.model.VehicleXPathMapper;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class VehicleSearchService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleSearchService.class);

    private String searchUrl;
    private int fromPageNo;
    private int toPageNo;
    private W3cDocumentService w3cDocumentService;
    private VehicleXPathMapper vehicleMapper;

    @Autowired
    public VehicleSearchService(@Value("${otomoto.www.searchSiteTemplate}") String searchUrl,
                                @Value("${otomoto.search.pages.fromPageNo}") int fromPageNo,
                                @Value("${otomoto.search.pages.toPageNo}") int toPageNo,
                                W3cDocumentService w3cDocumentService,
                                VehicleXPathMapper vehicleMapper) {
        this.searchUrl = searchUrl;
        this.fromPageNo = fromPageNo;
        this.toPageNo = toPageNo;
        this.w3cDocumentService = w3cDocumentService;
        this.vehicleMapper = vehicleMapper;
    }

    public List<String> findAllVehicleSitesForMark(String vehicleMark) {
        List<String> searchSites = getAllSearchSitesForMark(vehicleMark);
        return searchSites.stream()
                .map(this::findAllVehiclesAuctionSitesFromSearchSite)
                .flatMap(Collection::stream)
                .collect(toList());
    }

    private List<String> getAllSearchSitesForMark(String vehicleMark) {
        List<String> vehicleSearchSites = Lists.newArrayList();
        for (int i = fromPageNo; i <= toPageNo; i++) {
            String searchSite = String.format(searchUrl, vehicleMark, i);
            vehicleSearchSites.add(searchSite);
        }
        return vehicleSearchSites;
    }

    private List<String> findAllVehiclesAuctionSitesFromSearchSite(String searchSite) {
        try {
            logger.info("Finding vehicle offers sites from site: [{}]", searchSite);
            Document document = w3cDocumentService.getDocument(searchSite);
            return vehicleMapper.mapToVehiclesLinks(document);
        } catch (Exception e) {
            throw new RuntimeException("Error while finding vehicle auctions links: " + e.getMessage(), e);
        }
    }

}
