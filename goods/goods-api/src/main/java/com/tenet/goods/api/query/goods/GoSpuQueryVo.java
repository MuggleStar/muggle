package com.tenet.goods.api.query.goods;

import com.tenet.common.entity.BaseEntity;
import com.tenet.goods.api.entity.goods.GoSpu;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Madison
 * @since 2021/2/28
 */
@Data
public class GoSpuQueryVo extends BaseEntity {

    private GoSpu goSpu;

    private LocalDateTime createTimeStart;

    private LocalDateTime createTimeEnd;

    private LocalDateTime updateTimeStart;

    private LocalDateTime updateTimeEnd;

    private List<Long> goSpuIdList;

}
