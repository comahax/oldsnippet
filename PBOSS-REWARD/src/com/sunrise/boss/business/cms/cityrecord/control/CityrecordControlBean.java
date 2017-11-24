/**
* auto-generated code
* Thu Dec 15 07:12:07 GMT 2011
*/
package com.sunrise.boss.business.cms.cityrecord.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.admin.dictitem.control.DictitemControl;
import com.sunrise.boss.business.admin.dictitem.control.DictitemControlBean;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordDAO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.control.BbcRewardrecord2Control;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.control.BbcRewardrecord2ControlBean;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2DAO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2ListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2VO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.VBbcRewardrecord2VO;
import com.sunrise.boss.business.cms.chadtdictidname.control.ChAdtDictidnameControl;
import com.sunrise.boss.business.cms.chadtdictidname.control.ChAdtDictidnameControlBean;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordDAO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordListVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordTableVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.LocalDataPackage;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecord2DAO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecord3DAO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecord3VO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecord4DAO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecordDAO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecordList2VO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecordList3VO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecordList4VO;
import com.sunrise.boss.business.cms.cityrecord.persistent.VCityrecordListVO;
import com.sunrise.boss.business.cms.cityrecordtotal.control.CityrecordtotalControl;
import com.sunrise.boss.business.cms.cityrecordtotal.control.CityrecordtotalControlBean;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalListVO;
import com.sunrise.boss.business.cms.cityrecordtotal.persistent.CityrecordtotalVO;
import com.sunrise.boss.business.cms.operation.control.OperationControl;
import com.sunrise.boss.business.cms.operation.control.OperationControlBean;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.control.RewardrecordControl;
import com.sunrise.boss.business.cms.reward.rewardrecord.control.RewardrecordControlBean;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordDAO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.VRewardrecordVO;
import com.sunrise.boss.business.cms.rewardupload.persistent.RewarduploadDAO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.ChrewardtypeCacheUtil;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>Title: CityrecordControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/cityrecord/control/CityrecordControlBean"
 name="CityrecordControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CityrecordControlBean extends  AbstractControlBean
    implements CityrecordControl {

    public CityrecordVO doCreate(CityrecordVO vo, User user)
        throws Exception {
        try{
			CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
            // TODO  set the pk */
            return (CityrecordVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CityrecordVO vo, User user)
        throws Exception {
        try{
			CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CityrecordVO doUpdate(CityrecordVO vo, User user)
        throws Exception {
        try{
			CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
            return (CityrecordVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CityrecordVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
        return (CityrecordVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CityrecordListVO params, User user)throws Exception {
		CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
		String countyid = params.get_se_countyid();
		if(countyid!=null && countyid.trim().length()>0){//�ֹ�˾���ݲ�ѯ
			params.getQueryConditions().put("countyid", countyid);
			params.set_se_countyid(null);
			return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.cityrecord.doQuerylistcounty", params);
		}else{
			return dao.queryByNamedSqlQuery("com.sunrise.boss.business.cms.cityrecord.doQuerylist", params);
		}
    }
    
    public DataPackage doThreeQuery(CityrecordListVO params, User user)
		throws Exception {
    	try {
			CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
			ChAdtDictidnameControl dncontrol = (ChAdtDictidnameControl)ControlFactory.build(ChAdtDictidnameControlBean.class);
			
			if (StringUtils.isNotBlank(params.getSqlopnid())){
				//  ��������ġ�ҵ���α��롯��ѯCH_PW_OPERATION��,�����ѡ�ı��벻��ҵ��ϸ��,
				//  ����ݵ�ǰ�����ȡ����ҵ��㼶�µ�ȫ��ҵ����뼯���в�ѯ
				OperationControl operationcontrol = (OperationControl) ControlFactory.build(OperationControlBean.class);
				OperationVO operationvo = operationcontrol.doFindByPk(params.getSqlopnid(), user);
				if(operationvo==null){
					throw new Exception("ҵ��㼶���벻����");
				}
				if (operationvo.getOpnlevel()!=5){//����ҵ��ϸ��
					String sql = " opnid in (select opnid from ch_pw_operation start with opnid='"
						+ params.getSqlopnid()
						+ "' connect by prior   opnid   = parentid) ";
					params.set_sql_opnid(sql);
				}else{
					params.set_se_opnid(params.getSqlopnid());
				}
			}
			
			DataPackage dp = new DataPackage();
			List<CityrecordVO> list = new ArrayList();
			if("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())){
				//���������ʶISFLAG=2��ȷ���ҼƳ�ϵͳSYSTEMFLAG=2���ѯ������������ϸ��¼��
				RewardrecordControl rrcontrol = (RewardrecordControl) ControlFactory.build(RewardrecordControlBean.class);
				RewardrecordListVO rrlistvo = new RewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				String rewardlistidsql = "rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=2)";
				//String rewardlistidsql = " not exists( SELECT REWARDLISTID from CH_ADT_CITYRECORD where SYSTEMFLAG=2 and REWARDLISTID IS NOT NULL and REWARDMONTH='"+ rrlistvo.get_se_rewardmonth() +"')";
				rrlistvo.set_sql_rewardlistid(rewardlistidsql);
				//����Ϊ�������ҳ����������
//				RewardrecordListVO rrlistvo2 = new RewardrecordListVO();
//				BeanUtils.copyProperties(rrlistvo2, rrlistvo);
//				rrlistvo2.set_pagesize("0");
//				DataPackage dpforpage = rrcontrol.doQuery2(rrlistvo2, user);
				//over
				DataPackage dptemp = rrcontrol.doQuery2(rrlistvo, user);
				if(null!=dptemp && dptemp.getDatas().size()>0){
					for(Iterator it = dptemp.getDatas().iterator();it.hasNext();){
						RewardrecordVO rrvo = (RewardrecordVO)it.next();
						if((rrvo.getPaymoney2()==null || rrvo.getPaymoney2()==0) && (rrvo.getPaymoney3()==null || rrvo.getPaymoney3()==0)){//������ص�
							CityrecordVO crvo = new CityrecordVO();
							BeanUtils.copyProperties(crvo, rrvo);
							if("0403".equals(rrvo.getOpnid().substring(0, 4))){
								crvo.setMobile(rrvo.getBakinfo());
							}
							crvo.setIsflag((short)2);
							crvo.setSystemflag((short)2);
							crvo.setPaymoney(rrvo.getPaysum());
							crvo.setRewardlistid(rrvo.getRewardlistid());
							//���⴦��������
							String rewardtypename = "";
							String rewardtype = "";
							ChAdtDictidnameVO pkvo = new ChAdtDictidnameVO(crvo.getRewardtype().toString(),"CH_REWARDTYPE");
							pkvo = dncontrol.doFindByPk(pkvo, user);
							if(null==pkvo || StringUtils.isBlank(pkvo.getDictname())){
								DictitemControl dicontrol = (DictitemControl) ControlFactory.build(DictitemControlBean.class);
								DictitemVO pkvo2 = new DictitemVO(crvo.getRewardtype().toString(),"CH_REWARDTYPE");
								pkvo2 = dicontrol.doFindByPk(pkvo2, user);
								if(null!=pkvo2){
									rewardtypename = pkvo2.getDictname();
									rewardtype = pkvo2.getDictid();
								}
							}else{
								rewardtypename = pkvo.getDictname();
								rewardtype = pkvo.getDictid();
							}
							crvo.setRewardtypename(rewardtypename);
							crvo.setRewardtype(Short.parseShort(rewardtype));
							list.add(crvo);
						}else{//����ص�
							//��һ����¼��
							CityrecordVO crvo1 = new CityrecordVO();
							BeanUtils.copyProperties(crvo1, rrvo);
							crvo1.setIsflag((short)2);
							crvo1.setSystemflag((short)2);
							
							crvo1.setRewardmonth(rrvo.getPaymonth1());
							crvo1.setPaymoney(rrvo.getPaymoney1());
							crvo1.setRewardlistid(rrvo.getRewardlistid());
							//���⴦��������
							String rewardtypename = "";
							String rewardtype = "";
							ChAdtDictidnameVO pkvo = new ChAdtDictidnameVO(crvo1.getRewardtype().toString(),"CH_REWARDTYPE");
							pkvo = dncontrol.doFindByPk(pkvo, user);
							if(null==pkvo || StringUtils.isBlank(pkvo.getDictname())){
								DictitemControl dicontrol = (DictitemControl) ControlFactory.build(DictitemControlBean.class);
								DictitemVO pkvo2 = new DictitemVO(crvo1.getRewardtype().toString(),"CH_REWARDTYPE");
								pkvo2 = dicontrol.doFindByPk(pkvo2, user);
								if(null!=pkvo2){
									rewardtypename = pkvo2.getDictname();
									rewardtype = pkvo2.getDictid();
								}
							}else{
								rewardtypename = pkvo.getDictname();
								rewardtype = pkvo.getDictid();
							}
							crvo1.setRewardtypename(rewardtypename);
							crvo1.setRewardtype(Short.parseShort(rewardtype));
							list.add(crvo1);
							//�ڶ�����¼��
							CityrecordVO crvo2 = new CityrecordVO();
							BeanUtils.copyProperties(crvo2, rrvo);
							crvo2.setIsflag((short)2);
							crvo2.setSystemflag((short)2);
							
							crvo2.setRewardmonth(rrvo.getPaymonth2());
							crvo2.setPaysum((double)0);
							crvo2.setPaymoney(rrvo.getPaymoney2());
							crvo2.setRewardlistid(rrvo.getRewardlistid());
							crvo2.setRewardtypename(rewardtypename);
							crvo2.setRewardtype(Short.parseShort(rewardtype));
							list.add(crvo2);
							
							if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()!=0){
								//��������¼��
								CityrecordVO crvo3 = new CityrecordVO();
								BeanUtils.copyProperties(crvo3, rrvo);
								crvo3.setIsflag((short)2);
								crvo3.setSystemflag((short)2);
								
								crvo3.setRewardmonth(rrvo.getPaymonth3());
								crvo3.setPaysum((double)0);
								crvo3.setPaymoney(rrvo.getPaymoney3());
								crvo3.setRewardlistid(rrvo.getRewardlistid());
								crvo3.setRewardtypename(rewardtypename);
								crvo3.setRewardtype(Short.parseShort(rewardtype));
								list.add(crvo3);
							}
						}
					}
				}
				dp.setDatas(list);
				dp.setPageNo(new Integer(params.get_pageno()));
				dp.setPageSize(new Integer(params.get_pagesize()));
//				dp.setRowCount(dpforpage.getRowCount());
//				dp.setRowCount(dptemp.getRowCount());
				// 1����3��,rowcount�仯��,��Щ��¼�ͷ�����һҳ��.
				dp.setRowCount(list.size());
				return dp;
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
				//���������ʶISFLAG=2��ȷ���ҼƳ�ϵͳSYSTEMFLAG=3���ѯBBC�����ϸ��¼
				BbcRewardrecord2Control rrcontrol = (BbcRewardrecord2Control) ControlFactory.build(BbcRewardrecord2ControlBean.class);
				BbcRewardrecord2ListVO rrlistvo = new BbcRewardrecord2ListVO();
				String sql = " ossrc in (3,4,5) ";
				rrlistvo.set_sql_ossrc(sql);
				BeanUtils.copyProperties(rrlistvo, params);
				String rewardlistidsql = "rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=3)"; 
				//String rewardlistidsql = " not exists( SELECT REWARDLISTID from CH_ADT_CITYRECORD where SYSTEMFLAG=3 and REWARDLISTID IS NOT NULL and REWARDMONTH='"+ rrlistvo.get_se_rewardmonth() +"')";
				rrlistvo.set_sql_rewardlistid(rewardlistidsql);
				//����Ϊ�������ҳ����������
//				BbcRewardrecord2ListVO rrlistvo2 = new BbcRewardrecord2ListVO();
//				BeanUtils.copyProperties(rrlistvo2, rrlistvo);
//				rrlistvo2.set_pagesize("0");
//				DataPackage dpforpage = rrcontrol.doQuery2(rrlistvo2, user);
				//over
				DataPackage dptemp2 = rrcontrol.doQuery2(rrlistvo, user);
				if(null!=dptemp2 && dptemp2.getDatas().size()>0){
					for(Iterator it = dptemp2.getDatas().iterator();it.hasNext();){
						BbcRewardrecord2VO rrvo = (BbcRewardrecord2VO)it.next();
						CityrecordVO crvo = new CityrecordVO();
						BeanUtils.copyProperties(crvo, rrvo);
						crvo.setIsflag((short)2);
						crvo.setSystemflag((short)3);
						crvo.setBusivalue((double)1);
						crvo.setPaymoney(rrvo.getPaysum());
						//���⴦��������
						String rewardtypename = "";
						ChAdtDictidnameVO pkvo = new ChAdtDictidnameVO(crvo.getRewardtype().toString(),"CH_REWARDTYPE");
						pkvo = dncontrol.doFindByPk(pkvo, user);
						if(null==pkvo || StringUtils.isBlank(pkvo.getDictname())){
							DictitemControl dicontrol = (DictitemControl) ControlFactory.build(DictitemControlBean.class);
							DictitemVO pkvo2 = new DictitemVO(crvo.getRewardtype().toString(),"CH_REWARDTYPE");
							pkvo2 = dicontrol.doFindByPk(pkvo2, user);
							if(null!=pkvo2){
								rewardtypename = pkvo2.getDictname();
							}
						}else{
							rewardtypename = pkvo.getDictname();
						}
						crvo.setRewardtypename(rewardtypename);
						list.add(crvo);
					}
				}
				dp.setDatas(list);
				dp.setPageNo(new Integer(params.get_pageno()));
				dp.setPageSize(new Integer(params.get_pagesize()));
//				dp.setRowCount(dpforpage.getRowCount());
				dp.setRowCount(dptemp2.getRowCount());
				return dp;
			}else{
				//������ѯ������Ͼ���CH_ADT_CITYRECORD���ȡ
				dp = dao.query(params);
//				dp=dao.doQuerycnt(params, user);
				List<CityrecordVO> dplist = new ArrayList<CityrecordVO>();
				for(Iterator<CityrecordVO> it = dp.getDatas().iterator();it.hasNext();){
					CityrecordVO vo = it.next();
					//���⴦��������
					String rewardtypename = "";
					ChAdtDictidnameVO pkvo = new ChAdtDictidnameVO(vo.getRewardtype().toString(),"CH_REWARDTYPE");
					pkvo = dncontrol.doFindByPk(pkvo, user);
					if(null==pkvo || StringUtils.isBlank(pkvo.getDictname())){
						DictitemControl dicontrol = (DictitemControl) ControlFactory.build(DictitemControlBean.class);
						DictitemVO pkvo2 = new DictitemVO(vo.getRewardtype().toString(),"CH_REWARDTYPE");
						pkvo2 = dicontrol.doFindByPk(pkvo2, user);
						if(null!=pkvo2){
							rewardtypename = pkvo2.getDictname();
						}
					}else{
						rewardtypename = pkvo.getDictname();
					}
					vo.setRewardtypename(rewardtypename);
					dplist.add(vo);
				}
				dp.setDatas(dplist);
				return dp;
			}
		} catch (Exception e) {
			throw e;
		}
    }
    
    public void doIssue(String[] pkValueArray, User user) throws Exception{
    	try{
			CityrecordVO vo = new CityrecordVO();
			vo.setRecordid(StringUtils.isNotBlank(pkValueArray[0])?new Long(pkValueArray[0]):null);
			vo.setIsflag(new Short("1"));
			vo.setSystemflag(StringUtils.isNotBlank(pkValueArray[2])?new Short(pkValueArray[2]):null);
			vo.setWayid(pkValueArray[3]);
			vo.setOpnid(pkValueArray[4]);
			vo.setRewardtype(StringUtils.isNotBlank(pkValueArray[5])?new Short(pkValueArray[5]):null);
			vo.setMobile(pkValueArray[6]);
			vo.setRewardmonth(pkValueArray[7]);
			vo.setOprtime(PublicUtils.UtilStrToDate(pkValueArray[8]));
			vo.setBusivalue(StringUtils.isNotBlank(pkValueArray[9])?new Double(pkValueArray[9]):null);
			vo.setPaysum(StringUtils.isNotBlank(pkValueArray[10])?new Double(pkValueArray[10]):null);
			vo.setPaymoney(StringUtils.isNotBlank(pkValueArray[11])?new Double(pkValueArray[11]):null);
			vo.setApproveid(pkValueArray[12]);
			vo.setRewardlistid(StringUtils.isNotBlank(pkValueArray[13])?new Long(pkValueArray[13]):null);
			vo.setOprcode(user.getOpercode());
			vo.setOptime(new Date());
			
			
			
			CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			CityrecordListVO listvo = new CityrecordListVO();
			if(StringUtils.isNotBlank(pkValueArray[6])){//���MOBILE��Ϊ�յļƼ���ҵ��,����:��ҵ�����+ҵ����ʱ��+�������+ҵ���������IMEI��+�����·�
				listvo.set_se_opnid(vo.getOpnid());
				listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
				listvo.set_ne_rewardtype(vo.getRewardtype().toString());
				listvo.set_se_mobile(vo.getMobile());
				listvo.set_se_rewardmonth(vo.getRewardmonth());
				//listvo.set_ne_isflag("1");//�ѷ���
				String sql = " isflag in (0,1) ";
				listvo.set_sql_isflag(sql);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new BusinessException("","�й�˾���ϴ���ͬ�ĳ����");
				}				
			}else if(StringUtils.isBlank(pkValueArray[6]) && ("0701010100004".equals(vo.getOpnid()) || 
					"0701010100003".equals(vo.getOpnid()) || "0701010100002".equals(vo.getOpnid()))){//���MOBILEΪ�հ��ǼƼ���ҵ��,�����:�������+ҵ�����+������+ҵ����ʱ��+�����·�
				listvo.set_se_wayid(vo.getWayid());
				listvo.set_se_opnid(vo.getOpnid());
				listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
				listvo.set_ne_rewardtype(vo.getRewardtype().toString());
				listvo.set_se_rewardmonth(vo.getRewardmonth());
				//listvo.set_ne_isflag("1");//�ѷ���
				String sql = " isflag in (0,1) ";
				listvo.set_sql_isflag(sql);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new BusinessException("","�й�˾���ϴ���ͬ�ĳ����");
				}
			}
			if(null!=vo.getRecordid()){
				crcontrol.doUpdate(vo, user);
			}else{
				crcontrol.doCreate(vo, user);
			}
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public void doAllissue(CityrecordListVO params, User user) throws Exception{
    	try{
    		CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			DataPackage dp = crcontrol.doThreeQuery(params, user);
			Iterator<CityrecordVO> it = dp.getDatas().iterator();
			while(it.hasNext()){
				CityrecordVO vo = it.next();
				if(vo.getIsflag()!=2){
					continue;
				}else{
					CityrecordListVO listvo = new CityrecordListVO();
					if(StringUtils.isNotBlank(vo.getMobile())){//���MOBILE��Ϊ�յļƼ���ҵ��,����:��ҵ�����+ҵ����ʱ��+�������+ҵ���������IMEI��+�����·�
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_se_mobile(vo.getMobile());
						listvo.set_se_rewardmonth(vo.getRewardmonth());
						//listvo.set_ne_isflag("1");//�ѷ���
						String sql = " isflag in (0,1) ";
						listvo.set_sql_isflag(sql);
						DataPackage dp2 = crcontrol.doQuery(listvo, user);
						if(null!=dp2 && dp2.getDatas().size()>0){
							throw new BusinessException("","�й�˾���ϴ���ͬ�ĳ����");
						}
					}else if(StringUtils.isBlank(vo.getMobile()) && ("0701010100004".equals(vo.getOpnid()) || 
							"0701010100003".equals(vo.getOpnid()) || "0701010100002".equals(vo.getOpnid()))){//���MOBILEΪ�հ��ǼƼ���ҵ��,�����:�������+ҵ�����+������+ҵ����ʱ��+�����·�
						listvo.set_se_wayid(vo.getWayid());
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_se_rewardmonth(vo.getRewardmonth());
						//listvo.set_ne_isflag("1");//�ѷ���
						String sql = " isflag in (0,1) ";
						listvo.set_sql_isflag(sql);
						DataPackage dp2 = crcontrol.doQuery(listvo, user);
						if(null!=dp2 && dp2.getDatas().size()>0){
							throw new BusinessException("","�й�˾���ϴ���ͬ�ĳ����");
						}
					}
					
					vo.setIsflag(new Short("1"));
					vo.setOprcode(user.getOpercode());
					vo.setOptime(new Date());
					
					if(null!=vo.getRecordid()){
						crcontrol.doUpdate(vo, user);
					}else{
						crcontrol.doCreate(vo, user);
					}
				}
			}
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public LocalDataPackage doListstat(CityrecordListVO params, User user)
    	throws Exception {
    	LocalDataPackage dp = new LocalDataPackage();//�������
    	double totalSumpaymoney=0;//�ϼ���Ӧ����
    	double totalSumConfirmmoney=0;//�ϼ���ȷ��
    	double tatalSumNotconfirmmoney=0;//�ϼƴ�����ȷ��
    	List<CityrecordTableVO> retlist = new ArrayList<CityrecordTableVO>();//�������
    	CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	String opnidstart = params.get_se_opnid();
    	String wayid = params.get_se_wayid();
    	String waylike = params.get_se_waylike();
    	String month = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
    	Short opnlevel = 0;
    	if(StringUtils.isNotBlank(opnidstart)){
    		OperationControl oprcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
        	OperationVO oprvo = oprcontrol.doFindByPk(opnidstart, user);
        	if(oprvo==null){
        		throw new BusinessException("","ҵ����벻����!");
        	}
        	opnlevel = oprvo.getOpnlevel();//��ȡҵ�����Ĳ㼶 
    	}
    	
    	if(StringUtils.isNotBlank(opnidstart) && opnlevel!=1 ){//������ҵ��㼶���벻Ϊ��,����ҵ�����Ĳ㼶����1������߼�����
    														   //���Դ�Ϊ���ͳ�ƴ�ҵ��㼶�������е�ҵ��ϸ��
    		List opnidandparentid = dao.getOpnidandParentid(opnidstart);
    		Object opnidobj[] = (Object[])opnidandparentid.get(0);
    		String opnidone = (String)opnidobj[1];//һ��ҵ�����
    		String opnidtwo = (String)opnidobj[0];//����ҵ�����
//    		List busistat = dao.getBusistat(opnidstart,wayid,waylike,month,systemflag);
    		List busistat = dao.getBusistatenhance(opnidstart,wayid,waylike,month,systemflag);
    		CityrecordTableVO info = new CityrecordTableVO();
			for(Iterator ite = busistat.iterator();ite.hasNext();){
				Object obje[] = (Object[])ite.next();
				if(StringUtils.isNotBlank(info.getRewardtype())&&StringUtils.isNotBlank((String)obje[0])
						&&StringUtils.isNotBlank(info.getOprmonth())&&StringUtils.isNotBlank((String)obje[2])
						&&info.getRewardtype().equals((String)obje[0])
						&&info.getOprmonth().equals((String)obje[2])
						){
					info.setSumbusivalue(info.getSumbusivalue()+(Double)obje[4]);
					info.setSumpaymoney((info.getSumpaymoney()==null?0d:info.getSumpaymoney()) + (Double)obje[5]);
					if((Short)obje[3]==0){//��ȷ��
						info.setSumconfirmmoney((info.getSumconfirmmoney()==null?0d:info.getSumconfirmmoney()) + (Double)obje[5]);
					}else{//�ѷ���
						info.setSumnotconfirmmoney((info.getSumnotconfirmmoney()==null?0d:info.getSumnotconfirmmoney()) + (Double)obje[5]);
					}
				}else{
					if(info.getRewardtype()!=null){
						CityrecordTableVO info2 = new CityrecordTableVO();
						BeanUtils.copyProperties(info2, info);
						retlist.add(info2);
						totalSumpaymoney+=info2.getSumpaymoney();
						totalSumConfirmmoney+=info2.getSumconfirmmoney();
						tatalSumNotconfirmmoney+=info2.getSumnotconfirmmoney();
					}
					info = new CityrecordTableVO();
					info.setOpnidone(opnidone);
					info.setOpnidonereplacer(opnidone);//Ϊ����ֵ
					info.setOpnidtwo(opnidtwo);
					info.setOpnidtworeplacer(opnidtwo);//Ϊ����ֵ
					info.setRewardtype((String)obje[0]);
					info.setRewardtypereplacer((String)obje[0]);//Ϊ����ֵ
					if(obje[1]!=null){//CH_ADT_DICTIDNAME CH_REWARDTYPE
						info.setRewardtypename((String)obje[1]);
					}else{//sa_db_dictitem CH_REWARDTYPE
						DictitemControl dicontrol = (DictitemControl) ControlFactory.build(DictitemControlBean.class);
						DictitemVO pkvo = new DictitemVO((String)obje[0],"CH_REWARDTYPE");
						pkvo = dicontrol.doFindByPk(pkvo, user);
						info.setRewardtypename(pkvo.getDictname());
					}
					///info.setRewardcount(1);
					info.setOprmonth((String)obje[2]);
					info.setOprmonthreplacer((String)obje[2]);//Ϊ����ֵ
					if(obje[4]!=null){
						info.setSumbusivalue((Double)obje[4]);
					}else{
						info.setSumbusivalue(0.0);
					}
					if((Short)obje[3]==0){//��ȷ��
						info.setSumconfirmmoney((Double)obje[5]);
						info.setSumnotconfirmmoney(0d);
					}else{//�ѷ���
						info.setSumconfirmmoney(0d);
						info.setSumnotconfirmmoney((Double)obje[5]);
					}
					if(obje[5]!=null ){
						info.setSumpaymoney((Double)obje[5]);//��Ӧ����
					}else{
						info.setSumpaymoney(0.0);
					}
				}
			}
			if(busistat.size()>0){
				CityrecordTableVO info3 = new CityrecordTableVO();
				BeanUtils.copyProperties(info3, info);
				retlist.add(info3);
				totalSumpaymoney+=info3.getSumpaymoney();
				totalSumConfirmmoney+=info3.getSumconfirmmoney();
				tatalSumNotconfirmmoney+=info3.getSumnotconfirmmoney();
			}
			
    	}else{//������ҵ��㼶����Ϊ�ջ���ҵ�����Ĳ㼶Ϊ��һ������ͳ�����е�ҵ��ϸ����һ�����������ҵ��ϸ�
    		List opnidandparentid = dao.getOpnidandParentid2(opnidstart,opnlevel);
    		for (Iterator it = opnidandparentid.iterator(); it.hasNext();) {
    			Object opnidobj[] = (Object[])it.next();	//[һ��ҵ����룬����ҵ�����]
    			String opnidone = (String)opnidobj[0];//һ��ҵ�����
        		String opnidtwo = (String)opnidobj[1];//����ҵ�����
        		
        		List busistat = dao.getBusistat(opnidtwo, wayid, waylike, month,
    					systemflag);
    			CityrecordTableVO info = new CityrecordTableVO();
    			for (Iterator ite = busistat.iterator(); ite.hasNext();) {
    				Object obje[] = (Object[]) ite.next();
    				if (StringUtils.isNotBlank(info.getRewardtype())
    						&& StringUtils.isNotBlank((String) obje[0])
    						&& StringUtils.isNotBlank(info.getOprmonth())
    						&& StringUtils.isNotBlank((String) obje[2])
    						&& info.getRewardtype().equals((String) obje[0])
    						&& info.getOprmonth().equals((String) obje[2])) {
    					info.setSumbusivalue(info.getSumbusivalue()
    							+ (Double) obje[4]);
    					info.setSumpaymoney((info.getSumpaymoney() == null ? 0d
    							: info.getSumpaymoney())
    							+ (Double) obje[5]);
    					if ((Short) obje[3] == 0) {// ��ȷ��
    						info.setSumconfirmmoney((info.getSumconfirmmoney() == null ? 0d
    										: info.getSumconfirmmoney())
    										+ (Double) obje[5]);
    					} else {// �ѷ���
    						info.setSumnotconfirmmoney((info
    								.getSumnotconfirmmoney() == null ? 0d : info
    								.getSumnotconfirmmoney())
    								+ (Double) obje[5]);
    					}
    				} else {
    					if (info.getRewardtype() != null) {
    						CityrecordTableVO info2 = new CityrecordTableVO();
    						BeanUtils.copyProperties(info2, info);
    						retlist.add(info2);
    						totalSumpaymoney+=info2.getSumpaymoney();
    						totalSumConfirmmoney+=info2.getSumconfirmmoney();
    						tatalSumNotconfirmmoney+=info2.getSumnotconfirmmoney();
    					}
    					info = new CityrecordTableVO();
    					info.setOpnidone(opnidone);
    					info.setOpnidonereplacer(opnidone);//Ϊ����ֵ
    					info.setOpnidtwo(opnidtwo);
    					info.setOpnidtworeplacer(opnidtwo);//Ϊ����ֵ
    					info.setRewardtype((String) obje[0]);
    					info.setRewardtypereplacer((String)obje[0]);//Ϊ����ֵ
    					if (obje[1] != null) {// CH_ADT_DICTIDNAME CH_REWARDTYPE
    						info.setRewardtypename((String) obje[1]);
    					} else {// sa_db_dictitem CH_REWARDTYPE
    						DictitemControl dicontrol = (DictitemControl) ControlFactory
    								.build(DictitemControlBean.class);
    						DictitemVO pkvo = new DictitemVO((String) obje[0],
    								"CH_REWARDTYPE");
    						pkvo = dicontrol.doFindByPk(pkvo, user);
    						info.setRewardtypename(pkvo.getDictname());
    					}
    					// /info.setRewardcount(1);
    					info.setOprmonth((String) obje[2]);
    					info.setOprmonthreplacer((String)obje[2]);//Ϊ����ֵ
    					if (obje[4] != null) {
    						info.setSumbusivalue((Double) obje[4]);
    					} else {
    						info.setSumbusivalue(0.0);
    					}
    					if ((Short) obje[3] == 0) {// ��ȷ��
    						info.setSumconfirmmoney((Double) obje[5]);
    						info.setSumnotconfirmmoney(0d);
    					} else {// �ѷ���
    						info.setSumconfirmmoney(0d);
    						info.setSumnotconfirmmoney((Double) obje[5]);
    					}
    					if (obje[5] != null) {
    						info.setSumpaymoney((Double) obje[5]);// ��Ӧ����
    					} else {
    						info.setSumpaymoney(0.0);
    					}
    				}
    			}
    			if(busistat.size()>0){
    				CityrecordTableVO info3 = new CityrecordTableVO();
    				BeanUtils.copyProperties(info3, info);
    				retlist.add(info3);
    				totalSumpaymoney+=info3.getSumpaymoney();
    				totalSumConfirmmoney+=info3.getSumconfirmmoney();
    				tatalSumNotconfirmmoney+=info3.getSumnotconfirmmoney();
    			}
    		}
    	}
    	
		
		//��ʽ��֮��Ϊ��ҳ��Ĳ��֣��ϲ�ͬ���
		int opnidoneCount = 1;
		int opnidtwoCount = 1;
		int rewardtypeCount = 1;
		int oprmonthCount = 1;
		CityrecordTableVO vo = null;
		List<CityrecordTableVO> tableList2 = new ArrayList<CityrecordTableVO>();
		CityrecordTableVO prevVO = new CityrecordTableVO();
		for(int i =0; i<retlist.size(); i++){
			CityrecordTableVO nextVO = retlist.get(i);
			if(nextVO.getOpnidone().equals(prevVO.getOpnidone())){
				opnidoneCount++;
					vo = tableList2.get(i-opnidoneCount+1);
					vo.setOpnidoneCount(opnidoneCount);
				if(nextVO.getOpnidtwo().equals(prevVO.getOpnidtwo())){
					opnidtwoCount++;
					vo = tableList2.get(i-opnidtwoCount+1);
					vo.setOpnidtwoCount(opnidtwoCount);
					if(nextVO.getRewardtype().equals(prevVO.getRewardtype())){
						rewardtypeCount++;
						vo = tableList2.get(i-rewardtypeCount+1);
						vo.setRewardtypeCount(rewardtypeCount);
						if(nextVO.getOprmonth().equals(prevVO.getOprmonth())){
							oprmonthCount++;
							vo = tableList2.get(i-oprmonthCount+1);
							vo.setOprmonthCount(oprmonthCount);
						}else{
							BeanUtils.copyProperties(prevVO, nextVO);
							tableList2.add(this.rebuildVO(nextVO, 4));
							oprmonthCount= 1;
							continue;
						}
					}else{
						BeanUtils.copyProperties(prevVO, nextVO);
						tableList2.add(this.rebuildVO(nextVO, 3));	
						rewardtypeCount=1;
						oprmonthCount= 1;
						continue;
					}
				}else{
					BeanUtils.copyProperties(prevVO, nextVO);
					tableList2.add(this.rebuildVO(nextVO, 2));
					opnidtwoCount=1;
					rewardtypeCount=1;
					oprmonthCount= 1;
					continue;
				}
			}else{
				BeanUtils.copyProperties(prevVO, nextVO);
				tableList2.add(this.rebuildVO(nextVO, 1));
				opnidoneCount=1;
				opnidtwoCount=1;
				rewardtypeCount=1;
				oprmonthCount= 1;
				continue;
			}
		}
		dp.setDatas(tableList2);
    	dp.setRowCount(tableList2.size());
    	dp.setTotal1(totalSumpaymoney);
    	dp.setTotal2(totalSumConfirmmoney);
    	dp.setTotal3(tatalSumNotconfirmmoney);
		return dp;
    }
    
    private CityrecordTableVO rebuildVO(CityrecordTableVO vo,int num) throws Exception{
    	CityrecordTableVO tempvo = new CityrecordTableVO();
		BeanUtils.copyProperties(tempvo, vo);
		switch (num) {
			case 5:
				BeanUtils.setProperty(tempvo, "oprmonth", "");
			case 4:
				BeanUtils.setProperty(tempvo, "rewardtype", "");
			case 3:
				BeanUtils.setProperty(tempvo, "opnidtwo", "");				
			case 2:
				BeanUtils.setProperty(tempvo, "opnidone", "");
			case 1:				
				break;
		}
		return tempvo;
	}
    
    //ȫ��ȷ���߼�
    public void doAllConfirmbak(CityrecordListVO params, User user)
		throws Exception {
    	CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	String opnidstart = params.get_se_opnid();
    	String wayid = params.get_se_wayid();
    	String waylike = params.get_se_waylike();
    	String month = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
    	List detaillist = new ArrayList();
    	if(StringUtils.isBlank(opnidstart)){
    		List opnidandparentid = dao.getOpnidandParentid2(opnidstart,(short)0);//�г�����һ������������
    		for (Iterator it = opnidandparentid.iterator(); it.hasNext();) {
    			Object opnidobj[] = (Object[])it.next();	//[һ��ҵ����룬����ҵ�����]
    			//String opnidone = (String)opnidobj[0];//һ��ҵ�����
        		String opnidtwo = (String)opnidobj[1];//����ҵ�����
        		detaillist = dao.getDetail2(opnidtwo,wayid,waylike,month,systemflag); 
        		for(Iterator itt = detaillist.iterator();itt.hasNext();){
            		Object obj[] = (Object[]) itt.next();
            		CityrecordVO vo = (CityrecordVO)dao.findByPk((Long)obj[0]);
            		if(vo.getIsflag()==1){
            			vo.setIsflag((short)0);
        				dao.update(vo);
        			}
            	}
    		}
    	}else{
    		detaillist = dao.getDetail2(opnidstart,wayid,waylike,month,systemflag);
    		for (Iterator it = detaillist.iterator(); it.hasNext();) {
				Object obj[] = (Object[]) it.next();
				CityrecordVO vo = (CityrecordVO) dao.findByPk((Long) obj[0]);
				if (vo.getIsflag() == 1) {
					vo.setIsflag((short) 0);
					dao.update(vo);
				}
			}
    	}
    }
  //ȫ��ȷ���߼�
    public int doAllConfirm(CityrecordListVO params, User user)
		throws Exception {
    	CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	return dao.confirmall(params, user);
    }
  //ȷ��ҳ��֮����ȷ���߼�
    public void doConfirmonebak(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, User user)
		throws Exception {
    	CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	String opnidstart = StringUtils.isBlank(params.get_se_opnid())?opnid2:params.get_se_opnid();
    	//��ȡopnidstart�Ĳ㼶
    	OperationControl oprcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
    	OperationVO oprvo = oprcontrol.doFindByPk(opnidstart, user);
    	if(oprvo==null){
    		throw new BusinessException("","ҵ����벻����!");
    	}
    	Short opnlevel = oprvo.getOpnlevel();//��ȡҵ�����Ĳ㼶 
    	if(opnlevel==1){
    		opnidstart = opnid2;//���������ѡҵ�����Ϊ1�������޷����ݳ��������ҵ������ȷ��������������������¼��
    							//��Ҫ�������ҵ����룬��ҵ�����
    	}
    	String wayid = params.get_se_wayid();
    	String waylike = params.get_se_waylike();
    	String month = params.get_se_rewardmonth();
    	String systemflag = params.get_ne_systemflag();
    	List detaillist = dao.getDetail(opnidstart,wayid,waylike,month,systemflag,rewardtype,oprmonth);
    	List<CityrecordVO> list = new ArrayList<CityrecordVO>();
    	for(Iterator it = detaillist.iterator();it.hasNext();){
    		Object obj[] = (Object[]) it.next();
    		CityrecordVO vo = (CityrecordVO)dao.findByPk((Long)obj[0]);
    		if(vo.getIsflag()==1){
    			vo.setIsflag((short)0);
				dao.update(vo);
			}
    	}
    }
  //ȷ��ҳ��֮����ȷ���߼�
    public int doConfirmone(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, User user)
		throws Exception {
    	CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	String opnidstart = StringUtils.isBlank(params.get_se_opnid())?opnid2:params.get_se_opnid();
    	//��ȡopnidstart�Ĳ㼶
    	OperationControl oprcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
    	OperationVO oprvo = oprcontrol.doFindByPk(opnidstart, user);
    	if(oprvo==null){
    		throw new BusinessException("","ҵ����벻����!");
    	}
    	Short opnlevel = oprvo.getOpnlevel();//��ȡҵ�����Ĳ㼶 
    	if(opnlevel==1){
    		opnidstart = opnid2;//���������ѡҵ�����Ϊ1�������޷����ݳ��������ҵ������ȷ��������������������¼��
    							//��Ҫ�������ҵ����룬��ҵ�����
    	}
    	return dao.confirmone(params,opnidstart,rewardtype,oprmonth, user);
    }
    //ȷ��ҳ��֮��ϸ�߼�
    public DataPackage doListdetail(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, String isflag,User user)
		throws Exception {
    	String opnidstart = StringUtils.isBlank(params.get_se_opnid())?opnid2:params.get_se_opnid();
    	//��ȡopnidstart�Ĳ㼶
    	OperationControl oprcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
    	OperationVO oprvo = oprcontrol.doFindByPk(opnidstart, user);
    	if(oprvo==null){
    		throw new BusinessException("","ҵ����벻����!");
    	}
    	Short opnlevel = oprvo.getOpnlevel();//��ȡҵ�����Ĳ㼶 
    	if(opnlevel==1){
    		opnidstart = opnid2;//���������ѡҵ�����Ϊ1�������޷����ݳ��������ҵ������ȷ��������������������¼��
    							//��Ҫ�������ҵ����룬��ҵ�����
    	}
    	params.set_se_opnid(opnidstart);
    	//month--> rewardmonth ,oprmonth--> oprtime
    	params.set_de_oprtime(oprmonth);
    	params.set_ne_rewardtype(rewardtype);
    	params.set_ne_isflag(isflag);

    	//�ĳɷ�ҳ����
    	VCityrecordList3VO vlistVO=new VCityrecordList3VO();
		BeanUtils.copyProperties(vlistVO, params);
    	VCityrecord3DAO vdao = (VCityrecord3DAO) DAOFactory.build(VCityrecord3DAO.class, user);
		DataPackage vdp=vdao.listissueconfirmdetail(vlistVO, user);
		
    	List<CityrecordVO> list = new ArrayList<CityrecordVO>();
    	for(Iterator it = vdp.getDatas().iterator();it.hasNext();){
    		VCityrecord3VO obj = (VCityrecord3VO) it.next();
    		VCityrecord3VO vo = new VCityrecord3VO();
    		vo.setRecordid(obj.getRecordid()==null?null:(Long)obj.getRecordid());
    		vo.setIsflag(obj.getIsflag()==null?null:(Short)obj.getIsflag());
    		vo.setSystemflag(obj.getSystemflag()==null?null:(Short)obj.getSystemflag());
    		vo.setWayid(obj.getWayid()==null?null:(String)(obj.getWayid()));
    		vo.setOpnid(obj.getOpnid()==null?null:(String)obj.getOpnid());
    		vo.setRewardtype(obj.getRewardtype()==null?null:(Short)obj.getRewardtype());

    		String name = (String)Code2NameConfiger.getName("REWARDTYPE", vo.getRewardtype().toString(), user.getCityid());
    		vo.setRewardtypename(name);
    		vo.setMobile(obj.getMobile()==null?null:(String)obj.getMobile());
    		vo.setRewardmonth(obj.getRewardmonth()==null?null:(String)obj.getRewardmonth());
    		vo.setOprtime(obj.getOprtime()==null?null:(Date)obj.getOprtime());
    		vo.setBusivalue(obj.getBusivalue()==null?null:(Double)obj.getBusivalue());
    		vo.setPaymoney(obj.getPaymoney()==null?0:(Double)obj.getPaymoney());//��Ϊ�գ���ȡ0
    		vo.setPaysum(obj.getPaysum()==null?0:(Double)obj.getPaysum());//��Ϊ�գ���ȡ0
    		CityrecordVO devo = new CityrecordVO();
    		BeanUtils.copyProperties(devo, vo);
    		list.add(devo);
    	}
    	DataPackage dp = new DataPackage();
    	dp.setDatas(list);
    	dp.setRowCount(vdp.getRowCount());
    	dp.setPageNo(vdp.getPageNo());
    	dp.setPageSize(vdp.getPageSize());    	
    	
    	return dp;
    }

	public void doOnlyissue(CityrecordListVO params, User user)
			throws Exception {
		// TODO Auto-generated method stub
		CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
		dao.onlyIssue(params, user);
	}
	public DataPackage doQueryDetail(CityrecordListVO params, User user)
	throws Exception {
		try {
			CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
			if (params.get_sin_opnid() != null && !"".equals(params.get_sin_opnid())) {
				params.set_sin_opnid(null);
			}			
			DataPackage dp = new DataPackage();
			List<CityrecordVO> list = new ArrayList();
			if("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())){
				//���������ʶISFLAG=1��ȷ���ҼƳ�ϵͳSYSTEMFLAG=2���ѯ������������ϸ��¼��
				RewardrecordControl rrcontrol = (RewardrecordControl) ControlFactory.build(RewardrecordControlBean.class);
				RewardrecordListVO rrlistvo = new RewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				String rewardlistidsql = "rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=2)"; 
				rrlistvo.set_sql_rewardlistid(rewardlistidsql);

				DataPackage dptemp = rrcontrol.doQuery2(rrlistvo, user);
				if(null!=dptemp && dptemp.getDatas().size()>0){
					for(Iterator it = dptemp.getDatas().iterator();it.hasNext();){
						RewardrecordVO rrvo = (RewardrecordVO)it.next();
						String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), ""+rrvo.getRewardtype());						
						if(rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()!=0){//��һ�ڲ�������
							CityrecordVO crvo = new CityrecordVO();
							BeanUtils.copyProperties(crvo, rrvo);							
							if(rrvo.getOpnid()!=null){
								String opnid2 = rrvo.getOpnid().substring(0, 2);
								if("04".equals(opnid2)){//�ն˳��
									crvo.setMobile(rrvo.getBakinfo());
								}								
							}
							crvo.setIsflag((short)1);
							crvo.setSystemflag((short)2);
							crvo.setPaymoney(rrvo.getPaymoney1());
							crvo.setRewardmonth(rrvo.getPaymonth1());
							crvo.setRewardtypename(rewardtypename);
							list.add(crvo);
						}
	    				if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()!=0){//�ڶ��ڲ�������
	    					CityrecordVO crvo2 = new CityrecordVO();
							BeanUtils.copyProperties(crvo2, rrvo);
							crvo2.setIsflag((short)1);
							crvo2.setSystemflag((short)2);															
							crvo2.setRewardmonth(rrvo.getPaymonth2());
							crvo2.setPaymoney(rrvo.getPaymoney2());
							crvo2.setRewardtypename(rewardtypename);
							if(rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()>0){
								crvo2.setPaysum((double)0);//���ڵ�һ�ڣ��˴��ܶ���Ϊ��
							}
							list.add(crvo2);
	    				}
	    				if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()!=0){//�����ڲ�������    							
	    					CityrecordVO crvo3 = new CityrecordVO();
							BeanUtils.copyProperties(crvo3, rrvo);
							crvo3.setIsflag((short)1);
							crvo3.setSystemflag((short)2);							
							crvo3.setRewardmonth(rrvo.getPaymonth3());							
							crvo3.setPaymoney(rrvo.getPaymoney3());
							crvo3.setRewardtypename(rewardtypename);
							if((rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()>0) || (rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0)){
								crvo3.setPaysum((double)0);//���ڵ�һ��ڶ��ڣ��˴��ܶ���Ϊ��
							}
							list.add(crvo3);
	    				}
					}
				}
				dp.setDatas(list);
				dp.setPageNo(new Integer(params.get_pageno()));
				dp.setPageSize(new Integer(params.get_pagesize()));
				dp.setRowCount(dptemp.getRowCount());
				return dp;
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
				//���������ʶISFLAG=1��ȷ���ҼƳ�ϵͳSYSTEMFLAG=3���ѯBBC�����ϸ��¼
				BbcRewardrecord2Control rrcontrol = (BbcRewardrecord2Control) ControlFactory.build(BbcRewardrecord2ControlBean.class);
				BbcRewardrecord2ListVO rrlistvo = new BbcRewardrecord2ListVO();
				String sql = " ossrc in (3,4,5) ";
				rrlistvo.set_sql_ossrc(sql);
				BeanUtils.copyProperties(rrlistvo, params);
				String rewardlistidsql = "rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=3)"; 
				rrlistvo.set_sql_rewardlistid(rewardlistidsql);
				DataPackage dptemp2 = rrcontrol.doQuery2(rrlistvo, user);
				if(null!=dptemp2 && dptemp2.getDatas().size()>0){
					for(Iterator it = dptemp2.getDatas().iterator();it.hasNext();){
						BbcRewardrecord2VO rrvo = (BbcRewardrecord2VO)it.next();
						CityrecordVO crvo = new CityrecordVO();
						BeanUtils.copyProperties(crvo, rrvo);
						crvo.setIsflag((short)1);
						crvo.setSystemflag((short)3);
						crvo.setBusivalue((double)1);
						crvo.setPaymoney(rrvo.getPaysum());
						//���⴦��������
						String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), ""+rrvo.getRewardtype());
						//String rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", rrvo.getRewardtype().toString(), user.getCityid());
						crvo.setRewardtypename(rewardtypename);
						list.add(crvo);
					}
				}
				dp.setDatas(list);
				dp.setPageNo(new Integer(params.get_pageno()));
				dp.setPageSize(new Integer(params.get_pagesize()));
				dp.setRowCount(dptemp2.getRowCount());
				return dp;
			}else{
				//������ѯ������Ͼ���CH_ADT_CITYRECORD���ȡ
				params.set_sin_opnid(null);
				dp = dao.query(params);
				List<CityrecordVO> dplist = new ArrayList<CityrecordVO>();
				for(Iterator<CityrecordVO> it = dp.getDatas().iterator();it.hasNext();){
					CityrecordVO vo = it.next();
					String rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", vo.getRewardtype().toString(), user.getCityid());
					vo.setRewardtypename(rewardtypename!=null?rewardtypename:vo.getRewardtype().toString());
					dplist.add(vo);
				}
				dp.setDatas(dplist);
				return dp;
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public DataPackage doThreeQueryEhance(CityrecordListVO params, User user)
	throws Exception {
	try {	
		DataPackage dp = new DataPackage();
		List<CityrecordVO> list = new ArrayList();
		if("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())){
			//���������ʶISFLAG=1��ȷ���ҼƳ�ϵͳSYSTEMFLAG=2���ѯ������������ϸ��¼��
			RewardrecordControl rrcontrol = (RewardrecordControl) ControlFactory.build(RewardrecordControlBean.class);
			RewardrecordListVO rrlistvo = new RewardrecordListVO();
			BeanUtils.copyProperties(rrlistvo, params);
			DataPackage dptemp = rrcontrol.doQuery3(rrlistvo, user);
			if(null!=dptemp && dptemp.getDatas().size()>0){
				for(Iterator it = dptemp.getDatas().iterator();it.hasNext();){
					VRewardrecordVO rrvo = (VRewardrecordVO)it.next();
					//���⴦��������
					String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), ""+rrvo.getRewardtype());
					rrvo.setRewardtypename(rewardtypename);
				}
			}
			return dptemp;
		}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
			//���������ʶISFLAG=1��ȷ���ҼƳ�ϵͳSYSTEMFLAG=3���ѯBBC�����ϸ��¼
			BbcRewardrecord2Control rrcontrol = (BbcRewardrecord2Control) ControlFactory.build(BbcRewardrecord2ControlBean.class);
			BbcRewardrecord2ListVO rrlistvo = new BbcRewardrecord2ListVO();
			BeanUtils.copyProperties(rrlistvo, params);
			DataPackage dptemp2 = rrcontrol.doQuery3(rrlistvo, user);//VBbcRewardrecord2VO
			if(null!=dptemp2 && dptemp2.getDatas().size()>0){
				for(Iterator it = dptemp2.getDatas().iterator();it.hasNext();){
					VBbcRewardrecord2VO rrvo = (VBbcRewardrecord2VO)it.next();
					//���⴦��������
					String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), ""+rrvo.getRewardtype());
					rrvo.setRewardtypename(rewardtypename);
				}
			}
			return dptemp2 ;
		}else{
			//������ѯ������Ͼ���CH_ADT_CITYRECORD���ȡ
			CityrecordtotalControl control = (CityrecordtotalControl) ControlFactory.build(CityrecordtotalControlBean.class);
			CityrecordtotalListVO listvo = new CityrecordtotalListVO();
			BeanUtils.copyProperties(listvo, params);
			dp=control.doQuerycnt(listvo, user);
			List<CityrecordtotalVO> dplist = new ArrayList<CityrecordtotalVO>();
			for(Iterator<CityrecordtotalVO> it = dp.getDatas().iterator();it.hasNext();){
				CityrecordtotalVO vo = it.next();
				//���⴦��������CH_ADT_CITYREWARDֻ��һ������
				//String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), ""+vo.getRewardtype());
				String rewardtypename = (String)Code2NameConfiger.getName("REWARDTYPE", vo.getRewardtype().toString(), user.getCityid());
				vo.setRewardtypename(rewardtypename!=null?rewardtypename:vo.getRewardtype().toString());
				dplist.add(vo);
			}
			dp.setDatas(dplist);
			return dp;
		}
	} catch (Exception e) {
		throw e;
	}
}

	public DataPackage doThreeQueryEhanceCount(CityrecordListVO params, User user) throws Exception{
		try {	
			if("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())){
				//���������ʶISFLAG=1��ȷ���ҼƳ�ϵͳSYSTEMFLAG=2���ѯ������������ϸ��¼��
				RewardrecordDAO pwdao = (RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class, user.getCityid());
				RewardrecordListVO rrlistvo = new RewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				DataPackage dptemp = pwdao.doQuerycount(rrlistvo, user);
				return dptemp;
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
				//���������ʶISFLAG=1��ȷ���ҼƳ�ϵͳSYSTEMFLAG=3���ѯBBC�����ϸ��¼
				BbcRewardrecordDAO bbcdao = (BbcRewardrecordDAO) DAOFactory.build(BbcRewardrecordDAO.class, user);
				BbcRewardrecordListVO rrlistvo = new BbcRewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				DataPackage dptemp2 = bbcdao.doQuerycount(rrlistvo, user);
				return dptemp2 ;
			}else{
				//������ѯ������Ͼ���CH_ADT_CITYRECORD���ȡ
				CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
				CityrecordListVO listvo = new CityrecordListVO();
				BeanUtils.copyProperties(listvo, params);
				DataPackage dp =dao.doQuerycount(listvo, user);
				return dp;
			}
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * ����ɾ�����÷�������ʹ��
	 * 20120914 ���ù��ܴ�[���г����ϸ�ϴ�����]Ǩ�Ƶ�[�����ϸ���ݲ�ѯ]�˵�
	 */	
//	public void doDeletepart(CityrecordListVO params, User user)
//			throws Exception {
//		try{
//			CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
//            dao.deletePart(params,user);
//        } catch(Exception ex){
//            sessionContext.setRollbackOnly();
//            throw ex;
//        }		
//	}
	public int doDeleteall(CityrecordListVO params, User user)
			throws Exception {
		try{
			CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
		    return dao.deleteall(params,user);
		} catch(Exception ex){
		    sessionContext.setRollbackOnly();
		    throw ex;
		}
	
	}
	    
    public String[] doIssue(CityrecordListVO params, User user)throws Exception{
    	//String datestamp = ((Integer) Math.round(new Date().getTime() / 1000)).toString();
    	RewarduploadDAO dao = (RewarduploadDAO) DAOFactory.build(RewarduploadDAO.class, user);
    	Long datestamp = (Long)dao.getSequence("ch_adt_rewardupload_seq");
		//����
		int failnum = 0;//����ʧ�ܼ�¼��
		String errmsg= "";//������Ϣ
    	DataPackage dp = this.doQueryDetail(params, user);
    	if (null != dp && dp.getDatas().size() > 0) {
    		Long priorRewardlistid=null;
    		boolean succ = false;
    		Iterator it = dp.getDatas().iterator();
    		do{
    			CityrecordVO vo = (CityrecordVO) it.next();
				vo.setTaskid(datestamp);
				try{
					succ = this.doIssue(params, vo, user, priorRewardlistid, succ);
				}catch(BusinessException be){
					System.out.println(be.getMessage());
					failnum++;
					errmsg = errmsg+"["+be.getMessage()+"] ";
					succ = false;
				}	
				priorRewardlistid=vo.getRewardlistid();
    		}while(it.hasNext());
		}
    	return new String[]{""+failnum,errmsg};
    }
	
	private boolean doIssue(CityrecordListVO params, CityrecordVO vo, User user, Long priorRewardlistid, boolean succ) throws BusinessException{
    	try{
			vo.setIsflag(new Short("1"));
			vo.setOprcode(user.getOpercode());
			vo.setOptime(new Date());	
			
			CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			//���������ȷ�ϳ������ͳ�ƻ���ʱ��δ���˳������ϴ����˴������������жϣ������ϴ����ʹ�������������жϣ�ֱ�ӷ�������
			if("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())){				
				CityrecordListVO listvo = new CityrecordListVO();
				//���������Ӱ�䵽һ����������
//				1��0��3��5��7��30��55��52��60������
//				2��1��4��6��54��51
//				3��2��53
				short type = vo.getRewardtype();
				if(type==1 || type==4 || type==6 || type==54 || type==51){
					vo.setRewardtype((short)2);
					vo.setRewardtypename("����");
				}else if(type==2 || type==53){
					vo.setRewardtype((short)3);
					vo.setRewardtypename("����");
				}else{
					vo.setRewardtype((short)1);
					vo.setRewardtypename("һ��");
				}
				String opnid2=vo.getOpnid().substring(0,2);
				if("04".equals(opnid2)){//�ն˳��
					listvo.set_se_opnid(vo.getOpnid());
					listvo.set_ne_rewardtype(vo.getRewardtype().toString());
					listvo.set_se_mobile(vo.getMobile());
					listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
					listvo.set_ne_systemflag("1");
					DataPackage dp = crcontrol.doQuery(listvo, user);
					if(null!=dp && dp.getDatas().size()>0){
						throw new BusinessException("","[rewardlistid="+vo.getRewardlistid()+"]�й�˾���ϴ���ͬ�ĳ����");
					}				
				}else if("0701010100001".equals(vo.getOpnid())
						|| "0701010100002".equals(vo.getOpnid())
						|| "0701010100003".equals(vo.getOpnid())
						|| "0701010100004".equals(vo.getOpnid())
						|| "0701010100005".equals(vo.getOpnid())
						|| "0701010100006".equals(vo.getOpnid())
						|| "0701010100007".equals(vo.getOpnid())
						|| "0701010100012".equals(vo.getOpnid())						
						|| "0701010100013".equals(vo.getOpnid())
						|| "0701020400239".equals(vo.getOpnid())
						|| "0702010100001".equals(vo.getOpnid())
						|| "0704010100001".equals(vo.getOpnid())
						|| "0705010100001".equals(vo.getOpnid())						
						){
					if(!vo.getRewardlistid().equals(priorRewardlistid)){
						//��ǰ��¼����һ��rewardlistid����ȣ���Ҫ���ظ���У��
						listvo.set_se_wayid(vo.getWayid());
						listvo.set_se_opnid(vo.getOpnid());
						String oprtime = PublicUtils.formatUtilDate(vo.getOprtime(),"yyyyMM");
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_ne_systemflag("1");
						String oprtimesql = " to_char(oprtime,'yyyyMM')='"+oprtime+"'";
						listvo.set_sql_oprtime(oprtimesql);
						DataPackage dp = crcontrol.doQuery(listvo, user);
						if(null!=dp && dp.getDatas().size()>0){
							throw new BusinessException("","[rewardlistid="+vo.getRewardlistid()+"]�й�˾���ϴ���ͬ�ĳ����");
						}
					}else{//��ǰ��¼����һ��rewardlistid��ȣ�����Ҫ���ظ���У��
						if(!succ){//��һ����¼����ʧ�ܣ���������ʱֱ�ӷ���false
							return false;
						}
					}
				}else{
					if(!vo.getRewardlistid().equals(priorRewardlistid)){
						//��ǰ��¼����һ��rewardlistid����ȣ���Ҫ���ظ���У��
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
						listvo.set_se_mobile(vo.getMobile());
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_ne_systemflag("1");
						DataPackage dp = crcontrol.doQuery(listvo, user);
						if(null!=dp && dp.getDatas().size()>0){
							throw new BusinessException("","[rewardlistid="+vo.getRewardlistid()+"]�й�˾���ϴ���ͬ�ĳ����");
						}
					}else{//��ǰ��¼����һ��rewardlistid��ȣ�����Ҫ���ظ���У��
						if(!succ){//��һ����¼����ʧ�ܣ���������ʱֱ�ӷ���false
							return false;
						}
					}										
				}
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){//��������
				//��rewardtypeӰ�䵽һ����������
				if(vo.getRewardtype()==10){
					vo.setRewardtype((short)2);
					vo.setRewardtypename("����");
				}else{
					vo.setRewardtype((short)1);
					vo.setRewardtypename("һ��");
				}
			}
			
			if(null!=vo.getRecordid()){
				crcontrol.doUpdate(vo, user);
			}else{
				crcontrol.doCreate(vo, user);
			}
			return true;
        }catch(BusinessException be){
        	throw be;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

	/**
     * 2012-8-11 shixiaolong
     * ��ʹ�ô˷���
     * @param vo
     * @param user
     * @throws Exception
     */
    @Deprecated
	public void doIssuecheck(CityrecordVO vo, User user) throws Exception {
		try{
//			CityrecordVO vo = new CityrecordVO();
//			vo.setRecordid(StringUtils.isNotBlank(vo.getRecordid())?new Long(pkValueArray[0]):null);
			vo.setIsflag(new Short("1"));
//			vo.setSystemflag(StringUtils.isNotBlank(pkValueArray[2])?new Short(pkValueArray[2]):null);
//			vo.setWayid(pkValueArray[3]);
//			vo.setOpnid(pkValueArray[4]);
//			vo.setRewardtype(StringUtils.isNotBlank(pkValueArray[5])?new Short(pkValueArray[5]):null);
//			vo.setMobile(pkValueArray[6]);
//			vo.setRewardmonth(pkValueArray[7]);
//			vo.setOprtime(PublicUtils.UtilStrToDate(pkValueArray[8]));
//			vo.setBusivalue(StringUtils.isNotBlank(pkValueArray[9])?new Double(pkValueArray[9]):null);
//			vo.setPaysum(StringUtils.isNotBlank(pkValueArray[10])?new Double(pkValueArray[10]):null);
//			vo.setPaymoney(StringUtils.isNotBlank(pkValueArray[11])?new Double(pkValueArray[11]):null);
//			vo.setApproveid(pkValueArray[12]);
//			vo.setRewardlistid(StringUtils.isNotBlank(pkValueArray[13])?new Long(pkValueArray[13]):null);
			vo.setOprcode(user.getOpercode());
			vo.setOptime(new Date());
			
			
			
			CityrecordControl crcontrol = (CityrecordControl) ControlFactory.build(CityrecordControlBean.class);
			CityrecordListVO listvo = new CityrecordListVO();
//			if(StringUtils.isNotBlank(pkValueArray[6])){//���MOBILE��Ϊ�յļƼ���ҵ��,����:��ҵ�����+ҵ����ʱ��+�������+ҵ���������IMEI��+�����·�
			if(StringUtils.isNotBlank(vo.getMobile())){
				listvo.set_se_opnid(vo.getOpnid());
				listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
				listvo.set_ne_rewardtype(vo.getRewardtype().toString());
				listvo.set_se_mobile(vo.getMobile());
				listvo.set_se_rewardmonth(vo.getRewardmonth());
				//listvo.set_ne_isflag("1");//�ѷ���
				String sql = " isflag in (0,1) ";
				listvo.set_sql_isflag(sql);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new BusinessException("","�й�˾���ϴ���ͬ�ĳ����");
				}				
//			}else if(StringUtils.isBlank(pkValueArray[6]) && ("0701010100004".equals(vo.getOpnid()) || 
    		}else if(StringUtils.isBlank(vo.getMobile()) && ("0701010100004".equals(vo.getOpnid()) || 
					"0701010100003".equals(vo.getOpnid()) || "0701010100002".equals(vo.getOpnid()))){//���MOBILEΪ�հ��ǼƼ���ҵ��,�����:�������+ҵ�����+������+ҵ����ʱ��+�����·�
				listvo.set_se_wayid(vo.getWayid());
				listvo.set_se_opnid(vo.getOpnid());
				listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
				listvo.set_ne_rewardtype(vo.getRewardtype().toString());
				listvo.set_se_rewardmonth(vo.getRewardmonth());
				//listvo.set_ne_isflag("1");//�ѷ���
				String sql = " isflag in (0,1) ";
				listvo.set_sql_isflag(sql);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new BusinessException("","�й�˾���ϴ���ͬ�ĳ����");
				}
			}
			if(null!=vo.getRecordid()){
//				crcontrol.doUpdate(vo, user);
			}else{
//				crcontrol.doCreate(vo, user);
			}
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
		
	}

	public DataPackage doThreeQuery4Thread(CityrecordListVO params, User user)
			throws Exception {

			if("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())){
				//���������ʶISFLAG=2��ȷ���ҼƳ�ϵͳSYSTEMFLAG=2���ѯ������������ϸ��¼��
				RewardrecordListVO rrlistvo = new RewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);				
				return dao.doQuery4Thread(rrlistvo, user);
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
				//���������ʶISFLAG=2��ȷ���ҼƳ�ϵͳSYSTEMFLAG=3���ѯBBC�����ϸ��¼
				BbcRewardrecord2Control rrcontrol = (BbcRewardrecord2Control) ControlFactory.build(BbcRewardrecord2ControlBean.class);
				BbcRewardrecord2ListVO rrlistvo = new BbcRewardrecord2ListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				BbcRewardrecord2DAO dao=(BbcRewardrecord2DAO)DAOFactory.build(BbcRewardrecord2DAO.class,user);				
				return dao.doQuery4Thread(rrlistvo, user);
			}
			return null;    
	}

	
	public DataPackage doListstatenhance(CityrecordListVO params, User user)
			throws Exception {
		VCityrecordListVO listVO=new VCityrecordListVO();
		BeanUtils.copyProperties(listVO, params);
		VCityrecordDAO dao = (VCityrecordDAO) DAOFactory.build(VCityrecordDAO.class, user);
		DataPackage dp = new DataPackage();
//		if ((params.get_se_opnid() == null || params.get_se_opnid().equals(""))
//				&& (params.get_se_opnid2() == null || params.get_se_opnid2().equals(""))) {
//			// ҳ��δѡ��ҵ������
//			dp = dao.liststatenhanceWithoutopnid(listVO, user);
//		} else if (params.get_se_opnid2() != null && !params.get_se_opnid2().equals("")) {
//			// ����������ѡ��ҵ��С��
//			dp=dao.liststatenhanceWithtwolevelopnid(listVO, user);
//		} else if (params.get_se_opnid() != null && !params.get_se_opnid().equals("")) {
//			// �����ѯ������ѡ��ҵ����൫δѡ��ҵ��С��
//			dp=dao.liststatenhanceWithonelevelopnid(listVO, user);
//		}
		dp = dao.liststatenhance(listVO, user);
		return dp;
	}
	
	public DataPackage doListstatenhancecount(CityrecordListVO params, User user)throws Exception {
		CityrecordDAO dao = (CityrecordDAO)DAOFactory.build(CityrecordDAO.class, user);
		return dao.doQuerystatcount(params, user);
}

	public DataPackage doOnlysum(CityrecordListVO params, User user)
			throws Exception {
		VCityrecordList2VO listVO=new VCityrecordList2VO();
		BeanUtils.copyProperties(listVO, params);
		VCityrecord2DAO dao = (VCityrecord2DAO) DAOFactory.build(VCityrecord2DAO.class, user);
		return dao.onlysum(listVO, user);
	}
	
	public DataPackage doListstatenhanceexcel(CityrecordListVO params, User user)
	throws Exception {
		VCityrecordListVO listVO=new VCityrecordListVO();
		BeanUtils.copyProperties(listVO, params);
		//CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
		VCityrecordDAO dao = (VCityrecordDAO) DAOFactory.build(VCityrecordDAO.class, user);
		String opnidstart = params.get_se_opnid();
		//String wayid = params.get_se_wayid();
		//String waylike = params.get_se_waylike();
		//String month = params.get_se_rewardmonth();
		//String systemflag = params.get_ne_systemflag();
		Short opnlevel = 0;
		if(StringUtils.isNotBlank(opnidstart)){
			OperationControl oprcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
			OperationVO oprvo = oprcontrol.doFindByPk(opnidstart, user);
			if(oprvo==null){
				throw new BusinessException("","ҵ����벻����!");
			}
			opnlevel = oprvo.getOpnlevel();//��ȡҵ�����Ĳ㼶 
		}
		DataPackage dp = new DataPackage();
		//  --�ڵ�Ϊ��  ��0����
		if(StringUtils.isBlank(opnidstart)){
			dp=dao.liststatenhanceWithoutopnid(listVO, user);
		}else if(StringUtils.isNotBlank(opnidstart) && opnlevel==1 ){
			//--�ڵ�Ϊ1��
			dp=dao.liststatenhanceWithonelevelopnid(listVO, user);
			
		}else
		{  //--�ڵ�Ϊ2��������			
			dp=dao.liststatenhanceWithtwolevelopnid(listVO, user);			
		}
		
		return dp;
	}
	
	 /**
     * 
     * @param params
     * @param user
     * @param querytype 1��ѯ���ݡ�2ͳ��������3��ѯ���ݺ�ͳ������
     * @return
     * @throws Exception
     */
	public DataPackage doQueryMainopn(CityrecordListVO params, User user, int querytype)throws Exception{
		RewardrecordListVO rrlistvo = new RewardrecordListVO();
		BeanUtils.copyProperties(rrlistvo, params);
		RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);		
		return dao.doQueryMainopn(rrlistvo, user, querytype);
	}
	public int doSaveMainopn(CityrecordListVO params, User user, long datestamp, int batchsize)throws Exception{
		RewardrecordListVO rrlistvo = new RewardrecordListVO();
		BeanUtils.copyProperties(rrlistvo, params);
		RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);
		return dao.doInsertMainopn(rrlistvo, user, datestamp, batchsize);
	}
	 /**
     * 
     * @param params
     * @param user
     * @param querytype 1��ѯ���ݡ�2ͳ��������3��ѯ���ݺ�ͳ������
     * @return
     * @throws Exception
     */
	public DataPackage doQuerySpecialopn07(CityrecordListVO params, User user, int querytype)throws Exception{
		RewardrecordListVO rrlistvo = new RewardrecordListVO();
		BeanUtils.copyProperties(rrlistvo, params);
		RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);	
		return dao.doQuerySpecialopn07(rrlistvo, user, querytype);
	}
	public int doSaveSpecialopn07(CityrecordListVO params, User user, long datestamp, int batchsize)throws Exception{
		RewardrecordListVO rrlistvo = new RewardrecordListVO();
		BeanUtils.copyProperties(rrlistvo, params);
		RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);
		return dao.doInsertSpecialopn07(rrlistvo, user, datestamp, batchsize);
	}
	 /**
     * 
     * @param params
     * @param user
     * @param querytype 1��ѯ���ݡ�2ͳ��������3��ѯ���ݺ�ͳ������
     * @return
     * @throws Exception
     */
	public DataPackage doQuerySpecialopn0403(CityrecordListVO params, User user, int querytype)throws Exception{
		RewardrecordListVO rrlistvo = new RewardrecordListVO();
		BeanUtils.copyProperties(rrlistvo, params);
		RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);	
		return dao.doQuerySpecialopn0403(rrlistvo, user, querytype);
	}
	public int doSaveSpecialopn0403(CityrecordListVO params, User user, long datestamp, int batchsize)throws Exception{
		RewardrecordListVO rrlistvo = new RewardrecordListVO();
		BeanUtils.copyProperties(rrlistvo, params);
		RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);	
		return dao.doInsertSpecialopn0403(rrlistvo, user, datestamp, batchsize);
	}
	
	/**
	 * COMS��ϸ������ѯ
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryexceldetail(CityrecordListVO params, User user) throws Exception{		
		DataPackage dp = new DataPackage();		
		if("2".equals(params.get_ne_systemflag())){//�������
			RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);
			RewardrecordListVO listvo = new RewardrecordListVO();
			BeanUtils.copyProperties(listvo, params);
			listvo.set_orderby("rewardlistid");
			listvo.set_desc("0");
			dp = dao.doQuery4Detailexport(listvo, user);
			//dp = dao.doQuerypw(listvo, user);			
		}else if("3".equals(params.get_ne_systemflag())){//��������
			VCityrecord4DAO dao = (VCityrecord4DAO)DAOFactory.build(VCityrecord4DAO.class, user);
			VCityrecordList4VO listvo = new VCityrecordList4VO();
			BeanUtils.copyProperties(listvo, params);
			listvo.set_orderby("wayid,opnid,rewardtype,oprtime");
			listvo.set_desc("0");
			dp = dao.doQuerybbc(listvo, user);
		}else{
			throw new Exception("ֻ����[����������]��[�������˳��]����COMS��ϸ����");
		}
		return dp;
	}

	public int updateIsflagByDcordid(Short isflag, Long dcordid, User user)
			throws Exception {
		CityrecordDAO dao = (CityrecordDAO)DAOFactory.build(CityrecordDAO.class, user);
		return dao.updateIsflagByDcordid(isflag, dcordid);
	}
}
