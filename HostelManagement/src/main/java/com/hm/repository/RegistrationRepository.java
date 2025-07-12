
package com.hm.repository;

import com.hm.dto.Registration;

public interface RegistrationRepository {
    boolean saveDetails(Registration registration);
}
