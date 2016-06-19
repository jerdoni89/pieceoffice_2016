/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.entity.admin;

import com.po.entity.BaseDTO;
import com.po.entity.BaseResult;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucky Bear
 */
public class GroupUserResult extends BaseResult {

    @Override
    public BaseDTO getBeanFromResultSet(ResultSet rs) throws SQLException {
        GroupUserDTO dto = new GroupUserDTO();
        if (rs != null && rs.next()) {
            loadDtoFromResult(dto, rs);
        }
        return dto;
    }

    @Override
    public List<? extends BaseDTO> getListFromResultSet(ResultSet rs) {
        List<GroupUserDTO> list = new ArrayList<>();
        GroupUserDTO dto;
        try {
            while (rs != null && rs.next()) {
                dto = new GroupUserDTO();
                loadDtoFromResult(dto, rs);
                list.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserResult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private void loadDtoFromResult(GroupUserDTO dto, ResultSet rs) throws SQLException {
        dto.setGroupId(rs.getLong("group_id"));
        dto.setGroupName(rs.getString("group_name"));
        dto.setDescription(rs.getString("descriptions"));
        dto.setStatus(rs.getInt("status"));
    }
}
