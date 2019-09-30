package com.company.Infrastructure.data;

//наш кастомный эксепшен, что при поиске юзера по имени или емейлу не найдено

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
