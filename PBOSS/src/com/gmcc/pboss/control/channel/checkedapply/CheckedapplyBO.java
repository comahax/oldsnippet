/**
 * auto-generated code
 * Tue Jun 05 08:32:39 CST 2012
 */
package com.gmcc.pboss.control.channel.checkedapply;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDAO;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDBParam;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.gmcc.pboss.business.channel.checkedapply.ViewCDDetailVO;
import com.gmcc.pboss.business.channel.checkedapply.ViewCDVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDAO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: CheckedapplyBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CheckedapplyBO extends AbstractControlBean implements
		Checkedapply {

	public CheckedapplyVO doCreate(CheckedapplyVO vo) throws Exception {
		try {
			CheckedapplyDAO dao = (CheckedapplyDAO) DAOFactory.build(CheckedapplyDAO.class, user);
			// TODO set the pk */
			return (CheckedapplyVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CheckedapplyVO vo) throws Exception {
		try {
			CheckedapplyDAO dao = (CheckedapplyDAO) DAOFactory.build(CheckedapplyDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CheckedapplyDAO dao = (CheckedapplyDAO) DAOFactory.build(CheckedapplyDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CheckedapplyVO doUpdate(CheckedapplyVO vo) throws Exception {
		try {
			CheckedapplyDAO dao = (CheckedapplyDAO) DAOFactory.build(CheckedapplyDAO.class,user);
			return (CheckedapplyVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CheckedapplyVO doFindByPk(Serializable pk) throws Exception {
		CheckedapplyDAO dao = (CheckedapplyDAO) DAOFactory.build(CheckedapplyDAO.class,user);
		return (CheckedapplyVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CheckedapplyDBParam params)
			throws Exception {
		CheckedapplyDAO dao = (CheckedapplyDAO) DAOFactory.build(CheckedapplyDAO.class,user);
		return dao.query(params);
	}
	
	private DataPackage getData(CheckedapplyDBParam params) throws Exception{
		CheckedapplydetailDAO dao = (CheckedapplydetailDAO) DAOFactory.build(CheckedapplydetailDAO.class,user);
		
		params.set_se_cityid(user.getCityid());
		
		//全量查询
		params.setQueryAll(true);
		
		params.setSelectFieldsString("cityid,applytype,status,istop,aptime,wtype,wayid" +
				",wayname,countyid,oprtime,oprcode2,oprcode,wtype,chktype,waystatus");
		
		DataPackage dp=null;
		dp=dao.queryByNamedSqlQuery("queryCheckedapplyStat",params);
		
		return dp;
	}
	
	public DataPackage doQueryCheckedapplyStat(CheckedapplyDBParam params)
		throws Exception {		
		DataPackage dp = getData(params);
				
		DataPackage resultDp = new DataPackage();
		List collection = new ArrayList();
		
		//网点类型分为三类：top网点表示渠道表中istop字段为1的网点，
		//省级核心连锁网点表示网点对应的所属网点合作商存在并且这个合作商对应的所属省级渠道存在，
		//其他所有网点为有潜力网点。
		if(dp != null && !"".equals(dp)){
			List datas = dp.getDatas();
			
			if(datas != null && !"".equals(datas) && datas.size()>0){
				Map<String, ViewCDVO> eMap = new HashMap<String, ViewCDVO>();
				for(int i=0 ; i<datas.size() ; i++){
					Map oneRecord = (Map)datas.get(i);
					String istop = (String)oneRecord.get("istop");
					String wtype = (String)oneRecord.get("wtype");
					
					String cityid = (String)oneRecord.get("cityid");
					String applytype = (String)oneRecord.get("applytype");
					String status = (String)oneRecord.get("status");
					
					ViewCDVO viewCDVO = new ViewCDVO();
					viewCDVO.setCityid(cityid);
					viewCDVO.setApplytype(applytype);
					viewCDVO.setStatus(status);
					viewCDVO.setNettypestat(0L);
					viewCDVO.setNettype1stat(0L);
					viewCDVO.setIstopstat(0L);
					viewCDVO.setStatstat(0L);
					
					if(cityid != null && !"".equals(cityid)
							&& applytype != null && !"".equals(applytype)
							&& status != null && !"".equals(status)){
						String key = cityid + "_" + applytype + "_" +status;
						if(eMap.containsKey(key)){//存在 累加
							ViewCDVO eCDVO = eMap.get(key);
							if("1".equals(istop)){//top网点
								eCDVO.setIstopstat(eCDVO.getIstopstat().longValue() + 1);
							}else if("2".equals(wtype)){
								//省级核心连锁网点
								eCDVO.setNettypestat(eCDVO.getNettypestat().longValue() + 1);
							}else if("3".equals(wtype)){
								//有潜力网点
								eCDVO.setNettype1stat(eCDVO.getNettype1stat().longValue() + 1);
							}
							eCDVO.setStatstat(eCDVO.getStatstat().longValue() + 1);
						}else{//不存在
							if("1".equals(istop)){
								//top网点
								viewCDVO.setIstopstat(1L);
							}else if("2".equals(wtype)){
								//省级核心连锁网点
								viewCDVO.setNettypestat(1L);
							}else if("3".equals(wtype)){
								//有潜力网点
								viewCDVO.setNettype1stat(1L);
							}
							viewCDVO.setStatstat(1L);
							
							collection.add(viewCDVO);
							eMap.put(key, viewCDVO);
						}
					}
				}
			}
		}
		
		resultDp.setDatas(collection);
		resultDp.setRowCount(collection.size());
		resultDp.setPageNo(dp.getPageNo());
		resultDp.setPageSize(dp.getPageSize());
		return resultDp;
	} 
	
	// 新增授权网点申请表，授权网点申请明细表信息
	public CheckedapplyVO doAddCheckedapply(CheckedapplyVO vo, boolean ch_checked_county, boolean ch_checked_midcity) throws Exception {
		CheckedapplyVO newvo = new CheckedapplyVO();
		try {
			CheckedapplydetailDBParam param = new CheckedapplydetailDBParam();
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, user);
			Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class, user);
			param.set_se_applyno("");
			param.set_se_oprcode(user.getOprcode());
			param.set_se_applytype(vo.getApplytype());
			DataPackage dp = null;
			if (ch_checked_county) {
				dp = checkedapplydetailBO.doQueryInfoForInsert_COUNTY(param);
			} else if (ch_checked_midcity) {
				dp = checkedapplydetailBO.doQueryInfoForInsert_MIDCITY(param);
			}

			if (null == dp || dp.getDatas().size() == 0) {
				throw new Exception(
						"授权网点申请的明细没有填写，请点击【选择申请网点】按钮或者【批量导入】按钮填写明细数据");
			} else {
				// 新增申请表
				vo.setOprcode(user.getOprcode());
				vo.setCityid(user.getCityid());
				newvo = checkedapplyBO.doCreate(vo);
				for (int i = 0; i < dp.getDatas().size(); i++) {
					CheckedapplydetailVO detailvo = (CheckedapplydetailVO) dp.getDatas().get(i);

					Serializable pk = (Serializable) detailvo.getSeq();
					CheckedapplydetailVO detailvo1 = checkedapplydetailBO.doFindByPk(pk);

					if (!vo.getApplytype().equals(detailvo1.getApplytype())) {
						throw new Exception("申请类型" + Code2NameUtils.code2Name("$CH_CHECKTYPE", vo.getApplytype(), user.getCityid())
								+ "跟申请明细中的申请类型" + Code2NameUtils.code2Name("$CH_CHECKTYPE", detailvo.getApplytype(), user.getCityid()) + "不一致，请重新选择");
					}

					Long applyno = detailvo1.getApplyno();
					if (applyno == null) {
						detailvo1.setAptime(newvo.getAptime());
						detailvo1.setApplyno(newvo.getApplyno());
						checkedapplydetailBO.doUpdate(detailvo1);
					} else {
						if (applyno.longValue() != newvo.getApplyno().longValue()) {
							CheckedapplydetailVO detailvo2 = new CheckedapplydetailVO();
							BeanUtils.copyProperties(detailvo2, detailvo1);
							detailvo2.setSeq(null);
							detailvo2.setApplyno(newvo.getApplyno());
							if (ch_checked_county) {
								detailvo2.setIsflag(Short.parseShort("0"));
							} else if (ch_checked_midcity) {
								detailvo2.setIsflag(Short.parseShort("1"));
							}
							detailvo2.setAptime(new Date());
							detailvo2.setWaystatus(null);
							detailvo2.setOprtime(null);
							detailvo2.setOprcode(this.getUser().getOprcode());
							checkedapplydetailBO.doCreate(detailvo2);
						}
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return newvo;
	}
      // 新增授权网点申请表，授权网点申请明细表信息
     public CheckedapplyVO doAddCheckedapply(CheckedapplyVO vo) throws Exception{ 
    	 
    	 CheckedapplyVO newvo = new CheckedapplyVO();
    	 try {
    		 //vo.setStatus("0");//申请状态设置为0待审核
    		 CheckedapplydetailDBParam param = new CheckedapplydetailDBParam(); 
        	 Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class,user); 
        	 Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class,user); 
    		 param.set_se_applyno("");
    		 param.set_se_oprcode(user.getOprcode());
    		 param.set_se_applytype(vo.getApplytype());
    		 DataPackage dp = checkedapplydetailBO.doQueryInfoForInsert(param);
    		 
    		 if(null==dp || dp.getDatas().size()==0){
    			 throw new Exception("授权网点申请的明细没有填写，请点击【选择申请网点】按钮或者【批量导入】按钮填写明细数据");
    		 }else{	
    			 //新增申请表
    			vo.setOprcode(user.getOprcode());
    			vo.setCityid(user.getCityid());
    			newvo = checkedapplyBO.doCreate(vo);
    			for(int i=0 ; i<dp.getDatas().size() ; i++){
    				CheckedapplydetailVO detailvo = (CheckedapplydetailVO)dp.getDatas().get(i);
    				
    				 Serializable pk = (Serializable)detailvo.getSeq();
    				 CheckedapplydetailVO detailvo1 = checkedapplydetailBO.doFindByPk(pk);
    				 
    				 if(!vo.getApplytype().equals(detailvo1.getApplytype())){
    					 throw new Exception("申请类型"+Code2NameUtils.code2Name("$CH_CHECKTYPE",vo.getApplytype(), user.getCityid())+"跟申请明细中的申请类型"+Code2NameUtils.code2Name("$CH_CHECKTYPE",detailvo.getApplytype(), user.getCityid())+"不一致，请重新选择");
    				 }
    				 
    				 Long  applyno = detailvo1.getApplyno();
    				 if(applyno == null ){
    					 detailvo1.setAptime(newvo.getAptime());
    					 detailvo1.setApplyno(newvo.getApplyno());  
    					 checkedapplydetailBO.doUpdate(detailvo1);
    				 }else{
    					 if(applyno.longValue()!= newvo.getApplyno().longValue()){
    						 CheckedapplydetailVO detailvo2 = new CheckedapplydetailVO(); 
    						 BeanUtils.copyProperties(detailvo2, detailvo1);
    						 detailvo2.setSeq(null); 
    						 detailvo2.setApplyno(newvo.getApplyno());
    						 detailvo2.setIsflag(Short.parseShort("1"));
    						 detailvo2.setAptime(new Date());
    						 detailvo2.setWaystatus(null);
    						 detailvo2.setOprtime(null);
    						 detailvo2.setOprcode(this.getUser().getOprcode());
        					 checkedapplydetailBO.doCreate(detailvo2);
    					 } 
    				 }

    			}			
    		 }
    	 } catch (Exception e) {
    		// sessionContext.setRollbackOnly();
    		throw e;
    	 }
    			 
    	 return newvo;
     }//更新授权网点申请表，授权网点申请明细表信息
     public void doUpdateCheckedapply(CheckedapplyVO vo) throws Exception{
    	 
    	 try {
    		 //vo.setStatus("0");//申请状态设置为0待审核
    		 CheckedapplydetailDBParam param = new CheckedapplydetailDBParam(); 
        	 Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class,user); 
        	 Checkedapply checkedapplyBO = (Checkedapply) BOFactory.build(CheckedapplyBO.class,user);
        	 CheckedapplyVO newvo = checkedapplyBO.doFindByPk(vo.getApplyno());
        	 BeanUtils.copyProperties(newvo, vo);
    		 param.set_se_applyno(vo.getApplyno().toString()); 
    		 param.set_se_applytype(vo.getApplytype());
    		 DataPackage dp = checkedapplydetailBO.doQuery(param);
    		 if(null==dp || dp.getDatas().size()==0){
    			 throw new Exception("授权网点申请的明细没有填写，请点击【选择申请网点】按钮或者【批量导入】按钮填写明细数据");
    		 }else{
    			 
    			 for(int i=0 ; i<dp.getDatas().size() ; i++){
    				CheckedapplydetailVO detailvo = (CheckedapplydetailVO)dp.getDatas().get(i);
    				
    				Serializable pk = (Serializable)detailvo.getSeq();
   				 	CheckedapplydetailVO detailvo1 = checkedapplydetailBO.doFindByPk(pk);
    				
    				if(!vo.getApplytype().equals(detailvo1.getApplytype())){
    					throw new Exception("申请类型"+ Code2NameUtils.code2Name("$CH_CHECKTYPE",vo.getApplytype(), user.getCityid())+"跟申请明细中的申请类型"+Code2NameUtils.code2Name("$CH_CHECKTYPE",detailvo.getApplytype(), user.getCityid())+"不一致，请重新选择");
    				}
    				// 更新申请明细表
    				if (detailvo1.getAptime()==null) {
    					detailvo1.setAptime(vo.getAptime());
    					checkedapplydetailBO.doUpdate(detailvo1);
    				}
    			 }
    			//更新申请表
    			 checkedapplyBO.doUpdate(newvo);			 
    		 }
    	 } catch (Exception e) {
    		// sessionContext.setRollbackOnly();
    		throw e;
    	 }   	     	 
     }

	public DataPackage doQueryByNamedSqlQuery(String name, Object param)
			throws Exception {
		CheckedapplyDAO dao = (CheckedapplyDAO) DAOFactory.build(CheckedapplyDAO.class,user);
		return dao.queryByNamedSqlQuery(name,param);
	}

	public DataPackage doQueryCheckedapplyDetail(CheckedapplyDBParam params)
			throws Exception {
		DataPackage dp = getData(params);
		
		DataPackage resultDp = new DataPackage();
		List collection = new ArrayList();
		
		if(dp != null && !"".equals(dp)){
			List datas = dp.getDatas();
			
			if(datas != null && !"".equals(datas) && datas.size()>0){
				Map<String, ViewCDDetailVO> eMap = new HashMap<String, ViewCDDetailVO>();
				for(int i=0 ; i<datas.size() ; i++){
					Map oneRecord = (Map)datas.get(i);
					String istop = (String)oneRecord.get("istop");
					
					String cityid = (String)oneRecord.get("cityid");
					String applytype = (String)oneRecord.get("applytype");
					String status = (String)oneRecord.get("status");
					
					String wayid = (String)oneRecord.get("wayid");
					
					ViewCDDetailVO viewCDDetailVO = new ViewCDDetailVO();
					
					
					viewCDDetailVO.setCityid(cityid);
					viewCDDetailVO.setApplytype(applytype);
					viewCDDetailVO.setStatus(status);
					
					String wayname = (String)oneRecord.get("wayname");
					String countyid = (String)oneRecord.get("countyid");//分公司
					Date oprtimeDate = (Date)oneRecord.get("oprtime");//审核时间
					String oprtime = "";
					if(oprtimeDate != null && !"".equals(oprtimeDate)){
						oprtime = new SimpleDateFormat("yyyy-MM-dd").format(oprtimeDate);
					}
					String oprcode2 = (String)oneRecord.get("oprcode2");//审核人
					String oprcode = (String)oneRecord.get("oprcode");//申请工号
					String wtype = (String)oneRecord.get("wtype");//网点类型
					String chktype = (String)oneRecord.get("chktype");//考核方式
					String waystatus = String.valueOf(oneRecord.get("waystatus"));//网点审核状态
					
					viewCDDetailVO.setWayname(wayname);
					viewCDDetailVO.setCountyid(countyid);
					viewCDDetailVO.setOprtime(oprtime);
					viewCDDetailVO.setOprcode2(oprcode2);
					viewCDDetailVO.setOprcode(oprcode);
					viewCDDetailVO.setWtype(wtype);
					viewCDDetailVO.setChktype(chktype);
					viewCDDetailVO.setWaystatus(waystatus);
					
					if("1".equals(istop)){
						//top网点(目标渠道数)
						viewCDDetailVO.setIstop("TOP网点");
					}else if("2".equals(wtype)){
						//省级核心连锁网点
						viewCDDetailVO.setIstop("省级核心连锁");
					}else if("3".equals(wtype)){
						//有潜力网点
						viewCDDetailVO.setIstop("有潜力网点");
					}
					
					viewCDDetailVO.setWayid(wayid);
					
					collection.add(viewCDDetailVO);
				}
			}
		}
		
		resultDp.setDatas(collection);
		resultDp.setRowCount(collection.size());
		resultDp.setPageNo(dp.getPageNo());
		resultDp.setPageSize(dp.getPageSize());
		return resultDp;
	}

	public DataPackage doQueryByNamedSqlQueryWay(String name, Object param)
			throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class,user);
		return dao.queryByNamedSqlQuery(name,param);
	}
    
}
