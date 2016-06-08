package pl.dmichalski.otomoto.crawler.business.export;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.*;
import static java.nio.file.StandardOpenOption.APPEND;

@Service
public class VehicleStorage {

    private static final Logger logger = LoggerFactory.getLogger(VehicleStorage.class);

    private String outputFilePath;

    @Autowired
    public VehicleStorage(@Value("${txt.output.file.path}") String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public synchronized void appendLinesToFile(List<String> lines) {
        try {
            logger.info("Saving file with vehicles in path: [{}]", outputFilePath);
            createEmptyFileIfNotExists();
            Files.write(Paths.get(outputFilePath), lines, APPEND);
            logger.info("File with vehicles saved successfully");
        } catch (IOException e) {
            logger.error("Error while saving output file: {}", e.getMessage(), e);
        }
    }

    private void createEmptyFileIfNotExists() throws IOException {
        logger.info("Creating empty file in path: [{}]", outputFilePath);
        if (notExists(Paths.get(outputFilePath))) {
            createFile(Paths.get(outputFilePath));
        }
        logger.info("Empty file created in path: [{}]", outputFilePath);
    }

}
