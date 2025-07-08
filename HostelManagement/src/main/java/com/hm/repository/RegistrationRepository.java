package com.hm.repository;

import com.hm.dto.Registration;

public interface RegistrationRepository {
    boolean saveStudentDetails(Registration registration);
}
