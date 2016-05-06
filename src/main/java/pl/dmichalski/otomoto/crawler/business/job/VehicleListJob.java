package pl.dmichalski.otomoto.crawler.business.job;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmichalski.otomoto.crawler.business.export.VehicleStorage;
import pl.dmichalski.otomoto.crawler.business.json.JsonMapper;
import pl.dmichalski.otomoto.crawler.business.model.Vehicle;
import pl.dmichalski.otomoto.crawler.business.service.VehicleAuctionService;
import pl.dmichalski.otomoto.crawler.business.service.VehicleSearchService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.stream.Collectors.toList;

@Component
public class VehicleListJob {

    private static final Logger logger = LoggerFactory.getLogger(VehicleListJob.class);

    private VehicleSearchService vehicleSitesService;
    private VehicleAuctionService vehicleService;
    private JsonMapper jsonMapper;
    private VehicleStorage vehicleStorage;

    @Autowired
    public VehicleListJob(VehicleSearchService vehicleSitesService,
                          VehicleAuctionService vehicleService,
                          JsonMapper jsonMapper,
                          VehicleStorage vehicleStorage) {
        this.vehicleSitesService = vehicleSitesService;
        this.vehicleService = vehicleService;
        this.jsonMapper = jsonMapper;
        this.vehicleStorage = vehicleStorage;
    }

    public void retrieveVehicleList(String vehicleMark) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        List<Vehicle> vehicles = findVehicles(vehicleMark);
        List<String> vehicleJsonList = mapVehiclesToJson(vehicles);
        vehicleStorage.appendLinesToFile(vehicleJsonList);

        stopwatch.stop();
        logger.info("Execution took: [{}s] for mark [{}]", stopwatch.elapsed(TimeUnit.SECONDS), vehicleMark);
    }

    private List<Vehicle> findVehicles(String vehicleMark) {
        List<String> vehicleSites = vehicleSitesService.findAllVehicleSitesForMark(vehicleMark);
        return vehicleSites.stream()
                .map(vehicleService::getVehicleFromSite)
                .collect(toList());
    }

    private List<String> mapVehiclesToJson(List<Vehicle> vehicles) {
        return vehicles.stream()
                    .map(jsonMapper::mapToJson).collect(toList());
    }

}
