package com.gmcc.pboss.web.channel.impway;

import java.util.Date;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class ImpWayTaskBean extends BaseBatchTaskBean{
	public ImpWayTaskBean() throws Exception {
		super.setBatchName("入柜商渠道导入"); 
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "行号|渠道编码|渠道名称|上级渠道编码|渠道类型|渠道子类型|地市公司编码|分公司编码|服务销售中心编码|微区域编码|星级|商圈类型编码|区域类型编码|联系电话|行政区划编码|详细地址|地理纬度|地理经度|经营模式|是否联网|联网方式|物业来源分类|是否中心渠道|合作商编码|是否共享|处理结果|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
 		ResultVO resultVO = new ResultVO();
		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Way way = (Way) BOFactory.build(WayBO.class, user);
			
			WayVO vo = way.doFindByPk(content[0].trim());
			if (vo != null && vo.getWaytype() != null && !vo.getWaytype().equals("IMP")) {
				throw new Exception("此菜单只能操作渠道类型为入柜商渠道【IMP】的渠道编码");
			}
			
			WayVO wayvo = new WayVO();
			wayvo.setWayid(content[0]);
			wayvo.setWayname(content[1]);
			if(null!=content[2]){ 
				WayVO vo1 = way.doFindByPk(content[2].trim());
				if(vo1 != null && ((("IMP").equals(vo1.getWaytype()) || ("IMP").equals(content[2])) || 1!=vo1.getWaystate())){
					throw new Exception("入柜商渠道的上级渠道编码必须为有效的渠道，且渠道类型不能为引商入柜渠道");
				}else{
					wayvo.setUpperwayid(content[2]);
				}
			}else{
				throw new Exception("入柜商渠道的上级渠道编码不能为空");
			}
			wayvo.setWaytype("IMP");
			if (StringUtils.isNotBlank(content[4])) {
				wayvo.setWaysubtype(content[4].trim());
			}
			wayvo.setCityid(content[5].trim());
			wayvo.setCountyid(content[6].trim());
			if (StringUtils.isNotBlank(content[7])) {
				wayvo.setSvccode(content[7].trim());
			}
			if (StringUtils.isNotBlank(content[8])) {
				wayvo.setMareacode(content[8].trim());
			}
			if (StringUtils.isNotBlank(content[9]) && StringUtils.isNumeric(content[9].trim())) {
				wayvo.setStarlevel(new Long(content[9].trim()));
			}
			if (StringUtils.isNotBlank(content[10]) && StringUtils.isNumeric(content[10].trim())) {
				wayvo.setBuztypecode(new Short(content[10].trim()));
			}
			if (StringUtils.isNotBlank(content[11]) && StringUtils.isNumeric(content[11].trim())) {
				wayvo.setAdtypecode(new Short(content[11].trim()));
			}
			if (StringUtils.isNotBlank(content[12])) {
				wayvo.setBuzphoneno(content[12].trim());
			}
			if (StringUtils.isNotBlank(content[13])) {
				wayvo.setAdacode(content[13].trim());
			}
			if (StringUtils.isNotBlank(content[14])) {
				wayvo.setAddress(content[14].trim());
			}
			wayvo.setLatitude(content[15].trim());
			wayvo.setLongtitude(content[16].trim());
			if (StringUtils.isNumeric(content[17].trim())) {
				wayvo.setRunmode(new Long(content[17].trim()));
			}
			if (StringUtils.isNotBlank(content[18]) && StringUtils.isNumeric(content[18].trim())) {
				wayvo.setIsconnected(new Long(content[18].trim()));
			}
			if (StringUtils.isNotBlank(content[19]) && StringUtils.isNumeric(content[19].trim())) {
				wayvo.setConnecttype(new Long(content[19].trim()));
			}
			if (StringUtils.isNotBlank(content[20]) && StringUtils.isNumeric(content[20].trim())) {
				wayvo.setPrtsource(new Long(content[20].trim()));
			}
			if (StringUtils.isNotBlank(content[21]) && StringUtils.isNumeric(content[21].trim())) {
				wayvo.setIscoreway(new Long(content[21].trim()));
			}
			if (StringUtils.isNotBlank(content[22])) {
				wayvo.setChainhead(content[22].trim());
			}
			if (StringUtils.isNotBlank(content[23])) {
				wayvo.setIsshare(content[23].trim());
			}
			
			if (vo == null) {
				wayvo.setWaystate(new Short("1"));
				wayvo.setCreatetime(new Date());
				way.doSave(wayvo);
			} else {
				BeanUtils.copyProperties(vo, wayvo);
				way.doUpdateImpWay(wayvo);
			}
			
			line = rowCount + "|"+line+"|" + "导入成功" + "|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "|" + "出错原因:" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
