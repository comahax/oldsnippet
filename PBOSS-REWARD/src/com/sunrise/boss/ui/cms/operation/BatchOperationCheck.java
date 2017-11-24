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
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * ҵ�����ͱ�ʶ|ҵ����������|����ʶ|״̬|˵��|��������
	 */
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (fields.length != 6) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		}
		if(!"0".equals(fields[5]) && !"1".equals(fields[5]) && !"2".equals(fields[5])){
			throw new Exception("�������ͱ�����0(����)��1(�޸�)��2(ɾ��)�е�һ��");
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
			throw new Exception("ҵ���������Ʋ���Ϊ�գ��Ҳ��ܳ���25");
		}
		if(fields[2].length() > 18){
			throw new Exception("����ʶ���Ȳ��ܳ���18");
		}
		if(fields[3].length() > 2 || !fields[3].matches("[0-9]{1,2}")){
			throw new Exception("״̬Ϊ���Ȳ��ܳ���2������");
		}
		if(fields[4].length() > 125){
			throw new Exception("˵�����ܳ���125");
		}		
	}
	
	private void updateCheck(String[] fields)throws Exception {
		OperationDelegate delegate = new OperationDelegate();
		if("".equals(fields[0]) || fields[0].length() > 18){
			throw new Exception("ҵ�����ͱ�ʶ����Ϊ�գ��Ҳ��ܳ���18");
		}
		OperationVO operationVO = delegate.doFindByPk(fields[0], user);
		if(operationVO == null){
			throw new Exception("ҵ�����ͣ�" + fields[0] + "������");
		}
		if(!"".equals(fields[1]) && fields[1].length() > 25){
			throw new Exception("ҵ���������Ʋ��ܳ���25");
		}
		if(fields[2].length() > 18){
			throw new Exception("����ʶ���Ȳ��ܳ���18");
		}
		if(fields[3].length() > 2){
			throw new Exception("״̬���Ȳ��ܳ���2");
		}
		if(fields[4].length() > 125){
			throw new Exception("˵�����ܳ���125");
		}
	}

	private void deleteCheck(String[] fields)throws Exception {
		if("".equals(fields[0]) || fields[0].length() > 18){
			throw new Exception("ҵ�����ͱ�ʶ����Ϊ�գ��Ҳ��ܳ���18");
		}
		OperationDelegate delegate = new OperationDelegate();
		OperationVO operationVO = delegate.doFindByPk(fields[0], user);
		if(operationVO == null){
			throw new Exception("ҵ�����ͣ�" + fields[0] + "������");
		}
	}
}
