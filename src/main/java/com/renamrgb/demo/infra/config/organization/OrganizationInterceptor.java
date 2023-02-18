package com.renamrgb.demo.infra.config.organization;

import com.renamrgb.demo.infra.config.exceptions.OrganizationIdNotFoundException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrganizationInterceptor implements HandlerInterceptor {

    private final String ORGANIZATION_ID = "Organization-Id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String organizationId = request.getHeader(ORGANIZATION_ID);
        if (isNullOrEmpity(organizationId)) {
            throw new OrganizationIdNotFoundException("Organization-Id não foi informado no header");
        }

        OrganizationScope.set(organizationId);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        OrganizationScope.organizationIdThreadLocal.remove();
    }

    private boolean isNullOrEmpity(final String value) {
        return value == null || value.isEmpty();
    }
}
