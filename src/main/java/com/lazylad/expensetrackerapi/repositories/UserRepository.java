package com.lazylad.expensetrackerapi.repositories;

import com.lazylad.expensetrackerapi.domain.User;
import com.lazylad.expensetrackerapi.exceptions.AuthException;
import com.lazylad.expensetrackerapi.exceptions.BadRequestException;
import com.lazylad.expensetrackerapi.exceptions.NotFoundException;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws BadRequestException;

    User findByEmailAndPassword(String email, String password) throws AuthException;

    Integer CountByEmail(String email);

    User findById(Integer userId) throws NotFoundException;

    User[] findAll(Integer limit);
}
