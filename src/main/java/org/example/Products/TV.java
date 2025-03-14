package org.example.Products;

public class TV extends Electronics{

    private String screenSize;

    private TV(Builder builder){
        super(builder);
        this.screenSize = builder.screenSize;
    }

    public static class Builder extends Electronics.Builder<Builder> {
        /**“I (this Builder class) am extending Electronics.Builder<Builder>,”
         so everywhere Electronics.Builder uses T, it will be referring to this exact Builder class.
         The Builder in the angle brackets (<Builder>) refers to the same class you are currently defining (public static class Builder).
         This is the “curiously recurring generic pattern.” It’s how you tell the parent builder class, “I am the concrete T type,”
         so that any methods returning T will actually return this Builder class.**/
        private String screenSize;



        public Builder screenSize(String screenSize) {
            this.screenSize = screenSize;
            return this;
        }


        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public TV build() {
            return new TV(this);
        }
    }



}
