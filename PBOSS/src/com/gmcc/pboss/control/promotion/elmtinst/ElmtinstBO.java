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
			//ʵ����ʶĬ��I��ͷ
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
			// ��������Ϊ����ֵ����ȥ��������Ϊ"false"�Ľ����
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
			tree = null; // �ͷ��ڴ�
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
					throw new Exception("Ԫ��ʵ�� ["+instId+"] ������;���߸�ʵ�����ڣ�����������Ԫ��ģ�岻���ڣ����ʵ�������");
				}
				Map etMap = (Map)etList.get(0);
				ElmtinstVO eiVo = (ElmtinstVO)eiBo.doFindByPk(instId);
				// �ɼ�ģʽ
				String gatheringMode = (String)etMap.get("GATHERINGMODE");
				// �ɼ��߼�
				String gatheringLogic = (String)etMap.get("GATHERINGLOGIC");
				// ������
				String paramString = eiVo.getParams();
				
				if("0".equals(gatheringMode)) {
					// �ɼ���ʽ��SQL��ѯ���
					// ����SQLģʽ�� �����б� 
					gatheringLogic = BusinessUtils.reformQueryString(gatheringLogic, paramString);
					resultList = eiBo.doGartherDataBySQLMode(gatheringLogic);
				}else {
					// �ɼ���ʽ������
					// ���ڳ���ɼ�ģʽ �Ĳ�����ֵ��
					Map paramMap = BusinessUtils.parseParam2Map(paramString);
					// ��'cityid' set��paramMap����Ϊ����Gathering�ľ���ʵ����õ���ǰ����ID
					paramMap.put("cityid", user.getCityid());
					Properties properties = new Properties();
					InputStream in = ElmtinstBO.class.getResourceAsStream(ElmtinstConstant.GATHER_FILE_PATH);
					properties.load(in);
					// �������ļ��е���Ϣȫ���ŵ�paramMap����Ϊ��
					// ��Gathering�ľ���ʵ����õ������ļ��е���Ϣ
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
	
	//����ģ���ʶ��ȡ������Ϣ
	public Object[] doGetParamInfo(String tmplid) throws Exception {
		String paramNameStr = "";
		String elmttmplMemo = "";
		Object[] paramInfo = new Object[2];
		
		//ȡ��ģ��Ļ�ȡ�߼��ַ�����ģ��˵��
		Elmttmpl elmttmpl = (Elmttmpl)BOFactory.build(ElmttmplBO.class,user); 
		ElmttmplDBParam param = new ElmttmplDBParam();
		param.set_se_tmplid(tmplid);
		DataPackage dp = elmttmpl.doQuery(param);
		if(null!=dp.getDatas()&&dp.getDatas().size()==1)
		{
			ElmttmplVO elmttmplVO = (ElmttmplVO)dp.getDatas().get(0);
			String gatheringlogic = elmttmplVO.getGatheringlogic();
			//����ģ��Ļ�ȡ�߼��ַ����õ��������ַ���
			paramNameStr = getParamNameStr(gatheringlogic);
			//��ȡģ��˵��
			elmttmplMemo = elmttmplVO.getMemo();
		}
		
		//���ò�����Ϣ
		paramInfo[0] = paramNameStr;
		paramInfo[1] = elmttmplMemo;
		return paramInfo;
	}
	
	//����ģ��Ļ�ȡ�߼��ַ����õ��������ַ���
	public String getParamNameStr(String gatheringlogic) throws Exception {
		String paramNameStr = "";
		String paramName = "";
		
		//�����������
		int paramCount = 0;
		if(StringUtils.countMatches(gatheringlogic, "@")%2==0)
		{
			paramCount = StringUtils.countMatches(gatheringlogic, "@")/2;
		}
		
		//��ȡ����
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
