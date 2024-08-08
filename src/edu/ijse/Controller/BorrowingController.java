/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.Controller;

import edu.ijse.dto.BorrowingDto;
import edu.ijse.service.ServiceFactory;
import edu.ijse.service.user.BorrowingService;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class BorrowingController {
    private ArrayList<BorrowingDto> borrowingDtos;

    public BorrowingController() {
        borrowingDtos = new ArrayList<>(); // Initialize with an empty list or fetch from data source
    }
    private BorrowingService borrowingService=(BorrowingService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BORROWING);
    
    public String saveBorrow(BorrowingDto borrowingDto)throws Exception{
        return borrowingService.save(borrowingDto);
    }
    
    public String updateBorrow(BorrowingDto borrowingDto)throws Exception{
        return borrowingService.update(borrowingDto);
    }
    
    public String deleteBorrow(int id)throws Exception{
        return borrowingService.delete(id);
    }
    
    public ArrayList<BorrowingDto> getAllBorrowings() throws Exception{
        return borrowingService.getAll();
    }
    
    public BorrowingDto get(int id) throws Exception{
        return borrowingService.get(id);
    }
    
    
    
}
