package com.gmcc.pboss.web.sales.ordercreate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDBParam;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateDBParam;
import com.gmcc.pboss.business.sales.comorderstate.ComorderstateVO;
import com.gmcc.pboss.business.sales.wayassistant.WayassistantVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.resource.cityrescode.Cityrescode;
import com.gmcc.pboss.control.resource.cityrescode.CityrescodeBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comorder.ComorderCheck;
import com.gmcc.pboss.control.sales.comorder.ComorderCheckBO;
import com.gmcc.pboss.control.sales.comorderstate.Comorderstate;
import com.gmcc.pboss.control.sales.comorderstate.ComorderstateBO;
import com.gmcc.pboss.control.sales.wayassistant.Wayassistant;
import com.gmcc.pboss.control.sales.wayassistant.WayassistantBO;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class CreateBatchTaskBean extends BaseBatchTaskBean {
	
	private Map<String,String> codeAndComcateMap;// ��������Ӧ��ϵ����
	
	public CreateBatchTaskBean() throws Exception{
		// 
		super.setBatchName("��������");
		super.setOprtype("����");
	}
	protected String doStart() {
		return "���|�����̱���|������Դ����Ͷ�������|������\r\n";
	}
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO vo=new ResultVO();
		String[] content=new String[2];
		if(line.indexOf('|')>0){
			content=StringUtils.splitPreserveAllTokens(line,'|');
		}else{
			content[0]=line;
		}
		
		try {
			// ��������Ӧ��ϵ����
			if (codeAndComcateMap == null)
			codeAndComcateMap = this.getCodeAndComcateMap();
			
			// �����̼��
			Way way = (Way) BOFactory.build(WayBO.class,user);
			WayVO wayvo = way.doFindByPk(content[0]);
			if (wayvo == null) {
				throw new Exception("�����̻�����Ϣ������");
			} else if (!"AG".equals(wayvo.getWaytype())) {
				throw new Exception("�����̻�����Ϣ������");
			} else if (!user.getCityid().equals(wayvo.getCityid())) {
				throw new Exception("�����̻�����Ϣ������");
			}
			
			// ��鶩���ʸ�
			Wayassistant ass = (Wayassistant) BOFactory.build(WayassistantBO.class,user);
			WayassistantVO assvo = ass.doFindByPk(content[0]);
			if (assvo == null) {
				throw new Exception("����Ʒ����Ȩ��");
			} else if (assvo.getCanorder() == null || assvo.getCanorder() != 1) {
				throw new Exception("����Ʒ����Ȩ��");
			}			
			// ��¼�ɷѷ�ʽ��Ϣ
			String paytype = assvo.getPaytype();
			String delitype = assvo.getDelitype();
			wayvo.setPaytype(paytype);
			wayvo.setDelitype(delitype);
			
			// �����Դ���������
			List<ComorderVO> result = new ArrayList<ComorderVO>();
			if (content[1].contains("#")) {
				result = this.getcomsrc(content[1]);
			} else {
				result = this.getjmsrc(content[1]);
			}			
			
			// ��϶������
			if (!this.doCheckMixOrderEnable(result)) {
				throw new Exception("���ܶ��������Դ���Ķ���");
			}
			
			// ��������˺�
			if (paytype.equals(ComorderConstant.PAYTYPE_BANK)) {
				if (!this.doCheckBankInformation(content[0])) {
					throw new Exception("�����˺���Ϣ�����ڻ�����");
				}
			}
			
			// �¶����������
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			try {
				comorder.checkMonthBookTimes(content[0]);
			} catch (SaleException se) {
				if (se.getMonmaxtimes() != null) {
					throw new Exception("�����ѳɹ�����"+ se.getMontimes().toString() +"�Σ��ﵽ��󶩹����������ܼ�������");
				} else {
					throw se;
				}
			} catch (Exception ex) {
				throw ex;
			}
			
			// ��鶩��ʱ��
			try{
				ComorderCheck comorderCheckBO = (ComorderCheckBO)BOFactory.build(ComorderCheckBO.class,user);
				comorderCheckBO.checkLimitTime(wayvo);
			}catch(SaleException ex){
				if("SALE-104015".equals(ex.getErrorCode())){
					throw new Exception("���첻�ṩ��Ʒ��������");
				}else if("SALE-104003".equals(ex.getErrorCode())){
					throw new Exception("����ϵͳ����ʱ���");
				}
			}catch(Exception e){
				throw e;
			}
			
			// �����Ʒ����
			this.doCheckDataList(result, codeAndComcateMap, wayvo.getWayid());
			
			// ȷ��������Դ����
			String storarea = comorder.doGetStorArea(wayvo);

			// ��Ʒ�������
			Set<String> brandSet = comorder.comOrderCheck(wayvo.getWayid(), result, storarea);
			
			// ��ȡ�������
			String orderid = comorder.doGetOrderId();
			
			// ��������
			comorder.doBuildOrder(orderid, wayvo, storarea, result, brandSet,
					ComorderConstant.ORDERAVE_HALL, null);
			
			// ������һ������
			try {
				comorder.doNextProcess(orderid);
			} catch (Exception e) {
			}
			
			vo.setInfo(rowCount+"|"+content[0]+"|"+content[1]+"|"+"�����ɹ���������ţ�"+orderid);
			
			vo.setOk(true);
			return vo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vo.setInfo(rowCount+"|"+content[0]+"|"+content[1]+"|"+"������Ϣ:"+e.getMessage());
			vo.setOk(false);
			return vo;
		}		
	}
	
	/**
	 * �����Դ����(����)
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public List<ComorderVO> getjmsrc(String src) throws Exception {
		
		List<ComorderVO> result = new ArrayList<ComorderVO>();
		List lis = new ArrayList();
		String newflag = "y";
		String s = "";
		String n = "";
		String oldflag = "y";
		for(int i = 0; i<src.length(); i++) {
			char ss = src.charAt(i);
			
			String mm = ss + "";
			// ����ַ�����ĸ
			if (mm.matches("[a-zA-Z]{1}")) {
				s = s + mm;
				newflag = "s";
			//����ַ�������
			} else if (mm.matches("[0-9]{1}")) {
				n = n + mm;
				newflag = "n";
				// ��һ���ַ�Ϊ��ĸ��ʱ��
				if (i == 0) {
					throw new Exception("������Ϣ��ʽ����");
				}
			// ����ַ�������ĸ�����֣������ʽ����ȷ
			} else {
				throw new Exception("������Ϣ��ʽ����");
			}
			// ��ǰ�ַ������֣��ϸ��ַ�Ϊ��ĸ��ʱ��
			if ("n".equals(newflag) && "s".equals(oldflag)) {
				lis.add(s);
				s = "";
				// ��ǰ�ַ�Ϊ��ĸ���ϸ��ַ�Ϊ���ֵ�ʱ��
			} else if ("s".equals(newflag) && "n".equals(oldflag)) {
				lis.add(n);
				n = "";
			}
			oldflag = newflag;
		}
		// �����ַ�Ϊ��ĸ��ʱ��
		if (!"".equals(s)) {
			lis.add(s);
			
			// �����ַ�Ϊ���ֵ�ʱ��
		} else if (!"".equals(n)) {
			lis.add(n);
		}
		int k = lis.size();
		// �����õĶ��м�������Ϊż����ʱ�򣬵����ʽ����ȷ
		if (k%2 != 0) {
			throw new Exception("������Ϣ��ʽ����");
		} else {
			for (int i = 0; i < lis.size(); ) {
				ComorderVO vo = new ComorderVO();
				// ���������Ϊ����
				try {
					Long.parseLong(lis.get(i+1).toString());
				} catch (Exception e) {
					throw new Exception("������Ϣ��ʽ����");
				}
				if(codeAndComcateMap.containsKey(lis.get(i).toString()))
					vo.setComcategory(codeAndComcateMap.get(lis.get(i).toString()));
				else
					vo.setComcategory(lis.get(i).toString());
				vo.setOrderamount(Long.parseLong(lis.get(i+1).toString()));
				result.add(vo);
				i = i + 2;
			}
		}		
		return result;
	}
	
	/**
	 * �����Դ����(ͨ��)
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public List<ComorderVO> getcomsrc(String src) throws Exception {
		List<ComorderVO> result = new ArrayList<ComorderVO>();
		List lis = new ArrayList();
		// ��Ƕ��Ų��
		String[] items = src.split(",");
		for (int i = 0; i < items.length; i++) {
			// ȫ�Ƕ��Ų��
			String[] items1 = items[i].split("��");
			for (int k = 0; k < items1.length; k++) {
				// #�Ų��
				String[] items2 = items1[k].split("#");
				for (int j = 0; j < items2.length; j++) {
					lis.add(items2[j]);
				}
			}
		}
		
		// �Ѳ�ֵ����ݷ�װ
		int k = lis.size();
		if (k%2 != 0) {
			throw new Exception("������Ϣ��ʽ����");
		} else {
			for (int i = 0; i < lis.size(); ) {
				ComorderVO vo = new ComorderVO();
				// ���������Ϊ����
				try {
					Long.parseLong(lis.get(i+1).toString());
				} catch (Exception e) {
					throw new Exception("������Ϣ��ʽ����");
				}
				if(codeAndComcateMap.containsKey(lis.get(i).toString()))
					vo.setComcategory(codeAndComcateMap.get(lis.get(i).toString()));
				else
					vo.setComcategory(lis.get(i).toString());
				vo.setOrderamount(Long.parseLong(lis.get(i+1).toString()));
				result.add(vo);
				i = i + 2;
			}
		}		
		return result;
	}

	/**
	 * ����ϵͳ��������Ƿ������϶���,�������������أ����������鶩����Ʒ�Ƿ�ΪͬһƷ��
	 */
	public boolean doCheckMixOrderEnable(List<ComorderVO> ordreDataList) throws Exception {
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class,user);
		String paramvalue = sysparam.doFindByID("63", "pboss_fx");		
		boolean enable = true;
		boolean result = true;
		if(paramvalue!=null && !"".equals(paramvalue)){
			if("0".equals(paramvalue)){
				enable=false;
			}
		}
		if(!enable){//����������϶���
			//��ѯIM_PR_COMCATEGORYRELA����ȡ��Ʒ����-��Դ�����ϣ��ŵ�һ��Map��
			Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
			params.setSelectFieldsString("comcategory,restype");
			params.set_pagesize("0");
			params.setDataOnly(true);
			DataPackage dp = comcategoryrela.doLoadComCateAndResType(params);
			List comcateAndRestype = dp.getDatas();
			//key-comcategory��Ʒ����,value-restype��Դ����
			Map<String,String> cateAndRes = new HashMap<String,String>();
			if(comcateAndRestype.size()>0){
				for(Iterator it=comcateAndRestype.iterator();it.hasNext();){
					Map<String,String> temp = (Map<String,String>)it.next();					
					cateAndRes.put(temp.get("comcategory"), temp.get("restype"));
				}
			}
			
			//��Ʒ��Դ���ͱ�Ǳ���
			String tokenRestype = null;
			for(ComorderVO comvo: ordreDataList){
				if(tokenRestype==null){//�����һ����Ʒ��������Դ��𱣴�
					tokenRestype = cateAndRes.get(comvo.getComcategory());
					continue;
				}
				//����������Ʒ�������Դ����뱣�����Դ���ͬ������
				String restype = cateAndRes.get(comvo.getComcategory());
				if(!tokenRestype.equals(restype)){
					result = false;
				}
			}
		}		
		return result;
	}
	
	/**
	 * ��������˺�
	 * @param wayid
	 * @throws Exception
	 */
	public boolean doCheckBankInformation(String wayid) throws Exception{
		Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
		WayaccountDBParam param = new WayaccountDBParam();
		param.set_se_wayid(wayid);
		DataPackage dp = wayaccount.doQuery(param);
		boolean result = true;
		if(dp.getDatas().size() == 0){
			return false;
		}
		WayaccountVO vo = (WayaccountVO)dp.getDatas().get(0);
		if(StringUtils.isEmpty(vo.getDeacctno()) || StringUtils.isEmpty(vo.getDeacctname()) || StringUtils.isEmpty(vo.getDebankname())){
			return false;
		}
		return result;
	}
	
	/**
	 * �����Ʒ�������Ʒ����
	 * @param ordreDataList
	 * @param codeAndComcate
	 * @param wayid
	 * @return
	 * @throws Exception
	 */
	private Map<String, Integer> doCheckDataList(List<ComorderVO> ordreDataList,Map<String,String> codeAndComcate,String wayid) throws Exception {
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class, user);
		for(ComorderVO comvo: ordreDataList){
			String comcate = comvo.getComcategory();
			String count = comvo.getOrderamount() + "";
			
			//�����Ʒ����
			String brand = comcate.toUpperCase().trim();
			
			if(dataMap.get(brand) != null){
				throw new Exception("��Ʒ�ظ�");
			}
			
			Dictitem dictitem = (Dictitem)BOFactory.build(DictitemBO.class, user);
			DictitemDBParam dictitemDBParam = new DictitemDBParam();
			dictitemDBParam.set_se_groupid("IM_FXCOMCATEGORY");
			dictitemDBParam.set_se_dictid(brand);
			DataPackage dictitemDp = dictitem.doQuery(dictitemDBParam);
			if(dictitemDp.getDatas().size() == 0){
				throw new Exception("��Ʒ������");
			}
			
			Comorderstate comorderstate = (Comorderstate)BOFactory.build(ComorderstateBO.class, user);
			ComorderstateDBParam comorderstateDBParam = new ComorderstateDBParam();
			comorderstateDBParam.set_se_cityid(user.getCityid());
			comorderstateDBParam.set_se_comcategory(brand);
			DataPackage comorderstateDp = comorderstate.doQuery(comorderstateDBParam);
			if(comorderstateDp.getDatas().size() != 0){
				ComorderstateVO vo = (ComorderstateVO)comorderstateDp.getDatas().get(0);
				if(!"NORMAL".equals(vo.getOrderstate())){
					throw new Exception("��Ʒ����״̬������");
				}
			}
			
			//�����Ʒ����
			String amount = count.trim();
			if(!PublicUtils.isInteger(amount) || Integer.parseInt(amount) <= 0){
				throw new Exception("���������Ǵ����������");
			}
			// ��ȡ�������� 
			// ���ա���Ʒ�������½��еĶ���������ȡ�߼�����ȡָ�����С�ָ����Ʒ����Ķ���������[2010-07-29]
			String unitage = comorderBO.doGetUnitage(user.getCityid(), brand);
			if(Integer.parseInt(amount) % Integer.parseInt(unitage) != 0){
				throw new Exception("������Ʒ�����Ƕ�������������");
			}
//			comvo.setPlanCode(unitage);//�趨��������
			Map map = comorderBO.doGetUnitpriceAndPlancode(wayid, comvo.getComcategory());
			if (null != map.get("planCode") && !"".equals(map.get("planCode"))) {
				comvo.setPlanCode(map.get("planCode").toString());//�趨�Żݷ���
			}
			Double unitprice = Double.parseDouble(map.get("unitprice").toString());
			// ������Ʒ����
			comvo.setUnitprice(unitprice);
			// �����ܽ��
			Double totalprice = unitprice * comvo.getOrderamount();
			comvo.setTotalprice(totalprice);
			
			dataMap.put(brand, Integer.parseInt(amount));
		}
		return dataMap;
	}
	
	/**
	 * ��������Ӧ��ϵ����
	 * @return
	 * @throws Exception
	 */
	private Map<String,String> getCodeAndComcateMap() throws Exception {
		//������������Ӧ��ϵ���ϣ���ѯ������Դ�����Ӧ��(IM_PR_CITYRESCODE)��
		//ƥ���й�˾��ʶΪ�������У�����Ӧ��ϵһ�����롣
		Cityrescode cityrescode = (Cityrescode)BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cparams = new CityrescodeDBParam();
		cparams.set_se_cityid(user.getCityid());
		DataPackage dp = cityrescode.doQuery(cparams);
		List<CityrescodeVO> codeAndComcateList = dp.getDatas();
		//key-cityrescode������Դ����,value-comcategory��Ʒ�������
		Map<String,String> codeAndComcate = new HashMap<String,String>();
		if(codeAndComcateList.size()>0){
			for(CityrescodeVO cityrescodevo:codeAndComcateList){
				codeAndComcate.put(cityrescodevo.getCityrescode(),cityrescodevo.getComcategory());
			}
		}
		return codeAndComcate;
	}
}
