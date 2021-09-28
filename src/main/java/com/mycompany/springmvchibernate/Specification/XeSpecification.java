/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Specification;

import com.mycompany.springmvchibernate.XeMay;
import com.mycompany.springmvchibernate.XeMay_;

import java.util.Collection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/*
*
 *
 * @author MinhTo
 */
public class XeSpecification {

    public static Specification<XeMay> hasBienSoIn(Collection<String> listBienSo) {
        return (Root<XeMay> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
            Predicate equalPredicate = root.get(XeMay_.bienSo).in(listBienSo);
            return equalPredicate;
        };
    }
    public static Specification<XeMay> hasTenXe(String tenxe)
    {
        return (root, cq, cb) -> {
            Predicate eqPredicate=cb.equal(root.get(XeMay_.tenxe),tenxe);
            return eqPredicate ; //To change body of generated lambdas, choose Tools | Templates.
        };
    }
}
