package com.tenet.goods.api.api;

import com.tenet.common.dto.OperateResult;
import com.tenet.goods.api.entity.brand.GoBrand;

/**
 * @author Madison
 * @since 2021/2/24
 */
public interface GoBrandApi {

    OperateResult<GoBrand> getBrandById(Long id);
}
