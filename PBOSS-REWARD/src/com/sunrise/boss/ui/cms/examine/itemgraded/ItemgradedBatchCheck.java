package com.sunrise.boss.ui.cms.examine.itemgraded;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineListVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidListVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.examine.examine.ExamineDelegate;
import com.sunrise.boss.delegate.cms.examine.exmnitem.ExmnitemDelegate;
import com.sunrise.boss.delegate.cms.examine.oprnwayid.OprnwayidDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ItemgradedBatchCheck extends BaseCheckFormat {

	protected static String[] rewardasstype = new String[] { "0", "1", "2", "3" };

	public ItemgradedBatchCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringSplit.split(line, "|");
		WayDelegate waydelegate = new WayDelegate();

		if (content.length != 6){
			throw new BusinessException("", "������Ӧ��Ϊ6��,��鿴˵������!");
		}
		
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		format.setLenient(false);

		if (StringUtils.isEmpty(content[0]))
		{
			throw new BusinessException("", "���롾�������롿����Ϊ��!");
		}
		
		if ((content[0].length()>16))
		{
			throw new BusinessException("", "���롾�������롿���Ȳ��ܴ���32λ!");
		}

		WayVO wayvo = waydelegate.doFindByPk(content[0], user);
		if (wayvo == null) {
			throw new BusinessException("", "���롾�������롿������");
		}
		
		WayListVO listvo = new WayListVO();
		listvo.set_se_wayid(content[0]);
		listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		listvo.set_se_waytype("AG");
		DataPackage dp = waydelegate.doQuery(listvo, user);
		if(dp==null || dp.getDatas().size()==0){
			throw new BusinessException("", "���롾�������롿���Ǳ����е������������!");
		}
		CommonDelegate comdelegate = new CommonDelegate(SysparamVO.class);
    	Serializable pkVO=new SysparamVO();
		BeanUtils.setProperty(pkVO, "systemid","8");
		BeanUtils.setProperty(pkVO, "paramtype","pboss");
		SysparamVO sysparamVO=(SysparamVO)comdelegate.doFindByPk(pkVO, user);
		//���������ֵ[PARAMVALUE]��Ϊ1����ֻ���ڡ�����������Ȩ[CH_PW_OPRNWAYID]�����д���ӳ���ϵ�Ÿ��������֣�������������
		if("1".equals(sysparamVO.getParamvalue())){
			OprnwayidDelegate oprndelegate = new OprnwayidDelegate();
			OprnwayidListVO oprnparam = new OprnwayidListVO();
			oprnparam.set_se_operid(user.getOpercode());
			oprnparam.set_se_wayid(content[0]);
			DataPackage oprndp = oprndelegate.doQuery(oprnparam, user);
			
			if(oprndp==null || oprndp.getDatas().size()==0){
				throw new BusinessException("", "��ǰ�����ڡ��������롿[" + content[0] + "]�޷���������!");
			}
		}
		
		if (StringUtils.isEmpty(content[1]))
		{
			throw new BusinessException("", "���롾���˱�ʶ������Ϊ��!");
		}
		
		if ((content[1].length()>6))
		{
			throw new BusinessException("", "���롾���˱�ʶ�����Ȳ��ܴ���6λ!");
		}
		
		wayvo = waydelegate.doFindByPk(content[0], user);
		ExamineDelegate delegate = new ExamineDelegate();
		ExamineListVO params = new ExamineListVO();
		params.set_ne_exmnid(content[1]);
		params.set_sk_adtype(wayvo.getAdtypecode()!=null?wayvo.getAdtypecode().toString():null);
		params.set_sk_starlevel(wayvo.getStarlevel()!=null?wayvo.getStarlevel().toString():null);
		params.set_se_state("1");
		DataPackage exdp = delegate.doQueryExamineList(params, user);
		if(exdp==null || exdp.getDatas().size()==0){
			throw new BusinessException("", "���롾���˱�ʶ�����Ϸ�,�ڡ��������롿[" + content[0] + "]��, û�з�����������, �Ǽ�, ����Ч�ġ����˱�ʶ��!");
		}
		
		if (StringUtils.isEmpty(content[2]))
		{
			throw new BusinessException("", "���롾ָ���ʶ������Ϊ��!");
		}
		
		if ((content[2].length()>6))
		{
			throw new BusinessException("", "���롾ָ���ʶ�����Ȳ��ܴ���6λ!");
		}
		
		ExmnitemDelegate itemdelegate = new ExmnitemDelegate();
		ExmnitemVO itemvo = new ExmnitemVO();
		itemvo.setExmnid(new Integer(content[1]));
		itemvo.setExmnstdid(new Integer(content[2]));
		
		ExmnitemVO rltvo = itemdelegate.doFindByPk(itemvo, user);
		if(rltvo==null){
			throw new BusinessException("", "���롾ָ���ʶ���뵼��ġ����˱�ʶ��["+content[1]+"]�޶�Ӧ��ϵ!");
		}
		
		try {
			format.parse(content[3]);
		} catch (Exception e) {
			throw new BusinessException("", "���롾�������ڡ��²��Ϸ�,ӦΪ6λ��������!");
		}
		String regex = "^([1-9]\\d{3}[0][1-9])|([1-9]\\d{3}[1][0-2])$";
		if (!content[3].matches(regex)) {
			throw new BusinessException("", "���롾�������ڡ��²��Ϸ�,�·ݷ�ΧӦΪ[01-12]!");
		}
		
		if ((content[4].length()>5))
		{
			throw new BusinessException("", "���롾�۷����������Ȳ��ܴ���5λ!");
		}
		
		if (StringUtils.isEmpty(content[4]) || !NumberUtils.isNumber(content[4])) {
			throw new BusinessException("", "���롾�۷�����������Ϊ����ӦΪ����!");
		}
		
		if (Double.parseDouble(content[4])<0){
			throw new BusinessException("", "���롾�۷�������ֵ�������0!");
		}
		
		try {
			if (!(checkAmtFormat(content[4], 3)))
				throw new Exception("�������Ϸ�,(" + content[4]
						+ ")�����������3λ������С��������һ����2λ!");
		} catch (Exception e) {
			throw new Exception("�������Ϸ�,(" + content[4]
					+ ")�����������3λ������С��������һ����2λ!");
		}
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
