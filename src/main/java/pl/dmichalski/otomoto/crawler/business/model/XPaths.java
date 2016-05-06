package pl.dmichalski.otomoto.crawler.business.model;

public class XPaths {

    public static final String OFFER_LINK = "//div[@class='item-col main-box']/div[@class='rel']/h3[@class='om-title']/a/@href";

    public static final String VIN = "//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='VIN']/span";
    public static final String PRODUCTION_YEAR = "//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='Rok produkcji']/span";
    public static final String TYPE = "//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='Kategoria']/a/span";
    public static final String MAKE = "//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='Marka']/a/span";
    public static final String MODEL ="//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='Model']/a/span";
    public static final String VERSION = "//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='Wersja']/a/span";
    public static final String FUEL = "//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='Rodzaj paliwa']/a/span";
    public static final String ENGINE_CAPACITY = "//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='Pojemność skokowa']/span";
    public static final String ENGINE_POWER = "//div[@class='om-offer-params']/ul[@class='params-list clr']/li[small='Moc']/span";

}