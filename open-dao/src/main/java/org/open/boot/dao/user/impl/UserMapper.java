package org.open.boot.dao.user.impl;

import org.apache.ibatis.annotations.Param;
import org.open.boot.dao.user.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * mapper类
 *
 * @author barnak
 */
interface UserMapper extends BaseMapper<UserDO> {


    UserDO getByUserId(@Param("userId") String userId);
    UserDO selectByUserIds(@Param("userId") Long userId);
}
