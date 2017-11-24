package com.sunrise.boss.common.utils.export;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.OutputStream;
import java.math.BigDecimal;

import jxl.write.WritableWorkbook;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableCellFormat;
import jxl.write.Label;
import java.util.HashMap;
import java.text.NumberFormat;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletResponse;

import com.sunrise.boss.common.utils.i18n.I18nMessage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: Cyberway Commons</p>
 * <p>Description: 查询数据导出文件处理类 </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Cyberway Compucomm Co., Ltd.</p>
 * @author langx
 * @version 1.0
 */

public abstract class ExportDataCreator {
    private final String resBundle = "com.sunrise.boss.resource.i18n.common.utils";

    public static final String FIELD_SEPARATOR_REGEX = "|"; // "|"

    public static final char[] KEYWORD_ENTER = { 13, 10 };

    public String[] title = null;
    public String headtitle = null;

    //  public static final
    public static final String DATE = "DATE";

    public static final String NUMBER = "NUMBER";

    public static final String EXPRESSION = "EXPRESSION";

    public static final String CODE2NAME = "CODE2NAME";
    public static final String MORECODE2NAME = "MORECODE2NAME";
    

    public static String encodeKey;


    public List map = null;

    public HashMap hashmap = null;

    public int rowCount = 0;

    protected String fileName ;

    protected String filetype = "TXT" ;

    WritableWorkbook wwb = null;
    WritableSheet ws = null;
    Label label_excel;
    WritableCellFormat wcf = null;

    protected final static int MAX_SIZE = 5000;
    
    protected User user = null;
    
    public ExportDataCreator( User user ) {
    	this.user = user;
    }
    private static final String EXCEL_HEAD = "<head>\r\n" +
    		"	<meta http-equiv=Content-Type content=\"text/html; charset=GBK\">\r\n" +
    		"	<meta name=ProgId content=Excel.Sheet>\r\n" +
    		"	<meta name=Generator content=\"Microsoft Excel 11\">\r\n" +
    		"</head>\r\n" +
    		"<style>\r\n" +
    		"td {\r\n" +
    		"	border:#a8a8a8 soild 1px;\r\n" +
    		"	color:#000;\r\n" +
    		"	font-size:12px;\r\n" +
    		"	text-align:center;\r\n" +
    		"	background:#FFFFFF;\r\n" +
    		"	mso-number-format:\"\\@\";\r\n" +
    		"}\r\n" +
    		"</style>\r\n";

    /**
     *
     * 导出数据格式化结构
     */
    public class PropertyFormat {
        public PropertyFormat(int propertyId, String propertyName,
                              String format, String formatType) {
            this.propertyName = propertyName;
            this.format = format;
            this.formatType = formatType;
            this.propertyId = propertyId;
        }

        int propertyId;

        String propertyName;

        String format;

        String formatType;

		public String getFormat() {
			return format;
		}

		public void setFormat(String format) {
			this.format = format;
		}

		public String getFormatType() {
			return formatType;
		}

		public void setFormatType(String formatType) {
			this.formatType = formatType;
		}

		public int getPropertyId() {
			return propertyId;
		}

		public void setPropertyId(int propertyId) {
			this.propertyId = propertyId;
		}

