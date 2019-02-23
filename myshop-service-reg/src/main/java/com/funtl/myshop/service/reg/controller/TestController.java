package com.funtl.myshop.service.reg.controller;

import com.funtl.myshop.commons.domain.TbUser;
import com.funtl.myshop.commons.dto.AbstractBaseResult;
import com.funtl.myshop.commons.dto.BaseResultFactory;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 请求数据测试
 *
 * @author YangBo
 * @date 2019/02/22
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping(value = "records/{id}")
    public AbstractBaseResult getById(HttpServletRequest request, @PathVariable long id) {

        // 模拟一条TBUser数据
        TbUser tbUser = new TbUser();
        tbUser.setId(1L);
        tbUser.setUsername("Tallon");


        if (id == 1) {
            return BaseResultFactory.getInstance().build(request.getRequestURI(), tbUser);
        } else {
            return BaseResultFactory.build(HttpStatus.UNAUTHORIZED.value(), "参数类型错误", "ID只能为1", applicationContext.getEnvironment().getProperty("com.funtl.myshop"));
        }
    }

    @GetMapping(value = "records")
    public AbstractBaseResult getList(HttpServletRequest request) {
        // 模拟一条TBUser数据
        TbUser tbUser1 = new TbUser();
        tbUser1.setId(2L);
        tbUser1.setUsername("Eric");
        // 模拟一条TBUser数据
        TbUser tbUser2 = new TbUser();
        tbUser2.setId(3L);
        tbUser2.setUsername("Sam");

        List<TbUser> list = Lists.newArrayList();
        list.add(tbUser1);
        list.add(tbUser2);

        return BaseResultFactory.getInstance().build(request.getRequestURI(), 2, 1,list);
    }
}
