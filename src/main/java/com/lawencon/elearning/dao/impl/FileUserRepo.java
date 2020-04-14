package com.lawencon.elearning.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.elearning.model.FileUser;
@Repository
public interface FileUserRepo extends JpaRepository<FileUser, String> {

}
