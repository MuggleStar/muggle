package com.tenet.goods.api.dto.goods;

import com.tenet.common.entity.BaseEntity;
import com.tenet.goods.api.entity.goods.GoSku;
import com.tenet.goods.api.entity.goods.GoSpu;
import com.tenet.goods.api.entity.goods.GoSpuDetail;
import lombok.Data;

import java.util.List;

/**
 * @author Madison
 * @since 2021/2/28
 */
@Data
public class GoSpuDto extends BaseEntity {

    private GoSpu goSpu;

    private GoSpuDetail goSpuDetail;

    private List<GoSku> goSkuList;


}
