/**
 * auto-generated code
 * Tue Oct 13 09:42:25 CST 2009
 */
 package com.gmcc.pboss.web.sales.realtimeamt;

import java.util.LinkedList;
import java.util.List;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtDBParam;
import com.gmcc.pboss.business.sales.realtimeamt.RealtimeamtVO;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.realtimeamt.Realtimeamt;
import com.gmcc.pboss.web.channel.way.WayWebParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: RealtimeamtAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RealtimeamtAction extends BaseAction{
	private List<RealtimeamtForm> realtimeamtList = new LinkedList<RealtimeamtForm>();
	public RealtimeamtAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RealtimeamtForm());
		this.setParam(new RealtimeamtWebParam());

        //ָ��VO��
        setClsVO(RealtimeamtVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"wayid"};
		this.setClsControl(Realtimeamt.class);
		this.setClsQueryParam(RealtimeamtDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doList() throws Exception{
		super.doList();
		DataPackage dp = getDp();
		List<RealtimeamtVO> list = dp.getDatas();

		String wayname = new String();
		for(RealtimeamtVO realtimeamtVO:list)
		{
			RealtimeamtForm realtimeamtForm = new RealtimeamtForm();
			BeanUtils.copyProperties(realtimeamtForm, realtimeamtVO);
			WayBO way = (WayBO)BOFactory.build(WayBO.class,getDBAccessUser());
			WayWebParam param = new WayWebParam();
			param.set_se_wayid(realtimeamtVO.getWayid());
			dp = way.doQuery(param);
			
			if(dp.getRowCount()>0)
			{
				wayname = ((WayVO)dp.getDatas().get(0)).getWayname();
				realtimeamtForm.setWayname(wayname);
			}
			realtimeamtList.add(realtimeamtForm);
		}
		
		return WEB_RESULT_LIST;
	}

	public List<RealtimeamtForm> getRealtimeamtList() {
		return realtimeamtList;
	}

	public void setRealtimeamtList(List<RealtimeamtForm> realtimeamtList) {
		this.realtimeamtList = realtimeamtList;
	}
}