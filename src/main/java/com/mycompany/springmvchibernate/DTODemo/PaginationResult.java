/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.DTODemo;

import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author MinhTo
 */
public class PaginationResult<E> {
    private int totalPages;
    private int currentPage;
    private int maxResult;
    private List<E> list;
    private int maxNavigationPage;
    private List<Integer> navigationPages;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getMaxNavigationPage() {
        return maxNavigationPage;
    }

    public void setMaxNavigationPage(int maxNavigationPage) {
        this.maxNavigationPage = maxNavigationPage;
    }

    public List<Integer> getNavigationPages() {
        return navigationPages;
    }

    public void setNavigationPages(List<Integer> navigationPages) {
        this.navigationPages = navigationPages;
    }
     public  PaginationResult (int page, int maxResult, int maxNavigationPage) {}
}
