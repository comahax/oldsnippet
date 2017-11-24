package com.sunrise.jop.infrastructure.db;

import java.io.*;
import java.util.*;

import org.apache.commons.beanutils.*;

/**
 * <p>Title: GDIBOSS</p>
 * <p/>
 * <p>Description: һ���ѯ���صĽ���� </p>
 * <p/>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p/>
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author HuangBaiming
 * @version 1.0
 */
public class DataPackage implements Serializable {
    private int rowCount;
    private int pageSize;
    private int pageNo;
    
    private List datas;

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List getDatas() {
        return datas;
    }

    public void setDatas(List datas) {
        this.datas = datas;
    }

    public int getTotalPage(){
    	if( getPageSize() == 0) //���pagesizeΪ0����ʾ����ҳ��ֻ��1ҳ��
    		return 1;
    	else
    		return (int) Math.ceil(((double) getRowCount()) / ((double) getPageSize()));
    }
    
    /**
     * ��DataPackage��Dataת��Ϊָ��������Class cls��List
     * @param cls ��ת��Ϊ�������͵�List
     */
    public List toList(Class cls) {
        List list = new ArrayList();
        for (Iterator it = getDatas().iterator(); it.hasNext();) {
            Object o = (Object) it.next();
            try {
                Object obj = cls.newInstance();
                BeanUtils.copyProperties(obj, o);
                list.add(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
