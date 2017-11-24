package com.gmcc.pboss.web.resource.compack;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.resource.compack.ComcategoryInfo;
import com.gmcc.pboss.business.resource.compack.PackResourceInfo;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.sunrise.jop.common.utils.lang.LoggerUtils;

public class PackResourceThread implements Runnable{
	private static Logger log = Logger.getLogger(PackResourceThread.class);
	
	private Compack bo;
	private List<ComcategoryInfo> comcateList;
	private String discomcode;
	private String batchno;
	private PackResourceInfo packInfo;
	private String file;
	private BufferedOutputStream os;
	
	public PackResourceThread(Compack bo,List<ComcategoryInfo> comcateList,String discomcode,String batchno,PackResourceInfo packInfo,String file){
		this.bo = bo;
		this.comcateList = comcateList;
		this.discomcode = discomcode;
		this.batchno = batchno;
		this.packInfo = packInfo;
		this.file = file;
		try{
			os = new BufferedOutputStream(new FileOutputStream(file));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			
			
			os.write("���|��Ʒ����|����|����|���ΰ���|���ΰ��ţ��ɣ�|\r\n".getBytes());
			bo.packResource(comcateList, discomcode, batchno, packInfo, os);
			packInfo.setFinish(true);
			packInfo.setEndTime(new Date());
			StringBuilder sb = new StringBuilder(100);
			sb.append("ͳ�ƣ�����ʱ�� ").append(format.format(packInfo.getStartTime()));
			sb.append(" ���ʱ�� ").append(format.format(packInfo.getEndTime()));
			sb.append(" �׿����� ").append(packInfo.getResource());
			sb.append(" ������ ").append(packInfo.getTotalPack());
			os.write(sb.toString().getBytes());
		}catch(Exception e){
			LoggerUtils.error(e, log);
			e.printStackTrace();
			packInfo.setFinish(true);
			packInfo.setEndTime(new Date());
			packInfo.setErrMsg(e.getMessage());
		}finally{
			try{
				os.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

}
