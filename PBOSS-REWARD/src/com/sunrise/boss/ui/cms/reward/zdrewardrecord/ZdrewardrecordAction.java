/**
* auto-generated code
* Thu Jun 06 20:14:18 CST 2013
*/
package com.sunrise.boss.ui.cms.reward.zdrewardrecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfListVO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordListVO;
import com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent.ZdrewardrecordVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.chadtdictparam.ChAdtDictparamDelegate;
import com.sunrise.boss.delegate.cms.reward.rewardconf.RewardconfDelegate;
import com.sunrise.boss.delegate.cms.reward.zdrewardrecord.ZdrewardrecordDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.commons.taglib.code2name.Node;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>Title: ZdrewardrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ZdrewardrecordAction extends BaseAction {
    public ZdrewardrecordAction() {
            setVoClass(ZdrewardrecordVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }

	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZdrewardrecordForm zdrewardrecordForm = (ZdrewardrecordForm) actionForm;
		setTypeList(zdrewardrecordForm, request);
		
		if (!zdrewardrecordForm.isQuery()) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
			zdrewardrecordForm.set_se_calcmonth(format.format(this.getDefaultDate(-1)));
			zdrewardrecordForm.set_ne_noncyc(null);
			return actionMapping.findForward("list");
		}
		
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ǰ�����³��δ����ȷ�ϻ��ʡ������ȷ�ϲ������ţ��ݲ��ܲ�ѯ(����)!");
			return actionMapping.findForward("list");
		}
		
		Page.setPageSize(request, (BaseActionForm) actionForm);
		ZdrewardrecordListVO listVO = new ZdrewardrecordListVO();
		setListVO(listVO, actionForm);
		ZdrewardrecordDelegate delegate = new ZdrewardrecordDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return actionMapping.findForward("list");
	}

	@Override
	protected ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		export.setFileName("�ն˳������ѯ");
		export.addOutputProperty("seq");
		export.addOutputProperty("calcmonth");
		export.addOutputProperty("opnid");
		export.addOutputProperty("name");
		export.addOutputProperty("wayid");
		export.addOutputProperty("wayname");
		export.addOutputProperty("oprcode");
		export.addOutputProperty("mobile");
		export.addOutputProperty("oprtime", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("runtime", CommonExportBean.DATE, "yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("ruleid");
		export.addOutputProperty("resultflag");
		export.addOutputProperty("adtflag");
		export.addOutputProperty("adtcode");
		export.addOutputProperty("adtremark");
		export.addOutputProperty("rewardtype");
		export.addOutputProperty("rewardflag");
		export.addOutputProperty("repairmonth");
		export.addOutputProperty("batchno");
		export.addOutputProperty("bakinfo");
		export.addOutputProperty("bakinfo2");
		export.addOutputProperty("bakinfo2", CommonExportBean.CODE2NAME, "#IM_PR_COM");
		export.addOutputProperty("bakinfo3");
		export.addOutputProperty("wrapfee");
		export.addOutputProperty("noncyc");
		export.addOutputProperty("totalsum");
		export.addOutputProperty("paysum");
		export.addOutputProperty("paymoney1");
		export.addOutputProperty("assegrade2");
		export.addOutputProperty("prodid");
		export.addOutputProperty("bakinfo4");
		export.addOutputProperty("bakinfo5");
		export.addOutputProperty("bakinfo6",CommonExportBean.CODE2NAME, "$ZD_SYSTEM"); 
		export.addOutputProperty("bakinfo7");
		export.addOutputProperty("bakinfo8");
		export.addOutputProperty("bakinfo9");
		export.addOutputProperty("bakinfo10" ,CommonExportBean.CODE2NAME, "$ZD_TYPE");
		
		export.voClassArray = new Class[] { ZdrewardrecordVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] { "��ˮ��",
				"�����·�", "ȫʡҵ�����", "ҵ������", "��������", "��������", "ҵ��������", "ҵ��������",
				"ҵ����ʱ��", "У��ʱ��", "У��������", "�ɹ�ʧ�ܽ����ʶ", "���˽����ʶ", "У��������",
				"У��������", "�������", "�����ʶ", "�����·�", "���κ�", "IMEI", "��ƷID", "��Ʒ����",
				"��ƷЭ���", "��ŵ����", "�������", "Ӧ�����", "������", "ʵ�����","����ϵ��2","��ƷID","��׼��",
				"������","�ն���ʽ","����","ARPUֵ","���ʿͻ�","�ն�����"});
		super.ExportQuery(actionMapping, actionForm, request, response, user, export);
		return actionMapping.findForward(null);
	}
	
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		if(!this.doCheckRewardMonth(actionMapping, actionForm, request, response, user)){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ǰ�����³��δ����ȷ�ϻ��ʡ������ȷ�ϲ������ţ��ݲ��ܲ�ѯ(����)!");
			return actionMapping.findForward("list");
		}
		
		String filename = null;
		try {
			String chCityid = SessionFactoryRouter.conversionCityid(user.getCityid());
			if (chCityid == null || "".equals(chCityid)) {
				throw new Exception("�ù��Ų������κε��У�");
			}
			filename = getFilePath(actionForm, user, request);
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("�ļ�·��Ϊ�գ�");
			}
			FtpInfo ftpInfo =null;
			ftpInfo = ResPubUtil.getFtpInfo(user);
			
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("�������ļ������ڣ�����ʧ�ܣ�" + ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename.trim()));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		return actionMapping.findForward("down");
	}
	
	private String getFilePath(ActionForm actionForm, User user,
			HttpServletRequest request) throws Exception {
		StringBuffer filepath = new StringBuffer("");
		ZdrewardrecordForm form = (ZdrewardrecordForm) actionForm;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		String month = form.get_se_calcmonth() == null ? format.format(calendar.getTime()) : form.get_se_calcmonth();
		String chCityid = SessionFactoryRouter.conversionCityid(user.getCityid());

		ChAdtDictparamDelegate chAdtdictparamDelegate = new ChAdtDictparamDelegate();
		ChAdtDictparamListVO listvo = new ChAdtDictparamListVO();
		listvo.set_se_dkey("filebasepath");
		DataPackage dp = chAdtdictparamDelegate.doQuery(listvo, user);
		if (dp.getRowCount() == 0) {
			throw new Exception("������·��ϵͳ���������ڣ���˶ԣ�");
		}
		String path = ((ChAdtDictparamVO) ((List) dp.getDatas()).get(0)).getDvalue();
		filepath.append(path);

		filepath.append("/adt/");
		filepath.append(chCityid.toLowerCase()).append("/");
		filepath.append("src/collect/boss/onekey/onekey_");
		filepath.append(chCityid.toLowerCase()).append("_");
		filepath.append(month);
		filepath.append(".gz");
		return filepath.toString();
	}
	
	private void setTypeList(ZdrewardrecordForm zdrewardrecordForm, HttpServletRequest request) {
		LinkedList<Node> zdrewardList = new LinkedList<Node>();
		Node allzd = new Node();
		allzd.setCode("allzd");
		allzd.setName(" ");
		zdrewardList.add(allzd);
		Node hyzd = new Node();
		hyzd.setCode("hyzd");
		hyzd.setName("��Լ�ն�");
		zdrewardList.add(hyzd);
		Node lhyzd = new Node();
		lhyzd.setCode("lhyzd");
		lhyzd.setName("���Լ�ն�");
		zdrewardList.add(lhyzd);
		Node ljzd = new Node();
		ljzd.setCode("ljzd");
		ljzd.setName("����ն�");
		zdrewardList.add(ljzd);
		Node lptzd = new Node();
		lptzd.setCode("lptzd");
		lptzd.setName("��ƽ̨�ն�");
		zdrewardList.add(lptzd);
		//2014-06-09 a-biao add
		Node newzd = new Node();
		newzd.setCode("newzd");
		newzd.setName("2014�����ն˳��");
		zdrewardList.add(newzd);
		
		Node zdyzq = new Node();
		zdyzq.setCode("zdyzq");
		zdyzq.setName("�ն�������������Ԥ�����");
		zdrewardList.add(zdyzq);
		
		Node jdljarpu = new Node();
		jdljarpu.setCode("jdljarpu");
		jdljarpu.setName("�����̳�����ն�ARPU�ֳɳ��");
		zdrewardList.add(jdljarpu);
		
		Node jdljstd = new Node();
		jdljstd.setCode("jdljstd");
		jdljstd.setName("�����̳�����ն˻�׼�۷ֳɳ��");
		zdrewardList.add(jdljstd);
		
		Node g3timefisrt = new Node();
		g3timefisrt.setCode("g3timefisrt");
		g3timefisrt.setName("3GTIMES�����ڳ��");
		zdrewardList.add(g3timefisrt);
		
		Node g3timearpu = new Node();
		g3timearpu.setCode("g3timearpu");
		g3timearpu.setName("3GTIMES��ARPU�ֳɳ��");
		zdrewardList.add(g3timearpu);
		
		Node g4timezh = new Node();
		g4timezh.setCode("g4timezh");
		g4timezh.setName("4GTIMES��ת�����");
		zdrewardList.add(g4timezh);
		
		Node g4timeph = new Node();
		g4timeph.setCode("g4timeph");
		g4timeph.setName("4GTIMES���ջݰ�����");
		zdrewardList.add(g4timeph);
		
		Node g4notimeph = new Node();
		g4notimeph.setCode("g4notimeph");
		g4notimeph.setName("4G��TIMES���ջݰ�����");
		zdrewardList.add(g4notimeph);
		
		Node g4notime3in1 = new Node();
		g4notime3in1.setCode("g4notime3in1");
		g4notime3in1.setName("4G��TIMES������һ�������");
		zdrewardList.add(g4notime3in1);
		
		//2015��2�� 	BR201501120007 ����2015���Ż����������ն˳���֪ͨ ��� a-biao
		//�ն�����:���ڻ�ת�����opnid like '04110501%'
		Node kuneijizhuanhua = new Node();
		kuneijizhuanhua.setCode("kuneijizhuanhua");
		kuneijizhuanhua.setName("���ڻ�ת�����");
		zdrewardList.add(kuneijizhuanhua);
		
		//���ڻ��ֳɳ��      opnid like '04110502%'
		Node kuneijifencheng = new Node();
		kuneijifencheng.setCode("kuneijifencheng");
		kuneijifencheng.setName("���ڻ��ֳɳ��");
		zdrewardList.add(kuneijifencheng);
		//	�Դ���ת�����      opnid like '04111501%'
		Node zidaijizhuanhua = new Node();
		zidaijizhuanhua.setCode("zidaijizhuanhua");
		zidaijizhuanhua.setName("�Դ���ת�����");
		zdrewardList.add(zidaijizhuanhua);
		//	�Դ����ֳɳ��      opnid like '04111502%'
		Node zidaijifencheng = new Node();
		zidaijifencheng.setCode("zidaijifencheng");
		zidaijifencheng.setName("�Դ����ֳɳ��");
		zdrewardList.add(zidaijifencheng);

		
		request.setAttribute("zdrewardList", zdrewardList);
		
		LinkedList<Node> noncycList = new LinkedList<Node>();
		Node jbqs0 = new Node();
		jbqs0.setCode("0");
		jbqs0.setName(" ");
		noncycList.add(jbqs0);
		Node jbqs1 = new Node();
		jbqs1.setCode("1");
		jbqs1.setName("һ��");
		noncycList.add(jbqs1);
		Node jbqs2 = new Node();
		jbqs2.setCode("2");
		jbqs2.setName("����");
		noncycList.add(jbqs2);
		Node jbqs3 = new Node();
		jbqs3.setCode("3");
		jbqs3.setName("����");
		noncycList.add(jbqs3);
		Node jbqs4 = new Node();
		jbqs4.setCode("4");
		jbqs4.setName("����");
		noncycList.add(jbqs4);
		Node jbqs5 = new Node();
		jbqs5.setCode("5");
		jbqs5.setName("����");
		noncycList.add(jbqs5);
		Node jbqs6 = new Node();
		jbqs6.setCode("6");
		jbqs6.setName("����");
		noncycList.add(jbqs6);
		Node jbqs7 = new Node();
		jbqs7.setCode("7");
		jbqs7.setName("����");
		noncycList.add(jbqs7);
		Node jbqs8 = new Node();
		jbqs8.setCode("8");
		jbqs8.setName("����");
		noncycList.add(jbqs8);
		Node jbqs9 = new Node();
		jbqs9.setCode("9");
		jbqs9.setName("����");
		noncycList.add(jbqs9);
		Node jbqs10 = new Node();
		jbqs10.setCode("10");
		jbqs10.setName("ʮ��");
		noncycList.add(jbqs10);
		Node jbqs11 = new Node();
		jbqs11.setCode("11");
		jbqs11.setName("ʮһ��");
		noncycList.add(jbqs11);
		Node jbqs12 = new Node();
		jbqs12.setCode("12");
		jbqs12.setName("ʮ����");
		noncycList.add(jbqs12);		
		request.setAttribute("noncycList", noncycList);
		
//		if (zdrewardrecordForm.get_se_zdreward() == null
//				|| "".equals(zdrewardrecordForm.get_se_zdreward())
//				|| "hyzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("����ҵ��������");
//			noncycList.add(jbcj);
//			Node jlcj = new Node();
//			jlcj.setCode("2");
//			jlcj.setName("����ҵ�������");
//			noncycList.add(jlcj);
//			request.setAttribute("noncycList", noncycList);
//		} else if ("lhyzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node yqcj = new Node();
//			yqcj.setCode("1");
//			yqcj.setName("����ҵ��һ�ڳ��");
//			noncycList.add(yqcj);
//			Node eqcj = new Node();
//			eqcj.setCode("2");
//			eqcj.setName("����ҵ����ڳ��");
//			noncycList.add(eqcj);
//			Node sqcj = new Node();
//			sqcj.setCode("3");
//			sqcj.setName("����ҵ�����ڳ��");
//			noncycList.add(sqcj);
//			request.setAttribute("noncycList", noncycList);
//		} else if ("ljzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("����ҵ��������");
//			noncycList.add(jbcj);
//			Node khcj = new Node();
//			khcj.setCode("2");
//			khcj.setName("����ҵ�񿼺˳��");
//			noncycList.add(khcj);
//			request.setAttribute("noncycList", noncycList);
//		} else if ("lptzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("����ҵ��������");
//			noncycList.add(jbcj);
//			Node khcj = new Node();
//			khcj.setCode("2");
//			khcj.setName("����ҵ�񿼺˳��");
//			noncycList.add(khcj);
//			request.setAttribute("noncycList", noncycList);
//		}else if (zdrewardrecordForm.get_se_zdreward() == null
//				|| "".equals(zdrewardrecordForm.get_se_zdreward())
//				|| "newzd".equals(zdrewardrecordForm.get_se_zdreward())) {
//			//2014-06-09 a-biao add
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("T��T+1��T+2һ�ڳ��");
//			noncycList.add(jbcj);
//			Node jlcj = new Node();
//			jlcj.setCode("2");
//			jlcj.setName("T+2���ʿͻ�Ԥ�����ڳ��");
//			noncycList.add(jlcj);
//			Node t3eqcj = new Node();
//			t3eqcj.setCode("3");
//			t3eqcj.setName("T+3���ڳ��");
//			noncycList.add(t3eqcj);
//			Node t3djz = new Node();
//			t3djz.setCode("4");
//			t3djz.setName("T+3�ͼ�ֵ�۷����");
//			noncycList.add(t3djz);
//			Node t4ivr = new Node();
//			t4ivr.setCode("5");
//			t4ivr.setName("T+4IVR����������");
//			noncycList.add(t4ivr);
//			request.setAttribute("noncycList", noncycList);
//		}else if (zdrewardrecordForm.get_se_zdreward() == null
//				|| "".equals(zdrewardrecordForm.get_se_zdreward())
//				|| "zdyzq".equals(zdrewardrecordForm.get_se_zdreward())) {
//			//2014-06-09 a-biao add
//			//��Ӧ����������������أ�NONCYCĬ��Ϊ1
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName(" ");
//			noncycList.add(jbcj);
//			request.setAttribute("noncycList", noncycList);
//		}else if (zdrewardrecordForm.get_se_zdreward() == null
//				|| "".equals(zdrewardrecordForm.get_se_zdreward())
//				|| "jdlj".equals(zdrewardrecordForm.get_se_zdreward())) {
//			//2014-06-09 a-biao add
//			LinkedList<Node> noncycList = new LinkedList<Node>();
//			Node jbcj = new Node();
//			jbcj.setCode("1");
//			jbcj.setName("ARPU�ֳɳ��");
//			noncycList.add(jbcj);
//			Node jlcj = new Node();
//			jlcj.setCode("2");
//			jlcj.setName("��׼�۷ֳɳ��");
//			noncycList.add(jlcj);
//			request.setAttribute("noncycList", noncycList);
//		}
	}
	
	public boolean doCheckRewardMonth(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ZdrewardrecordForm form = (ZdrewardrecordForm) actionForm;
		
		RewardconfListVO listvo = new RewardconfListVO();
		listvo.set_se_rewardkind("AG");
		listvo.set_se_rewardmonth(form.get_se_calcmonth().trim());
		listvo.set_se_cityid(user.getCityid());
		listvo.set_se_state("1");
		listvo.set_pagesize("0");
		RewardconfDelegate confdelegate = new RewardconfDelegate();
		DataPackage dp  = confdelegate.doQuery(listvo, user);
		if(dp != null && dp.getDatas().size() != 0){
			return true;
		}
		
		ProvincialrightVO rightvo = new ProvincialrightVO();
		rightvo.setProopr(user.getOpercode());
		rightvo.setRightid("CH_PW_REWARDCONF");
		CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
		rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
		if(rightvo == null){
			return false;
		}else{
			return true;
		}
	}
	
	// ����Ĭ�����ڷ���,����Ϊ�Ӻ�i����,����Ϊ��ǰi����
	private Date getDefaultDate(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, i);
		return c.getTime();
	}
}
