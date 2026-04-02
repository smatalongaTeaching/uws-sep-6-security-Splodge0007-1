package com.uws.secureprogramming.AgeInputValidation;

public interface iAgeCheck {
    final String Adult = "Adult";
    final String Minor = "Minor";
    final String Invalid = "Invalid";
    String checkAge(String age);
}
