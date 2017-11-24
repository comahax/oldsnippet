package com.gmcc.pboss.biz.info.reward.cityrecord.action;

import java.util.ArrayList;
import java.util.List; 
import net.sf.json.JSONArray; 
import com.gmcc.pboss.biz.info.reward.cityrecord.service.CityrecordService;
import com.gmcc.pboss.biz.info.reward.cityrecord.support.CityrecordQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember; 
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.biz.info.node.model.Way;

public class CityrecordAction extends AbstractAction {
	//������ʽ���£���201307
	private static final String YEAR_MONTH = "[1-9]{1}[0-9]{3}((0[1-9]{1})|(1[012]{1}))";
	
	private List retlist;
	private double paytotal;

	private QueryParameter parameter;
	private CityrecordService cityrecordService; 
	@Override
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		parameter = parameter==null?new CityrecordQueryParameter():parameter;
		// ����ҳ�룬������ϸ��ѯʱʹ�ã�ͳ�ƻ��ܲ�ʹ��
		if (this.getPageNo() != null)
			parameter.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			parameter.setSize(getPageSize().intValue());// ���ô�С 
		
		LoginMember logMem = this.getMember();
		if(logMem.getIsnet()==1){//����ֻ�����ѯ��������Ϣ
			((CityrecordQueryParameter)parameter).setWayid(logMem.getWayid());
		}
		
		return parameter;
	}

	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	
	public String doView(){
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.CITYRECORD_STAT);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_CITYRECORD_STAT);
		}
		((CityrecordQueryParameter)this.getParameter()).setSupportPaymonth(cityrecordService.isSupportPaymonth());
		return SUCCESS;
	}
	
	
	private boolean isValidParam(CityrecordQueryParameter param){
		boolean supportPaymont = param.isSupportPaymonth();
		String month = param.getMonth();
		String paymonth = param.getPaymonth();
		String oprmonth   = param.getOprmonth();
		boolean flag = true;//���
		if(!supportPaymont){//��֧�ָ����·�
			param.setPaymonth(null); 
			if( (month==null || "".equals(month)) &&  (oprmonth==null ||  "".equals(oprmonth)) ){//�����·ݺ�ҵ������ͬʱΪ��
				this.addActionMessage("[�����·�]��[ҵ������]����ͬʱΪ��");
				flag = flag && false;
			}
			
			if(month!=null && !"".equals(month) && !month.matches(YEAR_MONTH)){//��Ϊ�գ�����ʽ������Ҫ��
				param.setMonth("");
				this.addActionMessage("[�����·�]��ʽ���ԣ�����Ϊ6Ϊ��Ч����");
				flag = flag && false;
			}
			
			if(oprmonth!=null && !"".equals(oprmonth) && !oprmonth.matches(YEAR_MONTH)){//��Ϊ�գ�����ʽ������Ҫ��
				param.setOprmonth("");
				this.addActionMessage("[ҵ������]��ʽ���ԣ�����Ϊ6Ϊ��Ч����");
				flag = flag && false;
			}
		}else{//֧�ָ����·�
			if( (month==null || "".equals(month)) && (paymonth==null || "".equals(paymonth)) && (oprmonth==null ||  "".equals(oprmonth)) ){//�����·ݺ͸����·�ͬʱΪ��
				this.addActionMessage("[�����·�]��[�����·�]��[ҵ������]����ͬʱΪ��");
				flag = flag && false;
			}
			if(month!=null && !"".equals(month) && !month.matches(YEAR_MONTH)){//��Ϊ�գ�����ʽ������Ҫ��
				param.setMonth("");
				this.addActionMessage("[�����·�]��ʽ���ԣ�����Ϊ6Ϊ��Ч����");
				flag = flag && false;
			}
			if(paymonth!=null && !"".equals(paymonth) && !paymonth.matches(YEAR_MONTH)){//��Ϊ�գ�����ʽ������Ҫ��
				param.setPaymonth("");
				this.addActionMessage("[�����·�]��ʽ���ԣ�����Ϊ6Ϊ��Ч����");
				flag = flag && false;
			}
			if(oprmonth!=null && !"".equals(oprmonth) && !oprmonth.matches(YEAR_MONTH)){//��Ϊ�գ�����ʽ������Ҫ��
				param.setOprmonth("");
				this.addActionMessage("[ҵ������]��ʽ���ԣ�����Ϊ6Ϊ��Ч����");
				flag = flag && false;
			}
		}
		return flag;
	}
	
	public String doStat(){
		if(this.getLogMember().getIsnet()!=4){//����
			this.setTitle(PageLoction.CITYRECORD_STAT);
		}else{//������Ա
			this.setTitle(PageLoction.MAG_CITYRECORD_STAT);
		}
		ServiceResult result = null;
		result = isLogin();
		
		CityrecordQueryParameter param = (CityrecordQueryParameter)this.getParameter();
		if(this.isValidParam(param)){//У������Ƿ���ȷ
			if(result.isSuccess()){
				result = this.cityrecordService.transact(getMember(), getParameter(), ServiceType.OTHER);
			}
			if(result.isSuccess()){
				this.retlist = result.getRetResult().getData();
				Object[] retObj = (Object[])result.getRetObject();
				//this.busitotal=busi_pay[0];
				this.paytotal=(Double)retObj[0];
				if(retObj[1]!=null){
					//CityrecordQueryParameter param = (CityrecordQueryParameter)this.parameter;
					Way way = (Way)retObj[1];
					param.setWayname(way.getWayname());
					param.setStarlevel(way.getStrStarlevel());
				}
			}else{
				//CityrecordQueryParameter param = (CityrecordQueryParameter)this.parameter;
				param.setWayname(null);
				param.setStarlevel(null);
				this.addActionMessage(result.getMessage());
			}
		}		
		return SUCCESS;
	}	

	public String doList(){
		return SUCCESS;
	}
	
	public String doAjax(){
		ServiceResult result = isLogin();
		if(result.isSuccess())
			result = this.cityrecordService.transact(getMember(), getParameter(), ServiceType.QUERY);
		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	
	/**
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {
		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("wayid", "�������"));
		setCols.add(new ColumnSet("wayname", "��������"));
		setCols.add(new ColumnSet("opnid", "ҵ�����"));
		setCols.add(new ColumnSet("opnname", "ҵ������"));
		setCols.add(new ColumnSet("rewardtypename", "�������"));
		setCols.add(new ColumnSet("mobile", "�ֻ������IMEI����"));
		setCols.add(new ColumnSet("oprtime", "ҵ����ʱ��"));
		setCols.add(new ColumnSet("busivalue", "ҵ������ҵ����"));
		setCols.add(new ColumnSet("paymoney", "����Ӧ�����"));
		return setCols;
	}
	 /**
	 * ����ҳ����ʾ��Ч��
	 * @return the colSet
	 */
	public String getShowCols(){
		return JSONArray.fromObject(getsetCols()).toString();
	}	
	
	public CityrecordService getCityrecordService() {
		return cityrecordService;
	}

	public List getRetlist() {
		return retlist;
	}

	public double getPaytotal() {
		return paytotal;
	}

	public void setCityrecordService(CityrecordService cityrecordService) {
		this.cityrecordService = cityrecordService;
	}
}
