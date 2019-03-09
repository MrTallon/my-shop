package com.funtl.myshop.commons.service.impl;

import com.funtl.myshop.commons.dto.AbstractBaseDomain;
import com.funtl.myshop.commons.service.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.MyMapper;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

/**
 * This is Description
 *
 * @author YangBo
 * @date 2019/03/09
 */
public class BaseCrudServiceImpl<T extends AbstractBaseDomain, M extends MyMapper<T>> implements BaseCrudService<T> {

    @Autowired
    protected M mapper;

    //精髓：通过范型得到实体类的Class
    private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Override
    public boolean unique(String property, String value) {
        Example example = new Example(entityClass);
        example.createCriteria().andEqualTo(property, value);
        int result = mapper.selectCountByExample(example);
        if (result > 0) {
            return false;
        }
        return true;
    }

    @Override
    public T save(T domain) {
        int result = 0;
        //分布式系统的时间不可以直接用Date获取，应用全局时钟，此处暂用Date
        Date currentDate = new Date();
        domain.setUpdated(currentDate);
        //创建
        if (domain.getId() == null) {
            domain.setCreated(currentDate);
            result = mapper.insertUseGeneratedKeys(domain);
        }
        //更新
        else {
            result = mapper.updateByPrimaryKeySelective(domain);
        }
        //数据操作成功
        if (result > 0) {
            return domain;
        }
        //保存数据失败
        return null;
    }
}
