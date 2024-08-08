/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Lihini
 */
public class BorrowingEntity {
    private int id;
    private int book_id;
    private int member_id;
    private Date borrow_date;
    private Date due_date;
    private Date return_date;
    private BigDecimal fine;

    public BorrowingEntity() {
    }

    public BorrowingEntity(int id, int book_id, int member_id, Date borrow_date, Date due_date, Date return_date, BigDecimal fine) {
        this.id = id;
        this.book_id = book_id;
        this.member_id = member_id;
        this.borrow_date = borrow_date;
        this.due_date = due_date;
        this.return_date = return_date;
        this.fine = fine;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the book_id
     */
    public int getBook_id() {
        return book_id;
    }

    /**
     * @param book_id the book_id to set
     */
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    /**
     * @return the member_id
     */
    public int getMember_id() {
        return member_id;
    }

    /**
     * @param member_id the member_id to set
     */
    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    /**
     * @return the borrow_date
     */
    public Date getBorrow_date() {
        return borrow_date;
    }

    /**
     * @param borrow_date the borrow_date to set
     */
    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    /**
     * @return the due_date
     */
    public Date getDue_date() {
        return due_date;
    }

    /**
     * @param due_date the due_date to set
     */
    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    /**
     * @return the return_date
     */
    public Date getReturn_date() {
        return return_date;
    }

    /**
     * @param return_date the return_date to set
     */
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    /**
     * @return the fine
     */
    public BigDecimal getFine() {
        return fine;
    }

    /**
     * @param fine the fine to set
     */
    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "BorrowingEntity{" + "id=" + id + ", book_id=" + book_id + ", member_id=" + member_id + ", borrow_date=" + borrow_date + ", due_date=" + due_date + ", return_date=" + return_date + ", fine=" + fine + '}';
    }
    
    

}
