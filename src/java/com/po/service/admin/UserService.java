/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.service.admin;

import com.po.entity.admin.UserDTO;
import com.po.entity.admin.UserResult;
import com.po.resp.MsgResp;
import com.po.service.BaseService;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Lucky Bear
 */
public class UserService extends BaseService {
    
    private final UserResult result = new UserResult();
    
    public MsgResp getListUsers() {
        MsgResp resp = new MsgResp();
        Connection conn = null;
        try {
            conn = pool.getConnection();
            startTransaction(conn);
            List<UserDTO> list = (List<UserDTO>) baseDAO.getListBeanBySql(conn, "select * from users", result);
            resp.getRespContent().put(DATA, list);
            setMsgResp(resp, 0, list);
            endTransaction(conn);
        } catch (Exception ex) {
            rollback(conn);
            logger.error(ex);
        }
        return resp;
    }
    
}
