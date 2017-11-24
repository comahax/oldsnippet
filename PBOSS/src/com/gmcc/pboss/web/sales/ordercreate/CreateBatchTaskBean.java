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
	
	private Map<String,String> codeAndComcateMap;// 载入代码对应关系集合
	
	public CreateBatchTaskBean() throws Exception{
		// 
		super.setBatchName("批量订购");
		super.setOprtype("导入");
	}
	protected String doStart() {
		return "序号|合作商编码|地市资源代码和订购数量|处理结果\r\n";
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
			// 载入代码对应关系集合
			if (codeAndComcateMap == null)
			codeAndComcateMap = this.getCodeAndComcateMap();
			
			// 合作商检查
			Way way = (Way) BOFactory.build(WayBO.class,user);
			WayVO wayvo = way.doFindByPk(content[0]);
			if (wayvo == null) {
				throw new Exception("合作商基本信息不存在");
			} else if (!"AG".equals(wayvo.getWaytype())) {
				throw new Exception("合作商基本信息不存在");
			} else if (!user.getCityid().equals(wayvo.getCityid())) {
				throw new Exception("合作商基本信息不存在");
			}
			
			// 检查订购资格
			Wayassistant ass = (Wayassistant) BOFactory.build(WayassistantBO.class,user);
			WayassistantVO assvo = ass.doFindByPk(content[0]);
			if (assvo == null) {
				throw new Exception("无商品订购权限");
			} else if (assvo.getCanorder() == null || assvo.getCanorder() != 1) {
				throw new Exception("无商品订购权限");
			}			
			// 记录缴费方式信息
			String paytype = assvo.getPaytype();
			String delitype = assvo.getDelitype();
			wayvo.setPaytype(paytype);
			wayvo.setDelitype(delitype);
			
			// 拆分资源代码和数量
			List<ComorderVO> result = new ArrayList<ComorderVO>();
			if (content[1].contains("#")) {
				result = this.getcomsrc(content[1]);
			} else {
				result = this.getjmsrc(content[1]);
			}			
			
			// 混合订单检查
			if (!this.doCheckMixOrderEnable(result)) {
				throw new Exception("不能订购混合资源类别的订单");
			}
			
			// 检查银行账号
			if (paytype.equals(ComorderConstant.PAYTYPE_BANK)) {
				if (!this.doCheckBankInformation(content[0])) {
					throw new Exception("银行账号信息不存在或不完整");
				}
			}
			
			// 月订购次数检查
			Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,
					user);
			try {
				comorder.checkMonthBookTimes(content[0]);
			} catch (SaleException se) {
				if (se.getMonmaxtimes() != null) {
					throw new Exception("本月已成功订购"+ se.getMontimes().toString() +"次，达到最大订购次数，不能继续订购");
				} else {
					throw se;
				}
			} catch (Exception ex) {
				throw ex;
			}
			
			// 检查订购时段
			try{
				ComorderCheck comorderCheckBO = (ComorderCheckBO)BOFactory.build(ComorderCheckBO.class,user);
				comorderCheckBO.checkLimitTime(wayvo);
			}catch(SaleException ex){
				if("SALE-104015".equals(ex.getErrorCode())){
					throw new Exception("今天不提供商品订购服务");
				}else if("SALE-104003".equals(ex.getErrorCode())){
					throw new Exception("不在系统订购时间段");
				}
			}catch(Exception e){
				throw e;
			}
			
			// 检查商品种类
			this.doCheckDataList(result, codeAndComcateMap, wayvo.getWayid());
			
			// 确定订购资源库区
			String storarea = comorder.doGetStorArea(wayvo);

			// 商品订购检查
			Set<String> brandSet = comorder.comOrderCheck(wayvo.getWayid(), result, storarea);
			
			// 获取订单编号
			String orderid = comorder.doGetOrderId();
			
			// 建立订单
			comorder.doBuildOrder(orderid, wayvo, storarea, result, brandSet,
					ComorderConstant.ORDERAVE_HALL, null);
			
			// 订单下一步处理
			try {
				comorder.doNextProcess(orderid);
			} catch (Exception e) {
			}
			
			vo.setInfo(rowCount+"|"+content[0]+"|"+content[1]+"|"+"订购成功，订单编号："+orderid);
			
			vo.setOk(true);
			return vo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			vo.setInfo(rowCount+"|"+content[0]+"|"+content[1]+"|"+"错误信息:"+e.getMessage());
			vo.setOk(false);
			return vo;
		}		
	}
	
	/**
	 * 拆分资源代码(江门)
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
			// 如果字符是字母
			if (mm.matches("[a-zA-Z]{1}")) {
				s = s + mm;
				newflag = "s";
			//如果字符是数字
			} else if (mm.matches("[0-9]{1}")) {
				n = n + mm;
				newflag = "n";
				// 第一个字符为字母的时候
				if (i == 0) {
					throw new Exception("订购信息格式错误");
				}
			// 如果字符不是字母和数字，导入格式不正确
			} else {
				throw new Exception("订购信息格式错误");
			}
			// 当前字符是数字，上个字符为字母的时候
			if ("n".equals(newflag) && "s".equals(oldflag)) {
				lis.add(s);
				s = "";
				// 当前字符为字母，上个字符为数字的时候
			} else if ("s".equals(newflag) && "n".equals(oldflag)) {
				lis.add(n);
				n = "";
			}
			oldflag = newflag;
		}
		// 最后的字符为字母的时候
		if (!"".equals(s)) {
			lis.add(s);
			
			// 最后的字符为数字的时候
		} else if (!"".equals(n)) {
			lis.add(n);
		}
		int k = lis.size();
		// 当所得的队列集数量不为偶数的时候，导入格式不正确
		if (k%2 != 0) {
			throw new Exception("订购信息格式错误");
		} else {
			for (int i = 0; i < lis.size(); ) {
				ComorderVO vo = new ComorderVO();
				// 如果数量不为数字
				try {
					Long.parseLong(lis.get(i+1).toString());
				} catch (Exception e) {
					throw new Exception("订购信息格式错误");
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
	 * 拆分资源代码(通用)
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public List<ComorderVO> getcomsrc(String src) throws Exception {
		List<ComorderVO> result = new ArrayList<ComorderVO>();
		List lis = new ArrayList();
		// 半角逗号拆分
		String[] items = src.split(",");
		for (int i = 0; i < items.length; i++) {
			// 全角逗号拆分
			String[] items1 = items[i].split("，");
			for (int k = 0; k < items1.length; k++) {
				// #号拆分
				String[] items2 = items1[k].split("#");
				for (int j = 0; j < items2.length; j++) {
					lis.add(items2[j]);
				}
			}
		}
		
		// 把拆分的数据封装
		int k = lis.size();
		if (k%2 != 0) {
			throw new Exception("订购信息格式错误");
		} else {
			for (int i = 0; i < lis.size(); ) {
				ComorderVO vo = new ComorderVO();
				// 如果数量不为数字
				try {
					Long.parseLong(lis.get(i+1).toString());
				} catch (Exception e) {
					throw new Exception("订购信息格式错误");
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
	 * 根据系统参数检查是否允许混合订单,允许则立即返回，不允许则检查订购商品是否为同一品牌
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
		if(!enable){//不允许订购混合订单
			//查询IM_PR_COMCATEGORYRELA，获取商品种类-资源类别组合，放到一个Map中
			Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class, user);
			ComcategoryrelaDBParam params = new ComcategoryrelaDBParam();
			params.setSelectFieldsString("comcategory,restype");
			params.set_pagesize("0");
			params.setDataOnly(true);
			DataPackage dp = comcategoryrela.doLoadComCateAndResType(params);
			List comcateAndRestype = dp.getDatas();
			//key-comcategory商品种类,value-restype资源类型
			Map<String,String> cateAndRes = new HashMap<String,String>();
			if(comcateAndRestype.size()>0){
				for(Iterator it=comcateAndRestype.iterator();it.hasNext();){
					Map<String,String> temp = (Map<String,String>)it.next();					
					cateAndRes.put(temp.get("comcategory"), temp.get("restype"));
				}
			}
			
			//商品资源类型标记变量
			String tokenRestype = null;
			for(ComorderVO comvo: ordreDataList){
				if(tokenRestype==null){//处理第一个商品，将其资源类别保存
					tokenRestype = cateAndRes.get(comvo.getComcategory());
					continue;
				}
				//处理其他商品，如果资源类别与保存的资源类别不同，报错
				String restype = cateAndRes.get(comvo.getComcategory());
				if(!tokenRestype.equals(restype)){
					result = false;
				}
			}
		}		
		return result;
	}
	
	/**
	 * 检查银行账号
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
	 * 检查商品种类和商品数量
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
			
			//检查商品种类
			String brand = comcate.toUpperCase().trim();
			
			if(dataMap.get(brand) != null){
				throw new Exception("商品重复");
			}
			
			Dictitem dictitem = (Dictitem)BOFactory.build(DictitemBO.class, user);
			DictitemDBParam dictitemDBParam = new DictitemDBParam();
			dictitemDBParam.set_se_groupid("IM_FXCOMCATEGORY");
			dictitemDBParam.set_se_dictid(brand);
			DataPackage dictitemDp = dictitem.doQuery(dictitemDBParam);
			if(dictitemDp.getDatas().size() == 0){
				throw new Exception("商品不存在");
			}
			
			Comorderstate comorderstate = (Comorderstate)BOFactory.build(ComorderstateBO.class, user);
			ComorderstateDBParam comorderstateDBParam = new ComorderstateDBParam();
			comorderstateDBParam.set_se_cityid(user.getCityid());
			comorderstateDBParam.set_se_comcategory(brand);
			DataPackage comorderstateDp = comorderstate.doQuery(comorderstateDBParam);
			if(comorderstateDp.getDatas().size() != 0){
				ComorderstateVO vo = (ComorderstateVO)comorderstateDp.getDatas().get(0);
				if(!"NORMAL".equals(vo.getOrderstate())){
					throw new Exception("商品订购状态不正常");
				}
			}
			
			//检查商品数量
			String amount = count.trim();
			if(!PublicUtils.isInteger(amount) || Integer.parseInt(amount) <= 0){
				throw new Exception("订购数量非大于零的整数");
			}
			// 获取订购基数 
			// 参照【商品订购】章节中的订购基数获取逻辑，获取指定地市、指定商品种类的订购基数。[2010-07-29]
			String unitage = comorderBO.doGetUnitage(user.getCityid(), brand);
			if(Integer.parseInt(amount) % Integer.parseInt(unitage) != 0){
				throw new Exception("订购商品数量非订购基数整数倍");
			}
//			comvo.setPlanCode(unitage);//设定订购基数
			Map map = comorderBO.doGetUnitpriceAndPlancode(wayid, comvo.getComcategory());
			if (null != map.get("planCode") && !"".equals(map.get("planCode"))) {
				comvo.setPlanCode(map.get("planCode").toString());//设定优惠方案
			}
			Double unitprice = Double.parseDouble(map.get("unitprice").toString());
			// 设置商品单价
			comvo.setUnitprice(unitprice);
			// 计算总金额
			Double totalprice = unitprice * comvo.getOrderamount();
			comvo.setTotalprice(totalprice);
			
			dataMap.put(brand, Integer.parseInt(amount));
		}
		return dataMap;
	}
	
	/**
	 * 载入代码对应关系集合
	 * @return
	 * @throws Exception
	 */
	private Map<String,String> getCodeAndComcateMap() throws Exception {
		//首先载入代码对应关系集合，查询地市资源代码对应表(IM_PR_CITYRESCODE)，
		//匹配市公司标识为归属地市，将对应关系一次载入。
		Cityrescode cityrescode = (Cityrescode)BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cparams = new CityrescodeDBParam();
		cparams.set_se_cityid(user.getCityid());
		DataPackage dp = cityrescode.doQuery(cparams);
		List<CityrescodeVO> codeAndComcateList = dp.getDatas();
		//key-cityrescode地市资源代码,value-comcategory商品种类编码
		Map<String,String> codeAndComcate = new HashMap<String,String>();
		if(codeAndComcateList.size()>0){
			for(CityrescodeVO cityrescodevo:codeAndComcateList){
				codeAndComcate.put(cityrescodevo.getCityrescode(),cityrescodevo.getComcategory());
			}
		}
		return codeAndComcate;
	}
}
