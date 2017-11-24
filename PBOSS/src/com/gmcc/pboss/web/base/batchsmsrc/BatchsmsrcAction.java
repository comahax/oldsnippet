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
	
	// 短信编码
	public static final Map SmsCodeMap = new HashMap();
	static {
		for (int i = 1; i <= 9; i++) {
			SmsCodeMap.put("CJ_03"+i, "CJ_03"+i);
		}
	}
	
	public BatchsmsrcAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new BatchsmsrcForm());
		this.setParam(new BatchsmsrcDBParam());

        //指定VO类
        setClsVO(BatchsmsrcVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"mobile","smscode"};
		this.setClsControl(Batchsmsrc.class);
		this.setClsQueryParam(BatchsmsrcDBParam.class) ;

	}
	
	@Override
	public String doSave() throws Exception {
		try {
			
			BatchsmsrcForm form = (BatchsmsrcForm) super.getForm();
			// 短信编码
			SmstmplBO bo = (SmstmplBO) BOFactory.build(SmstmplBO.class,super.getDBAccessUser());
			if (bo.doFindByPk(form.getSmscode()) == null) {
				throw new Exception("短信编码在短信模板表中不存在。");
			}
			if (SmsCodeMap.get(form.getSmscode()) == null) {
				throw new Exception("不是CJ_031~CJ_039之间的短信编码。");
			}
			// 发送时间
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