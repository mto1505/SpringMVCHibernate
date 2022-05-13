/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.API;

import com.mycompany.springmvchibernate.Service.IXeMayService;
import com.mycompany.springmvchibernate.Specification.XeSpecification;

import com.mycompany.springmvchibernate.DTODemo.KhachHangDTO2;
import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MinhTo
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/xe-may")
public class XeMayControllerAPI {

   /* @Autowired
    IXeMayService xeMayService;

    @GetMapping
    public ResponseEntity<List<XeMayDTO2>> findAll(@RequestParam List<String> dsBienSo, String hasName) {

        List<XeMayDTO2> listXeMayDTOs = xeMayService.findAllByListBienSoAndTen(dsBienSo, hasName);
        return ResponseEntity.ok().body(listXeMayDTOs);

        //XeMayView xeMayView=xeMayRepository.findOneBybienSo("76");
//        XeMayDTO xeMayDTO=xeMayService.findOneByBienSo(bienso);
//        System.out.println(xeMayView.getBienSo());
//        System.out.println(xeMayView.getTenxe());
//        System.out.println(xeMayView.getidLoaiXe().getTenloai());
//        System.out.println(xeMayView);
        //List<XeMayDTO> list=xeMayRepository
//    return ResponseEntity.ok().body(xeMayRepository.findAllCustom((Pageable) new PageRequest(0, 5)));
//        return null;    
    }

    @PostMapping
    public ResponseEntity<String> createNewXeEntity(@RequestBody XeMayDTO2 xeMayDTO) {
        try {
            xeMayService.save(xeMayDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping
    public ResponseEntity<String> deleteXeEntity(@PathVariable String id) {
        xeMayService.delete(id);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/{bienSo}")
    public ResponseEntity<XeMayDTO2> updateEntity(@PathVariable String bienSo, @RequestBody XeMayDTO2 xeMayDTO2) {
        // XeMay xeMay=xeMayService.\
        System.out.println(xeMayDTO2.getKhachHang().getNgaySinh().toString());
        XeMayDTO2 xeMayDTO = xeMayService.findOneByBienSo(bienSo);
        
        if (xeMayDTO != null) {
            return new ResponseEntity(xeMayService.update(xeMayDTO2), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
    }
*/
}
