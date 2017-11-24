/**
 * auto-generated code
 * Mon Jul 13 10:27:28 CST 2009
 */
 package com.gmcc.pboss.web.base.rightitem;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.base.rightitem.RightitemVO ;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.base.rightitem.RightitemDBParam;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.base.acl.ACL;
import com.gmcc.pboss.control.base.acl.ACLBO;
import com.gmcc.pboss.control.base.rightitem.Rightitem ;
import com.gmcc.pboss.control.base.rightitem.RightitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;

/**
 * <p>Title: RightitemAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Lee
 * @version 1.0
 */
public class RightitemAction extends BaseAction{
	
	public RightitemAction() {
		super();

		this.setForm(new RightitemForm());
		this.setParam(new RightitemWebParam());

        setClsVO(RightitemVO.class);
        this.pkNameArray=new String[]{"rightid"};
		this.setClsControl(Rightitem.class);
		this.setClsQueryParam(RightitemDBParam.class) ;

	}
	
	public String doTree(){
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			String contextPath = request.getContextPath();
			String topChildrenURI = "selectRightXml.jsp";
			
			Rightitem rightitem = (Rightitem) BOFactory.build(RightitemBO.class, getDBAccessUser());
//			DataPackage dp = rightitem.doQueryRightRootId();
//			if(dp.getDatas() == null || dp.getDatas().size() == 0){
//				throw new BusinessException("该根节点不存在!");
//			}
//			
//			RightitemVO rootvo = (RightitemVO) dp.getDatas().get(0);
			
			String rootId = "0";
			String rootName = "令牌树";
			
			
			StringBuffer topChildrenURLBuffer = new StringBuffer(100);
			topChildrenURLBuffer.append(contextPath).append("/base/rightitem/").append(topChildrenURI)
				.append("?parentid=").append(rootId)
				.append("&parentname=").append(rootName)
				.append("&childrenURL=").append(contextPath).append("/base/rightitem/").append(topChildrenURI);
			
			System.out.println(topChildrenURLBuffer.toString());
			
			request.setAttribute("rootId", rootId);
			request.setAttribute("rootName", rootName);
			request.setAttribute("topChildrenURL", topChildrenURLBuffer.toString());
			
		}catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
			request.setAttribute("rootName", "非法数据");
			// TODO: handle exception
		}
		
		return "tree";
	}
}