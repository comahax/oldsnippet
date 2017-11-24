/**
 * auto-generated code
 * Mon Sep 14 14:47:12 CST 2009
 */
package com.gmcc.pboss.control.promotion.elmtinst;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import open.tool.rule.Strategy;
import open.tool.rule.Tree;
import open.tool.rule.TreeFactory;
import open.tool.rule.data.VO;
import open.tool.rule.utils.DataUtils;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstDAO;
import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstDBParam;
import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstVO;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplDBParam;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplVO;
import com.gmcc.pboss.common.utils.tools.BusinessStrategy;
import com.gmcc.pboss.common.utils.tools.BusinessUtils;
import com.gmcc.pboss.control.promotion.elmttmpl.Elmttmpl;
import com.gmcc.pboss.control.promotion.elmttmpl.ElmttmplBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ElmtinstBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/promotion/elmtinst/control/ElmtinstBO"
*    name="Elmtinst"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ElmtinstBO extends AbstractControlBean implements
		Elmtinst {

	public ElmtinstVO doCreate(ElmtinstVO vo) throws Exception {
		try {
			ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class, user);
			String instid = dao.getSequence("CH_CX_ELMTINST_SEQ").toString();
			//实例标识默认I开头
			vo.setInstid("I"+ instid);
			return (ElmtinstVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ElmtinstVO vo) throws Exception {
		try {
			ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ElmtinstVO doUpdate(ElmtinstVO vo) throws Exception {
		try {
			ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class,user);
			return (ElmtinstVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ElmtinstVO doFindByPk(Serializable pk) throws Exception {
		ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class,user);
		return (ElmtinstVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ElmtinstDBParam params)
			throws Exception {
		ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class,user);
		return dao.query(params);
	}
	
	public Map doGetDataSet(String expression) throws Exception {
		try {
			Tree tree = TreeFactory.build(expression);
			Set leafNames = tree.getLeafNames();
			Iterator it = leafNames.iterator();
	
			while (it.hasNext()) {
				String instId = (String) it.next();
				List<VO> dataList = doGatherPromotionsDataByInstId(instId);
				HashMap hm = DataUtils.toHashMap(dataList);
				dataList.clear();
				tree.setLeaf(instId, hm);
			}
			Strategy strategy = new BusinessStrategy();
			tree.execute(strategy);
			HashMap<VO,Object> result = tree.getValue();
			// 若运算结果为布尔值，则去除运算结果为"false"的结果集
			if(result.containsValue(true) || result.containsValue(false)) {
				Set<VO> keySet = result.keySet();
				for(Iterator<VO> keyIt = keySet.iterator();keyIt.hasNext();) {
					VO vo = keyIt.next();
					Object value = result.get(vo);
					if(!((Boolean)value).booleanValue()) {
						keyIt.remove();
					}
				}
			}
			tree = null; // 释放内存
			return result;
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public List<VO> doGatherPromotionsDataByInstId(String instId) 
		throws Exception {
		List<VO> resultList = new ArrayList<VO>();
		try {
			Elmtinst eiBo = (ElmtinstBO) BOFactory.build(ElmtinstBO.class,user);
			DataPackage etDp = doQueryElmttmplByInstId(instId);
			if(etDp != null && etDp.getDatas() != null) {
				List etList = new ArrayList(etDp.getDatas());
				if(etList.size() <= 0) {
					throw new Exception("元素实例 ["+instId+"] 不存在;或者该实例存在，但其所属的元素模板不存在，请核实库表数据");
				}
				Map etMap = (Map)etList.get(0);
				ElmtinstVO eiVo = (ElmtinstVO)eiBo.doFindByPk(instId);
				// 采集模式
				String gatheringMode = (String)etMap.get("GATHERINGMODE");
				// 采集逻辑
				String gatheringLogic = (String)etMap.get("GATHERINGLOGIC");
				// 参数串
				String paramString = eiVo.getParams();
				
				if("0".equals(gatheringMode)) {
					// 采集方式：SQL查询语句
					// 用于SQL模式的 参数列表 
					gatheringLogic = BusinessUtils.reformQueryString(gatheringLogic, paramString);
					resultList = eiBo.doGartherDataBySQLMode(gatheringLogic);
				}else {
					// 采集方式：程序
					// 用于程序采集模式 的参数键值对
					Map paramMap = BusinessUtils.parseParam2Map(paramString);
					// 把'cityid' set进paramMap中是为了让Gathering的具体实现类得到当前地市ID
					paramMap.put("cityid", user.getCityid());
					Properties properties = new Properties();
					InputStream in = ElmtinstBO.class.getResourceAsStream(ElmtinstConstant.GATHER_FILE_PATH);
					properties.load(in);
					// 把配置文件中的信息全部放到paramMap中是为了
					// 让Gathering的具体实现类得到配置文件中的信息
					paramMap.putAll(properties);
					String clazzName = gatheringLogic.substring(0, gatheringLogic.indexOf(":"));
					resultList = eiBo.doGatherDataByPGMMode(clazzName, paramMap);
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return resultList;
		
	}
	
	public List<VO> doGartherDataBySQLMode(String sqlString) throws Exception {
		ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class,user);
		return dao.gartherDataBySQLMode(sqlString);
	}

	public List<VO> doGatherDataByPGMMode(String clazzName, Object params)
			throws Exception {
		ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class,user);
		return dao.gatherDataByPGMMode(clazzName, params);
	}

	public DataPackage doQueryElmttmplByInstId(String instId) throws Exception {
		ElmtinstDAO dao = (ElmtinstDAO) DAOFactory.build(ElmtinstDAO.class,user);
		return dao.queryElmttmplByInstId(instId);
	}
	
	//根据模板标识获取参数信息
	public Object[] doGetParamInfo(String tmplid) throws Exception {
		String paramNameStr = "";
		String elmttmplMemo = "";
		Object[] paramInfo = new Object[2];
		
		//取得模板的获取逻辑字符串和模板说明
		Elmttmpl elmttmpl = (Elmttmpl)BOFactory.build(ElmttmplBO.class,user); 
		ElmttmplDBParam param = new ElmttmplDBParam();
		param.set_se_tmplid(tmplid);
		DataPackage dp = elmttmpl.doQuery(param);
		if(null!=dp.getDatas()&&dp.getDatas().size()==1)
		{
			ElmttmplVO elmttmplVO = (ElmttmplVO)dp.getDatas().get(0);
			String gatheringlogic = elmttmplVO.getGatheringlogic();
			//根据模板的获取逻辑字符串得到参数名字符串
			paramNameStr = getParamNameStr(gatheringlogic);
			//获取模板说明
			elmttmplMemo = elmttmplVO.getMemo();
		}
		
		//设置参数信息
		paramInfo[0] = paramNameStr;
		paramInfo[1] = elmttmplMemo;
		return paramInfo;
	}
	
	//根据模板的获取逻辑字符串得到参数名字符串
	public String getParamNameStr(String gatheringlogic) throws Exception {
		String paramNameStr = "";
		String paramName = "";
		
		//计算参数个数
		int paramCount = 0;
		if(StringUtils.countMatches(gatheringlogic, "@")%2==0)
		{
			paramCount = StringUtils.countMatches(gatheringlogic, "@")/2;
		}
		
		//提取参数
		int startIndex = gatheringlogic.indexOf("@");
		int endIndex = gatheringlogic.indexOf("@",startIndex+1);
		Set<String> paramNameSet = new HashSet<String>();
		for(int i=0; i<paramCount; i++)
		{
			paramName = gatheringlogic.substring(startIndex + 1,endIndex);
			if(!paramNameSet.contains(paramName))
			{
				paramNameSet.add(paramName);
				paramNameStr = paramNameStr + paramName + "|";
			}
			startIndex = gatheringlogic.indexOf("@",endIndex+1);
			endIndex = gatheringlogic.indexOf("@",startIndex+1);
		}
		
//		String items[] = StringUtils.splitPreserveAllTokens(gatheringlogic, (char) 32);
//		for (int i = 0; i < items.length; i++) {
//			if (items[i].indexOf("@") != -1&& StringUtils.countMatches(items[i], "@") == 2) {
//				paramName = items[i].substring(items[i].indexOf("@") + 1, items[i].lastIndexOf("@"));
//				paramNameStr = paramNameStr + paramName + ";";
//			}
//		}
		return paramNameStr;
	}
}
