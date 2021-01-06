package com.sa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class ForumRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Forum> findAll() {
		Query query = entityManager.createQuery("from forum");
		return query.getResultList();
	}
	
	public Forum findById(Integer id) {
		return entityManager.find(Forum.class, id);
	}
	
	@Transactional
	public Forum save(Forum forum) {
		entityManager.persist(forum);
		return forum;
	}
	
	@Transactional
	public void delete(Forum forum) {
		entityManager.remove(forum);
	}
}
