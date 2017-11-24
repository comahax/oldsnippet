/**
 * auto-generated code
 * Fri May 20 16:28:47 CST 2011
 */
 package com.gmcc.pboss.web.base.batchsmsrc;

import java.util.HashMap;
import java.util.Map;

import com.gmcc.pboss.business.base.batchsmsrc.BatchsmsrcDBParam;
import com.gmcc.pboss.business.base.batchsmsrc.BatchsmsrcVO;
import com.gmcc.pboss.control.base.batchsmsrc.Batchsmsrc;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: BatchsmsrcAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public class BatchsmsrcAction extends BaseAction{
	
	// ���ű���
	public static final Map SmsCodeMap = new HashMap();
	static {
		for (int i = 1; i <= 9; i++) {
			SmsCodeMap.put("CJ_03"+i, "CJ_03"+i);
		}
	}
	
	public BatchsmsrcAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new BatchsmsrcForm());
		this.setParam(new BatchsmsrcDBParam());

        //ָ��VO��
        setClsVO(BatchsmsrcVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"mobile","smscode"};
		this.setClsControl(Batchsmsrc.class);
		this.setClsQueryParam(BatchsmsrcDBParam.class) ;

	}
	
	@Override
	public String doSave() throws Exception {
		try {
			
			BatchsmsrcForm form = (BatchsmsrcForm) super.getForm();
			// ���ű���
			SmstmplBO bo = (SmstmplBO) BOFactory.build(SmstmplBO.class,super.getDBAccessUser());
			if (bo.doFindByPk(form.getSmscode()) == null) {
				throw new Exception("���ű����ڶ���ģ����в����ڡ�");
			}
			if (SmsCodeMap.get(form.getSmscode()) == null) {
				throw new Exception("����CJ_031~CJ_039֮��Ķ��ű��롣");
			}
			// ����ʱ��
			BatchsmsrcCheck timeCheck = new BatchsmsrcCheck();
			timeCheck.check(form.getSdt());
			
			super.doSave();
			
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return "content";
	}
	
}