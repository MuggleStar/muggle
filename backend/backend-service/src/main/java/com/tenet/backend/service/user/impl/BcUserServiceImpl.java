package com.tenet.backend.service.user.impl;

import com.tenet.backend.api.entity.user.BcUser;
import com.tenet.backend.mapper.user.BcUserMapper;
import com.tenet.backend.service.user.IBcUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Madison
 * @since 2021-02-05
 */
@Service
public class BcUserServiceImpl extends ServiceImpl<BcUserMapper, BcUser> implements IBcUserService {

}
