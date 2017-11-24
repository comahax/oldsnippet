/**
 * auto-generated code
 * Fri Aug 11 16:47:18 CST 2006
 */
package com.sunrise.boss.ui.commons.morecheck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2Name;
import com.sunrise.boss.ui.commons.taglib.morecode2name.MoreCode2NameConfiger;
import com.sunrise.boss.ui.commons.taglib.morecode2name.Node;

/**
 * Title: MoreCheckAction Description: Copyright: Copyright (c) 2006 Company:
 * Maywide Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */

public class MoreCheckAction extends BaseAction {

	static public final String SYSCODE_FLAG = "$";

	static public final String CONFIG_FLAG = "#";

	static public final String CLASS_PREFIX = "com.sunrise.boss.ui.commons.taglib.morecode2name.impl.";

	static public final String DEFAULT_ALLNAME = "ȫ��ƥ��";  /**ȫѡ���� Ĭ��ֵ*/

	static public final String DEFAULT_ALLCODE = "*,";   /**ȫѡcode Ĭ��ֵ*/

	private static Logger log = Logger.getRootLogger();

	public MoreCheckAction() {
	}

	
	/**  ��ȡurl�Ĳ���ֵ
	 *   ����ֵ��definition��condition��dbFlag��û���ϣ�
	**/
	public void getParameter(ActionForm actionForm, HttpServletRequest request){
		
		/**  ��ȡurl�Ĳ���ֵ **/
		String code = request.getParameter("code");
		String definition = request.getParameter("definition");
		String condition = request.getParameter("condition");
		String dbFlag = request.getParameter("dbFlag");		
		
		if(null != code && !"".equals(code))
			((MoreCheckForm) actionForm).setCode(code);
		if(null != definition && !"".equals(definition))
			((MoreCheckForm) actionForm).setDefinition(definition);
		if(null != condition && !"".equals(condition))
			((MoreCheckForm) actionForm).setCondition(condition);
		if(null != dbFlag && !"".equals(dbFlag))
			((MoreCheckForm) actionForm).setDbFlag(dbFlag);
	
	}
	
