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
 * ����ҵ�񹤾���,����2��ʹ�õĴ���,д������ͳһ����
 * @author mys
 * @version 1.0
 */
public class FEEUtils {
	//private final static String MZONE_MON_CARD = "101"; // �������⿨
	//private final static String MZONE_DAY_CARD = "102"; // �������⿨
	public final static String OCE_REAL_PROD = "1";  // ʵʱ����OCE��ʽ����
	public final static String REAL_PROD = "2";  // ʵʱ���ʷ�ʽ��������
	public final static String ELSE_PROD = "0";  // ��ʵʱ���ʷ�ʽ��������
	
	//private final static String[] SUBS_PROD_MZONE = new String[]{"101","102"};  // ���в�Ʒ��ʶ,1005Ϊ���۴��ڿ�
	//private final static String[] SUBS_PROD_SZX = new String[]{"201","202","203","204"};  // �����д��ڿ���Ʒ��ʶ
	
	
	private final static String BRANDMZONE  = "BrandMzone";
	private final static String BRANDSZX    = "BrandSzx";
	private final static String BRANDGOTONE = "BrandGotone";
	private final static String BRANDDZK    = "BrandDzk";
	
	private final static String PROD_PER  = "ProdType_Person";  //���˲�Ʒ
	private final static String PROD_FAL  = "ProdType_Family";	//��ͥ����Ʒ
	private final static String PROD_GRO  = "ProdType_Group";   //���Ų�Ʒ
	
	private final static String CHUANF = "~"; // 
	private static Logger log = Logger.getLogger(FEEUtils.class);
	
	//todo��ȡ�û���ǰ�����ʱ�(������ϸ)���ܶ�
	public static double getAllValidAmt( Long eboxid, Long eboxunitid, User user )
	throws Exception {
		double eboxAmt = getValidEboxAmt( eboxid, eboxunitid, user );
		double eboxDetAmt = getValidEboxDetAmt( eboxid, eboxunitid, user );
		return eboxAmt+eboxDetAmt;
	}
	
	//todo��ȡ�û���ǰ�����ʱ����
	public static double getValidEboxAmt( Long eboxid, Long eboxunitid, User user )
	throws Exception {
		return 0;
	}
	
	//todo��ȡ�û���ǰ�����ʱ����(���·���)
	public static double getValidEboxDetAmt( Long eboxid, Long eboxunitid, User user )
	throws Exception {
		return 0;
	}
	
	//todo�����˱���Ŀ���ͻ�ȡ��ǰ�����������ʱ��Ŀ����ܶ�(������ϸ)
	public static double getAllValAmtByType( Long eboxid, Short eboxunittype, User user )
	throws Exception {
		double eboxAmt = getEboxAmtByType( eboxid, eboxunittype, user );
		double eboxDetAmt = getValEboxDetAmtByType( eboxid, eboxunittype, user );
		return eboxAmt+eboxDetAmt;
	}
	
	//todo�����ʱ���Ŀ���ͻ�ȡ��ǰ�������ʱ��Ŀ��ý��
	public static double getEboxAmtByType( Long eboxid, Short eboxunittype, User user )
	throws Exception {
		return 0;
	}
	
	//todo�����ʱ���Ŀ���ͻ�ȡ��ǰ�������ʱ���ϸ�Ŀ��ý��
	public static double getValEboxDetAmtByType( Long eboxid, Short eboxunittype, User user )
	throws Exception {
		return 0;
	}
	
	//todo�����˱���Ŀ���ͻ�ȡ��ǰ�������ʱ���ϸ���ܶ�
	public static double getEboxDetAmtByType( Long eboxid, Short eboxunittype, User user )
	throws Exception {
		return 0;
	}
	
	/**
	 * �ж��û�״̬�Ƿ���Ч(�������˲�Ʒ�ͼ��Ų�Ʒ)
	 * @param status
	 * @return
	 */
	public static boolean checkValSubsAll( String status )
	throws Exception {
		boolean val = true;
		
		if( status==null || "".equals(status) ){
			throw new Exception( "�û�״̬Ϊ��" );
		}
		
		if( SubscriberDAO.GSUBS_STATE_VALID
				.indexOf(status) == -1 ){
			val = false;
		}
		
		return val;
	}
	
