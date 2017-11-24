package com.sunrise.boss.web.common.menu;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.sunrise.boss.business.common.menu.control.Menuitem;
import com.sunrise.boss.business.common.menu.control.MenuitemBO;
import com.sunrise.boss.business.common.menu.persistent.MenuitemDBParam;
import com.sunrise.boss.business.common.menu.persistent.MenuitemVO;
import com.sunrise.boss.common.client.menutoken.PublicService;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
/**
 * 生成菜单树结构
 * @author qhb
 *
 */
public class MenuitemAction extends BaseAction{
	
	
	public MenuitemAction(){
		
		super.setForm(new MenuitemForm());
		super.setParam(new MenuitemDBParam());
		
		super.setClsVO(MenuitemVO.class);
		super.setClsControl(MenuitemBO.class);
		
		super.setDbFlag(DBConstant.DB_FLAG_COMMON);
		super.pkNameArray = new String[]{"menuid"};	
		
	}
	
	/**
	 * 输出菜单树
	 * @throws Exception
	 */
	public void doQueryTreeNodes() throws Exception{
		
		User user = (User)super.getDBAccessUser();
		
		Menuitem menuItem = (Menuitem)BOFactory.build(MenuitemBO.class,user);
		MenuitemDBParam param = new MenuitemDBParam();	
	
		param.set_orderby("sortorder");
		param.set_ne_region(user.getCityid());
		param.set_ne_status("1"); //有效状态的菜单
		param.set_pagesize("0");
		param.setDataOnly(true); //只获取数据，不获取总记录数
		DataPackage dp = menuItem.doQuery(param);
		// xml 格式节点树
//		String  treeNodes = doCreateTreeInfo(dp);		
		// json 格式节点树
		String treeNodes = doCreateJsonTree(dp);
		PrintWriter out = super.getResponse().getWriter();	
		out.write(treeNodes);			
		out.flush();
		out.close();

	}	
	// 创建菜单树结构
	private String doCreateTreeInfo(DataPackage dp) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		
		if(dp != null && dp.getDatas()!= null && dp.getDatas().size()> 0){
			
			List<MenuitemVO> items = dp.getDatas();
		
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\r\n");
			
			sb.append("<nodes>").append("\r\n");
			
			for(MenuitemVO item:items){	
				
				sb.append(doCreateXmlNode(item));
			}
			sb.append("</nodes>");
		}
		System.out.println("---------------------------------");
		System.out.println(""+sb.toString());
		System.out.println("---------------------------------");
		return sb.toString();
	}
	// 创建菜单节点
	private String doCreateXmlNode(MenuitemVO item){
		User user = (User)super.getDBAccessUser();
		
		StringBuilder sb = new StringBuilder();	
		sb.append("<node>")	;
		sb.append("<menuId>").append(item.getMenuid()==null ?"":item.getMenuid()).append("</menuId>").append("\r\n");
		sb.append("<menuName>").append(item.getMenuname()==null ?"":item.getMenuname()).append("</menuName>").append("\r\n");
		sb.append("<menuPid>").append(item.getMenupid()==null ?"":item.getMenupid()).append("</menuPid>").append("\r\n");	
		// xml 中特殊符号处理
		sb.append("<guiObject>");
		
		// 判断菜单权限，如没有权限则不传地址
		if(!PublicService.checkMenu(user, item.getMenuid())) {
			sb.append("");
		} else {
			if(null == item.getGuiobject() || "".equals(item.getGuiobject())) {
				sb.append("");	
			} else if(item.getSubsystemid().equalsIgnoreCase("UAP_WEB")){ // 本系统资源
				sb.append("<![CDATA[/"+item.getGuiobject()+"]]>");
			} else { // 外部系统资源
				sb.append("<![CDATA["+"integration.jsp?targetUrl="+item.getGuiobject()+"]]>"); 
			}
		}
		sb.append("</guiObject>").append("\r\n");
		sb.append("<status>").append(item.getStatus()==null?"":item.getStatus()).append("</status>").append("\r\n");
		sb.append("<region>").append(item.getRegion()==null?"":item.getRegion()).append("</region>").append("\r\n");		
		sb.append("</node>").append("\r\n");

		return sb.toString();
	}
	// 创建菜单节点
	private String doCreateJsonTree(DataPackage dp) throws Exception{
		User user = (User)super.getDBAccessUser();
		//存放树节点信息 
		List<Map<String,Object>> items = new ArrayList<Map<String,Object>>(); 
		
		//存放树节点信息  
		List<MenuitemVO> nodes = dp.toList(MenuitemVO.class);
        
        StringBuilder sb = new StringBuilder();
		
        List<String> trees = new ArrayList<String>();     
		for(MenuitemVO node:nodes){			
			Map<String,Object> item = new HashMap<String,Object>();   //最外层，父节点 
			
			item.put("id", node.getMenuid());
			item.put("pId", node.getMenupid());
			item.put("name", node.getMenuname());
			item.put("open", Boolean.TRUE);
		
			if(null == node.getGuiobject() || "".equals(node.getGuiobject())) {
				item.put("targetUrl", "");
			} else if(node.getSubsystemid().equalsIgnoreCase("UAP_WEB")){ // 本系统资源
				item.put("targetUrl",node.getGuiobject());					
			} else { // 外部系统资源
				item.put("targetUrl", "integration.jsp?targetUrl="+node.getGuiobject());
			}
					
			items.add(item);
		}
		JSONArray json = JSONArray.fromObject(items);
		System.out.println("***********************************");
		System.out.println(json.toString());
		System.out.println("***********************************");		
		
		return json.toString();
	}
	
}
