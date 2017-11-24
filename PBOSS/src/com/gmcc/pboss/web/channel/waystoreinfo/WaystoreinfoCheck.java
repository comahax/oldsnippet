package com.gmcc.pboss.web.channel.waystoreinfo;

 
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils; 
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class WaystoreinfoCheck extends BaseCheckFormat {  
	
	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		} 
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		Dictitem dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
		DictitemVO vo = new DictitemVO();  

		if (content.length != 24) {
			throw new Exception("上传数据列数不对,应为23列,请查看说明帮助!");
		}
		//门店编码
		if (content[0] == null || "".equals(content[0])) {
			throw new Exception("门店编码不能为空");
		} else{
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayDBParam wayDBParam = new WayDBParam();
			wayDBParam.set_se_wayid(content[0]);
			wayDBParam.set_se_waytype("AG");
			wayDBParam.set_ne_waystate("1");
			ArrayList<String> waysubtype_in = new ArrayList<String>();
			waysubtype_in.add("PSAL");
			waysubtype_in.add("SAGT");
			waysubtype_in.add("VWAY");
			waysubtype_in.add("FD");
			waysubtype_in.add("FDS");
			waysubtype_in.add("JMQD");
			wayDBParam.set_sin_waysubtype(waysubtype_in);
			DataPackage dp = way.doQuery(wayDBParam);  
			 if(dp.getRowCount()==0){
				throw new Exception("请输入有效的门店编码");
			 } 
		} 
		//面积 
		if (content[1] == null || "".equals(content[1])) {
			throw new Exception("面积不能为空");
		}else if(!CheckUtil.checkDouble(content[1])){
			throw new Exception("请输入正确的面积");
		}
		//专区类型
		if(content[2] == null || "".equals(content[2])) {
			throw new Exception("专区类型不能为空"); 
		}else{
			vo.setGroupid("CH_WAYSTORETYPE");
			vo.setDictid(content[2]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("请输入有效的专区类型 ");
			}
			
		}
		//专区面积
		if (content[3] == null || "".equals(content[3])) {
			throw new Exception("专区面积不能为空");
		}else if(!CheckUtil.checkDouble(content[1])){
			throw new Exception("请输入正确的专区面积");
		}  
		//专区背板4
		if(content[4] == null || "".equals(content[4])) {
			throw new Exception("专区背板不能为空"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[4]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("请输入有效的专区背板 ");
			} 
		}
		//专区专柜
		if(content[5] == null || "".equals(content[5])) {
			throw new Exception("专区专柜不能为空"); 
		}else if(!CheckUtil.checkNum(content[5])){ 
			throw new Exception("请输入有效的专区专柜数量 "); 
		}
		
		//专区立牌
		if(content[6] == null || "".equals(content[6])) {
			throw new Exception("专区立牌不能为空"); 
		}else if(!CheckUtil.checkNum(content[6])){ 
			throw new Exception("请输入有效的专区立牌数量 "); 
		}
		
		//专区价签
		if(content[7] == null || "".equals(content[7])) {
			throw new Exception("专区立牌专区价签不能为空"); 
		}else if(!CheckUtil.checkNum(content[7])){ 
			throw new Exception("请输入有效的专区价签数量 "); 
		}
		//专区展架
		if(content[8] == null || "".equals(content[8])) {
			throw new Exception("专区展架不能为空"); 
		}else if(!CheckUtil.checkNum(content[8])){ 
			throw new Exception("请输入有效的专区展架数量 "); 
		} 
		
		//专区店内横幅
		if(content[9] == null || "".equals(content[9])) {
			throw new Exception("专区店内横幅不能为空"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[9]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("请输入有效的专区店内横幅 ");
			} 
		}
		//专区店外横幅
		if(content[10] == null || "".equals(content[10])) {
			throw new Exception("专区店外横幅不能为空"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[10]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("请输入有效的专区店外横幅 ");
			} 
		}
		//专区堆头
		if(content[11] == null || "".equals(content[11])) {
			throw new Exception("专区堆头不能为空"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[11]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("请输入有效的专区堆头 ");
			} 
		}
		//专区地贴
		if(content[12] == null || "".equals(content[12])) {
			throw new Exception("专区地贴不能为空"); 
		}else{
			vo.setGroupid("CH_YESORNO1");
			vo.setDictid(content[12]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("请输入有效的专区地贴 ");
			} 
		}  
		//专区桌面台牌点位
		if(content[13] == null || "".equals(content[13])) {
			throw new Exception("专区桌面台牌点位不能为空"); 
		}else if(!CheckUtil.checkNum(content[13])){ 
			throw new Exception("请输入有效的专区桌面台牌点位 "); 
		} 
		//专区桌面台卡点位
		if(content[14] == null || "".equals(content[14])) {
			throw new Exception("专区桌面台卡点位不能为空"); 
		}else if(!CheckUtil.checkNum(content[14])){ 
			throw new Exception("请输入有效的专区桌面台卡点位 "); 
		}  
		//专区海报
		if(content[15] == null || "".equals(content[15])) {
			throw new Exception("专区海报不能为空"); 
		}else if(!CheckUtil.checkNum(content[15])){ 
			throw new Exception("请输入有效的专区海报 "); 
		}   
		//门头类型
		if(content[16] == null || "".equals(content[16])) {
			throw new Exception("门头类型不能为空"); 
		}else{
			vo.setGroupid("CH_DOORTYPE");
			vo.setDictid(content[16]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			  throw new Exception("请输入有效的门头类型 ");
			} 
		}
		//专区类型与门头类型互斥
		if( (("3").equals(content[2]) && ("4").equals(content[16])) || (("4").equals(content[2]) && ("3").equals(content[16]))  ){
			throw new Exception("3G专区的门头类型必须为3G门头，4G专区的门头类型必须为4G门头");
		}
		
		//外墙广告面积大小 
		if (content[17] == null || "".equals(content[17])) {
			throw new Exception("外墙广告面积大小不能为空");
		}else if(!CheckUtil.checkDouble(content[17])){
			throw new Exception("请输入正确的外墙广告面积大小");
		}
		//外墙广告大幅宣传画点位
		if(content[18] == null || "".equals(content[18])) {
			throw new Exception("外墙广告大幅宣传画点位不能为空"); 
		}else if(!CheckUtil.checkNum(content[18])){ 
			throw new Exception("请输入有效的外墙广告大幅宣传画点位 "); 
		}  
		//终端专营
		if(content[19] == null || "".equals(content[19])) {
			throw new Exception("终端专营不能为空"); 
		}else{
			vo.setGroupid("CH_YESORNO2");
			vo.setDictid(content[19]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("请输入有效的终端专营 ");
			} 
		}   
		//业务专营
		if(content[20] == null || "".equals(content[20])) {
			throw new Exception("业务专营不能为空"); 
		}else{
			vo.setGroupid("CH_YESORNO2");
			vo.setDictid(content[20]);
			DictitemVO dictitemVO = dictitem.doFindByPk(vo);
			if(null == dictitemVO){
			throw new Exception("请输入有效的业务专营 ");
			} 
		}
		// 店内宣传数量 
		if(content[21] == null || "".equals(content[21])) {
			throw new Exception("店内宣传数量不能为空"); 
		}else if(!CheckUtil.checkNum(content[21])){ 
			throw new Exception("请输入有效的店内宣传数量 "); 
		}  
		//系数
		if(CheckUtil.isEmpty(content[22])){
			throw new Exception("系数不能为空"); 
		}else if(!CheckUtil.checkDouble(content[22], 1, 2) || Double.parseDouble(content[22]) < 0 || Double.parseDouble(content[22]) > 1){
			throw new Exception("系数必须为0-1之间的小数值"); 
		}
		
		
		

	}
}
