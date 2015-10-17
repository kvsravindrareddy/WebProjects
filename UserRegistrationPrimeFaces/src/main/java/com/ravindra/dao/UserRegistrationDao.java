package com.ravindra.dao;

import com.ravindra.controller.UserRegistrationController;

public interface UserRegistrationDao {
	void registerIntoDb(UserRegistrationController register);
	Boolean existingUserCheck(String userName);
}
