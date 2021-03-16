package org.open.boot.dao.user;

import com.baomidou.mybatisplus.extension.service.IService;
import org.open.boot.dao.user.entity.UserDO;

/**
 * 服务类
 *
 * @author barnak
 */
public interface UserManager extends IService<UserDO> {

<<<<<<< HEAD
    UserDO getByUserId(String userId);
=======
    UserDO selectByUserIds(Long userId);
>>>>>>> 6c93c63cc08ab6b62be4be8fdcd03bdda9328020
}
