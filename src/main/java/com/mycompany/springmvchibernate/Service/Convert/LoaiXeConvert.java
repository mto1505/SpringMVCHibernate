/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service.Convert;

import com.mycompany.springmvchibernate.LoaiXe;
import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO;

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
    
    
    public LoaiXeDTO toDTO(LoaiXe loaiXe)
    {
       LoaiXeDTO loaiXeDTO=modelMapper.map(loaiXe,LoaiXeDTO.class);
       return loaiXeDTO;
    
    }
    public LoaiXe toEntity(LoaiXeDTO loaiXeDTO)
    {
        LoaiXe loaiXe=modelMapper.map(loaiXeDTO, LoaiXe.class);
        return loaiXe;
    }
    public List<LoaiXe> toEntitys(List<LoaiXeDTO> loaiXeDTO)
    {
        List<LoaiXe> loaiXe=modelMapper.map(loaiXeDTO, new TypeToken<List<LoaiXe>>(){}.getType());
        return loaiXe;
    }
     public List<LoaiXeDTO> toDTOs(List<LoaiXe> listLoaiXe)
    {
        List<LoaiXeDTO> loaiXe=modelMapper.map(listLoaiXe, new TypeToken<List<LoaiXeDTO>>(){}.getType());
        return loaiXe;
    }
    
    
    
    
    
    
}
