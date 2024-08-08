/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dto;

/**
 *
 * @author Lihini
 */
public class BookDto {
    private int id;
    private String title;
    private String author;
    private int category_Id;

    public BookDto() {
    }

    public BookDto(int id, String title, String author, int category_Id) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category_Id = category_Id;
    }

    /**
     * @return the bookId
     */
    public int getBookId() {
        return id;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(int bookId) {
        this.id = bookId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return category_Id;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.category_Id = categoryId;
    }

    @Override
    public String toString() {
        return "BookDto{" + "bookId=" + id + ", title=" + title + ", author=" + author + ", categoryId=" + category_Id + '}';
    }
    
    

}
