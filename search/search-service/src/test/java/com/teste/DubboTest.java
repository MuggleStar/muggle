package com.teste;

import com.tenet.common.dto.OperateResult;
import com.tenet.common.enums.ResultTypeEnum;
import com.tenet.goods.api.api.GoBrandApi;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.search.SearchApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Madison
 * @since 2021/2/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class DubboTest {


    @Resource
    private GoBrandApi goBrandApi;


    @Test
    public void test2() {
        OperateResult<GoBrand> operateResult = goBrandApi.getBrandById(1528L);
        if (ResultTypeEnum.SUCCESS.getCode().equals(operateResult.getCode())) {
            System.out.println(operateResult.getData());
        }
    }

}
