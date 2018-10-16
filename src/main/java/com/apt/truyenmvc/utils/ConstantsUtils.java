package com.apt.truyenmvc.utils;

/**
 * @author Huy Thang
 *
 */
public class ConstantsUtils {
	
	//Trạng thái bị ẩn
	public static Integer STATUS_DENIED = 0;
	//Trạng thái kích hoạt
	public static Integer STATUS_ACTIVED = 1;

	//Trạng thái truyện bị ẩn
	public static Integer STORY_STATUS_HIDDEN = 0;
	//Trạng thái truyện đang ra
	public static Integer STORY_STATUS_GOING_ON = 1;
	//Trang thái truyện hoàn thành
	public static Integer STORY_STATUS_COMPLETED = 2;
	//Trạng thái truyện chờ duyệt
	public static Integer STORY_STATUS_WAIT_APPROVAL = 3;
	
	//Số Story Trong Home Page
	public static int PAGE_SIZE_HOME = 18;
	
	public static int PAGE_SIZE = 20;
	
	public static int PAGE_DEFAULT = 1;
	
	public static int RANK_SIZE = 10;

    public static int ROLE_ADMIN = 1;

    public static int ROLE_SMOD = 2;

	public static int ROLE_CONVERTER = 3;

    public static int ROLE_USER = 4;

	public static String AVATAR_DEFAULT = "https://res.cloudinary.com/thang1988/image/upload/v1539181299/logo.png";

    public static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static final int RANDOM_STRING_LENGTH = 6;
}
