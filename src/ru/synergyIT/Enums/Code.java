package ru.synergyIT.Enums;

import java.util.Random;

public enum Code {
    MTS, Tele2, Beeline, Megafon;

    public static String getRandomCode() {
        Code[] values = Code.values ();
        int length = values.length;
        int randIndex = new Random ().nextInt ( length );
        String code;
        switch (String.valueOf ( values[randIndex] )) {
            case "MTS":
                code = "911";
                break;
            case "Tele2":
                code = "900";
                break;
            case "Beeline":
                code = "906";
                break;
            case "Megafon":
                code = "921";
                break;
            default:
                code = "495";
        }
        return code;
    }
}
