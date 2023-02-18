package com.renamrgb.demo.infra.config.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class OrganizationEntity {
    @Column(name = "ORGANIZATION_ID", nullable = false)
    private String organizationId;
}