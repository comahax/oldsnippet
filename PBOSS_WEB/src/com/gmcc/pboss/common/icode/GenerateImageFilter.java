package com.gmcc.pboss.common.icode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.filter.BaseFilter;



/**
 * 生成图形校验码
 */
public class GenerateImageFilter extends BaseFilter {
	private Logger logger = Logger.getLogger(GenerateImageFilter.class);
    /**
     * 
     */
    private static final long serialVersionUID = 458893798396156476L;
    
//    private static final String[] mkdir = new String[] { "image01", "image02",
//            "image03", "image04", "image05", "image06", "image07", "image08",
//            "image09", "image10" };
    
   
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
    	HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		this.service(request, response);
		
		return;
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // String serverName = "gd.chinamobile.com";
        
        String beferUrl = request.getHeader("referer");
        //logger.info("beferUrl:" + beferUrl);
        //logger.info("request.getServerName():" + request.getServerName());
        
        // 判断是不是通过正确的URL访问，如果不是，刚不显示图片
        if (beferUrl != null && beferUrl.indexOf(request.getServerName()) != -1) {
            
        	// 判断是否要生成６位随机验证码---tz
            String isSixNumber = (String) request.getParameter("isSix");
            // logger.info("isSixNumber="+isSixNumber);
            if (isSixNumber != null && isSixNumber.equals("yes")) {
                genera6Numbers(request, response);
            } 
            
            else{
                
            	//验证码
                String rndImg = ImageArray.getString();
                logger.info("Image Code In Session >>> " + rndImg);
                request.getSession().setAttribute(HttpDictionary.ICODE_NAME,
                		String.valueOf(rndImg).toLowerCase());
                
                ServletOutputStream sos = response.getOutputStream();
                response.setContentType("image/jpeg");
                //验证码保存路径
                String path = FileConfigAdapter.getImagePath();
                /*
                java.io.File file = new java.io.File(path
                        + mkdir[(int) (Math.random() * mkdir.length)] + "/"
                        + rndImg + ".jpg");
                */
                StringBuffer sb = new StringBuffer();
                sb.append(path).append(rndImg).append(".jpg");
                
                File file = new File(sb.toString());
                java.io.FileInputStream is = new java.io.FileInputStream(file);
                
                byte[] b = new byte[4096];
                int nRead;
                while ((nRead = is.read(b, 0, 1024)) > 0) {
                    sos.write(b, 0, nRead);
                }
                sos.flush();
                sos.close();
                is.close();
            }// end else
        }
    }
    
//    private Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
//        Random random = new Random();
//        if (fc > 255)
//            fc = 255;
//        if (bc > 255)
//            bc = 255;
//        int r = fc + random.nextInt(bc - fc);
//        int g = fc + random.nextInt(bc - fc);
//        int b = fc + random.nextInt(bc - fc);
//        return new Color(r, g, b);
//    }
    
    /**
     * 生成６位的随机验证码 tz
     */
    public void genera6Numbers(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        ServletOutputStream sos = response.getOutputStream();
        // 得到６位随机验证码
        String rndImg = SixImageArray.getString();
        // 图片存放路径
        String jpgPath = "/projects/gmcc/siximage/pic/" + rndImg + ".jpg";
        // logger.info("图片存放路径="+jpgPath);
        // 存放入session中：_CMGD_WEB_6_IMAGECODE
        request.getSession().setAttribute("_CMGD_WEB_SIX_IMAGECODE",
                String.valueOf(rndImg).toLowerCase());
        // 读图片
        File file = new java.io.File(jpgPath);
        FileInputStream is = new java.io.FileInputStream(file);
        
        byte[] b = new byte[4096];
        int nRead;
        while ((nRead = is.read(b, 0, 1024)) > 0) {
            sos.write(b, 0, nRead);
        }
        sos.flush();
        sos.close();
        is.close();
        // return;
    }
    
}
