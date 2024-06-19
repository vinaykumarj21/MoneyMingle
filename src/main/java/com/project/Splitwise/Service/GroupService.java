package com.project.Splitwise.Service;

import com.project.Splitwise.DTO.GroupDTO;
import com.project.Splitwise.DTO.TransactionDTO;
import com.project.Splitwise.Exception.GroupNotFoundException;

import java.util.List;

public interface GroupService {
    List<TransactionDTO>settleUpByGroupId(int groupId) throws GroupNotFoundException;
    double totalAmountSpentByUsers(int groupId) throws GroupNotFoundException;
    GroupDTO createGroup(GroupDTO groupDTO);
}
