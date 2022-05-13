/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service.Convert;

import com.mycompany.springmvchibernate.DTODemo.XeMayDTO;


import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author MinhTo
 */
/*@Component*/
public class XeMayConvert {

    @Autowired
    ModelMapper modelMapper;
/*
    public XeMayDTO toDTO(XeMay xeMay) {
        XeMayDTO xeMayDTO = modelMapper.map(xeMay, XeMayDTO.class);
        return xeMayDTO;
    }

    public XeMayDTO2 toDTO2(XeMay xeMay) {
        XeMayDTO2 xeMayDTO2 = modelMapper.map(xeMay, XeMayDTO2.class);
        return xeMayDTO2;
    }

    public XeMay toEntity(XeMayDTO xeMayDTO) {
        XeMay xeMay = modelMapper.map(xeMayDTO, XeMay.class);
        return xeMay;
    }

    public List<XeMayDTO> toDTOs(List<XeMay> listXe) {
        List<XeMayDTO> listXeDTO = new ArrayList<>();
        for (XeMay xeMay : listXe) {
            listXeDTO.add(toDTO(xeMay));
        }
        return listXeDTO;
    }

    public List<XeMayDTO2> toDTO2s(List<XeMay> listXe) {
        List<XeMayDTO2> listXeDTO2 = new ArrayList<>();
        for (XeMay xeMay : listXe) {
            listXeDTO2.add(toDTO2(xeMay));
        }
        return listXeDTO2;
    }
     public XeMay toEntity(XeMayDTO2 xeMayDTO2) {
        XeMay xeMay = modelMapper.map(xeMayDTO2, XeMay.class);
        return xeMay;
    }
*/
}
