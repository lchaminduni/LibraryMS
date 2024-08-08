/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao.Impl;

import com.sun.jdi.connect.spi.Connection;
import edu.ijse.dao.CrudUtil;
import edu.ijse.dao.Interfaces.BookDao;
import edu.ijse.entity.BookEntity;


import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Lihini
 */
public class BookDaoImpl implements BookDao{
    
    @Override
    public boolean update(BookEntity be) throws Exception {
        return CrudUtil.executeUpdate("UPDATE book SET title = ?, author = ?, category_id = ? WHERE id=?",be.getTitle(),be.getAuthor(),be.getCategoryId(),be.getBookId());
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM book");
        while(rst.next()){
            BookEntity bookEntity=new BookEntity(rst.getInt("id"),rst.getString("title"),rst.getString("author"),rst.getInt("category_id"));
            
            bookEntities.add(bookEntity);
        }
        return bookEntities;
    }

    @Override
    public boolean save(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO book VALUES (?,?,?,?)",t.getBookId(),t.getTitle(),t.getAuthor(),t.getCategoryId());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM book WHERE id= ?", id);
    }

    @Override
    public BookEntity get(Integer id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM book WHERE id = ?", id);
        if(rst.next()){
            BookEntity bookEntity=new BookEntity(rst.getInt("id"),rst.getString("title"),rst.getString("author"),rst.getInt("category_id"));
            return bookEntity;
        }
        return null;
    }

    

    
}
