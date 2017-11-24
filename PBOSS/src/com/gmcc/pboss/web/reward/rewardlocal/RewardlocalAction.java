/**
 * auto-generated code
 * Wed Jul 28 14:21:59 CST 2010
 */
 package com.gmcc.pboss.web.reward.rewardlocal;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.reward.rewardlocal.RewardlocalDBParam;
import com.gmcc.pboss.business.reward.rewardlocal.RewardlocalVO;
import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleDBParam;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.reward.rewardlocal.Rewardlocal;
import com.gmcc.pboss.control.reward.rewardlocal.RewardlocalBO;
import com.gmcc.pboss.control.reward.rewardlocaldtl.RewardlocaldtlBO;
import com.gmcc.pboss.control.reward.rewardlocaltitle.Rewardlocaltitle;
import com.gmcc.pboss.control.reward.rewardlocaltitle.RewardlocaltitleBO;
import com.gmcc.pboss.web.reward.rewardlocaldtl.RewardlocaldtlWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: RewardlocalAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocalAction extends BaseAction{
	
	public RewardlocalAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RewardlocalForm());
		this.setParam(new RewardlocalWebParam());

        //ָ��VO��
        setClsVO(RewardlocalVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"rewardid"};
		this.setClsControl(Rewardlocal.class);
		this.setClsQueryParam(RewardlocalDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//�жϱ��س���Ƿ����
	public String doIsExistReward(){
		try{
			RewardlocalDBParam param = (RewardlocalDBParam) super.getParam();
			Rewardlocal rewardlocalBO = (Rewardlocal)BOFactory.build(RewardlocalBO.class,super.getDBAccessUser());
			boolean result =  rewardlocalBO.doIsExistReward(param.get_se_rewardmonth(), param.get_se_rpttype());
			super.getResponse().getWriter().write(""+result);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
			//return "error"+e.getMessage();
		}
		return null;
	}
	
	private String isVisibleReward;
	private String isVisibleLocalReward;
	
	/**
	 * ��ת�������Ż�����Ƿ�ɼ�
	 * @return
	 */
	public String doSetVisible(){
		try{
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,super.getDBAccessUser());
			SysparamVO vo = new SysparamVO();
			vo.setSystemid((long)1);
			vo.setParamtype("pboss_Web");
			isVisibleReward = sysparamBO.doFindByPk(vo).getParamvalue(); 
			vo.setSystemid((long)2);
			isVisibleLocalReward = sysparamBO.doFindByPk(vo).getParamvalue();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	/**
	 * ��������
	 * @return
	 */
	public String doSetVisibleSave(){
		try{
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,super.getDBAccessUser());
			SysparamVO vo1 = new SysparamVO();
			vo1.setSystemid((long)1);
			vo1.setParamtype("pboss_Web");
			vo1 = sysparamBO.doFindByPk(vo1);
			if(isVisibleReward==null){
				isVisibleReward = "0";
			}
			vo1.setParamvalue(isVisibleReward);
			sysparamBO.doUpdate(vo1);
			
			SysparamVO vo2 = new SysparamVO();
			vo2.setSystemid((long)2);
			vo2.setParamtype("pboss_Web");
			vo2  = sysparamBO.doFindByPk(vo2);
			if(isVisibleLocalReward==null){
				isVisibleLocalReward  = "0" ;
			}
			vo2.setParamvalue(isVisibleLocalReward);
			sysparamBO.doUpdate(vo2);
			addActionMessage(getText("success"));
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return SUCCESS;
	}
	
	private List<Rewardlocaltitle> listRewardlocaltitle;
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doListReward() throws Exception {
		try {
			//�������ѡ�񱾵س����ϸ
			if("RPWDLocalRPT".equals(((RewardlocalWebParam)getParam()).get_se_rpttype())){
				RewardlocaldtlBO bo = (RewardlocaldtlBO)BOFactory.build(RewardlocaldtlBO.class,super.getDBAccessUser());
				RewardlocaldtlWebParam p = new RewardlocaldtlWebParam();
				BeanUtils.copyProperties(p, getParam());
				p.set_orderby("id");
				p.set_desc("asc");
				setDp(bo.doQuery(p));
			}else{
				RewardlocaltitleDBParam p = new RewardlocaltitleDBParam();
				p.set_se_rewardmonth(((RewardlocalWebParam)getParam()).get_se_rewardmonth());
				p.set_se_rpttype(((RewardlocalWebParam)getParam()).get_se_rpttype());
				p.set_orderby("seq");
				p.set_desc("asc");
				p.setQueryAll(true);
				RewardlocaltitleBO bo = (RewardlocaltitleBO)BOFactory.build(RewardlocaltitleBO.class,super.getDBAccessUser());
				listRewardlocaltitle = bo.doQuery(p).getDatas();
				param.set_orderby("rewardid");
				param.set_desc("asc");
				((RewardlocalDBParam)param).set_se_mobleno(null);
				return super.doList();
			}
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return WEB_RESULT_LIST;
	}
	
	/**
	 * ��ת����ѯҳ��
	 * @return
	 * @throws Exception
	 */
	public String doListPage()throws Exception{
		if(param==null){
			param = new RewardlocalWebParam();
		}
		Date d = new Date();
		int m = Integer.valueOf(DateFormatUtils.format(d, "MM"));
		if(m<=3){
			int y = Integer.valueOf(DateFormatUtils.format(d, "yyyy"));
			((RewardlocalWebParam)param).set_se_rewardmonth((y-1)+"10");
		}else{
			if(m-1<10){
				((RewardlocalWebParam)param).set_se_rewardmonth(DateFormatUtils.format(d, "yyyy")+"0"+(m-1));	
			}else{
				((RewardlocalWebParam)param).set_se_rewardmonth(DateFormatUtils.format(d, "yyyy")+(m-1));
			}
		}
		return WEB_RESULT_LIST;
	}

	public String getIsVisibleReward() {
		return isVisibleReward;
	}

	public void setIsVisibleReward(String isVisibleReward) {
		this.isVisibleReward = isVisibleReward;
	}

	public String getIsVisibleLocalReward() {
		return isVisibleLocalReward;
	}

	public void setIsVisibleLocalReward(String isVisibleLocalReward) {
		this.isVisibleLocalReward = isVisibleLocalReward;
	}

	public List<Rewardlocaltitle> getListRewardlocaltitle() {
		return listRewardlocaltitle;
	}

	public void setListRewardlocaltitle(List<Rewardlocaltitle> listRewardlocaltitle) {
		this.listRewardlocaltitle = listRewardlocaltitle;
	}
}