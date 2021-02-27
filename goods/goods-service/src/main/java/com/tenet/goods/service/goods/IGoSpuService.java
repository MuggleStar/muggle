package com.tenet.goods.service.goods;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tenet.common.dto.PageDto;
import com.tenet.goods.api.entity.goods.GoSpu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tenet.goods.api.query.goods.GoSpuQueryVo;

/**
 * <p>
 * spu表 服务类
 * </p>
 *
 * @author Madison
 * @since 2021-02-20
 */
public interface IGoSpuService extends IService<GoSpu> {

    /**
     * 分页查询
     *
     * @param param
     * @return
     */
    Page<GoSpu> getGoSpuByPage(PageDto<GoSpuQueryVo> param);

}
