package com.lawencon.elearning.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lawencon.elearning.dao.FileUserDao;
import com.lawencon.elearning.model.FileUser;

@Service
@Transactional
public class FileUserServiceImpl implements FileUserService {

	@Autowired
	private FileUserDao fileUserService;

	@Override
	public FileUser insert(FileUser fileUser) throws Exception {
		return fileUserService.insert(fileUser);
	}

	@Override
	public List<FileUser> findAll() throws Exception {
		return fileUserService.findAll();
	}

	@Override
	public void deleteAll() throws Exception {
		fileUserService.deleteAll();
		
	}

}
