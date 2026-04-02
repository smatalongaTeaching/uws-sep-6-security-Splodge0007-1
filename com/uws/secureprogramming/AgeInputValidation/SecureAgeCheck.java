package com.uws.secureprogramming.AgeInputValidation;

import java.util.Scanner;

public class SecureAgeCheck implements iAgeCheck {

    @Override
    public String checkAge(String age) {
        try {
            int ageInt = Integer.parseInt(age);
            if (ageInt >= 18 && ageInt <= 120) {
                return Adult;
            } else if (ageInt >= 0 && ageInt < 18) {
                return Minor;
            } else {
                return Invalid;
            }
        } catch (NumberFormatException e) {
            return Invalid;
        }
    }
}
