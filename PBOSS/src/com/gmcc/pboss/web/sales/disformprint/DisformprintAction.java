/**
 * auto-generated code
 * Sat Aug 13 12:50:41 CST 2011
 */
 package com.gmcc.pboss.web.sales.disformprint;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Iterator;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
 
import com.gmcc.pboss.business.sales.disformprint.DisformprintVO ;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.sales.disformprint.DisformprintDBParam;
import com.gmcc.pboss.control.sales.disformprint.Disformprint;
import com.gmcc.pboss.control.sales.disformprint.DisformprintBO;
import com.gmcc.pboss.business.sales.disformprint.CountyComInfo;
import com.gmcc.pboss.business.sales.disformprint.DisformFullInfo;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.disformprint.ComIccInfo;

/**
 * <p>Title: DisformprintAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformprintAction extends BaseAction{
	//获取配送单样式输出间隔行数
	private int emptySpan;
	//导出Excel文件的头部
	private static final String EXCEL_START="<html xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n" +
											"xmlns:x=\"urn:schemas-microsoft-com:office:excel\"\n" +
											"xmlns=\"http://www.w3.org/TR/REC-html40\">\n" +
											"<head>\n" +
											"	<meta http-equiv=Content-Type content=\"text/html; charset=GBK\">\n" +
											"	<meta name=ProgId content=Excel.Sheet>\n" +
											"	<meta name=Generator content=\"Microsoft Excel 11\">\n" +
											"	<style>\n" +
											"	.text {\n" +
											"		border:#a8a8a8 soild 1px;\n" +
											"		color:#000;\n" +
											"		font-size:12px;\n" +
											"		text-align:center;\n" +
											"		background:#FFFFFF;\n" +
											"		mso-number-format:\"\\@\";\n" +
											"	}\n" +
											"	.longtext {\n" +          //上面的格式风格长文本不能显示
											"		border:#a8a8a8 soild 1px;\n" +
											"		color:#000;\n" +
											"		font-size:12px;\n" +
											"		text-align:center;\n" +
											"		background:#FFFFFF;\n" +
											"	}\n" +
											"	</style>\n" +
											"</head>\n" +
											"<body>\n";
	//导出Excel文件的结尾
	private static final String EXCEL_END="\n</body>\n</html>";

	public DisformprintAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new DisformprintForm());
		this.setParam(new DisformprintDBParam());

        //指定VO类
        setClsVO(DisformprintVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"recid"};
		this.setClsControl(Disformprint.class);
		this.setClsQueryParam(DisformprintDBParam.class) ;

	}
	
	@Override
	public String doList(){
		DisformprintForm form =(DisformprintForm)getForm();
		try{
			Disformprint dis = (DisformprintBO)BOFactory.build(DisformprintBO.class, getDBAccessUser());
			DisformprintDBParam params = (DisformprintDBParam)this.getParam();
			params.setDataOnly(true);
			params.set_pagesize("0");
			params.setQueryAll(true);
			
			DataPackage dp = dis.doCountyComStat(params);
			this.setDp(dp);
			
			Long allcount = 0L;
			List<CountyComInfo> list = dp.getDatas();
			for(CountyComInfo info : list){
				long count = info.getNum();
				allcount = allcount + count;
			}
			form.setAllcount(allcount);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getCause() == null ? e.getMessage() : e
					.getCause().getMessage());
			//AAUtilsForStruts2.addZonesToRefresh("refreshTable");
		}		
		//AAUtilsForStruts2.addZonesToRefresh("refreshTable");
		return "list";
	}
	
	public String doExportExcel_bak(){
		try{
			Disformprint dis = (DisformprintBO)BOFactory.build(DisformprintBO.class, getDBAccessUser());
			DisformprintDBParam params = (DisformprintDBParam)this.getParam();
			params.setDataOnly(true);
			params.set_pagesize("0");
			
			//配送单打印样式输出-明细信息
			//DATA:List<DisformFullInfo>;
			//	  DisformFullInfo:DisformVO,ComIccInfo
			//    ComIccInfo:comid,starticc,endicc,quantity-商品标识,起始编号,终止编号,数量			
			DataPackage dp = dis.doQueryDisformDetail(params);
			
			//获取配送单样式输出间隔行数
			this.emptySpan = dis.doQueryEmptySpan();
			
			List<DisformFullInfo> disInfo = dp.getDatas();
			
			//获取地市名称
			String city = Code2NameUtils.code2Name("#CITYCOMPANY", this.getDBAccessUser().getCityid(), this.getDBAccessUser().getCityid());
			city = city.substring(0,2);
			//写Excel
			HttpServletResponse response = this.getResponse();
			this.setExcelResponse(response);
			OutputStream os = response.getOutputStream();
			
			StringBuffer sb = new StringBuffer();
			sb.append(EXCEL_START);
			sb.append("<table border=\"1\" bordercolor=\"#A8A8A8\">");
			int eachLineNum = 0;//标记每张单的行号
			int totalLineNum = 0;//标记总的行号
			int disNum = 0;//标记当前处理第几张配送单
			for(Iterator<DisformFullInfo> it=disInfo.iterator();it.hasNext();){
				DisformFullInfo disfullinfo = it.next();
				DisformVO disVO = disfullinfo.getDisVO();
				List<ComIccInfo> comIcc = disfullinfo.getComIcc();
				
				//表格-每张单的首行
				if(disNum == 0){//第一张配送单，不需要分页标记
					sb.append("<tr align=\"center\">");
				}else{//第一张配送单，不需要分页标记
					sb.append("<tr style='page-break-before:always' align=\"center\">");
				}
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' colspan=\"4\" align=\"center\"><p style=\"font-size:18pt;font-weight:bolder\">中国移动广东公司").append(city).append("分公司业务用品配送单</p></td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");				
				//表格-每张单行2
				sb.append("<tr align=\"right\">");
				sb.append("<td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//表格-每张单行3
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>订单编号：</td>");
				sb.append("<td class='text'>").append(disVO.getOrderid()).append("</td>");
				sb.append("<td class='text'>渠道编码：</td>");
				sb.append("<td class='text'>").append(disVO.getRecewayid()).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//表格-每张单行4
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>配送单编号：</td>");
				sb.append("<td class='text'>").append(disVO.getRecid()).append("</td>");
				sb.append("<td class='text'>创建时间：</td>");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String createtime = format.format(disVO.getCreatetime());
				sb.append("<td class='text'>").append(createtime).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//表格-每张单行5
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>收货网点名称：</td>");
				String recewayname = Code2NameUtils.code2Name("#WAYIDINFO", disVO.getRecewayid(), this.getDBAccessUser().getCityid());
				sb.append("<td class='text'>").append(recewayname).append("</td>");
				sb.append("<td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//表格-每张单行6
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>收货人姓名：</td>");
				sb.append("<td class='text'>").append(disVO.getRecename()).append("</td>");
				sb.append("<td class='text'>收货人电话：</td>");
				sb.append("<td class='text'>").append(disVO.getRecetel()).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//表格-每张单行7
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>收货人地址：</td>");
				sb.append("<td class='text' colspan=\"2\">").append(disVO.getReceadd()).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				
				//表格-明细表头
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>序号</td>");
				sb.append("<td class='text'>商品名称</td>");
				sb.append("<td class='text'>商品资源起始编号</td>");
				sb.append("<td class='text'>商品资源终止编号</td>");
				sb.append("<td class='text'>数量</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//表格-明细信息
				for(int i=0;i<comIcc.size();i++){
					ComIccInfo ci = comIcc.get(i);
					sb.append("<tr>");
					sb.append("<td class='text' align=\"right\">").append(i+1).append("</td>");
					String comName = Code2NameUtils.code2Name("#COMSYSTEM", ci.getComid(),this.getDBAccessUser().getCityid());
					sb.append("<td class='text' align=\"left\">").append(comName).append("</td>");
					sb.append("<td class='text' align=\"left\">").append(ci.getStarticc()).append("</td>");
					sb.append("<td class='text' align=\"left\">").append(ci.getEndicc()).append("</td>");
					sb.append("<td class='text' align=\"right\">").append(ci.getQuantity()).append("</td>");
					sb.append("<td class='text'>&nbsp;</td>");
					sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
					sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
					sb.append("</tr>\n");
				}
				
				//表格-每张配送单的表尾首行1
				sb.append("<tr>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"left\">经办签收：</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"left\">网点签收：</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//表格-每张配送单的表尾行2
				sb.append("<tr>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"left\">签收时间：</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"left\">打印序号：</td>");
				sb.append("<td class='text' align=\"right\">").append(++disNum).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//表格-每张配送单的表尾行3
				sb.append("<tr>");
				sb.append("<td class='text'>备注：</td>");
				if(disVO.getMemo()==null){
					sb.append("<td class='longtext' colspan=\"4\">&nbsp;</td>");
				}else{
					sb.append("<td class='longtext' colspan=\"4\">").append(disVO.getMemo()).append("</td>");
				}				
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				
				//表格-各配送单之间的空行
				if(disNum<disInfo.size()){//最后一张配送单后面无需空行
					for(int j=0;j<this.emptySpan;j++){
						sb.append("<tr>");
						sb.append("<td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td>");
						sb.append("<td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td>");
						sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
						sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
						sb.append("</tr>\n");
					}
				}				
				eachLineNum = 0;
			}
			sb.append("</table>");
			sb.append(EXCEL_END);
			
			os.write(this.cvtToGBK(sb.toString()));			
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getCause() == null ? e.getMessage() : e
					.getCause().getMessage());
			return "list";
		}
		return null;
	}
	
	public String doExportExcel(){
		try{
			Disformprint dis = (DisformprintBO)BOFactory.build(DisformprintBO.class, getDBAccessUser());
			DisformprintDBParam params = (DisformprintDBParam)this.getParam();
			params.setDataOnly(true);
			params.set_pagesize("0");
			
			//配送单打印样式输出-明细信息
			//DATA:List<DisformFullInfo>;
			//	  DisformFullInfo:DisformVO,ComIccInfo
			//    ComIccInfo:comid,starticc,endicc,quantity-商品标识,起始编号,终止编号,数量，价格			
			DataPackage dp = dis.doQueryDisformDetail(params);
			
			//获取配送单样式输出间隔行数
			this.emptySpan = dis.doQueryEmptySpan();
			
			List<DisformFullInfo> disInfo = dp.getDatas();
			
			//获取地市名称
			String city = Code2NameUtils.code2Name("#CITYCOMPANY", this.getDBAccessUser().getCityid(), this.getDBAccessUser().getCityid());
			city = city.substring(0,2);
			//写Excel
			HttpServletResponse response = this.getResponse();
			this.setExcelResponse(response);
			
			WritableWorkbook book = Workbook.createWorkbook(getResponse().getOutputStream());
			WritableSheet sheet = book.createSheet("配送单打印-明细", 0);
			jxl.write.WritableFont wfc =new jxl.write.WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE);
            jxl.write.WritableCellFormat wcfFc =new jxl.write.WritableCellFormat(wfc);
            wcfFc.setAlignment(Alignment.CENTRE);
            
            jxl.write.WritableCellFormat wcfFc1 =new jxl.write.WritableCellFormat();
            wcfFc1.setWrap(true);
            wcfFc1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

            
            jxl.write.WritableCellFormat wcfFc2 =new jxl.write.WritableCellFormat();
            wcfFc2.setWrap(true);
            wcfFc2.setAlignment(Alignment.CENTRE);
//          wcfFc2.setAlignment(Alignment.JUSTIFY);
//          wcfFc2.setShrinkToFit(true);
            
            Label label = null;
            
            sheet.setColumnView(0, 6);
            sheet.setColumnView(1, 25);
            sheet.setColumnView(2, 22);
            sheet.setColumnView(3, 22);
            sheet.setColumnView(4, 20);
            sheet.setColumnView(5, 10);
            sheet.setColumnView(6, 6);
            sheet.setColumnView(7, 6);
			
			int eachLineNum = 0;//标记每张单的行号
			int totalLineNum = 0;//标记总的行号
			int disNum = 0;//标记当前处理第几张配送单
			for(Iterator<DisformFullInfo> it=disInfo.iterator();it.hasNext();){
				DisformFullInfo disfullinfo = it.next();
				DisformVO disVO = disfullinfo.getDisVO();
				List<ComIccInfo> comIcc = disfullinfo.getComIcc();
				
				//表格-每张单的首行
				sheet.mergeCells(1, totalLineNum, 4, totalLineNum);
				label = new Label(1,totalLineNum,"中国移动广东公司"+city+"分公司业务用品配送单",wcfFc);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//表格-每张单行2
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//表格-每张单行3
				label = new Label(1,totalLineNum,"订单编号：",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,disVO.getOrderid(),wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"渠道编码：",wcfFc2);
				sheet.addCell(label);
				label = new Label(4,totalLineNum,disVO.getRecewayid(),wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//表格-每张单行4
				label = new Label(1,totalLineNum,"配送单编号：",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,disVO.getRecid().toString(),wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"创建时间：",wcfFc2);
				sheet.addCell(label);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String createtime = format.format(disVO.getCreatetime());
				label = new Label(4,totalLineNum,createtime,wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//表格-每张单行5
				label = new Label(1,totalLineNum,"收货网点名称：",wcfFc2);
				sheet.addCell(label);
				String recewayname = Code2NameUtils.code2Name("#WAYIDINFO", disVO.getRecewayid(), this.getDBAccessUser().getCityid());
				label = new Label(2,totalLineNum,recewayname,wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//表格-每张单行6
				label = new Label(1,totalLineNum,"收货人姓名：",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,disVO.getRecename(),wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"收货人电话：",wcfFc2);
				sheet.addCell(label);
				label = new Label(4,totalLineNum,disVO.getRecetel(),wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//表格-每张单行7
				label = new Label(1,totalLineNum,"收货人地址：",wcfFc2);
				sheet.addCell(label);
				sheet.mergeCells(2, totalLineNum, 3, totalLineNum);
				label = new Label(2,totalLineNum,disVO.getReceadd(),wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);				
				//表格-明细表头
				label = new Label(0,totalLineNum,"序号",wcfFc2);
				sheet.addCell(label);
				label = new Label(1,totalLineNum,"商品名称",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,"商品资源起始编号",wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"商品资源终止编号",wcfFc2);
				sheet.addCell(label);
				label = new Label(4,totalLineNum,"数量",wcfFc2);
				sheet.addCell(label); 
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				double comCardPrice =0;
				double comSmpPrice = 0;
				//表格-明细信息
				for(int i=0;i<comIcc.size();i++){
					ComIccInfo ci = comIcc.get(i);
					label = new Label(0,totalLineNum,(i+1)+"",wcfFc2);
					sheet.addCell(label);
					String comName = Code2NameUtils.code2Name("#COMSYSTEM", ci.getComid(),this.getDBAccessUser().getCityid());
					label = new Label(1,totalLineNum,comName,wcfFc2);
					sheet.addCell(label);
					label = new Label(2,totalLineNum,ci.getStarticc(),wcfFc2);
					sheet.addCell(label);
					label = new Label(3,totalLineNum,ci.getEndicc(),wcfFc2);
					sheet.addCell(label);
					label = new Label(4,totalLineNum,""+ci.getQuantity(),wcfFc2); 
					sheet.addCell(label);  
					label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
					sheet.addCell(label);
					label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
					sheet.addCell(label);
				    comCardPrice += ci.getComCard_price();
				    comSmpPrice += ci.getComSMP_price(); 
				}	
				String price = comCardPrice + comSmpPrice +"";
				//表格-每张配送单的表尾首行1
				label = new Label(1,totalLineNum,"经办签收：",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,"",wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"网点签收：",wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//表格-每张配送单的表尾行2
				label = new Label(1,totalLineNum,"签收时间：",wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"打印序号：",wcfFc2);
				sheet.addCell(label);
				label = new Label(4,totalLineNum,""+(++disNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//表格-金额
				label = new Label(1,totalLineNum,"金额总计：",wcfFc2);
				sheet.addCell(label);
				sheet.mergeCells(2, totalLineNum, 3, totalLineNum);
				label = new Label(2,totalLineNum,price,wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);				
				//表格-每张配送单的表尾行3
//				sheet.setRowView(totalLineNum, true);
				label = new Label(0,totalLineNum,"备注：",wcfFc1);
				sheet.addCell(label);
				sheet.mergeCells(1, totalLineNum, 4, totalLineNum);
				String memo = disVO.getMemo();
				if(memo!=null && memo.length()>85){//长度超过第2到5列的和
					memo = memo.trim().replaceAll("\\s", "");
					sheet.setRowView(totalLineNum, memo.length()/85*560);
				}
				label = new Label(1,totalLineNum,memo,wcfFc1);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);				
				//表格-各配送单之间的空行
				if(disNum<disInfo.size()){//最后一张配送单后面无需空行
					for(int j=0;j<this.emptySpan;j++){
						label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
						sheet.addCell(label);
						label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
						sheet.addCell(label);
					}
				}	
				sheet.addRowPageBreak(totalLineNum);
				eachLineNum = 0;
			}
			
			book.write();
			book.close();
			getResponse().getOutputStream().flush();
			getResponse().getOutputStream().close();
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getCause() == null ? e.getMessage() : e
					.getCause().getMessage());
			return "list";
		}
		return null;
	}
	
	//修改该方法，不做编码转换 （这里认为str为gbk编码的字符串）
    private byte[] cvtToGBK( String str ) {
    	if(str==null){
    		return "".getBytes();
    	}else{
    		return str.getBytes();
    	}
    }
	
	private void setExcelResponse(HttpServletResponse response)	throws Exception {
		String filename = null;
		filename = "配送单打印-明细";
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + filename + ".xls";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("application/x-msdownload");
	}
	
	public int getEmptySpan() {
		return emptySpan;
	}

	public void setEmptySpan(int emptySpan) {
		this.emptySpan = emptySpan;
	}
}