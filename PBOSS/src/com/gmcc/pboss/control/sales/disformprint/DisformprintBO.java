/**
 * auto-generated code
 * Sat Aug 13 12:50:41 CST 2011
 */
package com.gmcc.pboss.control.sales.disformprint;

import java.io.Serializable;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

import com.gmcc.pboss.business.sales.disformprint.DisformprintDBParam;
import com.gmcc.pboss.business.sales.disformprint.DisformprintDAO;
import com.gmcc.pboss.business.sales.disformprint.DisformprintVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.exception.JOPException;
import com.gmcc.pboss.business.base.sysparam.SysparamDAO;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.disformprint.ComIccInfo;
import com.gmcc.pboss.business.sales.disformprint.DisformFullInfo;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformDAO;

/**
 * <p>Title: DisformprintBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformprintBO extends AbstractControlBean implements
		Disformprint {

	public DisformprintVO doCreate(DisformprintVO vo) throws Exception {
		try {
			DisformprintDAO dao = (DisformprintDAO) DAOFactory.build(DisformprintDAO.class, user);
			// TODO set the pk */
			return (DisformprintVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(DisformprintVO vo) throws Exception {
		try {
			DisformprintDAO dao = (DisformprintDAO) DAOFactory.build(DisformprintDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			DisformprintDAO dao = (DisformprintDAO) DAOFactory.build(DisformprintDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformprintVO doUpdate(DisformprintVO vo) throws Exception {
		try {
			DisformprintDAO dao = (DisformprintDAO) DAOFactory.build(DisformprintDAO.class,user);
			return (DisformprintVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DisformprintVO doFindByPk(Serializable pk) throws Exception {
		DisformprintDAO dao = (DisformprintDAO) DAOFactory.build(DisformprintDAO.class,user);
		return (DisformprintVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(DisformprintDBParam params)
			throws Exception {
		DisformprintDAO dao = (DisformprintDAO) DAOFactory.build(DisformprintDAO.class,user);
		return dao.query(params);
	}
	
	/*
	 *配送单打印样式输出-统计信息
	 */
	public DataPackage doCountyComStat(DisformprintDBParam params) throws Exception{
		DataPackage dp = null;
		DisformprintDAO dao = (DisformprintDAO) DAOFactory.build(DisformprintDAO.class,user);
		dp = dao.getCountyComStat(params);
		return dp;
	}
	
	/*
	 * 根据系统参数获取空行数
	 * 获取配送单样式输出间隔行数
	 */
	public int doQueryEmptySpan() throws Exception{
		int emptySpan = 4;
		SysparamDAO sysDAO = (SysparamDAO)DAOFactory.build(SysparamDAO.class, user);
		String emptySpanStr = sysDAO.doFindByID(69L, "pboss_fx");
		if(emptySpanStr!=null && !"".equals(emptySpanStr.trim())){//不为空
			try{
				emptySpan = Integer.parseInt(emptySpanStr.trim());
			}catch(NumberFormatException nfe){//非数字类型
				emptySpan = 4;
			}
		}
		return emptySpan;
	}
	
	/*
	 * 配送单打印样式输出-明细信息，用于导出EXCEL
	 */
	public DataPackage doQueryDisformDetail(DisformprintDBParam params) throws Exception{		
		//获取配送单样式输出单次上限
		SysparamDAO sysDAO = (SysparamDAO)DAOFactory.build(SysparamDAO.class, user);
		String uplimitStr = sysDAO.doFindByID(68L, "pboss_fx");
		int uplimit = 1000;
		if(uplimitStr != null && !"".equals(uplimitStr.trim())){//不为空
			try{
				uplimit = Integer.parseInt(uplimitStr.trim());
			}catch(NumberFormatException nfe){//非数字类型
				uplimit = 1000;
			}
		}
		
		DataPackage dpDisform = null;
		DisformprintDAO disDAO = (DisformprintDAO)DAOFactory.build(DisformprintDAO.class,user);
		DisformDAO disformDAO = (DisformDAO)DAOFactory.build(DisformDAO.class,user);
		params.set_orderby("recid,orderid");
		dpDisform = disformDAO.getDisform4Print(params);
		if(dpDisform.getDatas().size()<=0){
			throw new Exception("配送单明细记录为零，请更改查询条件后重试。");
		}
		else if(dpDisform.getDatas().size()>uplimit){
			throw new Exception("当前配送单总量为" + dpDisform.getDatas().size() + "，超过单次输出上限" + uplimit + "，请更改查询条件后重试。");
		}
		
		List<DisformFullInfo> disFullList = new ArrayList<DisformFullInfo>();
		List<DisformVO> disList = dpDisform.getDatas();
		for(Iterator<DisformVO> itDis=disList.iterator();itDis.hasNext();){//处理每条配送单数据
			DisformVO disVO = itDis.next();
			
			//根据订单编码，关联获取订单资源明细和套卡资源明细信息
			//将返回结果构造成:商品标识，起始编号，终止编号，数量，价格
			List<ComIccInfo> comIccList = this.getComSMP(disDAO, disVO.getOrderid());
			
			//根据订单编码，获取订单资源明细表中套卡数据
			//将返回结果构造成:商品标识，起始编号，终止编号，数量
			List<ComIccInfo> comcardList = this.getComCard(disDAO, disVO.getOrderid());
			
			//合并数据
			comIccList.addAll(comcardList);
			
			DisformFullInfo fullInfo = new DisformFullInfo(disVO,comIccList);
			disFullList.add(fullInfo);
		}
		
		DataPackage dp = new DataPackage();
		dp.setDatas(disFullList);
		dp.setRowCount(disFullList.size());
		return dp;
	}
	
	private List<ComIccInfo> getComSMP(DisformprintDAO disDAO,String orderid) throws Exception{
		//根据订单编码，关联获取订单资源明细和套卡资源明细信息
		//将返回结果构造成:商品标识，起始编号，终止编号，数量，总金额
		List<ComIccInfo> comIccList = new ArrayList<ComIccInfo>();
		DataPackage dpComIcc = disDAO.getComIccInfo(orderid);
		if(dpComIcc.getDatas().size()>0){
			List<Object[]> dpComIccList = dpComIcc.getDatas();
			String tokenComid = null;
			String tokenIccidFrom = null;
			String tokenIccidTo = null;
			int quantity = 0;
			double comSMP_price = 0;
			for(Iterator<Object[]> itComIcc=dpComIccList.iterator();itComIcc.hasNext();){
				Object[] comIcc = itComIcc.next();
				String comid = (String)comIcc[0];
				String iccid = (String)comIcc[1];
				double actprice = Double.parseDouble(comIcc[2].toString());
				if( tokenComid ==null ){//首次进入循环
					tokenComid = comid;
					tokenIccidFrom = iccid;
					tokenIccidTo = iccid;
					quantity += 1; 
				}
				else{
					if(tokenComid.equals(comid) && this.isSequential(tokenIccidTo, iccid)){//商品标识相同，编号连续
						tokenIccidTo = iccid;
						quantity += 1;
					}
					else{//保存当前token数据到List，开始处理下一种商品或者下一个起始号码							
						ComIccInfo comIccInfo = new ComIccInfo(tokenComid,tokenIccidFrom,tokenIccidTo,quantity);
						comIccList.add(comIccInfo);
						
						tokenComid = comid;
						tokenIccidFrom = iccid;
						tokenIccidTo = iccid;
						quantity = 1;			
					}
				}
				comSMP_price += actprice;
			}
			//处理最后一批数据，可能是多条数据的汇总，也可能只有一条数据
			ComIccInfo comIccInfo = new ComIccInfo(tokenComid,tokenIccidFrom,tokenIccidTo,quantity,comSMP_price,0);
			comIccList.add(comIccInfo);
		}
		return comIccList;
	}
	
	private List<ComIccInfo> getComCard(DisformprintDAO disDAO,String orderid) throws Exception{
		//根据订单编码，获取订单资源明细表中套卡数据
		//将返回结果构造成:商品标识，起始编号，终止编号，数量
		List<ComIccInfo> comcardList = new ArrayList<ComIccInfo>();
		DataPackage dpComCardResid = disDAO.getComCardResis(orderid);
		if(dpComCardResid.getDatas().size()>0){
			List<Object[]> dpComCardList = dpComCardResid.getDatas();
			String tokenComid = null;
			String comresidFrom = null;
			String comresidTo = null;
			int quantity = 0;
			double comCard_price = 0;
			for(Iterator<Object[]> itCard = dpComCardList.iterator();itCard.hasNext();){
				Object[] comCard = itCard.next();
				String comid = (String)comCard[0];
				String comresid = (String)comCard[1];
				double actprice = Double.parseDouble(comCard[2].toString());
				if(tokenComid == null){//处理第一条数据
					tokenComid = comid;
					comresidFrom = comresid;
					comresidTo = comresid;
					quantity = 1;
				}else{
					if(tokenComid.equals(comid) && this.isSequential(comresidTo, comresid)){//商品标识相同，编号连续
						comresidTo = comresid;
						quantity += 1;
					}else{//保存当前token数据到List，开始处理下一种商品或者下一个起始号码	
						ComIccInfo comIccInfo = new ComIccInfo(tokenComid,comresidFrom,comresidTo,quantity);
						comcardList.add(comIccInfo);
						
						tokenComid = comid;
						comresidFrom = comresid;
						comresidTo = comresid;
						quantity = 1;
					}
				}
				comCard_price += actprice;
			}
			//处理最后一批数据，可能是多条数据的汇总，也可能只有一条数据
			ComIccInfo comIccInfo = new ComIccInfo(tokenComid,comresidFrom,comresidTo,quantity,0,comCard_price);
			comcardList.add(comIccInfo);				
		}		
		return comcardList;
	}
	
	/*
	 * 判断两个数字字符创是否连续， s1按照字符排序必须小于s2,且位数必须相等
	 * 如果小于19位可以直接转化成Long进行比较 
	 */
	private boolean isSequential(String s1,String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		if(s1.length()<19){
			long ls1 = Long.parseLong(s1);
			long ls2 = Long.parseLong(s2);
			return (ls1+1)==ls2;			
		}
		char[] ca1 = s1.toCharArray();
		int len = ca1.length;
		for(int i=len-1;i>=0;i--){
			if(ca1[i]<'9'){
				ca1[i]=(char)(ca1[i]+1);
				break;
			}else{
				ca1[i]='0';
			}
		}
		s1 = new String(ca1);
		return s1.equals(s2);	
	}

}
