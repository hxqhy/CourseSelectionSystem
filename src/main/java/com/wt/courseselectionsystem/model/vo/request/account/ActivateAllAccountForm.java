package com.wt.courseselectionsystem.model.vo.request.account;

import lombok.Data;

import java.util.List;
/**
 * @author mry5l
 */

@Data
public class ActivateAllAccountForm {

    private List<String> allNumber;
}
