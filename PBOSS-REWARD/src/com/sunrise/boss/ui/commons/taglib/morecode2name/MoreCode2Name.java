package com.sunrise.boss.ui.commons.taglib.morecode2name;

import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

public interface MoreCode2Name {

    /**
     * MoreCode2NameTag��ǩ���������3������ translateMore��getAllName��getAllCode��
     * MoreCheckTag��ǩ���������4������ getList��getObject��getAllName��getAllCode��
     * @param code Object    Ҫ�������code
     * @return String        �������ַ���
     * @author mys
     */
    public String translateMore(Object code,User user)throws Exception;    
    
    public String getAllName() throws Exception;
    
    public String getAllCode() throws Exception;
    
    
    /**
     * ����morecheck, ��ʾ���б���
     * @param params
     * @throws Exception
     * @author mys
     */
    public Object getList(Object params, User user) throws Exception;
     
    
    /**
     * ����morecheck, ��ʾ���б�,���緵��DataPackage
     * @author mys
     */
    public Object getObject(Object params, User user) throws Exception;
}
