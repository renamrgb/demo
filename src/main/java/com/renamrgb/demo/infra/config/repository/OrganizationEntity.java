package com.renamrgb.demo.infra.config.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class OrganizationEntity implements Serializable {

    @Column(name = "ORGANIZATION_ID", length = 6)
    private String organizationId;
}