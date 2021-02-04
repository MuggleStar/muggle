package com.tenet.backend.api.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表实体类
 * </p>
 *
 * @author Madison
 * @since 2021-02-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bc_user")
public class BcUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 电话号码
     */
    private String userMobile;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 密码
     */
    private String userPwd;

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
