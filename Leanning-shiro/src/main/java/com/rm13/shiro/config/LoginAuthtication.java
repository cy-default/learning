package com.rm13.shiro.config;

import com.rm13.shiro.model.generator.User;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/25
 */
public class LoginAuthtication {

    public static ThreadLocal<User> currentUser = new ThreadLocal();

    public static User getAuthenticatedUser() {
        User user = currentUser.get();
        if(user == null){
            user = new User();
        }
        return user;
    }

    public static void setAuthenticatedUser(User user) {
        currentUser.set(user);
    }

    public static void clear(){
        currentUser.remove();
    }
}
