package com.java.jpa.springbootjparelaciones.repositories;

import com.java.jpa.springbootjparelaciones.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {



}
