package org.open.boot.service.user;

import org.open.boot.dao.user.entity.UserDO;

import java.util.List;

/**
 * 服务类
 *
 * @author barnak
 */
public interface UserService {

    void updateBatchById(List<UserDO> asList);

    UserDO getById(long l);

    int updateById(UserDO user);
}
