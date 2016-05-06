package pl.dmichalski.otomoto.crawler.business.model;

public class Vehicle {
    private final String make;
    private final String model;
    private final String vin;
    private final String productionYear;
    private final String version;
    private final String type;
    private final String fuel;
    private final String engineCapacity;
    private final String enginePower;

    private Vehicle(Builder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.vin = builder.vin;
        this.productionYear = builder.productionYear;
        this.version = builder.version;
        this.type = builder.type;
        this.fuel = builder.fuel;
        this.engineCapacity = builder.engineCapacity;
        this.enginePower = builder.enginePower;
    }

    public static Builder create() {
        return new Builder();
    }

    public static final class Builder {
        private String make;
        private String model;
        private String vin;
        private String productionYear;
        private String version;
        private String type;
        private String fuel;
        private String engineCapacity;
        private String enginePower;

        private Builder() {
        }

        public Vehicle build() {
            return new Vehicle(this);
        }

        public Builder make(String make) {
            this.make = make;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder vin(String vin) {
            this.vin = vin;
            return this;
        }

        public Builder productionYear(String productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder fuel(String fuel) {
            this.fuel = fuel;
            return this;
        }

        public Builder engineCapacity(String engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public Builder enginePower(String enginePower) {
            this.enginePower = enginePower;
            return this;
        }
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public String getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }

    public String getFuel() {
        return fuel;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public String getEnginePower() {
        return enginePower;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", productionYear='" + productionYear + '\'' +
                ", version='" + version + '\'' +
                ", type='" + type + '\'' +
                ", fuel='" + fuel + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", enginePower='" + enginePower + '\'' +
                '}';
    }
}
