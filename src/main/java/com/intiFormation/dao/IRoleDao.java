package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intiFormation.entity.Role;


public interface IRoleDao extends JpaRepository <Role, Integer>{

}
