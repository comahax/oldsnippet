package com.gmcc.pboss.web.channel.employee;

import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
/**
 * ���������Ա����
 * @author wefrogll
 * @version 1.0 2009-11-20
 */
public class SocietyPeopleTaskBean extends BaseBatchTaskBean{
	private String param92 = "";
	private String resultStr = "";
	private boolean customeFlag = false;

	public SocietyPeopleTaskBean() throws Exception {
		super.setBatchName("���������Ա��������");
		super.setOprtype("����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	protected String doStart() {
		try {
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class, user);
			param92 = sysparamBO.doFindByID("92", "channel");
		} catch (Exception e) {
		}
		return "�����Ա��������������  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			if (rowCount == 1 && param92.equals("1")) {
				if (SocietyPeopleCheck.lineHead[0].equals(items[0])) {
					customeFlag = true;
					checkHead(items);
					resultVO.setInfo(line);
					resultVO.setOk(true);
					this.countrecord = this.countrecord - 1;
					this.ok = this.ok - 1;
					return resultVO;
				} else {
					customeFlag = false;
				}
			}
			EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
			if (rowCount > 1 && customeFlag) {
				rowCount = rowCount - 1;
				int count = SocietyPeopleCheck.lineHead.length;
				String checkLine[] = new String[count];
				items = copyArr(checkLine, items);
				employeeBO.doCustomPeopleImport(items);
			} else {
				employeeBO.doSocietypeopleImport(items);
			}
			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
	
	private void checkHead(String[] content) throws Exception {
		// ��ս�����ϴμ��Ľ��
		this.resultStr = "";
		for (int i = 0; i < content.length; i++) {
			boolean find = false;
			for (int j = 0; j < SocietyPeopleCheck.lineHead.length; j++) {
				if ("".equals(content[i])) {
					throw new Exception("�Զ��嵼���ļ�ͷ�в������п�,�����û������");
				}
				if (content[i].equals(SocietyPeopleCheck.lineHead[j])) {
					resultStr = resultStr + j + "|";
					find = true;
					continue;
				}
			}
			if (!find) {
				throw new Exception("�Զ����ļ�ͷ:" + content[i] + "����ȷ!");
			}
		}
	}
	
	private String[] copyArr(String[] arr, String[] content) {
		String temArr[] = StringUtils.splitPreserveAllTokens(resultStr, "|");
		for (int i = 0; i < temArr.length - 1; i++) {
			int temp = new Integer(temArr[i]).intValue();
			arr[temp] = content[i];
		}
		return arr;
	}
}
