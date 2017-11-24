package com.sunrise.boss.ui.cms.operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;
import com.sunrise.boss.business.cms.microarea.persistent.MicroareaVO;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.servcent.persistent.ServcentVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.cntycompany.CntycompanyDelegate;
import com.sunrise.boss.delegate.cms.microarea.MicroareaDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.servcent.ServcentDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchOperationCheck extends BaseCheckFormat {

	private User user;

	public BatchOperationCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		user = (User) parameterMap.get("user");
		String fileName = file.getFileName();
		if (!fileName.substring(fileName.length() - 4).equalsIgnoreCase(".txt")) {
			// if (!file.getContentType().equals("text/plain"))
			// {System.out.println("file.getContentType()="+file.getContentType());
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	/**
	 * 业务类型标识|业务类型名称|父标识|状态|说明|操作类型
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("文件行数不能超过10000行");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		// 检查列数
		if (fields.length != 6) {
			throw new Exception("上传数据列数不对,应为6列,请查看说明帮助!");
		}
		if(!"0".equals(fields[5]) && !"1".equals(fields[5]) && !"2".equals(fields[5])){
			throw new Exception("操作类型必须是0(增加)、1(修改)、2(删除)中的一种");
		}
		if("0".equals(fields[5])){
			insertCheck(fields);
		}else if("1".equals(fields[5])){
			updateCheck(fields);
		}else if("2".equals(fields[5])){
			deleteCheck(fields);
		}
	}
	
	private void insertCheck(String[] fields)throws Exception {
		if("".equals(fields[1]) || fields[1].length() > 25){
			throw new Exception("业务类型名称不能为空，且不能超过25");
		}
		if(fields[2].length() > 18){
			throw new Exception("父标识长度不能超过18");
		}
		if(fields[3].length() > 2 || !fields[3].matches("[0-9]{1,2}")){
			throw new Exception("状态为长度不能超过2的数字");
		}
		if(fields[4].length() > 125){
			throw new Exception("说明不能超过125");
		}		
	}
	
	private void updateCheck(String[] fields)throws Exception {
		OperationDelegate delegate = new OperationDelegate();
		if("".equals(fields[0]) || fields[0].length() > 18){
			throw new Exception("业务类型标识不能为空，且不能超过18");
		}
		OperationVO operationVO = delegate.doFindByPk(fields[0], user);
		if(operationVO == null){
			throw new Exception("业务类型：" + fields[0] + "不存在");
		}
		if(!"".equals(fields[1]) && fields[1].length() > 25){
			throw new Exception("业务类型名称不能超过25");
		}
		if(fields[2].length() > 18){
			throw new Exception("父标识长度不能超过18");
		}
		if(fields[3].length() > 2){
			throw new Exception("状态长度不能超过2");
		}
		if(fields[4].length() > 125){
			throw new Exception("说明不能超过125");
		}
	}

	private void deleteCheck(String[] fields)throws Exception {
		if("".equals(fields[0]) || fields[0].length() > 18){
			throw new Exception("业务类型标识不能为空，且不能超过18");
		}
		OperationDelegate delegate = new OperationDelegate();
		OperationVO operationVO = delegate.doFindByPk(fields[0], user);
		if(operationVO == null){
			throw new Exception("业务类型：" + fields[0] + "不存在");
		}
	}
}
