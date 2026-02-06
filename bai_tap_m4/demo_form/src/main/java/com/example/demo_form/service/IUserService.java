package com.example.demo_form.service;

import com.example.demo_form.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean save(User user);
    boolean delete(int id);
}
