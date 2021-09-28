package com.mycompany.springmvchibernate.DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springmvchibernate.Dao.SanPhamDao;
import com.mycompany.springmvchibernate.Entity.SanPham;

@Repository
@Transactional
public class SanPhamDaoImpl implements SanPhamDao {

	
	@PersistenceContext 
	private EntityManager entityManager;
	
	@Autowired
	private EntityManagerFactory emf;
 	
	@SuppressWarnings("unchecked")
	@Override
	public List<SanPham> findAll() {
		
		List<SanPham> listSanPham2=entityManager.createQuery("select id from SanPham").getResultList();
		List<SanPham> listSanPham=entityManager.createQuery("from SanPham").getResultList();
	
		return listSanPham2;
	}

}
