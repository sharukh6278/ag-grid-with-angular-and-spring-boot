package com.ag.grid.demo.repository;

import com.ag.grid.demo.model.CompanyResponse;
import com.ag.grid.demo.model.RequestWithFilterAndSort;
import com.ag.grid.demo.pojo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Component
public class CompanyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    public Page<CompanyResponse> getCompanies(Pageable pageable, RequestWithFilterAndSort requestWithFilterAndSort){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<CompanyResponse> companyResponseCriteriaQuery=criteriaBuilder.createQuery(CompanyResponse.class);
        Root<Company> companyRoot=companyResponseCriteriaQuery.from(Company.class);

        companyResponseCriteriaQuery.multiselect(companyRoot.get("id"),
                companyRoot.get("companyName"),
                companyRoot.get("employeeName"),
                companyRoot.get("description"),
                companyRoot.get("leave")
                );

        Optional.ofNullable(requestWithFilterAndSort.getColId()).isPresent(colId);
        List<CompanyResponse> companyResponseList=entityManager.createQuery(companyResponseCriteriaQuery).getResultList();
        List<CompanyResponse> companyResponses=entityManager.createQuery(companyResponseCriteriaQuery).
                setFirstResult((int) pageable.getOffset()).
                setMaxResults(pageable.getPageSize()).
                getResultList();
        return new PageImpl<>(companyResponses,pageable,companyResponseList.size());
    }
}
