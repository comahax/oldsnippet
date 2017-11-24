package com.sunrise.boss.ui.cms.waycompact;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.base.*;

import com.sunrise.boss.ui.cms.commons.CMSConstant;
import com.sunrise.boss.ui.cms.commons.UploadFile;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactListVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.waycompact.WaycompactDelegate;

/**
 * AGWaycompactAction <br>
 * Description: 社会渠道：合同资料专用Action
 * 
 * <br>
 * Company: Sunrise,Guangzhou</br>
 * 
 * @author yijianrong
 * @since 1.0
 * @version 1.0 2007-4-5
 */
public class AGWaycompactAction extends BaseDelegateAction {
	public AGWaycompactAction() {
		setVoClass(WaycompactVO.class);
		this.pkNameArray = new String[1];
		pkNameArray[0] = "wayid";
	}

	/**
	 * 列表
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String waysubtype = request.getParameter("WAYSUBTYPE");
			String wayid = request.getParameter("WAYID");
			WaycompactForm form = (WaycompactForm) actionForm;
			Page.setPageSize(request, form);
			if (wayid != null && !wayid.trim().equals("")) {
				form.set_se_wayid(wayid);
			}

			WaycompactListVO listVO = new WaycompactListVO();
			setListVO(listVO, form);

			if (listVO.getSubtype() == null
					|| listVO.getSubtype().trim().equals("")) {
				listVO.setSubtype(waysubtype);
			}

			WaycompactDelegate delegate = new WaycompactDelegate();
			DataPackage dp = delegate.queryByOprcodeAndType(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, be
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	/**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			WaycompactForm form = (WaycompactForm) actionForm;
			// 为了不影响已有的业务，再此调用BEAN的判断方法
			WayDelegate waydelegate = new WayDelegate();
			if (!waydelegate.isAGWay(form.getWayid(), form.getSubtype(), user)) {
				throw new BusinessException("AGWAY_ERR01", "渠道编码："
						+ form.getWayid() + "；该渠道不属于社会渠道或对应的子渠道类型不正确，请重新选择渠道");
			}

			// 上传
			FormFile compactfile = form.getCompactfile();
			try {
				if (compactfile != null && compactfile.getFileName() != null
						&& compactfile.getFileSize() > 0) {
					String uploadpath = servlet.getServletContext()
							.getRealPath("/")
							+ CMSConstant.COMPACT_UPLOADPATH;
					if (UploadFile.doUpLoadFile(uploadpath, compactfile,
							request)) {
						form.setCompactpath(uploadpath
								+ compactfile.getFileName());
					}
				}
			} catch (Exception ex) {
				// 不做处理
			}

			FormFile licencefile = form.getLicencefile();
			try {
				if (licencefile != null && licencefile.getFileName() != null
						&& licencefile.getFileSize() > 0) {
					String uploadpath = servlet.getServletContext()
							.getRealPath("/")
							+ CMSConstant.COMPACT_UPLOADPATH;
					if (UploadFile.doUpLoadFile(uploadpath, licencefile,
							request)) {
						form.setLicencepath(uploadpath
								+ licencefile.getFileName());
					}
				}
			} catch (Exception ex) {
				// 不做处理
			}

			WaycompactDelegate delegate = new WaycompactDelegate();
			WaycompactVO contentVO = new WaycompactVO();
			setSaveVO(contentVO, form);
			contentVO.setBegintime(contentVO.getSigntime());

			WaycompactVO existObj = null;
			existObj = delegate.doFindByPk(form.getWayid(), user);

			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				if (existObj!=null){
					org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
							contentVO);
					contentVO = existObj;		
				}
				delegate.doUpdate(contentVO, user);
			} else {
				if (existObj != null) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					throw new BusinessException("", "已经存在该渠道编码："
							+ form.getWayid() + "的记录，请重新选择");
				} else {
					delegate.doCreate(contentVO, user);
				}
			}
			BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
			form.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return (actionMapping.findForward("content"));

	}

	/**
	 * 编辑
	 */
	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		try {
			WaycompactForm form = (WaycompactForm) actionForm;
			getContentVO(request, form, user);

			String command = getCommandString(request);
			form.setCmdState(command);
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
		} catch (BusinessException be) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, be
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * getContentVO
	 * 
	 * @param request
	 * @param form
	 * @param user
	 * @throws Exception
	 */
	private void getContentVO(HttpServletRequest request, WaycompactForm form,
			User user) throws Exception {
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null) {
			throw new NullPointerException("pk is required.");
		}

		Object contentVO = getContentVO(request, user);
		if (contentVO == null) {
			form.setWayid(pk);
		} else {
			BeanUtils.copyProperties(form, contentVO);
		}
	}
}
