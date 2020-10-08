package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private String bun;
    private int burgers;
    private String sauce;
    private List<String> ingredients = new ArrayList<>();

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static class BigmacBuilder {

        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bunType) {
            if (bunType.equals(Bun.SESAME) || bunType.equals(Bun.STANDARD)) {
                this.bun = bunType;
                return this;
            } else {
                throw new IllegalStateException("Please choose " + Bun.SESAME + " or " + Bun.STANDARD);
            }
        }

        public BigmacBuilder burgers(int quantity) {
            if (quantity < 1 || quantity > 2) {
                throw new ArrayIndexOutOfBoundsException("Choose 1 or 2 burgers");
            }
            this.burgers = quantity;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (Sauce.getAvailableSauses().contains(sauce)) {
                this.sauce = sauce;
                return this;
            } else {
                throw new IllegalStateException("Sause " + sauce + " is not available, please choose one of below: " +
                        "\n" + Sauce.getAvailableSauses());
            }
        }

        public BigmacBuilder ingredients(String ingredient) {
            if (Ingredients.getAvailableIngredients().contains(ingredient)) {
                ingredients.add(ingredient);
                return this;
            } else {
                throw new IllegalStateException("Ingredient " + ingredient + " is not available, please choose one of below: " +
                        "\n" + Ingredients.getAvailableIngredients());
            }
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }

    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
