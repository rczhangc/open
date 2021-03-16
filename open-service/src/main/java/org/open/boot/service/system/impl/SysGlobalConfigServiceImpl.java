package org.open.boot.service.system.impl;

import org.open.boot.dao.system.SysGlobalConfigManager;
import org.open.boot.service.system.SysGlobalConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统全局配置服务实现类
 *
 * @author barnak
 */
@Service
class SysGlobalConfigServiceImpl implements SysGlobalConfigService {

    @Resource
    private SysGlobalConfigManager sysGlobalConfigManager;

}