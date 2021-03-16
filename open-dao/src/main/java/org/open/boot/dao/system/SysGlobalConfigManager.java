package org.open.boot.dao.system;

import com.baomidou.mybatisplus.extension.service.IService;
import org.open.boot.dao.system.entity.SysGlobalConfigDO;

/**
 * 系统全局配置服务类
 *
 * @author barnak
 */
public interface SysGlobalConfigManager extends IService<SysGlobalConfigDO> {

    <T> void saveBeans(T t);

    <T> T getBeans(String code, Class<T> clazz);
}
