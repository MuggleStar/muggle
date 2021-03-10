package com.tenet.goods.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tenet.common.utils.AssertUtil;
import com.tenet.goods.api.entity.goods.GoSku;
import com.tenet.goods.api.entity.goods.GoSpuDetail;
import com.tenet.goods.mapper.goods.GoSkuMapper;
import com.tenet.goods.service.goods.IGoSkuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<GoSku> listByGoSpuIdList(List<Long> goSpuIdList) {
        AssertUtil.notEmpty(goSpuIdList,"参数不可为空！");

        LambdaQueryWrapper<GoSku> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(GoSku :: getGoSpuId,goSpuIdList);

        return this.list(lambdaQueryWrapper);
    }
}
