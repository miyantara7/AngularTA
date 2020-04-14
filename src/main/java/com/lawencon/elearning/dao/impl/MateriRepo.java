package com.lawencon.elearning.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.elearning.model.Materi;
@Repository
public interface MateriRepo extends JpaRepository<Materi, String> {

	@Query(value = "select * from tb_materi where week = ?1 and day = ?2 and id = ?3", nativeQuery =true)
	List<Materi> findByWeekAndDay(int week, int day, String id);

}
