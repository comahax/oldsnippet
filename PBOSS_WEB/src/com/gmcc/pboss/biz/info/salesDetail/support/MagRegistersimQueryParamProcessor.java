package com.gmcc.pboss.biz.info.salesDetail.support;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import com.gmcc.pboss.common.support.DefaultHqlQueryProcessor;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;

public class MagRegistersimQueryParamProcessor extends DefaultHqlQueryProcessor
		implements QueryParameterProcessor {

	@Override
	public String getHql(QueryParameter parameter) {
		// TODO Auto-generated method stub
		MagRegistersimQueryParameter p = (MagRegistersimQueryParameter)parameter;
		
		StringBuffer hql = new StringBuffer();
		//������ʹ��Oracle SQL�������Ӳ�ѯ
		/*hql.append("select " +
				"ttt.wayid,ttt.wayname,ttt.countyid,ttt.starlevel,ttt.employeename," +
				"ttt.officetel,ttt.mobile,ttt.brand,ttt.comname,ttt.comtype,ttt.comclassid,ttt.comprice,ttt.oprtime," +
				"TO_CHAR(n.activedate, 'yyyy-MM-dd hh24:mi:ss') AS activedate,ttt.mendfalg " +
				"from (");*/
		
		/*hql.append("select r.wayid,w.wayname,w.countyid,to_char(w.starlevel),e.employeename, ");
		hql.append("	e.officetel,r.mobile,to_char(r.brand),r.comname,to_char(r.comtype),to_char(r.comclassid),to_char(r.comprice/100), ");
		hql.append("	to_char(r.oprtime, 'yyyy-MM-dd hh24:mi:ss') as oprtime, ");
		hql.append("	to_char(n.activedate, 'yyyy-MM-dd hh24:mi:ss') as activedate,to_char(r.mendfalg) ");
		hql.append("  from ch_pw_registersim r, ch_pw_way w,ch_pw_employee e,");//,fx_sn_noactinfo n
		*/
		hql.append("select r.wayid,w.wayname,w.countyid,to_char(w.starlevel) as starlevel,e.employeename, ");
		hql.append("	e.officetel,r.mobile,to_char(r.brand) as brand,r.comname,to_char(r.comtype) as comtype,to_char(r.comclassid) as comclassid,to_char(r.comprice/100) as comprice, ");
		hql.append("	to_char(r.oprtime, 'yyyy-MM-dd hh24:mi:ss') as oprtime, ");
		hql.append("	TO_CHAR(n.activedate, 'yyyy-MM-dd hh24:mi:ss') AS activedate, ");
		hql.append("	to_char(r.mendfalg) as mendfalg ");
		hql.append(" from fx_sn_noactinfo n, ch_pw_employee e, ch_pw_way w, ch_pw_registersim r ");// fx_sn_noactinfo n
		
		
		/*hql.append(" (select mobileno, activedate from fx_sn_noactinfo ");
		hql.append(" where activedate>=to_date(:active3month,'yyyy-mm-dd hh24:mi:ss') ");//ʹ��������������Ч
*/		//�ڼ���ʱ����ڵ�����£������Ӳ�ѯ��������
		/*if(p.getActiveFrom()!=null && p.getActiveTo()!=null){
			//hql.append(" and n.activedate between :activeFrom and :activeTo");//20110513--��ִ�е�����ʽ���Ǻܺ�
			hql.append(" and activedate between to_date(:activeFrom,'yyyy-mm-dd hh24:mi:ss') and to_date(:activeTo,'yyyy-mm-dd hh24:mi:ss')");
		}
		hql.append(" ) n");*/
		
		hql.append("  where r.mobile=n.mobileno(+) ");
		hql.append(" and n.activedate(+)>=to_date(:active3month,'yyyy-mm-dd hh24:mi:ss')");//ʹ��������������Ч*/
		hql.append("	AND r.oprcode=e.employeeid ");
		hql.append("	AND r.wayid=w.wayid ");		
		
		if(p.getActiveFrom()!=null && p.getActiveTo()!=null){
			//hql.append(" and n.activedate between :activeFrom and :activeTo");//20110513--��ִ�е�����ʽ���Ǻܺ�
			hql.append(" and (activedate between to_date(:activeFrom,'yyyy-mm-dd hh24:mi:ss') and to_date(:activeTo,'yyyy-mm-dd hh24:mi:ss')) ");
		}
		
		//������
		if(StringUtils.isNotEmpty(p.getCityid()));{
			hql.append(" and r.cityid = :cityid ");
		}
		//�������
		if(StringUtils.isNotEmpty(p.getWayid())){
			hql.append(" and r.wayid = :wayid ");
		}
		else{//����������Ϊ�գ����޶���ѯ��ǰ�����������㣻���δ�޶�����ѯ��Χ��Ŵ�
			hql.append(" and r.wayid in ( select  wayid from ch_pw_way where waymagcode=:waymagcode)");
		}
		//��Ա-��Ա���룬�׿����oprcode��Ӧ��Ա�����Ա���룬����Ա����
		if(StringUtils.isNotEmpty(p.getOprcode())){
			hql.append(" and r.oprcode =:oprcode ");
		}
		//�ֹ�˾
		if(StringUtils.isNotEmpty(p.getCountyid())){
			hql.append(" and w.countyid =:countyid ");
		}
		//���۷�����
		if(StringUtils.isNotEmpty(p.getSvccode())){
			hql.append(" and w.svccode =:svccode ");
		}
		//ҵ�����
		if(StringUtils.isNotEmpty(p.getMobile())){
			hql.append(" and r.mobile =:mobile ");
		}
		//Ʒ��
		if(StringUtils.isNotEmpty(p.getBrand())){
			hql.append(" and r.brand =:brand ");
		}
		//���Ǳ�ʶ
		if(StringUtils.isNotEmpty(p.getFlag())){
			hql.append(" and r.mendfalg=:flag");
		}
		//��Ʒ����
		if(StringUtils.isNotEmpty(p.getType())){
			hql.append(" and r.comclassid=:type ");
		}
		//�Ǽ���ʼʱ��
		//�Ǽǽ���ʱ��
		if(p.getTimeFrom()!=null && p.getTimeTo()!=null){
			//hql.append(" and r.oprtime between :start and :end");//20110513--��ִ�е�����ʽ���Ǻܺ�
			hql.append(" and r.oprtime between to_date(:start,'yyyy-mm-dd hh24:mi:ss') and to_date(:end,'yyyy-mm-dd hh24:mi:ss')");
		}	
		
		hql.append(" order by r.seqid");
		
		/*hql.append("  ) ttt ");
		
		hql.append("  LEFT JOIN fx_sn_noactinfo n ");
		hql.append("  ON ttt.mobile = n.mobileno ");
		hql.append(" where activedate>=to_date(:active3month,'yyyy-mm-dd hh24:mi:ss')");//ʹ��������������Ч
		*/
		//�ڼ���ʱ����ڵ�����£������Ӳ�ѯ��������
		/*if(p.getActiveFrom()!=null && p.getActiveTo()!=null){
			//hql.append(" and n.activedate between :activeFrom and :activeTo");//20110513--��ִ�е�����ʽ���Ǻܺ�
			hql.append(" and (activedate between to_date(:activeFrom,'yyyy-mm-dd hh24:mi:ss') and to_date(:activeTo,'yyyy-mm-dd hh24:mi:ss')) ");
		}*/
		
		return hql.toString();
	}
	
	public String getCntHql(QueryParameter parameter){
		String countQueryString = " select count (*)  from ( "
			+ this.getHql(parameter)
			+ " )";
		return countQueryString;
	}
	
	@Override
	public String[] getParamEncloseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(Query query, QueryParameter parameter) {
		// TODO Auto-generated method stub
		MagRegistersimQueryParameter p = (MagRegistersimQueryParameter)parameter;
		
		//������--ҵ������������ opntype=1,smsno=10086111,cityid=��ǰ��¼��Ա����
		if(StringUtils.isNotEmpty(p.getCityid()));{
			query.setString("cityid",p.getCityid());
		}
		//�������
		if(StringUtils.isNotEmpty(p.getWayid())){
			query.setString("wayid", p.getWayid().trim());
		}
		else{
			query.setString("waymagcode", p.getWaymagcode());
		}
		//��Ա-����
		if(StringUtils.isNotEmpty(p.getOprcode())){
			query.setString("oprcode", p.getOprcode());
		}
		//�ֹ�˾
		if(StringUtils.isNotEmpty(p.getCountyid())){
			query.setString("countyid", p.getCountyid());
		}
		//���۷�����
		if(StringUtils.isNotEmpty(p.getSvccode())){
			query.setString("svccode", p.getSvccode());
		}
		//ҵ�����
		if(StringUtils.isNotEmpty(p.getMobile())){
			query.setString("mobile", p.getMobile().trim());
		}
		//Ʒ��
		if(StringUtils.isNotEmpty(p.getBrand())){
			query.setShort("brand", Short.parseShort(p.getBrand()));
		}
		//���Ǳ�ʶ
		if(StringUtils.isNotEmpty(p.getFlag())){
			query.setByte("flag", Byte.parseByte(p.getFlag()));
		}
		//��Ʒ����
		if(StringUtils.isNotEmpty(p.getType())){
			query.setInteger("type", Integer.parseInt(p.getType()));
		}
		//�Ǽ���ʼʱ��
		//�Ǽǽ���ʱ��
		if(p.getTimeFrom()!=null && p.getTimeTo()!=null){
			String start = (new java.sql.Date(p.getTimeFrom().getTime())).toString()+" 00:00:00";
			String end = (new java.sql.Date(p.getTimeTo().getTime())).toString()+" 23:59:59";
			query.setString("start", start);
			query.setString("end", end);
		}
		
		//����ʱ�䲻���ڵ�ǰʱ�䰴3����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date(System.currentTimeMillis());		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH)-3);
		query.setString("active3month", sdf.format(c.getTime()));
		//������ʼʱ��
		//�������ʱ��
		if(p.getActiveFrom()!=null && p.getActiveTo()!=null){
			String start = (new java.sql.Date(p.getActiveFrom().getTime())).toString()+" 00:00:00";
			String end = (new java.sql.Date(p.getActiveTo().getTime())).toString()+" 23:59:59";
			query.setString("activeFrom", start);
			query.setString("activeTo", end);
		}
		/***/
	}

}
