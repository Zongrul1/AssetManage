package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.UserMapper;
import com.example.assetmanage.model.User;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户service
 * @author huang jiahui
 * @date 2021/9/18 10:02
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;


    /**
     * 根据id返回存在用户
     * @param id
     * @return {@link User}
     */
    public User get(String id) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("id", id).eq("deleted", 0));
    }

    /**
     * 返回全部用户
     * @return {@link List}<{@link User}>
     */
    public List<User> getAll() {
        return userMapper.selectList(new QueryWrapper<>());
    }

    /**
     * 新增用户
     * @param user
     * @return {@link User}
     */
    public User add(User user) {
        // sha256加密
        String passwordEncrypt = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(passwordEncrypt);
        user.setCreateTime(new Date(System.currentTimeMillis()));
        userMapper.insert(user);
        return user;
    }

    /**
     * 更新用户信息
     * @param user
     * @return {@link User}
     */
    public User update(User user) {
        String passwordEncrypt = DigestUtils.sha256Hex(user.getPassword());
        user.setPassword(passwordEncrypt);
        userMapper.updateById(user);
        return user;
    }

    /**
     * 删除用户
     * @param id
     * @return {@link String}
     */
    public String delete(String id){
        userMapper.deleteById(id);
        return id;
    }

    /**
     * 假删除，能恢复
     * @param id
     * @return {@link String}
     */
    public String hiddenDelete(String id){
        User user = userMapper.selectById(id);
        user.setDeleted(1);
        update(user);
        return id;
    }

    /**
     * todo
     * 验证用户合法性
     * @param account
     * @param password
     * @return {@link String}
     */
    public String verify(String account,String password){
        // 验证sha256
        String passwordEncrypt = DigestUtils.sha256Hex(password);

        int count = userMapper.selectCount(new QueryWrapper<User>().eq("account",account)
                .eq("password",passwordEncrypt));

        if (count == 0) {
            return "验证失败";
        }

        return "验证成功";
    }

}
