package org.example.Products;

public class Laptop extends Electronics {
    private String processor;


    private Laptop(Builder builder) {
        super(builder);
        this.processor = builder.processor;

    }

    public String getProcessor(){
        return processor;
    }


    public static class Builder extends Electronics.Builder<Builder> {
        /**“I (this Builder class) am extending Electronics.Builder<Builder>,”
         so everywhere Electronics.Builder uses T, it will be referring to this exact Builder class.
         The Builder in the angle brackets (<Builder>) refers to the same class you are currently defining (public static class Builder).
         This is the “curiously recurring generic pattern.” It’s how you tell the parent builder class, “I am the concrete T type,”
         so that any methods returning T will actually return this Builder class.**/
        private String processor;


        public Builder processor(String processor) {
            this.processor = processor;
            return this;
        }


        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Laptop build() {
            return new Laptop(this);
        }
    }
}
