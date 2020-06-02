package com.smittrial.demo.dao;

import com.smittrial.demo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserModel, Integer> {
}
