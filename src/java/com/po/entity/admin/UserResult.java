/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.entity.admin;

import com.po.entity.BaseDTO;
import com.po.entity.BaseResult;
import com.po.util.DateTimeUtil;
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
public class UserResult extends BaseResult {

    
    @Override
    public BaseDTO getBeanFromResultSet(ResultSet rs) {
        UserDTO dto = new UserDTO();
        try {
            if (rs != null && rs.next()) {
                loadDTOFromResult(dto, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserResult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dto;
    }

    @Override
    public List<? extends BaseDTO> getListFromResultSet(ResultSet rs) {
        List<UserDTO> list = new ArrayList<>();
        UserDTO dto;
        try {
            while (rs != null && rs.next()) {
                dto = new UserDTO();
                loadDTOFromResult(dto, rs);
                list.add(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserResult.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private void loadDTOFromResult(UserDTO dto, ResultSet rs) throws SQLException {
        dto.setUserId(rs.getLong("user_id"));
        dto.setUserName(rs.getString("user_name"));
        dto.setPassword(rs.getString("password"));
        dto.setFullName(rs.getString("full_name"));
        dto.setEmail(rs.getString("email"));
        dto.setPhone(rs.getString("phone"));
        dto.setBirthday(DateTimeUtil.toUtilDate(rs.getDate("birthday")));
        dto.setGender(rs.getInt("gender"));
        dto.setStatus(rs.getInt("status"));
        dto.setGroupId(rs.getLong("group_id"));
    }
}
