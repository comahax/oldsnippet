
package com.sunrise.boss.ui.qsmanage.paramsmanage.batchparamset;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent.ImpFieldDetaListVO;
import com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent.ImpFieldDetaVO;
import com.sunrise.boss.business.qsmanage.paramrules.imprule.persistent.ImpRuleVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.Escape;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * 处理从批量发过来的请求，由于批量菜单的form无法转换成baseactionform类型，所以要有execute方法来处理
 * @author wangguangying 20090320
 * 
 *
 */
public class ParamSetAction extends Action {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		String cmd = request.getParameter(WebConstant.PAGE_ATTRIBUTE_COMMAND);
		if (cmd.equals("VIEW")) {
			return doView(actionMapping, actionForm, request, response, user);
		}else if(cmd.equals("SHOWDETA")){
			return doShowdeta(actionMapping, actionForm, request, response, user);
		}
		return null;
		
	}
	
	/**
	 * ajax调用，异步显示导入数据格式
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doView(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=GDK");
		StringBuffer outstring = new StringBuffer();
		
		Long ruleid = new Long(request.getParameter("ruleid"));

		CommonDelegate ruledele = new CommonDelegate(ImpRuleVO.class);
		ImpRuleVO rulevo = (ImpRuleVO) ruledele.doFindByPk(ruleid, user);
		
		CommonDelegate fielddele = new CommonDelegate(ImpFieldDetaVO.class);
		ImpFieldDetaListVO listVO = new ImpFieldDetaListVO();
		listVO.set_ne_ruleid(ruleid.toString());
		listVO.set_nnl_fieldindex("1");
		listVO.set_orderby("fieldindex");
		listVO.set_desc("asc");
		listVO.set_pagesize("0");
		DataPackage dp = fielddele.doQuery(listVO, user, false);
		List list = dp.toList(ImpFieldDetaVO.class);
		
		String curtable = null;
		StringBuffer desc = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			ImpFieldDetaVO vo = (ImpFieldDetaVO) list.get(i);
			outstring.append(vo.getFieldname()).append(rulevo.getSepchar());
			if((i + 1) % 7 == 0){
				outstring.append("<br>");
			}
			if(curtable == null){
				curtable = vo.getBusiname();
				desc.append(curtable);
			}else if(!curtable.equals(vo.getBusiname())){
				if(i != list.size()){
					desc.append("->").append(vo.getBusiname());
					curtable = vo.getBusiname();
				}
				
			}
			if((i + 1) % 18 == 0){
				desc.append("<br>");
			}
		}
		outstring.append("<br>");
		outstring.append("+").append(desc.toString());
		out.print(Escape.escape(outstring.toString()));
		return null;
	}
/**
 * 弹出框显示规则具体信息
 * @param actionMapping
 * @param actionForm
 * @param request
 * @param response
 * @param user
 * @return
 * @throws Exception
 */
	public ActionForward doShowdeta(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		Long ruleid = new Long(request.getParameter("ruleid"));
		CommonDelegate ruledele = new CommonDelegate(ImpRuleVO.class);
		ImpRuleVO rulevo = (ImpRuleVO) ruledele.doFindByPk(ruleid, user);

		CommonDelegate fielddele = new CommonDelegate(ImpFieldDetaVO.class);
		ImpFieldDetaListVO listVO = new ImpFieldDetaListVO();
		listVO.set_ne_ruleid(ruleid.toString());
		listVO.set_orderby("fieldindex");
		listVO.set_desc("asc");
		listVO.set_pagesize("0");
		DataPackage dp = fielddele.doQuery(listVO, user, false);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		request.setAttribute("rulevo", rulevo);
		
		return (actionMapping.findForward("listdeta"));
	}
}
