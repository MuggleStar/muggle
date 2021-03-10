package com.tenet.goods.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tenet.common.utils.AssertUtil;
import com.tenet.goods.api.entity.goods.GoSpu;
import com.tenet.goods.api.entity.goods.GoSpuDetail;
import com.tenet.goods.mapper.goods.GoSpuDetailMapper;
import com.tenet.goods.service.goods.IGoSpuDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * spu扩展表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Service
public class GoSpuDetailServiceImpl extends ServiceImpl<GoSpuDetailMapper, GoSpuDetail> implements IGoSpuDetailService {

    @Override
    public List<GoSpuDetail> listByGoSpuIdList(List<Long> goSpuIdList) {

        AssertUtil.notEmpty(goSpuIdList,"参数不可为空！");

        LambdaQueryWrapper<GoSpuDetail> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(GoSpuDetail :: getGoSpuId,goSpuIdList);

        return this.list(lambdaQueryWrapper);
    }
}
