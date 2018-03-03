package com.company.project.service.impl;

import com.company.project.core.ServiceException;
import com.company.project.dao.CheckPlanMapper;
import com.company.project.vo.CheckPlanRequestVO;
import com.company.project.model.CheckPlan;
import com.company.project.security.GeneratorUserDetailService;
import com.company.project.security.JwtTokenUtil;
import com.company.project.security.SecurityUser;
import com.company.project.service.CheckPlanService;
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
 *
 * User的service层具体实现
 */
@Service
public class CheckPlanServiceImpl implements CheckPlanService {

    public static final Logger LOGGER = LoggerFactory.getLogger(CheckPlanServiceImpl.class);

    @Autowired
    private CheckPlanMapper checkPlanMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private GeneratorUserDetailService userDetailService;


    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Long saveCheckPlan(CheckPlanRequestVO requestDTO) {
        Date now = Date.from(Instant.now());


        CheckPlan checkPlan = new CheckPlan();

        CglibBeanCopierUtils.copyProperties(requestDTO, checkPlan);

        checkPlanMapper.saveCheckPlan(checkPlan);

        return checkPlan.getId();
    }

    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Integer deleteById(Long id) {
        return checkPlanMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Long updateCheckPlan(Long id, CheckPlanRequestVO requestDTO) {
    	CheckPlan checkPlan = new CheckPlan();
    	checkPlan.setId(id);
        CglibBeanCopierUtils.copyProperties(requestDTO, checkPlan);

        return checkPlanMapper.updateCheckPlan(checkPlan);
    }

    @Override
    public CheckPlan findById(Long id) {
        return checkPlanMapper.findById(id);
    }

    @Override
    public PageInfo<CheckPlan> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<CheckPlan> pageInfo = new PageInfo<>(checkPlanMapper.findAll());

        return pageInfo;
    }

    @Override
    public PageInfo<CheckPlan> findAllByCompany(String token, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        
        final String tokenok = token.substring(tokenHead.length(),token.length());
        LOGGER.info("token is {}", tokenok);
        String username = jwtTokenUtil.getUsernameFromToken(tokenok);
        
        LOGGER.info("username is {}", username);
        
        SecurityUser user = (SecurityUser) userDetailService.loadUserByUsername(username);
        
        PageInfo<CheckPlan> pageInfo = new PageInfo<>(checkPlanMapper.findByCompany(user.getCompany()));

        return pageInfo;
    }


}
