package pl.dmichalski.otomoto.crawler.business.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import pl.dmichalski.otomoto.crawler.business.model.Vehicle;
import pl.dmichalski.otomoto.crawler.business.model.VehicleXPathMapper;

@Service
public class VehicleAuctionService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleAuctionService.class);

    private W3cDocumentService w3cDocument;
    private VehicleXPathMapper vehicleMapper;

    @Autowired
    public VehicleAuctionService(W3cDocumentService w3cDocument, VehicleXPathMapper vehicleMapper) {
        this.w3cDocument = w3cDocument;
        this.vehicleMapper = vehicleMapper;
    }

    public Vehicle getVehicleFromSite(String vehicleOfferLink) {
        try {
            Document document = w3cDocument.getDocument(vehicleOfferLink);
            Vehicle vehicle = vehicleMapper.mapToVehicle(document);
            logger.info("Found vehicle: " + vehicle);
            return vehicle;
        } catch (Exception e) {
            throw new RuntimeException("Error while getting vehicle description from site: " + e.getMessage(), e);
        }
    }

}
