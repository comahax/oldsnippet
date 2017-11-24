package com.asisinfo.common.web.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * �����ļ��ã������ļ�������վĿ¼�ڣ����Բ���ֱ�����������أ�ֻ��ͨ��servlet����
 * ������� filename
 * @author Administrator
 *
 */
public class DownFileServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final long serialVersionUID = 1L;

	private String defaultEncoding = "utf-8";//post���뷽ʽ
	

	public void init(ServletConfig config)throws ServletException 
	{
		super.init(config) ;
        if (config.getInitParameter("encoding") != null) {
			this.defaultEncoding = config.getInitParameter("encoding");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String encode = request.getCharacterEncoding();
			request.setCharacterEncoding((encode != null) ? encode
					: defaultEncoding);
            String filename = request.getParameter("filename");
            String pathname = request.getParameter("pathname");
            String downloadname = StringUtils.isEmpty(request.getParameter("downloadname"))
            		?filename:request.getParameter("downloadname");

			String filepath = FilePathLoader.getInstance().getFilePath(pathname,filename);
			
			File file = new File(filepath);
			long filesize = 0l;

            if(file.exists()){
				filesize = file.length(); 
			}else{
				response.setCharacterEncoding( "utf-8");
				response.setContentType( "text/html;charset=utf-8");			
				PrintWriter out = response.getWriter() ;			
				out.println("<script language=javascript>");
				out.println("window.alert('�ļ������ڣ�');");
				out.println("</script>");
				return ;
			}
			file = null;
			BufferedInputStream byteStream = new BufferedInputStream (new FileInputStream(filepath));
			response.setContentType("application/download;charset=UTF-8");
			response.setHeader("Content-Disposition" , "attachment;filename=" + new String(downloadname.getBytes("utf-8") , "ISO-8859-1")) ;
			response.setHeader( "Content-Length", Long.toString( filesize ));
			ServletOutputStream outStream =  response.getOutputStream()  ;
			byte anp[] = new byte[51200];
			
			int ncount = 0;
			while (true) {
				ncount = byteStream.read(anp, 0, 51200);
				if (ncount == -1)
					break;
				else
					outStream.write(anp, 0, ncount);
			}
			outStream.flush();
			byteStream.close() ;
			anp = null;
		}catch(Exception e){
			logger.error("�����ļ�����", e);
		}
		
	}
	
	public String getDefaultEncoding() {
		return defaultEncoding;
	}
	public void setDefaultEncoding(String defaultEncoding) {
		this.defaultEncoding = defaultEncoding;
	}
	
    
}
