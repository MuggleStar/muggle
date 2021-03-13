package com.tenet.goods.api.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tenet.common.dto.OperateResult;
import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.api.GoBrandApi;
import com.tenet.goods.api.dto.goods.GoBrandDto;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.goods.api.query.brand.GoBrandQueryVo;
import com.tenet.goods.service.brand.IGoBrandService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Madison
 * @since 2021/2/24
 */
@DubboService
public class GoBrandApiService implements GoBrandApi {

    @Resource
    private IGoBrandService brandService;



    @Override
    public OperateResult<GoBrand> getBrandById(Long id) {

        GoBrand goBrand4Search = new GoBrand();
        goBrand4Search.setId(id);
        GoBrand result = brandService.getById(goBrand4Search);
        if (result == null) {
            return OperateResult.fail("结果为空");
        }
        return OperateResult.success(result);
    }

    @Override
    public OperateResult<PageDto<GoBrandDto>> pageGoSpuDtoByCondition(PageDto<GoBrandQueryVo> param) {

        // 分页查询spu主表
        Page<GoBrand> goSpuByPage = brandService.getGoSpuByPage(param);

        // 处理分页数据
        PageDto<GoBrandDto> pagDto = new PageDto<>(param);
        pagDto.setTotal(goSpuByPage.getTotal());
        pagDto.setTotalPage(goSpuByPage.getPages());

        List<GoBrand> goSpuList = goSpuByPage.getRecords();
        if (CollectionUtils.isEmpty(goSpuList)) {
            return OperateResult.noResult(pagDto);
        }

        // 封装数据
        List<GoBrandDto> goBrandDtoList = new ArrayList<>();
        for (GoBrand goBrand : goSpuList) {
            GoBrandDto goBrandDto = new GoBrandDto();
            goBrandDto.setGoBrand(goBrand);
            goBrandDtoList.add(goBrandDto);
        }
        pagDto.setResult(goBrandDtoList);

        return OperateResult.success(pagDto);
    }
}
