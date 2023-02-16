package com.wt.courseselectionsystem.common.annotation.limiter;

import com.wt.courseselectionsystem.common.SystemUtils;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.vo.request.course.plan.CoursePlanInfoQuery;

import java.time.LocalDate;
import java.util.Optional;

import static com.wt.courseselectionsystem.common.constant.AccountConstant.STUDENT_CODE;
import static com.wt.courseselectionsystem.common.constant.AccountConstant.TEACHER_CODE;

/**
 * @author lixin
 */
public class CoursePlanInfoListQueryLimiter implements Limiter {

    @Override
    public Object limit(Object obj, Account account) {
        CoursePlanInfoQuery query = obj instanceof CoursePlanInfoQuery ? (CoursePlanInfoQuery) obj
                : new CoursePlanInfoQuery();
        Integer accountType = Optional.ofNullable(account)
                .map(Account::getAccountType)
                .orElseThrow(() -> new RuntimeException("获取账户类型失败"));
        if (accountType.equals(STUDENT_CODE)) {
            query.setCoursePlanYear(String.valueOf(LocalDate.now().getYear()));
            query.setCoursePlanNo("");
        }
        if (accountType.equals(TEACHER_CODE)) {
            String teacherNo = Optional.ofNullable(account.getAccountNo())
                    .map(SystemUtils::parseAccountNo)
                    .orElseThrow(() -> new RuntimeException("获取教师编号失败"));
            query.setTeacherNo(teacherNo);
            query.setTeacherName("");
        }
        return query;
    }

}
