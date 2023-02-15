package com.wt.courseselectionsystem.model.vo.request.account;

import lombok.Data;

@Data
public class UpdatePasswordForm {
    private String accountNo;
    private String password;
}
