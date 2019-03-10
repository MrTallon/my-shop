package com.funtl.myshop.service.reg.controller;

import com.funtl.myshop.commons.domain.TbUser;
import com.funtl.myshop.commons.dto.AbstractBaseResult;
import com.funtl.myshop.commons.service.TbUserService;
import com.funtl.myshop.commons.validator.BeanValidator;
import com.funtl.myshop.commons.web.AbstractBaseController;
import com.funtl.myshop.service.reg.service.RegService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "reg")
public class RegController extends AbstractBaseController<TbUser> {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private RegService regService;
    /**
     * 注册用户
     *
     * @param tbUser
     * @return
     */
    @ApiOperation(value = "用户注册",notes = "注意用户名和邮箱不可重复")
    @PostMapping(value = "user")
    public AbstractBaseResult reg(@ApiParam(name = "tbUser",value = "用户模型") TbUser tbUser) {
        //数据校验
        String message = BeanValidator.validator(tbUser);
        if (StringUtils.isNotBlank(message)) {
            return error(message, null);
        }

        //验证用户名是否重复
        if (!tbUserService.unique("username", tbUser.getUsername())) {
            return error("用户名已被注册，请重试", null);
        }
        //验证邮箱是否重复
        if (!tbUserService.unique("email", tbUser.getEmail())) {
            return error("邮箱已被注册，请重试", null);
        }

        //注册用户
        tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));

        TbUser user = tbUserService.save(tbUser);
        if (user != null) {
            regService.sendEmail(user);
            response.setStatus(HttpStatus.CREATED.value());
            return success(request.getRequestURI(), user);
        }
        return error("注册失败，请重试", null);
    }
}