package pl.dmichalski.otomoto.crawler.business.model;

public class XPaths {

    public static final String OFFER_LINK = "//div[@class='item-col main-box']/div[@class='rel']/h3[@class='om-title']/a/@href";

    public static final String VIN = "//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='VIN']/parent::li/div";
    public static final String PRODUCTION_YEAR = "//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='Rok produkcji']/parent::li/div";
    public static final String TYPE = "//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='Kategoria']/parent::li/div";
    public static final String MAKE = "//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='Marka']/parent::li/div";
    public static final String MODEL ="//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='Model']/parent::li/div";
    public static final String VERSION = "//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='Wersja']/parent::li/div";
    public static final String FUEL = "//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='Rodzaj paliwa']/parent::li/div";
    public static final String ENGINE_CAPACITY = "//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='Pojemność skokowa']/parent::li/div";
    public static final String ENGINE_POWER = "//div[@class='offer-params']/ul[@class='offer-params__list']/li[@class='offer-params__item']/span[text()='Moc']/parent::li/div";

}