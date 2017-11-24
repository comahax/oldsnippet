package com.sunrise.boss.ui.cms.yytwayproemployee;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.audit.common.CityIDMap;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.resmanage.nores.nosect.NosectDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class YYTWayproemployeeTaskBean extends BaseBatchTaskBean {
	public YYTWayproemployeeTaskBean() throws Exception {
		super.setBatchName("Ӫҵ��רԱ��Ϣ��������������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "Ӫҵ��רԱ��Ϣ�������������� \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");
			
			
			// �Ƿ���Ҫ���ֵ���,��ʱ����.??
			//���ֵ���
			NosectDelegate nosectDelegate = new NosectDelegate();
			String cityid = nosectDelegate.doQueryCityID(content[1],user);
			User userNew = new User();
			BeanUtils.copyProperties(userNew, user);
			userNew.setCityid(SessionFactoryRouter.conversionCityid2Num(cityid));
			
			//1���ж������������Ƿ����
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[2]);
			wayListVO.set_ne_waystate(Short.valueOf("1"));
			DataPackage waydp = waydelegate.doQuery(wayListVO, userNew);
			if(waydp.getRowCount()==0){
				throw new BusinessException("","���������̲�����");
			}else{
				Collection col = waydp.getDatas();
				Iterator it = col.iterator();
				WayVO wayvo =(WayVO)it.next();
				if(!("GD".equals(wayvo.getCityid())||wayvo.getCityid()==null)){
					if(!wayvo.getCityid().equals(cityid)){
						throw new BusinessException("","�ֻ�����Ŷ����������������������в�һ��!");
					}
				}
			}
			
			// 20111116 add by liuchao ���ݵ����ÿ���ֻ������ֵ��im_pr_nores���в�ѯ
//			NoresDelegate noresDelegate=new NoresDelegate();
//			NoresListVO noresListVO=new NoresListVO();
//			noresListVO.set_se_mobileno(content[1]);
//			DataPackage noreDataPackage = noresDelegate.doQuery(noresListVO, userNew);
//			if(noreDataPackage.getRowCount()==0){
//				throw new BusinessException("","������ֻ���������");
//			}

			EmployeeDelegate employeeDelegate = new EmployeeDelegate();
			
			//��ѯ��Ա����������
			EmployeeListVO listVO=new EmployeeListVO();
			listVO.set_se_telephone(content[1]);
			listVO.set_ne_isnet("2");
			listVO.set_desc("1");
			listVO.set_orderby("regdate");
			DataPackage dp=employeeDelegate.doQuery(listVO, userNew);
			// ����ģʽΪ��0������
			if (null != content[0] && ("0".equals(content[0]))) {
				//���ڸ����ƹ�רԱ�����Ĵ���
				//������ڼ�¼
				if(dp.getRowCount()>0){
					EmployeeVO employeeVO = (EmployeeVO)((List)dp.getDatas()).get(0);
					String wayid = employeeVO.getWayid();
					if(StringUtils.isEmpty(wayid)){
						throw new BusinessException("","Ӫҵ��רԱ�����������벻����");
					}
					String wayid2 = CityIDMap.conversionCityid(userNew.getCityid()) + "U_00000";
					//ԭ���������ڸ����ƹ�רԱ����
					if(wayid.equals(wayid2) || employeeVO.getEmpstatus()==1){
//						throw new BusinessException("", "�ƹ�רԱ�Ѿ�ע��!");
					}
					else{
						throw new BusinessException("", "Ӫҵ��רԱ�Ѿ�ע��!");
					}
					
					EmployeeVO empVO = buildEmpVO(content, "Update");
					EmployeeVO oldVO = (EmployeeVO) ((List) dp.getDatas())
					.get(0);
					empVO.setEmployeeid(oldVO.getEmployeeid());
					//�Ƚ���Ա״̬�����������Ƿ�䶯.���Ƿ�Ҫ������.
					if(!empVO.getWayid().equals(oldVO.getWayid()) || !empVO.getEmpstatus().equals(oldVO.getEmpstatus()))
						empVO.setChanged(true);
					
					employeeDelegate.doUpdateWaypro(empVO, userNew);
					if(employeeDelegate.doMessage(userNew)){
						if(empVO.isChanged()){
						line = rowCount + "   " + line + "    �����ɹ�,�������ȴ��û�ȷ�ϣ������ѯ������\"���Ŷ���ȷ�����ݲ�ѯ\"";
						}else
						{
							line = rowCount + "   " + line + "    �����ɹ�";
						}
					}else{
						line = rowCount + "   " + line + "    �����ɹ�";
					}
					resultVO.setInfo(line);
					resultVO.setOk(true);
					
				}else{
					
					employeeDelegate.doCreateWaypro(buildEmpVO(content, "NEW"),
							userNew);
					if(employeeDelegate.doMessage(userNew)){
						line = rowCount + "   " + line + "    �����ɹ�,�������ȴ��û�ȷ�ϣ������ѯ������\"���Ŷ���ȷ�����ݲ�ѯ\"";
					}else{
						line = rowCount + "   " + line + "    �����ɹ�";
					}
					resultVO.setInfo(line);
					resultVO.setOk(true);
				}
				
				
			} else if (null != content[0] && content[0].equals("1")) {
				EmployeeVO empVO = buildEmpVO(content, "Update");
//				//��ѯ��Ա����������
//				EmployeeListVO listVO=new EmployeeListVO();
//				listVO.set_se_telephone(empVO.getTelephone());
//				listVO.set_ne_isnet("2");
//				listVO.set_desc("1");
//				listVO.set_orderby("regdate");
//				DataPackage dp=employeeDelegate.doQuery(listVO, userNew);
				if (dp.getRowCount() == 0) {
					throw new Exception("�Ҳ�����Ҫ�޸ĵļ�¼");
					} else {
						EmployeeVO oldVO = (EmployeeVO) ((List) dp.getDatas())
								.get(0);
						empVO.setEmployeeid(oldVO.getEmployeeid());
						
						
						//�Ƚ���Ա״̬�����������Ƿ�䶯.���Ƿ�Ҫ������.
						if(!empVO.getWayid().equals(oldVO.getWayid()) || !empVO.getEmpstatus().equals(oldVO.getEmpstatus())){
							empVO.setChanged(true);
						}
						if(!empVO.getWayid().equals(oldVO.getWayid())){
							String wayid2 = CityIDMap.conversionCityid(userNew.getCityid()) + "U_00000";
							//ԭ���������ڸ����ƹ�רԱ����
							if(oldVO.getWayid().equals(wayid2)){
								//�����ں�����
							}
							//ԭ�����������ڸ����ƹ�רԱ����
							else{
								throw new BusinessException("","Ӫҵ��רԱ�Ѿ�ע��");
							}
							
						}
						employeeDelegate.doUpdateWaypro(empVO, userNew);
						if(employeeDelegate.doMessage(userNew)){
							if(empVO.isChanged()){
								line = rowCount + "   " + line + "    �����ɹ�,�������ȴ��û�ȷ�ϣ������ѯ������\"���Ŷ���ȷ�����ݲ�ѯ\"";
							}else
							{
								line = rowCount + "   " + line + "    �����ɹ�";
							}
						}else{
							line = rowCount + "   " + line + "    �����ɹ�";
						}
						resultVO.setInfo(line);
						resultVO.setOk(true);
					}
			}
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

	private EmployeeVO buildEmpVO(String content[], String operate)
			throws Exception {
		// ??ע�������ѵ������޸���?
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setIsnet(new Short("2"));
		employeeVO.setWaytype("ET");
		employeeVO.setTelephone(content[1]);
		employeeVO.setWayid(content[2]);
		employeeVO.setEmployeename(content[3]);
		employeeVO.setSubname(content[4]);
		employeeVO.setEmpstatus(Short.valueOf(content[5]));
		employeeVO.setCardid(content[6]);
		employeeVO.setPvtemail(content[7]);
		employeeVO.setRegdate(new Date(format.parse(content[8]).getTime()));
		employeeVO.setIntime(new Date(format.parse(content[8]).getTime()));
		employeeVO.setOuttime(new Date(format.parse(content[9]).getTime()));
		if (StringUtils.isNotBlank(content[10])) {
			if("0".equals(content[10]))
			{
				employeeVO.setIsunpb(true);
			}else if("1".equals(content[10]))
			{
				employeeVO.setIsunpb(false);
			}
		}
		if (StringUtils.isNotBlank(content[11])) {
			employeeVO.setIstenseed(new Short(content[11]));
		}
		if (StringUtils.isNotBlank(content[12])) {
			employeeVO.setIsinternal(new Short(content[12]));
		}
		employeeVO.setEmpattr(content[13]);
		employeeVO.setEmpattrmemo(content[14]);
		if(StringUtils.isNotBlank(content[15])){
			employeeVO.setEmpattr2(new Short(content[15]));
		}
		employeeVO.setOprcode2(content[16]);
		return employeeVO;
	}

}