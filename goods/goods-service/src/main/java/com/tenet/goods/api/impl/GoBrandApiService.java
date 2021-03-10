package com.tenet.goods.api.impl;

import com.tenet.common.dto.OperateResult;
import com.tenet.goods.api.api.GoBrandApi;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.goods.service.brand.IGoBrandService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

/**
 * @author Madison
 * @since 2021/2/24
 */
@Service(version = "1.0.0", group = "tenet-goods")
public class GoBrandApiService implements GoBrandApi {

    @Resource
    private IGoBrandService goBrandService;



    @Override
    public OperateResult<GoBrand> getBrandById(Long id) {

        GoBrand goBrand4Search = new GoBrand();
        goBrand4Search.setId(id);
        GoBrand result = goBrandService.getById(goBrand4Search);
        if (result == null) {
            return OperateResult.fail("结果为空");
        }
        return OperateResult.success(result);
    }
}
