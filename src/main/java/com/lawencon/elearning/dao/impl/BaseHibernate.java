package com.lawencon.elearning.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseHibernate {
	
	@PersistenceContext
	protected EntityManager em;

}
