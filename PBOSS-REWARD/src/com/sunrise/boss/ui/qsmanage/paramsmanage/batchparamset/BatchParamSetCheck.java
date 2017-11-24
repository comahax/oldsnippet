package com.sunrise.boss.ui.qsmanage.paramsmanage.batchparamset;

import java.util.HashMap;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.fee.qsmanage.common.utils.QsUtils;
import com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent.ImpFieldDetaListVO;
import com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent.ImpFieldDetaVO;
import com.sunrise.boss.business.qsmanage.paramrules.imprule.persistent.ImpRuleVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.pub.tools.StringSplit;
/**
 * 
 * @author wangguangying 20090320
 *
 */
public class BatchParamSetCheck implements ICheckFormat {
	private Long ruleid;

	private ImpRuleVO rulevo;

	private DataPackage dp;

	public DataPackage getDp() {
		return dp;
	}

	public void setDp(DataPackage dp) {
		this.dp = dp;
	}

	public ImpRuleVO getRulevo() {
		return rulevo;
	}

	public void setRulevo(ImpRuleVO rulevo) {
		this.rulevo = rulevo;
	}

	public BatchParamSetCheck() {
		super();
	}
	
	/**
	 * ��ʼcheck�и�������ֵ�������������ļ��ļ��
	 */
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.setRuleid(Long.valueOf((String)parameterMap.get("ruleid")));
		try {
			User user = new User();
			user.setCityid("999");
			CommonDelegate ruledele = new CommonDelegate(ImpRuleVO.class);
			this.setRulevo((ImpRuleVO) ruledele.doFindByPk(getRuleid(), user));
			CommonDelegate fielddele = new CommonDelegate(ImpFieldDetaVO.class);
			ImpFieldDetaListVO listVO = new ImpFieldDetaListVO();
			listVO.set_ne_ruleid(getRuleid().toString());
			listVO.set_orderby("fieldindex");
			listVO.set_desc("asc");
			listVO.set_pagesize("0");
			this.setDp(fielddele.doQuery(listVO, user, false));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (getRulevo().getFilehead() != null
				&& !getRulevo().getFilehead().equals("")
				&& !file.getFileName().startsWith(getRulevo().getFilehead())) {
			throw new Exception("Ҫ������ļ����Ʋ���ȷ������ǰ׺������ο�����˵��!");
		}
		
		if (getRulevo().getFiletail() != null
				&& !getRulevo().getFiletail().equals("")
				&& !file.getFileName().toLowerCase().endsWith(getRulevo().getFiletail())) {
			throw new Exception("Ҫ������ļ����Ʋ���ȷ�����Ϻ�׺������ο�����˵��!");
		}
		
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount) throws Exception {

		if (rowCount > getRulevo().getFilenum().intValue()) {
			throw new Exception("�ļ��������ܳ���["
					+ getRulevo().getFilenum().toString() + "]��");
		}

		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringSplit.split(line, getRulevo().getSepchar());
		if (items.length != getRulevo().getFieldnum().intValue()) {
			throw new Exception("�����ļ����ϴ������������ԣ�ӦΪ[" + getRulevo().getFieldnum().toString()
					+ "]�У�");
		}

		List list = dp.toList(ImpFieldDetaVO.class);
		for (int i = 0; i < list.size(); i++) {
			ImpFieldDetaVO vo = (ImpFieldDetaVO) list.get(i);
			int index = vo.getFieldindex().intValue();
			index = index < 0 ? -index : index ;
			if(!(((items[index-1] == null || items[index-1].equals("")) && (vo.getMainfield().intValue() == 2 || vo.getMainfield().intValue() == 0)))){
				QsUtils.checkVarible(vo, items[index-1]);
			}
		}
	}

	public Long getRuleid() {
		return ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}

}
