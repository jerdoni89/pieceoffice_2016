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

/**
 *
 * @author Lucky Bear
 */
public class PoMenuResult extends BaseResult {

    @Override
    public BaseDTO getBeanFromResultSet(ResultSet rs) throws SQLException {
        PoMenuDTO dto = new PoMenuDTO();
        if (rs != null && rs.next()) {
            loadDtoFromResult(dto, rs);
        }
        return dto;
    }

    @Override
    public List<? extends BaseDTO> getListFromResultSet(ResultSet rs) throws SQLException {
        List<PoMenuDTO> list = new ArrayList<>();
        PoMenuDTO dto;
        while (rs != null && rs.next()) {
            dto = new PoMenuDTO();
            loadDtoFromResult(dto, rs);
            list.add(dto);
        }
        return list;
    }

    private void loadDtoFromResult(PoMenuDTO dto, ResultSet rs) throws SQLException {
        dto.setMenu_id(rs.getLong("menu_id"));
        dto.setMenu_name(rs.getString("menu_name"));
        dto.setMenu_icon(rs.getString("menu_icon"));
        dto.setParent_id(rs.getLong("parent_id"));
        dto.setPage_id(rs.getLong("page_id"));
        dto.setMenu_order(rs.getInt("menu_order"));
        dto.setDescriptions(rs.getString("descriptions"));
        dto.setLanguage(rs.getString("language"));
        dto.setApp_id(rs.getInt("app_id"));
        dto.setVisible(rs.getInt("visible"));
        dto.setPage_name(rs.getString("page_name"));
        dto.setPage_uri(rs.getString("page_uri"));
        dto.setPage_bean(rs.getString("page_bean"));
    }

}
