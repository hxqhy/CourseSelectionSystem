package com.wt.courseselectionsystem.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.model.vo.request.LoginForm;
import com.wt.courseselectionsystem.service.AccountService;
import com.wt.courseselectionsystem.service.impl.AccountServiceImpl;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author lixin
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AccountDaoTest {
    @Autowired
    MockMvc mockMvc; // Mock：模拟

    @Autowired
    private AccountDao accountDao;

    @Test
    public void testInsertAccount() {
        Account account = new Account();
        account.setAccountNo("12323");
        String s = passwordEncode("12323");
        account.setPassword(s);
        account.setAccountType(1);
        System.out.println(accountDao.insertAccount(account) == 1);
    }

    @Test
    public void testLogin() throws Exception {
        String url = "/account_login";
        LoginForm loginForm = new LoginForm();
        loginForm.setAccount("12323");
        loginForm.setPassword("12323");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(loginForm);

        mockMvc.perform( // 执行发出请求
                MockMvcRequestBuilders.post(url) // 根据请求方式决定调用的方法
                        .contentType(MediaType.APPLICATION_JSON) // 请求数据的文档类型，例如：application/json; charset=utf-8
                        .content(s) // 请求参数，有多个时，多次调用param()方法
                        .accept(MediaType.APPLICATION_JSON)) // 接收的响应结果的文档类型，注意：perform()方法到此结束
                .andExpect( // 预判结果，类似断言
                        MockMvcResultMatchers
                                .jsonPath("code") // 预判响应的JSON结果中将有名为state的属性
                                .value(200)) // 预判响应的JSON结果中名为state的属性的值，注意：andExpect()方法到此结束
                .andDo( // 需要执行某任务
                        MockMvcResultHandlers.print()); // 打印日志
    }


    private String passwordEncode(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
    }

    @Test
    public void testSelectAccountByAccountNo() {
        System.out.println(accountDao.selectByAccountNo("201948178305"));
    }
}

