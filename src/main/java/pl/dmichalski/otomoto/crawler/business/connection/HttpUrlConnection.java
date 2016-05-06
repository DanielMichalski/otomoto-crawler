package pl.dmichalski.otomoto.crawler.business.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpUrlConnection {

    private static final String USER_AGENT = "User-Agent";
    private static final String CONTENT_TYPE = "Content-Type";

    private ConnectionConfig config;

    @Autowired
    public HttpUrlConnection(ConnectionConfig config) {
        this.config = config;
    }

    public InputStream connect(String www) throws Exception {
        URL url = new URL(www);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(config.getRequestMethod());
        connection.setRequestProperty(USER_AGENT, config.getUserAgent());
        connection.setRequestProperty(CONTENT_TYPE, config.getContentType());
        connection.setReadTimeout(config.getReadTimeout());
        return connection.getInputStream();
    }


}
