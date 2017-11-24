/**
 * auto-generated code
 * Fri Oct 02 10:38:11 CST 2009
 */
package com.gmcc.pboss.control.resource.resdisform;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.waitreq.WaitreqVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;
import com.gmcc.pboss.business.communication.rcvobj.RcvobjVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.discomres.DiscomresVO;
import com.gmcc.pboss.business.resource.resdisform.ProductDetailDAO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDAO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformDBParam;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVO;
import com.gmcc.pboss.business.resource.resdisform.ResdisformVOHelper;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.waitreq.Waitreq;
import com.gmcc.pboss.control.channel.waitreq.WaitreqBO;
import com.gmcc.pboss.control.communication.advinfo.Advinfo;
import com.gmcc.pboss.control.communication.advinfo.AdvinfoBO;
import com.gmcc.pboss.control.communication.rcvobj.Rcvobj;
import com.gmcc.pboss.control.communication.rcvobj.RcvobjBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.resource.discomres.Discomres;
import com.gmcc.pboss.control.resource.discomres.DiscomresBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ResdisformBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResdisformBO extends AbstractControlBean implements
		Resdisform {

	public ResdisformVO doCreate(ResdisformVO vo) throws Exception {
		try {
			ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class, user);
			// TODO set the pk */
			return (ResdisformVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ResdisformVO vo) throws Exception {
		try {
			ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResdisformVO doUpdate(ResdisformVO vo) throws Exception {
		try {
			ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
			return (ResdisformVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ResdisformVO doFindByPk(Serializable pk) throws Exception {
		ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
		return (ResdisformVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ResdisformDBParam params)
			throws Exception {
		ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
		return dao.query(params);
	}
	
	/**�鿴��Ʒ��ϸ
     * @param discomcode �����̱��
     * @param disi	���䵥��
     */
    public DataPackage doQueryProductDetail(String discomcode,String disi,ResdisformDBParam params) throws Exception{

    	ProductDetailDAO dao = (ProductDetailDAO) DAOFactory.build(ProductDetailDAO.class,user);
    	Map conditionMap = new HashMap();
    	conditionMap.put("DISID", disi);
    	conditionMap.put("DISCOMCODE", discomcode);
    	params.setQueryConditions(conditionMap);
    	params.setSelectFieldsString("batchno,boxnum,comresid,comcategory");
    	return dao.doQuery(params);
    }
    
    //�������·��䵥״̬
    private void doUpdateState(String[] pk, ResdisformVOHelper voHelper) throws Exception{
    	String[] pkArray = null;
    	for(int i = 0;i<pk.length;i++){			
			pkArray = pk[i].split("\\|");
			ResdisformVO vo = new ResdisformVO();
			vo.setDiscomcode(pkArray[0]);
			vo.setDisid(pkArray[1]);
			vo = this.doFindByPk(vo);
			vo.setIssuecode(voHelper.getIssuecode());
			vo.setIssutime(voHelper.getIssutime());
			vo.setSmscontent(voHelper.getSmscontent());
			vo.setDisformstate("WAITISSUE");
			this.doUpdate(vo);
    	}
    }
    
    /**
     * ��������
     * @param pk	��������(��������,֮����|�ֿ�)
     * @param form	
     * @return
     * @throws Exception
     */
    public String batchUpdate(String[] pk,ResdisformVOHelper voHelper,List<String> employeeIDs) throws Exception {
    	int success = 0;
    	int fail = 0;
    	StringBuilder error = new StringBuilder(50);

    	//�Խ����е���Դ���䵥���ݽ����޸ģ������˹��š�����ʱ�䡢������������ȡ�������ݣ����䵥״̬ȡ������������
    	try{
    		ResdisformBO bo = (ResdisformBO)BOFactory.build(ResdisformBO.class,user);
    		bo.doUpdateState(pk,voHelper);
    	}catch(Exception e){
    		throw new JOPException(" ���·��䵥״̬ʱ����"+e.getMessage());
    	}
    		
    		
    		if("send".equals(voHelper.getIsSendSms())){
//    			�������֪ͨΪ��ѡ״̬������Ҫ���Ͷ���֪ͨ���������ݵ����Ŵ����ͱ�(CH_SMS_WAITREQ)��
//    			��������ȡ4�������ֻ�����ȡ�����ֻ����루����������룩����������ȡ����������ݡ�
    			Waitreq waitreqBO = (WaitreqBO) BOFactory.build(WaitreqBO.class,user);
    			Employee employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
    			for(String employeeid:employeeIDs){
    				try{
    					EmployeeVO employeeVO = employeeBO.doFindByPk(employeeid);
    					waitreqBO.doInsert(new Short("5"), voHelper.getSmscontent(), employeeVO.getOfficetel());
    				}catch(Exception e){
    					e.printStackTrace();   					
    				}
    			}
    			

//    		c��	����������Ϣ
//    		�������֪ͨΪ��ѡ״̬������Ҫ����������Ϣ���������ݵ�������Ϣ��(CH_PW_ADVINFO)����ϢIDȡ���У�����ȡ����Դ����[yyyyMMdd]����yyyyMMddΪ��ǰ���ڣ�
//    			������Ϣ����ȡ�������ݣ�����ȡ1���棻����ʱ��ȡ��ǰʱ�䣻�ƻ����ʱ�����գ�������Ч��ȡ��ǰʱ��+10�죻
//    			������������ȡ4�ض���Ա���Ƿ����֪ͨȡ1�ǣ��Ƿ���Ҫ����ȡ0�񣻷�������ȡ���淢���˹��ţ�״̬ȡ3�ѷ�����

    			AdvinfoVO advinfoVO = new AdvinfoVO();
    			
    			try{
    				Calendar calendar = Calendar.getInstance();
    				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    				Advinfo advinfoBO = (AdvinfoBO)BOFactory.build(AdvinfoBO.class,user);
    				
    				advinfoVO.setTitle("��Դ����["+format.format(calendar.getTime())+"]");
    				advinfoVO.setContent(voHelper.getSmscontent());
    				advinfoVO.setType(new Short("1"));
    				advinfoVO.setReleasetime(calendar.getTime());
    				calendar.add(Calendar.DAY_OF_MONTH, 10);
    				advinfoVO.setEnddate(calendar.getTime());
    				advinfoVO.setDesttype(new Short("4"));
    				advinfoVO.setSmsnotify(new Short("1"));
    				advinfoVO.setOprcode(voHelper.getIssuecode());
    				advinfoVO.setState(new Short("3"));
    				advinfoVO.setNdapproval(new Short("0"));
    				
    				advinfoVO = advinfoBO.doCreate(advinfoVO);
    				
    			}catch(Exception e){
    				e.printStackTrace();
    				error.append(" ������ʧ��:"+e.getMessage()).append("|");
    			}
    			
//        		�������ݵ����ն����(CH_PW_RCVOBJ)��������ʶȡ���У���ϢIDȡ����������Ϣ�������ʶȡ��Ա��ţ�����״̬Ϊ1�򿪣��鿴ʱ�����գ�״̬ʱ��ȡ��ǰʱ�䡣
    		
    				Rcvobj rcvobjBO = (RcvobjBO) BOFactory.build(RcvobjBO.class,user);
    				for(String employeeid:employeeIDs){
    					try{
    						RcvobjVO rcvobjVO = new RcvobjVO();
    						rcvobjVO.setAdvinfoid(advinfoVO == null ? null:advinfoVO.getAdvinfoid());
    						rcvobjVO.setObjid(employeeid);
    						rcvobjVO.setState(new Short("1"));
    						rcvobjVO.setStatetime(new Date());
    	    				rcvobjBO.doCreate(rcvobjVO);
    					}catch(Exception e){
    						e.printStackTrace();
    	    				error.append(" �������ݵ����ն���� ��ԱID ["+employeeid+"]:"+e.getMessage()).append("|");
    					}
    				}  			    			
    		}
    	return error.toString();
    }
    

    
    /**
     * ��������
     * @param item item[0]:�����̱��� item[1]:���� item[2]:����
     * @param ways �����б�
     * @param disid ���䵥��
     * @param storarea ��Դ����
     */
    public Map<String,String> doUpdate(String[] item,List<WayVO> ways,String disid,String storarea) throws Exception {
    	Compack compackBO = (CompackBO)BOFactory.build(CompackBO.class,user);
    	Discomres discomresBO = (DiscomresBO)BOFactory.build(DiscomresBO.class,user);
    	Map<String,String> categoryMap = new HashMap<String,String>();
    	
//    	int i = 0;
//		for(i = 0;i<ways.size();i++){
//			if(ways.get(i).getWayid().equals(item[0]))
//				break;
//		}
//		//��ѯ�����̱����Ƿ���������MAP�У����������ͨ����������������¼����ԭ�������̲����ڡ���
//		if(i==ways.size()){
//			throw new Exception ("������["+item[0]+"]������");
//		}
		
		//������Ʒ���Ρ����š���״̬�������䣩��ѯ��Ʒ����IM_PR_COMPACK��������޽�����¼����ԭ��δ������Ʒ�������ڡ���
//		����н������¹��������̺���Դ������������Ʒ��״̬Ϊ�������������������ݵ���������Դ��IM_PR_DISCOMRES����
		CompackDBParam compackParam = new CompackDBParam();
		compackParam.setQueryAll(true);
		compackParam.set_se_batchno(item[1]);
		compackParam.set_se_boxnum(item[2]);
		compackParam.set_se_packstate("30");
		DataPackage compackDP = compackBO.doQuery(compackParam);
		if( null == compackDP || null == compackDP.getDatas() || compackDP.getDatas().size() == 0){
			throw new Exception("δ������Ʒ��������");
		}
		for(int j = 0;j<compackDP.getDatas().size();j++){
			CompackVO compackVO = (CompackVO)compackDP.getDatas().get(j);
			compackVO.setDiscomcode(item[0]);
			compackVO.setStorarea(storarea);
			compackVO.setPackstate("31");
			
			DiscomresVO discomresVO = new DiscomresVO();
			discomresVO.setDiscomcode(item[0]);
			discomresVO.setBatchno(item[1]);
			discomresVO.setBoxnum(item[2]);
			discomresVO.setDisid(disid);
			discomresBO.doCreate(discomresVO);
			
			String count = categoryMap.get(compackVO.getComcategory());
			if( null != count){
				if( null != compackVO.getAmount()){
					categoryMap.put(compackVO.getComcategory(), Long.parseLong(count) + compackVO.getAmount().intValue()+"");
				}
			}else{
				categoryMap.put(compackVO.getComcategory(), compackVO.getAmount() == null ? "0":compackVO.getAmount().toString());
			}
		}
//		�׿���Դ���ݸ��£�������Ʒ���Ρ����š���״̬�������䣩��ѯ�׿���Դ��IM_FX_COMRESSMP����
//		����޽�����¼����ԭ���׿���Դ�����ڡ�������н���������Դ������������Ʒ״̬Ϊ������������
		Comressmp comressmpBO = (ComressmpBO)BOFactory.build(ComressmpBO.class,user);
		ComressmpDBParam comressmpParam = new ComressmpDBParam();
		comressmpParam.setQueryAll(true);
		comressmpParam.set_se_batchno(item[1]);
		comressmpParam.set_se_boxnum(item[2]);
		comressmpParam.set_ne_comstate(new Short("30"));
		
		DataPackage comressmpDP = comressmpBO.doQuery(comressmpParam);
		if( null == comressmpDP || null == comressmpDP.getDatas() || comressmpDP.getDatas().size() == 0){
			throw new Exception ("�׿���Դ������");
		}
		
		for(int k = 0;k<comressmpDP.getDatas().size();k++){
			ComressmpVO comressmpVO = (ComressmpVO)comressmpDP.getDatas().get(k);
			comressmpVO.setComstate(new Short("31"));
		}
		
		return categoryMap;
    }
    
    //ȡ�ò�ѯ������CH_PW_WAY������ȡ�������ϣ��������������ѯ������Ա������Ϣ��(CH_PW_EMPLOYEE)
    // ƥ���Ƿ�Ϊ�����ֶ�Ϊ�ǣ���ISNET=1����ƥ���ù�״̬Ϊ�ڸڣ���EMPSTATUS=0������ȡ���������������������ֻ����루����������룩
    public DataPackage doQueryEmployee(ResdisformDBParam params) throws Exception{
    	ResdisformDAO dao = (ResdisformDAO) DAOFactory.build(ResdisformDAO.class,user);
    	return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.resdisform.getemployee", params);
    }
}
