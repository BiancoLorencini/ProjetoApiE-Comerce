package br.org.serratec.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.ecommerce.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
