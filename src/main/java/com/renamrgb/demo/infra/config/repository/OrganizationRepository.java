package com.renamrgb.demo.infra.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface OrganizationRepository<T extends OrganizationEntity, ID extends Serializable> extends JpaRepository<T, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    <S extends T> S save(S entity);

    void deleteById(ID id);
}
