package com.tenet.goods.service.brand.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tenet.common.dto.PageDto;
import com.tenet.common.utils.AssertUtil;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.goods.api.query.brand.GoBrandQueryVo;
import com.tenet.goods.mapper.brand.GoBrandMapper;
import com.tenet.goods.service.brand.IGoBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
@Service
public class GoBrandServiceImpl extends ServiceImpl<GoBrandMapper, GoBrand> implements IGoBrandService {

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    @Override
    public Page<GoBrand> getGoSpuByPage(PageDto<GoBrandQueryVo> param) {

        AssertUtil.notNull(param, "参数不可为空");
        AssertUtil.notNull(param.getParam(), "参数Param不可为空");
        AssertUtil.notNull(param.getPageNo(), "参数PageNo不可为空");
        AssertUtil.notNull(param.getPageSize(), "参数PageSize不可为空");


        GoBrandQueryVo goBrandQueryVo = param.getParam();
        Page<GoBrand> page = new Page<>(param.getPageNo(), param.getPageSize());
        LambdaQueryWrapper<GoBrand> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.setEntity(goBrandQueryVo.getGoBrand());
        lambdaQueryWrapper.orderByAsc(GoBrand::getId);

        return this.page(page, lambdaQueryWrapper);
    }
}
