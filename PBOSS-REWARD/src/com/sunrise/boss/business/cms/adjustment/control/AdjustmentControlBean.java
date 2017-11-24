/**
* auto-generated code
* Fri Aug 17 16:14:58 CST 2012
*/
package com.sunrise.boss.business.cms.adjustment.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.apache.log4j.Logger;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentVO;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentDAO;
import com.sunrise.boss.business.cms.adjustment.persistent.AdjustmentListVO;
import com.sunrise.boss.business.cms.adjustment.persistent.VAdjustmentDAO;
import com.sunrise.boss.business.cms.adjustment.persistent.VAdjustmentListVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordDAO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchDAO;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamDAO;

/**
 * <p>Title: AdjustmentControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/adjustment/control/AdjustmentControlBean"
 name="AdjustmentControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AdjustmentControlBean extends AbstractControlBean
    implements AdjustmentControl {
	
	private static final Logger log = Logger.getLogger(AdjustmentControlBean.class);
	
	public static final Long SUBOPNID_REPOERT_ID = 94L;
	public static final String SYS_CHANNEL = "channel";

    public AdjustmentVO doCreate(AdjustmentVO vo, User user)
        throws Exception {
        try{
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
            // TODO  set the pk */
            return (AdjustmentVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(AdjustmentVO vo, User user)
        throws Exception {
        try{
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AdjustmentVO doUpdate(AdjustmentVO vo, User user)
        throws Exception {
        try{
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
            return (AdjustmentVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public AdjustmentVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
        return (AdjustmentVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(AdjustmentListVO params, User user)
        throws Exception {
			AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQuery(VAdjustmentListVO params, User user)
			throws Exception {
		VAdjustmentDAO dao = (VAdjustmentDAO) DAOFactory.build(VAdjustmentDAO.class, user);
		if(params.get_checked()==null || (params.get_checked()!=0 && params.get_checked()!=1) ){
			throw new Exception("[�Ƿ�˶�]ֻ֧���Ѻ˶Ժ�δ�˶Բ�ѯ");
		}
		int checked = params.get_checked();
		String namesql = null;
		if(checked==0){//�Ѻ˶�
			if(params.get_se_batchno()==null || "".equals(params.get_se_batchno().trim())){
				//�������β�ѯ����Ϊ�գ��Ѿ������κŵļ�¼���ܲ�ѯ��չʾ
				params.set_sql_batchno("batchno is null");
			}
			if(!params.suppertUpper()){//��֧��ҵ�����
				namesql = "com.sunrise.boss.business.cms.adjustment.persistent.doquery.checked";
			}else{//֧��ҵ�����
				namesql = "com.sunrise.boss.business.cms.adjustment.persistent.doquery.checked.withupperopnid";
			}			
		}else {//if(checked==1) δ�˶�
			if(!params.suppertUpper()){//��֧��ҵ�����
				namesql = "com.sunrise.boss.business.cms.adjustment.persistent.doquery.unchecked";
			}else{//֧��ҵ�����
				namesql = "com.sunrise.boss.business.cms.adjustment.persistent.doquery.unchecked.withupperopnid";
			}			
		}
		params.getQueryConditions().put("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return dao.queryByNamedSqlQuery(namesql, params);
	}
    
    //������湴ѡ�ĵ����������¼
    public String doSaveUnchecked(VAdjustmentListVO params, User user) throws Exception{
    	int retcount = 0;
    	String retinfo = null;
    	try{
    		String[] selectArray = params.get_selectitem();
        	if(!params.suppertUpper()){//�����֧��ҵ�����
        		retcount = this.doSaveNoUpperopnid(selectArray, user);         	
        	}else{
        		retcount = this.doSaveWithUpperopnid(selectArray, user);
        	}
        	retinfo = ""+retcount;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		retinfo = "-1:"+retcount+":"+ex.getMessage();
    	}    	
    	return retinfo;
    }
    //�����֧��ҵ�����
    private int doSaveNoUpperopnid(String[] selectArray,User user)throws Exception{
    	int retcount = 0;
    	AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
    	Session session = SessionUtil.currentSession(user.getCityid());
    	SQLQuery query = null;
    	List ret = null;
    	query = (SQLQuery)session.getNamedQuery("com.sunrise.boss.business.cms.adjustment.persistent.dosaveunchecked");
    	for(int i=0; i<selectArray.length; i++){
    		String[] info = selectArray[i].split("\\|");
    		query.setString("wayid", info[1]);
    		query.setString("rewardmonth", info[2]);
    		query.setString("countyid", info[3]);
    		ret = query.list();
    		for(Iterator it=ret.iterator();it.hasNext();){
    			Object[] obj = (Object[])it.next();
    			AdjustmentVO vo = new AdjustmentVO(obj[0].toString(),
    					obj[1].toString(),
    					obj[2].toString(),
    					(Double)obj[3]
    					);
    			vo.setConfirmoprcode(user.getOpercode());
    			vo.setConfirmptime(new Date());
    			dao.create(vo);
    			retcount++;
    		}
    	} 
    	return retcount;
    }
    //�����֧��ҵ�����
    private int doSaveWithUpperopnid(String[] selectArray,User user)throws Exception{
    	int retcount = 0;
    	AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
    	Session session = SessionUtil.currentSession(user.getCityid());
    	SQLQuery query = null;
    	List ret = null;
    	query = (SQLQuery)session.getNamedQuery("com.sunrise.boss.business.cms.adjustment.persistent.dosaveunchecked.withupperopnid");
    	for(int i=0; i<selectArray.length; i++){
    		String[] info = selectArray[i].split("\\|");
    		query.setString("wayid", info[1]);
    		query.setString("rewardmonth", info[2]);
    		query.setString("countyid", info[3]);
    		query.setString("upperopnid", info[4]);
    		ret = query.list();
    		for(Iterator it=ret.iterator();it.hasNext();){
    			Object[] obj = (Object[])it.next();
    			AdjustmentVO vo = new AdjustmentVO(obj[0].toString(),
    					obj[1].toString(),
    					obj[2].toString(),
    					obj[3].toString(),
    					(Double)obj[4]
    					);
    			vo.setConfirmoprcode(user.getOpercode());
    			vo.setConfirmptime(new Date());
    			dao.create(vo);
    			retcount++;
    		}
    	}
    	return retcount;
    }
    
    public String doSaveAllUnchecked(VAdjustmentListVO params, User user) throws Exception{
    	String retinfo = null;
    	try{
    		AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
    		int ret = dao.doSaveAllUnchecked(params, user);
    		retinfo = ""+ret;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		retinfo="-1:"+ex.getMessage();
    	}
    	return retinfo;
    }
    
    public String doDeleteAllChecked(VAdjustmentListVO params, User user) throws Exception{
    	String retinfo = null;
    	try{
    		AdjustmentDAO dao = (AdjustmentDAO) DAOFactory.build(AdjustmentDAO.class, user);
    		int ret = dao.doDeleteAllChecked(params, user);
    		retinfo = ""+ret;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		retinfo="-1:"+ex.getMessage();
    	}
    	return retinfo;
    }
    
    public String doCreatereport(VAdjustmentListVO params, User user) throws Exception{
    	try{
    		PaymentbatchDAO pdao = (PaymentbatchDAO)DAOFactory.build(PaymentbatchDAO.class, user);
        	AdjustmentDAO adao =(AdjustmentDAO)DAOFactory.build(AdjustmentDAO.class, user);
        	SysparamDAO sysdao = (SysparamDAO)DAOFactory.build(SysparamDAO.class, user);
        	
        	//��ȡ��channel��94��ϵͳ������ȷ�������Ƿ���Ҫ��ҵ��С��չʾ����
        	String sysvalue = sysdao.doFindByID(SUBOPNID_REPOERT_ID, SYS_CHANNEL);
        	if(sysvalue!=null && "1".equals(sysvalue)){//֧�ָ���ҵ��С��չʾ����
        		params.set_hassubopnidreport(sysvalue);
        	}else{//��֧�ָ���ҵ��С��չʾ����
        		params.set_hassubopnidreport("0");
        	}
        	String batchno = null;
        	try{//�������κ�
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            	String month = sdf.format(new Date());
            	String city = SessionFactoryRouter.conversionCityid(user.getCityid());//���б�ʶ�ַ�
            	Long sequence = (Long)adao.getSequence("CH_ADT_ADJUSTMENT_BATCHNO_SEQ");
            	if((sequence%1000)==0){//����λΪ000,ȡ��һ��ֵ
            		sequence = (Long)adao.getSequence("CH_ADT_ADJUSTMENT_BATCHNO_SEQ");
            	}
            	String reportseq = sequence.toString();
            	reportseq = reportseq.substring(reportseq.length()-3);
            	batchno = "C" + city + month + reportseq;
            	System.out.print("����֧�����κ�:"+batchno);
            	log.info("����֧�����κ�:"+batchno);
        	}catch(Exception ex){
        		ex.printStackTrace();
        		log.info("�������κ�ʧ�ܣ�ԭ��", ex);
        		throw new Exception("�������κ�ʧ�ܣ�ԭ��"+ex.getMessage());
        	}        	
        	//���³�������ϸch_adt_Dcord���е�ǰisflag=0��batchno is null����ϸ��¼
        	try{
            	int result = adao.doUpdatedcord(batchno, params, user.getOpercode());//params.get_se_countyid()
        		if(result>=0){
        			System.out.println("���³�������ϸ��ch_adt_Dcord��"+result+"������");
        			log.info("���³�������ϸ��ch_adt_Dcord��"+result+"������");
        		}
        		//�����޸ĵ�CH_ADT_DCORD���¼������CH_ADT_CITYRECORD���޸Ķ�Ӧ���ݵ�isflag״ֵ̬
        		//ʷ���� 20140217
        		//ȡ����ch_adt_cityrecord��״̬���޸ģ�����ǰ̨����ʱƵ������ʱ��3�°汾���ò����߼�Ǩ�Ƶ���̨��
//        		CityrecordDAO cityrecordDAO = (CityrecordDAO) DAOFactory.build(CityrecordDAO.class, user);
//        		int rows = cityrecordDAO.updateCityRecordIsflag(Short.parseShort("5"), batchno);
//        		if(rows>=0){
//        			System.out.println("���µ��г���ϴ���ϸ��CH_ADT_CITYRECORD��"+rows+"������");
//        			log.info("���µ��г���ϴ���ϸ��CH_ADT_CITYRECORD��"+rows+"������");
//        		}
        	}catch(Exception ex){
        		System.out.println("���³�������ϸ��ch_adt_Dcord����ʧ��");
        		log.info("���³�������ϸ��ch_adt_Dcord����ʧ��",ex);
				throw new Exception("���³�������ϸ������ʧ��");
        	}
        	//���¸������ݵ�����CH_ADT_ADJUSTMENT,��ȡCH_ADT_ADJUSTMENT����BATCHNO Ϊ�յļ�¼
        	try{
            	int result = adao.doUpdateadjustment(batchno, params);//params.get_se_countyid()
        		if(result>=0){
        			System.out.println("���¸������ݵ�����CH_ADT_ADJUSTMENT��"+result+"������");
        			log.info("���¸������ݵ�����CH_ADT_ADJUSTMENT��"+result+"������");
        		}
        	}catch(Exception ex){
        		System.out.println("���¸������ݵ�����CH_ADT_ADJUSTMENT����ʧ��");
        		log.info("���¸������ݵ�����CH_ADT_ADJUSTMENT����ʧ��",ex);
				throw new Exception("���¸������ݵ���������ʧ��");
        	}
        	//���������κŵ�ch_adt_Dcord��ϸ��¼���ܲ��뵽CH_ADT_PAYMENT��
        	try{        		
            	int result = adao.doCreatepayment(batchno, params);//params.get_se_countyid()
        		if(result>=0){
        			System.out.println("��𸶿��CH_ADT_PAYMENT���в���"+result+"������");
        			log.info("��𸶿��CH_ADT_PAYMENT���в���"+result+"������");
        		}
        	}catch(Exception ex){
        		System.out.println("��𸶿��CH_ADT_PAYMENT���в�������ʧ��");
        		log.info("��𸶿��CH_ADT_PAYMENT���в�������ʧ��",ex);
				throw new Exception("��𸶿����������ʧ��");
        	}
        	//��CH_ADT_PAYMENTBATCH�в����¼
        	PaymentbatchVO pvo = new PaymentbatchVO();
        	pvo.setCityid(Short.parseShort(user.getCityid()));
        	pvo.setPaymentflag((short)0);
        	pvo.setPaymentoprcode(user.getOpercode());
        	pvo.setPaymentoprtime(new Date());
        	pvo.setListflag((short)0);
        	pvo.setEndflag((short)0);
        	pvo.setBatchno(batchno);
        	if(params.isSupportPaymonth()){
        		pvo.setPaymonth(params.get_paymonth());
        	}
        	pdao.create(pvo);
        	    	
        	return batchno;
    	}catch(Exception ex){
    		ex.printStackTrace();
    		sessionContext.setRollbackOnly();
    		log.info("����֧������ʧ�ܣ����Ժ����ԣ�", ex);
    		throw new Exception("����֧������ʧ�ܣ����Ժ����ԣ�"+ex.getMessage());
    	}
    }
}
