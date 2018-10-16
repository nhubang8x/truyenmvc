package com.apt.truyenmvc.service;

import java.util.List;

import com.apt.truyenmvc.exception.EmailTakenException;
import com.apt.truyenmvc.exception.UsernameTakenException;
import org.springframework.data.domain.Page;

import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.inf.TopConverter;

/**
 *
 * @author Huy Thang
 */
public interface UserService {

	public User getUserByUserName(String username);

	public Page<User> getPageUser();

	/**
	 * Lấy List Top Converter
	 *
	 * @param page
	 * @param size
	 *
	 * @return List<TopConverter>
	 */
	public List<TopConverter> getTopConverter(int page, int size);

    /**
     * Cập Nhật User
     *
     * @param user
     *
     * @return boolean
     */
	public boolean registerUser(User user);

    /**
     * Kiểm tra Email đã tồn tại chưa
     *
     * @param email
     *
     * @return boolean
     */
	public boolean checkEmailExits(String email);

    /**
     * Kiểm tra UserName đã tồn tại chưa
     *
     * @param userName
     *
     * @return boolean
     */
    public boolean checkUserNameExits(String userName);

    /**
     * Lấy User
     *
     * @param userName
     * @param email
     *
     * @return User
     */
    public User getForgotUser(String userName, String email);

    /**
     * Cập Nhật User
     *
     * @param user
     *
     * @return User
     */
    public User updateUser(User user);
}
