package com.tenet.goods.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tenet.common.dto.PageDto;
import com.tenet.common.utils.AssertUtil;
import com.tenet.goods.api.entity.goods.GoSpu;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;
import com.tenet.goods.mapper.goods.GoSpuMapper;
import com.tenet.goods.service.goods.IGoSpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * spu表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Service
public class GoSpuServiceImpl extends ServiceImpl<GoSpuMapper, GoSpu> implements IGoSpuService {


    @Override
    public Page<GoSpu> getGoSpuByPage(PageDto<GoSpuQueryVo> param) {

        AssertUtil.notNull(param,"参数不可为空");
        AssertUtil.notNull(param.getParam(),"参数Param不可为空");
        AssertUtil.notNull(param.getPageNo(),"参数PageNo不可为空");
        AssertUtil.notNull(param.getPageSize(),"参数PageSize不可为空");

        GoSpuQueryVo spuQueryVo = param.getParam();

        Page<GoSpu> page = new Page<>(param.getPageNo(),param.getPageSize());
        LambdaQueryWrapper<GoSpu> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.setEntity(spuQueryVo.getGoSpu());
        if (spuQueryVo.getCreateTimeStart() != null) {
            lambdaQueryWrapper.gt(GoSpu :: getCreateTime,spuQueryVo.getCreateTimeStart());
        }
        if (spuQueryVo.getCreateTimeEnd() != null) {
            lambdaQueryWrapper.le(GoSpu :: getCreateTime,spuQueryVo.getCreateTimeEnd());
        }
        if (spuQueryVo.getUpdateTimeStart() != null) {
            lambdaQueryWrapper.gt(GoSpu :: getUpdateTime,spuQueryVo.getUpdateTimeStart());
        }
        if (spuQueryVo.getUpdateTimeEnd() != null) {
            lambdaQueryWrapper.le(GoSpu :: getUpdateTime,spuQueryVo.getUpdateTimeEnd());
        }
        if (!CollectionUtils.isEmpty(spuQueryVo.getGoSpuIdList())) {
            lambdaQueryWrapper.in(GoSpu :: getId,spuQueryVo.getGoSpuIdList());
        }
        lambdaQueryWrapper.orderByAsc(GoSpu :: getId);

        Page<GoSpu> pageResult = this.page(page, lambdaQueryWrapper);
        return pageResult;
    }
}
