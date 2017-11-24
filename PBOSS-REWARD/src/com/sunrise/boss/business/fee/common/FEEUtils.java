package com.sunrise.boss.business.fee.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.apache.log4j.Logger;

import com.sunrise.boss.business.common.subscriber.persistent.SubscriberDAO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberListVO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.business.common.tanstableinfo.persistent.TansTableInfoVO;
import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.boss.business.fee.check.disputersn.persistent.DisputeReasonVO;
import com.sunrise.boss.business.fee.common.multinode.persistent.MultiNodeListVO;
import com.sunrise.boss.business.fee.common.multinode.persistent.MultiNodeVO;
import com.sunrise.boss.business.fee.common.prodinfo.persistent.ProdInfoVO;
import com.sunrise.boss.business.fee.dgrealprod.balancetype.persistent.BalanceTypeVO;
import com.sunrise.boss.business.fee.groupquery.groupsubscriber.persistent.GroupSubscriberListVO;
import com.sunrise.boss.business.fee.groupquery.groupsubscriber.persistent.GroupSubscriberVO;
import com.sunrise.boss.business.fee.persistent.batchoper.BatchOperVO;
import com.sunrise.boss.business.fee.persistent.creditreq.CreditReqVO;
import com.sunrise.boss.business.fee.persistent.mwbustype.MwBusTypeVO;
import com.sunrise.boss.business.fee.prod.realprod.persistent.RealProdVO;
import com.sunrise.boss.business.fee.realtran.payway.SqlUtils;
import com.sunrise.boss.business.fee.woff.changewait.persistent.ChargeWaitVO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitVO;
import com.sunrise.boss.business.zifee.pcppproduct.persistent.PcPpProductVO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.admin.purview.PurviewDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.delegate.common.subscriber.SubscriberDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.delegate.fee.billing.validbillcyc.ValidBillCycDelegate;
import com.sunrise.boss.delegate.fee.check.DisputeReasonDelegate;
import com.sunrise.boss.delegate.fee.woff.eboxunit.EBoxUnitDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.StringSplit;

/**
 * 帐务业务工具类,超过2次使用的代码,写在这里统一管理
 * @author mys
 * @version 1.0
 */
public class FEEUtils {
	//private final static String MZONE_MON_CARD = "101"; // 动感月租卡
	//private final static String MZONE_DAY_CARD = "102"; // 动感日租卡
	public final static String OCE_REAL_PROD = "1";  // 实时销帐OCE方式处理
	public final static String REAL_PROD = "2";  // 实时销帐方式处理流程
	public final static String ELSE_PROD = "0";  // 非实时销帐方式处理流程
	
	//private final static String[] SUBS_PROD_MZONE = new String[]{"101","102"};  // 动感产品标识,1005为南雄大众卡
	//private final static String[] SUBS_PROD_SZX = new String[]{"201","202","203","204"};  // 神州行大众卡产品标识
	
	
	private final static String BRANDMZONE  = "BrandMzone";
	private final static String BRANDSZX    = "BrandSzx";
	private final static String BRANDGOTONE = "BrandGotone";
	private final static String BRANDDZK    = "BrandDzk";
	
	private final static String PROD_PER  = "ProdType_Person";  //个人产品
	private final static String PROD_FAL  = "ProdType_Family";	//家庭网产品
	private final static String PROD_GRO  = "ProdType_Group";   //集团产品
	
	private final static String CHUANF = "~"; // 
	private static Logger log = Logger.getLogger(FEEUtils.class);
	
	//todo获取用户当前所有帐本(包括明细)的总额
	public static double getAllValidAmt( Long eboxid, Long eboxunitid, User user )
	throws Exception {
		double eboxAmt = getValidEboxAmt( eboxid, eboxunitid, user );
		double eboxDetAmt = getValidEboxDetAmt( eboxid, eboxunitid, user );
		return eboxAmt+eboxDetAmt;
	}
	
	//todo获取用户当前可用帐本余额
	public static double getValidEboxAmt( Long eboxid, Long eboxunitid, User user )
	throws Exception {
		return 0;
	}
	
	//todo获取用户当前可用帐本余额(分月返还)
	public static double getValidEboxDetAmt( Long eboxid, Long eboxunitid, User user )
	throws Exception {
		return 0;
	}
	
	//todo根据账本科目类型获取当前该类型所有帐本的可用总额(包括明细)
	public static double getAllValAmtByType( Long eboxid, Short eboxunittype, User user )
	throws Exception {
		double eboxAmt = getEboxAmtByType( eboxid, eboxunittype, user );
		double eboxDetAmt = getValEboxDetAmtByType( eboxid, eboxunittype, user );
		return eboxAmt+eboxDetAmt;
	}
	
	//todo根据帐本科目类型获取当前该类型帐本的可用金额
	public static double getEboxAmtByType( Long eboxid, Short eboxunittype, User user )
	throws Exception {
		return 0;
	}
	
