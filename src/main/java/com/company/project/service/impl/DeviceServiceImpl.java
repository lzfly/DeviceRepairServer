package com.company.project.service.impl;

import com.company.project.core.ServiceException;
import com.company.project.dao.DeviceMapper;
import com.company.project.vo.DeviceRequestVO;
import com.company.project.model.Device;
import com.company.project.security.GeneratorUserDetailService;
import com.company.project.security.JwtTokenUtil;
import com.company.project.security.SecurityUser;
import com.company.project.service.DeviceService;
import com.company.project.utils.CglibBeanCopierUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.transaction.TransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;


/**
 * Created by CodeGenerator on 2017/10/15.
 *
 * @author jinhuaquan
 *
 * User的service层具体实现
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    public static final Logger LOGGER = LoggerFactory.getLogger(DeviceServiceImpl.class);

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private GeneratorUserDetailService userDetailService;


    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Long saveDevice(DeviceRequestVO requestDTO) {
        Date now = Date.from(Instant.now());


        Device device = new Device();

        CglibBeanCopierUtils.copyProperties(requestDTO, device);

        deviceMapper.saveDevice(device);

        return device.getId();
    }

    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Integer deleteById(Long id) {
        return deviceMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Long updateDevice(Long id, DeviceRequestVO requestDTO) {
    	Device device = new Device();
    	device.setId(id);
        CglibBeanCopierUtils.copyProperties(requestDTO, device);

        return deviceMapper.updateDevice(device);
    }

    @Override
    public Device findById(Long id) {
        return deviceMapper.findById(id);
    }

    @Override
    public PageInfo<Device> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Device> pageInfo = new PageInfo<>(deviceMapper.findAll());

        return pageInfo;
    }

    @Override
    public PageInfo<Device> findAllByCompany(String token, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        
        final String tokenok = token.substring(tokenHead.length(),token.length());
        LOGGER.info("token is {}", tokenok);
        String username = jwtTokenUtil.getUsernameFromToken(tokenok);
        
        LOGGER.info("username is {}", username);
        
        SecurityUser user = (SecurityUser) userDetailService.loadUserByUsername(username);
        
        PageInfo<Device> pageInfo = new PageInfo<>(deviceMapper.findByCompany(user.getCompany()));

        return pageInfo;
    }


}
