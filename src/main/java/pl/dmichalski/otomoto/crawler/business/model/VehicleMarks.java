package pl.dmichalski.otomoto.crawler.business.model;

import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "otomoto.search")
public class VehicleMarks {

    private List<String> vehicleMarks = Lists.newArrayList();

    public List<String> getVehicleMarks() {
        return vehicleMarks;
    }
}
