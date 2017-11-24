/**
 * 
 */
package com.sunrise.boss.ui.cms.adjustment;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.admin.operator.OperatorDelegate;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

/**
 * @author cx-yz
 *
 */
public class BatchAdjustmentCheck extends BaseCheckFormat {
	public static final String CH_ADT_ADJUST_COUNTY ="CH_ADT_ADJUST_COUNTY";//�ֹ�˾Ȩ�����ƣ������ܽ���˵����Ĭ�Ͼ����й�˾����
	public static final String FEES_SWITCH = "91";
	public static final String UPPEROPNID_SWITCH = "93";
	public static final String SYS_CHANNEL = "channel";
	private boolean iscountyonly = false;
	private String countyid = null;
	private boolean supportfees = false;
	private boolean supportupper = false;
	public BatchAdjustmentCheck(){
		super();
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user)
	throws Exception{
		if (null == line || "".equals(line)) {
			return;
		}
		if(rowCount==1){
			ACLDelegate acldelegate = new ACLDelegate(); 
			this.iscountyonly = acldelegate.checkPermission(user.getOpercode(), CH_ADT_ADJUST_COUNTY);
			OperatorDelegate odelegate = new OperatorDelegate();
    		this.countyid = odelegate.doQuerycountyid(user.getOpercode(), user);
    		if(this.iscountyonly && this.countyid==null){
    			throw new Exception("���ž��зֹ�˾��������CH_ADT_ADJUST_COUNTY�������Ŷ�Ӧ�ֹ�˾Ϊ��");
    		}
    		//�Ƿ�֧��������
    		SysparamDelegate sysparamDelegate = new SysparamDelegate();
        	SysparamListVO sysparamListVO = new SysparamListVO();
        	sysparamListVO.set_se_paramtype(SYS_CHANNEL);
        	sysparamListVO.set_ne_systemid(FEES_SWITCH);
        	DataPackage sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
        	if(sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0){
        		Iterator<SysparamVO> it = sysparamDP.getDatas().iterator();
        		if(it.hasNext()){
        			SysparamVO sysparamVO= it.next();
        			if(sysparamVO.getParamvalue()!=null && "1".equals(sysparamVO.getParamvalue())){
        				this.supportfees = true;
        			}
        		}        		
        	}
        	//�Ƿ�֧��ҵ�����
        	sysparamListVO.set_se_paramtype(SYS_CHANNEL);
        	sysparamListVO.set_ne_systemid(UPPEROPNID_SWITCH);
        	sysparamDP = sysparamDelegate.doQuery(sysparamListVO, user);
        	if(sysparamDP != null && sysparamDP.getDatas() != null && sysparamDP.getDatas().size() > 0){
        		Iterator<SysparamVO> it = sysparamDP.getDatas().iterator();
        		if(it.hasNext()){
        			SysparamVO sysparamVO= it.next();
        			if(sysparamVO.getParamvalue()!=null && "1".equals(sysparamVO.getParamvalue())){
        				this.supportupper = true;
        			}
        		}        		
        	}
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		if(this.supportfees){//֧��������			
			this.supportfeesCheck(items, user);			
		}else if(this.supportupper){//֧��ҵ�����
			this.supportupperCheck(items, user);
		}else{
			this.commonCheck(items, user);
		}
	}
	
	private void commonCheck(String[] items, User user) throws Exception{
		// �������
		if (items.length != 6) {
			throw new Exception("�ϴ�������������,ӦΪ5��,���ԡ�|����β����鿴�ļ���ʽ˵��!");
		}
		//�����������
		this.chechWayid(items[0], user);
		//�������·�
		this.chechMonth(items[1]);
		//���˰��
		this.chechTax(items[2]);
		//��齱��
		this.chechRpmoney(items[3]);
	}
	
	private void supportfeesCheck(String[] items, User user) throws Exception{
		// �������
		if (items.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ6��,���ԡ�|����β����鿴�ļ���ʽ˵��!");
		}
		//�����������
		this.chechWayid(items[0], user);
		//�������·�
		this.chechMonth(items[1]);
		//���˰��
		this.chechTax(items[2]);
		//��齱��
		this.chechRpmoney(items[3]);
		//���������
		this.chechFees(items[4]);
	}
	
	private void supportupperCheck(String[] items, User user)throws Exception{
		// �������
		if (items.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ6��,���ԡ�|����β����鿴�ļ���ʽ˵��!");
		}
		//�����������
		this.chechWayid(items[0], user);
		//�������·�
		this.chechMonth(items[1]);
		//���ҵ�����
		this.chechUpperopnid(items[2], user);
		//���˰��
		this.chechTax(items[3]);
		//��齱��
		this.chechRpmoney(items[4]);
	}
	
	private void chechUpperopnid(String upperopnid, User user)throws Exception{
		//���ҵ�����
		if(upperopnid==null || "".equals(upperopnid.trim())){
			throw new Exception("ҵ�������벻��Ϊ��");
		}else{
			OperationDelegate delegate = new OperationDelegate();
			OperationVO vo = delegate.doFindByPk(upperopnid.trim(), user);
			if(vo==null || vo.getOpnlevel()==null || vo.getOpnlevel()!=1){
				//ҵ����벻���ڡ�����ҵ�񼶱��ֶ�Ϊ�ա�����ҵ�񼶱���һ��
				throw new Exception("������Ч��ҵ��������");
			}
		}
	}
	
	private void chechWayid(String wayid, User user) throws Exception{
		//�����������
		if(wayid==null || "".equals(wayid.trim())){
			throw new Exception("�������벻��Ϊ��");
		}else{
			WayDelegate delegate = new WayDelegate();
			WayVO vo = delegate.doFindByPk(wayid, user);
			if(vo==null){
				throw new Exception("���������������������");
			}
			if(vo.getCityid()==null || !vo.getCityid().equals(SessionFactoryRouter.conversionCityid(user.getCityid()))){
				throw new Exception("�����������������뵱ǰ�����������в�һ��");
			}
			if(this.iscountyonly){
				if(vo.getCountyid()!=null){
					if(!this.countyid.equals(vo.getCountyid())){
						throw new Exception("���������Ӧ���������ֹ�˾�뵱ǰ���������ֹ�˾��һ�£���ǰ����ֻ���ϴ��������ֹ�˾������������");
					}
				}else{
					throw new Exception("���������Ӧ�ֹ�˾Ϊ��");
				}
			}
		}
	}
	
	private void chechMonth(String month) throws Exception{
		//�������·�
		if (month == null || "".equals(month.trim())) {
			throw new Exception("�����·ݲ���Ϊ��");
		} else if (!month.trim().matches("[0-9]{6}")) {
			throw new Exception("�����·ݸ�ʽ����ȷ������Ϊ6λ�����ָ�ʽ����ݼ��·ݣ���201208");
		} else {
			int year = Integer.parseInt(month.trim().substring(0, 4));
			int mon = Integer.parseInt(month.trim().substring(4));
			if (year < 1000 || mon < 1 || mon > 12) {
				throw new Exception("�����·ݸ�ʽ����ȷ�������·ݱ�������Ч��6λ���£���201208");
			}
		}
	}
	
	private void chechTax(String taxmoney)throws Exception {
		//���˰��
		if(taxmoney!=null && !"".equals(taxmoney.trim())){
			String s = taxmoney.trim();
			try{
				Double.parseDouble(s);
			}catch(NumberFormatException ex){
				throw new Exception("˰���ֶα��������֣����ܳ��ַ������ַ�");
			}			
			int index = s.indexOf(".");
			if(index!=-1){
				if(s.substring(index).length()>5){
					throw new Exception("˰���ֶ�С������������4λ");
				}
				if(s.substring(0, index).length()>6){
					throw new Exception("˰�����ֶ������������6λ");
				}
			}else{
				if(s.length()>6){
					throw new Exception("˰�����ֶ������������6λ");
				}
			}			
		}
	}
	
	private void chechRpmoney(String rpmoney)throws Exception{
		//��齱��
		if(rpmoney!=null && !"".equals(rpmoney.trim())){
			String s = rpmoney.trim();
			double jf = 0;
			try{
				jf = Double.parseDouble(s);
			}catch(NumberFormatException ex){
				throw new Exception("��������ֶα��������֣����ܳ��ַ������ַ�");
			}			
			int index = s.indexOf(".");
			if(index!=-1){
				if(s.substring(index).length()>5){
					throw new Exception("��������ֶ�С������������4λ");
				}
				if ((jf > 0 && s.substring(0, index).length() > 6)
						|| (jf < 0 && s.substring(0, index).length() > 7)) {
					throw new Exception("��������ֶ������������6λ");
				}
			}else{
				if((jf > 0 && s.length()>6) || (jf < 0 && s.length()>7)){
					throw new Exception("��������ֶ������������6λ");
				}
			}
			
		}
	}
	
	private void chechFees(String fees)throws Exception{
		//���������
		if(fees!=null && !"".equals(fees.trim())){
			String s = fees.trim();
			try{
				Double.parseDouble(s);
			}catch(NumberFormatException ex){
				throw new Exception("�������ֶα��������֣����ܳ��ַ������ַ�");
			}			
			int index = s.indexOf(".");
			if(index!=-1){
				if(s.substring(index).length()>5){
					throw new Exception("�������ֶ�С������������4λ");
				}
				if(s.substring(0, index).length()>6){
					throw new Exception("�������ֶ������������6λ");
				}
			}else{
				if(s.length()>6){
					throw new Exception("�������ֶ������������6λ");
				}
			}
		}
	}
}
