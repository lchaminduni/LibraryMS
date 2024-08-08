/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao.Impl;

import edu.ijse.dao.CrudUtil;
import edu.ijse.dao.Interfaces.BorrowingDao;
import edu.ijse.entity.BorrowingEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class BorrowingDaoImpl implements BorrowingDao{

    @Override
    public boolean save(BorrowingEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO borrowing VALUES (?,?,?,?,?,?,?)",t.getId(),t.getBook_id(),t.getMember_id(),t.getBorrow_date(),t.getDue_date(),t.getReturn_date(),t.getFine());
    }

    @Override
    public boolean update(BorrowingEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE borrowing SET book_id = ?, member_id = ?, borrow_date = ?,due_date=?,return_date=?,fine=? WHERE id=?",t.getBook_id(),t.getMember_id(),t.getBorrow_date(),t.getDue_date(),t.getReturn_date(),t.getFine(),t.getId());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM borrowing WHERE id= ?", id);
    }

    @Override
    public BorrowingEntity get(Integer id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM borrowing WHERE id = ?", id);
        if(rst.next()){
            BorrowingEntity borrowingEntity=new BorrowingEntity(rst.getInt("id"),rst.getInt("book_id"),rst.getInt("member_id"),rst.getDate("borrow_date"),rst.getDate("due_date"),rst.getDate("return_date"),rst.getBigDecimal("fine"));
            return borrowingEntity;
        }
        return null;
    }

    @Override
    public ArrayList<BorrowingEntity> getAll() throws Exception {
        ArrayList<BorrowingEntity> borrowingkEntities=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM borrowing");
        while(rst.next()){
            BorrowingEntity borrowingEntity=new BorrowingEntity(rst.getInt("id"),rst.getInt("book_id"),rst.getInt("member_id"),rst.getDate("borrow_date"),rst.getDate("due_date"),rst.getDate("return_date"),rst.getBigDecimal("fine"));
            
            borrowingkEntities.add(borrowingEntity);
        }
        return borrowingkEntities;
    }
}
