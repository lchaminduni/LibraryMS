/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.user.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.Interfaces.BookDao;

import edu.ijse.dao.Interfaces.BorrowingDao;
import edu.ijse.dao.Interfaces.MemberDao;
import edu.ijse.dto.BorrowingDto;
import edu.ijse.entity.BorrowingEntity;
import edu.ijse.service.user.BorrowingService;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lihini
 */
public class BorrowingServiceImpl implements BorrowingService{
    private BorrowingDao borrowingDao = (BorrowingDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BORROWING);
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOKS);
    private MemberDao memberDao = (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);
    
    @Override
    public String save(BorrowingDto borrowingDto) throws Exception {
        BorrowingEntity borrowingEntity = getBorrowingEntity(borrowingDto);
        return borrowingDao.save(borrowingEntity) ? "Success" : "Fail";
    }

    @Override
    public String update(BorrowingDto borrowingDto) throws Exception {
        BorrowingEntity borrowingEntity = getBorrowingEntity(borrowingDto);
        return borrowingDao.update(borrowingEntity) ? "Success" : "Fail";
    }

    @Override
    public String delete(int id) throws Exception {
        return borrowingDao.delete(id) ? "Success" : "Fail";
    }

    @Override
    public BorrowingDto get(int id) throws Exception {
        BorrowingEntity borrowingEntity = borrowingDao.get(id); 
        if (borrowingEntity != null) {
            return getBorrowingDto(borrowingEntity);
        }
        return null;
        
    }

    @Override
    public ArrayList<BorrowingDto> getAll() throws Exception {
        ArrayList<BorrowingEntity> borrowingEntities = borrowingDao.getAll();
        if (borrowingEntities != null && !borrowingEntities.isEmpty()) {
            ArrayList<BorrowingDto> borrowingDtos = new ArrayList<>();

            for (BorrowingEntity borrowingEntity : borrowingEntities) {
                borrowingDtos.add(getBorrowingDto(borrowingEntity));
            }
            return borrowingDtos;
        }
        return null;
    }

    private BorrowingEntity getBorrowingEntity(BorrowingDto borrowingDto) {
        return new BorrowingEntity(borrowingDto.getId(),borrowingDto.getBook_id(),borrowingDto.getMember_id(),(Date)borrowingDto.getBorrow_date(),(Date)borrowingDto.getDue_date(),(Date)borrowingDto.getReturn_date(), borrowingDto.getFine());
    }

    private BorrowingDto getBorrowingDto(BorrowingEntity borrowingEntity) {
        return new BorrowingDto(borrowingEntity.getId(), borrowingEntity.getBook_id(), borrowingEntity.getMember_id(), borrowingEntity.getBorrow_date(), borrowingEntity.getDue_date(), borrowingEntity.getReturn_date(), borrowingEntity.getFine());
    }

    
}
