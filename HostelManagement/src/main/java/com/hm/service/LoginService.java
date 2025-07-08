package com.hm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    boolean validateUser(HttpServletRequest request, HttpServletResponse response);
}
