package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Andreea Munteanu, group X
 */
public interface Storage {
    abstract void printCapacity();
    abstract void setStorage(int capacity);
    abstract int getStorage();

    default int convertCapacityTo(String measureUnit) {
        /*
         *  Method for converting storage capacity into another unit of measurement (MB, KB, B).
         */

        // first we make sure that the unit is valid:
        List<String> measureUnits = new ArrayList<String>();
        measureUnits.add("MB"); // megabyte
        measureUnits.add("KB"); // kilobyte
        measureUnits.add("B"); // byte
        assert measureUnits.contains(measureUnit);

        int c = getStorage();
        int res = 0;
        String unit = "";

        // making the conversion:
        switch (measureUnit) {
            case "MB" -> {
                res = c * 1000;
                unit = "MB";
            }
            case "KB" -> {
                res = c * 1000000;
                unit = "KB";
            }
            case "B" -> {
                res = c * 1000000000;
                unit = "B";
            }
        };

        System.out.println("Storage capacity in " + measureUnit + ": " + res + " " + unit);
        return res;
    }

}
