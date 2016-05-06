package pl.dmichalski.otomoto.crawler.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import pl.dmichalski.otomoto.crawler.business.job.VehicleListJob;
import pl.dmichalski.otomoto.crawler.business.model.VehicleMarks;

import javax.annotation.PostConstruct;

@Configuration
public class SchedulingConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(SchedulingConfiguration.class);

    @Autowired
    private VehicleListJob vehicleListJob;
    @Autowired
    private VehicleMarks vehicleMarks;

    @Bean
    ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(25);
        executor.setWaitForTasksToCompleteOnShutdown(false);
        executor.setThreadNamePrefix("otomoto-vehicle-executor");
        executor.setAwaitTerminationSeconds(10);
        return executor;
    }

    @PostConstruct
    public void configureTasks() throws Exception {
        logger.info("Configuring update vehicle list job for marks: {}", vehicleMarks.getVehicleMarks());
        vehicleMarks.getVehicleMarks().forEach(this::execute);
    }

    private void execute(String vehicleMark) {
        taskExecutor().execute(() -> vehicleListJob.retrieveVehicleList(vehicleMark));
    }

}
