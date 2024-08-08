/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.Controller;

import edu.ijse.dto.BookCategoryDto;
import edu.ijse.service.ServiceFactory;
import edu.ijse.service.user.CategoryService;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class CategoryController {
    private ArrayList<BookCategoryDto> categories;

    public CategoryController() {
        categories = new ArrayList<>(); // Initialize with an empty list or fetch from data source
    }
    private CategoryService categoryService=(CategoryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORIES);
    public String saveCategory(BookCategoryDto categoryDto)throws Exception{
        return categoryService.add(categoryDto);
    }
    
    public String updateCategory(BookCategoryDto categoryDto)throws Exception{
        return categoryService.update(categoryDto);
    }
    
    public String deleteCategory(String Id)throws Exception{
        return categoryService.delete(Id);
    }
    
    public ArrayList<BookCategoryDto> getAllCategories() throws Exception{
        return categoryService.getAll();
        
    }
    
    public BookCategoryDto get(int id) throws Exception{
        return categoryService.get(id);
    }
}
