/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.Controller;


import edu.ijse.dao.Interfaces.CategoryDao;
import edu.ijse.dto.BookDto;
import edu.ijse.service.ServiceFactory;
import edu.ijse.service.user.BookService;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class BookController {
    private ArrayList<BookDto> bookDtos;

    public BookController() {
        bookDtos = new ArrayList<>(); // Initialize with an empty list or fetch from data source
    }
    private BookService bookService=(BookService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOKS);
    
    public String saveBook(BookDto bookDto)throws Exception{
        return bookService.save(bookDto);
    }
    
    public String updateBook(BookDto bookDto)throws Exception{
        return bookService.update(bookDto);
    }
    
    public String deleteBook(int bookId)throws Exception{
        return bookService.delete(bookId);
    }
    
    public ArrayList<BookDto> getAllBooks() throws Exception{
        return bookService.getAll();
    }
    
    public BookDto get(int bookId) throws Exception{
        return bookService.get(bookId);
    }
    
    
}
