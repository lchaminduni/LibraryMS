/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service;

import edu.ijse.service.user.impl.BookServiceImpl;
import edu.ijse.service.user.impl.BorrowingServiceImpl;
import edu.ijse.service.user.impl.CategoryServiceImpl;
import edu.ijse.service.user.impl.MemberServiceImpl;

/**
 *
 * @author Lihini
 */
public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    
    private ServiceFactory(){
        
    }
    
    public static ServiceFactory getInstance(){
        if(serviceFactory==null){
            serviceFactory=new ServiceFactory();
        }
        return serviceFactory;
    }
    public SuperService getService(ServiceType serviceType){
        switch (serviceType) {
            case CATEGORIES:
                return new CategoryServiceImpl();
            case BOOKS:
                return new BookServiceImpl();
            case MEMBER:
                return new MemberServiceImpl();
            case BORROWING:
                return new BorrowingServiceImpl();
            default:
                return null;
        }
    }
    
    public enum ServiceType{
        CATEGORIES,BOOKS,MEMBER,BORROWING
    }
}
