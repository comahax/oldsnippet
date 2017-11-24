package com.sunrise.boss.ui.cms.reward.adtrewardupload;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.adtrewardupload.AdtRewarduploadDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;
import com.sunrise.boss.ui.resmanage.common.ResUploadFileAction;
import com.sunrise.pub.tools.PublicUtils;

public class BatchinTaskAction extends ResUploadFileAction {
	protected void setFilecode(HashMap map, User user) {
//		this.filecode = "RESALE_0_0"; // Ψһ����
		this.filecode = "";
	}
	
	/**
	 * ��д���෽��
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(CONTENT_TYPE);
		HttpSession session = request.getSession();
		User user = (User) session
				.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);

		if (user == null) {
			user = new User();
			user.setOpercode("test");
			user.setWayid("test");
		}

		try {
			AdtRewarduploadbatchForm adtrewarduploadbatchForm = (AdtRewarduploadbatchForm) form; 
			if (adtrewarduploadbatchForm.getMobile().trim().length() != 11) {
				throw new Exception("���Ž��պ�������ұ���Ϊ11λ�ֻ�����.");
			}
			UploadFileForm fileForm = (UploadFileForm) form;
			FormFile file = fileForm.getTheFile();
			HashMap map = getParamMapFromRequest(request, user);

			setFilecode(map, user);

			String filename = getFile(file, user);
			int count = checkFile(file, filename, fileForm.getCheckFormat(), map, user);
			filename = ftpFile(filename, user);
			String filecode = processFile(filename, count, map, user);

			file.destroy();
			
			//�������(taskid)����C++������.FileIntoDB
			//Runtime.getRuntime().exec("FileIntoDB("+ filecode +")");
			
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"�ļ����ϴ��ɹ������յ�����֪ͨ����������:<font color=red>"+filecode+"</font>��ʱ��ѯ������.");
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			return actionMapping.findForward("error");
		}
	}

	protected List getParamList(HashMap map, User user) throws Exception {
		List list = new ArrayList();
		//addParam(list, "remark", (String) map.get("remark"));
		addParam(list, "cityid", SessionFactoryRouter.conversionCityid(user
				.getCityid()));
		addParam(list, "oprcode", user.getOpercode());
		SimpleDateFormat fs = new SimpleDateFormat("yyyyMMddHHmmss");
		addParam(list, "batchno", user.getCityid() + fs.format(new Date()));
		return list;
	}
	
	/**
	 * 
	 * @param filename
	 * @param count
	 * @param map
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected String processFile(String filename, int count, HashMap map,
			User user) throws Exception {

		String filecode = getFilecode();
		List list = getParamList(map, user);

		String mobile = (String) map.get("mobile");

		//��CH_ADT_REWARDUPLOAD���в���������¼: 
		//TASKID:CH_ADT_REWARDUPLOAD_SEQ�Զ�����
		//UPLOADFILE:�ϴ��ļ������·��
		//TASKSTATE:2������
		//OPRCODE:����Ա����
		//UPLOADTIME:ϵͳ��ǰʱ��
		//TOTALCOUNT:�ļ��ܼ�¼��
		//MOBILE:ǰ̨¼��ġ�����֪ͨ�ֻ����롯
		AdtRewarduploadVO adtrewarduploadVO = new AdtRewarduploadVO();
		adtrewarduploadVO.setUploadfile(filename);
		adtrewarduploadVO.setTaskstate(new Byte("2"));
		adtrewarduploadVO.setOprcode(user.getOpercode());
		adtrewarduploadVO.setUploadtime(new Date());
		//adtrewarduploadVO.setTotalcount(count);
		adtrewarduploadVO.setMobile(mobile);
		new AdtRewarduploadDelegate().doCreate(adtrewarduploadVO, user);

		return adtrewarduploadVO.getTaskid().toString();
	}
	
	/**
	 * ����ļ���ʽ���������ļ�������
	 * 
	 * @param filename
	 * @param iCheckFormat
	 * @param user
	 * @return
	 * @throws Exception
	 */
	protected int checkFile(FormFile file, String filename,
			ICheckFormat iCheckFormat, HashMap map, User user) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
		if(file.getFileSize()<=0 && file.getFileData().length<=0)
		{
			throw new Exception("�ϴ����ļ����ݲ���Ϊ��!");
		}
		
//		SELECT ParamValue FROM IB_GL_SysParam WHERE SystemId='74' AND ParamType='channel';
		SysparamDelegate sysparamDelegate = new SysparamDelegate();
		SysparamVO sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long("74"));
		sysparamVO.setParamtype("channel");
		sysparamVO = sysparamDelegate.doFindByPk(sysparamVO, user);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue())){
			throw new Exception("ϵͳ����<font color=red>[����ϴ��ļ���С����]</font>δ���ã���֪ͨ������Ա.");
		}
		//System.out.println(1024 * 1024 * Integer.parseInt(sysparamVO.getParamvalue()));
		//System.out.println("file.getFileSize(): "+file.getFileSize());
		if(file.getFileSize() > 1024 * 1024 * Integer.parseInt(sysparamVO.getParamvalue())){
			throw new Exception("���ϴ����ļ�����<font color=red>" + sysparamVO.getParamvalue() + "</font>M,���ֺ����ϴ�.");
		}
		
