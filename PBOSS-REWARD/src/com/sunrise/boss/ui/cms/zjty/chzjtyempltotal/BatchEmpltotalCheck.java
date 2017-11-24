package com.sunrise.boss.ui.cms.zjty.chzjtyempltotal;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchEmpltotalCheck extends BaseCheckFormat {
	private int operType = 0;
	String[] heads = StringUtils
			.splitPreserveAllTokens(
					"����|��������|�˶���������|˵��",
					"|");

	public BatchEmpltotalCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		// TODO Auto-generated method stub
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		/*
		 * ���ݲ�ͬ�Ĳ������ϴ��ļ�������ͬ��
		 */
	
		if (this.operType != 2 && items.length != 4) {
			throw new Exception("�ϴ�������������,ӦΪ4��,��鿴˵������!");
			
		} else if (this.operType == 2 && items.length != 2) {
			throw new Exception("�ϴ�������������,ӦΪ2��,��鿴˵������!");
		}
		if(StringUtils.isBlank(items[0]) || StringUtils.isBlank(items[1]))
		{
			throw new Exception("[����]��[��������]����Ϊ��");
		}
		
		if(this.operType!=2)
		{
			WayDelegate delegate=new WayDelegate();
			WayVO vo=delegate.doFindByPk(items[1], user);
			if(vo==null)
			{
				throw new Exception("�������в����������������ļ�¼��"+items[1]);
			}else if(!"AG".equals(vo.getWaytype()) && !"ZJTY".equals(vo.getWaysubtype()))
			{
				throw new Exception("���˵�ֻ�ṩ�Խ���Ӫ���͵�����¼����޸�");
			}
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if(!items[0].trim().matches(regex))
		{
			throw new Exception("[����]��ʽΪ[YYYYMM]");
		}
		if(this.operType==0 || this.operType==1)
		{
			if(StringUtils.isNotBlank(items[1]) && items[1].getBytes("GBK").length>32)
			{
				throw new Exception("[��������]���ȳ���32λ");
			}
			if (StringUtils.isEmpty(items[2]) || !NumberUtils.isNumber(items[2])) {
				throw new BusinessException("", "[�˶�������]���Ϸ�,ӦΪ����,֧����λС��");
			}
			try {
				if (!(checkAmtFormat((items[2]), 4)))
					throw new Exception("[�˶�������]���Ϸ�,(" + items[2]
							+ ")�����������4λ������С��������һ����2λ!");
			} catch (Exception e) {
				throw new Exception("[�˶�������]���Ϸ�,(" + items[2]
						+ ")�����������4λ������С��������һ����2λ!");
			}
			
			if(StringUtils.isNotBlank(items[3]) && items[3].getBytes("GBK").length>32)
			{
				throw new Exception("[˵��]���ȳ���255λ");
			}
		}
		
	}


	public static void main(String[] args)throws Exception {
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		System.out.println("200810".matches(regex));
		System.out.println(StringUtils.isNotBlank(" "));
	}
	
	public boolean checkAmtFormat(String amt, int length) {
		amt = amt.trim();
		if (amt.indexOf(".") != -1) {
			if (amt.indexOf(".") == 0) {
				return false;
			}
			if (amt.indexOf(".") > length) {
				return false;
			}
			if ((amt.length() - amt.indexOf(".")) != 3) {
				return false;
			}
		} else {
			if (amt.length() > length) {
				return false;
			}
		}
		return true;
	}
}
