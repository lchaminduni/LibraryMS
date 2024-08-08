/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao;

import edu.ijse.dao.Impl.BookDaoImpl;
import edu.ijse.dao.Impl.BorrowingDaoImpl;
import edu.ijse.dao.Impl.CategoryDaoImpl;
import edu.ijse.dao.Impl.MemberDaoImpl;

/**
 *
 * @author Lihini
 */
public class DaoFactory {
     private static DaoFactory daoFactory;
    
    private DaoFactory(){
        
    }
    
    public static DaoFactory getInstance (){
        if(daoFactory==null){
            daoFactory=new DaoFactory();
        }
        return daoFactory;
    }
    public SuperDao getDao(DaoTypes daoTypes){
        switch (daoTypes) {
            case CATEGORIES:
                return new CategoryDaoImpl();
            case BOOKS:
                return new BookDaoImpl();
            case MEMBER:
                return new MemberDaoImpl();
            case BORROWING:
                return new BorrowingDaoImpl();
            default:
                return null;
        }
    }
    
    public enum DaoTypes{
        CATEGORIES,BOOKS,MEMBER,BORROWING
    }
}
