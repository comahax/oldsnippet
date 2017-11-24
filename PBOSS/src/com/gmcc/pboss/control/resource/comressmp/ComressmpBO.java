/**
 * auto-generated code
 * Tue Sep 01 14:28:15 CST 2009
 */
package com.gmcc.pboss.control.resource.comressmp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackPriterInfo;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.compack.PackMobilePrinterInfo;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDAO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.web.sales.stockalarm.AlarmUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: ComressmpBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/comressmp/control/ComressmpBO"
*    name="Comressmp"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComressmpBO extends AbstractControlBean implements
		Comressmp {

	public ComressmpVO doCreate(ComressmpVO vo) throws Exception {
		try {
			ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
			// TODO set the pk */
			return (ComressmpVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComressmpVO vo) throws Exception {
		try {
			ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComressmpVO doUpdate(ComressmpVO vo) throws Exception {
		try {
			ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
			return (ComressmpVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComressmpVO doFindByPk(Serializable pk) throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		return (ComressmpVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComressmpDBParam params)
			throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		return dao.query(params);
	}
	/**
	 * 批量更新套卡资源用途字段
	 */
	public void doUpdateBatchResuse(String comresid,String resuse)
	throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		ComressmpDBParam params=new ComressmpDBParam();
		params.set_se_comresid(comresid);
		DataPackage data=dao.query(params);
		List<ComressmpVO> list=data.getDatas();
		for(ComressmpVO vo:list){
//			vo.setResuse(resuse);
			this.doUpdate(vo);
		}
	}
	/**
	 * 批量更新套卡库区字段
	 */
	public void doUpdateBatchStorarea(String comresid,String storarea)throws Exception{
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		ComressmpDBParam params=new ComressmpDBParam();
		params.set_se_comresid(comresid);
		DataPackage data=dao.query(params);
		List<ComressmpVO> list=data.getDatas();
		for(ComressmpVO vo:list){
//			vo.setStorarea(storarea);
			//this.doUpdate(vo);
		}
	}
	/**
	 * 批量更新套卡仓储包号字段
	 */
	public void doUpdateBatchBoxnum(String[] items)throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		ComressmpDBParam params=new ComressmpDBParam();
		params.set_se_comresid(items[0]);
		DataPackage data=dao.query(params);
		List<ComressmpVO> list=data.getDatas();
		for(ComressmpVO vo:list){
			vo.setBoxnum(items[1]);
			//this.doUpdate(vo);
		}
	}

	public DataPackage doStat(ComressmpDBParam params) throws Exception {
		// TODO Auto-generated method stub
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		params.setSelectFieldsString("countyid,wayid,brand,comcategory,comstate,ncount");
		params.setDataOnly(true);
		int count=0;//合计
		
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.comressmp.doStat", params);
		if(dp != null && dp.getDatas() != null){
			List list = dp.getDatas();
			List<ComressmpTableVO> tableList = new LinkedList<ComressmpTableVO>();
			
			for(Iterator itt = list.iterator(); itt.hasNext();){
				Map map = (Map)itt.next();
				ComressmpTableVO vo = new ComressmpTableVO();
				vo.setCountyid((String) map.get("countyid"));
				vo.setWayid((String) map.get("wayid"));
				vo.setBrand((String) map.get("brand"));
				vo.setComcategory((String) map.get("comcategory"));
				vo.setComstate( ""+map.get("comstate"));				
				vo.setNcount((String) map.get("ncount"));
				count += Integer.parseInt(vo.getNcount());
				tableList.add(vo);
			}
			
			int countyCount = 1;
			int wayCount = 1;
			int brandCount = 1;
			int comcateCount = 1;
			ComressmpTableVO vo = null;
			List<ComressmpTableVO> tableList2 = new ArrayList<ComressmpTableVO>();
			ComressmpTableVO prevVO = new ComressmpTableVO();
			for(int i =0; i<tableList.size(); i++){
				ComressmpTableVO nextVO = tableList.get(i);
				if(nextVO.getCountyid().equals(prevVO.getCountyid())){
					countyCount++;
						vo = tableList2.get(i-countyCount+1);
						vo.setCountyCount(countyCount);
					if(nextVO.getWayid().equals(prevVO.getWayid())){
						wayCount++;
						vo = tableList2.get(i-wayCount+1);
						vo.setWayCount(wayCount);
						if(nextVO.getBrand().equals(prevVO.getBrand())){
							brandCount++;
							vo = tableList2.get(i-brandCount+1);
							vo.setBrandCount(brandCount);
							if(nextVO.getComcategory().equals(prevVO.getComcategory())){
								comcateCount++;
								vo = tableList2.get(i-comcateCount+1);
								vo.setComcateCount(comcateCount);
								if(nextVO.getComstate().equals(prevVO.getComstate())){
									
								}else{
									BeanUtils.copyProperties(prevVO, nextVO);
									tableList2.add(this.rebuildVO(nextVO, 5));
									continue;
								}
							}else{
								BeanUtils.copyProperties(prevVO, nextVO);
								tableList2.add(this.rebuildVO(nextVO, 4));
								comcateCount= 1;
								continue;
							}
						}else{
							BeanUtils.copyProperties(prevVO, nextVO);
							tableList2.add(this.rebuildVO(nextVO, 3));	
							brandCount=1;
							comcateCount= 1;
							continue;
						}
					}else{
						BeanUtils.copyProperties(prevVO, nextVO);
						tableList2.add(this.rebuildVO(nextVO, 2));
						wayCount=1;
						brandCount=1;
						comcateCount= 1;
						continue;
					}
				}else{
					BeanUtils.copyProperties(prevVO, nextVO);
					tableList2.add(this.rebuildVO(nextVO, 1));
					countyCount=1;
					wayCount=1;
					brandCount=1;
					comcateCount= 1;
					continue;
				}
			}
			
//			if(tableList.size()>1){
//				if(countyCount>1){
//					ComressmpTableVO nextVO = tableList.get(tableList.size()-countyCount);
//					nextVO.setCountyCount(countyCount);
//				}
//				if(wayCount>1){
//					ComressmpTableVO nextVO = tableList.get(tableList.size()-wayCount);
//					nextVO.setWayCount(wayCount);
//				}
//				if(brand>1){
//					ComressmpTableVO nextVO = tableList.get(tableList.size()-brandCount);
//					nextVO.setBrandCount(brandCount);
//				}
//			}
			
			
			dp.setRowCount(count);//因为不需要分页，借用DP的属性保存统计总量
			dp.setDatas(tableList2);
			
		}
		return dp;
	}
	
	public ComressmpTableVO rebuildVO(ComressmpTableVO vo,int num) throws Exception{
		ComressmpTableVO tempvo = new ComressmpTableVO();
		BeanUtils.copyProperties(tempvo, vo);
		switch (num) {
			case 6: 
				BeanUtils.setProperty(tempvo, "comstate", "");
			case 5:
				BeanUtils.setProperty(tempvo, "comcategory", "");
			case 4:
				BeanUtils.setProperty(tempvo, "brand", "");
			case 3:
				BeanUtils.setProperty(tempvo, "wayid", "");				
			case 2:
				BeanUtils.setProperty(tempvo, "countyid", "");
			case 1:				
				break;
		}
		return tempvo;
	}
	
	public DataPackage doQueryBySqlName(String sqlName,DBQueryParam param) throws Exception{
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		return dao.queryByNamedSqlQuery(sqlName, param);
	}

	public DataPackage doGetTrunksOrBoxesForPrint(ComressmpDBParam param,
			String mode) throws Exception {
		
		ComressmpDAO dao = (ComressmpDAO)DAOFactory.build(ComressmpDAO.class, user);
		List list = dao.doQueryTrunksOrBoxesForPrint(param);
		DataPackage resultDp = new DataPackage();
		if(list == null || list.size() <= 0) {
			throw new JOPException("无套卡资源数据，请检查您输入的条件。");
		} else {
			Way wayBO = (Way)BOFactory.build(WayBO.class, user);
			Com comBO = (Com)BOFactory.build(ComBO.class, user);
			Map<String,Object[]> map = new HashMap<String,Object[]>();
			for(int i=0;i<list.size();i++) {
				Object[] ret = (Object[])list.get(i);
				// 包号
				String packagenum = (String)ret[0];
				// 商品标识
				Long comid = (Long)ret[1];
				// 渠道标识
				String wayid = (String)ret[2];
				// 最晚首次使用时间
				Date comactive = (Date)ret[3];
				// 数量
				Integer amount = ((Long)ret[4]).intValue();
				String[] packArray = StringUtils.split(packagenum,"-");
				if(packArray.length != 3) {
					throw new JOPException("包号"+packagenum+"不符合[箱-盒-包]格式规范，无法识别箱号");
				}
				if(StringUtils.isEmpty(wayid))
					throw new JOPException("无法获取资源归属渠道(包号="+packagenum+")");
				if(StringUtils.isEmpty(comid+"")) {
					throw new JOPException("无法获取商品标识(包号="+packagenum+")");
				}
				// 放到map中的key值(箱号 或者 （箱-盒）)
				String keynumber = "";
				if("trunk".equals(mode))
					keynumber = packArray[0];
				else if("box".equals(mode))
					keynumber = packArray[0] + "-" + packArray[1];
				// 检查箱号 或者 （箱-盒）是否在MAP中存在
				if(map.containsKey(keynumber)) {
					// 如果存在，则累加数量=原数量+商品数量
					Object[] values = map.get(keynumber);
					values[1] = (Integer)values[1] + amount;
				}else {
					// 如果不存在则新增Map元素	
					
					WayVO wayVO = wayBO.doFindByPk(wayid);
					Cntycompany cntyBO = (Cntycompany)BOFactory.build(CntycompanyBO.class, user);
					// 分公司Id
					String countyid = wayVO.getCountyid();
					if(StringUtils.isEmpty(countyid))
						throw new Exception("无法获取渠道("+wayVO.getWayid()+wayVO.getWayname()+")"+"的分公司ID");
					CntycompanyVO cntyVO = cntyBO.doFindByPk(countyid);
					// 分公司名称
					String countyname = cntyVO.getCountycompname();
					ComVO comVO = comBO.doFindByPk(comid);
					String comname = comVO.getComname();
					Object[] values = {comname,amount,countyname,comactive};
					map.put(keynumber, values);
				}
			}
			List<CompackPriterInfo> datas = new ArrayList<CompackPriterInfo>();
			for(Iterator<String> it = map.keySet().iterator();it.hasNext();) {
				String number = it.next();
				Object[] values = map.get(number);
				CompackPriterInfo info = new CompackPriterInfo();
				if("trunk".equals(mode)) {
					info.setTrunk_number(number);
				} else if("box".equals(mode)) {
					String[] numbers = StringUtils.split(number,"-");
					info.setTrunk_number(numbers[0]);
					info.setBox_number(numbers[1]);
				}
				info.setComname((String)values[0]);
				info.setAmount((Integer)values[1]);
				info.setCountyname((String)values[2]);
				info.setComactiveDate((Date)values[3]);
				datas.add(info);
			}
			resultDp.setDatas(datas);
			resultDp.setRowCount(datas.size());
		}
		
		return resultDp;
	}

	public DataPackage doGetPackagesForPrint(ComressmpDBParam param)
			throws Exception {
		
		Sysparam sysBO = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String maxPrintPagesizeStr = sysBO.doFindByID(43L, "pboss_fx");
		if(StringUtils.isEmpty(maxPrintPagesizeStr))
			maxPrintPagesizeStr = "50";
		// 单次打印最大页数
		int maxPrintPagesize = Integer.parseInt(maxPrintPagesizeStr);
		String _ssw_boxnum = param.get_ssw_boxnum();
		if(!StringUtils.isEmpty(_ssw_boxnum))
			param.set_ssw_boxnum(_ssw_boxnum+"-");
		param.set_pagesize("0");
		param.set_orderby("boxnum");
		DataPackage crsDp = this.doQuery(param);
		param.set_ssw_boxnum(_ssw_boxnum);
		if(crsDp.getRowCount() <= 0) {
			throw new JOPException("无套卡资源数据，请检查您输入的条件。");
		}
		
		int size_flag = 0; 
		PackMobilePrinterInfo info = null;
		List<String> mobileno = null;
		List<PackMobilePrinterInfo> datas = new ArrayList<PackMobilePrinterInfo>();
		String temp_boxnum = "";
		for(Iterator it = crsDp.getDatas().iterator();it.hasNext();) {
			ComressmpVO crsVO = (ComressmpVO)it.next();
			if(size_flag == 0) 
				temp_boxnum = crsVO.getBoxnum();
			if(!temp_boxnum.equals(crsVO.getBoxnum())) {
				size_flag = 0;
				temp_boxnum = crsVO.getBoxnum();
			}
			if(size_flag++ % 20 == 0) {
				info = new PackMobilePrinterInfo();
				mobileno = new ArrayList<String>();
				info.setPack_number(temp_boxnum);
				info.setMobileno(mobileno);
				datas.add(info);
			}
			mobileno.add(crsVO.getComresid());
		}
		int realPrintPagesize = new Double(Math.ceil((double)datas.size()/12.0)).intValue();
		if(realPrintPagesize > maxPrintPagesize)
			throw new Exception("打印数据预计为["+realPrintPagesize+"]页，超出最大页数["+maxPrintPagesize+"]，请修改条件后再打印。");
		DataPackage resultDp = new DataPackage();
		resultDp.setDatas(datas);
		resultDp.setRowCount(datas.size());
		return resultDp;
	}
	 /**
     * 根据批次和包号查询套卡资源表获取最大包内序号
     * @param param
     * @return
     * @throws Exception
     */
    public Integer doMaxInsideseq(ComressmpDBParam param)throws Exception {
    	ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
    	return dao.doMaxInsideseq(param);
    }
	public Integer doStatSMPStock(String countyid, String comcategory)
			throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
		ComressmpDBParam params = new ComressmpDBParam();
		params.getQueryConditions().put("countyid", countyid);
		params.getQueryConditions().put("comcategory",comcategory);
		Integer result = (Integer)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.resource.comressmp.doStatSMPStock", params);
		return result;
	}
	
	public DataPackage doStatCountyQty() throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
		ComressmpDBParam params = new ComressmpDBParam();
		params.setSelectFieldsString("countyid,brand,Qty");
		params.set_pagesize("0");
		params.setDataOnly(true);
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.comressmp.doStatCountyQty",params);
		return dp;
	}

	public ResultVO doBoxNumUpdate(String line, User user, int rowCount)
			throws Exception {
		ResultVO resultVO = new ResultVO();
		try{
			Comressmp ComressmpBO = (Comressmp) BOFactory.build(ComressmpBO.class, user);
			//资源编号|批次|包号|
			String items[] = AlarmUtils.getStrArr(StringUtils.splitPreserveAllTokens(line, "|"));
			ComressmpDBParam fristParams=new ComressmpDBParam();
			fristParams.set_se_batchno(items[1]);
			fristParams.set_se_boxnum(items[2]);
			/*//根据号码和批次更新套卡资源表(IM_FX_COMRESSMP)的包内序号为空。
			ComressmpDBParam fristParams=new ComressmpDBParam();
			fristParams.set_se_batchno(items[1]);
			fristParams.set_se_comresid(items[0]);
			List<ComressmpVO> fristList=ComressmpBO.doQuery(fristParams).getDatas();
			for(ComressmpVO vo:fristList){
				vo.setInsideseq(null);
				ComressmpBO.doUpdate(vo);
			}*/
			
			ComressmpDBParam params=new ComressmpDBParam();
			params.set_se_comresid(items[0]);
			params.set_se_batchno(items[1]);
			DataPackage data=ComressmpBO.doQuery(params);
			List<ComressmpVO> list=data.getDatas();
			if(list == null || list.size()<=0)
				throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|商品包数据不存在|");
			if(list.size()>1)
				throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|商品资源不唯一|");
			
			Compack compackBO = (Compack) BOFactory.build(CompackBO.class, user);
			Comcategoryrela comcategoryrelaBO = (Comcategoryrela) BOFactory.build(ComcategoryrelaBO.class, user);
			//商品批次|包号|
			
			CompackVO oldCompackVO=null;
			CompackVO newCompackVO=null;
			for(ComressmpVO vo:list){
				if(vo.getComstate()!=1 && vo.getComstate()!=30 )
					throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|号码状态不正确|");
				Serializable pkVO=new CompackVO();
				BeanUtils.setProperty(pkVO, "batchno", vo.getBatchno());//商品批次
				BeanUtils.setProperty(pkVO, "boxnum", vo.getBoxnum());//包号
				oldCompackVO=compackBO.doFindByPk(pkVO);
				if(oldCompackVO!=null){//存在
					if(!"1".equals(oldCompackVO.getPackstate())	&&	!"30".equals(oldCompackVO.getPackstate()))
						throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|原商品包状态不正确|");
				}else{
					throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|原商品包信息不存在|");
				}
				//套卡商品标识查询商品种类组合关系表
				ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
				comcategoryrelaDBParam.set_ne_comid(String.valueOf(vo.getComid()));
				List comcategoryrelas=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();
				ComcategoryrelaVO comcategoryrelaVO=(ComcategoryrelaVO)comcategoryrelas.get(0);
				
				Serializable pkVOnew=new CompackVO();
				BeanUtils.setProperty(pkVOnew, "batchno", items[1]);//商品批次
				BeanUtils.setProperty(pkVOnew, "boxnum", items[2]);//包号
				newCompackVO=(CompackVO)compackBO.doFindByPk(pkVOnew);
				if(newCompackVO==null){//不存在
					newCompackVO=new CompackVO();
					//商品种类根据套卡商品标识查询商品种类组合关系表获取
					newCompackVO.setComcategory(comcategoryrelaVO.getComcategory());
					//包状态、归属渠道、归属号段（号码前三位）取套卡资源属性，
					newCompackVO.setPackstate(String.valueOf(vo.getComstate()));
					newCompackVO.setWayid(vo.getWayid());
					newCompackVO.setNosect(items[0].substring(0,3));
					//资源用途、所属库区取原有数据，打包时间为当前时间，商品数量取0，配送商留空，
					newCompackVO.setResuse(oldCompackVO.getResuse());
					newCompackVO.setStorarea(oldCompackVO.getStorarea());
					newCompackVO.setPacktime(new Date());
					newCompackVO.setAmount(Short.valueOf("1"));
					
					newCompackVO.setBatchno(items[1]);
					newCompackVO.setBoxnum(items[2]);
					compackBO.doCreate(newCompackVO);
					//更新套卡资源包号
					vo.setBoxnum(items[2]);
					//根据批次和包号查询套卡资源表获取最大包内序号，包内序号取最大序号加一
					vo.setInsideseq(ComressmpBO.doMaxInsideseq(fristParams)+1);
					ComressmpBO.doUpdate(vo);
					//原商品包资源数量递减（如果资源数为零，则删除商品包）；
					oldCompackVO.setAmount((short)(oldCompackVO.getAmount()-1));
					if(oldCompackVO.getAmount() == 0){
						compackBO.doRemoveByVO(oldCompackVO);
					}else{
						compackBO.doUpdate(oldCompackVO);
					}
					
				}else{//存在
					if(!"1".equals(newCompackVO.getPackstate())	&&	!"30".equals(newCompackVO.getPackstate())){
						throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|新商品包状态不正确|");
					}else{
						//判断号码和新商品包的属性是否一致（包括商品种类、渠道标识、商品状态）
						if(comcategoryrelaVO.getComcategory().equals(newCompackVO.getComcategory())&& vo.getWayid().equals(newCompackVO.getWayid())
								&& String.valueOf(vo.getComstate()).equals(newCompackVO.getPackstate())){
							if(!(newCompackVO.getBatchno().equals(oldCompackVO.getBatchno()) && newCompackVO.getBoxnum().equals(oldCompackVO.getBoxnum()))){
								//更新套卡资源包号
								vo.setBoxnum(items[2]);
								//根据批次和包号查询套卡资源表获取最大包内序号，包内序号取最大序号加一
								vo.setInsideseq(ComressmpBO.doMaxInsideseq(fristParams)+1);
								ComressmpBO.doUpdate(vo);
								//原商品包资源数量递减
								oldCompackVO.setAmount((short)(oldCompackVO.getAmount()-1));
								if(oldCompackVO.getAmount() == 0){
									compackBO.doRemoveByVO(oldCompackVO);
								}else{
									compackBO.doUpdate(oldCompackVO);
								}
								//新商品包资源数量递增
								newCompackVO.setAmount((short)(newCompackVO.getAmount()+1));
								compackBO.doUpdate(newCompackVO);
							}
							
						}else{
							throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|套卡资源和新商品包 [商品种类/渠道/状态] 信息不一致|");
						}
					}
				}
			}
			line = items[0]+"|"+items[1]+"|"+items[2]+"|  |";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line =  e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
			return resultVO;
	}
}
