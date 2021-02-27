package com.tenet.goods.api.api;

import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.dto.goods.GoSpuDto;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;

/**
 * @author Madison
 * @since 2021/2/28
 */
public interface GoSkuApi {

    PageDto<GoSpuDto> getGoSpuDtoByPage(PageDto<GoSpuQueryVo> param);
}
