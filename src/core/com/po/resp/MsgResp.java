/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.po.resp;

import java.util.Map;

/**
 *
 * @author Lucky Bear
 */
public class MsgResp {
    // code: int
    private int respCode;
    
    // message : String
    private String respDesc;
    
    // content : List, Object
    Map<String, Object> respContent;

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public Map<String, Object> getRespContent() {
        return respContent;
    }

    public void setRespContent(Map<String, Object> respContent) {
        this.respContent = respContent;
    }
    
}
