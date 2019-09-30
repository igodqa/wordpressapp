package com.company.Infrastructure.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUserDataMapper implements UserDataMapper {

    private List<User> users = new ArrayList<>();

    // заполняется массив юзеров из файла user.txt
    public FileUserDataMapper() {
        try {
            FileReader fr = new FileReader("user.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                users.add(new User(data[0], data[1], data[2]));
            }

            fr.close();
        } catch (Exception ex) {
            throw new RuntimeException("User data was not mapped due to exception", ex);
        }

    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User findUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email))
                return u;
        }
        throw new UserNotFoundException("User with email " + email + "was not found");
    }

    @Override
    public User findUserByName(String name) {
        for (User u : users) {
            if (u.getName().equals(name))
                return u;
        }
        throw new UserNotFoundException("User with name " + name + "was not found");
    }
}
