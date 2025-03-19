package org.example.Products;

import java.util.concurrent.RecursiveTask;

public class CleaningStuff extends Product{

    private String ingredient;

    CleaningStuff(Builder builder) {
        super(builder);
        this.ingredient = builder.ingredient;

    }

    public static class Builder extends Product.Builder<Builder> {
        /**“I (this Builder class) am extending Electronics.Builder<Builder>,”
         so everywhere Electronics.Builder uses T, it will be referring to this exact Builder class.
         The Builder in the angle brackets (<Builder>) refers to the same class you are currently defining (public static class Builder).
         This is the “curiously recurring generic pattern.” It’s how you tell the parent builder class, “I am the concrete T type,”
         so that any methods returning T will actually return this Builder class.**/
        private String ingredient;


        public Builder ingredient(String ingredient) {
            this.ingredient = ingredient;
            return this;
        }


        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public CleaningStuff build() {
            return new CleaningStuff(this);
        }
    }

    public String getIngredient(){
        return ingredient;
    }
}
