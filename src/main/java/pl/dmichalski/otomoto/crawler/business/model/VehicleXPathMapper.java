package pl.dmichalski.otomoto.crawler.business.model;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleXPathMapper {

    private static final Logger logger = LoggerFactory.getLogger(VehicleXPathMapper.class);

    public Vehicle mapToVehicle(Document document) throws XPathExpressionException {
        return Vehicle.create()
                .vin(evaluateXpathNode(document, XPaths.VIN))
                .productionYear(evaluateXpathNode(document, XPaths.PRODUCTION_YEAR))
                .type(evaluateXpathNode(document, XPaths.TYPE))
                .make(evaluateXpathNode(document, XPaths.MAKE))
                .model(evaluateXpathNode(document, XPaths.MODEL))
                .version(evaluateXpathNode(document, XPaths.VERSION))
                .fuel(evaluateXpathNode(document, XPaths.FUEL))
                .engineCapacity(evaluateXpathNode(document, XPaths.ENGINE_CAPACITY))
                .enginePower(evaluateXpathNode(document, XPaths.ENGINE_POWER))
                .build();
    }

    public List<String> mapToVehiclesLinks(Document document) throws XPathExpressionException {
        ArrayList<String> offersLinks = Lists.newArrayList();
        NodeList nodes = evaluateXpathNodes(document, XPaths.OFFER_LINK);
        for (int i = 0; i < nodes.getLength(); i++) {
            String offerLink = nodes.item(i).getNodeValue();
            offersLinks.add(offerLink);
            logger.info("Found offer link: [{}]", offerLink);
        }
        return offersLinks;
    }

    private String evaluateXpathNode(Document doc, String xpath) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        return (String) xPath.evaluate(xpath, doc, XPathConstants.STRING);
    }

    private NodeList evaluateXpathNodes(Document doc, String xpath) throws XPathExpressionException {
        XPath xPath = XPathFactory.newInstance().newXPath();
        return (NodeList) xPath.evaluate(xpath, doc, XPathConstants.NODESET);
    }

}
