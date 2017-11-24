package com.gmcc.pboss.web.sales.waystocksnpt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.control.sales.waystocksnpt.Waystocksnpt;
import com.gmcc.pboss.control.sales.waystocksnpt.WaystocksnptBO;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class StocklistsmpTaskBean extends BaseBatchTaskBean {

	public StocklistsmpTaskBean() throws Exception {
		super.setBatchName("��������ͳ����������");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	@Override
	protected String doStart() {
		return "���|�ֹ�˾|������������|΢����|��������|�������|��������|�Ǽ�|��Ʒ����|�������|���ʱ��\r\n";
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
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// �ļ�����ʼ,д�����
			fos.write(doStart());
			int count = 0;
			String line;
			List _sin_wayid = new ArrayList();
			while ((line = rin.readLine()) != null) {
				_sin_wayid.add(line.trim());
			}
			Waystocksnpt snptbo = (Waystocksnpt) BOFactory.build(WaystocksnptBO.class, user);
			WaystocksnptDBParam params = new WaystocksnptDBParam();
			params.set_sin_wayid(_sin_wayid);
			params.setQueryAll(true);
			DataPackage dp = snptbo.doQuery(params);
			List list = dp.getDatas();
			setCountrecord(list.size());
			for (int i = 0; i < list.size(); i++) {
				WaystocksnptVO vo = (WaystocksnptVO) list.get(i);
				fos.write((i+1) + "|" + Code2NameUtils.code2Name("#CNTYCOMPANY", (vo.getCountyid() == null ? "" : vo.getCountyid()), user.getCityid())
						+ "|" + Code2NameUtils.code2Name("#SERVCENT", (vo.getSvccode() == null ? "" : vo.getSvccode()), user.getCityid())
						+ "|" + Code2NameUtils.code2Name("#MICROAREA", (vo.getMareacode() == null ? "": vo.getMareacode()), user.getCityid())
						+ "|" + (vo.getOrderid() == null ? "" : vo.getOrderid())
						+ "|" + (vo.getWayid() == null ? "" : vo.getWayid())
						+ "|" + (vo.getWayname() == null ? "" : vo.getWayname())
						+ "|" + Code2NameUtils.code2Name("$CH_STARLEVEL", (vo.getStarlevel() == null ? "" : vo.getStarlevel().toString()), user.getCityid())
						+ "|" + Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", (vo.getComcategory() == null ? "": vo.getComcategory()), user.getCityid())
						+ "|" + (vo.getStocknum() == null ? "" : vo.getStocknum())
						+ "|" + (vo.getStocktime() == null ? "" : format.format(vo.getStocktime())) + "\r\n");
			}
			
			// �ļ��������
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
