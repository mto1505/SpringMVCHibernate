/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Controller;

import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO2;
import com.mycompany.springmvchibernate.Service.ILoaiXeService;
import com.mycompany.springmvchibernate.Service.IXeMayService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MinhTo
 */
/*@Controller
public class XeMayController {*/

  /*  @Autowired
    IXeMayService xeMayService;
    @Autowired
    ILoaiXeService loaiXeService;

    @RequestMapping(value = "/quan-tri/xe-may", method = RequestMethod.GET)

    public ModelAndView updateXeMay(@RequestParam(name = "bienSo", required = false) String bienSoXe) {
        ModelAndView modelAndView = new ModelAndView("/admin/car/editCar");
        if (bienSoXe.isEmpty()) {
            XeMayDTO2 xeMay = xeMayService.findOneByBienSo(bienSoXe);
            modelAndView.addObject("xeMay", xeMay);
        }
        ArrayList<LoaiXeDTO> loaiXe = (ArrayList<LoaiXeDTO>) loaiXeService.findAll();
        modelAndView.addObject("listLoaiXe", loaiXe);

        return modelAndView;
    }*/

