package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Ingredients {

    public static String LETTUCE = "LETTUCE";
    public static String ONION = "ONION";
    public static String BEACON = "BEACON";
    public static String CUCUMBER = "CUCUMBER";
    public static String CHILLIPEPPERS = "CHILLI PEPPERS";
    public static String MUSHROOMS = "MUSHROOMS";
    public static String SHRIMPS = "SHRIMPS";
    public static String CHEESE = "CHEESE";

    public static List<String> getAvailableIngredients() {
        List<String> availableIngredients = new ArrayList<>();
        availableIngredients.add(LETTUCE);
        availableIngredients.add(ONION);
        availableIngredients.add(BEACON);
        availableIngredients.add(CUCUMBER);
        availableIngredients.add(CHILLIPEPPERS);
        availableIngredients.add(MUSHROOMS);
        availableIngredients.add(SHRIMPS);
        availableIngredients.add(CHEESE);
        return availableIngredients;
    }


}
