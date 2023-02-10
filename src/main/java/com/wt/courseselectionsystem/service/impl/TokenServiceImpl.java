package com.wt.courseselectionsystem.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.wt.courseselectionsystem.model.dao.basebean.Account;
import com.wt.courseselectionsystem.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author lixin
 */
@Service
public class TokenServiceImpl implements TokenService<Account> {
    /**
     * 本地缓存池
     */
    private final Cache<String, Account> tokenCache = CacheBuilder.newBuilder()
            .maximumSize(1000L)
            .expireAfterAccess(20, TimeUnit.MINUTES)
            .build();

    private String generateToken() {
        String random = String.valueOf((System.currentTimeMillis() +
                ThreadLocalRandom.current().nextInt(8888)));
        return DigestUtils.md5DigestAsHex(random.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String getToken(Account data) {
        String token = generateToken();
        tokenCache.put(token, data);
        return token;
    }

    @Override
    public Account getData(String token) {
        Account account = tokenCache.getIfPresent(token);
        if (Objects.isNull(account)) {
            throw new RuntimeException("令牌过期");
        }
        return account;
    }

    @Override
    public void removeToken(String token) {
        tokenCache.invalidate(token);
    }
}
