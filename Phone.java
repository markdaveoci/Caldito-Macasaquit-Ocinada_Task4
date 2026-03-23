public class Phone extends Hardware {

    private Phone(PhoneBuilder builder) {
        super(builder.id, builder.brand, builder.spec);
    }

    @Override
    public String interpretSpec() {
        return spec + " Megapixels";
    }

    public static class PhoneBuilder {
        private int id;
        private String brand;
        private int spec;

        public PhoneBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public PhoneBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public PhoneBuilder setSpec(int spec) {
            this.spec = spec;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }
}