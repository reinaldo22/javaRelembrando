package com.crud.postgres.reinaldo.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import javax.persistence.criteria.Predicate;

import com.Utilities.CommonValidationConstants;
import com.crud.postgres.reinaldo.model.Banner;
import java.util.List;


public interface BannerRepository extends JpaRepository<Banner, Long>, JpaSpecificationExecutor<Banner>  {

    
    
}
