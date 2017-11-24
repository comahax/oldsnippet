/**
 * auto-generated code
 * Wed Aug 10 10:50:17 CST 2011
 */
 package com.gmcc.pboss.web.sales.canorderinfo;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoDBParam;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.gmcc.pboss.business.sales.comorder.OrderEmptyCardVO;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.sales.canorderinfo.Canorderinfo;
import com.gmcc.pboss.control.sales.canorderinfo.CanorderinfoBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: canorderinfoAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CanorderinfoAction extends BaseAction{
	public List brandList = new ArrayList<CanorderinfoVO>();
	public List cardList = new ArrayList<CanorderinfoVO>();
	public List emptyList = new ArrayList<OrderEmptyCardVO>();
	private String smsContentA;
	public CanorderinfoAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new CanorderinfoForm());
		this.setParam(new CanorderinfoDBParam());

        //ָ��VO��
        setClsVO(CanorderinfoVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"brand","wayid"};
		this.setClsControl(Canorderinfo.class);
		this.setClsQueryParam(CanorderinfoDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	public String doNoticeOne() {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			CanorderinfoDBParam param = (CanorderinfoDBParam)getParam();
			String wayid = param.get_se_wayid();
			
			if(wayid != null && !"".equals(wayid)){
				Canorderinfo canorderinfo = (Canorderinfo) BOFactory.build(CanorderinfoBO.class,getDBAccessUser());
				
				WayVO wayvo = new WayVO();//��������Ϣ
				
				String rtnStr2 = canorderinfo.doCheckWayAndModel(getDBAccessUser(), wayvo, wayid);
				if(rtnStr2 !=null && !"".equals(rtnStr2)){
					this.addActionError(rtnStr2);
					return WEB_RESULT_LIST;
				}
				
				CanorderinfoVO coiVO = canorderinfo.doNotceOne(getDBAccessUser(), wayvo);
				String smsContent = coiVO.getSmsContent();//��������
				
				//����ǰ��ʾ
				if(smsContent != null && !"".equals(smsContent)){
					
					request.setAttribute("sendSmsFlag", true);
					
					request.getSession().setAttribute("sendNum", coiVO.getSendNum());
					request.getSession().setAttribute("officetel", coiVO.getOfficetel());
					request.getSession().setAttribute("smsContent", smsContent);
					
					doList();
					return WEB_RESULT_LIST;
				}
			}
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return WEB_RESULT_LIST;
		}
		
		return WEB_RESULT_LIST;
	}
	
	public String doNoticeOneConfirm() throws Exception{
		
		return "confirm";
	}
	
	public String doNoticeOneSend(){
		String confirm = "confirm";
		PrintWriter out = null;
		try{
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			out = ServletActionContext.getResponse().getWriter();
			HttpServletRequest request = ServletActionContext.getRequest();
			String officetel = (String)request.getSession().getAttribute("officetel");
			String smsContent = (String)request.getSession().getAttribute("smsContent");
			String sendNum = (String)request.getSession().getAttribute("sendNum");
						
			/*
			 * �˴����Ͷ���
			 */
			WaitreqBO waitreqBO = (WaitreqBO)BOFactory.build(WaitreqBO.class,getDBAccessUser());    				    				
			waitreqBO.doInsert2(new Short("3"), smsContent, sendNum,officetel);
			
		}catch(Exception e){
			e.printStackTrace();
			out.write("noticeOneSendErr" + "&&" + "���ŷ���ʧ��:" +e.getMessage());
			
			return null;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("noticeOneSend", "noticeOneSendDisable");
		
		out.write("noticeOneSendDisable" + "&&" + "���ŷ��ͳɹ�");
		return null;
	}
	
	public String doNoticeOneCancel() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("sendSmsFlag", false);
		request.getSession().setAttribute("sendNum", "");
		request.getSession().setAttribute("officetel", "");
		request.getSession().setAttribute("smsContent", "");
		return WEB_RESULT_LIST;
	}
	
	public String doList(){
		try{
			CanorderinfoForm form = (CanorderinfoForm) getForm();
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,getDBAccessUser());
			brandList = new ArrayList<CanorderinfoVO>();
			cardList = new ArrayList<CanorderinfoVO>();
			emptyList = new ArrayList<OrderEmptyCardVO>();
			CanorderinfoDBParam param = (CanorderinfoDBParam)getParam();
			String wayid = param.get_se_wayid();
			if(wayid != null && !"".equals(wayid)){
				Canorderinfo canorderinfo = (Canorderinfo) BOFactory.build(CanorderinfoBO.class,getDBAccessUser());
				WayVO wayvo = new WayVO();//��������Ϣ
				
				String rtnStr2 = canorderinfo.doCheckWayAndModel(getDBAccessUser(), wayvo, wayid);
				if(rtnStr2 !=null && !"".equals(rtnStr2)){
					this.addActionError(rtnStr2);
					return WEB_RESULT_LIST;
				}
				
				//��ȡ�׿�Ʒ�Ƽ���			
				canorderinfo.doQueryBrand(brandList, getDBAccessUser(), wayvo);
				
				//��ȡ��ֵ��������Ϣ
				canorderinfo.doQueryStock(cardList, getDBAccessUser(), wayvo);
				
				//��ȡ�հ�SIM��������Ϣ
//				canorderinfo.doQueryEmpty(emptyList, getDBAccessUser(), wayvo);			
				//��ȡ�հ�SIM��������Ϣ
				emptyList = comorder.getEmptySimInfo(wayvo);
			}
		}catch(Exception e){
			this.addActionError(e.getMessage());
			brandList = new ArrayList<CanorderinfoVO>();
			cardList = new ArrayList<CanorderinfoVO>();
			emptyList = new ArrayList<OrderEmptyCardVO>();
			e.printStackTrace();
			return WEB_RESULT_LIST;
		}
		return WEB_RESULT_LIST;
	}
	
	

	public List getBrandList() {
		return brandList;
	}

	public void setBrandList(List brandList) {
		this.brandList = brandList;
	}

	public List getCardList() {
		return cardList;
	}

	public void setCardList(List cardList) {
		this.cardList = cardList;
	}

	public String getSmsContentA() {
		return smsContentA;
	}

	public void setSmsContentA(String smsContentA) {
		this.smsContentA = smsContentA;
	}

	public List getEmptyList() {
		return emptyList;
	}

	public void setEmptyList(List emptyList) {
		this.emptyList = emptyList;
	}
	
}