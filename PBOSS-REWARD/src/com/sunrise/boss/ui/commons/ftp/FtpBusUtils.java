package com.sunrise.boss.ui.commons.ftp;

import java.util.Iterator;

import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

import javax.servlet.http.HttpServlet;

public class FtpBusUtils {

    public final static String DOWNLOAD_SYSID = "51"; //��ϵͳ����ָ��"�����걨�ļ����Ŀ¼"
    public final static String UPLOAD_SYSID = "52"; //��ϵͳ����ָ��"���ʺ�׼�ļ����Ŀ¼"
    public final static String SYSPARAM_BILLING = "billing"; //ϵͳ��������:����

    /**
     * ��ȡ�ļ�����Ŀ¼
     * @param user
     * @return
     * @throws Exception
     */
    public static String getDownloadPath( User user )
    throws Exception {
        CommonDelegate delegate = new CommonDelegate( SysparamVO.class );
        SysparamListVO listvo = new SysparamListVO();
        listvo.set_ne_systemid( DOWNLOAD_SYSID );
        listvo.set_se_paramtype( SYSPARAM_BILLING );
        Iterator it = delegate.doQuery( listvo, user, false ).getDatas().iterator();

        SysparamVO vo = null;
        if( it!=null && it.hasNext() ){
            vo = (SysparamVO)it.next();
            return vo.getParamvalue();
        } else {
            throw new Exception( "[FTP-MSG]\t��ϵͳ���������Ҳ���������ʶΪ51(ָ�������걨�ļ����Ŀ¼)�Ĳ�������" );
        }
    }

    /**
     * ��ȡ�ļ��ϴ�Ŀ¼
     * @param user
     * @return
     * @throws Exception
     */
    public static String getUploadPath( User user )
    throws Exception {
        CommonDelegate delegate = new CommonDelegate( SysparamVO.class );
        SysparamListVO listvo = new SysparamListVO();
        listvo.set_ne_systemid( UPLOAD_SYSID );
        listvo.set_se_paramtype( SYSPARAM_BILLING );
        Iterator it = delegate.doQuery( listvo, user, false ).getDatas().iterator();

        SysparamVO vo = null;
        if( it!=null && it.hasNext() ){
            vo = (SysparamVO)it.next();
            return vo.getParamvalue();
        } else {
            throw new Exception( "[FTP-MSG]\t��ϵͳ���������Ҳ���������ʶΪ52(ָ�����ʺ�׼�ļ����Ŀ¼)�Ĳ�������" );
        }
    }

    public static String getDownloadRealPath(HttpServlet servlet) throws Exception {
        String location = getDownloadPath(servlet);

        // String webappPath = getServlet().getInitParameter("uplocation");
        int strLength = location.length();
        String pathSeperator = location.substring(strLength - 1, strLength);
        location = servlet.getServletConfig().getServletContext().getRealPath(location);
        location = location + pathSeperator;
        return location;
    }

    public static String getDownloadPath(HttpServlet servlet) throws Exception {
        String location = servlet.getServletConfig().getInitParameter(
                "downloadlocation");
        if (location == null || location.equals("")) {
            throw new Exception("�ļ�·��û�����ã������web.xml��uploadlocation������!");
        }
        return location;
    }

    public static String getDownloadFilename(HttpServlet servlet, String filepath) throws Exception {
        return getDownloadPath(servlet) + getFilenameFromPath(filepath);
    }

    public static  String getFilenameFromPath(String remoteFilePath) {
        int pos = remoteFilePath.lastIndexOf("/");
        if (pos >= 0) {
            return remoteFilePath.substring(pos + 1);
        } else{
        	return remoteFilePath;
        }
    }
}
