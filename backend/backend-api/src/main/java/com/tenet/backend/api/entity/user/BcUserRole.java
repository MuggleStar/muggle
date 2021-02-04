package com.tenet.backend.api.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户-角色关联表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bc_user_role")
public class BcUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色id
     */
    private Long bcRoleId;

    /**
     * 用户id
     */
    private Long bcUserId;


}
