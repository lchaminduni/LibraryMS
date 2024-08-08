/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.ijse.service.user;

import edu.ijse.dto.UserDto;
import edu.ijse.service.SuperService;

/**
 *
 * @author Lihini
 */
public interface UserService extends SuperService{
    public UserDto getUser(int password)throws Exception;
}
