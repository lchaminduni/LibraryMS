/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.user;

import edu.ijse.dto.MemberDto;
import edu.ijse.service.SuperService;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public interface MemberService extends SuperService{
    String add(MemberDto memberDto) throws Exception;
    String update(MemberDto memberDto) throws Exception;
    String delete(int id) throws Exception;
    MemberDto get(int id) throws Exception;
    ArrayList<MemberDto> getAll() throws Exception;
    
    boolean memberExists(int id) throws Exception;
}
