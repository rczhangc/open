package org.open.boot.dao.page.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.open.boot.dao.page.PageManager;
import org.open.boot.dao.page.entity.PageDO;
import org.springframework.stereotype.Repository;

/**
 * 页面信息表（页面定义）服务实现类
 *
 * @author barnak
 */
@Repository
class PageManagerImpl extends ServiceImpl<PageMapper, PageDO> implements PageManager {

}