	/**
	 * ��ѯ
	 */
	public ActionForward doMorecheck(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		/**  ��ȡurl�Ĳ���ֵ **/
		getParameter(actionForm,request);
		
		Page.setPageSize(request, (BaseActionForm) actionForm);
		MoreCheckForm form = (MoreCheckForm) actionForm;
		form.set_pagesize("10");

		DataPackage dp = new DataPackage();
		if (form.getDefinition() != null
				&& form.getDefinition().trim().length() > 0) {
			
			/*** ��ȡ��ѡ�� ÿһ��code��code���õ�name �����磺 1��2��3 �� A��B��C�� ***/
			getFull(form,user);
			
			/*** ��ȡȫѡ���֡����磺 *��-> ȫ��ƥ�� ***/
			getAll(form);
			
			/*** ��������code ���� ȫѡ�ֶΣ�*���� code��name ת���� ȫѡ ***/
			if (null != form.getCode() && form.getAllcode().equals(form.getCode())) {				
				form.setCode(form.getAllcode());
				form.setName(form.getAllname());				
			}else{
				
				/**  **/
				getName( form,  user);
			}
			
			/*** ���ڼ�¼���Ƿ��Ƿ�ҳѡ���Ƿ��ǵ�һ�ε����� ***/
			if(!form.isFirst()){
				
				/** ���ñ�־ **/
				form.setFirst(true);
				
				/*** ��¼�³�ʼ��code �� name ***/
				form.setInitcode(form.getCode());
				form.setInitname(form.getName());
			}
			
			/** ȡ�ֵ�� **/
			if (form.getDefinition().indexOf(SYSCODE_FLAG) == 0) {

				try {

					DictitemListVO dictlist = new DictitemListVO();

					BeanUtils.copyProperties(dictlist, form);
					dictlist.set_se_groupid(form.getDefinition().substring(1));
					dictlist.set_orderby("dictid");
					dictlist.set_desc("0");
					CommonDelegate dictitemDelegate = new CommonDelegate(
							DictitemVO.class);
					dp = (DataPackage) dictitemDelegate.doQuery(dictlist, user);

					if (null != dp && null != dp.getDatas() && dp.getDatas().size() > 0) {						
						List list = new ArrayList();
						for (Iterator iter = dp.getDatas().iterator();iter.hasNext();) {
							DictitemVO dictvo = (DictitemVO) iter.next();
							Node node = new Node();
							node.setCode(dictvo.getDictid());
							node.setName(dictvo.getDictname());
							list.add(node);
						}	
						dp.setDatas(list);
					}

				} catch (Exception ex) {
					log.info("MoreCheckAction exception!");
					log.error("MoreCheckAction exception", ex);

				}
				/*** ȡ�Զ������õķ��� ***/	
			} else if (form.getDefinition().indexOf(CONFIG_FLAG) == 0) {
				try {

					BaseListVO baselistvo = new BaseListVO();
					BeanUtils.copyProperties(baselistvo, form);
					dp = MoreCode2NameConfiger.valueList(form.getDefinition() 
							.substring(1), form.getCondition(), user.getCityid(), baselistvo,false);
				

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				/*** ȡʵ�ָýӿڵķ��� ***/		
			} else {
				MoreCode2Name instance = null;				
				try {
					String definition = form.getDefinition();
					instance = (MoreCode2Name) Class.forName(
							CLASS_PREFIX + definition).newInstance();
					
					BaseListVO params = new BaseListVO();
					BeanUtils.copyProperties(params, (BaseActionForm) actionForm);
					dp = (DataPackage) instance.getObject(params,user);

				} catch (Exception ex) {
					log.info("MoreCheckAction exception!");
					log.error("MoreCheckAction exception", ex);
				}
			}

		}

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);

		return (actionMapping.findForward("morecheck"));
	}

	
	
	
	/*** code ����� name ***/
	private void getName(MoreCheckForm form, User user) {
    	String theName = "";
    	if(null != form.getDefinition()){
    		String definition = form.getDefinition().substring(1);
    		
    		/** ȡ�ֵ�� **/
    		if (form.getDefinition().indexOf(SYSCODE_FLAG) == 0) { 
    			
        		try {
        			String[] codekey = form.getCode().split(",");  
        			
    				CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
    				DictitemListVO dictlistvo = new DictitemListVO();
    				dictlistvo.set_se_groupid(definition);
    				dictlistvo.set_pagesize("0");
    				dictlistvo.set_desc("0");
    				dictlistvo.set_orderby("dictid");
    				
    				DataPackage dp = (DataPackage)dictitemDelegate.doQuery(dictlistvo, user);
    				
    				if( null != dp && null != dp.getDatas() && dp.getDatas().size() > 0 ){

    					Map map = new LinkedHashMap();
    					StringBuffer fullcode = new StringBuffer("");
    					StringBuffer fullname = new StringBuffer("");    
    					
    					for (Iterator iter = dp.getDatas().iterator();iter.hasNext();) {
    						DictitemVO dictvo = (DictitemVO) iter.next();
    						fullcode.append(dictvo.getDictid().toString()).append(",");
    						fullname.append(dictvo.getDictname().toString() == null ? dictvo.getDictid().toString() 
    										: dictvo.getDictname().toString()).append(",");
    						map.put(dictvo.getDictid(), dictvo.getDictname());
    					}
    					/** �����е�code��name��¼���� **/
    					form.setFullcode(fullcode.toString());
    					form.setFullname(fullname.toString());
    					
    					/*** ����code ȡname ***/
    					theName = getMoreName(map,codekey);
    				}
        		}catch (Exception ex) {
        			log.info("MoreCheckAction exception by getName!");
        			log.error("MoreCheckAction exception", ex);
        		}
        		
        		/*** ȡ�Զ������õķ��� ***/	
    		} else if (form.getDefinition().indexOf(CONFIG_FLAG) == 0) { 
    			
    			try {			
    				
    				String[] codekey = form.getCode().split(",");							
    				Map map = MoreCode2NameConfiger.valueList(definition,null, user.getCityid(),true);
    				
    				/*** ����code ȡname ***/
    				theName = getMoreName(map,codekey);				
    					
    				
    			} catch (Exception ex) {
    				log.info("MoreCheckAction exception by getName!");
    				log.error("MoreCheckAction exception", ex);
    			}  

    			/*** ȡʵ�ָýӿڵķ��� ***/	
    		} else { 			
    			MoreCode2Name instance = null;
    			try {
    				definition = form.getDefinition();
    				instance = (MoreCode2Name) Class.forName(
    						CLASS_PREFIX + definition).newInstance();
    				BaseListVO params = new BaseListVO();
    				BeanUtils.copyProperties(params, form);
    				Map map = (Map) instance.getList(params,user);
    				String[] codekey = form.getCode().split(",");
    				
    				/*** ����code ȡname ***/
    				theName = getMoreName(map,codekey);
    			} catch (Exception ex) {
    				log.info("MoreCheckAction exception by getName!");
    				log.error("MoreCheckAction exception", ex);
    			}
    		}
    	}
    	
    	form.setName(theName);
	}	
	

