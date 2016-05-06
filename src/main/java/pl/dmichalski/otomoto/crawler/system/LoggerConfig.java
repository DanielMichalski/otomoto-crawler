package pl.dmichalski.otomoto.crawler.system;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
class LoggerConfig {

    @PreDestroy
    public void destroyLoggers() {
        final ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
        if (loggerFactory instanceof LoggerContext) {
            final LoggerContext context = (LoggerContext) loggerFactory;
            context.stop();
        }
    }

}