	//todo根据帐本科目类型获取当前该类型帐本明细的可用金额
	public static double getValEboxDetAmtByType( Long eboxid, Short eboxunittype, User user )
	throws Exception {
		return 0;
	}
	
	//todo根据账本科目类型获取当前该类型帐本明细的总额
	public static double getEboxDetAmtByType( Long eboxid, Short eboxunittype, User user )
	throws Exception {
		return 0;
	}
	
	/**
	 * 判断用户状态是否有效(包括个人产品和集团产品)
	 * @param status
	 * @return
	 */
	public static boolean checkValSubsAll( String status )
	throws Exception {
		boolean val = true;
		
		if( status==null || "".equals(status) ){
			throw new Exception( "用户状态为空" );
		}
		
		if( SubscriberDAO.GSUBS_STATE_VALID
				.indexOf(status) == -1 ){
			val = false;
		}
		
		return val;
	}
	
	/**
	 * 根据用户标识判断用户是否动感地带用户
	 * @return
	 * @throws Exception
	 */
	public static boolean valMZoneUsrBySubs( Long subsid, User user )
	throws Exception {
		boolean val = false;
		
		if( subsid == null || "".equals(subsid) ){
			throw new Exception( "用户标识不能为空" );
		}
		
		SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(
				SubscriberDAO.class, user.getCityid());
		SubscriberVO vo = (SubscriberVO)dao.findByPk( subsid );
		
		if( vo == null ){
			throw new Exception( "用户标识["+subsid+"]没有对应用户" );
		}
		
		// 判断是否动感地带用户
		String prodid = vo.getProid();
		if( prodid!=null && !"".equals(prodid) ){
			CommonDelegate delegate = new  	CommonDelegate(ProdInfoVO.class);	
			ProdInfoVO pivo = new ProdInfoVO();
			pivo.setBrand(BRANDMZONE);
			pivo.setProdid(prodid);
			pivo = (ProdInfoVO) delegate.doFindByPk(pivo, user);
			if( null != pivo ){
				val = true;
			}
		}
		else {
			throw new Exception( "用户产品标识为空" );
		}
		
		return val;
	}
	

