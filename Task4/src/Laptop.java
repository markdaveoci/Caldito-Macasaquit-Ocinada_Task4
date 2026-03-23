
    public class Laptop extends Hardware {

    private Laptop(LaptopBuilder builder) {
        super(builder.id, builder.brand, builder.spec);
    }


    public String interpretSpec() {
        return spec + "GB RAM";
    }

    public static class LaptopBuilder {
        private int id;
        private String brand;
        private int spec;

        public LaptopBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public LaptopBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public LaptopBuilder setSpec(int spec) {
            this.spec = spec;
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }
    }
}
