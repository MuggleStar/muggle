package com.tenet.goods.service.brand;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.entity.brand.GoBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tenet.goods.api.query.brand.GoBrandQueryVo;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
public interface IGoBrandService extends IService<GoBrand> {

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    Page<GoBrand> getGoSpuByPage(PageDto<GoBrandQueryVo> param);
}
