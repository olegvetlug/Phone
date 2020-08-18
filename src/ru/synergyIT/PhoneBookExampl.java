package ru.synergyIT;

import ru.synergyIT.Enums.Name;
import ru.synergyIT.Enums.Numbers;
import ru.synergyIT.Enums.SecondName;
import ru.synergyIT.Enums.Surname;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBookExampl {
    public static void main(String[] args) {

        Set<PhoneUser> phoneBook = new HashSet<> ();

        while (phoneBook.size () < 10000) {
            PhoneUser user = new PhoneUser ();
            String surname = Surname.getRandomSurname ();
            user.setSurname ( surname );
            String name = Name.getRandomName ();
            user.setName ( name );
            String secondname = SecondName.getRandomSecondName ();
            user.setSecondName ( secondname );
            String number = "+7 " + "9" + Numbers.getRandomNum () + Numbers.getRandomNum () + " " + Numbers.getRandomNum () + Numbers.getRandomNum () + Numbers.getRandomNum () + " " + Numbers.getRandomNum () + Numbers.getRandomNum () + " " + Numbers.getRandomNum () + Numbers.getRandomNum ();
            user.setNumber ( number );
            phoneBook.add ( user );
        }
        phoneBook.forEach ( phoneUser -> {
            phoneUser.setRandomContactList ( phoneBook );
        } );

        findMustPopularUser ( phoneBook );
    }


    public static PhoneUser findMustPopularUser(Set<PhoneUser> phoneBook) {
        Map<String, Integer> popularityUser = new HashMap<> ();
        phoneBook.forEach ( phoneUser -> popularityUser.put ( phoneUser.getNumber () , 0 ) );

        phoneBook.forEach ( phoneUser -> {
            for (int i = 0; i < phoneUser.getContactList ().size (); i++) {
                Integer value = popularityUser.get ( phoneUser.getFromContactList ( i ).getNumber () ) + 1;
                popularityUser.replace ( phoneUser.getFromContactList ( i ).getNumber () , value );
            }
        } );
        int maxValue = Integer.MIN_VALUE;
      //  stream().max();
        for (int value : popularityUser.values ()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        int finalMaxValue = maxValue;
        phoneBook.forEach ( phoneUser -> {
            popularityUser.forEach ( (key , value) -> {
                if (phoneUser.getNumber ().equals ( key ) && value.equals ( finalMaxValue )) {
                    System.out.println ( phoneUser + " количество контактов на данный объект " + value );
                }
            } );
        } );
        return null;
    }
}