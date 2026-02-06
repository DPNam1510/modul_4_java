package com.example.demo_form.util;

import com.example.demo_form.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class Validate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(user.getFirstName().equals("")){
            errors.rejectValue("firstName",null,"cannot be left blank!");
        }else if(!user.getFirstName().matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$")){
            errors.rejectValue("firstName",null,"wrong format!");
        }else if(user.getFirstName().length()<2 || user.getFirstName().length()>50){
            errors.rejectValue("firstName",null,"Minimum characters is 5, maximum 50!");
        }
        if (user.getLastName().equals("")){
            errors.rejectValue("lastName",null,"cannot be left blank!");
        } else if (!user.getLastName().matches("^[A-Z][a-z]+$")) {
            errors.rejectValue("lastName",null,"wrong format!");
        }else if (user.getLastName().length()<2 || user.getLastName().length()>50) {
            errors.rejectValue("lastName",null,"Minimum characters is 5, maximum 50!");
        }
        if(user.getAge()==null){
            errors.rejectValue("age",null,"cannot be left blank!");
        }else if(user.getAge()<18){
            errors.rejectValue("age",null,"Minimum number is 18!");
        }
        if (user.getPhone().equals("")){
            errors.rejectValue("phone",null,"cannot be left blank!");
        } else if (!user.getPhone().matches("^[0-9]{9,11}$")) {
            errors.rejectValue("phone",null,"Phone number must be from 9 to 11 digits!");
        }
        if (user.getEmail().equals("")){
            errors.rejectValue("email",null,"cannot be left blank!");
        } else if (!user.getEmail().matches("^\\w+@([a-z]+.com)(.vn)?$")) {
            errors.rejectValue("email",null,"email is not in correct format!");
        }
    }
}