//		FileitemDelegate fiDelegeate = new FileitemDelegate();
//		FileitemListVO listVO = new FileitemListVO();
//		listVO.set_se_filecode(getFilecode());
//		DataPackage fidp = fiDelegeate.doQuery(listVO, user, false);
//		if (fidp.getDatas().size()<=0) {
//			throw new Exception("�ļ�����" + getFilecode() + "û�ж����ļ����������ϵ����Ա��");
//		}

//		FiledefDelegate fdefDelegate = new FiledefDelegate();
//		FiledefVO fdVo = fdefDelegate.doFindByPk(this.filecode, user);
//		int maxLine = 100000;
//		if (fdVo != null) {
//			maxLine = fdVo.getLinelimit().intValue();
//		} else {
//			throw new Exception("�ļ�����" + getFilecode() + "�޶��壬����ϵ����Ա��");
//		}

		FileInputStream fileInputStream = new FileInputStream(filename);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int row = 0;// ��¼��ǰ��鵽������

		try {
			while ((line = rin.readLine()) != null && row < 21 ) {//���Ӳ��ٱ��������ļ�
				if (line.trim().length() > 0) {
					++row;
//					if (row > maxLine) {
//						throw new Exception("�ļ�ʵ�����������ļ���������������");
//					}
//					Iterator iter = fidp.getDatas().iterator();
//					String[] items = StringUtils.splitPreserveAllTokens(line, splitFlag);
//					if (items.length != fidp.getDatas().size()) {
//						throw new Exception("�ϴ�������������,��" + row + "������ӦΪ"
//								+ fidp.getDatas().size() + "��,��鿴˵������!");
//					}
//					int col = 0;
//					while (iter.hasNext()) {
//						FileitemVO fileitem = (FileitemVO) iter.next();
//						checkItem(row, items[col], fileitem);
//						col++;
//					}
					//���ǰ20��
					if(row < 21){
						String[] items = StringUtils.splitPreserveAllTokens(line, splitFlag);
						if (items.length != 9) {
							throw new Exception("�ϴ�������������,��" + row + "������ӦΪ8��,��鿴˵������!");
						}else{
							for(int col = 0; col < 8; col++){
								checkItem2(row, col, items[col].trim(), user);
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			rin.close();
			read.close();
			fileInputStream.close();
		}
		return row;
	}
	
	// ���������
	protected void checkItem2(int row, int col, String item, User user)
			throws Exception {
		switch (col) {
		case 0://��������:����ΪCOMS�еǼǵ���Ч�����������(WAYTYPE='AG' AND WAYSUBTYPE<>��ZJTY�� AND WAYSTATE=1)������̱���(WAYTYPE='AG' AND WAYSUBTYPE<>��DIS�� AND WAYSTATE=1).
			if(StringUtils.isEmpty(item)){
				throw new Exception("��" + row + "�и�ʽ�д��������벻��Ϊ��");
			}
			//1.SELECT WAYID FROM CH_PW_WAY WHERE WAYTYPE = 'AG' AND WAYSUBTYPE <> 'ZJTY' AND WAYSTATE=1
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO1 = new WayListVO();
			wayListVO1.set_se_wayid(item);
			//wayListVO1.set_ne_waystate(Short.valueOf("1"));
			wayListVO1.set_se_waytype("AG");
			wayListVO1.set_sne_waysubtype("ZJTY");
			DataPackage waydp1 = waydelegate.doQuery(wayListVO1, user);
			if(waydp1.getRowCount()==0){
				throw new Exception("��" + row + "�и�ʽ�д���������[" + item + "]������");
			}
			break;
		case 1://ҵ�����:����ΪCOMS�еǼǵ���Чҵ�����(select opnid from ch_pw_operation).
			if(StringUtils.isEmpty(item)){
				throw new Exception("��" + row + "�и�ʽ�д�ҵ����벻��Ϊ��");
			}
			//SELECT OPNID FROM CH_PW_OPERATION
			OperationDelegate odel = new OperationDelegate();
			if(null == odel.doFindByPk(item, user)){
				throw new Exception("��" + row + "�и�ʽ�д�ҵ�����[" + item + "]������");
			}
			break;
		case 2://�������:����Ϊ1,2,3���κ�һλ����
			if(StringUtils.isEmpty(item)){
				throw new Exception("��" + row + "�и�ʽ�д������������Ϊ��");
			}
			Set<String> rewardtypeset = new HashSet<String>();//�ǼƼ�ҵ�񼯺�
			rewardtypeset.add("1");
			rewardtypeset.add("2");
			rewardtypeset.add("3");
			if(!rewardtypeset.contains(item)){
				throw new Exception("��" + row + "�и�ʽ�д������������Ϊ1,2,3���κ�һλ����");
			}
			break;		
		case 3://�ֻ�����ֵ�������IMEI��:�����ֵ����С�ڵ���17λ����.
			if(!StringUtils.isEmpty(item)){
				if(item.length() > 17){
					throw new Exception("��" + row + "�и�ʽ�д��ֻ�����ֵ�������IMEI�ű���С�ڵ���17λ����");
				}
				for (int i = 0; i < item.length(); i++) {
					if (item.charAt(i) < '0' || item.charAt(i) > '9') {
						throw new Exception("��" + row + "�и�ʽ�д��ֻ�����ֵ�������IMEI��[" + item + "]Ӧ��Ϊ�����ַ�����");
					}
				}
			}
			break;
		case 4://�����·�:6λ����YYYYMM,��:201201,����
			if(!CheckUtil.checkString(item, 6, true)){
				throw new Exception("��" + row + "�и�ʽ�д������·ݲ���Ϊ���ұ���Ϊ6λ����");
			}
			try{
				Date now = new Date();
				String nowstr = PublicUtils.formatUtilDate(now, "yyyyMM");
				if(new Long(item)>new Long(nowstr)){
					throw new Exception("��" + row + "�и�ʽ�д������·ݲ��ܴ��ڵ�ǰ�·�");
				}
			}catch (Exception e) {
				throw new Exception("��" + row + "�и�ʽ�д������·ݲ���ȷ");
			}
			break;
		case 5://ҵ����ʱ��: ʱ���ʽ: 2011-11-01 08:04:35
			if(StringUtils.isEmpty(item)){
				throw new Exception("��" + row + "�и�ʽ�д�ҵ����ʱ�䲻��Ϊ��");
			}
			try{
				Date date = PublicUtils.UtilStrToDate(item, "yyyy-MM-dd HH:mm:ss");
				Calendar ca = Calendar.getInstance(Locale.CHINA);//��ǰʱ��
				Calendar ca2 = Calendar.getInstance();
				ca2.setTime(date);
				if(ca2.after(ca)){
					throw new Exception("��" + row + "�и�ʽ�д�ҵ����ʱ�䲻�ܴ��ڵ�ǰϵͳʱ��");
				}
			}catch (Exception e) {
				throw new Exception("��" + row + "�и�ʽ�д�ҵ����ʱ�䲻��ȷ");
			}
			break;
		case 6://ҵ������ҵ�������:�����С�����ܳ���2λС��λ.����
			if(StringUtils.isEmpty(item)){
				throw new Exception("��" + row + "�и�ʽ�д�ҵ������ҵ��������Ϊ��");
			}
//			if(new Double(item) <= 0){
//				throw new Exception("��" + row + "�и�ʽ�д�ҵ������ҵ����������Ϊ����");
//			}
			if(!CheckUtil.checkDouble(item,10, 4)||((item.trim().indexOf(".") == -1 && item.trim().length() > 10))){
				throw new Exception("��" + row + "�и�ʽ�д�ҵ������ҵ��������������ֲ��ܳ���10λ,С�����ֲ��ܳ���4λ");
			}			
			break;
		case 7://Ӧ�����ϼ�: ����,���ֿ��Դ�С��.
			if(StringUtils.isEmpty(item)){
				throw new Exception("��" + row + "�и�ʽ�д�Ӧ�����ϼƲ���Ϊ��");
			}
			if(!CheckUtil.checkDouble(item,10, 4)||((item.trim().indexOf(".") == -1 && item.trim().length() > 10))){
				throw new Exception("��" + row + "�и�ʽ�д�Ӧ�����ϼ��������ֲ��ܳ���10λ,С�����ֲ��ܳ���4λ");
			}
			break;
		default:
			break;
		}
	}
	
}