/**
 * auto-generated code
 * Wed Sep 02 13:59:59 CST 2009
 */
package com.gmcc.pboss.control.resource.emptysim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map; 
import org.apache.commons.beanutils.BeanUtils; 
import com.gmcc.pboss.business.resource.comrescard.ComrescardDAO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDAO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimTableVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO; 
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: EmptysimBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/emptysim/control/EmptysimBO"
*    name="Emptysim"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class EmptysimBO extends AbstractControlBean implements
		Emptysim {

	public EmptysimVO doCreate(EmptysimVO vo) throws Exception {
		try {
			EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class, user);
			// TODO set the pk */
			return (EmptysimVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmptysimVO vo) throws Exception {
		try {
			EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmptysimVO doUpdate(EmptysimVO vo) throws Exception {
		try {
			EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user);
			return (EmptysimVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmptysimVO doFindByPk(Serializable pk) throws Exception {
		EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user);
		return (EmptysimVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmptysimDBParam params)
			throws Exception {
		EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user);
		return dao.query(params);
	}
	
	public DataPackage doQueryBySqlName(String sqlName,DBQueryParam param) throws Exception{
		EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user);
		return dao.queryByNamedSqlQuery(sqlName, param);
	}

	/**
	 * 根据商品种类查询充值卡资源与商品种类组合集合
	 * @param param
	 * @param comcategory
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryByComcategory(EmptysimDBParam param,String countyid,String svccode,String mareacode)
	throws Exception {
		EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user);
		
		return dao.doQueryComcategory(param,countyid,svccode,mareacode);
	}

	  public DataPackage doStat( EmptysimDBParam params) throws Exception{
		  EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user);
			params.setSelectFieldsString("countyid,wayid,usestate,ncount");
			params.setDataOnly(true);
			int count=0;//合计
			DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.emptysim.doStat", params);
			if(dp != null && dp.getDatas() != null){
				List list = dp.getDatas();
				List<EmptysimTableVO> resultList = new ArrayList<EmptysimTableVO>();
				List<EmptysimTableVO> sourceList= new ArrayList<EmptysimTableVO>();

				for(int i = list.size()-1;i>=0;i--){
					EmptysimTableVO tableVO = new EmptysimTableVO();
					Map map = (Map)list.get(i);
					
					tableVO.setCountyid((String)map.get("countyid"));
					tableVO.setWayid( (String)map.get("wayid")); 
					tableVO.setUsestate(map.get("usestate").toString());
					tableVO.setNcount((String)map.get("ncount"));
					count += Integer.parseInt((String)map.get("ncount"));
					sourceList.add(tableVO);
				}
				
				int countyCount = 1;
				int wayCount = 1;
				int usestateCount = 1;
				
				EmptysimTableVO vo = null;
				
				EmptysimTableVO prevVO = new EmptysimTableVO();
				for(int i =0; i<sourceList.size(); i++){
					EmptysimTableVO nextVO = sourceList.get(i);
					if(nextVO.getCountyid().equals(prevVO.getCountyid())){
						countyCount++;
							vo = resultList.get(i-countyCount+1);
							vo.setCountyCount(countyCount);
						if(nextVO.getWayid().equals(prevVO.getWayid())){
							wayCount++;
							vo = resultList.get(i-wayCount+1);
							vo.setWayCount(wayCount);						
								if(nextVO.getUsestate().equals(prevVO.getUsestate())){
									usestateCount++;
									vo = resultList.get(i-usestateCount+1);
									vo.setUsestateCount(usestateCount);	
									if(nextVO.getUsestate().equals(prevVO.getUsestate())){
										
									}else{
										BeanUtils.copyProperties(prevVO, nextVO);
										resultList.add(this.rebuildVO(nextVO, 4));
										continue;
									}
								}else{
									BeanUtils.copyProperties(prevVO, nextVO);
									resultList.add(this.rebuildVO(nextVO, 3));
									usestateCount = 1;
									continue;
								}
						}else{
							BeanUtils.copyProperties(prevVO, nextVO);
							resultList.add(this.rebuildVO(nextVO, 2));
							wayCount=1;
							usestateCount = 1;
							continue;
						}
					}else{
						BeanUtils.copyProperties(prevVO, nextVO);
						resultList.add(this.rebuildVO(nextVO, 1));
						countyCount=1;
						wayCount=1;
						usestateCount = 1;
						continue;
					}
				}
				
				dp.setDatas(resultList);
				dp.setRowCount(count);//因为不需要分页，借用DP的属性保存统计总量
			}
		  return dp;
	  }
	  
		private EmptysimTableVO rebuildVO(EmptysimTableVO vo,int num) throws Exception{
			EmptysimTableVO tempvo = new EmptysimTableVO();
			BeanUtils.copyProperties(tempvo, vo);
			switch (num) {
				case 4:
					BeanUtils.setProperty(tempvo, "usestate", "");
				case 3:
					BeanUtils.setProperty(tempvo, "wayid", "");				
				case 2:
					BeanUtils.setProperty(tempvo, "countyid", "");
				case 1:				
					break;
			}
			return tempvo;
		}
		public DataPackage doResQuery( EmptysimDBParam params) throws Exception{
			EmptysimDAO dao = (EmptysimDAO) DAOFactory.build(EmptysimDAO.class,user); 
			params.setSelectFieldsString("emptyno,comid,cardmill,iccid,pukno,begintime,stoptime,intime,wayid,simtype,usestate,backup,entertime,applytime,bosssaletime,oprcode,countyid");
            params.setSelectFieldsUseVOType(true);
         return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.emptysim.doList", params); 
		   }
}
