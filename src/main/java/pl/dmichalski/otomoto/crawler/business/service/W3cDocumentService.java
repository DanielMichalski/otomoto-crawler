package pl.dmichalski.otomoto.crawler.business.service;

import com.google.common.base.Charsets;
import org.apache.commons.io.IOUtils;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import pl.dmichalski.otomoto.crawler.business.connection.HttpUrlConnection;

import java.io.InputStream;

@Service
public class W3cDocumentService {

    private HttpUrlConnection connection;

    @Autowired
    public W3cDocumentService(HttpUrlConnection connection) {
        this.connection = connection;
    }

    public Document getDocument(String www) throws Exception {
        String response = getResponseAsString(www);
        TagNode cleanedHtml = new HtmlCleaner().clean(response);
        return new DomSerializer(new CleanerProperties()).createDOM(cleanedHtml);
    }

    private String getResponseAsString(String www) throws Exception {
        InputStream inputStream = connection.connect(www);
        String pageContent = IOUtils.toString(inputStream, Charsets.UTF_8.name());
        IOUtils.closeQuietly(inputStream);
        return pageContent;
    }


}
