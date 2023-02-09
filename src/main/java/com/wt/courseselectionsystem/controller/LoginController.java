package com.wt.courseselectionsystem.controller;

import com.wt.courseselectionsystem.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统用户登录 控制
 * @author xxx
 */
@Controller
public class LoginController {
    /**
     * 注入service
     */
    @Autowired
    private IAccountService accountService;

    /**
     * 功能描述：系统用户登录
     *登录用户名字判断？？？？？？？？？？？？？
     */
    @RequestMapping("/accountLogin")
    public String accountLogin(@RequestParam("accountNo")String accountNo,//名字
                               @RequestParam("password")String password,
                               HttpServletRequest request){
        if (accountNo!=null&&password!=null){
            if (accountService.login(accountNo,password)){
                request.getSession().setAttribute("accountNo",accountNo);
                /**
                 * 重定向到后台登录首页
                 */
                return "redirect:longinIndex";
            }
        }
        return "accountLogin";
    }
}
