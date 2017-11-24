/**
* auto-generated code
* Sat Jan 12 10:23:04 CST 2013
*/
package com.sunrise.boss.ui.cms.chadtwaymod;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodListVO;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.chadtwaymod.ChAdtWaymodDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtWaymodAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtWaymodAction extends BaseAction {
    public ChAdtWaymodAction() {
		setVoClass(ChAdtWaymodVO.class);
		// TODO: ������������������
		this.pkNameArray = new String[1];
		pkNameArray[0] = "wayid";
	}
    
    @Override
    protected ActionForward doList(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		((ChAdtWaymodForm) actionForm).set_ne_cityid(user.getCityid());
		return super.doList(actionMapping, actionForm, request, response, user);
	}

	@Override
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChAdtWaymodForm form = (ChAdtWaymodForm) actionForm;
		ChAdtWaymodVO contentVO = new ChAdtWaymodVO();
		BeanUtils.copyProperties(contentVO, form);
		contentVO.setCityid(Short.parseShort(user.getCityid()));
		ChAdtWaymodDelegate delegate = new ChAdtWaymodDelegate();
		String cmdState = form.getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// ����
			delegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} else {// ����
			ChAdtWaymodVO vo = null;
			if (contentVO.getWayid() != null && !contentVO.getWayid().equals("")) {
				vo = delegate.doFindByPk((Serializable)contentVO.getWayid(), user);
			}
			if (vo == null) {
				delegate.doCreate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // �Ѹ��º��ֵ����form������web��ʾ
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�Ѵ��ڸ������ŵ겹������ϵ��");
				onDuplicatePk(actionMapping, actionForm, request, response, user);
			}
		}
		return (actionMapping.findForward("content"));
	}

	@Override
	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((ChAdtWaymodForm) actionForm).get_selectitem();
		ChAdtWaymodDelegate delegate = new ChAdtWaymodDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			ChAdtWaymodVO vo = delegate.doFindByPk((Serializable)selectArray[i], user);
			delegate.doRemove(vo, user);
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("��Ȧ�ŵ겹������ϵ��");
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayid", "��������", export.CODE2NAME, "#WAY");
		export.addOutputProperty("vi", "VI����");
		export.addOutputProperty("area", "���");
		export.addOutputProperty("doorhead", "��ͷ��棨������");
		export.addOutputProperty("backboard", "�ֻ����壨������");
		export.addOutputProperty("propaganda", "���������ࣨ������");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
	
}
