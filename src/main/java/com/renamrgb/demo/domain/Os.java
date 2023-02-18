package com.renamrgb.demo.domain;

import com.renamrgb.demo.infra.config.repository.OrganizationEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
//@Table(name = "users",
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = {"ORGANIZATION_ID", "NAME"}),
//                @UniqueConstraint(columnNames = {"DESCRIPTION"})
//        })

public class Os extends OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;
}
