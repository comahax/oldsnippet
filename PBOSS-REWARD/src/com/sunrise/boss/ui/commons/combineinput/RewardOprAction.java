package com.sunrise.boss.ui.commons.combineinput;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.common.combineinput.persistent.CombineinputListVO;
import com.sunrise.boss.business.common.combineinput.persistent.CombineinputVO;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: CombineinputAction </p>
 * <p>Description: 联动下拉框动作控制Action </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class RewardOprAction extends CombineinputAction {
	public static String SINGLE_QUERY_LIMIT = "1000"; //单次查询结果数据限制
	public static int SINGLE_OUT_LIMIT = 50; //单次页面输出限制
	public static int LITTLE_LIMIT = 20; //差值限制
	
	public RewardOprAction() {
	}
	//拆分界面上的数据并按指定格式显示
	public String[] splitData(String originalStr,String symbol,User user)throws Exception{
		String[] array=null;
		if(originalStr!=null && !originalStr.equals("")){
			String[] tempArray=originalStr.split(symbol);
			array=new String[tempArray.length];
			for(int i=0;i<tempArray.length;i++){
				//OperationListVO lsitvo=new OperationListVO();
				String original=tempArray[i].substring(0,tempArray[i].indexOf("-"));
				OperationDelegate delegate=new OperationDelegate();
				OperationVO vo=delegate.doFindByPk(original,user);
				array[i]=vo.getOpnid()+"-"+vo.getName();
			}
		}else{
			return new String[0];
		}
		return array;
	}
	//                  
	public StringBuffer scrabbleData(String id,String name){
		StringBuffer line =new StringBuffer("");
    	line.append("<select>");
    	line.append("<value>");
    	line.append(id+"-"+name);
    	line.append("</value>");
    	line.append("<text>");
    	line.append(id + "-" + name);
    	line.append("</text>");
    	line.append("</select>");
    	return line;
	}
}
