package com.gmcc.pboss.control.resource.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.resource.emptysimlog.EmptysimlogVO;
import com.gmcc.pboss.business.resource.numtyperule.NumtyperuleVO;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoDBParam;
import com.gmcc.pboss.business.resource.simnoactinfo.SimnoactinfoVO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.gmcc.pboss.control.resource.baodi.BaodiBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.gmcc.pboss.control.resource.emptysimlog.Emptysimlog;
import com.gmcc.pboss.control.resource.emptysimlog.EmptysimlogBO;
import com.gmcc.pboss.control.resource.numtyperule.Numtyperule;
import com.gmcc.pboss.control.resource.numtyperule.NumtyperuleBO;
import com.gmcc.pboss.control.resource.simnoactinfo.Simnoactinfo;
import com.gmcc.pboss.control.resource.simnoactinfo.SimnoactinfoBO;
import com.gmcc.pboss.control.sales.partnerres.Partnerres;
import com.gmcc.pboss.control.sales.partnerres.PartnerresBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


public class ResourceBO extends AbstractControlBean implements Resource{
	private Log log = LogFactory.getLog(BaodiBO.class);
	
	public void process() throws Exception {
		// TODO Auto-generated method stub
		try{
			
		}catch(Exception e){
			e.printStackTrace();
			log.error(e.getMessage());
		}	
	}

	
	/**
	 * 套卡资源发布处理
	 * @param line 待处理串多个字段这间用&&分开
	 * @param map 商品包MAP 对每次操作做处理并记录，到处理完文件最后统一处理
	 * @param defaultState	默认商品状态
	 * @param resourceUse	默认资源用途
	 * @param storage		默认存储库区	
	 * @param batchno		商品批次
	 * @throws Exception
	 */
	public void doComressmDeploy(String line,Map map,String defaultState,String resourceUser,String storage,String batchno,List<NumtyperuleVO> typeruleList) throws Exception{
		
		String split_sybm = "|";
		String tempLine = line.replaceAll("&&", "|");
		String[] items = StringUtils.splitPreserveAllTokens(tempLine,"|");
		if(items.length !=20 ){
			throw new Exception("数据项应该是19个，各数据项之间用'&&'分开 :"+line);
		}
		
//		逐行读取文件内容，按照协议规定的字段顺序取值；要求商品资源编号、商品标识、商品批次、商品状态、
//		渠道标识和品牌字段非空，如果为空则记录出错文件，出错原因填写“XX字段为空”，
//		登记失败记录数并返回处理下一条记录；如果包号字段为空，则赋予默认值“000-000-000”。
		if( "".equals(items[0].trim()))
			throw new Exception("商品资源编号字段为空");
		if( "".equals(items[1].trim()))
			throw new Exception("商品标识字段为空");
		if( "".equals(items[3].trim()))
			throw new Exception("商品状态字段为空");
		if( "".equals(items[4].trim()))
			throw new Exception("渠道标识字段为空");
		if( "".equals(items[17].trim()))
			throw new Exception("品牌字段为空");
		String boxnum = items[18];
		if( "".equals(items[18].trim())){
			boxnum = items[1].trim()+items[4].trim()+"000-000-000";
			items[18] = items[1].trim()+items[4].trim()+"000-000-000";
		}
			
		try{
//			1）	根据商品批次和包号查询商品包MAP，存在则进入第5步；否则继续下一步。
			
			if(map.get(batchno+split_sybm+boxnum) == null){
				Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
				CompackVO compackVO = new CompackVO();
				compackVO.setBatchno(batchno);
				compackVO.setBoxnum(boxnum);
				compackVO = compackBO.doFindByPk(compackVO);
//				2）	根据商品批次和包号查询商品包表，存在数据则进入下一步；否则进入第4步。
				if(compackVO != null){
		
//				3）	判断商品包的商品种类、包状态(默认状态与读取的文件无关)、渠道是否和当前资源一致。
//				根据商品标识查询商品种类组合关系表获取商品种类，有多条时取第一条即可，如果不存在则记录出错信息“根据商品标识[XXX]找不到相应的商品种类组合关系”并返回处理下一条数据；套卡资源状态取套卡默认商品状态；渠道取文件中渠道标识。
//				如果全部一致则进入下一步；如果其中任一属性不一致则记录出错信息“套卡商品种类[A]和商品包商品种类[B]不一致”、“套卡入口默认状态[A]和商品包状态[B]不一致”或“套卡渠道[A]和商品包渠道[B]不一致”，返回处理下一条数据。

					Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class,user);
					ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
					comcategoryrelaDBParam.setDataOnly(true);
					comcategoryrelaDBParam.set_ne_comid(items[1]);
					DataPackage comcategoryrelaDP = comcategoryrelaBO.doQuery(comcategoryrelaDBParam);
					if( null == comcategoryrelaDP || null == comcategoryrelaDP.getDatas() || comcategoryrelaDP.getDatas().size() == 0)
						throw new JOPException("根据商品标识["+items[1]+"]找不到相应的商品种类组合关系");
					ComcategoryrelaVO ComcategoryrelaVO = (ComcategoryrelaVO) ((List)comcategoryrelaDP.getDatas()).get(0);
					if(!ComcategoryrelaVO.getComcategory().equals(compackVO.getComcategory()))
						throw new JOPException("套卡商品种类["+ComcategoryrelaVO.getComcategory()+"]和商品包商品种类["+compackVO.getComcategory()+"]不一致");	
					if(!defaultState.equals(compackVO.getPackstate()))
						throw new JOPException("套卡入库默认状态["+defaultState+"]和商品包状态["+compackVO.getPackstate()+"]不一致");	
					if(!compackVO.getWayid().equals(items[4]))
						throw new JOPException("套卡渠道["+items[4]+"]和商品包渠道["+compackVO.getWayid()+"]不一致");			
				}
//				4）	新增数据到MAP中，key取“批次|包号”，value取商品包对象，商品数量留空；
//				根据商品标识查询商品种类组合关系表（IM_PR_COMCATEGORYRELA）获取商品种类；包状态、所属渠道、取套卡对应字段；
//				归属号段取号码前3位；资源用途和所属库区取系统默认参数；归属配送商和打包时间留空。
				Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class,user);
				ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
				comcategoryrelaDBParam.setQueryAll(true);
				comcategoryrelaDBParam.setDataOnly(true);
				comcategoryrelaDBParam.set_ne_comid(items[1]);
				DataPackage comcategoryrelaDP = comcategoryrelaBO.doQuery(comcategoryrelaDBParam);
				if( null == comcategoryrelaDP || null == comcategoryrelaDP.getDatas() || comcategoryrelaDP.getDatas().size() == 0)
					throw new JOPException("根据商品标识["+items[1]+"]找不到相应的商品种类组合关系");
				ComcategoryrelaVO ComcategoryrelaVO = (ComcategoryrelaVO) ((List)comcategoryrelaDP.getDatas()).get(0);
				compackVO = new CompackVO();
				compackVO.setBatchno(batchno);
				compackVO.setBoxnum(boxnum);
				compackVO.setComcategory(ComcategoryrelaVO.getComcategory());
				compackVO.setPackstate(defaultState);
				compackVO.setWayid(items[4]);
				compackVO.setNosect(items[0].substring(0,3));
				compackVO.setResuse(resourceUser);
				compackVO.setStorarea(storage);
			map.put(batchno+split_sybm+boxnum, compackVO);
			} else {
				CompackVO compackVO = (CompackVO) map.get(batchno + split_sybm + boxnum);
				if (!compackVO.getWayid().equals(items[4])) {
					throw new JOPException("套卡渠道[" + items[4] + "]和商品包渠道[" + compackVO.getWayid() + "]不一致 -----");
				}
			}
//			5）	新增数据到套卡资源表（IM_FX_COMRESSMP），商品批次取当前日期，格式为yyyy-MM-dd；“商品状态”取套卡默认商品状态；
//			“入库时间”取当前时间；根据商品资源编号（即号码）调用号码分类模块获取“号码类型”；
//			套卡品牌，根据商品标识查询商品种类组合关系表（IM_PR_COMCATEGORYRELA）获取套卡品牌其他字段取当前行拆分字段。
			
