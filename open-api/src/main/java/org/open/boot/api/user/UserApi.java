package org.open.boot.api.user;

import org.open.boot.api.user.dto.UserDTO;

/**
 * @author barnak
 */
public interface UserApi {

    UserDTO getByUserId(long userId);
}
