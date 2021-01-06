package com.rest.wfm.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rest.wfm.entity.Users;

public interface UserDAO extends CrudRepository<Users,Long>{
  public Users getUserByUsername(String username);
}
