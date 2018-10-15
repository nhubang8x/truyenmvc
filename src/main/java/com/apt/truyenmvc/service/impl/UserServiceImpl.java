package com.apt.truyenmvc.service.impl;

import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.inf.TopConverter;
import com.apt.truyenmvc.exception.EmailTakenException;
import com.apt.truyenmvc.exception.UsernameTakenException;
import com.apt.truyenmvc.repository.UserRepository;
import com.apt.truyenmvc.service.UserService;
import com.apt.truyenmvc.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Huy Thang
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findByUName(username);
    }

    @Override
    public Page<User> getPageUser() {
        return userRepository.findAll(new PageRequest(0, 1));
    }

    @Override
    public List<TopConverter> getTopConverter(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<TopConverter> result = userRepository.getTopConverter(ConstantsUtils.STATUS_ACTIVED, ConstantsUtils.STATUS_ACTIVED, pageable);
        return result.getContent();
    }

    @Override
    public User updateUser(User user){
            return userRepository.save(user);
    }

    @Override
    public boolean checkEmailExits(String email) {
        return userRepository.existsUserByUEmail(email);
    }

    @Override
    public boolean checkUserNameExits(String userName) {
        return userRepository.existsUserByUName(userName);
    }
}