		public String getPropertyName() {
			return propertyName;
		}

		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}
    }

    /**
     * 增加需要导出的属性，并制定导出格式
     * @param propertyId  对应集的第几个对象 多表查询中用
     * @param propertyName String
     * @param format String
     *        DATE   YYYY-MM-DD
     *        NUMBER ##.00
     *        CODE2NAME definition
     */
    public void addOutputProperty(int propertyId, String propertyName,
                                     String format, String formatType) {
        if (map == null) {
            map = new ArrayList();
        }
        map.add(new PropertyFormat(propertyId, propertyName, format,
                        formatType));
    }

    public void addOutputProperty(String propertyName, String format,
                                     String formatType) {
        addOutputProperty(0, propertyName, format, formatType);
    }

    public void addOutputProperty(String propertyName) {
        addOutputProperty(0, propertyName, null, null);
    }
    
    protected void clear() {
        if (hashmap != null) {
            hashmap.clear();
        }
        if (map != null) {
            map.clear();
        }
        rowCount = 0;
    }
    
    public void write(OutputStream os, Iterator itt, Class[] vo) throws Exception {
        if( filetype.equals("TXT") ) {
            writeTxt(os,itt,vo);
        }
        else{
        	writeExcel(os,itt,vo);
        }
    }
    public void writeNoseq(OutputStream os, Iterator itt, Class[] vo) throws Exception {
        if( filetype.equals("TXT") ) {
            writeTxtNoseq(os,itt,vo);
        }
    }

    /**
     * 写文件标头
     * @param os
     * @param title
     * @throws Exception
     */
    protected void writeTitle(OutputStream os, String[] title) throws Exception {
        if( filetype.equals("TXT") ) {
            writeTxtTitle(os,title);
        } else if(filetype.equals("EXCELSTD")) {
        	writeExcelStdTitle(os,title);
        }
        else{
            writeExcelTitle(os,title);
        }
    }
    public void writeExcelEndLine(OutputStream os, String title)
			throws Exception {
		if (headtitle != null) {
			StringBuffer sb = new StringBuffer();
			sb.append(title);
			os.write(cvtToGBK(sb.toString()));
			beforeWrite(os);
			sb.setLength(0);
		}
	}
    private void writeExcelTitle(OutputStream os, String[] title) throws Exception {
    	os.write(EXCEL_HEAD.getBytes());
    	if( headtitle != null ){
    		StringBuffer sb = new StringBuffer();
    		sb.append("<table bordercolor=#A8A8A8><tr>")
				.append("<td colspan=").append(title.length+1).append(">")
				.append( headtitle ).append("</td></tr>");
			os.write(cvtToGBK(sb.toString()));
			beforeWrite( os  );
			sb.setLength(0);
			sb.append("</table>");
    	}
		 os.write(new StringBuffer("<table border=1 bordercolor=#A8A8A8>").append(KEYWORD_ENTER).toString().getBytes());
    	if (title != null) {
           
            os.write(cvtToGBK("<tr><td>序号</td>"));
            
            os.write(new String(KEYWORD_ENTER).getBytes());
            for (int i = 0; i < title.length; i++) {
                if (i == (title.length - 1)) {
                    os.write(cvtToGBK("<td>"+title[i]+"</td></tr>"));
                    os.write(new String(KEYWORD_ENTER).getBytes());
                } else {
                    os.write(cvtToGBK("<td>"+title[i]+"</td>"));
                }
            }
        }
    }
    
    private void writeExcelStdTitle(OutputStream os, String[] title) throws Exception {
        if( wwb == null ){
//			 init
            wwb = Workbook.createWorkbook(os);
            //ws = wwb.createSheet(I18nMessage.getString(resBundle, "export_info_querylog"), 0);
            ws = wwb.createSheet(fileName,0);
            wcf = new WritableCellFormat();
            wcf.setBackground(jxl.format.Colour.YELLOW);
        }
//		 print title
        if (title != null) {
            //label_excel = new Label(0, 0, I18nMessage.getString(resBundle, "export_info_serial"), wcf);
        	label_excel = new Label(0,0,"序号");
            ws.addCell(label_excel);
            for (int i = 0; i < title.length; i++) {
                label_excel = new Label(i + 1, 0, title[i], wcf);
                ws.addCell(label_excel);
            }
        } else {
            throw new Exception(I18nMessage.getString(resBundle, "export_err_notitle"));
        }
    }

    public void writeTxtTitle(OutputStream os, String[] title) throws Exception {
        //print title
        if (title != null) {
            //os.write( I18nMessage.getString(resBundle, "export_info_serial").getBytes());
        	os.write(cvtToGBK("序号"));
            os.write(FIELD_SEPARATOR_REGEX.getBytes());
            //        resultFile.writeBytes(new String(TITLE.getBytes("GBK"), "iso8859_1") + "\r\n")
            for (int i = 0; i < title.length; i++) {
                if (i == (title.length - 1)) {
                    os.write(cvtToGBK( title[i]));
                    os.write(new String(KEYWORD_ENTER).getBytes());
                } else {
                    os.write(cvtToGBK( title[i] ));
                    os.write(FIELD_SEPARATOR_REGEX.getBytes());
                }
            }
        }
    }
    //写文件头 无序列字段
    public void writeTxtTitleNoseq(OutputStream os, String[] title) throws Exception {
        //print title
        if (title != null) {           
            for (int i = 0; i < title.length; i++) {
                if (i == (title.length - 1)) {
                    os.write(cvtToGBK( title[i]));
                    os.write(new String(KEYWORD_ENTER).getBytes());
                } else {
                    os.write(cvtToGBK( title[i] ));
                    os.write(FIELD_SEPARATOR_REGEX.getBytes());
                }
            }
        }
    }

  

    /**
     * 导出为TXT文件格式的文件
     * @param os OutputStream
     * @param vo Class
     */
    private void writeTxt(OutputStream os, Iterator itt, Class[] vo)
            throws Exception {
        try {
        	//writeTxtTitle(os,title);//增加了写文件头
            //print datas
            if (itt != null) {
                while (itt.hasNext()) {
                    rowCount++;
                    StringBuffer buff = new StringBuffer();
                    Object ob = itt.next();
                    Object[] obs = null;
                    if (vo.length > 1) {
                        obs = (Object[]) ob;
                    } else {
                        obs = new Object[1];
                        obs[0] = ob;
                    }

                    if (map == null) {
                        break;
                    }
                    buff.append(rowCount).append(FIELD_SEPARATOR_REGEX);
                    for (int i = 0; i < map.size(); i++) {
                        PropertyFormat propertyFormat = (PropertyFormat) map
                                .get(i);

                        if (EXPRESSION.equals(propertyFormat.format)) { //处理两值相加的表达式
                            String value = expressionProc(obs, vo,
                                    propertyFormat.propertyName,
                                    propertyFormat.formatType);
                            buff.append(value).append(FIELD_SEPARATOR_REGEX);

                        } else {
                            Object value = getValue(obs, vo,
                                    propertyFormat.propertyId,
                                    propertyFormat.propertyName);
                            buff.append(formatData(propertyFormat, value))
                                    .append(FIELD_SEPARATOR_REGEX);
                        }
                    } // end for
                    //if (buff.length() > 0)
                        //buff.deleteCharAt(buff.length() - 1);
                    buff.append(KEYWORD_ENTER);
                    os.write(cvtToGBK( buff.toString() ));
                    os.flush();
                } // end while
            }
        } catch (Exception e) {
            e.printStackTrace();
            //throw new Exception(" Can`t match the VO type ");
        } finally {
            os.flush();
        }
    }
    private void writeTxtNoseq(OutputStream os, Iterator itt, Class[] vo) throws Exception {
		try {
			//writeTxtTitle(os,title);//增加了写文件头
		    //print datas
		    if (itt != null) {
		        while (itt.hasNext()) {
		            rowCount++;
		            StringBuffer buff = new StringBuffer();
		            Object ob = itt.next();
		            Object[] obs = null;
		            if (vo.length > 1) {
		                obs = (Object[]) ob;
		            } else {
		                obs = new Object[1];
		                obs[0] = ob;
		            }
		
		            if (map == null) {
		                break;
		            }
		            //buff.append(rowCount).append(FIELD_SEPARATOR_REGEX);
		            for (int i = 0; i < map.size(); i++) {
		                PropertyFormat propertyFormat = (PropertyFormat) map
		                        .get(i);
		
		                if (EXPRESSION.equals(propertyFormat.format)) { //处理两值相加的表达式
		                    String value = expressionProc(obs, vo,
		                            propertyFormat.propertyName,
		                            propertyFormat.formatType);
		                    buff.append(value).append(FIELD_SEPARATOR_REGEX);
		
		                } else {
		                    Object value = getValue(obs, vo,
		                            propertyFormat.propertyId,
		                            propertyFormat.propertyName);
		                    buff.append(formatData(propertyFormat, value))
		                            .append(FIELD_SEPARATOR_REGEX);
		                }
		            } // end for
		            //if (buff.length() > 0)
		                //buff.deleteCharAt(buff.length() - 1);
		            buff.append(KEYWORD_ENTER);
		            os.write(cvtToGBK( buff.toString() ));
		            os.flush();
		        } // end while
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    //throw new Exception(" Can`t match the VO type ");
		} finally {
		    os.flush();
		}
	}

    /**
     * 生成Excel格式的文件
     * @param os OutputStream
     * @param vo Class
     */
    private void writeExcelStd(OutputStream os, Iterator itt, Class[] vo
            ) throws Exception {
        try {
            if( wwb == null ){
//				 init
                wwb = Workbook.createWorkbook(os);
                ws = wwb.createSheet(I18nMessage.getString(resBundle, "export_info_querylog"), 0);
                wcf = new WritableCellFormat();
                wcf.setBackground(jxl.format.Colour.YELLOW);
            }

            if (itt != null) {
                while (itt.hasNext()) {
                    rowCount++;
                    Object ob = itt.next();
                    Object[] obs = null;
                    if (vo.length > 1) {
                        obs = (Object[]) ob;
                    } else {
                        obs = new Object[1];
                        obs[0] = ob;
                    }

                    if (map == null) {
                        break;
                    }
                    label_excel = new Label(0, rowCount, String
                            .valueOf(rowCount));
                    ws.addCell(label_excel);
                    for (int i = 0; i < map.size(); i++) {
                        PropertyFormat propertyFormat = (PropertyFormat) map
                                .get(i);
                        if (EXPRESSION.equals(propertyFormat.format)) {
                            String value = expressionProc(obs, vo,
                                    propertyFormat.propertyName,
                                    propertyFormat.formatType);
                            label_excel = new Label(i + 1, rowCount, value);
                            ws.addCell(label_excel);
                        } else {
                            Object value = getValue(obs, vo,
                                    propertyFormat.propertyId,
                                    propertyFormat.propertyName);
                            label_excel = new Label(i + 1, rowCount,
                                    formatData(propertyFormat, value));
                            ws.addCell(label_excel);
                        }
                    } // end for

                } // end while

            }

        } catch (Exception e) {
            e.printStackTrace();
            //throw new Exception(" Can`t match the VO type ");
        } finally {
        }
    }
    
    public void writeStdLines( OutputStream os,String[] line ) throws Exception {
    	if( wwb == null ){
            wwb = Workbook.createWorkbook(os);
            //ws = wwb.createSheet(I18nMessage.getString(resBundle, "export_info_querylog"), 0);
            ws = wwb.createSheet(fileName,0);
            wcf = new WritableCellFormat();
            wcf.setBackground(jxl.format.Colour.YELLOW);
        }
    	
    	
        if (line != null) {
        	int rowcount = ws.getRows();
            for (int i = 0; i < line.length; i++) {
                label_excel = new Label(i , rowcount, line[i], wcf);
                ws.addCell(label_excel);
            }
        } else {
            throw new Exception("error write lines.");
        }
    }
    
    public void writeLines( OutputStream os,String[] line ) throws Exception {
    	
        if (line != null) {
        	StringBuffer buff = new StringBuffer();
        	buff.append("<tr>");
            for (int i = 0; i < line.length; i++) {
            	buff.append("<td>");
            	buff.append(line[i]);
            	buff.append("</td>");
            }
            buff.append("</tr>");
            os.write(cvtToGBK(buff.toString()));

        } else {
            throw new Exception("error write lines.");
        }
        
    }
    
    /**
     * 导出为HTML文件格式转换EXCEL格式的文件
     * @param os OutputStream
     * @param vo Class
     */
    private void writeExcel(OutputStream os, Iterator itt, Class[] vo)
            throws Exception {
    	try {

            //print datas
    		
            if (itt != null) {
            	
                while (itt.hasNext()) {
                	StringBuffer buff = new StringBuffer();
                	buff.append("<tr>");
                    rowCount++;
                    
                    Object ob = itt.next();
                    Object[] obs = null;
                    if (vo.length > 1) {
                        obs = (Object[]) ob;
                    } else {
                        obs = new Object[1];
                        obs[0] = ob;
                    }

                    if (map == null) {
                        break;
                    }
                    buff.append("<td>").append(rowCount).append("</td>");
                    for (int i = 0; i < map.size(); i++) {
                        PropertyFormat propertyFormat = (PropertyFormat) map
                                .get(i);

                        if ( EXPRESSION.equals(propertyFormat.format)) { //处理两值相加的表达式
                            String value = expressionProc(obs, vo,
                                    propertyFormat.propertyName,
                                    propertyFormat.formatType);
                            buff.append("<td>").append(value).append("</td>");

                        } else {
                            Object value = getValue(obs, vo,
                                    propertyFormat.propertyId,
                                    propertyFormat.propertyName);
                            buff.append("<td>").append( formatData(propertyFormat, value) )
                                    .append("</td>");
                        }
                    } // end for
                    buff.append("</tr>");
                    buff.append(KEYWORD_ENTER);
                    os.write(cvtToGBK( buff.toString() ));
                    os.flush();
                } // end while
            }
        } catch (Exception e) {
            e.printStackTrace();
            //throw new Exception(" Can`t match the VO type ");
        } finally {
            os.flush();
        }
        
    }

    public void buildTxtPage( Object queryVO, HttpServletResponse resp ) throws Exception {
        //指定文件类型
        this.filetype = "TXT";
        // 写表头
        writeTitle();
        writeTitle( resp.getOutputStream() ,title );

        //查询数据
        queryPages( resp.getOutputStream(), queryVO, user);
    }
    
    public void buildExcelStdPage( Object queryVO, HttpServletResponse resp ) throws Exception {
        //指定文件类型
        this.filetype = "EXCELSTD";
        // 写表头
        writeTitle();
        writeTitle( resp.getOutputStream() ,title );

        //查询数据
        queryPages( resp.getOutputStream(), queryVO, user);
    }

    public void buildExcelPage( Object queryVO, HttpServletResponse resp ) throws Exception {
        //指定文件类型
        this.filetype = "EXCEL";
        // 写表头
        writeTitle();
        writeTitle( resp.getOutputStream() ,title );

        //查询数据
        queryPages( resp.getOutputStream(), queryVO, user) ;
        resp.getOutputStream().write("</table>".toString().getBytes());

    		StringBuffer sb = new StringBuffer();
    		sb.append("<table bordercolor=#A8A8A8>");
    		resp.getOutputStream().write(cvtToGBK(sb.toString()));
    		afterWrite(resp.getOutputStream());
			sb.setLength(0);
			sb.append("</table>");
			resp.getOutputStream().write(cvtToGBK(sb.toString()));

    }

    protected void close() throws Exception {
    	if (filetype.equals("EXCEL")) {
    		return;
    	}
        if( !filetype.equals("TXT")){
            if (wwb != null){
                wwb.write();
                wwb.close();
            }
        }
        
    }

    protected abstract void queryPages( OutputStream os,Object queryVO, User opr) throws Exception;

    protected abstract void writeTitle();
    
    protected void beforeWrite( OutputStream os ) throws Exception{
    	
    }
    
    protected void afterWrite( OutputStream os ) throws Exception{
    	
    }

    protected abstract String codeToName( String propertyName, String code ,User user);
    protected  String moreCodeToName( String propertyName, String code ,User user){return "";}

    /**
     * 将数据按规定的格式格式化
     * @param propertyFormat PropertyFormat
     * @param value Object
     * @return String
     * @throws Exception
     */
    protected String formatData(PropertyFormat propertyFormat, Object value)
            throws Exception {
        if (value == null) {
            return "";
        }
        if (propertyFormat.format == null) {
            return value.toString();
        } else if (propertyFormat.format.equals("DATE")) {
            // need add
            if (value instanceof java.sql.Timestamp) {
                java.sql.Timestamp date = (java.sql.Timestamp) value;
                DateFormat format = new SimpleDateFormat(
                        propertyFormat.formatType);
                return format.format(date);
            } else {
                return value.toString();
            }
        } else if (propertyFormat.format.equals("NUMBER")) {
            NumberFormat numberFormat = new DecimalFormat(
                    propertyFormat.formatType);
            double strdouble;
            if (value!=null && value.getClass()==String.class) {
            	if ("".equals(value)) {
            		value="0.00";
            	}
            	strdouble = Double.valueOf((String)value).doubleValue();
            	return numberFormat.format(strdouble);
            }
            	return numberFormat.format(value);
        } else if (propertyFormat.format.equals("CODE2NAME")) {
            return codeToName(propertyFormat.propertyName,String.valueOf(value), user);
        } else if (propertyFormat.format.equals("MORECODE2NAME")) {
            return moreCodeToName(propertyFormat.propertyName,String.valueOf(value), user);
        } 
        else {
            return value.toString();
        }

    }

    /**
     * 处理表达式的函数 现只支持 ＋ － 两种简单表达式
     * @param property Object[]
     * @param vo Class[]
     * @param expression String
     * @param type String
     * @return String
     */
    protected String expressionProc(Object[] property, Class[] vo,
                                  String expression, String type) {
        int pos = 0;
        
        List propertys = new ArrayList();
        List oprs = new ArrayList(0);
        
        splitOpr( expression, propertys, oprs );
        
        if( "DOUBLE".equals(type) ) {
        
	        Double valueD = (Double) getValue(property, vo,
	                getPropertyFormat( propertys.get(0).toString() ).propertyId, propertys.get(0).toString());
	        
	        for( int i=0;i<oprs.size();i++ ){
	        	if( "-".equals(oprs.get(i).toString()) ) {
	        		Double valueDtemp = (Double) getValue(property, vo,
	    	                getPropertyFormat( propertys.get(i+1).toString() ).propertyId, propertys.get(i+1).toString());
	        		BigDecimal num1 = new BigDecimal( valueD==null?0:valueD.doubleValue() );
	        		BigDecimal num2 = new BigDecimal( valueDtemp==null?0:valueDtemp.doubleValue());
	        		num1 = num1.subtract(num2);
	        		valueD = new Double( num1.doubleValue() );
	        	}
	        	if( "+".equals(oprs.get(i).toString()) ) {
	        		Double valueDtemp = (Double) getValue(property, vo,
	    	                getPropertyFormat( propertys.get(i+1).toString() ).propertyId, propertys.get(i+1).toString());
	        		BigDecimal num1 = new BigDecimal( valueD==null?0:valueD.doubleValue() );
	        		BigDecimal num2 = new BigDecimal( valueDtemp==null?0:valueDtemp.doubleValue());
	        		num1 = num1.add(num2);
	        		valueD = new Double( num1.doubleValue() );
	        	}
	        	if( "*".equals(oprs.get(i).toString()) ) {
	        		Double valueDtemp = (Double) getValue(property, vo,
	    	                getPropertyFormat( propertys.get(i+1).toString() ).propertyId, propertys.get(i+1).toString());
	        		BigDecimal num1 = new BigDecimal( valueD==null?0:valueD.doubleValue() );
	        		BigDecimal num2 = new BigDecimal( valueDtemp==null?0:valueDtemp.doubleValue());
	        		num1 = num1.multiply(num2);
	        		valueD = new Double( num1.doubleValue() );
	        	}
	        	if( "/".equals(oprs.get(i).toString()) ) {
	        		Double valueDtemp = (Double) getValue(property, vo,
	    	                getPropertyFormat( propertys.get(i+1).toString() ).propertyId, propertys.get(i+1).toString());
	        		BigDecimal num1 = new BigDecimal( valueD==null?0:valueD.doubleValue() );
	        		BigDecimal num2 = new BigDecimal( valueDtemp==null?0:valueDtemp.doubleValue());
	        		num1 = num1.divide(num2,10, BigDecimal.ROUND_HALF_UP);
	        		valueD = new Double( num1.doubleValue() );
	        	}
	        }
	        NumberFormat numberFormat = new DecimalFormat("0.00");
            return numberFormat.format( valueD );
        }
        
        return "";
    }
    
    private void splitOpr( String expression , List propertys, List oprs ) {
    	
    	char[] oprmodel = {'+','-','*','/'};
    	int pos=0;
    	
    	boolean breakflg = true;
    	while( breakflg ) {
    		
    		int posnew=-1;
    		String opr = "";
    		
	    	for( int i=0;i< oprmodel.length ;i ++ ){
	    		int pos1 = expression.indexOf( oprmodel[i], pos );
	    		if( pos1 != -1 && (pos1 < posnew || posnew == -1 ) ) {
	    			posnew = pos1;
	    			opr = String.valueOf( oprmodel[i] );
	    		}
	    	}
	    	
	    	if( posnew == -1 ){
				propertys.add( expression.substring( pos ) );
				breakflg = false;
				break;
	    	}
	    	else{
	    		propertys.add( expression.substring( pos , posnew ) );
    			oprs.add( String.valueOf( opr ) );
    			pos = posnew + 1 ;
	    	}
    	}
    }

    private PropertyFormat getPropertyFormat(String key) {
        if (hashmap == null) {
            hashmap = new HashMap();
            for (int i = 0; i < map.size(); i++) {
                PropertyFormat ift = (PropertyFormat) map.get(i);
                hashmap.put(ift.propertyName, ift);
            }
        }
        if (hashmap.containsKey(key)) {
            return (PropertyFormat) hashmap.get(key);
        }
        return null;
    }

    protected Object getValue(Object[] property, Class[] vo, int propertyid,
                            String propertyName) {
        Object ret = "";

        try {

            String methodName = "get"
                    + propertyName.substring(0, 1).toUpperCase()
                    + propertyName.substring(1);
            ret = (property[propertyid].getClass().forName(vo[propertyid]
                    .getName())).getDeclaredMethod(methodName, new Class[] {})
                    .invoke(property[propertyid], null);

        } catch (NoSuchMethodException me) {
            me.printStackTrace();
        } catch (ClassNotFoundException me) {
            me.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }
    
    
    //修改该方法，不做编码转换 （这里认为str为gbk编码的字符串）
    public byte[] cvtToGBK( String str ) {
    	if(str==null){
    		return "".getBytes();
    	}else{
    		return str.getBytes();
    	}
    	
//    	try{
//    		if( encodeKey == null ){
//    			encodeKey = System.getProperty("file.encoding");
//    		}
//    		if( !encodeKey.equals("GBK") ) {
//	    		str = new String( str.getBytes("GBK"), encodeKey );
//	    		return str.getBytes();
//    		}
//    		else{
//    			return str.getBytes();
//    		}
//    		
////    		str = new String( str.getBytes("GBK"), "ISO8859-1" );
////    		return str.getBytes();
//    	}
//    	catch ( Exception ex ) {
//    		return "".getBytes();
//    	}
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

	public String getFiletype() {
		return filetype;
	}


}
