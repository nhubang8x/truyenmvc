package com.apt.truyenmvc.validator.impl;

import com.apt.truyenmvc.service.UserService;
import com.apt.truyenmvc.validator.UniqueUserName;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Huy Thang on 13/10/2018
 * @project truyenmvc
 */
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    private final UserService userServicel;

    @Autowired
    public UniqueUserNameValidator(UserService userServicel) {
        this.userServicel = userServicel;
    }

    @Override
    public void initialize(UniqueUserName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {
        return userName != null && !userServicel.checkUserNameExits(userName);
    }
}
