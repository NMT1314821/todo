package com.example.springtodomanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springtodomanagement.Model.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
	
	
}
