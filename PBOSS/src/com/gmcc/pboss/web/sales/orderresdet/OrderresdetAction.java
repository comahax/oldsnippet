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
	private String instate;//入口状态
	private String outstate;//出口状态
	private DataPackage comdp;//订单商品价格信息
	
	private String dismode = "";//处理模式  MANUAL：人工处理模式  AUTO：自动处理模式
	
	//资源抽取模式
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
		
		//数字校验
		String regex = "^([0-9]){1,32}$";
		if(!number1.matches(regex)){
			rtn = "error4," + "0";
		}
		if(!number2.matches(regex)){
			rtn = "error5," + "0";
		}
		if("".equals(rtn)){//数字情况下（已经完成数字校验）
			if(number1.length()<19 && number2.length()<19){
				long ls1 = Long.parseLong(number1);
				long ls2 = Long.parseLong(number2);
				long count = ls2 - ls1 ;
				if(ls1 <= ls2){//计算设定范围的张数				
					rtn = "success," + count;
				}else{//开始范围大于结束范围
					rtn = "error1," + count;
				}
			}else{
				if(number1.length() == number2.length()){
					String n1s = number1.substring(0,(number1.length() - 18));
					String n1e = number1.substring(number1.length() - 18);
					
					String n2s = number2.substring(0,(number2.length() - 18));
					String n2e = number2.substring(number2.length() - 18);
					
					if(n1s != null && n1s.equals(n2s)){//前面14位数相同，只比较后面的18位即可
						long ls1 = Long.parseLong(n1e);
						long ls2 = Long.parseLong(n2e);
						long count = ls2 - ls1 ;
						if(ls1 <= ls2){//计算设定范围的张数				
							rtn = "success," + count;
						}else{//开始范围大于结束范围
							rtn = "error1," + count;
						}
					}else{//前面14位数不相同
						rtn = "error3," + "0";
					}
					
				}else{//一个大于19位，一个小于19位，设定的范围不对
					rtn = "error2," + "0";
				}
			}
		}
		
		out.write(rtn);
		
		return null;
	}
	
	public OrderresdetAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new OrderresdetForm());
		this.setParam(new OrderresdetWebParam());

        //指定VO类
        setClsVO(OrderresdetVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"detid"};
		this.setClsControl(Orderresdet.class);
		this.setClsQueryParam(OrderresdetDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	//导出EXCEL
	public String doExportExcel() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		String fileName = "";
		OrderresdetDBParam param = (OrderresdetDBParam)super.getParam();
		if("CUSTORDER".equals(param.get_se_ordercomtype()))
			fileName = "资源明细信息";
		else if("SYSTIEIN".equals(param.get_se_ordercomtype()))
			fileName = "搭售资源明细信息";
		if("SYSGIFT".equals(param.get_se_ordercomtype()))
			fileName = "赠送资源明细信息";
		export.setFileName(fileName);
		export.addOutputProperty("detid", "明细编号");
		export.addOutputProperty("comid", "商品名称",export.CODE2NAME, "#COM");
		export.addOutputProperty("comcategory", "商品种类",export.CODE2NAME, "$IM_FXCOMCATEGORY");
		export.addOutputProperty("comid", "商品标识");
		export.addOutputProperty("batchno", "商品批次");
		export.addOutputProperty("boxnum", "包号");
		export.addOutputProperty("comresid", "商品资源编号");
		export.addOutputProperty("emptyno", "空卡序列号");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		OrderresdetDBParam params = (OrderresdetDBParam)super.getParam();
		params.setQueryAll(true);
		super.setParam(params);
		return super.doExcel();
	}
	/**
	 * 订单资源抽取列表
	 * @return
	 * @throws Exception
	 */
	public String doDrawList() throws Exception {
		//获取订单信息
		OrderresdetDBParam orderresdetDBParam = (OrderresdetDBParam) getParam();
		Order orderbo = (Order)BOFactory.build(OrderBO.class,getDBAccessUser());
		OrderVO vo=orderbo.doFindByPk(orderresdetDBParam.get_se_orderid());
		setForm(vo);
		//获取订单商品价格信息
		Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,getDBAccessUser());
		OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
		ordercomcateDBParam.set_se_orderid(vo.getOrderid());
		if(!StringUtils.isEmpty(orderresdetDBParam.get_orderby()) && orderresdetDBParam.get_orderby().indexOf("comdp.")==0){
			ordercomcateDBParam.set_orderby(orderresdetDBParam.get_orderby().replaceAll("comdp.", ""));
			ordercomcateDBParam.set_desc(orderresdetDBParam.get_desc());
			orderresdetDBParam.set_orderby(null);
		}
		
		//获取订单状态
		Orderproce orderProceBO = (OrderproceBO) BOFactory.build(
				OrderproceBO.class, getDBAccessUser());
		OrderproceDBParam orderproceParam = new OrderproceDBParam();
		orderproceParam.set_ne_flowid(vo.getFlowid() + "");
		orderproceParam.set_se_instate(vo.getOrderstate());
		DataPackage orderproceDP = orderProceBO.doQuery(orderproceParam);
		if (null != orderproceDP && !"".equals(orderproceDP) && orderproceDP.getDatas() != null
				&& !"".equals(orderproceDP.getDatas()) && orderproceDP.getDatas().size() > 0) {
			OrderproceVO orderproceVO = (OrderproceVO) orderproceDP.getDatas().get(
					0);// 如有多条数据取第一条
			dismode = orderproceVO.getDismode();//处理模式  MANUAL：人工处理模式  AUTO：自动处理模式
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
		//获取订单资源明细信息
		Orderresdet orderresdetBO = (Orderresdet)BOFactory.build(OrderresdetBO.class,getDBAccessUser());
		DataPackage dp=orderresdetBO.doQueryOrderresdetGroupView(orderresdetDBParam);//.doQuery(orderresdetDBParam);
		setDp(dp);
		//获取出口状态
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
	 * 订单资源抽取
	 * @return
	 * @throws Exception
	 */
	public String doResdraw() throws Exception {		
		OrderresdetDBParam orderresdetDBParam = (OrderresdetDBParam) getParam();
		Orderresdet orderresdetBO=(Orderresdet)BOFactory.build(OrderresdetBO.class,getDBAccessUser());//订单资源明细BO
		String drawPara = "";
		try {
			drawPara = ServletActionContext.getRequest().getParameter("drawPara");
			
			if(drawPara != null && !"".equals(drawPara)){
				//页面指定的抽取号段
				String[] drawParas = drawPara.split("\\|");
				Map drawParaMap = new HashMap();
				if (drawParas != null && !"".equals(drawParas) && drawParas.length > 0) {
					for (int i = 0; i < drawParas.length; i++) {
						String item1 = drawParas[i];//商品种类和号段
						if (item1 != null && !"".equals(item1)){
							String[] item2 = item1.split(",");
							List numDou = new ArrayList();
							if (item2 != null && !"".equals(item2) && item2.length == 2) {
								//2列，商品种类 item2[0]、指定号段 item2[1]	
								String[] item3 = item2[1].split("<br>");//每组号段
								if (item3 != null && !"".equals(item3) && item3.length > 0) {
									for (int j = 0; j < item3.length; j++) {
										String[] item4 = item3[j].split("-");//每对号码
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
						//错误信息加上
						mess = "指定抽取范围【" + memo + "】的" + mess;
						this.getRequest().getSession().setAttribute("errMemo", "errMemo");
						this.getRequest().getSession().setAttribute("errDrawPara", drawPara);
					}
				}
			}
			
			e.printStackTrace();
			this.addActionError(mess);
			return doDrawList();
		}
		//订单抽取完成后，调用【订单下一步处理公用方法】，不判断处理结果
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