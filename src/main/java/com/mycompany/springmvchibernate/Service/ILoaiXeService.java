/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Service;

import java.util.List;

import com.mycompany.springmvchibernate.DTODemo.LoaiXeDTO2;

/**
 *
 * @author MinhTo
 */
public interface ILoaiXeService {
    List<LoaiXeDTO2> findAll();
    LoaiXeDTO2 findOneByTenLoai();
}
