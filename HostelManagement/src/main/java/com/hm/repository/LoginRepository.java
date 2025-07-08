package com.hm.repository;

import com.hm.dto.Login;

public interface LoginRepository {
    Login fetchLoginDetails(String enrollmentNumber, String password);
}