	/** 
	 * �ж���û�з��룬û�еĻ�codeֵԭ���Ż�  
	 */
	private String getMoreName(Map map,String[] codekey){
		if (map != null) {
			StringBuffer moreName =new StringBuffer();
			for( int i=0 ;i < codekey.length; i++ ){
				String ketName = "";
				if(map.containsKey(codekey[i])) {
					ketName = (String) map.get(codekey[i]);
					
					if(null != ketName && !"".equals(ketName)){
						moreName.append(ketName);
						moreName.append(",");
					}else{
						if(null != codekey[i] && !"".equals(codekey[i])){
							moreName.append(codekey[i]);
							moreName.append(",");
						}
					}
						
				}else{					
					if(null != codekey[i] && !"".equals(codekey[i])){
						moreName.append(codekey[i]);
						moreName.append(",");
					}	
				}
				
			}
			return moreName.toString();
		}
		return "";
	}	


	/*** ��ȡ��ѡ�� ÿһ��code��code���õ�name �����磺 1��2��3 �� A��B��C�� ***/
	private void getFull(MoreCheckForm form, User user) {
		
		StringBuffer fullcode = new StringBuffer("");
		StringBuffer fullname = new StringBuffer("");
		
		/** ȡ�ֵ�� **/
		if (form.getDefinition().indexOf(SYSCODE_FLAG) == 0) {
			
			try {    			
				CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
				DictitemListVO dictlistvo = new DictitemListVO();
				dictlistvo.set_se_groupid(form.getDefinition().substring(1));
				dictlistvo.set_pagesize("0");
				dictlistvo.set_desc("0");
				dictlistvo.set_orderby("dictid");
				
				DataPackage dp = (DataPackage)dictitemDelegate.doQuery(dictlistvo, user);
				
				if( null != dp && null != dp.getDatas() && dp.getDatas().size() > 0 ){

					for (Iterator iter = dp.getDatas().iterator();iter.hasNext();) {
						DictitemVO dictvo = (DictitemVO) iter.next();
						fullcode.append(dictvo.getDictid().toString()).append(",");
						fullname.append(dictvo.getDictname().toString() == null ? dictvo.getDictid().toString() 
										: dictvo.getDictname().toString()).append(",");
		
					}
				}
    		}catch (Exception ex) {
    			log.info("MoreCheckAction exception by getFull!");
    			log.error("MoreCheckAction exception", ex);
    		}
			
    		/*** ȡ�Զ������� ***/	
		} else if (form.getDefinition().indexOf(CONFIG_FLAG) == 0) {
			try {

				BaseListVO baselistvo = new BaseListVO();
				BeanUtils.copyProperties(baselistvo, form);
				DataPackage dp = MoreCode2NameConfiger.valueList(form
						.getDefinition().substring(1), form.getCondition(),
						user.getCityid(), baselistvo, true);
				if (null != dp && dp.getDatas() != null
						&& dp.getDatas().size() > 0) {

					for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {

						Node node = (Node) iter.next();
						
						fullcode.append(node.getCode().toString()).append(",");
						fullname.append(node.getName().toString() == null ? node.getCode().toString() 
										: node.getName().toString()).append(",");
						
					}

				}
			} catch (Exception ex) {
				log.info("MoreCheckAction exception by getFull!");
				log.error("MoreCheckAction exception", ex);
			}
			
			/*** ȡʵ�ָýӿڵ� ***/	
		} else {
			MoreCode2Name instance = null;
			try {
				String definition = form.getDefinition();
				instance = (MoreCode2Name) Class.forName(
						CLASS_PREFIX + definition).newInstance();
				BaseListVO params = new BaseListVO();
				BeanUtils.copyProperties(params, form);
				Map values = (Map) instance.getList(params,user);
				if (values != null && !values.isEmpty()) {
					Object[] keys = values.keySet().toArray();

					for (int i = keys.length - 1; i >= 0; i--) {
						
						fullcode.append(keys[i].toString()).append(",");
						fullname.append(values.get(keys[i]) == null ? keys[i].toString() : values
								.get(keys[i]).toString()).append(",");			
					}

				}
			} catch (Exception ex) {
				log.info("MoreCheckAction exception by getFull!");
				log.error("MoreCheckAction exception", ex);

			}
		}
		form.setFullcode(fullcode.toString());
		form.setFullname(fullname.toString());

	}

	
	/*** ��ȡȫѡ���֡����磺 *��-> ȫ��ƥ�� ***/
	private void getAll(MoreCheckForm form ) {
		
		if(null != form && null != form.getDefinition()){
			String theName = "";
			String theCode = "";
			String definition = form.getDefinition().substring(1);
			String falg = form.getDefinition().substring(0,1);
			
			/** ȡ�ֵ��ȫѡ���� **/
			if (SYSCODE_FLAG.equals(falg)) {
				try {
					theName = MoreCode2NameConfiger.getDictAllNameProperty(definition);
					theCode = MoreCode2NameConfiger.getDictAllCodeProperty(definition);
				} catch (Exception e) {
					log.info("fail : MoreCheckAction exception by get Dict allname!",e);
				}
				
				/*** ȡ�Զ�������ȫѡ���� ***/	
			} else if (CONFIG_FLAG.equals(falg)) {
				try {
					theCode = MoreCode2NameConfiger.getAllCodeProperty(definition);
					theName = MoreCode2NameConfiger.getAllNameProperty(definition);
				} catch (Exception e) {
					log.info("fail : MoreCheckAction exception by get allname!",e);
				}
				
				/*** ȡʵ�ָýӿڵ�ȫѡ���� ***/	
			}else{
				 definition = form.getDefinition();
				MoreCode2Name instance = null;
				try {
					definition = form.getDefinition();
					instance = (MoreCode2Name) Class.forName(CLASS_PREFIX + definition).newInstance();
					theCode = instance.getAllCode();
					theName = instance.getAllName();
				} catch (Exception ex) {
					log.info("MoreCheckAction exception by getAll!");
					log.error("MoreCheckAction exception", ex);

				}
				
				
			}

			/** ���������� �Զ�ƥ��Ĭ��ֵ ��ȫ��ƥ�䡯 **/
			if (null == theName || "".equals(theName))
				theName = DEFAULT_ALLNAME;
			if (null == theCode || "".equals(theCode))
				theCode = DEFAULT_ALLCODE;

			form.setAllcode(theCode);
			form.setAllname(theName);
		}
		
	}

}
