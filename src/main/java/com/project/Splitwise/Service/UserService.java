package com.project.Splitwise.Service;

import com.project.Splitwise.DTO.GroupDTO;
import com.project.Splitwise.DTO.UserDTO;
import com.project.Splitwise.Exception.GroupNotFoundException;
import com.project.Splitwise.Exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    UserDTO getUserById(int userId) throws UserNotFoundException;
    //finding the GroupInformation of a Particular user with UserId
    List<GroupDTO> getGroupsOfUser(int userId) throws UserNotFoundException;
    void addUserToGroup(int userId, int groupId)throws UserNotFoundException, GroupNotFoundException;
    UserDTO registerUser(UserDTO userDTO);
}
