package com.tenet.goods.api.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tenet.common.dto.OperateResult;
import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.api.GoSpuApi;
import com.tenet.goods.api.dto.goods.GoSpuDto;
import com.tenet.goods.api.entity.goods.GoSku;
import com.tenet.goods.api.entity.goods.GoSpu;
import com.tenet.goods.api.entity.goods.GoSpuDetail;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;
import com.tenet.goods.service.goods.IGoSkuService;
import com.tenet.goods.service.goods.IGoSpuDetailService;
import com.tenet.goods.service.goods.IGoSpuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Madison
 * @since 2021/2/28
 */
@Service
public class GoSkuApiService implements GoSpuApi {


    @Resource
    private IGoSpuService spuService;
    @Resource
    private IGoSpuDetailService spuDetailService;
    @Resource
    private IGoSkuService goSkuService;

    /**
     * 分页条件查询
     *
     * @param param
     * @return
     */
    @Override
    public OperateResult<PageDto<GoSpuDto>> pageGoSpuDtoByCondition(PageDto<GoSpuQueryVo> param) {

        // 分页查询spu主表
        Page<GoSpu> goSpuByPage = spuService.getGoSpuByPage(param);

        PageDto<GoSpuDto> pagDto = new PageDto<>(param);
        pagDto.setTotal(goSpuByPage.getTotal());
        pagDto.setTotalPage(goSpuByPage.getPages());

        List<GoSpu> goSpuList = goSpuByPage.getRecords();

        if (CollectionUtils.isEmpty(goSpuList)) {
            return OperateResult.noResult(pagDto);
        }

        // 查询spu详情及sku
        List<Long> goSpuIdList = goSpuList.stream().map(GoSpu::getId).collect(Collectors.toList());
        List<GoSpuDetail> spuDetailList = spuDetailService.listByGoSpuIdList(goSpuIdList);
        Map<Long, GoSpuDetail> spuDetailMap = new HashMap<>();
        for (GoSpuDetail goSpuDetail : spuDetailList) {
            spuDetailMap.put(goSpuDetail.getGoSpuId(),goSpuDetail);
        }
        List<GoSku> skuList = goSkuService.listByGoSpuIdList(goSpuIdList);
        Map<Long, List<GoSku>> skuMap = skuList.stream().collect(Collectors.groupingBy(GoSku::getGoSpuId));

        // 封装数据
        List<GoSpuDto> goSpuDtoList = new ArrayList<>();
        for (GoSpu goSpu : goSpuList) {
            GoSpuDto goSpuDto = new GoSpuDto();
            goSpuDto.setGoSpu(goSpu);
            goSpuDto.setGoSpuDetail(spuDetailMap.get(goSpu.getId()));
            goSpuDto.setGoSkuList(skuMap.get(goSpu.getId()));
            goSpuDtoList.add(goSpuDto);
        }

        pagDto.setResult(goSpuDtoList);

        return OperateResult.success(pagDto);
    }
}
