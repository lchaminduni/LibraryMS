/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.user;

import edu.ijse.dto.BookCategoryDto;
import edu.ijse.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public interface CategoryService extends SuperService{
    String add (BookCategoryDto categoryDto) throws Exception;
    String update (BookCategoryDto categoryDto) throws Exception;
    String delete (String id) throws Exception;
    BookCategoryDto get(int id) throws Exception;
    ArrayList<BookCategoryDto> getAll() throws Exception;
    
    boolean categoryExists(int categoryId) throws Exception;
}