	/**
	 * 获取分销账目所有账目类型为eboxunittype的账目余额
	 * @param cooperauid 分销商编号
	 * @param eboxunittype 账目类型
	 * @param user 操作员信息
	 * @return amt 分销账目类型为eboxunittype的可用账本余额
	 */
	public static double getValDstEboxAmt( String cooperauid, Short eboxunittype, User user )
	throws Exception {
		StringBuffer sqlBuffer = new StringBuffer("select sum(a.amt) from IB_DST_EBOXUNITBAL a, IB_DST_EBOXUNIT b ");
		sqlBuffer.append("where a.cooperauid = ? and a.eboxunitid = b.eboxunitid and b.eboxtype = ? ");
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		double amt = 0;
		
		try{
			pstmt = SqlUtils.getBSQLStatement( sqlBuffer.toString(), user.getCityid() );
			pstmt.setString( 1, cooperauid );
			pstmt.setObject( 2, eboxunittype );
			rs = pstmt.executeQuery();
			
			if( rs!=null && rs.next() ){
				amt = rs.getDouble( 1 );
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}finally{
			if( rs!=null ){
				rs.close();
			}
			if( pstmt!=null ){
				pstmt.close();
			}
		}
		
		return amt;
	}
	
	/** 获取所有大类 mys**/	
	public static List getUpperGrade(User user){
		List upperGrade = new ArrayList();
		try {
			DisputeReasonDelegate delegate = new DisputeReasonDelegate();
			upperGrade = delegate.getAllUpperGrade(user);			
		} catch (Exception ex) {
			log.error("查找该话费争议大类失败：", ex);
		}
		return null != upperGrade ? upperGrade : new ArrayList() ;		
	}
		
	/** 获取从属某个大类的所有小类 mys**/	
	public static List getLowGrade(String upperGrade, User user){
		List lowGrade = new ArrayList();
		if(null != upperGrade && !"".equals(upperGrade)){			
			try {
				DisputeReasonDelegate disDelegate = new DisputeReasonDelegate();				
				lowGrade = disDelegate.getLowByRsncode(upperGrade, user);					
			} catch (Exception ex) {				
				log.error("查找该话费争议大类[" + upperGrade + "]的小类失败：", ex);
			}
		}
		return null != lowGrade ? lowGrade : new ArrayList() ;		
	}
	
	/** 获取从属某个梦网端口号的所有梦网业务类型 mys**/	
//	public static List getBusType(String portid, User user){
////		List busType = new ArrayList();
////		if(null != portid && !"".equals(portid)){			
////			try {
////				HangbillDelegate delegate = new HangbillDelegate();				
////				List list = delegate.getMWBusType(portid, user);	
////				if (list != null && list.size() > 0) {
////					for(Iterator it = list.iterator(); it.hasNext();) {
////						Object[] ob = (Object[])it.next();
////						MwBusTypeVO vo = new MwBusTypeVO();						
////						vo.setBustype((Long) ob[0]);
////						vo.setBusname(String.valueOf(ob[1]));
////						busType.add(vo);
////					}
////					list.clear();
////				}	
////			} catch (Exception ex) {				
////				log.error("查找该梦网端口号[" + portid + "]梦网业务类型失败：", ex);
////			}
////		}
////		return null != busType ? busType : new ArrayList() ;		
//	}	
	
	/** 检查话费争议大类原因是否存在话费争议原因表IB_RE_DisputeRsn中 mys**/
	public static void chkUppergrade(String uppergrade, User user) throws Exception {
		try {	
			DisputeReasonDelegate delegate = new DisputeReasonDelegate();
			DisputeReasonVO vo = (DisputeReasonVO) delegate.doFindByPk(uppergrade, user);
			if (vo == null || vo.getGrade().intValue() != 0) {
				throw new Exception("");
			}
		} catch (Exception ex) {
			throw new Exception("该话费争议大类[" + uppergrade + "]未在系统中:" + ex.getMessage());
		}
	}
	
	/** 检查话费争议小类是否存在话费争议原因表IB_RE_DisputeRsn中 返回该从属大类代码 mys**/
	public static String chkLowGrade(String lowgrade, User user) throws Exception {		
		try {
			DisputeReasonDelegate delegate = new DisputeReasonDelegate();
			DisputeReasonVO vo = (DisputeReasonVO) delegate.doFindByPk(lowgrade, user);
			if (vo == null || vo.getGrade().intValue() != 1) {
				throw new Exception("");
			}
			return vo.getRsnattach();
		} catch (Exception ex) {
			throw new Exception("该话费争议小类[" + lowgrade + "]未在系统中:" + ex.getMessage());
		}		
	}
	
	/** 检查争议小类是否属于该争议大类； mys**/
	public static void isLowGBelong2UpG(String uppergrade,String lowgrade, User user) throws Exception {				
		chkUppergrade(uppergrade, user);
		String rsnattach = chkLowGrade(lowgrade, user);
		if (!uppergrade.equals(rsnattach)) {
			throw new Exception("该话费争议小类[" + lowgrade + "]不属于该话费争议大类[" + uppergrade + "]");
		}
	}
	
	/** 根据梦网端口号是否存在梦网代码信息IB_PS_MWCode表中，并根据生效、失效时间检查状态是否有效； mys**/
//	public static List chkPortid(String portid, User user) throws Exception {		
//		try {
//			HangbillDelegate delegate = new HangbillDelegate();
//			List list = delegate.getMWBusType(portid,user);
//			if (list == null || list.size() < 1){
//				throw new Exception("");
//			}
//			return list;
//		} catch (Exception ex) {
//			throw new Exception("找不到该梦网端口[" + portid + "]" + ex.getMessage());
//		}		
//	}	
	
	/** 根据该梦网端口号及该梦网业务类型检查其是否存在梦网代码信息IB_PS_MWCode表中，并根据生效、失效时间检查状态是否有效；mys**/
	public static void chkIcpTypeByPortid(String portid,String icptype, User user) throws Exception {
//		
//		List list = chkPortid(portid, user);				
//		
//		for (Iterator it = list.iterator(); it.hasNext();) {
//			Object[] ob =  (Object[]) it.next();
//			if (icptype.equals(String.valueOf(ob[0]))) {
//				return ;				
//			}
//		}		
//		throw new Exception("梦网端口号[" + portid + "]和梦网业务类型[" + icptype + "]不匹配");		
	}
	
	/** 获取帐务系统参数 **/
	public static String getSysParamValue( int systemid, User user) throws Exception {
		return getSysParamValue(systemid, "billing", user);		
	}
	
	/** 获取公共系统参数 **/
	public static String getCommSysParamValue( int systemid, User user) throws Exception {
		return getSysParamValue(systemid, "common", user);	
	}
	
	/** 获取公共系统参数 **/
	public static String getSysParamValue( int systemid, String systype, User user) throws Exception {
		try{
			SysparamDelegate delegate = new SysparamDelegate();
			SysparamVO sysparavo = new SysparamVO();
			sysparavo.setSystemid(new Long(systemid));
			sysparavo.setParamtype(systype);				
			sysparavo = (SysparamVO) delegate.doFindByPk(sysparavo,user);				
			if(null != sysparavo){				
				return sysparavo.getParamvalue();
			}
			return null;
		}catch(Exception ex){
			throw new Exception("获取" + systype + "系统参数[" + systemid + "]出错：" + ex.getMessage());
		}	
	}
	
	/***** 获取唯一用户 *****/
	public static SubscriberVO getSubscriber(String subsid,User user) throws Exception{
		Long _subsid = null;
		try{
			if(null == subsid || "".equals(subsid.trim())){
				throw new Exception("没有找到该用户!");	
			}
			_subsid = new Long(subsid);
		
		}catch(Exception e){
			throw new Exception("查找用户[" + subsid + "]出错：" + e.getMessage());
		}
		return getSubscriber(_subsid, user);		
	}
	
	/***** 获取唯一用户 *****/
	public static SubscriberVO getSubscriber(Long subsid,User user) throws Exception{
		try{
			if(null == subsid){
				throw new Exception("没有找到该用户!");			
			}	
			CommonDelegate delegate = new  	CommonDelegate(SubscriberVO.class);					
			SubscriberVO svo = (SubscriberVO) delegate.doFindByPk(subsid,user);			
			if(null == svo ){
				throw new Exception("没有找到该用户!");															
			}
			return svo;		

		}catch(Exception e){
			throw new Exception("查找用户[" + subsid + "]出错：" + e.getMessage());
		}		
	}
	
	/***** 获取用户标识集合 *****/
	public static List getSubsidList(String mobileno,User user) throws Exception{
		try{
			if(null != mobileno || !"".equals(mobileno)){
				CommonDelegate delegate = new  	CommonDelegate(SubscriberVO.class);	
				SubscriberListVO listvo = new SubscriberListVO(); 
				listvo.set_se_servnumber(mobileno);
				listvo.set_pagesize("0");	
				DataPackage dp = delegate.doQuery(listvo, user, false);			
				if(null != dp && null != dp.getDatas()){
					return (List) dp.getDatas();												
				}
			}
		}catch(Exception e){
			throw new Exception("该号码[" + mobileno + "]找到用户标识出错：" + e.getMessage());
		}
		return null;		
	}
	
	/***** 只获取有效用户 *****/
	public static SubscriberVO getValidSubs(String mobileno,User user) throws Exception{		
		SubscriberVO svo = getSubscriberVO(mobileno, user);	
		try{
			String[] itemstatus = SubscriberDAO.GSUBS_STATE_VALID.split(",");			
			if(null != svo){	
				for (int j = 0; j < itemstatus.length; j++) {						
					if (itemstatus[j].equals(svo.getStatus())) {
						return svo;
					}
				}						
			}
		}catch(Exception e){
			throw new Exception("该号码[" + mobileno + "]没有找到有效用户：" + e.getMessage());
		}
		throw new Exception("该号码[" + mobileno + "]没有找到有效用户");
	}
	
	/***** 判断有效用户 *****/
	public static boolean chkValidSubs(String status,User user) throws Exception{			
		String[] itemstatus = SubscriberDAO.GSUBS_STATE_VALID.split(",");			
			
		for (int j = 0; j < itemstatus.length; j++) {						
			if (itemstatus[j].equals(status)) {
				return true;
			}
		}					
		return false;
	}
	
	/*****  判断有效用户 *****/
	public static boolean chkValidSubs(SubscriberVO svo,User user) throws Exception{		
		if(null != svo){
			return chkValidSubs(svo.getStatus(), user);
		}			
		return false;		
	}
	
	/***** 号码 -> 用户 *****/
	public static SubscriberVO getSubscriberVO(String mobileno,User user) throws Exception{		
		List list = getSubsidList(mobileno, user);		
		try{
			String[] itemstatus = SubscriberDAO.GSUBS_STATE_VALID.split(",");			
			if(null != list && list.size() > 0){			
				for(Iterator iter = list.iterator() ; iter.hasNext();){				
					SubscriberVO svo = (SubscriberVO) iter.next();
					if(null == svo || null == svo.getStatus()){
						continue;
					}
					for (int j = 0; j < itemstatus.length; j++) {						
						if (itemstatus[j].equals(svo.getStatus())) {
							return svo;
						}
					}
				}	
				return (SubscriberVO) list.get(0);
			}
		}catch(Exception e){
			throw new Exception("该号码[" + mobileno + "]没有找到用户：" + e.getMessage());
		}
		throw new Exception("该号码[" + mobileno + "]没有找到用户");
	}
	
	
	/***** 获取帐户标识 *****/
	public static Long getEboxidByServnum(String mobileno,User user) throws Exception{		
		try{	
			SubscriberDelegate delegate = new SubscriberDelegate();
			return delegate.GetAcctidByServnum( mobileno, user );						
		}catch(Exception e){
			throw new Exception("该号码[" + mobileno + "]没有找到帐户:" + e.getMessage());
		}
	}
	
	/***** 只获取有效用户标识 *****/
	public static Long getValidSubsid(String mobileno,User user) throws Exception{		
		SubscriberVO svo = getValidSubs(mobileno, user);
		try{			
			if(null != svo && null != svo.getSubsid()){
				return svo.getSubsid();
			}			
		}catch(Exception e){
			throw new Exception("该号码[" + mobileno + "]没有找到有效用户:" + e.getMessage());
		}
		throw new Exception("该号码[" + mobileno + "]没有找到有效用户");
	}
	
	/***** 只获取有效帐户标识 *****/
	public static Long getValidEboxid(String mobileno,User user) throws Exception{		
		SubscriberVO svo = getValidSubs(mobileno, user);
		try{			
			if(null != svo && null != svo.getAcctid()){
				return svo.getAcctid();
			}			
		}catch(Exception e){
			throw new Exception("该号码[" + mobileno + "]没有找到有效帐户:" + e.getMessage());
		}
		throw new Exception("该号码[" + mobileno + "]没有找到有效帐户");
	}
	
	
	
	/** 判断帐务周期是否已经出帐 **/
	public static void chkValidCyc(Long validbillcyc, User user) throws Exception {
		ValidBillCycVO validcycvo = null;
		try {
			ValidBillCycDelegate delegate = new ValidBillCycDelegate();
			validcycvo = delegate.doFindByPk(validbillcyc, user);
		} catch (Exception ex) {			
			throw new Exception("查找帐务周期[" + validbillcyc + "]出错：" + ex.getMessage());
		}
		if (null == validcycvo) {
			throw new Exception("帐务周期[" + validbillcyc + "]不存在");  
		}
		if (validcycvo.getState().intValue() == 1) {
			throw new Exception("帐务周期[" + validbillcyc + "]已经出帐");  
		}	
	}
	
	/** 判断是否有权限，不报错 **/
	public static boolean chkPurView(String purview, User user)  {		
		try {
			PurviewDelegate delegate = new PurviewDelegate();	
			return delegate.checkPurview(user.getOpercode(),purview);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/** 判断是否有本地市权限，不报错 user.cityid 为数字,且非999(广东用户) **/
	public static boolean chkPurView(User user,String cityid)  {		
		return AccountingUtils.getCityid(user.getCityid())
			.equals(AccountingUtils.getCityid(cityid)) && !user.isProvinceUser();
	}
	
	/***** 获取有效用户标识,无有效标识返回第一个 *****/
	public static  Long getSubsidByServnumber(String mobileno, User user) throws Exception {
		try{
			SubscriberDelegate delegate = new SubscriberDelegate();
			return delegate.GetSubsidByServnum( mobileno, user );
		}catch (Exception ex) {
			throw new Exception("该号码[" + mobileno + "]没有找到用户:" + ex.getMessage());
		}		
	}
	
	/***** 获取有效用户标识,无有效标识返回第一个 *****/
	public static  Long getSubsidByServnumber(String mobileno, User user,boolean exception) throws Exception {
		try{
			Long subsid = getSubsidByServnumber(mobileno, user);
			if(subsid == null){
				throw new Exception();
			}
			return subsid;
		}catch (Exception ex) {
			if(exception){
				throw new Exception("该号码[" + mobileno + "]没有找到有用户:" + ex.getMessage());
			}else{
				return null;
			}
		}
	}
	
	/***** 返回用户的品牌标识 *****/
	public static String getBrandBySubsid(Long subsid, User user) throws Exception {
		SubscriberVO vo = null;
		try{
			SubscriberDelegate delegate = new SubscriberDelegate();
			vo = delegate.doFindByPk(subsid, user);				
		}catch (Exception ex) {		
			throw new Exception("该用户[" + subsid + "]不存在:" + ex.getMessage());			
		} 
		if(vo == null){
			throw new Exception("该用户[" + subsid + "]不存在!");
		}
		if(null == vo.getBrand() || "".equals(vo.getBrand())){
			throw new Exception("该用户[" + subsid + "]品牌Brand不存在!");
		}
		return vo.getBrand();
	}
	
	/***** 返回有效帐本科目 *****/
	public static EBoxUnitVO getValidEboxUnit(Long eboxunitid, User user) throws Exception {
		
		EBoxUnitVO ebuvo = getEboxUnit(eboxunitid, user);				
		
		if(null == ebuvo.getEboxunitstate() || ebuvo.getEboxunitstate().intValue() != 1){
			throw new Exception("帐本科目标识[" + eboxunitid + "]不可用!");
		}		
		
		return ebuvo;
	}
	
	
	
	
	/***** 返回帐本科目 *****/
	public static EBoxUnitVO getEboxUnit(Long eboxunitid, User user) throws Exception {
		EBoxUnitVO ebuvo = null;
		if(null == eboxunitid){
			throw new Exception("帐本科目标识[ null ]不存在!");	
		}
		try{			
			EBoxUnitDelegate delegate = new EBoxUnitDelegate();
			ebuvo = (EBoxUnitVO) delegate.doFindByPk(eboxunitid, EBoxUnitVO.class, user);
		}catch(Exception e){
			e.printStackTrace();	
			throw new Exception("查找帐本科目标识[" + eboxunitid + "]出错!");	
		}
		if(null == ebuvo){
			throw new Exception("帐本科目标识[" + eboxunitid + "]不存在!");				
		}				
		
		return ebuvo;
	}
	
	/***** 返回有效帐本科目 *****/
	public static EBoxUnitVO getEboxUnit(String eboxunitid, User user) throws Exception {
		Long _eboxunitid = null;
		try{
			_eboxunitid = new Long(eboxunitid);	
		}catch(Exception e){
			e.printStackTrace();	
			throw new Exception("帐本科目标识[" + eboxunitid + "]出错!");	
		}
		return getEboxUnit(_eboxunitid, user);		
	}
	
	/***** 返回有效帐本科目 *****/
	public static EBoxUnitVO getValidEboxUnit(String eboxunitid, User user) throws Exception {
		Long _eboxunitid = null;
		try{
			_eboxunitid = new Long(eboxunitid);	
		}catch(Exception e){
			e.printStackTrace();	
			throw new Exception("帐本科目标识[" + eboxunitid + "]出错!");	
		}
		return getValidEboxUnit(_eboxunitid, user);		
	}
	
	/***** 获取实时产品类信息 *****/
	public static RealProdVO getRealProd(String prodid, String brand, User user) throws Exception {
		try{
			if(null == brand || "".equals(brand) 
					|| null == prodid || "".equals(prodid)){
				throw new Exception("品牌标识或者产品标识为空!");
			}	
			CommonDelegate delegate = new  	CommonDelegate(RealProdVO.class);	
			RealProdVO rpvo = new RealProdVO(); 
			rpvo.setBrand(brand);
			rpvo.setProdid(prodid);	
			rpvo = (RealProdVO) delegate.doFindByPk(rpvo, user);	
				
			return rpvo;
		}catch(Exception e){
			throw new Exception("判断实时产品[" + brand + "][" + prodid +"]出错：" + e.getMessage());
		}	
	}
	
	/***** 判断是否是实时产品 *****/
	public static String chkRealProd(String mobileno,String prodid, String brand, User user) throws Exception {
		try{

			RealProdVO rpvo = getRealProd(prodid, brand, user);
			if(null != rpvo){
				
				String nosub = rpvo.getServnumambit();
				if(null != nosub && !"".equals(nosub.trim())
						&& null != mobileno && !"".equals(mobileno.trim())){
					
					String[] items = StringSplit.split(nosub, "~");					
					
					for(int i = 0; i < items.length; i++){						
						
						String mobileno_sub = mobileno.substring(0,items[i].length());
						
						if(items[i].trim().equals(mobileno_sub.trim())){
							System.out.println("处理类型： " + rpvo.getDealtype());
							return rpvo.getDealtype().toString();
						}						
					}
					return ELSE_PROD;
				}
				return rpvo.getDealtype().toString();
			}				
			return ELSE_PROD;
		}catch(Exception e){
			throw new Exception("判断实时产品[" + brand + "][" + prodid +"]出错：" + e.getMessage());
		}	
	}
	
	/***** 判断是否是实时产品 *****/
	public static String chkRealProd(SubscriberVO svo, User user) throws Exception {					
		if(svo == null){
			throw new Exception("品牌标识和产品标识为空!");
		}			
		return chkRealProd(svo.getServnumber(), svo.getProid(), svo.getBrand(), user);
	}
	
	/***** 判断是否是实时产品 *****/
	public static String chkRealProd(String subsid, User user) throws Exception {				
		return chkRealProd(getSubscriber(subsid, user), user);
	}
	

	
	/***** 转换user的cityid *****/
	public static User getNewUser(User user, String cityid) {
		User newUser = new User();
		try {
			BeanUtils.copyProperties(newUser, user);
			newUser.setCityid(cityid);
		} catch (Exception ex) {
			log.error("转换user出错: ",ex);
		}
		return newUser;
	}
	
	
	
	
	
	
	/** 连接账本串 **/
	public static String appendEboxStr(Long eboxunitid, Long eboxunitdetid,
			String isdet, Long chgamt, Date starttime,Date stoptime,
			String reason, String reason2, Long yxplanid , String opercode) throws Exception {
		
		try{
			if(null == eboxunitid){
				throw new Exception("账本标识不能为空!");
			}
			if(null == eboxunitdetid){
				throw new Exception("账本明细标识不能为空!");
			}
			if(null == chgamt){
				throw new Exception("变更金额不能为空!");
			}
			if(null == yxplanid){
				yxplanid = new Long(-1);
			}
			
			StringBuffer strb = new StringBuffer();			
			strb.append(eboxunitid.toString()).append(CHUANF)
				.append(eboxunitdetid.toString()).append(CHUANF)
				.append(isdet).append(CHUANF)
				.append(chgamt.toString()).append(CHUANF)
				.append(PublicUtils.utilDateToStr(starttime)).append(CHUANF)
				.append(PublicUtils.utilDateToStr(stoptime)).append(CHUANF)
				.append(reason).append(CHUANF)
				.append(reason2).append(CHUANF)
				.append(yxplanid.toString()).append(CHUANF)
				.append(opercode);
			
			return strb.toString();
			
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);	
			throw new Exception("账本串连接失败,参数有问题:" + ex.getMessage(),ex);
		}
	}
	
	/***** 获取迁移表信息 tablename 全小写 *****/
	public static TansTableInfoVO getTansTableInfo(String tablename,User user) throws Exception{
		try{
			if(null == tablename || "".equals(tablename.trim())){
				throw new Exception("表名为空!");			
			}	
			CommonDelegate delegate = new CommonDelegate(TansTableInfoVO.class);					
			return (TansTableInfoVO) delegate.doFindByPk(tablename.toLowerCase(),user);		

		}catch(Exception e){
			throw new Exception("查找数据迁移信息表名[" + tablename + "]出错：" + e.getMessage());
		}		
	}
	
	/***** 判断是否是数据迁移 *****/
	public static boolean isTransTable(String tablename, User user) throws Exception {
		TansTableInfoVO vo =  getTansTableInfo(tablename, user);
		if(null != vo){
			return true;
		}
		return false;				
	}
	
	public static boolean isQueryHistoryDB(User user) throws Exception {

		 // 当否已实施数据迁移值设置为“0 否”时，只对生产库进行操作即可
		 // 应用程序在判断发生LVM接管后，不再对历史库进行操作
		 // 
		 //                  参数类型    参数标识      参数值说明
		 // 是否已实施数据迁移	 common     1          0 否；1 是 ；默认设置为“0 否”
		 // 是否已发生LVM接管   common     2          0 否；1 是 ；默认设置为“0 否”	
		
		boolean removeFlag = false; //是否已实施数据迁移标识
		boolean lvmFlag = false; //是否已发生LVM接管标识
		
		SysparamDelegate delegate;
		try {
			delegate = new SysparamDelegate();
			SysparamVO sysparavo = new SysparamVO();
			//是否已实施数据迁移
			sysparavo.setParamtype("common");
			sysparavo.setSystemid(new Long(1));
			sysparavo = (SysparamVO) delegate.doFindByPk(sysparavo, user);
			if(sysparavo!=null&&sysparavo.getParamvalue().equals("1")){
				removeFlag = true;
			}
			//是否已发生LVM接管
			sysparavo.setParamtype("common");
			sysparavo.setSystemid(new Long(2));
			sysparavo = (SysparamVO) delegate.doFindByPk(sysparavo, user);
			if(sysparavo!=null&&sysparavo.getParamvalue().equals("1")){
				lvmFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return removeFlag && (!lvmFlag);
	}
	
	
	
	/** 获取某个表的sequence  默认-200 为错误码*
	 * @throws Exception 
	 **/
	public static long _getSequence(String sequencename, User user) throws Exception{    	
    	
		StringBuffer sqlBuffer = new StringBuffer("select ").append(sequencename);
		sqlBuffer.append(".nextval from dual");
		
		ResultSet rs = null;
		long seq = -200;
		
		try{					
			rs = SqlUtils.getBSQLStatement( sqlBuffer.toString(), user.getCityid()).executeQuery();
			
			if( rs != null && rs.next() ){
				seq = rs.getLong(1);
			}
		}catch(Exception ex){
			log.error("获取[" + sequencename + "]序列号出错: " + ex.getMessage(),ex);	
			throw ex;
		}finally{
			if( rs != null ){
				rs.close();
			}
		}
		return seq;
    }
	
	/** 获取某个表的sequence  默认-200 为错误码*
	 * @throws Exception 
	 **/
	public static long getSequence(String sequencename, User user) throws Exception{
    	
    	long sequence = _getSequence(sequencename,user);
    	if(sequence < 0){
    		throw new Exception( "获取[" + sequencename + "]日志标识出错: " + sequence );
    	}
    	return sequence;
    }
	
	/** 判断该品牌的余额类型是否存在  返回余额类型标识 **/
	public static int chkBalanceType(String brand, String eboxunitid, User user) throws Exception{    	
		
		BalanceTypeVO vo = null;
		try{
			CommonDelegate delegate = new CommonDelegate(BalanceTypeVO.class);
			vo = (BalanceTypeVO) delegate.doFindByPk(brand, user);	
		}catch(Exception ex){
			throw new Exception("该品牌[" + brand + "]账本对应余额类型不存在: " + ex.getMessage(),ex);
		}
		
		if(null == vo){
			throw new Exception("该品牌[" + brand + "]账本对应余额类型不存在!");
		}	
		for(int i = 1 ; i < 9 ; i++){
			Long _eboxunitid = (Long) BeanUtils.getProperty(vo, "eboxunitid" + i);
			if(null != _eboxunitid && eboxunitid.equals(_eboxunitid.toString())){
				return i;
			}	
		}
		throw new Exception("该品牌[" + brand + "]账本[" + eboxunitid + "]对应的余额类型不存在!");					
    }
	
	
	/** 获取该产品标识的记录信息 **/
	public static PcPpProductVO getProductByPK(String prodid, User user) throws Exception{    	
		
		PcPpProductVO vo = null;
		try{
			CommonDelegate delegate = new CommonDelegate(PcPpProductVO.class);
			vo = (PcPpProductVO) delegate.doFindByPk(prodid, user);	
		}catch(Exception ex){
			throw new Exception("该产品[" + prodid + "]未定义: " + ex.getMessage(),ex);
		}
		
		return vo;
    }
	
	/** 获取该产品标识的记录信息中的产品类型字段 **/
	public static String getProductType(String prodid, User user) throws Exception{    	
		
		PcPpProductVO vo = getProductByPK(prodid, user);			

		if(null != vo && null != vo.getProducttype()){
			return vo.getProducttype().trim(); 
		}
		return "";
    }
	
	/** 判断产品类型是否是集团产品 **/
	public static boolean chkGroupProd(String prodid, User user) throws Exception{    	
		
		String protype = getProductType(prodid, user);
		
		if(PROD_GRO.equals(protype)){
			return true;
		}
		return false;
    }
	
	/** 如果是集团产品，则替换帐户标识前3位为999作为客户标识 **/
	public static String chgGroCustid(String prodid, String eboxid, String custid, User user) throws Exception{    	
		
		boolean isgroup = chkGroupProd(prodid, user);
		if(isgroup){
			return "999" + eboxid.substring(3);
		}
		return custid;
    }
	
	
	/** 登记批量操作日志 **/
	public static void doBatchOper(String mobileno, String businame,
			String menupath, String memo, User user) throws Exception {
		try {
			BatchOperVO vo = new BatchOperVO();
			vo.setMobileno(mobileno);
			vo.setOpercode(user.getOpercode());
			vo.setOperdate(new Date(System.currentTimeMillis()));
			vo.setWayid(user.getWayid());
			vo.setBusiname(businame);
			vo.setMenupath(menupath);	
			vo.setMemo(memo);
			CommonDelegate delegate = new CommonDelegate(BatchOperVO.class);
			delegate.doCreate(vo, user);
		} catch (Exception ex) {
			log.error("登记批量操作日志失败: " + ex.getMessage(),ex);
			throw new Exception("登记批量操作日志失败: " + ex.getMessage(),ex);
		}
	}
	
	/** 根据用户找主号用户 **/
	public static long getMainSubs(SubscriberListVO listvo, User user) throws Exception {
		try {
			
			SubscriberDelegate delegate = new SubscriberDelegate();			
			return delegate.doQueryMainSubs(listvo, user);
		} catch (Exception ex) {
			log.error("根据用户找主号用户失败: " + ex.getMessage(),ex);
			throw new Exception("根据用户找主号用户失败: " + ex.getMessage(),ex);
		}
	}
	
	/** 根据用户标识找主号用户 **/
	public static long getMainSubs(String subsid, User user) throws Exception {
		
		SubscriberListVO listvo = new SubscriberListVO();
		listvo.set_ne_subsid(subsid);
		return getMainSubs(listvo, user);		
	}
	
	/** 判断改用户是不是主号用户 **/
	public static boolean chkMainSubs(long subsid, User user) throws Exception {
		
		long _subsid = getMainSubs(subsid + "", user);	
		System.out.println("_subsid, subsid: " + _subsid + " , " + subsid );
		
		if(_subsid != -1 && subsid != _subsid){
			return false;
		}
		return true;
	}
	
	/***** 获取集团帐户户标识 *****/
	public static  Long getGroEboxidByServnumber(String mobileno, User user) throws Exception {
		try{
			CommonDelegate delegate = new CommonDelegate(GroupSubscriberVO.class);
			GroupSubscriberListVO listVO = new GroupSubscriberListVO();
			listVO.set_se_billingnbr(mobileno);
			DataPackage dp = delegate.doQuery(listVO, user, false);
			if(dp == null || dp.getDatas() == null || dp.getDatas().size() == 0){
				throw new Exception("该号码[" + mobileno + "]没有找到用户");
			}
			GroupSubscriberVO vo = (GroupSubscriberVO) dp.toList(GroupSubscriberVO.class).get(0);
			return vo.getAcctid();
		}catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}		
	}
	
	/***** 判断红名单操作 的操作员权限 *****/
	public static void checksaferight(Date startdate, Date stopdate, User user, String highright, String lowright) throws Exception {
		
		PurviewDelegate delegatetmp = new PurviewDelegate();		
		if (!delegatetmp.checkPurview(user.getOpercode(),highright)) {
			if (delegatetmp.checkPurview( user.getOpercode(),lowright)) {
				String day = FEEUtils.getSysParamValue(82, user);
				long lateday = 0 ;
				if(day == null || "".equals(day)){
					lateday = 10;
				}else{
					lateday = Long.parseLong(day);
				}
               if(((stopdate.getTime()-startdate.getTime())/(1000*60*60*24)) > lateday){
            	   throw new Exception("延停天数不能大于" + lateday + "天！");
               }
			}else{
			    throw new Exception("你的权限不足，不能进行该操作!");          		
			}
		}		
	}
	
}
