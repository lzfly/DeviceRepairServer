package com.company.project.service.impl;

import com.company.project.core.ServiceException;
import com.company.project.dao.RepairItemMapper;
import com.company.project.vo.RepairItemRequestVO;
import com.company.project.model.RepairItem;
import com.company.project.service.RepairItemService;
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
public class RepairItemServiceImpl implements RepairItemService {

    public static final Logger LOGGER = LoggerFactory.getLogger(RepairItemServiceImpl.class);

    @Autowired
    private RepairItemMapper repairItemMapper;



    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Long saveRepairItem(RepairItemRequestVO requestDTO) {
        Date now = Date.from(Instant.now());


        RepairItem repairItem = new RepairItem();

        CglibBeanCopierUtils.copyProperties(requestDTO, repairItem);

        repairItemMapper.saveRepairItem(repairItem);

        return repairItem.getId();
    }

    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Integer deleteById(Long id) {
        return repairItemMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = TransactionException.class)
    public Long updateRepairItem(Long id, RepairItemRequestVO requestDTO) {
    	RepairItem repairItem = new RepairItem();
    	repairItem.setId(id);
        CglibBeanCopierUtils.copyProperties(requestDTO, repairItem);

        return repairItemMapper.updateRepairItem(repairItem);
    }

    @Override
    public RepairItem findById(Long id) {
        return repairItemMapper.findById(id);
    }

    @Override
    public PageInfo<RepairItem> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<RepairItem> pageInfo = new PageInfo<>(repairItemMapper.findAll());

        return pageInfo;
    }

    @Override
    public RepairItem findByCompany(String company) {
        return repairItemMapper.findByCompany(company);
    }


}
