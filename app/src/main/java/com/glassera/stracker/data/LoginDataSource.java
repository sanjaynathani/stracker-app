package com.glassera.stracker.data;

import com.glassera.stracker.data.model.LoggedInUser;
import com.glassera.stracker.service.ServiceLocator;
import com.glassera.stracker.service.dto.UserDto;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<UserDto> login(String username, String password) {

        try {
            UserDto userDto = ServiceLocator.getStrackerService().authenticate(username, password);
            //LoggedInUser user = new LoggedInUser(userDto.getUsername(), userDto.getToken());

            return new Result.Success<>(userDto);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        try {
            ServiceLocator.getStrackerService().logOut();
        } catch (Exception e) {
        }
    }
}