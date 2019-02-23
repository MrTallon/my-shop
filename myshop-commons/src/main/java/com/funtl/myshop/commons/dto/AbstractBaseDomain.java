package com.funtl.myshop.commons.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用的领域模型
 *
 * @author YangBo
 * @date 2019/02/23
 */
@Data
public abstract class AbstractBaseDomain implements Serializable {
    private Long id;
}
