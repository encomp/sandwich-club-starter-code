package com.udacity.sandwichclub.model;

import java.util.List;

public final class Sandwich {

    private final String mainName;
    private final List<String> alsoKnownAs;
    private final String placeOfOrigin;
    private final String description;
    private final String image;
    private final List<String> ingredients;

    public Sandwich() {
        this.mainName = null;
        this.alsoKnownAs = null;
        this.placeOfOrigin = null;
        this.description = null;
        this.image = null;
        this.ingredients = null;
    }

    private Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin,
                     String description, String image, List<String> ingredients) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public List<String> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public static final Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String mainName;
        private List<String> alsoKnownAs;
        private String placeOfOrigin;
        private String description;
        private String image;
        private List<String> ingredients;

        private Builder() {
        }

        public Builder setMainName(String mainName) {
            this.mainName = mainName;
            return this;
        }

        public Builder setAlsoKnownAs(List<String> alsoKnownAs) {
            this.alsoKnownAs = alsoKnownAs;
            return this;
        }

        public Builder setPlaceOfOrigin(String placeOfOrigin) {
            this.placeOfOrigin = placeOfOrigin;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setImage(String image) {
            this.image = image;
            return this;
        }

        public Builder setIngredients(List<String> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Sandwich build() {
            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image,
                    ingredients);
        }
    }
}
