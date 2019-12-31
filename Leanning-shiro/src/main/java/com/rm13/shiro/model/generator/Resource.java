package com.rm13.shiro.model.generator;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Resource implements Serializable {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 权限码
     */
    private String permCode;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * 资源URL
     */
    private String resUrl;

    /**
     * 资源类型：MENU BUTTON API
     */
    private String resType;

    /**
     * 排序
     */
    private Integer sortPriority;

    /**
     * 父资源ID
     */
    private Long parentId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifyBy;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 删除标记
     */
    private Integer deleteFlag;

    /**
     * demo..tb_resource
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     * @return id 自增主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自增主键
     * @param id 自增主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 权限码
     * @return perm_code 权限码
     */
    public String getPermCode() {
        return permCode;
    }

    /**
     * 权限码
     * @param permCode 权限码
     */
    public void setPermCode(String permCode) {
        this.permCode = permCode == null ? null : permCode.trim();
    }

    /**
     * 资源名称
     * @return res_name 资源名称
     */
    public String getResName() {
        return resName;
    }

    /**
     * 资源名称
     * @param resName 资源名称
     */
    public void setResName(String resName) {
        this.resName = resName == null ? null : resName.trim();
    }

    /**
     * 资源URL
     * @return res_url 资源URL
     */
    public String getResUrl() {
        return resUrl;
    }

    /**
     * 资源URL
     * @param resUrl 资源URL
     */
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl == null ? null : resUrl.trim();
    }

    /**
     * 资源类型：MENU BUTTON API
     * @return res_type 资源类型：MENU BUTTON API
     */
    public String getResType() {
        return resType;
    }

    /**
     * 资源类型：MENU BUTTON API
     * @param resType 资源类型：MENU BUTTON API
     */
    public void setResType(String resType) {
        this.resType = resType == null ? null : resType.trim();
    }

    /**
     * 排序
     * @return sort_priority 排序
     */
    public Integer getSortPriority() {
        return sortPriority;
    }

    /**
     * 排序
     * @param sortPriority 排序
     */
    public void setSortPriority(Integer sortPriority) {
        this.sortPriority = sortPriority;
    }

    /**
     * 父资源ID
     * @return parent_id 父资源ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父资源ID
     * @param parentId 父资源ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 创建人
     * @return create_by 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     * @return modify_by 修改人
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * 修改人
     * @param modifyBy 修改人
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    /**
     * 修改时间
     * @return modify_time 修改时间
     */
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 删除标记
     * @return delete_flag 删除标记
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 删除标记
     * @param deleteFlag 删除标记
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}