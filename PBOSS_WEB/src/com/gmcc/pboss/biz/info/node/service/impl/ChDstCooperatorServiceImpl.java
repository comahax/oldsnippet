package com.gmcc.pboss.biz.info.node.service.impl;

import org.apache.log4j.Logger;

import com.gmcc.pboss.biz.info.node.model.ChDstCooperator;
import com.gmcc.pboss.biz.info.node.dao.ChDstCooperatorDao;
import com.gmcc.pboss.biz.info.node.service.ChDstCooperatorService;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;

public class ChDstCooperatorServiceImpl extends BaseServiceImpl implements
		ChDstCooperatorService {
	/**
	 * ע��Dao�ӿ�
	 */
	private ChDstCooperatorDao chDstCooperatorDao;
	public void setChDstCooperatorDao(ChDstCooperatorDao chDstCooperatorDao){
		this.chDstCooperatorDao = chDstCooperatorDao;
	}
	public ChDstCooperatorDao getChDstCooperatorDao(){
		return this.chDstCooperatorDao;
	}
	
	/**
	 * ���ݵ�½�û�������id��ѯ��Ӧ�ķ���������cooperator
	 * @param wayid ����id
	 * @return      ������
	 */
	public ChDstCooperator getByWayid(String wayid){
		return this.chDstCooperatorDao.getByWayid(wayid);
	}

}
