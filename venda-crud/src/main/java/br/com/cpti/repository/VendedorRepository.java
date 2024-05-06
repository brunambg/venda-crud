package br.com.cpti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cpti.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}