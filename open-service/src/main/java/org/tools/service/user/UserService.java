package org.tools.service.user;

import org.tools.dao.user.entity.UserDO;

import java.util.List;

/**
 * 服务类
 *
 * @author barnak
 */
public interface UserService {

    /**
     *
     * @param user
     * @return
     */
    int updateById(UserDO user);

    int updateBatchById(List<UserDO> userDOList);

    UserDO getById(Long userId);
}
