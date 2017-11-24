package com.gmcc.pboss.web.base.operrole;

import java.sql.Date;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.operrole.OperroleDBParam;
import com.gmcc.pboss.business.base.operrole.OperroleVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.operrole.Operrole;
import com.gmcc.pboss.control.base.operrole.OperroleBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class OperroleTaskBean extends BaseBatchTaskBean {

	public OperroleTaskBean() throws Exception {
		super.setBatchName("����Ա��ɫ������������");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "����Ա��ɫ��������������  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			Operrole operrole = (Operrole) BOFactory.build(OperroleBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			OperroleVO vo = new OperroleVO();
			vo.setOperid(items[0]);
			vo.setRoleid(items[1]);
			vo.setStatus(new Byte(items[2]));
			vo.setStatusdate(isNull(items[3].trim()) ? null : Date
					.valueOf(items[3]));
			vo.setCreatedate(new java.util.Date());
			OperroleDBParam param = new OperroleDBParam();
			param.set_se_operid(vo.getOperid());
			param.set_se_roleid(vo.getRoleid());
			if (operrole.doQuery(param).getRowCount() == 0) {
				operrole.doCreate(vo);
			} else {
				operrole.doUpdate(vo);
			}
			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
	
	private boolean isNull(String item) {
		return "".equals(item) || "null".equals(item);
	}

	public static void main(String[] s) {

	}
}