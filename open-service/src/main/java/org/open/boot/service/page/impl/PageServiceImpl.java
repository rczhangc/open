package org.open.boot.service.page.impl;

import org.open.boot.dao.page.PageManager;
import org.open.boot.service.page.PageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 页面信息表（页面定义）服务实现类
 *
 * @author barnak
 */
@Service
class PageServiceImpl implements PageService {

    @Resource
    private PageManager pageManager;

}