package com.uws.secureprogramming.AgeInputValidation;

public class VulnerableAgeCheck implements iAgeCheck {

    @Override
    public String checkAge(String age) {

    try {
        int userAge = Integer.parseInt(age); // Tries to convert the string to an integer

        if (userAge < 0 || userAge > 120) {
            System.out.println("Invalid input. Please enter a valid numerical age 0-120.");
            return iAgeCheck.Invalid;
        }

        if (userAge >= 18) {
            return iAgeCheck.Adult;
        } else {
            return iAgeCheck.Minor;
        }
    }
    catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid numerical age 0-120.");
        return iAgeCheck.Invalid;
    }

}
}
