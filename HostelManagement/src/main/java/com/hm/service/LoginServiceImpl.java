package com.hm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hm.dto.Login;
import com.hm.repository.LoginRepositoryImpl;

public class LoginServiceImpl implements LoginService {
    @Override
    public boolean validateUser(HttpServletRequest request, HttpServletResponse response) {
        String enrollment = request.getParameter("enrollment");
        String password = request.getParameter("password");

        Login loginDetails = new LoginRepositoryImpl().fetchLoginDetails(enrollment, password);
        return loginDetails != null;
    }
}
