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
	 *���͵���ӡ��ʽ���-ͳ����Ϣ
	 */
	public DataPackage doCountyComStat(DisformprintDBParam params) throws Exception{
		DataPackage dp = null;
		DisformprintDAO dao = (DisformprintDAO) DAOFactory.build(DisformprintDAO.class,user);
		dp = dao.getCountyComStat(params);
		return dp;
	}
	
	/*
	 * ����ϵͳ������ȡ������
	 * ��ȡ���͵���ʽ����������
	 */
	public int doQueryEmptySpan() throws Exception{
		int emptySpan = 4;
		SysparamDAO sysDAO = (SysparamDAO)DAOFactory.build(SysparamDAO.class, user);
		String emptySpanStr = sysDAO.doFindByID(69L, "pboss_fx");
		if(emptySpanStr!=null && !"".equals(emptySpanStr.trim())){//��Ϊ��
			try{
				emptySpan = Integer.parseInt(emptySpanStr.trim());
			}catch(NumberFormatException nfe){//����������
				emptySpan = 4;
			}
		}
		return emptySpan;
	}
	
	/*
	 * ���͵���ӡ��ʽ���-��ϸ��Ϣ�����ڵ���EXCEL
	 */
	public DataPackage doQueryDisformDetail(DisformprintDBParam params) throws Exception{		
		//��ȡ���͵���ʽ�����������
		SysparamDAO sysDAO = (SysparamDAO)DAOFactory.build(SysparamDAO.class, user);
		String uplimitStr = sysDAO.doFindByID(68L, "pboss_fx");
		int uplimit = 1000;
		if(uplimitStr != null && !"".equals(uplimitStr.trim())){//��Ϊ��
			try{
				uplimit = Integer.parseInt(uplimitStr.trim());
			}catch(NumberFormatException nfe){//����������
				uplimit = 1000;
			}
		}
		
		DataPackage dpDisform = null;
		DisformprintDAO disDAO = (DisformprintDAO)DAOFactory.build(DisformprintDAO.class,user);
		DisformDAO disformDAO = (DisformDAO)DAOFactory.build(DisformDAO.class,user);
		params.set_orderby("recid,orderid");
		dpDisform = disformDAO.getDisform4Print(params);
		if(dpDisform.getDatas().size()<=0){
			throw new Exception("���͵���ϸ��¼Ϊ�㣬����Ĳ�ѯ���������ԡ�");
		}
		else if(dpDisform.getDatas().size()>uplimit){
			throw new Exception("��ǰ���͵�����Ϊ" + dpDisform.getDatas().size() + "�����������������" + uplimit + "������Ĳ�ѯ���������ԡ�");
		}
		
		List<DisformFullInfo> disFullList = new ArrayList<DisformFullInfo>();
		List<DisformVO> disList = dpDisform.getDatas();
		for(Iterator<DisformVO> itDis=disList.iterator();itDis.hasNext();){//����ÿ�����͵�����
			DisformVO disVO = itDis.next();
			
			//���ݶ������룬������ȡ������Դ��ϸ���׿���Դ��ϸ��Ϣ
			//�����ؽ�������:��Ʒ��ʶ����ʼ��ţ���ֹ��ţ��������۸�
			List<ComIccInfo> comIccList = this.getComSMP(disDAO, disVO.getOrderid());
			
			//���ݶ������룬��ȡ������Դ��ϸ�����׿�����
			//�����ؽ�������:��Ʒ��ʶ����ʼ��ţ���ֹ��ţ�����
			List<ComIccInfo> comcardList = this.getComCard(disDAO, disVO.getOrderid());
			
			//�ϲ�����
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
		//���ݶ������룬������ȡ������Դ��ϸ���׿���Դ��ϸ��Ϣ
		//�����ؽ�������:��Ʒ��ʶ����ʼ��ţ���ֹ��ţ��������ܽ��
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
				if( tokenComid ==null ){//�״ν���ѭ��
					tokenComid = comid;
					tokenIccidFrom = iccid;
					tokenIccidTo = iccid;
					quantity += 1; 
				}
				else{
					if(tokenComid.equals(comid) && this.isSequential(tokenIccidTo, iccid)){//��Ʒ��ʶ��ͬ���������
						tokenIccidTo = iccid;
						quantity += 1;
					}
					else{//���浱ǰtoken���ݵ�List����ʼ������һ����Ʒ������һ����ʼ����							
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
			//�������һ�����ݣ������Ƕ������ݵĻ��ܣ�Ҳ����ֻ��һ������
			ComIccInfo comIccInfo = new ComIccInfo(tokenComid,tokenIccidFrom,tokenIccidTo,quantity,comSMP_price,0);
			comIccList.add(comIccInfo);
		}
		return comIccList;
	}
	
	private List<ComIccInfo> getComCard(DisformprintDAO disDAO,String orderid) throws Exception{
		//���ݶ������룬��ȡ������Դ��ϸ�����׿�����
		//�����ؽ�������:��Ʒ��ʶ����ʼ��ţ���ֹ��ţ�����
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
				if(tokenComid == null){//�����һ������
					tokenComid = comid;
					comresidFrom = comresid;
					comresidTo = comresid;
					quantity = 1;
				}else{
					if(tokenComid.equals(comid) && this.isSequential(comresidTo, comresid)){//��Ʒ��ʶ��ͬ���������
						comresidTo = comresid;
						quantity += 1;
					}else{//���浱ǰtoken���ݵ�List����ʼ������һ����Ʒ������һ����ʼ����	
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
			//�������һ�����ݣ������Ƕ������ݵĻ��ܣ�Ҳ����ֻ��һ������
			ComIccInfo comIccInfo = new ComIccInfo(tokenComid,comresidFrom,comresidTo,quantity,0,comCard_price);
			comcardList.add(comIccInfo);				
		}		
		return comcardList;
	}
	
	/*
	 * �ж����������ַ����Ƿ������� s1�����ַ��������С��s2,��λ���������
	 * ���С��19λ����ֱ��ת����Long���бȽ� 
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
