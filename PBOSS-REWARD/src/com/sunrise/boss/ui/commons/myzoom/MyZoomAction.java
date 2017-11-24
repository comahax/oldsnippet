package com.sunrise.boss.ui.commons.myzoom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfigerII;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;
import com.sunrise.boss.ui.commons.taglib.options.Options;
import com.sunrise.boss.ui.commons.zoom.ZoomAction;

/**
 * Zoom ��ǿ��
 * @author Canigar
 *
 */
public class MyZoomAction extends ZoomAction{

	 /**
     * ��ѯ
     */
    protected ActionForward doList(ActionMapping actionMapping,
                                   ActionForm actionForm,
                                   HttpServletRequest request,
                                   HttpServletResponse response, User user) throws
            Exception {
    	Page.setPageSize(request, (BaseActionForm) actionForm);
    	MyZoomForm form = (MyZoomForm) actionForm;
    	form.set_pagesize("10");
    	
    	DataPackage dp = new DataPackage();
    	
    	
    	if (form.getDefinition() != null && form.getDefinition().trim().length() > 0) {

			if (form.getDefinition().indexOf(SYSCODE_FLAG) == 0) { // ��ϵͳ�ֵ����������ķ���
				try {
					CommonDelegate dictitemDelegate = new CommonDelegate(
							DictitemVO.class);
					DictitemListVO dictlist = new DictitemListVO();
					
					BeanUtils.copyProperties( dictlist, form );
					dictlist.set_se_groupid(form.getDefinition().substring(1));
					dictlist.set_se_dictid( form.getCode() );
					dictlist.set_sk_dictname( form.getName() );
					dictlist.set_orderby( "dictid" );
					dictlist.set_desc("0");
					
					dp = (DataPackage)dictitemDelegate.doQuery(dictlist,user);
					if( dp.getDatas().size() > 0 ){
						Iterator iter = dp.getDatas().iterator();
						List list = new ArrayList();
						while( iter.hasNext() ){
							DictitemVO dictvo = (DictitemVO)iter.next();
							Node node = new Node();
							node.setCode( dictvo.getDictid() );
							node.setName( dictvo.getDictname() );
							list.add( node );
						}
						dp.setDatas( list );
					}
					
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new Exception("show zoom");
				}
			} else if (form.getDefinition().indexOf(CONFIG_FLAG) == 0) { // ���������ļ����õĵ�����Ӧ�ķ���
				try {
					String conditionValue = null;
					StringBuffer where = new StringBuffer();
					if( form.getCode() != null && !"".equals( form.getCode() ) ){
						where.append(Code2NameConfigerII.getCodeProperty( form.getDefinition().substring(1))).append(":").append( form.getCode() ).append(";");
					}
					if( form.getName() != null && !"".equals( form.getName() ) ){
						where.append("_sk_").append(Code2NameConfigerII.getNameProperty( form.getDefinition().substring(1))).append(":").append( form.getName() ).append(";");;
					}
					
					if( !"".equals( where.toString() ) ){
						if( form.getCondition() != null ){
							where.append( form.getCondition() ).append(";");
						}
						where.deleteCharAt( where.length() -1 );
						conditionValue = where.toString();
					}
					else{
						conditionValue = form.getCondition();
					}
					
					BaseListVO baselistvo = new BaseListVO();
					BeanUtils.copyProperties( baselistvo, form );
					dp = Code2NameConfigerII.valueList(form.getDefinition().substring(1), conditionValue ,user.getCityid(),baselistvo );							
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				Options instance = null;
				try {
					instance = (Options) Class.forName(
							CLASS_PREFIX + form.getDefinition()).newInstance();
					
					BaseListVO baselistvo = new BaseListVO();
					BeanUtils.copyProperties( baselistvo, form );
					dp = (DataPackage) instance.valueObject(baselistvo,form.getCode(),form.getName(), user);
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new JspException("Options");
				}
			}
		
		}
    	
    	if( (dp.getDatas() != null && dp.getRowCount() > dp.getDatas().size())
    			|| (form.getCode() != null&&!"".equals( form.getCode())) || (form.getName() != null&&!"".equals( form.getName())) ) {
    		request.setAttribute("PAGEFLAG", new Boolean(true) );
    	}
    	
    	request.setAttribute("property",form.getProperty());
    	request.setAttribute( WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	
        return (actionMapping.findForward("list"));
    } 
	
}
