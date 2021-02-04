package com.tenet.backend.service.user.impl;

import com.tenet.backend.api.entity.user.BcUserRole;
import com.tenet.backend.mapper.user.BcUserRoleMapper;
import com.tenet.backend.service.user.IBcUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色关联表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-05
 */
@Service
public class BcUserRoleServiceImpl extends ServiceImpl<BcUserRoleMapper, BcUserRole> implements IBcUserRoleService {

}
