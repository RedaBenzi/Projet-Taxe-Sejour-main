package com.example.demo.securite.dao;

import com.example.demo.securite.bean.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends JpaRepository<Permission, Long> {
    public Permission findByName(String name);
}
