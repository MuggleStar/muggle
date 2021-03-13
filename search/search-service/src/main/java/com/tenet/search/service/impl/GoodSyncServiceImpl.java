package com.tenet.search.service.impl;

import com.tenet.common.dto.OperateResult;
import com.tenet.common.dto.PageDto;
import com.tenet.common.utils.JsonUtil;
import com.tenet.goods.api.api.GoBrandApi;
import com.tenet.goods.api.api.GoSpuApi;
import com.tenet.goods.api.dto.goods.GoBrandDto;
import com.tenet.goods.api.dto.goods.GoSpuDto;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.goods.api.entity.goods.GoSku;
import com.tenet.goods.api.entity.goods.GoSpu;
import com.tenet.goods.api.entity.goods.GoSpuDetail;
import com.tenet.goods.api.query.brand.GoBrandQueryVo;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;
import com.tenet.search.entity.GoodsSearch;
import com.tenet.search.repository.GoodsSearchRepository;
import com.tenet.search.service.GoodSyncService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品同步
 *
 * @author Madison
 * @since 2021/3/13
 */
@Service
public class GoodSyncServiceImpl implements GoodSyncService {


    @Resource
    private GoodsSearchRepository goodsSearchRepository;

    @DubboReference
    private GoSpuApi goSpuApi;

    @DubboReference
    private GoBrandApi goBrandApi;

    /**
     * 初始化
     */
    public void initGoods() {

        // 查询所有品牌（已知数量小于1000）
        PageDto<GoBrandQueryVo> brandPage = new PageDto<>();
        GoBrandQueryVo brandQueryVo = new GoBrandQueryVo();
        brandPage.setPageNo(1L);
        brandPage.setPageSize(1000L);
        brandPage.setParam(brandQueryVo);
        OperateResult<PageDto<GoBrandDto>> brandOperateResult = goBrandApi.pageGoSpuDtoByCondition(brandPage);
        List<GoBrandDto> brandDtoList = brandOperateResult.getData().getResult();

        // 封装成Map数据
        Map<Long, GoBrand> brandDtoMap = new HashMap<>();
        for (GoBrandDto goBrandDto : brandDtoList) {
            brandDtoMap.put(goBrandDto.getGoBrand().getId(),goBrandDto.getGoBrand());
        }


        // 按分页处理
        PageDto<GoSpuQueryVo> spuPage = new PageDto<>();
        GoSpuQueryVo spuQueryVo = new GoSpuQueryVo();
        spuPage.setPageNo(1L);
        spuPage.setPageSize(100L);
        spuPage.setParam(spuQueryVo);
        OperateResult<PageDto<GoSpuDto>> spuOperateResult = goSpuApi.pageGoSpuDtoByCondition(spuPage);
        Long totalPage = spuOperateResult.getData().getTotalPage();

        for (Long pageNo = 1L; pageNo <= totalPage; pageNo++) {
            spuPage.setPageNo(pageNo);
            spuOperateResult = goSpuApi.pageGoSpuDtoByCondition(spuPage);
            List<GoSpuDto> goSpuDtoList = spuOperateResult.getData().getResult();
            this.syncByList(goSpuDtoList,brandDtoMap);
        }

    }

    /**
     * 批量同步
     *
     * @param goSpuDtoList
     * @param brandDtoMap
     */
    public void syncByList(List<GoSpuDto> goSpuDtoList, Map<Long, GoBrand> brandDtoMap){
        List<GoodsSearch> goodsSearchList = new ArrayList<>();
        for (GoSpuDto goSpuDto : goSpuDtoList) {

            GoSpu goSpu = goSpuDto.getGoSpu();
            GoSpuDetail goSpuDetail = goSpuDto.getGoSpuDetail();
            List<GoSku> goSkuList = goSpuDto.getGoSkuList();

            // 异常数据跳过
            if (goSpu == null || goSpuDetail == null || CollectionUtils.isEmpty(goSkuList)) {
                continue;
            }
            GoBrand goBrand = brandDtoMap.get(goSpu.getGoBrandId());
            if (goBrand == null) {
                continue;
            }

            // 封装数据
            GoodsSearch goodsSearch = new GoodsSearch();
            goodsSearch.setId(goSpu.getId());
            goodsSearch.setAll(goSpu.getSpuTitle() +" "+ goBrand.getBrandName());
            goodsSearch.setSpuTitle(goSpu.getSpuTitle());
            goodsSearch.setGoBrandId(goSpu.getGoBrandId());
            goodsSearch.setGoCategoryIdOne(goSpu.getGoCategoryIdOne());
            goodsSearch.setGoCategoryIdTwo(goSpu.getGoCategoryIdTwo());
            goodsSearch.setGoCategoryIdThree(goSpu.getGoCategoryIdThree());
            goodsSearch.setCreateTime(goSpu.getCreateTime());

            List<Long> priceList = goSkuList.stream().map(GoSku::getSkuPrice).collect(Collectors.toList());
            Map<String, String> genericSpec = JsonUtil.json2Map(goSpuDetail.getGenericSpec(), String.class);
            Map<String, List<String>> specialSpec = JsonUtil.json2ListMap(goSpuDetail.getSpecialSpec(), String.class);

            goodsSearch.setPriceList(priceList);
            goodsSearch.setGenericSpec(genericSpec);
            goodsSearch.setSpecialSpec(specialSpec);

            goodsSearchList.add(goodsSearch);
        }

        // 批量保存
        goodsSearchRepository.saveAll(goodsSearchList);
    }

}
