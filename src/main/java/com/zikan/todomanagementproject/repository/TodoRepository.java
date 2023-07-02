package com.zikan.todomanagementproject.repository;

import com.zikan.todomanagementproject.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository <Todo, Long> {

}
