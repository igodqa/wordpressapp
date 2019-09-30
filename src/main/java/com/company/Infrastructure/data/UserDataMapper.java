package com.company.Infrastructure.data;

import java.util.List;

public interface UserDataMapper {

    List<User> getAll();

    User findUserByEmail(String email);

    User findUserByName(String name);
}
