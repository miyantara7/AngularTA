package com.lawencon.elearning.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.FileUserDao;
import com.lawencon.elearning.model.FileUser;
@Repository
public class FileUserJpaImpl implements FileUserDao {
	
	@Autowired
	private FileUserRepo fileUserRepo;

	@Override
	public FileUser insert(FileUser fileUser) throws Exception {
		return fileUserRepo.save(fileUser);
	}

	@Override
	public void deleteAll() throws Exception {
		fileUserRepo.deleteAll();
		
	}

	@Override
	public List<FileUser> findAll() throws Exception {
		return fileUserRepo.findAll();
	}

}
