package com.lazylad.expensetrackerapi.services;

import com.lazylad.expensetrackerapi.domain.User;
import com.lazylad.expensetrackerapi.exceptions.AuthException;
import com.lazylad.expensetrackerapi.exceptions.BadRequestException;
import com.lazylad.expensetrackerapi.repositories.UserRepository;
import com.lazylad.expensetrackerapi.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws AuthException {
        return null;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws BadRequestException {

        Validator validator = new Validator();

        if (!validator.isEmailValid(email)) {
            throw new BadRequestException("Invalid email address");
        }

        Integer count = userRepository.CountByEmail(email);

        if (count > 0) {
            throw new BadRequestException("Email already in use");
        }

        Integer userId = userRepository.create(firstName, lastName, email, password);

        return userRepository.findById(userId);
    }

    @Override
    public User findUserById(Integer id) throws AuthException {
        return userRepository.findById(id);
    }

    @Override
    public User[] findAllUsers(Integer limit) throws AuthException {
        return userRepository.findAll(limit);
    }
}
