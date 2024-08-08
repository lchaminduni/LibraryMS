/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.user;


import edu.ijse.dto.BookDto;
import edu.ijse.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public interface BookService extends SuperService{
    String save (BookDto bookDto) throws Exception;
    String update (BookDto bookDto) throws Exception;
    String delete (int bookId) throws Exception;
    BookDto get(int bookId) throws Exception;
    ArrayList<BookDto> getAll() throws Exception;
    
    boolean bookExists(int bookId) throws Exception;
}
