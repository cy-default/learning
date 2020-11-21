package com.rm13.shardingsphere.po;

import java.time.LocalDateTime;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String nickName;

    private Integer age;

    private String address;

    private String createBy;

    private LocalDateTime createTime;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private Integer deleteFlag;

    public User(Integer id, String username, String password, String name, String nickName, Integer age, String address, String createBy, LocalDateTime createTime, String modifyBy, LocalDateTime modifyTime, Integer deleteFlag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.age = age;
        this.address = address;
        this.createBy = createBy;
        this.createTime = createTime;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
        this.deleteFlag = deleteFlag;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}