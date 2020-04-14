package com.lawencon.elearning.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.elearning.dao.MateriDao;
import com.lawencon.elearning.model.Materi;

@Repository("materi_repo_hibernate")
public class MateriDaoImpl extends BaseHibernate implements MateriDao {

	@Override
	public Materi insertMateri(Materi materi) throws Exception {
		em.persist(materi);
		return materi;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Materi> findByWeekAndDay(int week, int day, String id) throws Exception {
		Query q = em.createNativeQuery("select filemateri from tb_materi where week = :week and day = :day")
				.setParameter("week", week).setParameter("day", day);
		return q.getResultList();
	}

	@Override
	public List<Materi> findAll(int week, int day) throws Exception {
		Query q = em.createNativeQuery("select judul_materi,id,day, week from tb_materi where week = ? and day = ?")
				.setParameter(1, week).setParameter(2, day);
		return bMapperHibernate(q.getResultList(), "judul_materi","id","day","week");
	}
	
	private static List<Map<String, Object>> bMapperHibernate(List<Object[]> listMapping, String... obj) throws Exception {
		if(listMapping.isEmpty() || listMapping.get(0).length < 1) throw new Exception("Results is Empty");		
		if(listMapping.get(0).length != obj.length) throw new Exception("Length not same, results = "+listMapping.get(0).length+" <> mapping = "+obj.length);
		
		List<Map<String, Object>> listMap = new ArrayList<>();
		listMapping.forEach(valObj -> {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < valObj.length; i++) {
				map.put(obj[i], valObj[i]);
			}
			
			listMap.add(map);
		});
		
		return listMap;
	}

}
