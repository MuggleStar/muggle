package com.tenet.backend.service.menu.impl;

import com.tenet.backend.api.entity.menu.BcMenu;
import com.tenet.backend.mapper.menu.BcMenuMapper;
import com.tenet.backend.service.menu.IBcMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-05
 */
@Service
public class BcMenuServiceImpl extends ServiceImpl<BcMenuMapper, BcMenu> implements IBcMenuService {

}
