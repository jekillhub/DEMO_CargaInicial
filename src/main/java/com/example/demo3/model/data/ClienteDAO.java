package com.example.demo3.model.data;

import com.example.demo3.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ClienteDAO extends CrudRepository<Cliente,Long> {}
