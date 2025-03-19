package org.example.Products;

import java.util.concurrent.RecursiveTask;

public class Produce extends Product{

    private Integer freshDay;

    private Produce(Builder builder) {
        super(builder);
        this.freshDay = builder.freshDay;

    }

    public static class Builder extends Product.Builder<Builder> {
        /**“I (this Builder class) am extending Electronics.Builder<Builder>,”
         so everywhere Electronics.Builder uses T, it will be referring to this exact Builder class.
         The Builder in the angle brackets (<Builder>) refers to the same class you are currently defining (public static class Builder).
         This is the “curiously recurring generic pattern.” It’s how you tell the parent builder class, “I am the concrete T type,”
         so that any methods returning T will actually return this Builder class.**/
        private Integer freshDay;


        public Builder freshDay(Integer freshDay) {
            this.freshDay = freshDay;
            return this;
        }


        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Produce build() {
            return new Produce(this);
        }


    }
    public int getFreshDay(){
        return freshDay;
    }


}
