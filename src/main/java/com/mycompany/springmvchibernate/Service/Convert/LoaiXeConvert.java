/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service.Convert;

import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO2;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author MinhTo
 */
/*@Component*/
public class LoaiXeConvert {
    
    @Autowired
    ModelMapper modelMapper;
    
    
    /*public LoaiXeDTO2 toDTO(LoaiXe loaiXe)
    {
       LoaiXeDTO2 loaiXeDTO=modelMapper.map(loaiXe,LoaiXeDTO2.class);
       return loaiXeDTO;
    
    }
    public LoaiXe toEntity(LoaiXeDTO2 loaiXeDTO)
    {
        LoaiXe loaiXe=modelMapper.map(loaiXeDTO, LoaiXe.class);
        return loaiXe;
    }
    public List<LoaiXe> toEntitys(List<LoaiXeDTO2> loaiXeDTO)
    {
        List<LoaiXe> loaiXe=modelMapper.map(loaiXeDTO, new TypeToken<List<LoaiXe>>(){}.getType());
        return loaiXe;
    }
     public List<LoaiXeDTO2> toDTOs(List<LoaiXe> listLoaiXe)
    {
        List<LoaiXeDTO2> loaiXe=modelMapper.map(listLoaiXe, new TypeToken<List<LoaiXeDTO2>>(){}.getType());
        return loaiXe;
    }*/
    
    
    
    
    
    
}
