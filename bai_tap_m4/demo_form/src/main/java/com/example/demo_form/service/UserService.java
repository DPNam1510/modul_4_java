package com.example.demo_form.service;

import com.example.demo_form.entity.User;
import com.example.demo_form.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo userRepo;
    public List<User> findAll(){
        return userRepo.findAll();
    }
    public boolean save(User user){
        try {
            userRepo.save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(int id){
        try {
            userRepo.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
