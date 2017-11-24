/**
 * auto-generated code
 * Tue Oct 13 15:13:34 CST 2009
 */
 package com.gmcc.pboss.web.sales.orderresdet;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: OrderresdetAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderresdetAction extends BaseAction{
	private String instate;//���״̬
	private String outstate;//����״̬
	private DataPackage comdp;//������Ʒ�۸���Ϣ
	
	private String dismode = "";//����ģʽ  MANUAL���˹�����ģʽ  AUTO���Զ�����ģʽ
	
	//��Դ��ȡģʽ
	private String orderresdetparamvalue;
	
	
	private String tokenflag;

	public String getTokenflag() {
		return tokenflag;
	}

	public void setTokenflag(String tokenflag) {
		this.tokenflag = tokenflag;
	}

	public String getOrderresdetparamvalue() {
		return orderresdetparamvalue;
	}

	public void setOrderresdetparamvalue(String orderresdetparamvalue) {
		this.orderresdetparamvalue = orderresdetparamvalue;
	}

	public String getInstate() {
		return instate;
	}

	public void setInstate(String instate) {
		this.instate = instate;
	}

	public String getOutstate() {
		return outstate;
	}

	public void setOutstate(String outstate) {
		this.outstate = outstate;
	}
	
	public DataPackage getComdp() {
		return comdp;
	}

	public void setComdp(DataPackage comdp) {
		this.comdp = comdp;
	}
	
	public String doNumbers() throws Exception{
		String rtn ="";
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		
		String number1 = ServletActionContext.getRequest().getParameter("number1");
		String number2 = ServletActionContext.getRequest().getParameter("number2");
		
		//����У��
		String regex = "^([0-9]){1,32}$";
		if(!number1.matches(regex)){
			rtn = "error4," + "0";
		}
		if(!number2.matches(regex)){
			rtn = "error5," + "0";
		}
		if("".equals(rtn)){//��������£��Ѿ��������У�飩
			if(number1.length()<19 && number2.length()<19){
				long ls1 = Long.parseLong(number1);
				long ls2 = Long.parseLong(number2);
				long count = ls2 - ls1 ;
				if(ls1 <= ls2){//�����趨��Χ������				
					rtn = "success," + count;
				}else{//��ʼ��Χ���ڽ�����Χ
					rtn = "error1," + count;
				}
			}else{
				if(number1.length() == number2.length()){
					String n1s = number1.substring(0,(number1.length() - 18));
					String n1e = number1.substring(number1.length() - 18);
					
					String n2s = number2.substring(0,(number2.length() - 18));
					String n2e = number2.substring(number2.length() - 18);
					
					if(n1s != null && n1s.equals(n2s)){//ǰ��14λ����ͬ��ֻ�ȽϺ����18λ����
						long ls1 = Long.parseLong(n1e);
						long ls2 = Long.parseLong(n2e);
						long count = ls2 - ls1 ;
						if(ls1 <= ls2){//�����趨��Χ������				
							rtn = "success," + count;
						}else{//��ʼ��Χ���ڽ�����Χ
							rtn = "error1," + count;
						}
					}else{//ǰ��14λ������ͬ
						rtn = "error3," + "0";
					}
					
				}else{//һ������19λ��һ��С��19λ���趨�ķ�Χ����
					rtn = "error2," + "0";
				}
			}
		}
		
		out.write(rtn);
		
		return null;
	}
	
	public OrderresdetAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new OrderresdetForm());
		this.setParam(new OrderresdetWebParam());

        //ָ��VO��
        setClsVO(OrderresdetVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
        this.pkNameArray=new String[]{"detid"};
		this.setClsControl(Orderresdet.class);
		this.setClsQueryParam(OrderresdetDBParam.class) ;

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//����EXCEL
	public String doExportExcel() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		String fileName = "";
		OrderresdetDBParam param = (OrderresdetDBParam)super.getParam();
		if("CUSTORDER".equals(param.get_se_ordercomtype()))
			fileName = "��Դ��ϸ��Ϣ";
		else if("SYSTIEIN".equals(param.get_se_ordercomtype()))
			fileName = "������Դ��ϸ��Ϣ";
		if("SYSGIFT".equals(param.get_se_ordercomtype()))
			fileName = "������Դ��ϸ��Ϣ";
		export.setFileName(fileName);
		export.addOutputProperty("detid", "��ϸ���");
		export.addOutputProperty("comid", "��Ʒ����",export.CODE2NAME, "#COM");
		export.addOutputProperty("comcategory", "��Ʒ����",export.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("comid", "��Ʒ��ʶ");
		export.addOutputProperty("batchno", "��Ʒ����");
		export.addOutputProperty("boxnum", "����");
		export.addOutputProperty("comresid", "��Ʒ��Դ���");
		export.addOutputProperty("emptyno", "�տ����к�");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		OrderresdetDBParam params = (OrderresdetDBParam)super.getParam();
		params.setQueryAll(true);
		super.setParam(params);
		return super.doExcel();
	}
	/**
	 * ������Դ��ȡ�б�
	 * @return
	 * @throws Exception
	 */
	public String doDrawList() throws Exception {
		//��ȡ������Ϣ
		OrderresdetDBParam orderresdetDBParam = (OrderresdetDBParam) getParam();
		Order orderbo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		OrderVO vo=orderbo.doFindByPk(orderresdetDBParam.get_se_orderid());
		setForm(vo);
		//��ȡ������Ʒ�۸���Ϣ
		Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,getDBAccessUser());
		OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
		ordercomcateDBParam.set_se_orderid(vo.getOrderid());
		if(!StringUtils.isEmpty(orderresdetDBParam.get_orderby()) && orderresdetDBParam.get_orderby().indexOf("comdp.")==0){
			ordercomcateDBParam.set_orderby(orderresdetDBParam.get_orderby().replaceAll("comdp.", ""));
			ordercomcateDBParam.set_desc(orderresdetDBParam.get_desc());
			orderresdetDBParam.set_orderby(null);
		}
		
		//��ȡ����״̬
		Orderproce orderProceBO = (OrderproceBO) BOFactory.build(
				OrderproceBO.class, getDBAccessUser());
		OrderproceDBParam orderproceParam = new OrderproceDBParam();
		orderproceParam.set_ne_flowid(vo.getFlowid() + "");
		orderproceParam.set_se_instate(vo.getOrderstate());
		DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
		if (null != orderproceDP && !"".equals(orderproceDP) && orderproceDP.getDatas() != null
				&& !"".equals(orderproceDP.getDatas()) && orderproceDP.getDatas().size() > 0) {
			OrderproceVO orderproceVO = (OrderproceVO) orderproceDP.getDatas().get(
					0);// ���ж�������ȡ��һ��
			dismode = orderproceVO.getDismode();//����ģʽ  MANUAL���˹�����ģʽ  AUTO���Զ�����ģʽ
		}
		
		ordercomcateDBParam.setQueryAll(true);
		DataPackage comdp =ordercomcateBO.doQuery(ordercomcateDBParam);
		if (null != comdp && !"".equals(comdp) && comdp.getDatas() != null
				&& !"".equals(comdp.getDatas()) && comdp.getDatas().size() > 0) {
			List<OrdercomcateVO> comdpList = comdp.getDatas();
			for(OrdercomcateVO ordercomcateVO:comdpList){
				if(ordercomcateVO.getComcategory() != null &&
						ordercomcateVO.getComcategory().lastIndexOf("CZ") >= 0){
					ordercomcateVO.setComcategoryType("CZ");
				}
			}
		}
		
		this.setComdp(comdp);
		//��ȡ������Դ��ϸ��Ϣ
		Orderresdet orderresdetBO = (Orderresdet)BOFactory.build(OrderresdetBO.class,getDBAccessUser());
		DataPackage dp=orderresdetBO.doQueryOrderresdetGroupView(orderresdetDBParam);//.doQuery(orderresdetDBParam);
		setDp(dp);
		//��ȡ����״̬
		Orderproce orderproceBO = (Orderproce)BOFactory.build(OrderproceBO.class,getDBAccessUser());
		OrderproceDBParam orderproceDBParam=new OrderproceDBParam();
		orderproceDBParam.set_ne_flowid(String.valueOf(vo.getFlowid()));
		orderproceDBParam.set_se_instate(vo.getOrderstate());
		DataPackage data=orderproceBO.doQuery(orderproceDBParam);
		List<OrderproceVO> list=data.getDatas();
		for(OrderproceVO obj:list){
			this.setOutstate(obj.getOutstate());
			this.setInstate(obj.getInstate());
			break;
		}
		return "drawList";
	}
	
	public String doSetNumbers() throws Exception {
		try {
			
			String orderamt=ServletActionContext.getRequest().getParameter("orderamt");
			String comcategory=ServletActionContext.getRequest().getParameter("comcategory");
			
			this.getRequest().setAttribute("orderamt", orderamt);
			this.getRequest().setAttribute("comcategory", comcategory);
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return "toSetNumbers";
	}
		
	/**
	 * ������Դ��ȡ
	 * @return
	 * @throws Exception
	 */
	public String doResdraw() throws Exception {		
		OrderresdetDBParam orderresdetDBParam = (OrderresdetDBParam) getParam();
		Orderresdet orderresdetBO=(Orderresdet)BOFactory.build(OrderresdetBO.class,getDBAccessUser());//������Դ��ϸBO
		String drawPara = "";
		try {
			drawPara = ServletActionContext.getRequest().getParameter("drawPara");
			
			if(drawPara != null && !"".equals(drawPara)){
				//ҳ��ָ���ĳ�ȡ�Ŷ�
				String[] drawParas = drawPara.split("\\|");
				Map drawParaMap = new HashMap();
				if (drawParas != null && !"".equals(drawParas) && drawParas.length > 0) {
					for (int i = 0; i < drawParas.length; i++) {
						String item1 = drawParas[i];//��Ʒ����ͺŶ�
						if (item1 != null && !"".equals(item1)){
							String[] item2 = item1.split(",");
							List numDou = new ArrayList();
							if (item2 != null && !"".equals(item2) && item2.length == 2) {
								//2�У���Ʒ���� item2[0]��ָ���Ŷ� item2[1]	
								String[] item3 = item2[1].split("<br>");//ÿ��Ŷ�
								if (item3 != null && !"".equals(item3) && item3.length > 0) {
									for (int j = 0; j < item3.length; j++) {
										String[] item4 = item3[j].split("-");//ÿ�Ժ���
										if(item4 != null && !"".equals(item4) && item4.length == 2){
											numDou.add(item4);											
										}										
									}
								}								
							}
							if(!drawParaMap.containsKey(item2[0])){
								drawParaMap.put(item2[0], numDou);
							}
						}						
					}
				}
				
				orderresdetDBParam.setDrawPara(drawParaMap);
			}
			
			String message=orderresdetBO.doResdraw(orderresdetDBParam,true);
			this.setActionMessage(message);
		} catch (Exception e) {
			String mess = e.getMessage();
			if(e instanceof SaleException){
				SaleException se = (SaleException)e;
				Ordercomcate ordercomcate = (Ordercomcate) BOFactory.build(OrdercomcateBO.class, getDBAccessUser());
				Object obj = se.getRtnObject();
				if(obj instanceof OrdercomcateVO){
					OrdercomcateVO ordercomcateVO = (OrdercomcateVO)obj;
					ordercomcate.doUpdate(ordercomcateVO);
					
					String memo = ordercomcateVO.getMemo();
					if(memo != null && !"".equals(memo)){
						//������Ϣ����
						mess = "ָ����ȡ��Χ��" + memo + "����" + mess;
						this.getRequest().getSession().setAttribute("errMemo", "errMemo");
						this.getRequest().getSession().setAttribute("errDrawPara", drawPara);
					}
				}
			}
			
			e.printStackTrace();
			this.addActionError(mess);
			return doDrawList();
		}
		//������ȡ��ɺ󣬵��á�������һ�������÷����������жϴ�����
		Order orderBO=(Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		orderBO.doNextProcess(orderresdetDBParam.get_se_orderid());
		return doDrawList();
	}
	
	
	public void setTokenflagValue(){
		Object obj = this.getRequest().getSession().getAttribute("tokenflag");
		if(obj==null||obj.equals("")){
		this.getRequest().getSession().setAttribute("tokenflag", tokenflag);
		}
		
		this.getRequest().getSession().setAttribute("orderresdetparamvalue", orderresdetparamvalue);
		
	}
	
	
	
	public String doTobatch() throws Exception {
		SysparamBO sysparambo = (SysparamBO)BOFactory.build(SysparamBO.class, this.getDBAccessUser());
		orderresdetparamvalue=sysparambo.doFindByID("24", "pboss_fx");
		if(orderresdetparamvalue==null || orderresdetparamvalue.equals("")){
			orderresdetparamvalue="SEQUENCE";
		}
		if(tokenflag == null){
			tokenflag = "";			
		}
		
		this.getRequest().getSession().setAttribute("tokenflag", tokenflag);
		
		
		this.getRequest().getSession().setAttribute("orderresdetparamvalue", orderresdetparamvalue);
		return "tobatchDraw";
	}

	public String getDismode() {
		return dismode;
	}

	public void setDismode(String dismode) {
		this.dismode = dismode;
	}
	
	
}