			Comcategoryrela comcategoryrelaBO = (ComcategoryrelaBO) BOFactory.build(ComcategoryrelaBO.class,user);
			ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
			comcategoryrelaDBParam.setQueryAll(true);
			comcategoryrelaDBParam.setDataOnly(true);
			comcategoryrelaDBParam.set_ne_comid(items[1]);
			DataPackage comcategoryrelaDP = comcategoryrelaBO.doQuery(comcategoryrelaDBParam);
			if( null == comcategoryrelaDP || null == comcategoryrelaDP.getDatas() || comcategoryrelaDP.getDatas().size() == 0)
				throw new JOPException("根据商品标识["+items[1]+"]找不到相应的商品种类组合关系");
			ComcategoryrelaVO comcategoryrelaVO = (ComcategoryrelaVO) ((List)comcategoryrelaDP.getDatas()).get(0);
			Numtyperule numtyperuleBO = (Numtyperule)BOFactory.build(NumtyperuleBO.class,user);
			Long type = numtyperuleBO.doMatchNumber(items[0],typeruleList);//根据号码取得其类型
	log.info(items[0]+"================号码类型:"+type+" ===========================");
	
			Comressmp bo = (ComressmpBO) BOFactory.build(ComressmpBO.class,user);
			//根据商品资源编号（即号码）查询套卡资源表（IM_FX_COMRESSMP）获取套卡集合。
			ComressmpDBParam comressmpDBParam=new ComressmpDBParam();
			comressmpDBParam.set_se_comresid(items[0]);
			List<ComressmpVO> comressmpList=bo.doQuery(comressmpDBParam).getDatas();
			boolean isUpdate=false;
			ComressmpVO vo = new ComressmpVO();
			//如果套卡集合不为空，对套卡集合进行遍历，如果存在商品状态不是“已售”的数据，提示“套卡资源[XXX]存在非已售状态数据”，否则继续；
			if(comressmpList!=null && comressmpList.size()>0){
				for(ComressmpVO tempvo:comressmpList){
					if(2!=tempvo.getComstate()){
						throw new JOPException(" ========套卡资源["+items[0]+"]存在非已售状态数据");
						//throw new JOPException(" ===========商品资源编号["+items[0]+"] 商品标识 ["+items[1]+"] 的套卡资源 已经存在");
					}
				}
				//对套卡集合二次遍历，判断是否存在商品标识相同的数据，如果无则新增数据到套卡资源表（逻辑见上），如果有则修改对应记录，修改后数据参照新增逻辑，注意有多条时只修改其中任一条即可。
				for(ComressmpVO tempvo:comressmpList){
					if(tempvo.getComid().longValue()==new Long(items[1]).longValue()){
						vo=tempvo;
						isUpdate=true;
						break;
					}
				}
			}
			
