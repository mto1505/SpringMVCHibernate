/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Specification;


import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import com.mycompany.springmvchibernate.EntityDemo.KhachHang;

/**
 *
 * @author MinhTo
 */
public class KhachHangSpecification {
    public static Specification<KhachHang> hasNameAndSDT(String name,String sdt)
            {  
               /* return (root, cq, cb) -> {
                        Predicate predicateHasName=cb.equal(root.get(KhachHang_.ten),name);
                        Predicate predicateHasSDT=cb.equal(root.get(KhachHang_.sdt),sdt);
                        Predicate predicateResult=cb.or(predicateHasName,predicateHasSDT);
                        return predicateResult;
                };*/
    	return null;
            }
}
    
