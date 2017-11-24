package com.gmcc.pboss.common.pnrg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gmcc.pboss.common.dictionary.Branch;


/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-8-18
 * 所属项目：
 * 所属模块：
 * 描述：
 * 		中国移动号码段文件管理
 */
public class PNRGLoader {
	protected static final Log logger = LogFactory.getLog(PNRGLoader.class);
	
	/**号码段文件最后一次修改时间*/
	private static long rangeLastModified = 0;
	private static Map rangeHash = null;
	private static List rangeList = null;
	
	/**号码段文件名称*/
	private static final String PNRG = "PNRG.cfg";
	
	/**
	 * 将号码段文件加载到内存中
	 * @param filePath 保存路径
	 * @throws IOException
	 */
	public static void init(String filePath) throws IOException{
        
		File file = new File(filePath + PNRG);
        long lastModified = file.lastModified();
        if (rangeLastModified < lastModified || rangeHash == null) {
            FileInputStream fis = new FileInputStream(file);
            load(fis);
            rangeLastModified = lastModified;
        }
	}
	/**
     * @description: 加载号码段文件到内存中，优化了加载逻辑，把号段开始和号段结束前7位相同的,以前7位为KEY放进一个HASHTABLE中，
     * 并且HASHTABLE中的KEY保持唯一，KEY有重复和号段开始和号段结束前7位不一致都保存在一个LIST里。文件加载完后重新遍历LIST，
     * 把存在LIST以号段开起7位为KEY，并且也存在HASHTABLE里的号段信息取出，增加到LIST里，然后从HASHTABLE里删除。
     * @param: 
     * @return: 
     * @throws: 
     */
	private static void load(FileInputStream fis) throws IOException {
		logger.info(">>>加载PNRG_FILE 号码段文件");
		
        String tmp = null;
        rangeList = new ArrayList();
        rangeHash = new Hashtable();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
//        long start = System.currentTimeMillis();
        String[] t = null;
        
        while ((tmp = br.readLine()) != null) {
            t = tmp.split(",");
            //号码段格式正确：序号，地市编码，开始号段，结束号段，品牌编码，号段标识
            if (t != null && (t.length == 6 || t.length == 7) 
            		&& t[2].length() == 11 && t[3].length()==11) {
                /*
                 * 号段开始和号段结束前7位相同的,以前7位为KEY放进一个HASHTABLE中
                 */
            	if (rangeHash.get(t[2].substring(0, 7)) == null 
                        && t[2].substring(0, 7).equals(t[3].substring(0, 7))
                        && "0000".equals(t[2].substring(7))
                        && "9999".equals(t[3].substring(7))) {
                    rangeHash.put(t[2].substring(0, 7), t);
                }
            	/*
            	 * 不一致都保存在一个LIST里
            	 */
                else {
                    rangeList.add(t);
                }
            } 
            else {
                logger.info("号段数据出错:" + tmp);
            }
        }
        
        br.close();
        
        logger.info("remove before:" + rangeHash.size());
        /*
         * 把存在LIST以号段开起7位为KEY，并且也存在HASHTABLE里的号段信息取出，
         * 增加到LIST里，然后从HASHTABLE里删除
         */
        t = null;
        for (int j = 0; j < rangeList.size(); j++) {
            t = (String[]) rangeList.get(j);
            if ( rangeHash.get(t[2].substring(0, 7)) != null) {
                rangeList.add(rangeHash.get(t[2].substring(0, 7)));
                rangeHash.remove(t[2].substring(0, 7));
            }
        }
//        logger.info("Waste Time: " + (System.currentTimeMillis() - start));
//        logger.info("RangeList: " + rangeList.size());
//        logger.info("RangeHash: " + rangeHash.size());
//        logger.info("Total Size: " + (rangeList.size() + rangeHash.size()));
	}//
	/**
	 * 加载号码信息
	 * @param mobile 手机号码
	 * @param filePath 号码段文件保存路径
	 * @return
	 * @throws IOException
	 */
	private static String[] loadMobileInfo(String mobile,String filePath) throws IOException {
        init(filePath);
        
        String[] mobileInfo = null;
        String[] branchAndBrand = null;
        
        if (mobile.length() != 11) {
            return null;
        }
        
        if (rangeHash != null) {
            mobileInfo = (String[]) rangeHash.get(mobile.substring(0, 7));
            if (mobileInfo != null) {
                //System.out.println("从HASHTABLE里取数据。。。。。");
                branchAndBrand = new String[4];
                branchAndBrand[0] = mobileInfo[1];
                branchAndBrand[1] = mobileInfo[4];
                branchAndBrand[2] = mobileInfo[5];
                if (mobileInfo.length == 7) {
                    branchAndBrand[3] = mobileInfo[6];
                } else {
                    branchAndBrand[3] = "";
                }
                return branchAndBrand;
            }
        }
        
        for (int i = 0; null != rangeList && i < rangeList.size(); i++) {
            mobileInfo = (String[]) rangeList.get(i);
            if ((mobile.compareTo(mobileInfo[2]) >= 0) && (mobile.compareTo(mobileInfo[3]) <= 0)) {
                branchAndBrand = new String[4];
                branchAndBrand[0] = mobileInfo[1];
                branchAndBrand[1] = mobileInfo[4];
                branchAndBrand[2] = mobileInfo[5];
                if (mobileInfo.length == 7) {
                    branchAndBrand[3] = mobileInfo[6];
                } else {
                    branchAndBrand[3] = "";
                }
                return branchAndBrand;
            }
            
        }
        return null;
    }
	/**
	 * 根据手机号码获得手机号码信息
	 * @param mobile 手机号码
	 * @param filePath 号码段文件保存路径
	 * @return
	 */
	public static MobileInfo getMobileInfo(String mobile,String filePath){
		String branchCode = null;
		MobileInfo info = new MobileInfo();
		try {
			String t[] = loadMobileInfo(mobile, filePath);
			if(t != null){
				branchCode = Branch.getBranchCode(Integer.parseInt(t[0]));
				info.setFlage(MobileInfo.SUCCESS);
			}
			else
				info.setFlage(MobileInfo.UN_EXIST);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			info.setFlage(MobileInfo.EXCEPTION);
		}
		
		info.setBranchCode(branchCode);
		return info;
	}

}
