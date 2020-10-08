package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Sauce {

    public static String STANDARD = "STANDARD";
    public static String THOUSANDISLANDS = "1000 ISLANDS";
    public static String BARBEQUE = "BARBEQUE";

    public static List<String> getAvailableSauses() {
        List<String> availableSauses = new ArrayList<>();
        availableSauses.add(STANDARD);
        availableSauses.add(THOUSANDISLANDS);
        availableSauses.add(BARBEQUE);
        return availableSauses;
    }

}
