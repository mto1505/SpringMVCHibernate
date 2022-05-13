package com.mycompany.springmvchibernate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.springmvchibernate.Entity.VerificationTokenEntity;
@Repository
public interface VerificationRepository extends JpaRepository<VerificationTokenEntity,Long>{
	public VerificationTokenEntity findOneByToken(String token);
}
