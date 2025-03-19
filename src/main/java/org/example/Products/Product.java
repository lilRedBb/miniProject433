package org.example.Products;



public abstract class Product  {
    private String id;
    private String name;
    private double price;


    protected Product(Builder<?> builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;

    }

    public static abstract class Builder<T extends Builder<T>> {
        /**The parent doesn’t literally know each subclass at compile time,
         * but by using T extends Builder<T>, it says,
         * “whatever subclass extends me will define T ,so I’ll return that.”
         The subclass then tells the parent, “Yes, T is ElectronicsBuilder,
         so return this typed as ElectronicsBuilder.”
         in short: The parent is Builder class, it has a parameter that is T,
         T has to be something that extends Builder<T></>**/
        private String id;
        private String name;
        private double price;


        //parent class return T in the method, which tells it will return any subclass that extends the parent
        //because, we will be using the subclass to call all these methods, not the parent
        public T id(String id) {
            this.id = id;
            return self();
        }

        public T name(String name) {
            this.name = name;
            return self();
        }

        public T price(double price) {
            this.price = price;
            return self();
        }



        // This ensures method chaining returns the correct builder type
        protected abstract T self();

        // Each subclass will implement its own build method
        public abstract Product build();
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}

