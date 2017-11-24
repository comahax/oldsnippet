/**
 * auto-generated code
 * Tue Sep 01 14:28:15 CST 2009
 */
package com.gmcc.pboss.control.resource.comressmp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.cntycompany.CntycompanyVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackPriterInfo;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.compack.PackMobilePrinterInfo;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDAO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.cntycompany.Cntycompany;
import com.gmcc.pboss.control.channel.cntycompany.CntycompanyBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.web.sales.stockalarm.AlarmUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: ComressmpBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/jop/business/resource/comressmp/control/ComressmpBO"
*    name="Comressmp"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class ComressmpBO extends AbstractControlBean implements
		Comressmp {

	public ComressmpVO doCreate(ComressmpVO vo) throws Exception {
		try {
			ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
			// TODO set the pk */
			return (ComressmpVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(ComressmpVO vo) throws Exception {
		try {
			ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComressmpVO doUpdate(ComressmpVO vo) throws Exception {
		try {
			ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
			return (ComressmpVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public ComressmpVO doFindByPk(Serializable pk) throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		return (ComressmpVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(ComressmpDBParam params)
			throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		return dao.query(params);
	}
	/**
	 * ���������׿���Դ��;�ֶ�
	 */
	public void doUpdateBatchResuse(String comresid,String resuse)
	throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		ComressmpDBParam params=new ComressmpDBParam();
		params.set_se_comresid(comresid);
		DataPackage data=dao.query(params);
		List<ComressmpVO> list=data.getDatas();
		for(ComressmpVO vo:list){
//			vo.setResuse(resuse);
			this.doUpdate(vo);
		}
	}
	/**
	 * ���������׿������ֶ�
	 */
	public void doUpdateBatchStorarea(String comresid,String storarea)throws Exception{
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		ComressmpDBParam params=new ComressmpDBParam();
		params.set_se_comresid(comresid);
		DataPackage data=dao.query(params);
		List<ComressmpVO> list=data.getDatas();
		for(ComressmpVO vo:list){
//			vo.setStorarea(storarea);
			//this.doUpdate(vo);
		}
	}
	/**
	 * ���������׿��ִ������ֶ�
	 */
	public void doUpdateBatchBoxnum(String[] items)throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		ComressmpDBParam params=new ComressmpDBParam();
		params.set_se_comresid(items[0]);
		DataPackage data=dao.query(params);
		List<ComressmpVO> list=data.getDatas();
		for(ComressmpVO vo:list){
			vo.setBoxnum(items[1]);
			//this.doUpdate(vo);
		}
	}

	public DataPackage doStat(ComressmpDBParam params) throws Exception {
		// TODO Auto-generated method stub
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		params.setSelectFieldsString("countyid,wayid,brand,comcategory,comstate,ncount");
		params.setDataOnly(true);
		int count=0;//�ϼ�
		
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.comressmp.doStat", params);
		if(dp != null && dp.getDatas() != null){
			List list = dp.getDatas();
			List<ComressmpTableVO> tableList = new LinkedList<ComressmpTableVO>();
			
			for(Iterator itt = list.iterator(); itt.hasNext();){
				Map map = (Map)itt.next();
				ComressmpTableVO vo = new ComressmpTableVO();
				vo.setCountyid((String) map.get("countyid"));
				vo.setWayid((String) map.get("wayid"));
				vo.setBrand((String) map.get("brand"));
				vo.setComcategory((String) map.get("comcategory"));
				vo.setComstate( ""+map.get("comstate"));				
				vo.setNcount((String) map.get("ncount"));
				count += Integer.parseInt(vo.getNcount());
				tableList.add(vo);
			}
			
			int countyCount = 1;
			int wayCount = 1;
			int brandCount = 1;
			int comcateCount = 1;
			ComressmpTableVO vo = null;
			List<ComressmpTableVO> tableList2 = new ArrayList<ComressmpTableVO>();
			ComressmpTableVO prevVO = new ComressmpTableVO();
			for(int i =0; i<tableList.size(); i++){
				ComressmpTableVO nextVO = tableList.get(i);
				if(nextVO.getCountyid().equals(prevVO.getCountyid())){
					countyCount++;
						vo = tableList2.get(i-countyCount+1);
						vo.setCountyCount(countyCount);
					if(nextVO.getWayid().equals(prevVO.getWayid())){
						wayCount++;
						vo = tableList2.get(i-wayCount+1);
						vo.setWayCount(wayCount);
						if(nextVO.getBrand().equals(prevVO.getBrand())){
							brandCount++;
							vo = tableList2.get(i-brandCount+1);
							vo.setBrandCount(brandCount);
							if(nextVO.getComcategory().equals(prevVO.getComcategory())){
								comcateCount++;
								vo = tableList2.get(i-comcateCount+1);
								vo.setComcateCount(comcateCount);
								if(nextVO.getComstate().equals(prevVO.getComstate())){
									
								}else{
									BeanUtils.copyProperties(prevVO, nextVO);
									tableList2.add(this.rebuildVO(nextVO, 5));
									continue;
								}
							}else{
								BeanUtils.copyProperties(prevVO, nextVO);
								tableList2.add(this.rebuildVO(nextVO, 4));
								comcateCount= 1;
								continue;
							}
						}else{
							BeanUtils.copyProperties(prevVO, nextVO);
							tableList2.add(this.rebuildVO(nextVO, 3));	
							brandCount=1;
							comcateCount= 1;
							continue;
						}
					}else{
						BeanUtils.copyProperties(prevVO, nextVO);
						tableList2.add(this.rebuildVO(nextVO, 2));
						wayCount=1;
						brandCount=1;
						comcateCount= 1;
						continue;
					}
				}else{
					BeanUtils.copyProperties(prevVO, nextVO);
					tableList2.add(this.rebuildVO(nextVO, 1));
					countyCount=1;
					wayCount=1;
					brandCount=1;
					comcateCount= 1;
					continue;
				}
			}
			
//			if(tableList.size()>1){
//				if(countyCount>1){
//					ComressmpTableVO nextVO = tableList.get(tableList.size()-countyCount);
//					nextVO.setCountyCount(countyCount);
//				}
//				if(wayCount>1){
//					ComressmpTableVO nextVO = tableList.get(tableList.size()-wayCount);
//					nextVO.setWayCount(wayCount);
//				}
//				if(brand>1){
//					ComressmpTableVO nextVO = tableList.get(tableList.size()-brandCount);
//					nextVO.setBrandCount(brandCount);
//				}
//			}
			
			
			dp.setRowCount(count);//��Ϊ����Ҫ��ҳ������DP�����Ա���ͳ������
			dp.setDatas(tableList2);
			
		}
		return dp;
	}
	
	public ComressmpTableVO rebuildVO(ComressmpTableVO vo,int num) throws Exception{
		ComressmpTableVO tempvo = new ComressmpTableVO();
		BeanUtils.copyProperties(tempvo, vo);
		switch (num) {
			case 6: 
				BeanUtils.setProperty(tempvo, "comstate", "");
			case 5:
				BeanUtils.setProperty(tempvo, "comcategory", "");
			case 4:
				BeanUtils.setProperty(tempvo, "brand", "");
			case 3:
				BeanUtils.setProperty(tempvo, "wayid", "");				
			case 2:
				BeanUtils.setProperty(tempvo, "countyid", "");
			case 1:				
				break;
		}
		return tempvo;
	}
	
	public DataPackage doQueryBySqlName(String sqlName,DBQueryParam param) throws Exception{
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class,user);
		return dao.queryByNamedSqlQuery(sqlName, param);
	}

	public DataPackage doGetTrunksOrBoxesForPrint(ComressmpDBParam param,
			String mode) throws Exception {
		
		ComressmpDAO dao = (ComressmpDAO)DAOFactory.build(ComressmpDAO.class, user);
		List list = dao.doQueryTrunksOrBoxesForPrint(param);
		DataPackage resultDp = new DataPackage();
		if(list == null || list.size() <= 0) {
			throw new JOPException("���׿���Դ���ݣ������������������");
		} else {
			Way wayBO = (Way)BOFactory.build(WayBO.class, user);
			Com comBO = (Com)BOFactory.build(ComBO.class, user);
			Map<String,Object[]> map = new HashMap<String,Object[]>();
			for(int i=0;i<list.size();i++) {
				Object[] ret = (Object[])list.get(i);
				// ����
				String packagenum = (String)ret[0];
				// ��Ʒ��ʶ
				Long comid = (Long)ret[1];
				// ������ʶ
				String wayid = (String)ret[2];
				// �����״�ʹ��ʱ��
				Date comactive = (Date)ret[3];
				// ����
				Integer amount = ((Long)ret[4]).intValue();
				String[] packArray = StringUtils.split(packagenum,"-");
				if(packArray.length != 3) {
					throw new JOPException("����"+packagenum+"������[��-��-��]��ʽ�淶���޷�ʶ�����");
				}
				if(StringUtils.isEmpty(wayid))
					throw new JOPException("�޷���ȡ��Դ��������(����="+packagenum+")");
				if(StringUtils.isEmpty(comid+"")) {
					throw new JOPException("�޷���ȡ��Ʒ��ʶ(����="+packagenum+")");
				}
				// �ŵ�map�е�keyֵ(��� ���� ����-�У�)
				String keynumber = "";
				if("trunk".equals(mode))
					keynumber = packArray[0];
				else if("box".equals(mode))
					keynumber = packArray[0] + "-" + packArray[1];
				// ������ ���� ����-�У��Ƿ���MAP�д���
				if(map.containsKey(keynumber)) {
					// ������ڣ����ۼ�����=ԭ����+��Ʒ����
					Object[] values = map.get(keynumber);
					values[1] = (Integer)values[1] + amount;
				}else {
					// ���������������MapԪ��	
					
					WayVO wayVO = wayBO.doFindByPk(wayid);
					Cntycompany cntyBO = (Cntycompany)BOFactory.build(CntycompanyBO.class, user);
					// �ֹ�˾Id
					String countyid = wayVO.getCountyid();
					if(StringUtils.isEmpty(countyid))
						throw new Exception("�޷���ȡ����("+wayVO.getWayid()+wayVO.getWayname()+")"+"�ķֹ�˾ID");
					CntycompanyVO cntyVO = cntyBO.doFindByPk(countyid);
					// �ֹ�˾����
					String countyname = cntyVO.getCountycompname();
					ComVO comVO = comBO.doFindByPk(comid);
					String comname = comVO.getComname();
					Object[] values = {comname,amount,countyname,comactive};
					map.put(keynumber, values);
				}
			}
			List<CompackPriterInfo> datas = new ArrayList<CompackPriterInfo>();
			for(Iterator<String> it = map.keySet().iterator();it.hasNext();) {
				String number = it.next();
				Object[] values = map.get(number);
				CompackPriterInfo info = new CompackPriterInfo();
				if("trunk".equals(mode)) {
					info.setTrunk_number(number);
				} else if("box".equals(mode)) {
					String[] numbers = StringUtils.split(number,"-");
					info.setTrunk_number(numbers[0]);
					info.setBox_number(numbers[1]);
				}
				info.setComname((String)values[0]);
				info.setAmount((Integer)values[1]);
				info.setCountyname((String)values[2]);
				info.setComactiveDate((Date)values[3]);
				datas.add(info);
			}
			resultDp.setDatas(datas);
			resultDp.setRowCount(datas.size());
		}
		
		return resultDp;
	}

	public DataPackage doGetPackagesForPrint(ComressmpDBParam param)
			throws Exception {
		
		Sysparam sysBO = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String maxPrintPagesizeStr = sysBO.doFindByID(43L, "pboss_fx");
		if(StringUtils.isEmpty(maxPrintPagesizeStr))
			maxPrintPagesizeStr = "50";
		// ���δ�ӡ���ҳ��
		int maxPrintPagesize = Integer.parseInt(maxPrintPagesizeStr);
		String _ssw_boxnum = param.get_ssw_boxnum();
		if(!StringUtils.isEmpty(_ssw_boxnum))
			param.set_ssw_boxnum(_ssw_boxnum+"-");
		param.set_pagesize("0");
		param.set_orderby("boxnum");
		DataPackage crsDp = this.doQuery(param);
		param.set_ssw_boxnum(_ssw_boxnum);
		if(crsDp.getRowCount() <= 0) {
			throw new JOPException("���׿���Դ���ݣ������������������");
		}
		
		int size_flag = 0; 
		PackMobilePrinterInfo info = null;
		List<String> mobileno = null;
		List<PackMobilePrinterInfo> datas = new ArrayList<PackMobilePrinterInfo>();
		String temp_boxnum = "";
		for(Iterator it = crsDp.getDatas().iterator();it.hasNext();) {
			ComressmpVO crsVO = (ComressmpVO)it.next();
			if(size_flag == 0) 
				temp_boxnum = crsVO.getBoxnum();
			if(!temp_boxnum.equals(crsVO.getBoxnum())) {
				size_flag = 0;
				temp_boxnum = crsVO.getBoxnum();
			}
			if(size_flag++ % 20 == 0) {
				info = new PackMobilePrinterInfo();
				mobileno = new ArrayList<String>();
				info.setPack_number(temp_boxnum);
				info.setMobileno(mobileno);
				datas.add(info);
			}
			mobileno.add(crsVO.getComresid());
		}
		int realPrintPagesize = new Double(Math.ceil((double)datas.size()/12.0)).intValue();
		if(realPrintPagesize > maxPrintPagesize)
			throw new Exception("��ӡ����Ԥ��Ϊ["+realPrintPagesize+"]ҳ���������ҳ��["+maxPrintPagesize+"]�����޸��������ٴ�ӡ��");
		DataPackage resultDp = new DataPackage();
		resultDp.setDatas(datas);
		resultDp.setRowCount(datas.size());
		return resultDp;
	}
	 /**
     * �������κͰ��Ų�ѯ�׿���Դ���ȡ���������
     * @param param
     * @return
     * @throws Exception
     */
    public Integer doMaxInsideseq(ComressmpDBParam param)throws Exception {
    	ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
    	return dao.doMaxInsideseq(param);
    }
	public Integer doStatSMPStock(String countyid, String comcategory)
			throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
		ComressmpDBParam params = new ComressmpDBParam();
		params.getQueryConditions().put("countyid", countyid);
		params.getQueryConditions().put("comcategory",comcategory);
		Integer result = (Integer)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.resource.comressmp.doStatSMPStock", params);
		return result;
	}
	
	public DataPackage doStatCountyQty() throws Exception {
		ComressmpDAO dao = (ComressmpDAO) DAOFactory.build(ComressmpDAO.class, user);
		ComressmpDBParam params = new ComressmpDBParam();
		params.setSelectFieldsString("countyid,brand,Qty");
		params.set_pagesize("0");
		params.setDataOnly(true);
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.resource.comressmp.doStatCountyQty",params);
		return dp;
	}

	public ResultVO doBoxNumUpdate(String line, User user, int rowCount)
			throws Exception {
		ResultVO resultVO = new ResultVO();
		try{
			Comressmp ComressmpBO = (Comressmp) BOFactory.build(ComressmpBO.class, user);
			//��Դ���|����|����|
			String items[] = AlarmUtils.getStrArr(StringUtils.splitPreserveAllTokens(line, "|"));
			ComressmpDBParam fristParams=new ComressmpDBParam();
			fristParams.set_se_batchno(items[1]);
			fristParams.set_se_boxnum(items[2]);
			/*//���ݺ�������θ����׿���Դ��(IM_FX_COMRESSMP)�İ������Ϊ�ա�
			ComressmpDBParam fristParams=new ComressmpDBParam();
			fristParams.set_se_batchno(items[1]);
			fristParams.set_se_comresid(items[0]);
			List<ComressmpVO> fristList=ComressmpBO.doQuery(fristParams).getDatas();
			for(ComressmpVO vo:fristList){
				vo.setInsideseq(null);
				ComressmpBO.doUpdate(vo);
			}*/
			
			ComressmpDBParam params=new ComressmpDBParam();
			params.set_se_comresid(items[0]);
			params.set_se_batchno(items[1]);
			DataPackage data=ComressmpBO.doQuery(params);
			List<ComressmpVO> list=data.getDatas();
			if(list == null || list.size()<=0)
				throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|��Ʒ�����ݲ�����|");
			if(list.size()>1)
				throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|��Ʒ��Դ��Ψһ|");
			
			Compack compackBO = (Compack) BOFactory.build(CompackBO.class, user);
			Comcategoryrela comcategoryrelaBO = (Comcategoryrela) BOFactory.build(ComcategoryrelaBO.class, user);
			//��Ʒ����|����|
			
			CompackVO oldCompackVO=null;
			CompackVO newCompackVO=null;
			for(ComressmpVO vo:list){
				if(vo.getComstate()!=1 && vo.getComstate()!=30 )
					throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|����״̬����ȷ|");
				Serializable pkVO=new CompackVO();
				BeanUtils.setProperty(pkVO, "batchno", vo.getBatchno());//��Ʒ����
				BeanUtils.setProperty(pkVO, "boxnum", vo.getBoxnum());//����
				oldCompackVO=compackBO.doFindByPk(pkVO);
				if(oldCompackVO!=null){//����
					if(!"1".equals(oldCompackVO.getPackstate())	&&	!"30".equals(oldCompackVO.getPackstate()))
						throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|ԭ��Ʒ��״̬����ȷ|");
				}else{
					throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|ԭ��Ʒ����Ϣ������|");
				}
				//�׿���Ʒ��ʶ��ѯ��Ʒ������Ϲ�ϵ��
				ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
				comcategoryrelaDBParam.set_ne_comid(String.valueOf(vo.getComid()));
				List comcategoryrelas=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();
				ComcategoryrelaVO comcategoryrelaVO=(ComcategoryrelaVO)comcategoryrelas.get(0);
				
				Serializable pkVOnew=new CompackVO();
				BeanUtils.setProperty(pkVOnew, "batchno", items[1]);//��Ʒ����
				BeanUtils.setProperty(pkVOnew, "boxnum", items[2]);//����
				newCompackVO=(CompackVO)compackBO.doFindByPk(pkVOnew);
				if(newCompackVO==null){//������
					newCompackVO=new CompackVO();
					//��Ʒ��������׿���Ʒ��ʶ��ѯ��Ʒ������Ϲ�ϵ���ȡ
					newCompackVO.setComcategory(comcategoryrelaVO.getComcategory());
					//��״̬�����������������ŶΣ�����ǰ��λ��ȡ�׿���Դ���ԣ�
					newCompackVO.setPackstate(String.valueOf(vo.getComstate()));
					newCompackVO.setWayid(vo.getWayid());
					newCompackVO.setNosect(items[0].substring(0,3));
					//��Դ��;����������ȡԭ�����ݣ����ʱ��Ϊ��ǰʱ�䣬��Ʒ����ȡ0�����������գ�
					newCompackVO.setResuse(oldCompackVO.getResuse());
					newCompackVO.setStorarea(oldCompackVO.getStorarea());
					newCompackVO.setPacktime(new Date());
					newCompackVO.setAmount(Short.valueOf("1"));
					
					newCompackVO.setBatchno(items[1]);
					newCompackVO.setBoxnum(items[2]);
					compackBO.doCreate(newCompackVO);
					//�����׿���Դ����
					vo.setBoxnum(items[2]);
					//�������κͰ��Ų�ѯ�׿���Դ���ȡ��������ţ��������ȡ�����ż�һ
					vo.setInsideseq(ComressmpBO.doMaxInsideseq(fristParams)+1);
					ComressmpBO.doUpdate(vo);
					//ԭ��Ʒ����Դ�����ݼ��������Դ��Ϊ�㣬��ɾ����Ʒ������
					oldCompackVO.setAmount((short)(oldCompackVO.getAmount()-1));
					if(oldCompackVO.getAmount() == 0){
						compackBO.doRemoveByVO(oldCompackVO);
					}else{
						compackBO.doUpdate(oldCompackVO);
					}
					
				}else{//����
					if(!"1".equals(newCompackVO.getPackstate())	&&	!"30".equals(newCompackVO.getPackstate())){
						throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|����Ʒ��״̬����ȷ|");
					}else{
						//�жϺ��������Ʒ���������Ƿ�һ�£�������Ʒ���ࡢ������ʶ����Ʒ״̬��
						if(comcategoryrelaVO.getComcategory().equals(newCompackVO.getComcategory())&& vo.getWayid().equals(newCompackVO.getWayid())
								&& String.valueOf(vo.getComstate()).equals(newCompackVO.getPackstate())){
							if(!(newCompackVO.getBatchno().equals(oldCompackVO.getBatchno()) && newCompackVO.getBoxnum().equals(oldCompackVO.getBoxnum()))){
								//�����׿���Դ����
								vo.setBoxnum(items[2]);
								//�������κͰ��Ų�ѯ�׿���Դ���ȡ��������ţ��������ȡ�����ż�һ
								vo.setInsideseq(ComressmpBO.doMaxInsideseq(fristParams)+1);
								ComressmpBO.doUpdate(vo);
								//ԭ��Ʒ����Դ�����ݼ�
								oldCompackVO.setAmount((short)(oldCompackVO.getAmount()-1));
								if(oldCompackVO.getAmount() == 0){
									compackBO.doRemoveByVO(oldCompackVO);
								}else{
									compackBO.doUpdate(oldCompackVO);
								}
								//����Ʒ����Դ��������
								newCompackVO.setAmount((short)(newCompackVO.getAmount()+1));
								compackBO.doUpdate(newCompackVO);
							}
							
						}else{
							throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|�׿���Դ������Ʒ�� [��Ʒ����/����/״̬] ��Ϣ��һ��|");
						}
					}
				}
			}
			line = items[0]+"|"+items[1]+"|"+items[2]+"|  |";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line =  e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
			return resultVO;
	}
}
