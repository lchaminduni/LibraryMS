/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.service.user.impl;

import edu.ijse.dao.DaoFactory;
import edu.ijse.dao.Interfaces.MemberDao;
import edu.ijse.db.DBConnection;
import edu.ijse.dto.MemberDto;
import edu.ijse.entity.MemberEntity;
import edu.ijse.service.user.MemberService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class MemberServiceImpl implements MemberService{
    private MemberDao memberDao = (MemberDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.MEMBER);

    @Override
    public String add(MemberDto memberDto) throws Exception {
        MemberEntity memberEntity = getMemberEntity(memberDto);
        return memberDao.save(memberEntity) ? "Success" : "Fail";
    }

    @Override
    public String update(MemberDto memberDto) throws Exception {
        MemberEntity memberEntity = getMemberEntity(memberDto);
        return memberDao.update(memberEntity) ? "Success" : "Fail";
    }

    @Override
    public String delete(int id) throws Exception {
        return memberDao.delete(id) ? "Success" : "Fail";
    }

    @Override
    public MemberDto get(int id) throws Exception {
        MemberEntity memberEntity = memberDao.get(id); // Change this line to use the correct method
        if (memberEntity != null) {
            return getMemberDto(memberEntity);
        }
        return null;
    }

    @Override
    public ArrayList<MemberDto> getAll() throws Exception {
        ArrayList<MemberEntity> memberEntities = memberDao.getAll();
        if (memberEntities != null && !memberEntities.isEmpty()) {
            ArrayList<MemberDto> memberDtos = new ArrayList<>();

            for (MemberEntity memberEntity : memberEntities) {
                memberDtos.add(getMemberDto(memberEntity));
            }
            return memberDtos;
        }
        return null;
    }

    private MemberEntity getMemberEntity(MemberDto memberDto) {
        return new MemberEntity(memberDto.getId(),memberDto.getName(),memberDto.getEmail());
    }

    private MemberDto getMemberDto(MemberEntity memberEntity) {
        return new MemberDto(memberEntity.getId(),memberEntity.getName(),memberEntity.getEmail());
    }

    @Override
    public boolean memberExists(int id) throws Exception {
        String query = "SELECT COUNT(*) FROM member WHERE id = ?";
        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("An error occurred while checking if the member exists", e);
        }
        return false;
    }

    
    
}
