package com.gmcc.pboss.web.channel.way;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class LogiswayCheck extends BaseCheckFormat {

	private Way delegate;

	private Bchcontact bchdelegate;

	private Waycompact comdelegate;

	private Wayaccount accdelegate;
	
	

	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
	}
}
	
	
	public void checkLine(String line, int rowCount, User user)
	throws Exception {
// TODO Auto-generated method stub
		delegate = (WayBO) BOFactory.build(WayBO.class,user);
		bchdelegate = (BchcontactBO) BOFactory.build(BchcontactBO.class, user);
		comdelegate = (WaycompactBO) BOFactory.build(WaycompactBO.class, user);
		accdelegate = (WayaccountBO) BOFactory.build(WayaccountBO.class,user);
		if (null == line || "".equals(line)) {
			return;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		for (int i = 0; i < items.length; i++) {
			items[i] = items[i] == null ? "" : items[i].trim();
		}
		// 检查列数
		if (items.length != 16) {
			throw new Exception("上传数据列数不对,应为15列");
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		// 渠道编码0
		String regex="^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		if (StringUtils.isBlank(items[0]) || !items[0].matches(regex)) {
			throw new Exception("渠道编码格式不正确或长度出错，正确范围为1~18");
		}
		wayVO.setWayid(items[0]);
		bchcontactVO.setWayid(items[0]);
		waycompactVO.setWayid(items[0]);
		wayaccountVO.setWayid(items[0]);

		wayVO = delegate.doFindByPk(wayVO.getWayid());
		
		WayVO uppvo=null;
		if(StringUtils.isNotBlank(items[2]))
		{
			uppvo=delegate.doFindByPk(items[2].trim());
		if(uppvo==null)
		{
			throw new Exception("上级渠道编码"+items[2]+"不存在");
		}
		}
		if (wayVO == null) {
			// 渠道名称1
			// 渠道名称1
			if (StringUtils.isEmpty(items[1])
					|| items[1].getBytes().length >256) {
				throw new Exception("渠道名称不能为空且长度不能大于256");
			}

			// 上级渠道编码2
			if (items[2].getBytes().length>18 || "".equals(items[2])) {
				throw new Exception("上级渠道编码格式出错，正确长度范围为1~18");
			}
			
			// 合作方3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("合作方出错，正确为0-2位数字");
			}

			// 地市公司4
			if (items[4].getBytes().length > 14) {
				throw new Exception("地市公司长度不能大于14");
			}
			// 分公司5
			if (items[5].getBytes().length > 14) {
				throw new Exception("分公司长度不能大于14");
			}

			// 服务销售中心6
			if (items[6].getBytes().length > 14) {
				throw new Exception("服务销售中心长度不能大于14");
			}

			// 微区域7
			if (items[7].getBytes().length > 14) {
				throw new Exception("微区域长度不能大于14");
			}

			// 行政区划8
			if (items[8].getBytes().length > 18) {
				throw new Exception("行政区划长度不能大于18");
			}

			// 经度值11
			if (!StringUtils.isEmpty(items[9])) {
				int i = items[9].indexOf(".");
				String flatitude = items[9].substring(0, i);
				String blatitude = items[9].substring(i + 1);
				if (!items[9].matches("[\\d.\\d]{1,10}")
						|| flatitude.length() != 3
						|| Double.valueOf(items[9]).doubleValue() <= 100
						|| Double.valueOf(items[9]).doubleValue() >= 130) {
					throw new Exception(
							"经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
				}
			} else {
				throw new Exception("经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
			}

			// 纬度值12
			if (!StringUtils.isEmpty(items[10])) {
				int i = items[10].indexOf(".");
				String flongtitude = items[10].substring(0, i);
				String blongtitude = items[10].substring(i + 1);
				if (!items[10].matches("[\\d.\\d]{1,9}")
						|| flongtitude.length() != 2
						|| blongtitude.length() != 6
						|| Double.valueOf(items[10]).doubleValue() <= 18
						|| Double.valueOf(items[10]).doubleValue() >= 26) {
					throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
				}
			} else {
				throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
			}

			// 详细地址9
			if (items[11].getBytes().length > 128) {
				throw new Exception("详细地址长度不能大于128");
			}
		} else {
			// 渠道名称1
			if (!StringUtils.isEmpty(items[1])
					&& items[1].getBytes().length > 256) {
				throw new Exception("渠道名称不能为空且长度不能大于256");
			}

			// 上级渠道编码2
			if (!CheckUtil.checkString(items[2], 18, false)) {
				throw new Exception("上级渠道编码长度出错，正确范围为1~18");
			}

			// 合作方3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("合作方出错，正确为0-2位数字");
			}

			// 地市公司4
			if (items[4].getBytes().length > 14) {
				throw new Exception("地市公司长度不能大于14");
			}

			// 分公司5
			if (items[5].getBytes().length > 14) {
				throw new Exception("分公司长度不能大于14");
			}

			// 服务销售中心6
			if (items[6].getBytes().length > 14) {
				throw new Exception("服务销售中心长度不能大于14");
			}

			// 微区域7
			if (items[7].getBytes().length > 14) {
				throw new Exception("微区域长度不能大于14");
			}

			// 行政区划8
			if (items[8].getBytes().length > 18) {
				throw new Exception("行政区划长度不能大于18");
			}

			// 经度值11
			if (!StringUtils.isEmpty(items[9])) {
				int i = items[9].indexOf(".");
				String flatitude = items[9].substring(0, i);
				String blatitude = items[9].substring(i + 1);
				if (!items[9].matches("[\\d.\\d]{1,10}")
						|| flatitude.length() != 3
						|| Double.valueOf(items[9]).doubleValue() <= 100
						|| Double.valueOf(items[9]).doubleValue() >= 130) {
					throw new Exception(
							"经度格式或者值范围不对，必须为100到130之间，且整数为3位，小数为6位！");
				}
			}

			// 纬度值12
			if (!StringUtils.isEmpty(items[10])) {
				int i = items[10].indexOf(".");
				String flongtitude = items[10].substring(0, i);
				String blongtitude = items[10].substring(i + 1);
				if (!items[10].matches("[\\d.\\d]{1,9}")
						|| flongtitude.length() != 2
						|| blongtitude.length() != 6
						|| Double.valueOf(items[10]).doubleValue() <= 18
						|| Double.valueOf(items[10]).doubleValue() >= 26) {
					throw new Exception("纬度格式或者值范围不对，必须为18到26之间，且整数为2位，小数为6位！");
				}
			}

			// 详细地址9
			if (items[11].getBytes().length > 128) {
				throw new Exception("详细地址长度不能大于128");
			}
		}

		//  -------------------- 插入ch_pw_employee表的信息  -----------------------
		if (!StringUtils.isEmpty(items[12])
				&& items[12].getBytes().length > 64) {
			throw new Exception("负责人姓名长度不能为空且不能大于64");
		}

		// 负责人联系电话13
		if (!StringUtils.isEmpty(items[13])
				&& items[13].getBytes().length > 20) {
			throw new Exception("负责人联系电话格式不对且不能为空");
		}

		// 负责人电子邮箱14
		if (!StringUtils.isEmpty(items[14])
				&& !items[14]
						.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
			throw new Exception("负责人电子邮箱格式不对");
		}


	}

	// 检查经营区域类型编码
	public void checkJYQY(String item, User user) throws Exception {
		if ("".equals(item)) {
			return;
		}
		Dictitem delegate = (DictitemBO) BOFactory.build(DictitemBO.class,user);
		DictitemDBParam listVO = new DictitemDBParam();
		listVO.set_se_groupid("CH_ORGTYPE");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO).getRowCount() <= 0) {
			throw new Exception("固定参数[区域类型编码]的值不正确");
		}

}

}
