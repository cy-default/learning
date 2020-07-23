package com.remotes.design;

import lombok.Data;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-01
 */
public class User {
    private String name;
    private String password;

    public User(UserBuilder builder) {
        this.name=builder.name;
        this.password = builder.password;
    }

    public static class UserBuilder{
        private String name;
        private String password;

        public User.UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public User.UserBuilder password(String password){
            this.password = password;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
