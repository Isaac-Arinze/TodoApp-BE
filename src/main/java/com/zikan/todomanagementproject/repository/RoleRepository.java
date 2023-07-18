package com.zikan.todomanagementproject.repository;

import com.zikan.todomanagementproject.entity.Role;
import com.zikan.todomanagementproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {

}
