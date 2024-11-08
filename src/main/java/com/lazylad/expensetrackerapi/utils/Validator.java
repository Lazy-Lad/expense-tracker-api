package com.lazylad.expensetrackerapi.utils;

import java.util.regex.Pattern;

public class Validator {

    private final String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Boolean isEmailValid(String email){
        if(email == null || email.isEmpty()) return false;

        Pattern pattern = Pattern.compile(emailPattern);

        return pattern.matcher(email).matches();
    };
}
