/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.service.admin;

import com.po.entity.admin.GroupUserDTO;
import com.po.entity.admin.GroupUserResult;
import com.po.resp.MsgResp;
import com.po.service.BaseService;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Lucky Bear
 */
public class GroupUserService extends BaseService {
    
    private final GroupUserResult result = new GroupUserResult();
    
    public MsgResp getListGroupUsers() {
        MsgResp resp = new MsgResp();
        Connection conn = null;
        try {
            conn = pool.getConnection();
            startTransaction(conn);
            List<GroupUserDTO> list = (List<GroupUserDTO>) baseDAO.getListBeanBySql(conn, "select * from group_users", result);
            setMsgResp(resp, 0, list);
            endTransaction(conn);
        } catch (Exception ex) {
            rollback(conn);
            logger.error(ex);
        }
        return resp;
    }
}
