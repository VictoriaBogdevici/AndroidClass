package com.example.conted.listviewimages;

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Drink[] drinks={
            new Drink("Latte","Esspreso shots with steamed milk",R.drawable.chefpoutine),
            new Drink("Milkshake","Milk cocktail",R.drawable.sushi),
            new Drink("Tea","Herbal Tea",R.drawable.salmon),
    };
}
