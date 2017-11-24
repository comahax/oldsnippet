<%@ page import= "java.io.*,com.sunrise.boss.common.utils.export.ExportDataCreator" %><%
    try{
        Object queryVO = request.getAttribute("queryVO");
        
        ExportDataCreator creator = (ExportDataCreator)request.getAttribute("creator");
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-control","public");
        response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
        String fn = "attachment; filename="+creator.getFileName()+".txt";  

        response.setHeader("Content-Disposition", new String(fn.getBytes("GB2312"),
                                        "ISO-8859-1"));
        response.setContentType("application/x-msdownload");
        creator.buildTxtPage( queryVO,response );
    }catch( Exception ee ){
        ee.printStackTrace();
    }
%>