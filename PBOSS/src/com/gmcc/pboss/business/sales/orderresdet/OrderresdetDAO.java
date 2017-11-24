/**
 * auto-generated code
 * Tue Oct 13 15:13:34 CST 2009
 */
package com.gmcc.pboss.business.sales.orderresdet;

import java.util.HashMap;
import java.util.List;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderresdetDAO</p>
 * <p>Description: Data Access Object for CompanyVO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderresdetDAO extends AbstractDAO {

    /**
     * default constructor
     */
    public OrderresdetDAO(){
        super(OrderresdetVO.class);
    }
    /**
     * ��ѯ����Ʒ���࣬���Σ����ŷ��鶩����Դ��ϸ��Ϣ
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOrderresdetGroupView(OrderresdetDBParam param) throws Exception {
    	OrderresdetDBParam orderresdetDBParam=new OrderresdetDBParam();
    	param.setSelectFieldsString("comcategory,ordercomtype,batchno,boxnum");
    	param.getQueryConditions().put("orderid", param.get_se_orderid());
    	orderresdetDBParam.set_se_orderid(param.get_se_orderid());
    	param.set_se_orderid(null);
		DataPackage datas=queryByNamedSqlQuery("com.gmcc.pboss.business.sales.orderresdet.doQueryOrderresdetGroupView", param);
	    List<HashMap> list=datas.getDatas();
	   List<OrderresdetVO> orderresdetList=null;
	   String comresids="";
	    for(HashMap objMap:list){
	    	orderresdetDBParam.set_se_comcategory((String)objMap.get("comcategory"));
	    	if(objMap.get("boxnum")!=null)
	    		orderresdetDBParam.set_se_boxnum((String)objMap.get("boxnum"));
	    	else
	    		orderresdetDBParam.set_se_boxnum(null);
	    	orderresdetDBParam.set_se_batchno((String)objMap.get("batchno"));
	    	orderresdetDBParam.setQueryAll(true);
	    	orderresdetList=this.query(orderresdetDBParam).getDatas();
	    	comresids="";
	    	for(OrderresdetVO vo:orderresdetList){
	    		if("".equals(comresids)){
	    			if("EMPTYSIM".equals(vo.getRestype())){
	    				comresids=vo.getEmptyno();
	    			}else{
	    				comresids=vo.getComresid();
	    			}
	    			
	    		}else{
	    			if("EMPTYSIM".equals(vo.getRestype())){
	    				comresids+=","+vo.getEmptyno();
	    			}else{
	    				comresids+=","+vo.getComresid();
	    			}
	    		}
	    			
	    	}
	    	objMap.put("comresids", comresids);
	    }
	    param.set_se_orderid(orderresdetDBParam.get_se_orderid());
	    datas.setDatas(list);
		return datas;
	}
    	/**
	 * ��������Դ��ϸ���е����ݰ���Ʒ������з���ϼ�,ƴ���ַ���
	 * 
	 * @param params
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	public String groupbyDet(OrderresdetDBParam params, String orderid,DBAccessUser user)
			throws Exception {
		String desc="";
		// ��wayid װ�� count����������
		DataPackage myGroupby = groupbyDet(params, orderid);
		if(myGroupby.getRowCount()>0)
		{
			List<HashMap> myIt=myGroupby.getDatas();
			int cnt=0;
			for(HashMap objMap:myIt){
				if(objMap.get("comcategory")!=null && objMap.get("orderid")!=null){
					//����
					Dictitem dictitem = (DictitemBO) BOFactory
					.build(DictitemBO.class, user);
					DictitemVO dictitemVO=new DictitemVO();
					dictitemVO.setGroupid("IM_FXCOMCATEGORY");
					dictitemVO.setDictid((String)objMap.get("comcategory"));
					dictitemVO=dictitem.doFindByPk(dictitemVO);
					if(dictitemVO!=null)
					{
						desc+=dictitemVO.getDictname();
						desc+=objMap.get("orderid");
						if(dictitemVO.getDictname().indexOf("�׿�")!=-1)
						{
							desc+="��,";
						}else if(dictitemVO.getDictname().indexOf("��ֵ��")!=-1)
						{
							desc+="��,";
						}
					}
				}
			}
			if(!"".equals(desc) && desc.length()>0){
				desc=desc.substring(0,desc.length()-1);
			}
		}
		return desc;
	}
	
	/**
	 * ��������Դ��ϸ���е����ݰ���Ʒ������з���ϼ�
	 * 
	 * @param params
	 * 
	 * @return
	 * @throws Exception
	 */
	public DataPackage groupbyDet(OrderresdetDBParam params,String orderid)
			throws Exception {
		//��wayid װ�� count����������
		params.setSelectFieldsString("comcategory,orderid");
		params.getQueryConditions().put("orderid", orderid);
		return queryByNamedSqlQuery("sales.orderresdet.groupby", params);
	}
	
	
	
	/**
	 *  �Ƹ���Ʊ��ӡ ͳ�ƶ�����ϸ����
	 * @param params
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	public DataPackage groupbyordercomtype(OrderresdetDBParam params,String orderid)throws Exception {
		//��wayid װ�� sum����������
		params.setSelectFieldsString("restype,actprice");
		params.getQueryConditions().put("orderid", orderid);
		return queryByNamedSqlQuery("sales.orderresdet.groupbyordercomtype", params);
	}
	/**
	 *  �Ƹ���Ʊ��ӡ ͳ�ƶ�����ϸ����
	 * @param params
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	public DataPackage groupbyordercomtypeDetail(OrderresdetDBParam params,String orderid,String restype)throws Exception {
		//��wayid װ�� sum����������
		params.setSelectFieldsString("statistic,actprice,comcategory,comid");
		params.getQueryConditions().put("orderid", orderid);
		params.getQueryConditions().put("restype", restype);
		return queryByNamedSqlQuery("sales.orderresdet.groupbyordercomtypedetail", params);
	}
	/**
	 *  �Ƹ���Ʊ��ӡ ͳ�ƶ�����ϸ����
	 * @param params
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	public DataPackage groupbyordercomtypeKBSIMDetail(OrderresdetDBParam params,String orderid,String restype)throws Exception {
		//��wayid װ�� sum����������
		params.setSelectFieldsString("statistic,actprice");
		params.getQueryConditions().put("orderid", orderid);
		params.getQueryConditions().put("restype", restype);
		return queryByNamedSqlQuery("sales.orderresdet.groupbyordercomtypeKBSIMdetail", params);
	}
	
	
	/**
	 *  �Ƹ�ҵ�񵥴�ӡ
	 * @param params
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	public DataPackage groupbyordercomtypeBusiness(OrderresdetDBParam params,String orderid,String comcategory)throws Exception {
		//��wayid װ�� sum����������
		params.setSelectFieldsString("comprice");
		params.getQueryConditions().put("orderid", orderid);
		params.getQueryConditions().put("comcategory", comcategory);
		return queryByNamedSqlQuery("sales.orderresdet.groupbyordercomtypeBusiness", params);
	}
	

	
}
