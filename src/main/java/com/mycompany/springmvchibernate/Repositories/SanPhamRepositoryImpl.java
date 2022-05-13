package com.mycompany.springmvchibernate.Repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.ChiTietSanPham;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Entity.SanPham_;



@Transactional
public class SanPhamRepositoryImpl implements SanPhamRepositoryCustom<SanPham, Integer> {
	
	@Value("${hibernate.batch_size}")
	private int batch_size;

	@PersistenceContext
	EntityManager entityManager;
	
	
	public void print()
	{
		System.out.println("batch_size:  "+ batch_size);
	}
	@Override
	@Transactional
	public void customDeleteByIds(List<Integer> ids) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaDelete<SanPham> query=cb.createCriteriaDelete(SanPham.class);
		Root<SanPham> root=query.from(SanPham.class);
		Path<Integer> path=root.get("id");
		List<Predicate> predicates =new ArrayList<Predicate>();
		for(Integer id:ids){
				predicates.add(cb.or(cb.equal(root.get(SanPham_.id), id)));
		}
		query.where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
		entityManager.createQuery(query).executeUpdate();
	}
	/*public List<SanPham> findSanPhamInIds(List<Integer> ids)
	{
		CriteriaBuilder cb=entityManager.getCriteriaBuilder();
		CriteriaQuery<SanPham> query=cb.createQuery(SanPham.class);
		Root<SanPham> root=query.from(SanPham.class);
		Path<Integer> path=root.get("id");
		List<Predicate> predicates =new ArrayList<Predicate>();
		for(Integer id:ids){
				predicates.add(cb.or(cb.equal(root.get(SanPham_.id), id)));
		}
		query.select(root).where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
		return entityManager.createQuery(query).getResultList();
	}*/

	//@Query("select new com.mycompany.springmvchibernate.DTO.SanPhamDTO(s.hinhAnhSps,s.ten,s.c) from SanPham s left join fetch s.chiTietSanPhams as ct")
	public List<SanPham>findByTenLoaiAndFetchChiTiet(String tenLoai ){
		List<SanPham> sanPhams=entityManager.createQuery(""
				+ "select s from SanPham s "
				+ "left join fetch s.chiTietSanPhams "
				+ "where s.loai.ten=:tenLoai").setParameter("tenLoai", tenLoai).getResultList(); 
		sanPhams=entityManager.createQuery(""
				+ "select s from SanPham s "
				+ "left join fetch s.hinhAnhSps where s in :sanPhams").setParameter("sanPhams", sanPhams).getResultList();
		return sanPhams;
	}
	@Override
	@Transactional
	public void addChiTietSanPham(Integer id, ChiTietSanPham ctsp) {
		// TODO Auto-generated method stub
		SanPham sanPham=entityManager.getReference(SanPham.class, id);
		ctsp.setSanPham(sanPham);
		entityManager.persist(ctsp);
	}
	@Override
	public List findBySellMore(int soLuongMua)
	{	
		String q="select ctddh.id.idCtsp as idCtsp"  
				+ " from ChiTietDonDatHang ctddh group by ctddh.id.idCtsp order by SUM(ctddh.soLuong)";
		List<Integer> listIdCtsp=entityManager.createQuery(q).setMaxResults(20).getResultList();
		String query="from ChiTietSanPham ctsp inner join ctsp.sanPham sp where"
				+ " ctsp.id in :listIdCtsp and sp.id=ctsp.sanPham.id"
				;
		List bestSellers=entityManager.createQuery(query).setParameter("listIdCtsp",listIdCtsp).setMaxResults(20).getResultList();
		
		
		
		return bestSellers;
	}
	public List<SanPham>findByTenLoaiAndFetchChiTietAndHaveName(String tenLoai,String name ){
		List<SanPham> sanPhams=entityManager.createQuery(""
				+ "select s from SanPham s "
				+ "left join fetch s.chiTietSanPhams "
				+ "where s.loai.ten=:tenLoai").setParameter("tenLoai", tenLoai).getResultList(); 
		sanPhams=entityManager.createQuery(""
				+ "select s from SanPham s "
				+ "left join fetch s.hinhAnhSps where s in :sanPhams and s.ten like :searchField").setParameter("sanPhams", sanPhams).setParameter("searchField", MatchMode.ANYWHERE.toMatchString(name)).getResultList();
		return sanPhams;
	}
	@Override
	public List findSanPhamAndDetail(int id) {
		// TODO Auto-generated method stub
		List<SanPham> sanPhams=entityManager.createQuery(""
				+ "select s from SanPham s "
				+ "left join fetch s.chiTietSanPhams "
				+ "where s.id=:id").setParameter("id", id).getResultList(); 
		sanPhams=entityManager.createQuery(""
				+ "select distinct s from SanPham s "
				+ "left join fetch s.hinhAnhSps where s in :sanPhams").setParameter("sanPhams", sanPhams).getResultList();
		return sanPhams;
	}
	
	





}
