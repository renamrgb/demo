package com.renamrgb.demo.infra.config.organization;

public class OrganizationScope {

    protected static final ThreadLocal<String> organizationIdThreadLocal = new ThreadLocal<>();

    public static void set(String organizationId) {
        organizationIdThreadLocal.set(organizationId);
    }

    public static String get() {
        return organizationIdThreadLocal.get();
    }
}
