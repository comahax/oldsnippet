package com.gmcc.pboss.web.channel.zjty.zjtywayinfo;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceDBParam;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


public class ZjtywayinfoCheck extends BaseCheckFormat {

	
	public ZjtywayinfoCheck() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * �жϵ����ļ���ʽ
	 */
	public void checkFile(File file, HashMap parameterMap, String contentType)
		throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
	}
	}
	
	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
//		1����|2��������|3�ϼ�����|4���������|5����������|6������|7���й�˾|8�ֹ�˾|9������������|
//		10΢����|11�Ǽ�|12��Ӫģʽ|13�Ƿ�����|14������ʽ|15��ҵ��Դ����|16��Ȧ����|17��������|18��ϵ�绰|
//		19��������|20����γ��|21������|22��ϸ��ַ|23����״̬|24�Ƿ���������|25�����̱���|26�Ƿ���|
//		27ȫ��ͳһ��������|28����|29������������|30�Ƿ���������|31ǰ̨Ӫҵ������O��|32�����ŶӽкŻ�|
//		33����POS��|34����24Сʱ����Ӫҵ��|35����VIPרϯ|36����VIP��|37G3���������|38ί�з���˾����|
//		39����ע���|40���˴���|41���֤����|42ǩԼ���|43Э��ǩ����Чʱ��|44Э���ֹʱ��|

		//1����
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (items.length != (48-2)) {
			throw new Exception("�ϴ�������������,ӦΪ45��,��鿴˵������!");
		}		
		// ��������
		if (StringUtils.isBlank(items[0])) {
			throw new Exception("�������벻��Ϊ�ա�");
		}
		if (items[0].getBytes("GBK").length > 18) {
			throw new Exception("[��������]���Ȳ��ܳ���18!");
		}
		
		//2��������
		if(StringUtils.isEmpty(items[1])){
			throw new Exception("�������Ʋ���Ϊ�ա�");
		}
		
		//3�ϼ�����
		if(StringUtils.isEmpty(items[2])){
			throw new Exception("�ϼ���������Ϊ�ա�");
		}
		
		
		//4���������
		if (StringUtils.isNotEmpty(items[3])){
			if (items[4].equals(getDictName("CH_SVBRCHTYPE",items[3],user))){
				throw new Exception("�̶�����:[���������]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		
		
		//5����������
		if(StringUtils.isEmpty(items[4])){
			throw new Exception("������������Ϊ�ա�");
		}
		//6������
		if(StringUtils.isNotEmpty(items[5])){
			if(!items[5].equals("ZJTY")){
				throw new Exception("������ֻ����ZJTY��");
			}
		}
//		//7���й�˾
//		if (StringUtils.isBlank(items[6])) {
//			throw new Exception("[���й�˾]����Ϊ�ա�");
//		}
//		if (isCityid(items[6])) {
//			throw new Exception("[���й�˾]ֻ��Ϊ(GZ,SZ,ZH,FS,ST,HZ,ZJ,JM,ZQ,SG,MZ,DG,ZS,MM,SW,CZ,JY,YJ,QY,HY,YF)");
//		}
		//8�ֹ�˾
		//9������������
		//10΢����
		//11�Ǽ�
		if (StringUtils.isNotEmpty(items[10-1])){
			if (items[10-1].equals(getDictName("CH_STARLEVEL",items[10-1],user))){
				throw new Exception("�̶�����:[�Ǽ�]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		
		//12��Ӫģʽ
//		if (StringUtils.isBlank(items[11])) {
//			throw new Exception("[���й�˾]����Ϊ�ա�");
//		}
//		if (!items[11].equals("1")){
//			throw new Exception("��Ӫģʽֻ����1��");
//		}
		
		//13�Ƿ�����
		if (StringUtils.isNotEmpty(items[12-1-1])){
			if (!check(items[12-1-1])){
				throw new Exception("�̶�����:[�Ƿ�����]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		//14������ʽ
		if (StringUtils.isNotEmpty(items[13-1-1])){
			if (items[4].equals(getDictName("CH_CONNECTTYPE",items[13-1-1],user))){
				throw new Exception("�̶�����:[������ʽ]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		
		//15��ҵ��Դ����
		if(StringUtils.isEmpty(items[14-1-1])){
			throw new Exception("��ҵ��Դ���಻��Ϊ�ա�");
		}
		if (StringUtils.isNotEmpty(items[14-1-1])){
			if (items[14-1-1].equals(getDictName("CH_PRTSOURCE",items[14-1-1],user))){
				throw new Exception("�̶�����:[��ҵ��Դ����]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		
		//16��Ȧ����
		if(StringUtils.isEmpty(items[15-1-1])){
			throw new Exception("��Ȧ���Ͳ���Ϊ�ա�");
		}
		//17��������
		if(StringUtils.isEmpty(items[16-1-1])){
			throw new Exception("�������Ͳ���Ϊ�ա�");
		}
		//18��ϵ�绰
		if(StringUtils.isNotEmpty(items[17-1-1])){
			try{
			Long tel = Long.valueOf(items[17-1-1]);
			}catch(Exception e){
				throw new Exception("��ϵ�绰ֻ�������֡�");			
			}
			
		}
		//19��������
		//20����γ��
		if(StringUtils.isEmpty(items[19-1-1])){
			throw new Exception("����γ�Ȳ���Ϊ�ա�");
		}
		//21������
		if(StringUtils.isEmpty(items[20-1-1])){
			throw new Exception("�����Ȳ���Ϊ�ա�");
		}
		//22��ϸ��ַ
		if(StringUtils.isEmpty(items[21-1-1])){
			throw new Exception("��ϸ��ַ����Ϊ�ա�");
		}
		//23����״̬
		if (StringUtils.isNotEmpty(items[22-1-1])){
			if (items[4].equals(getDictName("CH_WAYSTATE",items[22-1-1],user))){
				throw new Exception("�̶�����:[����״̬]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		
		
		//24�Ƿ���������
		if (StringUtils.isNotEmpty(items[23-1-1])){
			if (!check(items[23-1-1])){
				throw new Exception("�̶�����:[�Ƿ���������]��ֵ��ϵͳ�в����ڡ�");
			}
		}
// <j:selector name="form.chainhead" definition="#WAY" condition="waytype:AG;waysubtype:DIS;waystate:1;cityid:GD" />
		//25�����̱���
		if (StringUtils.isNotEmpty(items[24-1-1])){
			
			WayVO wayvo = new WayVO();
			WayBO waybo = (WayBO) BOFactory.build(WayBO.class, user);
			wayvo.setWayid(items[24-1-1]);
			if (waybo.doFindByPk(wayvo.getWayid()) == null) {
				throw new Exception("�����̱��벻����");
			}

			WayDBParam param = new WayDBParam();
			param.set_se_wayid(items[24-1-1]);
			param.set_se_waytype("AG");
			param.set_se_waysubtype("DIS");
			param.set_se_cityid("GD");
			param.set_ne_waystate("1");
			DataPackage dp = waybo.doQuery(param);
			if (dp == null || dp.getDatas().size() == 0) {
				throw new Exception("��[" + items[24-1-1] + "]���Ǻ����̱���!");
			}
			
		}
		//26�Ƿ���
		if (StringUtils.isNotEmpty(items[25-1-1])){
			if (!check(items[25-1-1])){
				throw new Exception("�̶�����:[�Ƿ���]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		//27ȫ��ͳһ��������
//		// ȫ��ͳһ������������ж�
		if (StringUtils.isNotEmpty(items[26-1-1])){
	//		WayprovinceDelegate delegate = new WayprovinceDelegate();
			Wayprovince  wayprovince=(Wayprovince)BOFactory.build(WayprovinceBO.class,user);
			WayprovinceDBParam wayprovinceListVO = new WayprovinceDBParam();
			wayprovinceListVO.set_se_uniquewayid(items[26-1-1].trim());
			DataPackage dp = wayprovince.doQuery(wayprovinceListVO);
			if(dp.getRowCount()!= 0){
				Iterator it = dp.getDatas().iterator();
				while (it.hasNext()) {
					WayprovinceVO vo = null;
					vo = (WayprovinceVO)it.next();
					if (!items[0].trim().equals(vo.getWayid())) {
						throw new Exception("ȫ��ͳһ��������:"+items[26-1-1]+" ��ϵͳ���Ѵ��ڡ�");
					}
				}
			}
		}
		//28����
		if (items[27-1-1].getBytes("GBK").length > 30) {
			throw new Exception("[����]���Ȳ��ܳ���30��");
		}
		//29������������
		if (StringUtils.isNotEmpty(items[28-1-1])){
			if (items[28-1-1].equals(getDictName("CH_PROVTYPE",items[28-1-1],user))){
				throw new Exception("�̶�����:[������������]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		//30�Ƿ���������
		if (StringUtils.isNotEmpty(items[29-1-1])){
			if (!check(items[29-1-1])){
				throw new Exception("�̶�����:[�Ƿ���������]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		//31ǰ̨Ӫҵ������O��
		if (StringUtils.isNotEmpty(items[30-1-1])) {
			if (!CheckUtil.checkDouble(items[30-1-1], 8, 2)) {
				throw new Exception("[ǰ̨Ӫҵ������O��]�������ֲ��ܳ���8,С�����ֲ��ܳ���2λ��");
			}
		}
		
		//32�����ŶӽкŻ�
		if (StringUtils.isNotEmpty(items[31-1-1])){
			if (!check(items[31-1-1])){
				throw new Exception("�̶�����:[�����ŶӽкŻ�]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		//33����POS��
		if (StringUtils.isNotEmpty(items[32-1-1])){
			if (!check(items[32-1-1])){
				throw new Exception("�̶�����:[����POS��]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		//34����24Сʱ����Ӫҵ��
		if (StringUtils.isNotEmpty(items[33-1-1])){
			if (!check(items[33-1-1])){
				throw new Exception("�̶�����:[����24Сʱ����Ӫҵ��]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		//35����VIPרϯ
		if (StringUtils.isNotEmpty(items[34-1-1])){
			if (!check(items[34-1-1])){
				throw new Exception("�̶�����:[����VIPרϯ]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		
		//36����VIP��
		if (StringUtils.isNotEmpty(items[35-1-1])){
			if (!check(items[35-1-1])){
				throw new Exception("�̶�����:[����VIP��]��ֵ��ϵͳ�в����ڡ�");
			}
		}
		//37G3���������
		if (StringUtils.isNotEmpty(items[36-1-1])) {
			if (!CheckUtil.checkDouble(items[36-1-1], 14, 2)) {
				throw new Exception("[G3���������]�������ֲ��ܳ���14,С�����ֲ��ܳ���2λ��");
			}
		}
		//38ί�з���˾����
		if(StringUtils.isEmpty(items[37-1-1])){
			throw new Exception("ί�з���˾���Ʋ���Ϊ�ա�");
		}
		//39����ע���
		if(StringUtils.isEmpty(items[38-1-1])){
			throw new Exception("����ע��Ų���Ϊ�ա�");
		}
		//40���˴���
		if(StringUtils.isEmpty(items[39-1-1])){
			throw new Exception("���˴�����Ϊ�ա�");
		}
		//41���֤����
		if(StringUtils.isNotEmpty(items[40-1-1])){
			if(items[40-1-1].length()!=18){
				throw new Exception("���֤����ֻ����18λ��");
			}
		}
		
		
		//42ǩԼ���
		if(StringUtils.isEmpty(items[41-1-1])){
			throw new Exception("ǩԼ��Ų���Ϊ�ա�");
		}
		//43Э��ǩ����Чʱ��
		if(StringUtils.isEmpty(items[42-1-1])){
			throw new Exception("Э��ǩ����Чʱ�䲻��Ϊ�ա�");
		}
		
		try{			
			Date.valueOf(items[42-1-1]);
		}catch(Exception e){
			throw new Exception("Э��ǩ����Чʱ���ʽ����ȷ��");
		}
		
		
		//44Э���ֹʱ��
		if(StringUtils.isEmpty(items[43-1-1])){
			throw new Exception("Э�����ʱ�䲻��Ϊ�ա�");
		}
		try{			
			Date.valueOf(items[43-1-1]);
		}catch(Exception e){
			throw new Exception("Э�����ʱ���ʽ����ȷ��");
		}
		//45�����˵绰
		if(StringUtils.isEmpty(items[44-1-1])){
			throw new Exception("�����˵绰����Ϊ�ա�");
		}
		//46Э������
		if(StringUtils.isEmpty(items[45-1-1])){
			throw new Exception("Э�����Ʋ���Ϊ�ա�");
		}
		//47ǩԼʱ��
		if(StringUtils.isEmpty(items[46-1-1])){
			throw new Exception("ǩԼʱ�䲻��Ϊ�ա�");
		}
		try{			
			Date.valueOf(items[46-1-1]);
		}catch(Exception e){
			throw new Exception("ǩԼʱ���ʽ����ȷ��");
		}

		// ������������ж�
		WayVO wayVO = null;
//		WayDelegate wdelegate = new WayDelegate();
		Way wdelegate=(Way)BOFactory.build(WayBO.class, user);
		wayVO = wdelegate.doFindByPk(items[2].trim());
		if (wayVO == null) {
			throw new Exception("������:"+ items[2] +" ��ϵͳ�в����ڡ�");
		}
	}
	
	private String getDictName(String groupid,String code,User user) throws Exception{
//		CommonDelegate dictitemDelegate = new CommonDelegate(DictitemVO.class);
		DictitemBO dictitemDelegate=(DictitemBO)BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();
		vo.setGroupid(groupid);
		vo.setDictid(code);
		vo = (DictitemVO) dictitemDelegate.doFindByPk(vo);
		 return vo == null?code:vo.getDictname();
	}
	
	private boolean check(String code) throws Exception{
		if ("0".equals(code) || "1".equals(code)) {
			return true;
		} else {
			return false;
		}
	}
	
	private static final List<String> list=new ArrayList<String>();
	static{
		list.add("GZ");
		list.add("SZ");
		list.add("ZH");
		list.add("FS");
		list.add("ST");
		list.add("HZ");
		list.add("ZJ");
		list.add("JM");
		list.add("ZQ");
		list.add("SG");
		list.add("MZ");
		list.add("DG");
		list.add("ZS");
		list.add("MM");
		list.add("SW");
		list.add("CZ");
		list.add("JY");
		list.add("YJ");
		list.add("QY");
		list.add("HY");
		list.add("YF");
	}
	
	private boolean isCityid(String cityid){
		
		return list.contains(cityid);
		
	}
	
}
