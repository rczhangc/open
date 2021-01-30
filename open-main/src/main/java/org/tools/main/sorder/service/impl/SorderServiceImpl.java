package org.tools.main.sorder.service.impl;

import org.tools.main.sorder.entity.Sorder;
import org.tools.main.sorder.mapper.SorderMapper;
import org.tools.main.sorder.service.ISorderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 订单信息表服务实现类
 *
 * @author barnak
 */
@Service
public class SorderServiceImpl extends ServiceImpl<SorderMapper, Sorder> implements ISorderService {

}
