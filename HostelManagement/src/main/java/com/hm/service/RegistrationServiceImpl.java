package com.hm.service;

import com.hm.dto.Registration;
import com.hm.repository.RegistrationRepositoryImpl;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public boolean registerUser(Registration registration) {
        return new RegistrationRepositoryImpl().saveStudentDetails(registration);
    }
}
