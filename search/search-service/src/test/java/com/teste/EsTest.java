package com.teste;

import com.tenet.common.dto.OperateResult;
import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.api.GoBrandApi;
import com.tenet.goods.api.api.GoSpuApi;
import com.tenet.goods.api.dto.goods.GoSpuDto;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.goods.api.query.brand.GoBrandQueryVo;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;
import com.tenet.search.SearchApplication;
import com.tenet.search.entity.GoodsSearch;
import com.tenet.search.repository.GoodsSearchRepository;
import com.tenet.search.service.GoodSyncService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品全量初始化入库
 *
 * @author Madison
 * @since 2021/3/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class EsTest {

    @Resource
    private GoodsSearchRepository goodsSearchRepository;

    @Resource
    private GoodSyncService goodSyncService;

    @Test
    public void testPut() {
        GoodsSearch goodsSearch = new GoodsSearch();
        goodsSearch.setId(2L);
        goodsSearch.setAll("测试 手机");

        Map<String,String> map = new HashMap<>();
        map.put("1","1value");
        goodsSearch.setGenericSpec(map);
        GoodsSearch save = goodsSearchRepository.save(goodsSearch);

    }

    @Test
    public void testInitGoods() {
        goodSyncService.initGoods();
    }

}
