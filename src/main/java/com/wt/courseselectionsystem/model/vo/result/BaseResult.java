package com.wt.courseselectionsystem.model.vo.result;

import lombok.Data;

import java.util.Objects;

/**
 * @author lixin
 */
@Data
public class BaseResult {
    private String code;
    private String msg;
    private Objects data;
}
