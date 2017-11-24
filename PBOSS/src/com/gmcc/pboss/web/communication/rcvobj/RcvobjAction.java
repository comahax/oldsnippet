/**
 * auto-generated code
 * Tue Sep 29 10:15:34 CST 2009
 */
 package com.gmcc.pboss.web.communication.rcvobj;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoDBParam;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjDBParam;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.control.communication.rcvobj.Rcvobj;
import com.gmcc.pboss.control.communication.rcvobj.RcvobjBO;
import com.gmcc.pboss.web.communication.reply.ReplyWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: RcvobjAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RcvobjAction extends BaseAction{
	
	public RcvobjAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RcvobjForm());
		
		RcvobjWebParam param = new RcvobjWebParam();
		param.set_orderby("rvcobjid");
		param.set_desc("1");
		this.setParam(param);

        //ָ��VO��
        setClsVO(RcvobjVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"rvcobjid"};
		this.setClsControl(Rcvobj.class);
		this.setClsQueryParam(RcvobjDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		Rcvobj rcvobj = (Rcvobj)BOFactory.build(RcvobjBO.class,getDBAccessUser());
		RcvobjDBParam param = (RcvobjDBParam)getParam();
		AdvinfoDBParam param2 = new AdvinfoDBParam();
		
		List<RcvobjVO> rcvobjList = new LinkedList<RcvobjVO>();
		String title = param.getTitle();
		//���ڱ����ѯ����
		if(!StringUtils.isEmpty(title)){
			param2.set_sk_title(param.getTitle());
			Class[] clazz = new Class[]{RcvobjVO.class,AdvinfoVO.class};
			Object[] params = new Object[] { param, param2 };
			String[][] joins = new String[][] { { "advinfoid", "advinfoid" } };
			
			DataPackage dp = rcvobj.doUnionQuery(params, clazz, joins);;
			List<Object[]> unionList = dp.getDatas();
			AdvinfoVO advinfoVO = new AdvinfoVO();
			for(Object[] objs:unionList)
			{
				RcvobjVO rcvobjVO = (RcvobjVO)objs[0];
				rcvobjList.add(rcvobjVO);
			}
			dp.setDatas(rcvobjList);
			setDp(dp);
		}
		//�����ڱ����ѯ����
		else{
			super.doList();
			rcvobjList = getDp().getDatas();
		}

		//���ñ���
		for(RcvobjVO rcvobjVO : rcvobjList)
		{
			AdvinfoVO advinfoVO = rcvobj.doGetAdvinfoByAdvinfoid(String.valueOf(rcvobjVO.getAdvinfoid()));
			if(null!=advinfoVO){
				rcvobjVO.setTitle(advinfoVO.getTitle());
			}
		}

		return WEB_RESULT_LIST;
	}
}