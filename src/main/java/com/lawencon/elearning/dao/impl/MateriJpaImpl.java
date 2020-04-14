package com.lawencon.elearning.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.elearning.dao.MateriDao;
import com.lawencon.elearning.model.Materi;
@Repository("materi_repo_jpa")
public class MateriJpaImpl implements MateriDao{
	
	@Autowired
	private MateriRepo materiRepo;

	@Override
	public Materi insertMateri(Materi materi) throws Exception {
		return materiRepo.save(materi);
	}

	@Override
	public List<Materi> findByWeekAndDay(int week, int day, String id) throws Exception {
		return materiRepo.findByWeekAndDay(week, day, id);
	}

	@Override
	public List<Materi> findAll(int week, int day) throws Exception {
		return null;
	}


}
