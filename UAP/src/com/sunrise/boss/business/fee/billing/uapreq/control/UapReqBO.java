/**
 * 
 */
package com.sunrise.boss.business.fee.billing.uapreq.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

import com.sunrise.boss.business.fee.billing.checkplan.persistent.CheckPlanVO;
import com.sunrise.boss.business.fee.billing.checkserv.persistent.CheckServVO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqDAO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqDBParam;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqVO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapRuDownloadDAO;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapRuDownloadDBParam;
import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapRuDownloadVO;
import com.sunrise.jop.common.commoncontrol.CommonBO;
import com.sunrise.jop.common.commoncontrol.CommonControl;
import com.sunrise.jop.common.utils.lang.StringSplit;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


public class UapReqBO extends AbstractControlBean implements
		UapReq {

	public UapReqVO doCreate(UapReqVO vo)
			throws Exception {
		try {
			UapReqDAO dao = (UapReqDAO) DAOFactory.build(UapReqDAO.class, this.user);

			return (UapReqVO) dao.create(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void doRemove(UapReqVO vo) throws Exception {
		try {
			UapReqDAO dao = (UapReqDAO) DAOFactory.build(UapReqDAO.class, this.user);

			dao.remove(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public UapReqVO doUpdate(UapReqVO vo)
			throws Exception {
		try {
			UapReqDAO dao = (UapReqDAO) DAOFactory.build(UapReqDAO.class, this.user);

			return (UapReqVO) dao.update(vo);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public UapReqVO doFindByPk(Serializable pk)
			throws Exception {
		UapReqDAO dao = (UapReqDAO) DAOFactory.build(
				UapReqDAO.class, this.user);
		return (UapReqVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(UapReqDBParam params)
			throws Exception {
		UapReqDAO dao = (UapReqDAO) DAOFactory.build(
				UapReqDAO.class, this.user);
		return dao.query(params);
	}

	public void doSaveFixfeeReq(UapReqVO vo, String filename)
			throws Exception {
		FileInputStream fileInputStream = new FileInputStream(filename);
        InputStreamReader read = new InputStreamReader (fileInputStream, "gbk");
        BufferedReader rin=new BufferedReader(read);
        
        UapReqVO newvo = doCreate(vo); // 先登记请求表
        
        String line;
        int count = 0;
        while ((line = rin.readLine()) != null) {
            if (null != line && line.trim().length() > 0) {
                ++count;
                try{	               	
                	String[] items = StringSplit.split(line, "|");
                	CheckServVO servvo = new CheckServVO();
                	servvo.setLogid(newvo.getLogid());
                	servvo.setRegion(new Integer(user.getCityid()));
                	servvo.setServnumber(items[0]);
                	
                	CommonControl commonbo = (CommonControl)BOFactory.build(CommonBO.class, user);
                	commonbo.setVoClass(CheckServVO.class);
                	commonbo.doCreate(servvo);
                    
                }catch(Exception e){
                	throw new Exception("保存第"+ count +"行数据时出错"+e.getMessage());
                }
            }
        }
	}

	public void doSaveProdReq(UapReqVO vo, String filename)
			throws Exception {
		FileInputStream fileInputStream = new FileInputStream(filename);
        InputStreamReader read = new InputStreamReader (fileInputStream, "gbk");
        BufferedReader rin=new BufferedReader(read);
        
        UapReqVO newvo = doCreate(vo); // 先登记请求表
        
        String line;
        int count = 0;
        while ((line = rin.readLine()) != null) {
            if (null != line && line.trim().length() > 0) {
                ++count;
                try{	               	
                	String[] items = StringSplit.split(line, "|");
                	CheckPlanVO planvo = new CheckPlanVO();
                	planvo.setLogid(newvo.getLogid());
                	planvo.setBatch(newvo.getBatch());
                	planvo.setProdid(items[0]);
                	planvo.setProdname(items[1]);
                	planvo.setSubsid(new Long(items[2]));
                	planvo.setServnumber(items[3]);
                	planvo.setTariffitemid(items[4]);
                	planvo.setRegion(new Integer(user.getCityid()));
                	
                	CommonControl commonbo = (CommonControl)BOFactory.build(CommonBO.class, user);
                	commonbo.setVoClass(CheckPlanVO.class);
                	commonbo.doCreate(planvo);
                    
                }catch(Exception e){
                	throw new Exception("保存第"+ count +"行数据时出错"+e.getMessage());
                }
            }
        }
	}

//	@Override
	public UapRuDownloadVO getUploadPath(UapRuDownloadDBParam param) throws Exception {
		UapRuDownloadDAO dao = (UapRuDownloadDAO) DAOFactory.build(
				UapRuDownloadDAO.class, this.user);
		UapRuDownloadVO uapRuDownloadVO = (UapRuDownloadVO) dao.findByProperty("ruleId", param.get_se_req_ruleId());
		return uapRuDownloadVO;
	}
	
	public void doSaveReqAndRu(UapReqVO vo, UapRuDownloadVO uapRuDownloadVO)
			throws Exception {
        doCreate(vo); // 先登记请求表
        CommonControl commonbo = (CommonControl)BOFactory.build(CommonBO.class, user);
    	commonbo.setVoClass(UapRuDownloadVO.class);
    	commonbo.doUpdate(uapRuDownloadVO);
	}

}
