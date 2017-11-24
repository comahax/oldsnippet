/**
 * auto-generated code
 * Fri Sep 18 18:06:45 CST 2009
 */
package com.gmcc.pboss.control.promotion.ruleitem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import open.tool.rule.Tree;
import open.tool.rule.TreeFactory;
import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomDBParam;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomVO;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrDBParam;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrVO;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresDBParam;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresVO;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemDAO;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemDBParam;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemVO;
import com.gmcc.pboss.control.promotion.elmtinst.Elmtinst;
import com.gmcc.pboss.control.promotion.elmtinst.ElmtinstBO;
import com.gmcc.pboss.control.promotion.ppzlncom.Ppzlncom;
import com.gmcc.pboss.control.promotion.ppzlncom.PpzlncomBO;
import com.gmcc.pboss.control.promotion.ppzlnptnr.Ppzlnptnr;
import com.gmcc.pboss.control.promotion.ppzlnptnr.PpzlnptnrBO;
import com.gmcc.pboss.control.promotion.ppzlnres.Ppzlnres;
import com.gmcc.pboss.control.promotion.ppzlnres.PpzlnresBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: RuleitemBO
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class RuleitemBO extends AbstractControlBean implements Ruleitem {

	public RuleitemVO doCreate(RuleitemVO vo) throws Exception {
		try {
			RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class,
					user);
			// TODO set the pk */
			return (RuleitemVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(RuleitemVO vo) throws Exception {
		try {
			RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RuleitemVO doUpdate(RuleitemVO vo) throws Exception {
		try {
			RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class,
					user);
			return (RuleitemVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public RuleitemVO doFindByPk(Serializable pk) throws Exception {
		RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class,
				user);
		return (RuleitemVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RuleitemDBParam params) throws Exception {
		RuleitemDAO dao = (RuleitemDAO) DAOFactory.build(RuleitemDAO.class,
				user);
		return dao.query(params);
	}

	public String doGetInstid(String expression) throws Exception {

		Tree tree = TreeFactory.build(expression);
		Set<String> leafNames = tree.getLeafNames();
		String instid = new String();
		Iterator<String> it = leafNames.iterator();
		if (it.hasNext()) {
			instid = it.next();
		}
		return instid;
	}
	
	/**
	 * 根据 参与对象(渠道)，商品总类，资源 过滤源数据
	 * @param pId 方案标识
	 * @param ruleId  规则标识
	 * @return
	 * @throws Exception
	 */
	public Map<VO,Object> doSrcDataFiltering(long pId,long ruleId)throws Exception {
		
		Map resultMap = new HashMap();
		// 根据“规则标识[RULEID]”从“规则明细”表获取“数据类型”为“源数据[0]”的规则明细
		try {
			RuleitemDBParam ruleitemParam = new RuleitemDBParam();
			ruleitemParam.set_ne_ruleid(String.valueOf(ruleId));
			ruleitemParam.set_se_datatype("0");
			ruleitemParam.set_pagesize("0");
			ruleitemParam.setDataOnly(true);
		
			List<RuleitemVO> ruleItems = new ArrayList<RuleitemVO>(this.doQuery(ruleitemParam).getDatas());
			Elmtinst eiBo = (ElmtinstBO)BOFactory.build(ElmtinstBO.class, user);
		
			if(ruleItems != null && ruleItems.size() > 0) {
				for(RuleitemVO ri : ruleItems) {
					String expression = ri.getOptexpression();
					Map dataSet = eiBo.doGetDataSet(expression);
					if(dataSet == null || dataSet.size() <= 0) 
						continue;
					Tree tree = TreeFactory.build(expression);
					Set leafNames = tree.getLeafNames();
					Iterator it = leafNames.iterator();
					String instId = "";
					if(it.hasNext()) {
						instId = (String)it.next();
					}
					DataPackage etDp = eiBo.doQueryElmttmplByInstId(instId);
					List etList = new ArrayList(etDp.getDatas());
					if(etList.size() <= 0) {
						throw new RuntimeException("元素实例 ["+instId+"] 不存在;或者该实例存在，但其所属的元素模板不存在，请核实库表数据");
					}
					Map etMap = (Map)etList.get(0);
					String columnInfo = (String)etMap.get("COLUMNSINFO");
					String[] colInfoArr = columnInfo.split("\\|");
					for(int i=0;i<colInfoArr.length;i++) {
						if("渠道代码".equalsIgnoreCase(colInfoArr[i])) {
							Ppzlnptnr ptBo = (PpzlnptnrBO)BOFactory.build(PpzlnptnrBO.class, user);
							PpzlnptnrDBParam ptParam = new PpzlnptnrDBParam();
							ptParam.set_ne_pid(String.valueOf(pId));
							ptParam.set_pagesize("0");
							ptParam.setDataOnly(true);
							DataPackage dp = ptBo.doQuery(ptParam);
							List<PpzlnptnrVO> ptVoList = new ArrayList<PpzlnptnrVO>(dp.getDatas());
							List<String> wayIds = new ArrayList<String>();
							for(PpzlnptnrVO vo : ptVoList) {
								wayIds.add(vo.getWayid());
							}
							dataSet = filterByFactor(dataSet,colInfoArr[i],wayIds);
						}else if("商品种类".equalsIgnoreCase(colInfoArr[i])) {
							Ppzlncom pcBo = (PpzlncomBO)BOFactory.build(PpzlncomBO.class,user);
							PpzlncomDBParam pcParam = new PpzlncomDBParam();
							pcParam.set_ne_pid(String.valueOf(pId));
							pcParam.set_pagesize("0");
							pcParam.setDataOnly(true);
							DataPackage dp = pcBo.doQuery(pcParam);
							List<PpzlncomVO> pcVoList = new ArrayList<PpzlncomVO>(dp.getDatas());
							List<String> comCates = new ArrayList<String>();
							for(PpzlncomVO vo : pcVoList) {
								comCates.add(vo.getComcategory());
							}
							dataSet = filterByFactor(dataSet,colInfoArr[i],comCates);
						}else if("资源标识".equalsIgnoreCase(colInfoArr[i])) {
							Ppzlnres prBo = (PpzlnresBO)BOFactory.build(PpzlnresBO.class,user);
							PpzlnresDBParam prParam = new PpzlnresDBParam();
							prParam.set_ne_pid(String.valueOf(pId));
							prParam.set_pagesize("0");
							prParam.setDataOnly(true);
							DataPackage dp = prBo.doQuery(prParam);
							List<PpzlnresVO> pcVoList = new ArrayList<PpzlnresVO>(dp.getDatas());
							List<String> res = new ArrayList<String>();
							for(PpzlnresVO vo : pcVoList) {
								res.add(vo.getResid());
							}
							dataSet = filterByFactor(dataSet,colInfoArr[i],res);
						}
					}
					resultMap.putAll(dataSet);
				}
			}else {
				// 规则明细为空，直接对该方案的参与者进行预设的优惠
				// (数据结果集：渠道代码|业务量；其中"渠道代码"取自CH_CX_PPZLNPTNR表，BUSIVALUE取1.0,运算结果也去1.0)
				Ppzlnptnr ptBo1 = (PpzlnptnrBO)BOFactory.build(PpzlnptnrBO.class, user);
				PpzlnptnrDBParam ptParam = new PpzlnptnrDBParam();
				ptParam.set_ne_pid(String.valueOf(pId));
				ptParam.set_pagesize("0");
				ptParam.setDataOnly(true);
				DataPackage dp = ptBo1.doQuery(ptParam);
				List<PpzlnptnrVO> ptVoList = new ArrayList<PpzlnptnrVO>(dp.getDatas());
				
				for(PpzlnptnrVO ptVo : ptVoList) {
					DefaultVO vo = new DefaultVO();
					HashMap<String,Object> keys = new HashMap<String,Object>();
					keys.put("渠道代码", ptVo.getWayid());
					vo.setKeys(keys);
					vo.setValue(1.0);
					resultMap.put(vo, 1.0);
				}
			}
		}catch(Exception ex) {
			// 为避免被Spring截获RuntimeException导致回滚，此处不抛出RuntimeException
			throw new Exception(ex);
		}
		return resultMap;
	}
	
	/**
	 * 基准数据校验
	 * @param srcData 	待校验的源数据
	 * @param ruleId	规则ID
	 * @return			经基准数据校验后的源数据
	 * @throws Exception
	 */
	public Map<VO,Object> doBenchmarkDataValidating(Map<VO, Object> srcData, long ruleId) throws Exception {
		
		// 根据“规则标识[RULEID]”从“规则明细”表获取“数据类型[DATATYPE]”为“基准数据[1]”的规则集合
		try {
			RuleitemDBParam ruleitemParam = new RuleitemDBParam();
			ruleitemParam.set_ne_ruleid(String.valueOf(ruleId));
			ruleitemParam.set_se_datatype("1");
			ruleitemParam.set_pagesize("0");
			List<RuleitemVO> ruleItems = 
				new ArrayList<RuleitemVO>(this.doQuery(ruleitemParam).getDatas());
			
			Elmtinst eiBo = (ElmtinstBO)BOFactory.build(ElmtinstBO.class, user);
			if(ruleItems != null && ruleItems.size() > 0) {
				for(RuleitemVO ri : ruleItems) {
					
					// 若源数据已经为空，就没必要再进行基准数据校验
					if(srcData.size() <= 0)
						return srcData;
					// 运算表达式
					String expression = ri.getOptexpression();
					// 过滤条件
					String matchingStr = ri.getMatching();
					String[] matchingArr = matchingStr.split(";");
					String[] srcMatchKey = new String[matchingArr.length];
					String[] bmMatchKey = new String[matchingArr.length];
					for(int i = 0;i<matchingArr.length;i++) {
						String matching = matchingArr[i];
						srcMatchKey[i] = matching.substring(0, matching.indexOf("="));
						bmMatchKey[i] = matching.substring(matching.indexOf("=")+1);
					}
					// 过滤方式
					String filterMode = ri.getFiltermode();
					// 基准数据集
					Map bmdataSet = eiBo.doGetDataSet(expression);
					
					if(bmdataSet.size() <= 0) { // 若基准数据集为空,则相当于 源数据和基准数据没有一个匹配上
						
						if("0".equals(filterMode)) {
							// 过滤方式[FILTERMODE]”为“保留[0]”时, 清空源数据
							srcData.clear();
						}
						//  过滤方式[FILTERMODE]”为“去除[1]”时,源数据全部保留下来
						continue;
					}
					
					Set<VO> srcKey = srcData.keySet();
					Set<VO> bmKey = bmdataSet.keySet();
					Iterator<VO> srcKeyIt = srcKey.iterator();
					int count = 0; // count变量用统计匹配字段的个数
					boolean hasMatch = false;
					while(srcKeyIt.hasNext()) {
						Iterator<VO> bmKeyIt = bmKey.iterator();
						DefaultVO srcVo = (DefaultVO)srcKeyIt.next();
						HashMap<String,?> srcVoKeyMap = srcVo.getKeys();
						
						while(bmKeyIt.hasNext()) {
							
							DefaultVO bmVo = (DefaultVO)bmKeyIt.next();
							HashMap<String,?> bmVoKeyMap = bmVo.getKeys();
							
							for(int i=0;i<matchingArr.length;i++) {
								if(srcVoKeyMap.get(srcMatchKey[i]).equals(bmVoKeyMap.get(bmMatchKey[i]))) {
									count++;
								}else {
									break;
								}
							}
							if(count == matchingArr.length) {
								hasMatch = true;
								break;
							}
							count = 0;
						}
						if("0".equals(filterMode)) {
							// 过滤方式[FILTERMODE]”为“保留[0]”时，与基准数据匹配上的数据都将保留下来
							if(!hasMatch) {
								srcKeyIt.remove();
							}else {
								hasMatch = false;
							}
						}else {
							// 过滤方式[FILTERMODE]”为“去除[1]”时，与基准数据匹配上的数据都将被排除，留下未匹配上的数据
							if(hasMatch) {
								srcKeyIt.remove();
								hasMatch = false;
							}
						}
						count = 0;
						
					}
					
				}
				
			}
		}catch(Exception ex) {
			// 为避免被Spring截获RuntimeException导致回滚，此处不抛出RuntimeException
			throw new Exception(ex.getCause());
		}
		return srcData;
	}

	/**
	 * 根据参与对象(渠道)进行过滤
	 * @param src 有待过滤的数据
	 * @param factorName 过滤条件的名称
	 * @param factor 过滤条件的值
	 * @return Map 过滤后的数据集
	 */
	private Map<VO,Object> filterByFactor(Map<VO,Object> src,String factorName,List<String> factorValue) {
		if(factorValue.size() > 0) {
			Set<VO> keySet = src.keySet();
			Iterator<VO> it = keySet.iterator();
			boolean exist = false;
			while(it.hasNext()) {
				DefaultVO vo = (DefaultVO)it.next();
				Map<String,?> keys =  vo.getKeys();
				Object value = keys.get(factorName);
				for(int i=0;i<factorValue.size();i++) {
					if(factorValue.get(i).equals(value)) {
						exist = true;
						break;
					}
				}
				if(!exist) {
					it.remove();
				}else {
					exist = false;
				}
			}
		}
		return src;
	}
}
