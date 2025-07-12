package com.hm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hm.dto.Registration;
import com.hm.repository.RegistrationRepository;
import com.hm.repository.RegistrationRepositoryImpl;

public class RegistrationServiceImpl implements RegistrationService {

	@Override
	public boolean registerUser(HttpServletRequest request, HttpServletResponse response) {
		 Registration registration = new Registration();
	        registration.setEnrollmentNumber(request.getParameter("enrollment"));
	        registration.setName(request.getParameter("name"));
	        registration.setEmail(request.getParameter("email"));
	        registration.setPassword(request.getParameter("password"));
	        registration.setBranch(request.getParameter("branch"));
	        registration.setYear(request.getParameter("year"));
	        registration.setDob(request.getParameter("dob"));
	        registration.setBloodGroup(request.getParameter("blood_group"));
	        registration.setMobile(request.getParameter("mobile"));
	        registration.setFatherName(request.getParameter("father_name"));
	        registration.setFatherMobile(request.getParameter("father_mobile"));
	        registration.setRoomId(request.getParameter("room_id"));
	        RegistrationRepository repository=new RegistrationRepositoryImpl();
	       return repository.saveDetails(registration);
	}
    
}