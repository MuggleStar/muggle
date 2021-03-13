package com.tenet.goods.api.dto.goods;

import com.tenet.common.entity.BaseEntity;
import com.tenet.goods.api.entity.brand.GoBrand;
import lombok.Data;

/**
 * @author Madison
 * @since 2021/3/13
 */
@Data
public class GoBrandDto extends BaseEntity {

    private GoBrand goBrand;

}
