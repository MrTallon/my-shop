package com.funtl.myshop.service.reg.controller;

import com.funtl.myshop.commons.domain.TbUser;
import com.funtl.myshop.commons.mapper.TbUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "reg")
public class RegController {

    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 根据 ID 测试查询用户信息
     *
     * @param tbUser
     * @return
     */
    @PostMapping(value = "")
    public String reg(TbUser tbUser) {
        // TODO 学习一下Validation
        return tbUser.getUsername();
    }
}