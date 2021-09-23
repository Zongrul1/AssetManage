package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.UserMapper;
import com.example.assetmanage.model.User;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * todo
 * @author huang jiahui
 * @date 2021/9/22 10:00
 */
@Service
@AllArgsConstructor
public class LoginService {

    private final UserMapper userMapper;

    /**
     * 验证用户合法性
     * @param account
     * @param password
     * @return {@link Boolean}
     */
    public String verify(String account, String password, HttpServletRequest request) {
        // 验证sha256
        String passwordEncrypt = DigestUtils.sha256Hex(password);

        // 查找用户
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("account", account)
                .eq("password", passwordEncrypt));

        // 用户不存在
        if (user == null) {
            return null;
        }
        // 获取当前时间
        long currentTime = System.currentTimeMillis();

        // todo 修改生成规则
        // 生成token规则 账户 + 密码 + 当前时间
        String token = DigestUtils.md5Hex(account + password + currentTime);

        request.getSession().setAttribute("userId",user.getId());
        request.getSession().setAttribute("token",token);


        return token;
    }

    @Scheduled(fixedRate = 1000 * 20)
    public void invalidSession(){
    }
}
