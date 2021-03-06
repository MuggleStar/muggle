package com.tenet.goods.service.goods;

import com.tenet.goods.api.entity.goods.GoSpuDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * spu扩展表 服务类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
public interface IGoSpuDetailService extends IService<GoSpuDetail> {

    List<GoSpuDetail> listByGoSpuIdList(List<Long> goSpuIdList);
}
