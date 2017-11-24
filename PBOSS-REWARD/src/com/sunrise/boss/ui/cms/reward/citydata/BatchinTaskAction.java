package com.sunrise.boss.ui.cms.reward.citydata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.resmanage.filedef.persistent.FiledefVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemListVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemVO;
import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.business.resmanage.taskfile.persistent.TaskfileVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.resmanage.filedef.FiledefDelegate;
import com.sunrise.boss.delegate.resmanage.fileitem.FileitemDelegate;
import com.sunrise.boss.delegate.resmanage.task.TaskDelegate;
import com.sunrise.boss.delegate.resmanage.taskfile.TaskfileDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.boss.ui.resmanage.common.ResUploadFileAction;

/**
 * <p>
 * Title: CitydataAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Zhang Fengchao
 * @version 1.0
 */
public class BatchinTaskAction extends ResUploadFileAction {
	private String selectitem="";

	protected void setFilecode(HashMap map, User user) {
		if("ARPUDATA".equals((String) map.get("citydatatype"))){
		this.filecode = "ARPUDATA_9_0"; // Ψһ����
		}else{
		this.filecode = "CITYDATA_0_0";	
		}
	}

	public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BatchCitydataForm actionform=(BatchCitydataForm)form;
		if("ARPUDATA".equals(actionform.getCitydatatype())){
		for(int i=0;i<actionform.get_selectitem().length;i++){
			if(i==0) selectitem=actionform.get_selectitem()[i];
			else selectitem=selectitem+","+actionform.get_selectitem()[i];
		}
		}
		String cmd=request.getParameter("CMD");
		if(StringUtils.isNotEmpty(cmd)){
			String methodName = "do"
				+ cmd.substring(0, 1).toUpperCase()
				+ cmd.substring(1, cmd.length()).toLowerCase();
			Method method=this.getClass().getMethod(methodName, new Class[]{ActionMapping.class,ActionForm.class,HttpServletRequest.class,HttpServletResponse.class});
			if(method!=null){
				Object[] args = { actionMapping, form, request, response};
				Object result=method.invoke(this, args);
				return (ActionForward)result;
			}
		}
		queryDictid(request);
		return super.execute(actionMapping, form, request, response);
	}

	protected List getParamList(HashMap map, User user) throws Exception {
		List list = new ArrayList();
		if(StringUtils.isNotEmpty(selectitem)){
			addParam(list, "rewardtypestr", selectitem);
		}
		String infectionbuss=(String) map.get("infectionbuss");
		String citydatatype=(String) map.get("citydatatype");
		if(citydatatype.equals("ARPUDATA")){
			if(StringUtils.isNotEmpty(infectionbuss)){
				if(infectionbuss.endsWith(";")){
				StringBuffer opninstr=new StringBuffer("");
					String[] opninArray=infectionbuss.split("\\;");
					for(int i=0;i<opninArray.length;i++){
						if(i==(opninArray.length-1)){
						opninstr.append(opninArray[i].substring(0,opninArray[i].indexOf("-")));
						continue;
						}
						opninstr.append(opninArray[i].substring(0,opninArray[i].indexOf("-"))+",");
					}
					addParam(list, "OPNIDSTR",opninstr.toString());
				}
			}
		}
		
		addParam(list, "remark", (String) map.get("remark"));
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

		String memo = (String) map.get("remark");

		TaskVO task = new TaskVO();
		task.setFilecode(filecode);
		task.setSubsystem("CH");
		task.setTaskstate(new Integer(3));// ����ʼ������δ����
		task.setCreatetime(new Date(System.currentTimeMillis()));
		task.setOprcode(user.getOpercode());
		task.setWayid(user.getWayid());
		task.setExectime(new Date(System.currentTimeMillis()));
		task.setTaskfilecount(new Short("1"));// ��ʱ��һ���ļ�
		task.setTotalcount(new Integer(count));
		task.setMemo(memo);

		TaskDelegate taskDelegate = new TaskDelegate();
		TaskVO taskVO = taskDelegate.doRecordTask(task, list, user);

		// �Ǽ������ļ�
		TaskfileDelegate taskfileDelegate = new TaskfileDelegate();
		TaskfileVO taskfile = new TaskfileVO();
		taskfile.setTaskid(taskVO.getTaskid());
		taskfile.setFileline(new Integer(count));
		taskfile.setTaskfile(filename);
		taskfile.setUploadtime(new Date(System.currentTimeMillis()));
		taskfileDelegate.doCreate(taskfile, user);

		taskVO.setTaskstate(new Integer(0));// ����״̬Ϊ������
		taskDelegate.doUpdate(taskVO, user);

		return "�ѵǼ�������������������<a href='resmanage/task.do?CMD=LIST&_se_taskid="+taskVO.getTaskid()+"'>"
				+ taskVO.getTaskid()
				+ "</a><font color='red'>(��������ſɽ��в�ѯ���������)</font>����̨���򽫽��д�������ص�����Դ����������Դ��־��ѯ�����������ļ����������ѯ�����в�ѯ����������ȷ���Ƿ���������ļ����費��Ҫ���µ��롣";
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

		FileitemDelegate fiDelegeate = new FileitemDelegate();
		FileitemListVO fiListVO = new FileitemListVO();
		fiListVO.set_pagesize("0");
		fiListVO.set_se_filecode(getFilecode());
		fiListVO.set_orderby("itemid");
		DataPackage fidp = fiDelegeate.doQuery(fiListVO, user, false);
		if (fidp.getDatas().size() < 1) {
			throw new Exception("�ļ�����" + getFilecode() + "û�ж����ļ����������ϵ����Ա��");
		}

		FiledefDelegate fdefDelegate = new FiledefDelegate();
		FiledefVO fdVo = fdefDelegate.doFindByPk(this.filecode, user);
		int maxLine = 100000;
		if (fdVo != null) {
			maxLine = fdVo.getLinelimit().intValue();
		} else {
			throw new Exception("�ļ�����" + getFilecode() + "�޶��壬����ϵ����Ա��");
		}

		FileInputStream fileInputStream = new FileInputStream(filename);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		int row = 0;// ��¼��ǰ��鵽������

		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++row;
					if (row > maxLine) {
						throw new Exception("�ļ�ʵ�����������ļ���������������");
					}
					Iterator iter = fidp.getDatas().iterator();
					String[] items = StringUtils.split(line,
							splitFlag);
					if (items.length != fidp.getDatas().size()) {
						throw new Exception("�ϴ�������������,��" + row + "������ӦΪ"
								+ fidp.getDatas().size() + "��,��鿴˵������!");
					}
					int col = 0;
					while (iter.hasNext()) {
						FileitemVO fileitem = (FileitemVO) iter.next();
						checkItem(row, items[col], fileitem);
						col++;
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
	
	public ActionForward doQuerydict(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		queryDictid(request);
		BatchCitydataForm form =(BatchCitydataForm) actionForm;
		if(null == form.getCitydatatype()){
			form.setCitydatatype("BUSIVALIDDATA");
		}
		return actionMapping.findForward("success");
	}

	private void queryDictid(HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("CH_REWARDTYPE");
		List nindictid = new ArrayList();
		//nindictid.add("4");
		//nindictid.add("6");
		nindictid.add("7");
		nindictid.add("8");
		listVO.set_snin_dictid(nindictid);
		listVO.set_orderby("dictid");
		DictitemDelegate delegate = new DictitemDelegate();
		List list = (List) delegate.doQuery(listVO, user).getDatas();
		request.setAttribute("LIST", list);
	}
}
