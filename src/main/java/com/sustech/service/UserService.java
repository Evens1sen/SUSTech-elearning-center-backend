package com.sustech.service;

import com.sustech.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author ${author}
 * @since 2023-03-29
 */
public interface UserService extends IService<User> {

    boolean sendEmail(String email, String text);

    boolean sendNotification(String email);

    String sendVerification(String email);

}
