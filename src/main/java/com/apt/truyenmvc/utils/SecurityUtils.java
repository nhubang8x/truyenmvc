package com.apt.truyenmvc.utils;

/**
 * @author Huy Thang on 09/10/2018
 * @project truyenmvc
 */
public class SecurityUtils {

    public static final String[] PERMIT_ALL_LINK ={ "/",
            "/dang-nhap",
            "/logout",
            "/api/load",
            "/api/load1",
            "/api/load2",
            "/api/load3" };

    public static final String[] ROLE_USER_LINK = { "/userInfo" };

    public static final String[] ROLE_ADMIN_LINK ={ "/admin" };

}