			vo.setNumbertype(type==null ? null:type.toString());
			vo.setComresid(items[0]);
			vo.setComid(new Long(items[1]));
			vo.setBrand(comcategoryrelaVO.getBrand());
			vo.setBatchno(batchno);
			vo.setComstate(Short.valueOf(defaultState));
			vo.setWayid(items[4]);
			vo.setOprcode(items[5]);
			vo.setStarttime(formatDate(items[6],"yyyy-MM-dd HH:mm:SS"));
			vo.setValidperiod(formatDate(items[7],"yyyy-MM-dd HH:mm:SS"));
			vo.setComkeep(formatDate(items[8],"yyyy-MM-dd HH:mm:SS"));
			vo.setComdisc(new Long(items[9]));
			vo.setPrice(new Long(items[10]));
			vo.setComactive(formatDate(items[11],"yyyy-MM-dd HH:mm:ss"));
			vo.setComsource(new Integer(items[12]));
			vo.setStockprice(new Long(items[13]));
			vo.setSimprice(new Long(items[14]));
			vo.setIsopen(new Short(items[15]));
			vo.setIccid(items[16]);
			vo.setBoxnum(items[18]);
			vo.setEntertime(new Date());
			if(isUpdate){
				bo.doUpdate(vo);
			}else{
				bo.doCreate(vo);
			}
					
		}catch(Exception e){
			e.printStackTrace();
//			try{
//				//如果失败则应该清除新增进MAP的值
//				if(map.containsKey(batchno+split_sybm+boxnum))
//				map.remove(batchno+split_sybm+boxnum);
//			}catch(Exception ex){
//				log.error(ex);
//			}
			if(null != e.getCause())
				throw new JOPException(e.getCause().getMessage());
			throw new JOPException(e.getMessage());
		}
	}
	
	
	/**
	 * 充值卡发布处理
	 * @param line	待处理串多个字段这间用&&分开
	 * @param comrescardState	充值卡商品状态
	 * @param batchno 批次
	 * @throws Exception
	 */
	public void doComrescardDeploy(String line,String comrescardState,String batchno) throws Exception{
		// TODO Auto-generated method stub

			String tempLine = line.replaceAll("&&", "|");
			String[] items = StringUtils.splitPreserveAllTokens(tempLine,"|");
			if(items.length != 17){
				throw new Exception("数据项应该是16个，各数据项之间用'&&'分开");
			}
//			按照协议规定的字段顺序取值，要求商品资源编号、商品标识、商品批次、商品状态和渠道标识字段非空
//			，如果为空则记录出错文件，出错原因填写“XX字段为空”，登记失败记录数并返回处理下一条记录。
			if("".equals(items[0].trim()))
				throw new JOPException("商品资源编号字段为空");
			if("".equals(items[1].trim()))
				throw new JOPException("商品标识字段为空");
			if("".equals(items[3].trim()))
				throw new JOPException("商品状态字段为空");
			if("".equals(items[4].trim()))
				throw new JOPException("渠道标识字段为空");
			ComrescardVO vo = new ComrescardVO();
			vo.setComresid(items[0]);
			vo.setComid(new Long(items[1]));
			vo.setBatchno(batchno);
			vo.setComstate(new Short(comrescardState));
			vo.setWayid(items[4]);
			vo.setOprcode(items[5]);
			vo.setStarttime(formatDate(items[6],"yyyy-MM-dd HH:mm:ss"));
			vo.setValidperiod(formatDate(items[7],"yyyy-MM-dd HH:mm:ss"));
			vo.setComkeep(formatDate(items[8],"yyyy-MM-dd HH:mm:ss"));
			vo.setComdisc(new Long(items[9]));
			vo.setPrice(new Long(items[10]));
			vo.setComactive(formatDate(items[11],"yyyy-MM-dd HH:mm:ss"));
			vo.setComsource(new Integer(items[12]));
			vo.setStockprice(new Long(items[13]));
			vo.setChargepwd(items[14]);
			vo.setPacktype(new Long(items[15]));
			vo.setEntertime(new Date());
			
			Comrescard bo = (ComrescardBO)BOFactory.build(ComrescardBO.class,user);
			bo.doCreate(vo);
//			由于使用SPRING AOP 对于DOCREATE,DOUPDATE,DOREMOVE方法的拦截系统自动记录日志,所以此处不需要单独再写日志表
//			try{
//				ComrescardlogVO logVO = new ComrescardlogVO();
//				BeanUtils.copyProperties(logVO,vo);
//				logVO.setOprcode2(operator);
//				logVO.setOptime(new Date());
//				logVO.setSuccess("success");
//				logVO.setOprtype("create");
//				Comrescardlog logBO = (ComrescardlogBO)BOFactory.build(ComrescardlogBO.class,user);
//				logBO.doCreate(logVO);
//			}catch(Exception e){
//				log.error("充值卡登记日志错误:"+e.getMessage());
//			}
	}
	
	/**
	 * 空白卡发布处理
	 * @param line	待处理串
	 * @param operator	操作员
	 * @throws Exception
	 */
	public void doEmptysimDeploy(String line,String simrescardState,String batchno ) throws Exception{
		String tempLine = line.replaceAll("&&", "|");
		String[] items = StringUtils.splitPreserveAllTokens(tempLine,"|");
		if(items.length != 14){
			throw new Exception("数据项应该是13个，各数据项之间用'&&'分开");
		}
//		要求空卡序列号、渠道标识和状态字段非空，如果为空则记录出错文件，出错原因填写“XX字段为空”
//		，登记失败记录数并返回处理下一条记录。
		if("".equals(items[0].trim()))
			throw new Exception("空卡序列号字段为空");
		if("".equals(items[7].trim()))
			throw new Exception("渠道标识字段为空");
		if("".equals(items[10].trim()))
			throw new JOPException("商品状态字段为空");
		if("".equals(items[12].trim()))
			throw new JOPException("商品标识字段为空");
		EmptysimVO vo = new EmptysimVO(); 
		vo.setEmptyno(items[0]);
		if("".equals(items[1].trim())){
			vo.setCardmill(null);
		}else{
			vo.setCardmill(new Integer(items[1]));
		}
		
		vo.setIccid(items[2]);
		vo.setPukno(items[3]);
		if("".equals(items[4].trim())){
			vo.setBegintime(null);
		}else{
			vo.setBegintime(formatDate(items[4],"yyyy-MM-dd HH:mm:ss"));
		}
		
		if("".equals(items[5].trim())){
			vo.setStoptime(null);
		}else{
			vo.setStoptime(formatDate(items[5],"yyyy-MM-dd HH:mm:ss"));
		}
		
		if("".equals(items[6].trim())){
			vo.setIntime(null);
		}else{
			vo.setIntime(formatDate(items[6],"yyyy-MM-dd HH:mm:ss"));
		}
		vo.setWayid(items[7]);
		vo.setOprcode(items[8]);
		if("".equals(items[9].trim())){
			vo.setSimtype(null);
		}else{
			vo.setSimtype(new Integer(items[9]));
		}
		vo.setUsestate(new Short(simrescardState));
		if("".equals(items[11].trim())){
			vo.setBackup(null);
		}else{
			vo.setBackup(new Short(items[11]));
		}
		vo.setEntertime(new Date());
		vo.setBatchno(batchno);
		vo.setComid(new Long(items[12]));
		
		Emptysim bo = (EmptysimBO)BOFactory.build(EmptysimBO.class,user);
		bo.doCreate(vo);
		
//		由于使用SPRING AOP 对于DOCREATE,DOUPDATE,DOREMOVE方法的拦截系统自动记录日志,所以此处不需要单独再写日志表
//		try{
//			EmptysimlogVO logVO = new EmptysimlogVO();
//			BeanUtils.copyProperties(logVO,vo);
//			logVO.setOprcode2(vo.getOprcode());
//			logVO.setOptime(new Date());
//			logVO.setSuccess("success");
//			logVO.setOprtype("create");
//			Emptysimlog logBO = (EmptysimlogBO)BOFactory.build(EmptysimlogBO.class, user);
//			logBO.doCreate(logVO);
//		}catch(Exception e){
//			e.printStackTrace();
//			log.error("空白SIM卡资源入库错误："+e.getMessage());
//		}
	}
	private static Date formatDate (String dateString,String format)throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(dateString);
	}
	
	public void doSimStateProcess(String line) throws Exception {
		String[] items = StringUtils.splitPreserveAllTokens(line,"|");
		
		if(items.length !=4 ){
			throw new Exception("数据项应该是3个，各数据项之间用'|'分开 :"+line);
		}
		if(items[0] == null || "".equals(items[0].trim()))
			throw new Exception("空卡序列号字段为空");
		if(items[1] == null || "".equals(items[1].trim()))
			throw new Exception("状态字段为空");
		if(items[2] == null || "".equals(items[2].trim()))
			throw new Exception("变更时间字段为空");
		
		String format = "yyyy-MM-dd HH:mm:ss";
		Date changetime = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			changetime = dateFormat.parse(items[2]);
		} catch (Exception e) {
			throw new Exception("变更时间，格式不对");
		}
		
		Simnoactinfo simnoactinfoBO = (SimnoactinfoBO)BOFactory.build(SimnoactinfoBO.class, user);
		SimnoactinfoDBParam simnoactinfoDBParam = new SimnoactinfoDBParam();
		simnoactinfoDBParam.set_se_emptyno(items[0]);
		SimnoactinfoVO simnoactinfoVO = null;
		DataPackage dp = simnoactinfoBO.doQuery(simnoactinfoDBParam);
		if(dp.getRowCount() > 0){
			simnoactinfoVO = (SimnoactinfoVO)dp.getDatas().get(0);
		}
		String emptyno = items[0];
		Date creattime = new Date();
		String memo = "空白SIM卡文件导入";
		String state = items[1];
		
		Short isactive = Short.parseShort(items[1]);
		
		if("5".equals(items[1]) || "10".equals(items[1])){
			state = "AVAILABLE";
			isactive = Short.parseShort("0");
		}
		if("2".equals(items[1])){
			state = "USED";
			isactive = Short.parseShort("1");
		}
		if("8".equals(items[1])){
			state = "CANCEL";
			isactive = Short.parseShort("2");
		}
		
		if(simnoactinfoVO == null){
			simnoactinfoVO = new SimnoactinfoVO();
			simnoactinfoVO.setChangetime(changetime);
			simnoactinfoVO.setCreattime(creattime);
			simnoactinfoVO.setEmptyno(emptyno);
			simnoactinfoVO.setState(state);
			simnoactinfoVO.setMemo(memo);
			
			simnoactinfoBO.doCreate(simnoactinfoVO);
		}else{
			if(changetime.getTime() > simnoactinfoVO.getChangetime().getTime()){
				simnoactinfoVO.setChangetime(changetime);
				simnoactinfoVO.setCreattime(creattime);
				simnoactinfoVO.setEmptyno(emptyno);
				simnoactinfoVO.setState(state);
				simnoactinfoVO.setMemo(memo);
				
				simnoactinfoBO.doUpdate(simnoactinfoVO);
			}
		}
		
		//更新合作商资源
		Partnerres partnerresBO = (PartnerresBO)BOFactory.build(PartnerresBO.class, user);
		PartnerresDBParam partnerresDBParam = new PartnerresDBParam();
		partnerresDBParam.set_ne_comid(emptyno);
		DataPackage dp1 = partnerresBO.doQuery(partnerresDBParam);
		if(dp1.getRowCount() > 0){
			PartnerresVO partnerresVO = (PartnerresVO)dp1.getDatas().get(0);
			partnerresVO.setIsactive(isactive);
			
			partnerresBO.doUpdate(partnerresVO);
		}
	}
}
