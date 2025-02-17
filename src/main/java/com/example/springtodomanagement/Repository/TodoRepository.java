package com.example.springtodomanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springtodomanagement.Model.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> 
{

}
