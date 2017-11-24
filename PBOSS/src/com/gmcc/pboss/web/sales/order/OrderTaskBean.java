package com.gmcc.pboss.web.sales.order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class OrderTaskBean extends BaseBatchTaskBean {

	public OrderTaskBean() throws Exception {
		super.setBatchName("资源明细信息批量导出");
		super.setOprtype("导出");
		super.setWriteLog(true);
	}
	
	protected String doStart() {
		return "序号|订单编码|渠道编码|明细编号|商品名称|商品种类|商品标识|商品批次|包号|商品资源编号\r\n";
	}

	@Override
	public void doProcessFile(String fileInPath, String fileOutPath)
			throws Exception {
		File resultFile = new File(fileOutPath);
		this.resultFile = fileOutPath;
		FileInputStream fileInputStream = new FileInputStream(fileInPath);
		InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "gbk");
		BufferedWriter fos = new BufferedWriter(writer);
		try {
			// 文件处理开始,写标题等
			fos.write(doStart());
			String line;
			List paraValue = new ArrayList();
			while ((line = rin.readLine()) != null) {
				paraValue.add(line.trim());
			}
			
			OrderresdetDBParam params = new OrderresdetDBParam();
			params.set_sin_orderid(paraValue);
			params.set_se_ordercomtype("CUSTORDER");
			params.setQueryAll(true);
			Orderresdet orderresdetBO = (Orderresdet)BOFactory.build(OrderresdetBO.class, user);
			DataPackage dp = orderresdetBO.doQueryExp(params);
			List list = dp.getDatas();
			setCountrecord(list.size());
			for (int i = 0; i < list.size(); i++) {
				HashMap hashMap = (HashMap) list.get(i);
				fos.write((i+1) + "|" + hashMap.get("orderid") + "|" 
						+ hashMap.get("wayid") + "|" + hashMap.get("detid")
						+ "|" + Code2NameUtils.code2Name("#COM", 
							(hashMap.get("comid") == null ? "" : hashMap.get("comid").toString()), user.getCityid())
						+ "|" + Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", 
								hashMap.get("comcategory").toString(), user.getCityid()) 
						+ "|" + (hashMap.get("comid") == null ? "" : hashMap.get("comid")) 
						+ "|" + (hashMap.get("batchno") == null ? "" : hashMap.get("batchno"))
						+ "|" + (hashMap.get("boxnum") == null ? "" : hashMap.get("boxnum"))
						+ "|" + (hashMap.get("comresid") == null ? "" : hashMap.get("comresid")) + "\r\n");
			}
			// 文件处理结束
			fos.write(doEnd());
		} catch (Exception ex) {
			fos.write(ex.getMessage());
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
		} finally {
			rin.close();
			read.close();
			fos.close();
			writer.close();
			this.resultFile = fileOutPath;
			isComplete = true;
		}
	}
}