	/**
	 * �����û���ʶ�ж��û��Ƿ񶯸еش��û�
	 * @return
	 * @throws Exception
	 */
	public static boolean valMZoneUsrBySubs( Long subsid, User user )
	throws Exception {
		boolean val = false;
		
		if( subsid == null || "".equals(subsid) ){
			throw new Exception( "�û���ʶ����Ϊ��" );
		}
		
		SubscriberDAO dao = (SubscriberDAO) DAOFactory.build(
				SubscriberDAO.class, user.getCityid());
		SubscriberVO vo = (SubscriberVO)dao.findByPk( subsid );
		
		if( vo == null ){
			throw new Exception( "�û���ʶ["+subsid+"]û�ж�Ӧ�û�" );
		}
		
		// �ж��Ƿ񶯸еش��û�
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
			throw new Exception( "�û���Ʒ��ʶΪ��" );
		}
		
		return val;
	}
	

	/**
	 * ��ȡ������Ŀ������Ŀ����Ϊeboxunittype����Ŀ���
	 * @param cooperauid �����̱��
	 * @param eboxunittype ��Ŀ����
	 * @param user ����Ա��Ϣ
	 * @return amt ������Ŀ����Ϊeboxunittype�Ŀ����˱����
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
	
	/** ��ȡ���д��� mys**/	
	public static List getUpperGrade(User user){
		List upperGrade = new ArrayList();
		try {
			DisputeReasonDelegate delegate = new DisputeReasonDelegate();
			upperGrade = delegate.getAllUpperGrade(user);			
		} catch (Exception ex) {
			log.error("���Ҹû����������ʧ�ܣ�", ex);
		}
		return null != upperGrade ? upperGrade : new ArrayList() ;		
	}
		
	/** ��ȡ����ĳ�����������С�� mys**/	
	public static List getLowGrade(String upperGrade, User user){
		List lowGrade = new ArrayList();
		if(null != upperGrade && !"".equals(upperGrade)){			
			try {
				DisputeReasonDelegate disDelegate = new DisputeReasonDelegate();				
				lowGrade = disDelegate.getLowByRsncode(upperGrade, user);					
			} catch (Exception ex) {				
				log.error("���Ҹû����������[" + upperGrade + "]��С��ʧ�ܣ�", ex);
			}
		}
		return null != lowGrade ? lowGrade : new ArrayList() ;		
	}
	
	/** ��ȡ����ĳ�������˿ںŵ���������ҵ������ mys**/	
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
////				log.error("���Ҹ������˿ں�[" + portid + "]����ҵ������ʧ�ܣ�", ex);
////			}
////		}
////		return null != busType ? busType : new ArrayList() ;		
//	}	
	
	/** ��黰���������ԭ���Ƿ���ڻ�������ԭ���IB_RE_DisputeRsn�� mys**/
	public static void chkUppergrade(String uppergrade, User user) throws Exception {
		try {	
			DisputeReasonDelegate delegate = new DisputeReasonDelegate();
			DisputeReasonVO vo = (DisputeReasonVO) delegate.doFindByPk(uppergrade, user);
			if (vo == null || vo.getGrade().intValue() != 0) {
				throw new Exception("");
			}
		} catch (Exception ex) {
			throw new Exception("�û����������[" + uppergrade + "]δ��ϵͳ��:" + ex.getMessage());
		}
	}
	
	/** ��黰������С���Ƿ���ڻ�������ԭ���IB_RE_DisputeRsn�� ���ظô���������� mys**/
	public static String chkLowGrade(String lowgrade, User user) throws Exception {		
		try {
			DisputeReasonDelegate delegate = new DisputeReasonDelegate();
			DisputeReasonVO vo = (DisputeReasonVO) delegate.doFindByPk(lowgrade, user);
			if (vo == null || vo.getGrade().intValue() != 1) {
				throw new Exception("");
			}
			return vo.getRsnattach();
		} catch (Exception ex) {
			throw new Exception("�û�������С��[" + lowgrade + "]δ��ϵͳ��:" + ex.getMessage());
		}		
	}
	
	/** �������С���Ƿ����ڸ�������ࣻ mys**/
	public static void isLowGBelong2UpG(String uppergrade,String lowgrade, User user) throws Exception {				
		chkUppergrade(uppergrade, user);
		String rsnattach = chkLowGrade(lowgrade, user);
		if (!uppergrade.equals(rsnattach)) {
			throw new Exception("�û�������С��[" + lowgrade + "]�����ڸû����������[" + uppergrade + "]");
		}
	}
	
	/** ���������˿ں��Ƿ��������������ϢIB_PS_MWCode���У���������Ч��ʧЧʱ����״̬�Ƿ���Ч�� mys**/
