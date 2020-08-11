package ru.synergyIT.Enums;

import java.util.Random;

public enum SecondName {
    Алексеевич, Иванович, Сергеевич, Андреевич, Геннадьевич, Ильич, Петрович, Сидорович, Глебович, Дмитриевич, Витальевич;

    public static String getRandomSecondName() {
        SecondName[] values = SecondName.values ();
        int lenght = values.length;
        int randIndex = new Random ().nextInt ( lenght );
        return String.valueOf ( values[randIndex] );
    }
}
