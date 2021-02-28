package com.tenet.goods.api.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tenet.common.dto.PageDto;
import com.tenet.common.utils.AssertUtil;
import com.tenet.goods.api.api.GoSkuApi;
import com.tenet.goods.api.dto.goods.GoSpuDto;
import com.tenet.goods.api.entity.goods.GoSpu;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;
import com.tenet.goods.service.goods.IGoSpuService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Madison
 * @since 2021/2/28
 */
@Service(version = "1.0.0", group = "goods")
public class GoSkuApiService implements GoSkuApi {


    @Resource
    private IGoSpuService spuService;

    @Override
    public PageDto<List<GoSpuDto>> getGoSpuDtoByPage(PageDto<GoSpuQueryVo> param) {

        Page<GoSpu> goSpuByPage = spuService.getGoSpuByPage(param);

        PageDto<List<GoSpuDto>> pagDto = new PageDto<>(param);
        pagDto.setTotal(goSpuByPage.getTotal());
        pagDto.setTotalPage(goSpuByPage.getPages());

        List<GoSpu> goSpuList = goSpuByPage.getRecords();

        if (CollectionUtils.isEmpty(goSpuList)) {
            return pagDto;
        }

        List<GoSpuDto> goSpuDtoList = new ArrayList<>();



        return pagDto;
    }
}
