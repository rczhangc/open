package org.open.boot.dao.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.open.boot.dao.system.SysGlobalConfigManager;
import org.open.boot.dao.system.entity.SysGlobalConfigDO;
import org.open.boot.dao.system.enums.SysGlobalConfigCodeEnum;
import org.springframework.stereotype.Repository;

/**
 * 系统全局配置服务实现类
 *
 * @author barnak
 */
@Repository
class SysGlobalConfigManagerImpl extends ServiceImpl<SysGlobalConfigMapper, SysGlobalConfigDO> implements SysGlobalConfigManager {

    @Override
    public <T> void saveBeans(T t) {

        String s = SysGlobalConfigCodeEnum.USER_INFO.toString();

    }

    @Override
    public <T> T getBeans(String code, Class<T> clazz) {
        return null;
    }
}
