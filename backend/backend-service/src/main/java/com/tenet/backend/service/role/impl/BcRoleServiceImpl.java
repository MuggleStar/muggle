package com.tenet.backend.service.role.impl;

import com.tenet.backend.api.entity.role.BcRole;
import com.tenet.backend.mapper.role.BcRoleMapper;
import com.tenet.backend.service.role.IBcRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-05
 */
@Service
public class BcRoleServiceImpl extends ServiceImpl<BcRoleMapper, BcRole> implements IBcRoleService {

}
