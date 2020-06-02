package com.smittrial.demo.dao;

import com.smittrial.demo.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleDAO extends JpaRepository<RoleModel, Integer> {
    @Query(value = "SELECT DISTINCT r.id, r.name FROM role AS r LEFT JOIN user_role AS ur ON r.id = ur.role_id WHERE ur.user_id = :userId", nativeQuery = true)
    List<RoleModel> getUserRoles(@Param("userId") Integer userId);
}
