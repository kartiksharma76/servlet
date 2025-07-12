package com.hm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hm.dto.Registration;

public interface RegistrationService {
    boolean registerUser(HttpServletRequest request, HttpServletResponse response);
}