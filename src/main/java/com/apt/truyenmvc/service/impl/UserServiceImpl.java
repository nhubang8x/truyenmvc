package com.apt.truyenmvc.service.impl;

import com.apt.truyenmvc.entity.Role;
import com.apt.truyenmvc.entity.Urole;
import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.inf.TopConverter;
import com.apt.truyenmvc.repository.RoleRepository;
import com.apt.truyenmvc.repository.UroleRepository;
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

    @Autowired
    private UroleRepository uroleRepository;
    @Autowired
    private RoleRepository roleRepository;

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
    public boolean registerUser(User user) {
        User newUser = userRepository.save(user);
        if (newUser != null) {
            Urole uRole = new Urole();
            uRole.setUser(newUser);
            Role role = roleRepository.findById(ConstantsUtils.ROLE_USER).get();
            uRole.setRole(role);
            uroleRepository.save(uRole);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmailExits(String email) {
        return userRepository.existsUserByUEmail(email);
    }

    @Override
    public boolean checkUserNameExits(String userName) {
        return userRepository.existsUserByUName(userName);
    }

    /**
     * Lấy User
     *
     * @param userName
     * @param email
     * @return User
     */
    @Override
    public User getForgotUser(String userName, String email) {
        return userRepository.findByUNameAndUEmail(userName, email);
    }

    /**
     * Cập Nhật User
     *
     * @param user
     * @return User
     */
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
