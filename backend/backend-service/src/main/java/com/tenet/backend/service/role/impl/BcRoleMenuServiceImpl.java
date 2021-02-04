package com.tenet.backend.service.role.impl;

import com.tenet.backend.api.entity.role.BcRoleMenu;
import com.tenet.backend.mapper.role.BcRoleMenuMapper;
import com.tenet.backend.service.role.IBcRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-菜单关联表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-05
 */
@Service
public class BcRoleMenuServiceImpl extends ServiceImpl<BcRoleMenuMapper, BcRoleMenu> implements IBcRoleMenuService {

}
