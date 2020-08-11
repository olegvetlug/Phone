package ru.synergyIT;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class PhoneUser {
    ArrayList<PhoneUser> contactList = new ArrayList<> ();
    private String surname;
    private String name;
    private String secondname;
    private String number;

    public PhoneUser() {
    }

    public PhoneUser getFromContactList(int index) {
        return contactList.get ( index );
    }

    public void addToContactList(PhoneUser contact) {
        contactList.add ( contact );
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondname;
    }

    public void setSecondName(String secondname) {
        this.secondname = secondname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        PhoneUser phoneUser = (PhoneUser) o;
        return Objects.equals ( number , phoneUser.number );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( number );
    }

    public void setRandomContactList(Set<PhoneUser> phoneUserSet) {
        phoneUserSet.forEach ( phoneUserAdded -> {
            if (!this.equals ( phoneUserAdded )) {
                int i = new Random ().nextInt ( 1000 );
                if (i == 9) {
                    this.addToContactList ( phoneUserAdded );
                }
            }
        } );
    }

    public ArrayList<PhoneUser> getContactList() {
        return contactList;
    }

    @Override
    public String toString() {
        return "PhoneUser{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", secondname='" + secondname + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
