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
		if(countyid!=null && countyid.trim().length()>0){//分公司数据查询
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
				//  根据输入的’业务层次编码’查询CH_PW_OPERATION表,如果所选的编码不是业务细项,
				//  则根据当前编码获取下属业务层级下的全量业务编码集进行查询
				OperationControl operationcontrol = (OperationControl) ControlFactory.build(OperationControlBean.class);
				OperationVO operationvo = operationcontrol.doFindByPk(params.getSqlopnid(), user);
				if(operationvo==null){
					throw new Exception("业务层级编码不存在");
				}
				if (operationvo.getOpnlevel()!=5){//不是业务细项
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
				//如果发布标识ISFLAG=2待确认且计酬系统SYSTEMFLAG=2则查询社会渠道酬金明细记录表
				RewardrecordControl rrcontrol = (RewardrecordControl) ControlFactory.build(RewardrecordControlBean.class);
				RewardrecordListVO rrlistvo = new RewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				String rewardlistidsql = "rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=2)";
				//String rewardlistidsql = " not exists( SELECT REWARDLISTID from CH_ADT_CITYRECORD where SYSTEMFLAG=2 and REWARDLISTID IS NOT NULL and REWARDMONTH='"+ rrlistvo.get_se_rewardmonth() +"')";
				rrlistvo.set_sql_rewardlistid(rewardlistidsql);
				//以下为了求出分页所需总行数
//				RewardrecordListVO rrlistvo2 = new RewardrecordListVO();
//				BeanUtils.copyProperties(rrlistvo2, rrlistvo);
//				rrlistvo2.set_pagesize("0");
//				DataPackage dpforpage = rrcontrol.doQuery2(rrlistvo2, user);
				//over
				DataPackage dptemp = rrcontrol.doQuery2(rrlistvo, user);
				if(null!=dptemp && dptemp.getDatas().size()>0){
					for(Iterator it = dptemp.getDatas().iterator();it.hasNext();){
						RewardrecordVO rrvo = (RewardrecordVO)it.next();
						if((rrvo.getPaymoney2()==null || rrvo.getPaymoney2()==0) && (rrvo.getPaymoney3()==null || rrvo.getPaymoney3()==0)){//不入酬金池的
							CityrecordVO crvo = new CityrecordVO();
							BeanUtils.copyProperties(crvo, rrvo);
							if("0403".equals(rrvo.getOpnid().substring(0, 4))){
								crvo.setMobile(rrvo.getBakinfo());
							}
							crvo.setIsflag((short)2);
							crvo.setSystemflag((short)2);
							crvo.setPaymoney(rrvo.getPaysum());
							crvo.setRewardlistid(rrvo.getRewardlistid());
							//特殊处理酬金期数
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
						}else{//入酬金池的
							//第一条记录：
							CityrecordVO crvo1 = new CityrecordVO();
							BeanUtils.copyProperties(crvo1, rrvo);
							crvo1.setIsflag((short)2);
							crvo1.setSystemflag((short)2);
							
							crvo1.setRewardmonth(rrvo.getPaymonth1());
							crvo1.setPaymoney(rrvo.getPaymoney1());
							crvo1.setRewardlistid(rrvo.getRewardlistid());
							//特殊处理酬金期数
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
							//第二条记录：
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
								//第三条记录：
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
				// 1条变3条,rowcount变化了,有些记录就放在下一页了.
				dp.setRowCount(list.size());
				return dp;
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
				//如果发布标识ISFLAG=2待确认且计酬系统SYSTEMFLAG=3则查询BBC酬金明细记录
				BbcRewardrecord2Control rrcontrol = (BbcRewardrecord2Control) ControlFactory.build(BbcRewardrecord2ControlBean.class);
				BbcRewardrecord2ListVO rrlistvo = new BbcRewardrecord2ListVO();
				String sql = " ossrc in (3,4,5) ";
				rrlistvo.set_sql_ossrc(sql);
				BeanUtils.copyProperties(rrlistvo, params);
				String rewardlistidsql = "rewardlistid not in( SELECT nvl(REWARDLISTID,'') from CH_ADT_CITYRECORD where SYSTEMFLAG=3)"; 
				//String rewardlistidsql = " not exists( SELECT REWARDLISTID from CH_ADT_CITYRECORD where SYSTEMFLAG=3 and REWARDLISTID IS NOT NULL and REWARDMONTH='"+ rrlistvo.get_se_rewardmonth() +"')";
				rrlistvo.set_sql_rewardlistid(rewardlistidsql);
				//以下为了求出分页所需总行数
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
						//特殊处理酬金期数
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
				//其它查询条件组合均从CH_ADT_CITYRECORD表获取
				dp = dao.query(params);
//				dp=dao.doQuerycnt(params, user);
				List<CityrecordVO> dplist = new ArrayList<CityrecordVO>();
				for(Iterator<CityrecordVO> it = dp.getDatas().iterator();it.hasNext();){
					CityrecordVO vo = it.next();
					//特殊处理酬金期数
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
			if(StringUtils.isNotBlank(pkValueArray[6])){//如果MOBILE不为空的计件类业务,根据:用业务编码+业务发生时间+酬金期数+业务发生号码或IMEI号+结算月份
				listvo.set_se_opnid(vo.getOpnid());
				listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
				listvo.set_ne_rewardtype(vo.getRewardtype().toString());
				listvo.set_se_mobile(vo.getMobile());
				listvo.set_se_rewardmonth(vo.getRewardmonth());
				//listvo.set_ne_isflag("1");//已发布
				String sql = " isflag in (0,1) ";
				listvo.set_sql_isflag(sql);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new BusinessException("","市公司已上传相同的酬金结果");
				}				
			}else if(StringUtils.isBlank(pkValueArray[6]) && ("0701010100004".equals(vo.getOpnid()) || 
					"0701010100003".equals(vo.getOpnid()) || "0701010100002".equals(vo.getOpnid()))){//如果MOBILE为空按非计件类业务,则根据:网点编码+业务编码+酬期数+业务发生时间+结算月份
				listvo.set_se_wayid(vo.getWayid());
				listvo.set_se_opnid(vo.getOpnid());
				listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
				listvo.set_ne_rewardtype(vo.getRewardtype().toString());
				listvo.set_se_rewardmonth(vo.getRewardmonth());
				//listvo.set_ne_isflag("1");//已发布
				String sql = " isflag in (0,1) ";
				listvo.set_sql_isflag(sql);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new BusinessException("","市公司已上传相同的酬金结果");
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
					if(StringUtils.isNotBlank(vo.getMobile())){//如果MOBILE不为空的计件类业务,根据:用业务编码+业务发生时间+酬金期数+业务发生号码或IMEI号+结算月份
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_se_mobile(vo.getMobile());
						listvo.set_se_rewardmonth(vo.getRewardmonth());
						//listvo.set_ne_isflag("1");//已发布
						String sql = " isflag in (0,1) ";
						listvo.set_sql_isflag(sql);
						DataPackage dp2 = crcontrol.doQuery(listvo, user);
						if(null!=dp2 && dp2.getDatas().size()>0){
							throw new BusinessException("","市公司已上传相同的酬金结果");
						}
					}else if(StringUtils.isBlank(vo.getMobile()) && ("0701010100004".equals(vo.getOpnid()) || 
							"0701010100003".equals(vo.getOpnid()) || "0701010100002".equals(vo.getOpnid()))){//如果MOBILE为空按非计件类业务,则根据:网点编码+业务编码+酬期数+业务发生时间+结算月份
						listvo.set_se_wayid(vo.getWayid());
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_se_rewardmonth(vo.getRewardmonth());
						//listvo.set_ne_isflag("1");//已发布
						String sql = " isflag in (0,1) ";
						listvo.set_sql_isflag(sql);
						DataPackage dp2 = crcontrol.doQuery(listvo, user);
						if(null!=dp2 && dp2.getDatas().size()>0){
							throw new BusinessException("","市公司已上传相同的酬金结果");
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
    	LocalDataPackage dp = new LocalDataPackage();//结果集合
    	double totalSumpaymoney=0;//合计总应结酬金
    	double totalSumConfirmmoney=0;//合计已确认
    	double tatalSumNotconfirmmoney=0;//合计待发布确认
    	List<CityrecordTableVO> retlist = new ArrayList<CityrecordTableVO>();//结果集合
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
        		throw new BusinessException("","业务编码不存在!");
        	}
        	opnlevel = oprvo.getOpnlevel();//获取业务编码的层级 
    	}
    	
    	if(StringUtils.isNotBlank(opnidstart) && opnlevel!=1 ){//界面上业务层级编码不为空,并且业务编码的层级不是1级（最高级），
    														   //则以此为起点统计此业务层级下面所有的业务细项
    		List opnidandparentid = dao.getOpnidandParentid(opnidstart);
    		Object opnidobj[] = (Object[])opnidandparentid.get(0);
    		String opnidone = (String)opnidobj[1];//一级业务编码
    		String opnidtwo = (String)opnidobj[0];//二级业务编码
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
					if((Short)obje[3]==0){//已确认
						info.setSumconfirmmoney((info.getSumconfirmmoney()==null?0d:info.getSumconfirmmoney()) + (Double)obje[5]);
					}else{//已发布
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
					info.setOpnidonereplacer(opnidone);//为替身赋值
					info.setOpnidtwo(opnidtwo);
					info.setOpnidtworeplacer(opnidtwo);//为替身赋值
					info.setRewardtype((String)obje[0]);
					info.setRewardtypereplacer((String)obje[0]);//为替身赋值
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
					info.setOprmonthreplacer((String)obje[2]);//为替身赋值
					if(obje[4]!=null){
						info.setSumbusivalue((Double)obje[4]);
					}else{
						info.setSumbusivalue(0.0);
					}
					if((Short)obje[3]==0){//已确认
						info.setSumconfirmmoney((Double)obje[5]);
						info.setSumnotconfirmmoney(0d);
					}else{//已发布
						info.setSumconfirmmoney(0d);
						info.setSumnotconfirmmoney((Double)obje[5]);
					}
					if(obje[5]!=null ){
						info.setSumpaymoney((Double)obje[5]);//总应结酬金
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
			
    	}else{//界面上业务层级编码为空或者业务编码的层级为第一级，则统计所有的业务细项（或第一级下面的所有业务细项）
    		List opnidandparentid = dao.getOpnidandParentid2(opnidstart,opnlevel);
    		for (Iterator it = opnidandparentid.iterator(); it.hasNext();) {
    			Object opnidobj[] = (Object[])it.next();	//[一级业务编码，二级业务编码]
    			String opnidone = (String)opnidobj[0];//一级业务编码
        		String opnidtwo = (String)opnidobj[1];//二级业务编码
        		
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
    					if ((Short) obje[3] == 0) {// 已确认
    						info.setSumconfirmmoney((info.getSumconfirmmoney() == null ? 0d
    										: info.getSumconfirmmoney())
    										+ (Double) obje[5]);
    					} else {// 已发布
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
    					info.setOpnidonereplacer(opnidone);//为替身赋值
    					info.setOpnidtwo(opnidtwo);
    					info.setOpnidtworeplacer(opnidtwo);//为替身赋值
    					info.setRewardtype((String) obje[0]);
    					info.setRewardtypereplacer((String)obje[0]);//为替身赋值
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
    					info.setOprmonthreplacer((String)obje[2]);//为替身赋值
    					if (obje[4] != null) {
    						info.setSumbusivalue((Double) obje[4]);
    					} else {
    						info.setSumbusivalue(0.0);
    					}
    					if ((Short) obje[3] == 0) {// 已确认
    						info.setSumconfirmmoney((Double) obje[5]);
    						info.setSumnotconfirmmoney(0d);
    					} else {// 已发布
    						info.setSumconfirmmoney(0d);
    						info.setSumnotconfirmmoney((Double) obje[5]);
    					}
    					if (obje[5] != null) {
    						info.setSumpaymoney((Double) obje[5]);// 总应结酬金
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
    	
		
		//格式化之，为了页面的布局（合并同类项）
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
    
    //全部确认逻辑
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
    		List opnidandparentid = dao.getOpnidandParentid2(opnidstart,(short)0);//列出所有一级二级组合情况
    		for (Iterator it = opnidandparentid.iterator(); it.hasNext();) {
    			Object opnidobj[] = (Object[])it.next();	//[一级业务编码，二级业务编码]
    			//String opnidone = (String)opnidobj[0];//一级业务编码
        		String opnidtwo = (String)opnidobj[1];//二级业务编码
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
  //全部确认逻辑
    public int doAllConfirm(CityrecordListVO params, User user)
		throws Exception {
    	CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	return dao.confirmall(params, user);
    }
  //确认页面之单条确认逻辑
    public void doConfirmonebak(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, User user)
		throws Exception {
    	CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	String opnidstart = StringUtils.isBlank(params.get_se_opnid())?opnid2:params.get_se_opnid();
    	//获取opnidstart的层级
    	OperationControl oprcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
    	OperationVO oprvo = oprcontrol.doFindByPk(opnidstart, user);
    	if(oprvo==null){
    		throw new BusinessException("","业务编码不存在!");
    	}
    	Short opnlevel = oprvo.getOpnlevel();//获取业务编码的层级 
    	if(opnlevel==1){
    		opnidstart = opnid2;//如果界面所选业务编码为1级，则无法根据酬金期数和业务发生月确定出界出所查出的那条记录，
    							//需要传入二级业务编码，即业务归属
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
  //确认页面之单条确认逻辑
    public int doConfirmone(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, User user)
		throws Exception {
    	CityrecordDAO dao = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
    	String opnidstart = StringUtils.isBlank(params.get_se_opnid())?opnid2:params.get_se_opnid();
    	//获取opnidstart的层级
    	OperationControl oprcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
    	OperationVO oprvo = oprcontrol.doFindByPk(opnidstart, user);
    	if(oprvo==null){
    		throw new BusinessException("","业务编码不存在!");
    	}
    	Short opnlevel = oprvo.getOpnlevel();//获取业务编码的层级 
    	if(opnlevel==1){
    		opnidstart = opnid2;//如果界面所选业务编码为1级，则无法根据酬金期数和业务发生月确定出界出所查出的那条记录，
    							//需要传入二级业务编码，即业务归属
    	}
    	return dao.confirmone(params,opnidstart,rewardtype,oprmonth, user);
    }
    //确认页面之明细逻辑
    public DataPackage doListdetail(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, String isflag,User user)
		throws Exception {
    	String opnidstart = StringUtils.isBlank(params.get_se_opnid())?opnid2:params.get_se_opnid();
    	//获取opnidstart的层级
    	OperationControl oprcontrol = (OperationControl)ControlFactory.build(OperationControlBean.class);
    	OperationVO oprvo = oprcontrol.doFindByPk(opnidstart, user);
    	if(oprvo==null){
    		throw new BusinessException("","业务编码不存在!");
    	}
    	Short opnlevel = oprvo.getOpnlevel();//获取业务编码的层级 
    	if(opnlevel==1){
    		opnidstart = opnid2;//如果界面所选业务编码为1级，则无法根据酬金期数和业务发生月确定出界出所查出的那条记录，
    							//需要传入二级业务编码，即业务归属
    	}
    	params.set_se_opnid(opnidstart);
    	//month--> rewardmonth ,oprmonth--> oprtime
    	params.set_de_oprtime(oprmonth);
    	params.set_ne_rewardtype(rewardtype);
    	params.set_ne_isflag(isflag);

    	//改成分页处理
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
    		vo.setPaymoney(obj.getPaymoney()==null?0:(Double)obj.getPaymoney());//若为空，则取0
    		vo.setPaysum(obj.getPaysum()==null?0:(Double)obj.getPaysum());//若为空，则取0
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
				//如果发布标识ISFLAG=1待确认且计酬系统SYSTEMFLAG=2则查询社会渠道酬金明细记录表
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
						if(rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()!=0){//第一期不等于零
							CityrecordVO crvo = new CityrecordVO();
							BeanUtils.copyProperties(crvo, rrvo);							
							if(rrvo.getOpnid()!=null){
								String opnid2 = rrvo.getOpnid().substring(0, 2);
								if("04".equals(opnid2)){//终端酬金
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
	    				if(rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()!=0){//第二期不等于零
	    					CityrecordVO crvo2 = new CityrecordVO();
							BeanUtils.copyProperties(crvo2, rrvo);
							crvo2.setIsflag((short)1);
							crvo2.setSystemflag((short)2);															
							crvo2.setRewardmonth(rrvo.getPaymonth2());
							crvo2.setPaymoney(rrvo.getPaymoney2());
							crvo2.setRewardtypename(rewardtypename);
							if(rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()>0){
								crvo2.setPaysum((double)0);//存在第一期，此处总额设为零
							}
							list.add(crvo2);
	    				}
	    				if(rrvo.getPaymoney3()!=null && rrvo.getPaymoney3()!=0){//第三期不等于零    							
	    					CityrecordVO crvo3 = new CityrecordVO();
							BeanUtils.copyProperties(crvo3, rrvo);
							crvo3.setIsflag((short)1);
							crvo3.setSystemflag((short)2);							
							crvo3.setRewardmonth(rrvo.getPaymonth3());							
							crvo3.setPaymoney(rrvo.getPaymoney3());
							crvo3.setRewardtypename(rewardtypename);
							if((rrvo.getPaymoney1()!=null && rrvo.getPaymoney1()>0) || (rrvo.getPaymoney2()!=null && rrvo.getPaymoney2()>0)){
								crvo3.setPaysum((double)0);//存在第一或第二期，此处总额设为零
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
				//如果发布标识ISFLAG=1待确认且计酬系统SYSTEMFLAG=3则查询BBC酬金明细记录
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
						//特殊处理酬金期数
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
				//其它查询条件组合均从CH_ADT_CITYRECORD表获取
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
			//如果发布标识ISFLAG=1待确认且计酬系统SYSTEMFLAG=2则查询社会渠道酬金明细记录表
			RewardrecordControl rrcontrol = (RewardrecordControl) ControlFactory.build(RewardrecordControlBean.class);
			RewardrecordListVO rrlistvo = new RewardrecordListVO();
			BeanUtils.copyProperties(rrlistvo, params);
			DataPackage dptemp = rrcontrol.doQuery3(rrlistvo, user);
			if(null!=dptemp && dptemp.getDatas().size()>0){
				for(Iterator it = dptemp.getDatas().iterator();it.hasNext();){
					VRewardrecordVO rrvo = (VRewardrecordVO)it.next();
					//特殊处理酬金期数
					String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), ""+rrvo.getRewardtype());
					rrvo.setRewardtypename(rewardtypename);
				}
			}
			return dptemp;
		}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
			//如果发布标识ISFLAG=1待确认且计酬系统SYSTEMFLAG=3则查询BBC酬金明细记录
			BbcRewardrecord2Control rrcontrol = (BbcRewardrecord2Control) ControlFactory.build(BbcRewardrecord2ControlBean.class);
			BbcRewardrecord2ListVO rrlistvo = new BbcRewardrecord2ListVO();
			BeanUtils.copyProperties(rrlistvo, params);
			DataPackage dptemp2 = rrcontrol.doQuery3(rrlistvo, user);//VBbcRewardrecord2VO
			if(null!=dptemp2 && dptemp2.getDatas().size()>0){
				for(Iterator it = dptemp2.getDatas().iterator();it.hasNext();){
					VBbcRewardrecord2VO rrvo = (VBbcRewardrecord2VO)it.next();
					//特殊处理酬金期数
					String rewardtypename = ChrewardtypeCacheUtil.getCityRewardname(user.getCityid(), ""+rrvo.getRewardtype());
					rrvo.setRewardtypename(rewardtypename);
				}
			}
			return dptemp2 ;
		}else{
			//其它查询条件组合均从CH_ADT_CITYRECORD表获取
			CityrecordtotalControl control = (CityrecordtotalControl) ControlFactory.build(CityrecordtotalControlBean.class);
			CityrecordtotalListVO listvo = new CityrecordtotalListVO();
			BeanUtils.copyProperties(listvo, params);
			dp=control.doQuerycnt(listvo, user);
			List<CityrecordtotalVO> dplist = new ArrayList<CityrecordtotalVO>();
			for(Iterator<CityrecordtotalVO> it = dp.getDatas().iterator();it.hasNext();){
				CityrecordtotalVO vo = it.next();
				//特殊处理酬金期数CH_ADT_CITYREWARD只分一二三期
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
				//如果发布标识ISFLAG=1待确认且计酬系统SYSTEMFLAG=2则查询社会渠道酬金明细记录表
				RewardrecordDAO pwdao = (RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class, user.getCityid());
				RewardrecordListVO rrlistvo = new RewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				DataPackage dptemp = pwdao.doQuerycount(rrlistvo, user);
				return dptemp;
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
				//如果发布标识ISFLAG=1待确认且计酬系统SYSTEMFLAG=3则查询BBC酬金明细记录
				BbcRewardrecordDAO bbcdao = (BbcRewardrecordDAO) DAOFactory.build(BbcRewardrecordDAO.class, user);
				BbcRewardrecordListVO rrlistvo = new BbcRewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				DataPackage dptemp2 = bbcdao.doQuerycount(rrlistvo, user);
				return dptemp2 ;
			}else{
				//其它查询条件组合均从CH_ADT_CITYRECORD表获取
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
	 * 单笔删除，该方法不再使用
	 * 20120914 将该功能从[地市酬金明细上传管理]迁移到[酬金明细数据查询]菜单
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
		//发布
		int failnum = 0;//发布失败记录数
		String errmsg= "";//错误信息
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
			//社会渠道待确认酬金由于统计汇总时，未过滤出地市上传，此处需逐条具体判断；地上上传酬金和创新联盟无需此判断，直接发布即可
			if("1".equals(params.get_ne_isflag()) && "2".equals(params.get_ne_systemflag())){				
				CityrecordListVO listvo = new CityrecordListVO();
				//将酬金类型影射到一、二、三期
//				1：0、3、5、7、30、55、52、60、其他
//				2：1、4、6、54、51
//				3：2、53
				short type = vo.getRewardtype();
				if(type==1 || type==4 || type==6 || type==54 || type==51){
					vo.setRewardtype((short)2);
					vo.setRewardtypename("二期");
				}else if(type==2 || type==53){
					vo.setRewardtype((short)3);
					vo.setRewardtypename("三期");
				}else{
					vo.setRewardtype((short)1);
					vo.setRewardtypename("一期");
				}
				String opnid2=vo.getOpnid().substring(0,2);
				if("04".equals(opnid2)){//终端酬金
					listvo.set_se_opnid(vo.getOpnid());
					listvo.set_ne_rewardtype(vo.getRewardtype().toString());
					listvo.set_se_mobile(vo.getMobile());
					listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
					listvo.set_ne_systemflag("1");
					DataPackage dp = crcontrol.doQuery(listvo, user);
					if(null!=dp && dp.getDatas().size()>0){
						throw new BusinessException("","[rewardlistid="+vo.getRewardlistid()+"]市公司已上传相同的酬金结果");
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
						//当前记录与上一条rewardlistid不相等，需要做重复性校验
						listvo.set_se_wayid(vo.getWayid());
						listvo.set_se_opnid(vo.getOpnid());
						String oprtime = PublicUtils.formatUtilDate(vo.getOprtime(),"yyyyMM");
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_ne_systemflag("1");
						String oprtimesql = " to_char(oprtime,'yyyyMM')='"+oprtime+"'";
						listvo.set_sql_oprtime(oprtimesql);
						DataPackage dp = crcontrol.doQuery(listvo, user);
						if(null!=dp && dp.getDatas().size()>0){
							throw new BusinessException("","[rewardlistid="+vo.getRewardlistid()+"]市公司已上传相同的酬金结果");
						}
					}else{//当前记录与上一条rewardlistid相等，不需要做重复性校验
						if(!succ){//上一条记录保存失败，本条处理时直接返回false
							return false;
						}
					}
				}else{
					if(!vo.getRewardlistid().equals(priorRewardlistid)){
						//当前记录与上一条rewardlistid不相等，需要做重复性校验
						listvo.set_se_opnid(vo.getOpnid());
						listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
						listvo.set_se_mobile(vo.getMobile());
						listvo.set_ne_rewardtype(vo.getRewardtype().toString());
						listvo.set_ne_systemflag("1");
						DataPackage dp = crcontrol.doQuery(listvo, user);
						if(null!=dp && dp.getDatas().size()>0){
							throw new BusinessException("","[rewardlistid="+vo.getRewardlistid()+"]市公司已上传相同的酬金结果");
						}
					}else{//当前记录与上一条rewardlistid相等，不需要做重复性校验
						if(!succ){//上一条记录保存失败，本条处理时直接返回false
							return false;
						}
					}										
				}
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){//创新联盟
				//将rewardtype影射到一、二、三期
				if(vo.getRewardtype()==10){
					vo.setRewardtype((short)2);
					vo.setRewardtypename("二期");
				}else{
					vo.setRewardtype((short)1);
					vo.setRewardtypename("一期");
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
     * 不使用此方法
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
//			if(StringUtils.isNotBlank(pkValueArray[6])){//如果MOBILE不为空的计件类业务,根据:用业务编码+业务发生时间+酬金期数+业务发生号码或IMEI号+结算月份
			if(StringUtils.isNotBlank(vo.getMobile())){
				listvo.set_se_opnid(vo.getOpnid());
				listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
				listvo.set_ne_rewardtype(vo.getRewardtype().toString());
				listvo.set_se_mobile(vo.getMobile());
				listvo.set_se_rewardmonth(vo.getRewardmonth());
				//listvo.set_ne_isflag("1");//已发布
				String sql = " isflag in (0,1) ";
				listvo.set_sql_isflag(sql);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new BusinessException("","市公司已上传相同的酬金结果");
				}				
//			}else if(StringUtils.isBlank(pkValueArray[6]) && ("0701010100004".equals(vo.getOpnid()) || 
    		}else if(StringUtils.isBlank(vo.getMobile()) && ("0701010100004".equals(vo.getOpnid()) || 
					"0701010100003".equals(vo.getOpnid()) || "0701010100002".equals(vo.getOpnid()))){//如果MOBILE为空按非计件类业务,则根据:网点编码+业务编码+酬期数+业务发生时间+结算月份
				listvo.set_se_wayid(vo.getWayid());
				listvo.set_se_opnid(vo.getOpnid());
				listvo.set_de_oprtime(PublicUtils.formatUtilDate(vo.getOprtime(),"yyyy-MM-dd HH:mm:ss"));
				listvo.set_ne_rewardtype(vo.getRewardtype().toString());
				listvo.set_se_rewardmonth(vo.getRewardmonth());
				//listvo.set_ne_isflag("1");//已发布
				String sql = " isflag in (0,1) ";
				listvo.set_sql_isflag(sql);
				DataPackage dp = crcontrol.doQuery(listvo, user);
				if(null!=dp && dp.getDatas().size()>0){
					throw new BusinessException("","市公司已上传相同的酬金结果");
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
				//如果发布标识ISFLAG=2待确认且计酬系统SYSTEMFLAG=2则查询社会渠道酬金明细记录表
				RewardrecordListVO rrlistvo = new RewardrecordListVO();
				BeanUtils.copyProperties(rrlistvo, params);
				RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);				
				return dao.doQuery4Thread(rrlistvo, user);
			}else if("1".equals(params.get_ne_isflag()) && "3".equals(params.get_ne_systemflag())){
				//如果发布标识ISFLAG=2待确认且计酬系统SYSTEMFLAG=3则查询BBC酬金明细记录
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
//			// 页面未选定业务类型
//			dp = dao.liststatenhanceWithoutopnid(listVO, user);
//		} else if (params.get_se_opnid2() != null && !params.get_se_opnid2().equals("")) {
//			// 界面条件有选择业务小类
//			dp=dao.liststatenhanceWithtwolevelopnid(listVO, user);
//		} else if (params.get_se_opnid() != null && !params.get_se_opnid().equals("")) {
//			// 界面查询条件有选择业务大类但未选择业务小类
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
				throw new BusinessException("","业务编码不存在!");
			}
			opnlevel = oprvo.getOpnlevel();//获取业务编码的层级 
		}
		DataPackage dp = new DataPackage();
		//  --节点为空  （0级）
		if(StringUtils.isBlank(opnidstart)){
			dp=dao.liststatenhanceWithoutopnid(listVO, user);
		}else if(StringUtils.isNotBlank(opnidstart) && opnlevel==1 ){
			//--节点为1级
			dp=dao.liststatenhanceWithonelevelopnid(listVO, user);
			
		}else
		{  //--节点为2级及以下			
			dp=dao.liststatenhanceWithtwolevelopnid(listVO, user);			
		}
		
		return dp;
	}
	
	 /**
     * 
     * @param params
     * @param user
     * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
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
     * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
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
     * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
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
	 * COMS明细到处查询
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryexceldetail(CityrecordListVO params, User user) throws Exception{		
		DataPackage dp = new DataPackage();		
		if("2".equals(params.get_ne_systemflag())){//社会渠道
			RewardrecordDAO dao=(RewardrecordDAO)DAOFactory.build(RewardrecordDAO.class,user);
			RewardrecordListVO listvo = new RewardrecordListVO();
			BeanUtils.copyProperties(listvo, params);
			listvo.set_orderby("rewardlistid");
			listvo.set_desc("0");
			dp = dao.doQuery4Detailexport(listvo, user);
			//dp = dao.doQuerypw(listvo, user);			
		}else if("3".equals(params.get_ne_systemflag())){//创新联盟
			VCityrecord4DAO dao = (VCityrecord4DAO)DAOFactory.build(VCityrecord4DAO.class, user);
			VCityrecordList4VO listvo = new VCityrecordList4VO();
			BeanUtils.copyProperties(listvo, params);
			listvo.set_orderby("wayid,opnid,rewardtype,oprtime");
			listvo.set_desc("0");
			dp = dao.doQuerybbc(listvo, user);
		}else{
			throw new Exception("只允许[社会渠道酬金]和[创新联盟酬金]到处COMS明细数据");
		}
		return dp;
	}

	public int updateIsflagByDcordid(Short isflag, Long dcordid, User user)
			throws Exception {
		CityrecordDAO dao = (CityrecordDAO)DAOFactory.build(CityrecordDAO.class, user);
		return dao.updateIsflagByDcordid(isflag, dcordid);
	}
}
