package com.tenet.goods.api.api;

import com.tenet.common.dto.OperateResult;
import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.dto.goods.GoBrandDto;
import com.tenet.goods.api.dto.goods.GoSpuDto;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.tenet.goods.api.query.brand.GoBrandQueryVo;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;

/**
 * @author Madison
 * @since 2021/2/24
 */
public interface GoBrandApi {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    OperateResult<GoBrand> getBrandById(Long id);

    /**
     * 分页查询，支持多条件
     *
     * @param param
     * @return
     */
    OperateResult<PageDto<GoBrandDto>> pageGoSpuDtoByCondition(PageDto<GoBrandQueryVo> param);

}
