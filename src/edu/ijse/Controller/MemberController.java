/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.Controller;

import edu.ijse.dto.MemberDto;
import edu.ijse.service.ServiceFactory;
import edu.ijse.service.user.MemberService;
import java.util.ArrayList;

/**
 *
 * @author Lihini
 */
public class MemberController {
    private ArrayList<MemberDto> memberDtos;

    public MemberController() {
         memberDtos = new ArrayList<>(); // Initialize with an empty list or fetch from data source
    }
    private MemberService memberService=(MemberService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.MEMBER);
    
    public String addMember(MemberDto memberDto)throws Exception{
        return memberService.add(memberDto);
    }
    
    public String updateMember(MemberDto memberDto)throws Exception{
        return memberService.update(memberDto);
    }
    
    public String deleteMember(int id)throws Exception{
        return memberService.delete(id);
    }
    
    public ArrayList<MemberDto> getAllMembers() throws Exception{
        return memberService.getAll();
    }
    
    public MemberDto get(int id) throws Exception{
        return memberService.get(id);
    }
    
}
