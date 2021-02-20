package com.tenet.goods.service.goods.impl;

import com.tenet.goods.api.entity.goods.GoSku;
import com.tenet.goods.mapper.goods.GoSkuMapper;
import com.tenet.goods.service.goods.IGoSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Service
public class GoSkuServiceImpl extends ServiceImpl<GoSkuMapper, GoSku> implements IGoSkuService {

}
