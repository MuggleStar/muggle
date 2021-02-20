package com.tenet.goods.service.category.impl;

import com.tenet.goods.api.entity.category.GoCategory;
import com.tenet.goods.mapper.category.GoCategoryMapper;
import com.tenet.goods.service.category.IGoCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Service
public class GoCategoryServiceImpl extends ServiceImpl<GoCategoryMapper, GoCategory> implements IGoCategoryService {

}
