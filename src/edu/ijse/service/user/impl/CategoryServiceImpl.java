/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.user.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.Interfaces.CategoryDao;
import edu.ijse.db.DBConnection;
import edu.ijse.dto.BookCategoryDto;
import edu.ijse.entity.CategoryEntity;
import edu.ijse.service.user.CategoryService;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class CategoryServiceImpl implements CategoryService{
    private CategoryDao categoryDao = (CategoryDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CATEGORIES);

    @Override
    public String add(BookCategoryDto categoryDto) throws Exception {
        CategoryEntity categoryEntity = getCategoryEntity(categoryDto);
        return categoryDao.save(categoryEntity) ? "Success" : "Fail";
    }

    @Override
    public String update(BookCategoryDto categoryDto) throws Exception {
        CategoryEntity categoryEntity = getCategoryEntity(categoryDto);
        return categoryDao.update(categoryEntity) ? "Success" : "Fail";
    }

    @Override
    public String delete(String id) throws Exception {
        return categoryDao.delete(id) ? "Success" : "Fail";
    }

    @Override
    public BookCategoryDto get(int id) throws Exception {
        CategoryEntity categoryEntity = categoryDao.get(String.valueOf(id)); // Change this line to use the correct method
        if (categoryEntity != null) {
            return getBookCategoryDto(categoryEntity);
        }
        return null;
    }

    @Override
    public ArrayList<BookCategoryDto> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities = categoryDao.getAll();
        if (categoryEntities != null && !categoryEntities.isEmpty()) {
            ArrayList<BookCategoryDto> categoryDtos = new ArrayList<>();

            for (CategoryEntity categoryEntity : categoryEntities) {
                categoryDtos.add(getBookCategoryDto(categoryEntity));
            }
            return categoryDtos;
        }
        return null;
    }

    private CategoryEntity getCategoryEntity(BookCategoryDto categoryDto) {
        return new CategoryEntity(categoryDto.getId(), categoryDto.getName());
    }

    private BookCategoryDto getBookCategoryDto(CategoryEntity categoryEntity) {
        return new BookCategoryDto(categoryEntity.getId(), categoryEntity.getName());
    }

    @Override
    public boolean categoryExists(int category_id) throws Exception {
        String query = "SELECT COUNT(*) FROM book_category WHERE id = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, category_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("An error occurred while checking if the category exists", e);
        }
        return false;
    }
}
