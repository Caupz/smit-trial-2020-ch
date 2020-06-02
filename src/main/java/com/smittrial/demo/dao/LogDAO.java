package com.smittrial.demo.dao;

import com.smittrial.demo.models.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDAO extends JpaRepository<LogModel, Integer> {
}
