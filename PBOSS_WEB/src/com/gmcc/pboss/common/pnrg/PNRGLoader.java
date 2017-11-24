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
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-8-18
 * ������Ŀ��
 * ����ģ�飺
 * ������
 * 		�й��ƶ�������ļ�����
 */
public class PNRGLoader {
	protected static final Log logger = LogFactory.getLog(PNRGLoader.class);
	
	/**������ļ����һ���޸�ʱ��*/
	private static long rangeLastModified = 0;
	private static Map rangeHash = null;
	private static List rangeList = null;
	
	/**������ļ�����*/
	private static final String PNRG = "PNRG.cfg";
	
	/**
	 * ��������ļ����ص��ڴ���
	 * @param filePath ����·��
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
     * @description: ���غ�����ļ����ڴ��У��Ż��˼����߼����ѺŶο�ʼ�ͺŶν���ǰ7λ��ͬ��,��ǰ7λΪKEY�Ž�һ��HASHTABLE�У�
     * ����HASHTABLE�е�KEY����Ψһ��KEY���ظ��ͺŶο�ʼ�ͺŶν���ǰ7λ��һ�¶�������һ��LIST��ļ�����������±���LIST��
     * �Ѵ���LIST�ԺŶο���7λΪKEY������Ҳ����HASHTABLE��ĺŶ���Ϣȡ�������ӵ�LIST�Ȼ���HASHTABLE��ɾ����
     * @param: 
     * @return: 
     * @throws: 
     */
	private static void load(FileInputStream fis) throws IOException {
		logger.info(">>>����PNRG_FILE ������ļ�");
		
        String tmp = null;
        rangeList = new ArrayList();
        rangeHash = new Hashtable();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
//        long start = System.currentTimeMillis();
        String[] t = null;
        
        while ((tmp = br.readLine()) != null) {
            t = tmp.split(",");
            //����θ�ʽ��ȷ����ţ����б��룬��ʼ�ŶΣ������ŶΣ�Ʒ�Ʊ��룬�Ŷα�ʶ
            if (t != null && (t.length == 6 || t.length == 7) 
            		&& t[2].length() == 11 && t[3].length()==11) {
                /*
                 * �Ŷο�ʼ�ͺŶν���ǰ7λ��ͬ��,��ǰ7λΪKEY�Ž�һ��HASHTABLE��
                 */
            	if (rangeHash.get(t[2].substring(0, 7)) == null 
                        && t[2].substring(0, 7).equals(t[3].substring(0, 7))
                        && "0000".equals(t[2].substring(7))
                        && "9999".equals(t[3].substring(7))) {
                    rangeHash.put(t[2].substring(0, 7), t);
                }
            	/*
            	 * ��һ�¶�������һ��LIST��
            	 */
                else {
                    rangeList.add(t);
                }
            } 
            else {
                logger.info("�Ŷ����ݳ���:" + tmp);
            }
        }
        
        br.close();
        
        logger.info("remove before:" + rangeHash.size());
        /*
         * �Ѵ���LIST�ԺŶο���7λΪKEY������Ҳ����HASHTABLE��ĺŶ���Ϣȡ����
         * ���ӵ�LIST�Ȼ���HASHTABLE��ɾ��
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
	 * ���غ�����Ϣ
	 * @param mobile �ֻ�����
	 * @param filePath ������ļ�����·��
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
                //System.out.println("��HASHTABLE��ȡ���ݡ���������");
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
	 * �����ֻ��������ֻ�������Ϣ
	 * @param mobile �ֻ�����
	 * @param filePath ������ļ�����·��
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
