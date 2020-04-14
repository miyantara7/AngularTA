package com.lawencon.elearning.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.elearning.dao.MateriDao;
import com.lawencon.elearning.model.Materi;

@Service
@Transactional
public class MateriServiceImpl implements MateriService{
	
	@Autowired
	@Qualifier("materi_repo_jpa")
	private MateriDao materiservice;
	@Autowired
	@Qualifier("materi_repo_hibernate")
	private MateriDao h_service;

	@Override
	public Materi insertMateri(Materi materi) throws Exception {
		return materiservice.insertMateri(materi);
	}

	@Override
	public List<Materi> findByWeekAndDay(int week, int day, String id) throws Exception {
		return materiservice.findByWeekAndDay(week, day, id);
	}

	@Override
	public List<Materi> findAll(int week, int day) throws Exception {
		return h_service.findAll(week, day);
	}

}
