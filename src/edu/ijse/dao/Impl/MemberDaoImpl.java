/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.dao.Impl;

import edu.ijse.dao.CrudUtil;
import edu.ijse.dao.Interfaces.MemberDao;
import edu.ijse.entity.MemberEntity;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class MemberDaoImpl implements MemberDao{

    @Override
    public boolean save(MemberEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO member VALUES (?,?,?)",t.getId(),t.getName(),t.getEmail());
    }

    @Override
    public boolean update(MemberEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE member SET name = ?, email = ? WHERE id=?",t.getName(),t.getEmail(),t.getId());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM member WHERE id= ?", id);
    }

    @Override
    public MemberEntity get(Integer id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM member WHERE id = ?", id);
        if(rst.next()){
            MemberEntity memberEntity=new MemberEntity(rst.getInt("id"),rst.getString("name"),rst.getString("email"));
            return memberEntity;
        }
        return null;
    }

    @Override
    public ArrayList<MemberEntity> getAll() throws Exception {
        ArrayList<MemberEntity> memberEntities=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM member");
        while(rst.next()){
            MemberEntity memberEntity=new MemberEntity(rst.getInt("id"),rst.getString("name"),rst.getString("email"));
            
            memberEntities.add(memberEntity);
        }
        return memberEntities;
    }
    
}
