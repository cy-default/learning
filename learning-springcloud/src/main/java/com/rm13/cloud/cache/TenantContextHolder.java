package com.rm13.cloud.cache;

/**
 * 租户信息
 *
 * @Author: chenyuan
 * @Date: 2021/4/6 下午8:00
 */
public class TenantContextHolder {
	private static final ThreadLocal<Long> TenantId = new ThreadLocal<>();

	public static void setTenantId(Long tenantId) {
		TenantId.set(tenantId);
	}

	public static void remove(){
		TenantId.remove();
	}

	public static Long getTenantId() {
		return TenantId.get();
	}
}
