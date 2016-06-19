/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.service;

import com.po.entity.admin.PoMenuDTO;
import com.po.entity.admin.PoMenuResult;
import com.po.resp.MsgResp;
import static com.po.service.BaseService.pool;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucky Bear
 */
public class MenuService extends BaseService implements IConstants {
    
    private final PoMenuResult result = new PoMenuResult();
    
    public MsgResp getListAllMenu() {
        MsgResp resp = new MsgResp();
        Connection conn = null;
        try {
            conn = pool.getConnection();
            startTransaction(conn);
            String sqlFile = MENU_SQL_FOLDER + "slc_all_menu.sql";
            List<PoMenuDTO> list = (List<PoMenuDTO>) baseDAO.getListBeanBySqlFile(conn, sqlFile, result);
            setMsgResp(resp, 0, list);
            endTransaction(conn);
        } catch (Exception ex) {
            rollback(conn);
            setMsgResp(resp, 0, null);
            logger.error(ex);
        }
        return resp;
    }
    
    public MsgResp getListMenuByUser(long userId) {
        MsgResp resp = new MsgResp();
        Connection conn = null;
        try {
            conn = pool.getConnection();
            startTransaction(conn);
            String sqlFile = MENU_SQL_FOLDER + "slc_menu_by_user.sql";
            List params = new ArrayList();
            params.add(userId);
            List<PoMenuDTO> list = (List<PoMenuDTO>) baseDAO.getListBeanBySqlFile(conn, sqlFile, params, result);
            setMsgResp(resp, 0, list);
            endTransaction(conn);
        } catch (Exception ex) {
            rollback(conn);
            setMsgResp(resp, 1, null);
            logger.error(ex);
        }
        return resp;
    }
    
}
