package com.crud.postgres.reinaldo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.postgres.reinaldo.model.profissao;

public interface ProfissaoRepository extends JpaRepository<profissao, Long> {

}
