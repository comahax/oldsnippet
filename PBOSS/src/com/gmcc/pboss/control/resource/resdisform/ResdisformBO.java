/**
 * auto-generated code
 * Fri Oct 02 10:38:11 CST 2009
 */
package com.gmcc.pboss.control.resource.resdisform;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.resdisform.ProductDetailDAO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDAO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDBParam;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVOHelper;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.rcvobj.Rcvobj;
import com.gmcc.pboss.control.communication.rcvobj.RcvobjBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.discomres.Discomres;
import com.gmcc.pboss.control.resource.discomres.DiscomresBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ResdisformBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResdisformBO extends AbstractControlBean implements
		Resdisform {

	public ResdisformVO doCreate(ResdisformVO vo) throws Exception {
		try {
			ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class, user);
			// TODO set the pk */
			return (ResdisformVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResdisformVO vo) throws Exception {
		try {
			ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResdisformVO doUpdate(ResdisformVO vo) throws Exception {
		try {
			ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
			return (ResdisformVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResdisformVO doFindByPk(Serializable pk) throws Exception {
		ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
		return (ResdisformVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResdisformDBParam params)
			throws Exception {
		ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
		return dao.query(params);
	}
	
	/**查看商品明细
     * @param discomcode 配送商编号
     * @param disi	分配单号
     */
    public DataPackage doQueryProductDetail(String discomcode,String disi,ResdisformDBParam params) throws Exception{

    	ProductDetailDAO dao = (ProductDetailDAO) DAOFactory.build(ProductDetailDAO.class,user);
    	Map conditionMap = new HashMap();
    	conditionMap.put("DISID", disi);
    	conditionMap.put("DISCOMCODE", discomcode);
    	params.setQueryConditions(conditionMap);
    	params.setSelectFieldsString("batchno,boxnum,comresid,comcategory");
    	return dao.doQuery(params);
    }
    
    //批量更新分配单状态
    private void doUpdateState(String[] pk, ResdisformVOHelper voHelper) throws Exception{
    	String[] pkArray = null;
    	for(int i = 0;i<pk.length;i++){			
			pkArray = pk[i].split("\\|");
			ResdisformVO vo = new ResdisformVO();
			vo.setDiscomcode(pkArray[0]);
			vo.setDisid(pkArray[1]);
			vo = this.doFindByPk(vo);
			vo.setIssuecode(voHelper.getIssuecode());
			vo.setIssutime(voHelper.getIssutime());
			vo.setSmscontent(voHelper.getSmscontent());
			vo.setDisformstate("WAITISSUE");
			this.doUpdate(vo);
    	}
    }
    
    /**
     * 批量更新
     * @param pk	主键数组(复合主键,之间用|分开)
     * @param form	
     * @return
     * @throws Exception
     */
    public String batchUpdate(String[] pk,ResdisformVOHelper voHelper,List<String> employeeIDs) throws Exception {
    	int success = 0;
    	int fail = 0;
    	StringBuilder error = new StringBuilder(50);

    	//对界面中的资源分配单数据进行修改，发布人工号、发布时间、发布短信内容取界面数据，分配单状态取“待发布”。
    	try{
    		ResdisformBO bo = (ResdisformBO)BOFactory.build(ResdisformBO.class,user);
    		bo.doUpdateState(pk,voHelper);
    	}catch(Exception e){
    		throw new JOPException(" 更新分配单状态时出错："+e.getMessage());
    	}
    		
    		
    		if("send".equals(voHelper.getIsSendSms())){
//    			如果短信通知为勾选状态，则需要发送短信通知，新增数据到短信待发送表(CH_SMS_WAITREQ)，
//    			短信类型取4，接收手机号码取店主手机号码（即公务机号码），短信内容取界面短信内容。
    			Waitreq waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
    			Employee employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
    			for(String employeeid:employeeIDs){
    				try{
    					EmployeeVO employeeVO = employeeBO.doFindByPk(employeeid);
    					waitreqBO.doInsert(new Short("5"), voHelper.getSmscontent(), employeeVO.getOfficetel());
    				}catch(Exception e){
    					e.printStackTrace();   					
    				}
    			}
    			

//    		c、	新增公告信息
//    		如果短信通知为勾选状态，则需要发布公告信息，新增数据到公告信息表(CH_PW_ADVINFO)，信息ID取序列；标题取“资源发布[yyyyMMdd]”，yyyyMMdd为当前日期；
//    			发布信息内容取短信内容；类型取1公告；发布时间取当前时间；计划完成时间留空；发布有效期取当前时间+10天；
//    			发布对象类型取4特定人员；是否短信通知取1是；是否需要审批取0否；发布工号取界面发布人工号；状态取3已发布。

    			AdvinfoVO advinfoVO = new AdvinfoVO();
    			
    			try{
    				Calendar calendar = Calendar.getInstance();
    				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    				Advinfo advinfoBO = (AdvinfoBO)BOFactory.build(AdvinfoBO.class,user);
    				
    				advinfoVO.setTitle("资源发布["+format.format(calendar.getTime())+"]");
    				advinfoVO.setContent(voHelper.getSmscontent());
    				advinfoVO.setType(new Short("1"));
    				advinfoVO.setReleasetime(calendar.getTime());
    				calendar.add(Calendar.DAY_OF_MONTH, 10);
    				advinfoVO.setEnddate(calendar.getTime());
    				advinfoVO.setDesttype(new Short("4"));
    				advinfoVO.setSmsnotify(new Short("1"));
    				advinfoVO.setOprcode(voHelper.getIssuecode());
    				advinfoVO.setState(new Short("3"));
    				advinfoVO.setNdapproval(new Short("0"));
    				
    				advinfoVO = advinfoBO.doCreate(advinfoVO);
    				
    			}catch(Exception e){
    				e.printStackTrace();
    				error.append(" 新增公失败:"+e.getMessage()).append("|");
    			}
    			
//        		新增数据到接收对象表(CH_PW_RCVOBJ)，发布标识取序列；信息ID取新增公告信息；对象标识取人员编号；处理状态为1打开；查看时间留空；状态时间取当前时间。
    		
    				Rcvobj rcvobjBO = (RcvobjBO) BOFactory.build(RcvobjBO.class,user);
    				for(String employeeid:employeeIDs){
    					try{
    						RcvobjVO rcvobjVO = new RcvobjVO();
    						rcvobjVO.setAdvinfoid(advinfoVO == null ? null:advinfoVO.getAdvinfoid());
    						rcvobjVO.setObjid(employeeid);
    						rcvobjVO.setState(new Short("1"));
    						rcvobjVO.setStatetime(new Date());
    	    				rcvobjBO.doCreate(rcvobjVO);
    					}catch(Exception e){
    						e.printStackTrace();
    	    				error.append(" 新增数据到接收对象表 人员ID ["+employeeid+"]:"+e.getMessage()).append("|");
    					}
    				}  			    			
    		}
    	return error.toString();
    }
    

    
    /**
     * 批量分配
     * @param item item[0]:配送商编码 item[1]:批次 item[2]:包号
     * @param ways 渠道列表
     * @param disid 分配单号
     * @param storarea 资源库区
     */
    public Map<String,String> doUpdate(String[] item,List<WayVO> ways,String disid,String storarea) throws Exception {
    	Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
    	Discomres discomresBO = (DiscomresBO)BOFactory.build(DiscomresBO.class,user);
    	Map<String,String> categoryMap = new HashMap<String,String>();
    	
//    	int i = 0;
//		for(i = 0;i<ways.size();i++){
//			if(ways.get(i).getWayid().equals(item[0]))
//				break;
//		}
//		//查询配送商编码是否在配送商MAP中，如果存在则通过，如果不存在则记录出错原因“配送商不存在”。
//		if(i==ways.size()){
//			throw new Exception ("配送商["+item[0]+"]不存在");
//		}
		
		//根据商品批次、包号、包状态（待分配）查询商品包表（IM_PR_COMPACK），如果无结果则记录出错原因“未分配商品包不存在”；
//		如果有结果则更新归属配送商和资源库区，更新商品包状态为“待发布”，新增数据到配送商资源表（IM_PR_DISCOMRES）。
		CompackDBParam compackParam = new CompackDBParam();
		compackParam.setQueryAll(true);
		compackParam.set_se_batchno(item[1]);
		compackParam.set_se_boxnum(item[2]);
		compackParam.set_se_packstate("30");
		DataPackage compackDP = compackBO.doQuery(compackParam);
		if( null == compackDP || null == compackDP.getDatas() || compackDP.getDatas().size() == 0){
			throw new Exception("未分配商品包不存在");
		}
		for(int j = 0;j<compackDP.getDatas().size();j++){
			CompackVO compackVO = (CompackVO)compackDP.getDatas().get(j);
			compackVO.setDiscomcode(item[0]);
			compackVO.setStorarea(storarea);
			compackVO.setPackstate("31");
			
			DiscomresVO discomresVO = new DiscomresVO();
			discomresVO.setDiscomcode(item[0]);
			discomresVO.setBatchno(item[1]);
			discomresVO.setBoxnum(item[2]);
			discomresVO.setDisid(disid);
			discomresBO.doCreate(discomresVO);
			
			String count = categoryMap.get(compackVO.getComcategory());
			if( null != count){
				if( null != compackVO.getAmount()){
					categoryMap.put(compackVO.getComcategory(), Long.parseLong(count) + compackVO.getAmount().intValue()+"");
				}
			}else{
				categoryMap.put(compackVO.getComcategory(), compackVO.getAmount() == null ? "0":compackVO.getAmount().toString());
			}
		}
//		套卡资源数据更新：根据商品批次、包号、包状态（待分配）查询套卡资源表（IM_FX_COMRESSMP），
//		如果无结果则记录出错原因“套卡资源不存在”；如果有结果则更新资源库区，更新商品状态为“待发布”。
		Comressmp comressmpBO = (ComressmpBO)BOFactory.build(ComressmpBO.class,user);
		ComressmpDBParam comressmpParam = new ComressmpDBParam();
		comressmpParam.setQueryAll(true);
		comressmpParam.set_se_batchno(item[1]);
		comressmpParam.set_se_boxnum(item[2]);
		comressmpParam.set_ne_comstate(new Short("30"));
		
		DataPackage comressmpDP = comressmpBO.doQuery(comressmpParam);
		if( null == comressmpDP || null == comressmpDP.getDatas() || comressmpDP.getDatas().size() == 0){
			throw new Exception ("套卡资源不存在");
		}
		
		for(int k = 0;k<comressmpDP.getDatas().size();k++){
			ComressmpVO comressmpVO = (ComressmpVO)comressmpDP.getDatas().get(k);
			comressmpVO.setComstate(new Short("31"));
		}
		
		return categoryMap;
    }
    
    //取得查询渠道表（CH_PW_WAY），获取渠道集合，根据渠道编码查询渠道人员基本信息表(CH_PW_EMPLOYEE)
    // 匹配是否为店主字段为是（即ISNET=1），匹配用工状态为在岗（即EMPSTATUS=0），获取店主姓名（即姓名），手机号码（即公务机号码）
    public DataPackage doQueryEmployee(ResdisformDBParam params) throws Exception{
    	ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
    	return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.resdisform.getemployee", params);
    }
}
