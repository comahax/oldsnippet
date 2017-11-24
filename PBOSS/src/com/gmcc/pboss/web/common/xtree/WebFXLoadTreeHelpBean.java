package com.gmcc.pboss.web.common.xtree;

import java.util.HashMap;
import java.util.List;

/**
 * WebFXLoadTree辅助类,帮助界面输出量过大,异步输出
 * @author Canigar
 *
 */
public class WebFXLoadTreeHelpBean {

	public static final HashMap<String, List<WebFXLoadTreeNode>> strHashMap = new HashMap<String, List<WebFXLoadTreeNode>>();
	public static final int browserLimitedLines = 100; //限制查询行数,过长需要进行数据优化 
	
	/**
	 * 根据父节点获取子节点剩余的数据
	 * @param parentNode
	 * @return
	 */
	public static String getRemainXmlStr(String parentNodeKey){
		List<WebFXLoadTreeNode> remainNodesList = strHashMap.get(parentNodeKey);
		StringBuffer buf = new StringBuffer(WebFXLoadTreeConfiger.node2XmlHead());
		
		int i=0;
		for(int j=0; j<remainNodesList.size(); ){
			buf.append(WebFXLoadTreeConfiger.node2XmlContent(remainNodesList.get(j)));
			remainNodesList.remove(j);
			if( (++i) > browserLimitedLines){
				break;
			}
		}
		if(remainNodesList.size() != 0){
			buf.append(WebFXLoadTreeConfiger.node2XmlRemainTag(parentNodeKey));
		}
		buf.append(WebFXLoadTreeConfiger.node2XmlEnd());
		
		return buf.toString();
	}
	

}
