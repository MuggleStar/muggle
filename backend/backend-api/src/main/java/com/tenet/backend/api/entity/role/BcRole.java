package com.tenet.backend.api.entity.role;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bc_role")
public class BcRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 是否启用
     */
    private Boolean isEnable;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人id
     */
    private Long updateId;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;


}