//	public static List chkPortid(String portid, User user) throws Exception {		
//		try {
//			HangbillDelegate delegate = new HangbillDelegate();
//			List list = delegate.getMWBusType(portid,user);
//			if (list == null || list.size() < 1){
//				throw new Exception("");
//			}
//			return list;
//		} catch (Exception ex) {
//			throw new Exception("�Ҳ����������˿�[" + portid + "]" + ex.getMessage());
//		}		
//	}	
	
	/** ���ݸ������˿ںż�������ҵ�����ͼ�����Ƿ��������������ϢIB_PS_MWCode���У���������Ч��ʧЧʱ����״̬�Ƿ���Ч��mys**/
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
//		throw new Exception("�����˿ں�[" + portid + "]������ҵ������[" + icptype + "]��ƥ��");		
	}
	
	/** ��ȡ����ϵͳ���� **/
	public static String getSysParamValue( int systemid, User user) throws Exception {
		return getSysParamValue(systemid, "billing", user);		
	}
	
	/** ��ȡ����ϵͳ���� **/
	public static String getCommSysParamValue( int systemid, User user) throws Exception {
		return getSysParamValue(systemid, "common", user);	
	}
	
	/** ��ȡ����ϵͳ���� **/
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
			throw new Exception("��ȡ" + systype + "ϵͳ����[" + systemid + "]����" + ex.getMessage());
		}	
	}
	
	/***** ��ȡΨһ�û� *****/
	public static SubscriberVO getSubscriber(String subsid,User user) throws Exception{
		Long _subsid = null;
		try{
			if(null == subsid || "".equals(subsid.trim())){
				throw new Exception("û���ҵ����û�!");	
			}
			_subsid = new Long(subsid);
		
		}catch(Exception e){
			throw new Exception("�����û�[" + subsid + "]����" + e.getMessage());
		}
		return getSubscriber(_subsid, user);		
	}
	
	/***** ��ȡΨһ�û� *****/
	public static SubscriberVO getSubscriber(Long subsid,User user) throws Exception{
		try{
			if(null == subsid){
				throw new Exception("û���ҵ����û�!");			
			}	
			CommonDelegate delegate = new  	CommonDelegate(SubscriberVO.class);					
			SubscriberVO svo = (SubscriberVO) delegate.doFindByPk(subsid,user);			
			if(null == svo ){
				throw new Exception("û���ҵ����û�!");															
			}
			return svo;		

		}catch(Exception e){
			throw new Exception("�����û�[" + subsid + "]����" + e.getMessage());
		}		
	}
	
	/***** ��ȡ�û���ʶ���� *****/
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
			throw new Exception("�ú���[" + mobileno + "]�ҵ��û���ʶ����" + e.getMessage());
		}
		return null;		
	}
	
	/***** ֻ��ȡ��Ч�û� *****/
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
			throw new Exception("�ú���[" + mobileno + "]û���ҵ���Ч�û���" + e.getMessage());
		}
		throw new Exception("�ú���[" + mobileno + "]û���ҵ���Ч�û�");
	}
	
	/***** �ж���Ч�û� *****/
	public static boolean chkValidSubs(String status,User user) throws Exception{			
		String[] itemstatus = SubscriberDAO.GSUBS_STATE_VALID.split(",");			
			
		for (int j = 0; j < itemstatus.length; j++) {						
			if (itemstatus[j].equals(status)) {
				return true;
			}
		}					
		return false;
	}
	
	/*****  �ж���Ч�û� *****/
	public static boolean chkValidSubs(SubscriberVO svo,User user) throws Exception{		
		if(null != svo){
			return chkValidSubs(svo.getStatus(), user);
		}			
		return false;		
	}
	
	/***** ���� -> �û� *****/
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
			throw new Exception("�ú���[" + mobileno + "]û���ҵ��û���" + e.getMessage());
		}
		throw new Exception("�ú���[" + mobileno + "]û���ҵ��û�");
	}
	
	
	/***** ��ȡ�ʻ���ʶ *****/
	public static Long getEboxidByServnum(String mobileno,User user) throws Exception{		
		try{	
			SubscriberDelegate delegate = new SubscriberDelegate();
			return delegate.GetAcctidByServnum( mobileno, user );						
		}catch(Exception e){
			throw new Exception("�ú���[" + mobileno + "]û���ҵ��ʻ�:" + e.getMessage());
		}
	}
	
	/***** ֻ��ȡ��Ч�û���ʶ *****/
	public static Long getValidSubsid(String mobileno,User user) throws Exception{		
		SubscriberVO svo = getValidSubs(mobileno, user);
		try{			
			if(null != svo && null != svo.getSubsid()){
				return svo.getSubsid();
			}			
		}catch(Exception e){
			throw new Exception("�ú���[" + mobileno + "]û���ҵ���Ч�û�:" + e.getMessage());
		}
		throw new Exception("�ú���[" + mobileno + "]û���ҵ���Ч�û�");
	}
	
	/***** ֻ��ȡ��Ч�ʻ���ʶ *****/
	public static Long getValidEboxid(String mobileno,User user) throws Exception{		
		SubscriberVO svo = getValidSubs(mobileno, user);
		try{			
			if(null != svo && null != svo.getAcctid()){
				return svo.getAcctid();
			}			
		}catch(Exception e){
			throw new Exception("�ú���[" + mobileno + "]û���ҵ���Ч�ʻ�:" + e.getMessage());
		}
		throw new Exception("�ú���[" + mobileno + "]û���ҵ���Ч�ʻ�");
	}
	
	
	
	/** �ж����������Ƿ��Ѿ����� **/
	public static void chkValidCyc(Long validbillcyc, User user) throws Exception {
		ValidBillCycVO validcycvo = null;
		try {
			ValidBillCycDelegate delegate = new ValidBillCycDelegate();
			validcycvo = delegate.doFindByPk(validbillcyc, user);
		} catch (Exception ex) {			
			throw new Exception("������������[" + validbillcyc + "]����" + ex.getMessage());
		}
		if (null == validcycvo) {
			throw new Exception("��������[" + validbillcyc + "]������");  
		}
		if (validcycvo.getState().intValue() == 1) {
			throw new Exception("��������[" + validbillcyc + "]�Ѿ�����");  
		}	
	}
	
	/** �ж��Ƿ���Ȩ�ޣ������� **/
	public static boolean chkPurView(String purview, User user)  {		
		try {
			PurviewDelegate delegate = new PurviewDelegate();	
			return delegate.checkPurview(user.getOpercode(),purview);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/** �ж��Ƿ��б�����Ȩ�ޣ������� user.cityid Ϊ����,�ҷ�999(�㶫�û�) **/
	public static boolean chkPurView(User user,String cityid)  {		
		return AccountingUtils.getCityid(user.getCityid())
			.equals(AccountingUtils.getCityid(cityid)) && !user.isProvinceUser();
	}
	
	/***** ��ȡ��Ч�û���ʶ,����Ч��ʶ���ص�һ�� *****/
	public static  Long getSubsidByServnumber(String mobileno, User user) throws Exception {
		try{
			SubscriberDelegate delegate = new SubscriberDelegate();
			return delegate.GetSubsidByServnum( mobileno, user );
		}catch (Exception ex) {
			throw new Exception("�ú���[" + mobileno + "]û���ҵ��û�:" + ex.getMessage());
		}		
	}
	
	/***** ��ȡ��Ч�û���ʶ,����Ч��ʶ���ص�һ�� *****/
	public static  Long getSubsidByServnumber(String mobileno, User user,boolean exception) throws Exception {
		try{
			Long subsid = getSubsidByServnumber(mobileno, user);
			if(subsid == null){
				throw new Exception();
			}
			return subsid;
		}catch (Exception ex) {
			if(exception){
				throw new Exception("�ú���[" + mobileno + "]û���ҵ����û�:" + ex.getMessage());
			}else{
				return null;
			}
		}
	}
	
	/***** �����û���Ʒ�Ʊ�ʶ *****/
	public static String getBrandBySubsid(Long subsid, User user) throws Exception {
		SubscriberVO vo = null;
		try{
			SubscriberDelegate delegate = new SubscriberDelegate();
			vo = delegate.doFindByPk(subsid, user);				
		}catch (Exception ex) {		
			throw new Exception("���û�[" + subsid + "]������:" + ex.getMessage());			
		} 
		if(vo == null){
			throw new Exception("���û�[" + subsid + "]������!");
		}
		if(null == vo.getBrand() || "".equals(vo.getBrand())){
			throw new Exception("���û�[" + subsid + "]Ʒ��Brand������!");
		}
		return vo.getBrand();
	}
	
	/***** ������Ч�ʱ���Ŀ *****/
	public static EBoxUnitVO getValidEboxUnit(Long eboxunitid, User user) throws Exception {
		
		EBoxUnitVO ebuvo = getEboxUnit(eboxunitid, user);				
		
		if(null == ebuvo.getEboxunitstate() || ebuvo.getEboxunitstate().intValue() != 1){
			throw new Exception("�ʱ���Ŀ��ʶ[" + eboxunitid + "]������!");
		}		
		
		return ebuvo;
	}
	
	
	
	
	/***** �����ʱ���Ŀ *****/
	public static EBoxUnitVO getEboxUnit(Long eboxunitid, User user) throws Exception {
		EBoxUnitVO ebuvo = null;
		if(null == eboxunitid){
			throw new Exception("�ʱ���Ŀ��ʶ[ null ]������!");	
		}
		try{			
			EBoxUnitDelegate delegate = new EBoxUnitDelegate();
			ebuvo = (EBoxUnitVO) delegate.doFindByPk(eboxunitid, EBoxUnitVO.class, user);
		}catch(Exception e){
			e.printStackTrace();	
			throw new Exception("�����ʱ���Ŀ��ʶ[" + eboxunitid + "]����!");	
		}
		if(null == ebuvo){
			throw new Exception("�ʱ���Ŀ��ʶ[" + eboxunitid + "]������!");				
		}				
		
		return ebuvo;
	}
	
	/***** ������Ч�ʱ���Ŀ *****/
	public static EBoxUnitVO getEboxUnit(String eboxunitid, User user) throws Exception {
		Long _eboxunitid = null;
		try{
			_eboxunitid = new Long(eboxunitid);	
		}catch(Exception e){
			e.printStackTrace();	
			throw new Exception("�ʱ���Ŀ��ʶ[" + eboxunitid + "]����!");	
		}
		return getEboxUnit(_eboxunitid, user);		
	}
	
	/***** ������Ч�ʱ���Ŀ *****/
	public static EBoxUnitVO getValidEboxUnit(String eboxunitid, User user) throws Exception {
		Long _eboxunitid = null;
		try{
			_eboxunitid = new Long(eboxunitid);	
		}catch(Exception e){
			e.printStackTrace();	
			throw new Exception("�ʱ���Ŀ��ʶ[" + eboxunitid + "]����!");	
		}
		return getValidEboxUnit(_eboxunitid, user);		
	}
	
	/***** ��ȡʵʱ��Ʒ����Ϣ *****/
	public static RealProdVO getRealProd(String prodid, String brand, User user) throws Exception {
		try{
			if(null == brand || "".equals(brand) 
					|| null == prodid || "".equals(prodid)){
				throw new Exception("Ʒ�Ʊ�ʶ���߲�Ʒ��ʶΪ��!");
			}	
			CommonDelegate delegate = new  	CommonDelegate(RealProdVO.class);	
			RealProdVO rpvo = new RealProdVO(); 
			rpvo.setBrand(brand);
			rpvo.setProdid(prodid);	
			rpvo = (RealProdVO) delegate.doFindByPk(rpvo, user);	
				
			return rpvo;
		}catch(Exception e){
			throw new Exception("�ж�ʵʱ��Ʒ[" + brand + "][" + prodid +"]����" + e.getMessage());
		}	
	}
	
	/***** �ж��Ƿ���ʵʱ��Ʒ *****/
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
							System.out.println("�������ͣ� " + rpvo.getDealtype());
							return rpvo.getDealtype().toString();
						}						
					}
					return ELSE_PROD;
				}
				return rpvo.getDealtype().toString();
			}				
			return ELSE_PROD;
		}catch(Exception e){
			throw new Exception("�ж�ʵʱ��Ʒ[" + brand + "][" + prodid +"]����" + e.getMessage());
		}	
	}
	
	/***** �ж��Ƿ���ʵʱ��Ʒ *****/
	public static String chkRealProd(SubscriberVO svo, User user) throws Exception {					
		if(svo == null){
			throw new Exception("Ʒ�Ʊ�ʶ�Ͳ�Ʒ��ʶΪ��!");
		}			
		return chkRealProd(svo.getServnumber(), svo.getProid(), svo.getBrand(), user);
	}
	
	/***** �ж��Ƿ���ʵʱ��Ʒ *****/
	public static String chkRealProd(String subsid, User user) throws Exception {				
		return chkRealProd(getSubscriber(subsid, user), user);
	}
	

	
	/***** ת��user��cityid *****/
	public static User getNewUser(User user, String cityid) {
		User newUser = new User();
		try {
			BeanUtils.copyProperties(newUser, user);
			newUser.setCityid(cityid);
		} catch (Exception ex) {
			log.error("ת��user����: ",ex);
		}
		return newUser;
	}
	
	
	
	
	
	
	/** �����˱��� **/
	public static String appendEboxStr(Long eboxunitid, Long eboxunitdetid,
			String isdet, Long chgamt, Date starttime,Date stoptime,
			String reason, String reason2, Long yxplanid , String opercode) throws Exception {
		
		try{
			if(null == eboxunitid){
				throw new Exception("�˱���ʶ����Ϊ��!");
			}
			if(null == eboxunitdetid){
				throw new Exception("�˱���ϸ��ʶ����Ϊ��!");
			}
			if(null == chgamt){
				throw new Exception("�������Ϊ��!");
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
			throw new Exception("�˱�������ʧ��,����������:" + ex.getMessage(),ex);
		}
	}
	
	/***** ��ȡǨ�Ʊ���Ϣ tablename ȫСд *****/
	public static TansTableInfoVO getTansTableInfo(String tablename,User user) throws Exception{
		try{
			if(null == tablename || "".equals(tablename.trim())){
				throw new Exception("����Ϊ��!");			
			}	
			CommonDelegate delegate = new CommonDelegate(TansTableInfoVO.class);					
			return (TansTableInfoVO) delegate.doFindByPk(tablename.toLowerCase(),user);		

		}catch(Exception e){
			throw new Exception("��������Ǩ����Ϣ����[" + tablename + "]����" + e.getMessage());
		}		
	}
	
	/***** �ж��Ƿ�������Ǩ�� *****/
	public static boolean isTransTable(String tablename, User user) throws Exception {
		TansTableInfoVO vo =  getTansTableInfo(tablename, user);
		if(null != vo){
			return true;
		}
		return false;				
	}
	
	public static boolean isQueryHistoryDB(User user) throws Exception {

		 // ������ʵʩ����Ǩ��ֵ����Ϊ��0 ��ʱ��ֻ����������в�������
		 // Ӧ�ó������жϷ���LVM�ӹܺ󣬲��ٶ���ʷ����в���
		 // 
		 //                  ��������    ������ʶ      ����ֵ˵��
		 // �Ƿ���ʵʩ����Ǩ��	 common     1          0 ��1 �� ��Ĭ������Ϊ��0 ��
		 // �Ƿ��ѷ���LVM�ӹ�   common     2          0 ��1 �� ��Ĭ������Ϊ��0 ��	
		
		boolean removeFlag = false; //�Ƿ���ʵʩ����Ǩ�Ʊ�ʶ
		boolean lvmFlag = false; //�Ƿ��ѷ���LVM�ӹܱ�ʶ
		
		SysparamDelegate delegate;
		try {
			delegate = new SysparamDelegate();
			SysparamVO sysparavo = new SysparamVO();
			//�Ƿ���ʵʩ����Ǩ��
			sysparavo.setParamtype("common");
			sysparavo.setSystemid(new Long(1));
			sysparavo = (SysparamVO) delegate.doFindByPk(sysparavo, user);
			if(sysparavo!=null&&sysparavo.getParamvalue().equals("1")){
				removeFlag = true;
			}
			//�Ƿ��ѷ���LVM�ӹ�
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
	
	
	
	/** ��ȡĳ�����sequence  Ĭ��-200 Ϊ������*
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
			log.error("��ȡ[" + sequencename + "]���кų���: " + ex.getMessage(),ex);	
			throw ex;
		}finally{
			if( rs != null ){
				rs.close();
			}
		}
		return seq;
    }
	
	/** ��ȡĳ�����sequence  Ĭ��-200 Ϊ������*
	 * @throws Exception 
	 **/
	public static long getSequence(String sequencename, User user) throws Exception{
    	
    	long sequence = _getSequence(sequencename,user);
    	if(sequence < 0){
    		throw new Exception( "��ȡ[" + sequencename + "]��־��ʶ����: " + sequence );
    	}
    	return sequence;
    }
	
	/** �жϸ�Ʒ�Ƶ���������Ƿ����  ����������ͱ�ʶ **/
	public static int chkBalanceType(String brand, String eboxunitid, User user) throws Exception{    	
		
		BalanceTypeVO vo = null;
		try{
			CommonDelegate delegate = new CommonDelegate(BalanceTypeVO.class);
			vo = (BalanceTypeVO) delegate.doFindByPk(brand, user);	
		}catch(Exception ex){
			throw new Exception("��Ʒ��[" + brand + "]�˱���Ӧ������Ͳ�����: " + ex.getMessage(),ex);
		}
		
		if(null == vo){
			throw new Exception("��Ʒ��[" + brand + "]�˱���Ӧ������Ͳ�����!");
		}	
		for(int i = 1 ; i < 9 ; i++){
			Long _eboxunitid = (Long) BeanUtils.getProperty(vo, "eboxunitid" + i);
			if(null != _eboxunitid && eboxunitid.equals(_eboxunitid.toString())){
				return i;
			}	
		}
		throw new Exception("��Ʒ��[" + brand + "]�˱�[" + eboxunitid + "]��Ӧ��������Ͳ�����!");					
    }
	
	
	/** ��ȡ�ò�Ʒ��ʶ�ļ�¼��Ϣ **/
	public static PcPpProductVO getProductByPK(String prodid, User user) throws Exception{    	
		
		PcPpProductVO vo = null;
		try{
			CommonDelegate delegate = new CommonDelegate(PcPpProductVO.class);
			vo = (PcPpProductVO) delegate.doFindByPk(prodid, user);	
		}catch(Exception ex){
			throw new Exception("�ò�Ʒ[" + prodid + "]δ����: " + ex.getMessage(),ex);
		}
		
		return vo;
    }
	
	/** ��ȡ�ò�Ʒ��ʶ�ļ�¼��Ϣ�еĲ�Ʒ�����ֶ� **/
	public static String getProductType(String prodid, User user) throws Exception{    	
		
		PcPpProductVO vo = getProductByPK(prodid, user);			

		if(null != vo && null != vo.getProducttype()){
			return vo.getProducttype().trim(); 
		}
		return "";
    }
	
	/** �жϲ�Ʒ�����Ƿ��Ǽ��Ų�Ʒ **/
	public static boolean chkGroupProd(String prodid, User user) throws Exception{    	
		
		String protype = getProductType(prodid, user);
		
		if(PROD_GRO.equals(protype)){
			return true;
		}
		return false;
    }
	
	/** ����Ǽ��Ų�Ʒ�����滻�ʻ���ʶǰ3λΪ999��Ϊ�ͻ���ʶ **/
	public static String chgGroCustid(String prodid, String eboxid, String custid, User user) throws Exception{    	
		
		boolean isgroup = chkGroupProd(prodid, user);
		if(isgroup){
			return "999" + eboxid.substring(3);
		}
		return custid;
    }
	
	
	/** �Ǽ�����������־ **/
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
			log.error("�Ǽ�����������־ʧ��: " + ex.getMessage(),ex);
			throw new Exception("�Ǽ�����������־ʧ��: " + ex.getMessage(),ex);
		}
	}
	
	/** �����û��������û� **/
	public static long getMainSubs(SubscriberListVO listvo, User user) throws Exception {
		try {
			
			SubscriberDelegate delegate = new SubscriberDelegate();			
			return delegate.doQueryMainSubs(listvo, user);
		} catch (Exception ex) {
			log.error("�����û��������û�ʧ��: " + ex.getMessage(),ex);
			throw new Exception("�����û��������û�ʧ��: " + ex.getMessage(),ex);
		}
	}
	
	/** �����û���ʶ�������û� **/
	public static long getMainSubs(String subsid, User user) throws Exception {
		
		SubscriberListVO listvo = new SubscriberListVO();
		listvo.set_ne_subsid(subsid);
		return getMainSubs(listvo, user);		
	}
	
	/** �жϸ��û��ǲ��������û� **/
	public static boolean chkMainSubs(long subsid, User user) throws Exception {
		
		long _subsid = getMainSubs(subsid + "", user);	
		System.out.println("_subsid, subsid: " + _subsid + " , " + subsid );
		
		if(_subsid != -1 && subsid != _subsid){
			return false;
		}
		return true;
	}
	
	/***** ��ȡ�����ʻ�����ʶ *****/
	public static  Long getGroEboxidByServnumber(String mobileno, User user) throws Exception {
		try{
			CommonDelegate delegate = new CommonDelegate(GroupSubscriberVO.class);
			GroupSubscriberListVO listVO = new GroupSubscriberListVO();
			listVO.set_se_billingnbr(mobileno);
			DataPackage dp = delegate.doQuery(listVO, user, false);
			if(dp == null || dp.getDatas() == null || dp.getDatas().size() == 0){
				throw new Exception("�ú���[" + mobileno + "]û���ҵ��û�");
			}
			GroupSubscriberVO vo = (GroupSubscriberVO) dp.toList(GroupSubscriberVO.class).get(0);
			return vo.getAcctid();
		}catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}		
	}
	
	/***** �жϺ��������� �Ĳ���ԱȨ�� *****/
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
            	   throw new Exception("��ͣ�������ܴ���" + lateday + "�죡");
               }
			}else{
			    throw new Exception("���Ȩ�޲��㣬���ܽ��иò���!");          		
			}
		}		
	}
	
}
