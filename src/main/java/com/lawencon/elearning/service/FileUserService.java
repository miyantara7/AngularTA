package com.lawencon.elearning.service;

import java.util.List;

import com.lawencon.elearning.model.FileUser;

public interface FileUserService {

	abstract FileUser insert(FileUser fileUser) throws Exception;
	abstract List<FileUser> findAll() throws Exception;
	abstract void deleteAll() throws Exception;
}
