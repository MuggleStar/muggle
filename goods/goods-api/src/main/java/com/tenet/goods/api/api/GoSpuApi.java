package com.tenet.goods.api.api;

import com.tenet.common.dto.OperateResult;
import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.dto.goods.GoSpuDto;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;

/**
 * @author Madison
 * @since 2021/2/28
 */
public interface GoSpuApi {

    /**
     * 分页查询，支持多条件
     *
     * @param param
     * @return
     */
    OperateResult<PageDto<GoSpuDto>> pageGoSpuDtoByCondition(PageDto<GoSpuQueryVo> param);
}
