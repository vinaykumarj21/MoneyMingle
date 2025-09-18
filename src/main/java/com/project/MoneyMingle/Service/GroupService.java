package com.project.MoneyMingle.Service;

import com.project.MoneyMingle.DTO.GroupDTO;
import com.project.MoneyMingle.DTO.TransactionDTO;
import com.project.MoneyMingle.Exception.GroupNotFoundException;

import java.util.List;

public interface GroupService {
    List<TransactionDTO>settleUpByGroupId(int groupId) throws GroupNotFoundException;
    double totalAmountSpentByUsers(int groupId) throws GroupNotFoundException;
    GroupDTO createGroup(GroupDTO groupDTO);
}
