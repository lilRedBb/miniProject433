package org.example.Products;

public abstract class Electronics extends Product {
    private int warrantyInMonths;

    // Constructor using the generic builder
    protected Electronics(Builder<?> builder) {
        super(builder);
        this.warrantyInMonths = builder.warrantyInMonths;
    }


    // Generic abstract builder for Electronics
    public static abstract class Builder<T extends Builder<T>> extends Product.Builder<T> {
        //my builder is extending my parent's builder, and also, for its subclass, it has to be
        //extension of Builder<T>

        private int warrantyInMonths;

        public T warrantyInMonths(int warrantyInMonths) {
            this.warrantyInMonths = warrantyInMonths;
            return self(); // Ensures correct subclass type is returned
        }

        @Override
        protected abstract T self(); // Subclass defines how to return itself
    }

    public int getWarrantyInMonths() {
        return warrantyInMonths;
    }

    public void setWarrantyInMonths(int warrantyInMonths) {
        this.warrantyInMonths = warrantyInMonths;
    }
}

