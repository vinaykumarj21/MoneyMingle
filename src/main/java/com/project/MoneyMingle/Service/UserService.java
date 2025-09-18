package com.project.MoneyMingle.Service;

import com.project.MoneyMingle.DTO.GroupDTO;
import com.project.MoneyMingle.DTO.UserDTO;
import com.project.MoneyMingle.Exception.GroupNotFoundException;
import com.project.MoneyMingle.Exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    UserDTO getUserById(int userId) throws UserNotFoundException;
    //finding the GroupInformation of a Particular user with UserId
    List<GroupDTO> getGroupsOfUser(int userId) throws UserNotFoundException;
    void addUserToGroup(int userId, int groupId)throws UserNotFoundException, GroupNotFoundException;
    UserDTO registerUser(UserDTO userDTO);
}
