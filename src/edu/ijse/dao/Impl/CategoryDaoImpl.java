/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao.Impl;

import edu.ijse.dao.CrudUtil;
import edu.ijse.dao.Interfaces.CategoryDao;
import edu.ijse.entity.CategoryEntity;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Lihini
 */
public class CategoryDaoImpl implements CategoryDao{

    
    @Override
    public boolean save(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO book_category VALUES (?,?)", t.getId(),t.getName());
    }

    
    @Override
    public boolean update(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE book_category SET name=? WHERE id=?",t.getName(),t.getId());
    }
    
    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM book_category");
        while(rst.next()){
            CategoryEntity entity=new CategoryEntity(rst.getInt("id"), rst.getString("name"));
            
            categoryEntities.add(entity);
        }
        return categoryEntities;
    }

    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM book_category WHERE id= ?", id);
    }

    public CategoryEntity get(Integer id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM book_category WHERE id = ?", id);
        if(rst.next()){
            CategoryEntity entity=new CategoryEntity(rst.getInt("id"),rst.getString("name"));
            
            return entity;
        }
        return null;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM book_category WHERE id= ?", id);
    }

    @Override
    public CategoryEntity get(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM book_category WHERE id = ?", id);
        if(rst.next()){
            CategoryEntity entity=new CategoryEntity(rst.getInt("id"),rst.getString("name"));
            
            return entity;
        }
        return null;
    }

    
}
