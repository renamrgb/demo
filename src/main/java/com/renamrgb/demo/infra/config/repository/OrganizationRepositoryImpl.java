package com.renamrgb.demo.infra.config.repository;

import com.renamrgb.demo.infra.config.organization.OrganizationScope;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class OrganizationRepositoryImpl<T extends OrganizationEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements OrganizationRepository<T, ID> {

    private final String ORGANIZATION_ID = OrganizationScope.get();
    private final EntityManager em;

    public OrganizationRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(ID id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(getDomainClass());
        Root<T> root = query.from(getDomainClass());
        Predicate organizationPredicate = criteriaBuilder.equal(root.get("organizationId"), ORGANIZATION_ID);
        Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
        query.select(root).where(organizationPredicate, idPredicate);
        return em.createQuery(query).getResultList().stream().findFirst();

    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getDomainClass());
        Root<T> root = query.from(getDomainClass());
        query.where(builder.equal(root.get("ORGANIZATION_ID"), ORGANIZATION_ID));
        return em.createQuery(query).getResultList();
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        entity.setOrganizationId(ORGANIZATION_ID);
        em.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void deleteById(ID id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaDelete<T> delete = criteriaBuilder.createCriteriaDelete(getDomainClass());
        Root<T> root = delete.from(getDomainClass());
        Predicate organizationPredicate = criteriaBuilder.equal(root.get("organizationId"), ORGANIZATION_ID);
        Predicate idPredicate = criteriaBuilder.equal(root.get("id"), id);
        delete.where(organizationPredicate, idPredicate);
        em.createQuery(delete).executeUpdate();
    }
}
