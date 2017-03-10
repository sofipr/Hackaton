package com.example.android.facebookloginsample;

import java.util.Date;

/**
 * Created by Danielle on 09/03/2017.
 */

public class Child {
    private Date birthDate;
    private char gender;

    public Child(char gender, Date birthDate) {
        if (!isGenderValid(gender) || !isBirthDateValid(birthDate)) {
            throw new IllegalArgumentException();
        }

        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public char getGender() {
        return this.gender;
    }

    private boolean isGenderValid(char gender) {
        return (gender == 'f' || gender == 'm');
    }

    private boolean isBirthDateValid(Date birthDate) {
        return (birthDate != null);
    }
}
