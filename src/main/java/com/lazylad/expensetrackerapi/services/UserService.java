package com.lazylad.expensetrackerapi.services;

import com.lazylad.expensetrackerapi.domain.User;
import com.lazylad.expensetrackerapi.exceptions.AuthException;
import com.lazylad.expensetrackerapi.exceptions.BadRequestException;

public interface UserService {
    User validateUser(String email, String password) throws AuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws BadRequestException;

    User findUserById(Integer id) throws AuthException;

    User[] findAllUsers(Integer limit) throws AuthException;
}
