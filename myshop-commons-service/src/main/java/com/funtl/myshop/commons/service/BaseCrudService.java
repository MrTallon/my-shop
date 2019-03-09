package com.funtl.myshop.commons.service;

import com.funtl.myshop.commons.dto.AbstractBaseDomain;

/**
 * 通用的业务逻辑
 *
 * @author YangBo
 * @date 2019/03/09
 */
public interface BaseCrudService<T extends AbstractBaseDomain> {
    /**
     * 查询属性值是否唯一
     * @param property
     * @param value
     * @return          true:唯一；false:不唯一
     */
    default boolean unique(String property, String value) {

        return false;
    }

    default T save(T domain) {
        return null;
    }

}
