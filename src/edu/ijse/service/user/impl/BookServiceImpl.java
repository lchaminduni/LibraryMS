/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.user.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.Interfaces.BookDao;
import edu.ijse.db.DBConnection;
import edu.ijse.dto.BookDto;
import edu.ijse.entity.BookEntity;
import edu.ijse.service.user.BookService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class BookServiceImpl implements BookService{
    private BookDao bookDao = (BookDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOKS);

    @Override
    public String save(BookDto bookDto) throws Exception {
        BookEntity bookEntity = getBookEntity(bookDto);
        return bookDao.save(bookEntity) ? "Success" : "Fail";
    }

    @Override
    public String update(BookDto bookDto) throws Exception {
        BookEntity bookEntity = getBookEntity(bookDto);
        return bookDao.update(bookEntity) ? "Success" : "Fail";
    }

    @Override
    public String delete(int bookId) throws Exception {
        return bookDao.delete(bookId) ? "Success" : "Fail";
    }

    @Override
    public BookDto get(int bookId) throws Exception {
        BookEntity bookEntity = bookDao.get(Integer.valueOf(bookId)); // Change this line to use the correct method
        if (bookEntity != null) {
            return getBookDto(bookEntity);
        }
        return null;
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList<BookEntity> bookEntities = bookDao.getAll();
        if (bookEntities != null && !bookEntities.isEmpty()) {
            ArrayList<BookDto> bookDtos = new ArrayList<>();

            for (BookEntity bookEntity : bookEntities) {
                bookDtos.add(getBookDto(bookEntity));
            }
            return bookDtos;
        }
        return null;
    }
    
    private BookEntity getBookEntity(BookDto bookDto) {
        return new BookEntity(bookDto.getBookId(),bookDto.getTitle(),bookDto.getAuthor(),bookDto.getCategoryId());
    }
    private BookDto getBookDto(BookEntity bookEntity) {
        return new BookDto(bookEntity.getBookId(),bookEntity.getTitle(),bookEntity.getAuthor(),bookEntity.getCategoryId());
    }

    @Override
    public boolean bookExists(int book_id) throws Exception {
        String query = "SELECT COUNT(*) FROM book WHERE id = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, book_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("An error occurred while checking if the book exists", e);
        }
        return true;
    }
}
