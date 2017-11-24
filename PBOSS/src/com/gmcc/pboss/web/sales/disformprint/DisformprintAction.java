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
	//��ȡ���͵���ʽ����������
	private int emptySpan;
	//����Excel�ļ���ͷ��
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
											"	.longtext {\n" +          //����ĸ�ʽ����ı�������ʾ
											"		border:#a8a8a8 soild 1px;\n" +
											"		color:#000;\n" +
											"		font-size:12px;\n" +
											"		text-align:center;\n" +
											"		background:#FFFFFF;\n" +
											"	}\n" +
											"	</style>\n" +
											"</head>\n" +
											"<body>\n";
	//����Excel�ļ��Ľ�β
	private static final String EXCEL_END="\n</body>\n</html>";

	public DisformprintAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new DisformprintForm());
		this.setParam(new DisformprintDBParam());

        //ָ��VO��
        setClsVO(DisformprintVO.class);
        //ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
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
			
			//���͵���ӡ��ʽ���-��ϸ��Ϣ
			//DATA:List<DisformFullInfo>;
			//	  DisformFullInfo:DisformVO,ComIccInfo
			//    ComIccInfo:comid,starticc,endicc,quantity-��Ʒ��ʶ,��ʼ���,��ֹ���,����			
			DataPackage dp = dis.doQueryDisformDetail(params);
			
			//��ȡ���͵���ʽ����������
			this.emptySpan = dis.doQueryEmptySpan();
			
			List<DisformFullInfo> disInfo = dp.getDatas();
			
			//��ȡ��������
			String city = Code2NameUtils.code2Name("#CITYCOMPANY", this.getDBAccessUser().getCityid(), this.getDBAccessUser().getCityid());
			city = city.substring(0,2);
			//дExcel
			HttpServletResponse response = this.getResponse();
			this.setExcelResponse(response);
			OutputStream os = response.getOutputStream();
			
			StringBuffer sb = new StringBuffer();
			sb.append(EXCEL_START);
			sb.append("<table border=\"1\" bordercolor=\"#A8A8A8\">");
			int eachLineNum = 0;//���ÿ�ŵ����к�
			int totalLineNum = 0;//����ܵ��к�
			int disNum = 0;//��ǵ�ǰ����ڼ������͵�
			for(Iterator<DisformFullInfo> it=disInfo.iterator();it.hasNext();){
				DisformFullInfo disfullinfo = it.next();
				DisformVO disVO = disfullinfo.getDisVO();
				List<ComIccInfo> comIcc = disfullinfo.getComIcc();
				
				//���-ÿ�ŵ�������
				if(disNum == 0){//��һ�����͵�������Ҫ��ҳ���
					sb.append("<tr align=\"center\">");
				}else{//��һ�����͵�������Ҫ��ҳ���
					sb.append("<tr style='page-break-before:always' align=\"center\">");
				}
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' colspan=\"4\" align=\"center\"><p style=\"font-size:18pt;font-weight:bolder\">�й��ƶ��㶫��˾").append(city).append("�ֹ�˾ҵ����Ʒ���͵�</p></td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");				
				//���-ÿ�ŵ���2
				sb.append("<tr align=\"right\">");
				sb.append("<td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//���-ÿ�ŵ���3
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>������ţ�</td>");
				sb.append("<td class='text'>").append(disVO.getOrderid()).append("</td>");
				sb.append("<td class='text'>�������룺</td>");
				sb.append("<td class='text'>").append(disVO.getRecewayid()).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//���-ÿ�ŵ���4
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>���͵���ţ�</td>");
				sb.append("<td class='text'>").append(disVO.getRecid()).append("</td>");
				sb.append("<td class='text'>����ʱ�䣺</td>");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String createtime = format.format(disVO.getCreatetime());
				sb.append("<td class='text'>").append(createtime).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//���-ÿ�ŵ���5
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>�ջ��������ƣ�</td>");
				String recewayname = Code2NameUtils.code2Name("#WAYIDINFO", disVO.getRecewayid(), this.getDBAccessUser().getCityid());
				sb.append("<td class='text'>").append(recewayname).append("</td>");
				sb.append("<td class='text'>&nbsp;</td><td class='text'>&nbsp;</td><td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//���-ÿ�ŵ���6
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>�ջ���������</td>");
				sb.append("<td class='text'>").append(disVO.getRecename()).append("</td>");
				sb.append("<td class='text'>�ջ��˵绰��</td>");
				sb.append("<td class='text'>").append(disVO.getRecetel()).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//���-ÿ�ŵ���7
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>�ջ��˵�ַ��</td>");
				sb.append("<td class='text' colspan=\"2\">").append(disVO.getReceadd()).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				
				//���-��ϸ��ͷ
				sb.append("<tr align=\"left\">");
				sb.append("<td class='text'>���</td>");
				sb.append("<td class='text'>��Ʒ����</td>");
				sb.append("<td class='text'>��Ʒ��Դ��ʼ���</td>");
				sb.append("<td class='text'>��Ʒ��Դ��ֹ���</td>");
				sb.append("<td class='text'>����</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//���-��ϸ��Ϣ
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
				
				//���-ÿ�����͵��ı�β����1
				sb.append("<tr>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"left\">����ǩ�գ�</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"left\">����ǩ�գ�</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//���-ÿ�����͵��ı�β��2
				sb.append("<tr>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"left\">ǩ��ʱ�䣺</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"left\">��ӡ��ţ�</td>");
				sb.append("<td class='text' align=\"right\">").append(++disNum).append("</td>");
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				//���-ÿ�����͵��ı�β��3
				sb.append("<tr>");
				sb.append("<td class='text'>��ע��</td>");
				if(disVO.getMemo()==null){
					sb.append("<td class='longtext' colspan=\"4\">&nbsp;</td>");
				}else{
					sb.append("<td class='longtext' colspan=\"4\">").append(disVO.getMemo()).append("</td>");
				}				
				sb.append("<td class='text'>&nbsp;</td>");
				sb.append("<td class='text' align=\"right\">").append(++eachLineNum).append("</td>");
				sb.append("<td class='text' align=\"right\">").append(++totalLineNum).append("</td>");
				sb.append("</tr>\n");
				
				//���-�����͵�֮��Ŀ���
				if(disNum<disInfo.size()){//���һ�����͵������������
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
			
			//���͵���ӡ��ʽ���-��ϸ��Ϣ
			//DATA:List<DisformFullInfo>;
			//	  DisformFullInfo:DisformVO,ComIccInfo
			//    ComIccInfo:comid,starticc,endicc,quantity-��Ʒ��ʶ,��ʼ���,��ֹ���,�������۸�			
			DataPackage dp = dis.doQueryDisformDetail(params);
			
			//��ȡ���͵���ʽ����������
			this.emptySpan = dis.doQueryEmptySpan();
			
			List<DisformFullInfo> disInfo = dp.getDatas();
			
			//��ȡ��������
			String city = Code2NameUtils.code2Name("#CITYCOMPANY", this.getDBAccessUser().getCityid(), this.getDBAccessUser().getCityid());
			city = city.substring(0,2);
			//дExcel
			HttpServletResponse response = this.getResponse();
			this.setExcelResponse(response);
			
			WritableWorkbook book = Workbook.createWorkbook(getResponse().getOutputStream());
			WritableSheet sheet = book.createSheet("���͵���ӡ-��ϸ", 0);
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
			
			int eachLineNum = 0;//���ÿ�ŵ����к�
			int totalLineNum = 0;//����ܵ��к�
			int disNum = 0;//��ǵ�ǰ����ڼ������͵�
			for(Iterator<DisformFullInfo> it=disInfo.iterator();it.hasNext();){
				DisformFullInfo disfullinfo = it.next();
				DisformVO disVO = disfullinfo.getDisVO();
				List<ComIccInfo> comIcc = disfullinfo.getComIcc();
				
				//���-ÿ�ŵ�������
				sheet.mergeCells(1, totalLineNum, 4, totalLineNum);
				label = new Label(1,totalLineNum,"�й��ƶ��㶫��˾"+city+"�ֹ�˾ҵ����Ʒ���͵�",wcfFc);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//���-ÿ�ŵ���2
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//���-ÿ�ŵ���3
				label = new Label(1,totalLineNum,"������ţ�",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,disVO.getOrderid(),wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"�������룺",wcfFc2);
				sheet.addCell(label);
				label = new Label(4,totalLineNum,disVO.getRecewayid(),wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//���-ÿ�ŵ���4
				label = new Label(1,totalLineNum,"���͵���ţ�",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,disVO.getRecid().toString(),wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"����ʱ�䣺",wcfFc2);
				sheet.addCell(label);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String createtime = format.format(disVO.getCreatetime());
				label = new Label(4,totalLineNum,createtime,wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//���-ÿ�ŵ���5
				label = new Label(1,totalLineNum,"�ջ��������ƣ�",wcfFc2);
				sheet.addCell(label);
				String recewayname = Code2NameUtils.code2Name("#WAYIDINFO", disVO.getRecewayid(), this.getDBAccessUser().getCityid());
				label = new Label(2,totalLineNum,recewayname,wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//���-ÿ�ŵ���6
				label = new Label(1,totalLineNum,"�ջ���������",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,disVO.getRecename(),wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"�ջ��˵绰��",wcfFc2);
				sheet.addCell(label);
				label = new Label(4,totalLineNum,disVO.getRecetel(),wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//���-ÿ�ŵ���7
				label = new Label(1,totalLineNum,"�ջ��˵�ַ��",wcfFc2);
				sheet.addCell(label);
				sheet.mergeCells(2, totalLineNum, 3, totalLineNum);
				label = new Label(2,totalLineNum,disVO.getReceadd(),wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);				
				//���-��ϸ��ͷ
				label = new Label(0,totalLineNum,"���",wcfFc2);
				sheet.addCell(label);
				label = new Label(1,totalLineNum,"��Ʒ����",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,"��Ʒ��Դ��ʼ���",wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"��Ʒ��Դ��ֹ���",wcfFc2);
				sheet.addCell(label);
				label = new Label(4,totalLineNum,"����",wcfFc2);
				sheet.addCell(label); 
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				double comCardPrice =0;
				double comSmpPrice = 0;
				//���-��ϸ��Ϣ
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
				//���-ÿ�����͵��ı�β����1
				label = new Label(1,totalLineNum,"����ǩ�գ�",wcfFc2);
				sheet.addCell(label);
				label = new Label(2,totalLineNum,"",wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"����ǩ�գ�",wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//���-ÿ�����͵��ı�β��2
				label = new Label(1,totalLineNum,"ǩ��ʱ�䣺",wcfFc2);
				sheet.addCell(label);
				label = new Label(3,totalLineNum,"��ӡ��ţ�",wcfFc2);
				sheet.addCell(label);
				label = new Label(4,totalLineNum,""+(++disNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);
				//���-���
				label = new Label(1,totalLineNum,"����ܼƣ�",wcfFc2);
				sheet.addCell(label);
				sheet.mergeCells(2, totalLineNum, 3, totalLineNum);
				label = new Label(2,totalLineNum,price,wcfFc2);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);				
				//���-ÿ�����͵��ı�β��3
//				sheet.setRowView(totalLineNum, true);
				label = new Label(0,totalLineNum,"��ע��",wcfFc1);
				sheet.addCell(label);
				sheet.mergeCells(1, totalLineNum, 4, totalLineNum);
				String memo = disVO.getMemo();
				if(memo!=null && memo.length()>85){//���ȳ�����2��5�еĺ�
					memo = memo.trim().replaceAll("\\s", "");
					sheet.setRowView(totalLineNum, memo.length()/85*560);
				}
				label = new Label(1,totalLineNum,memo,wcfFc1);
				sheet.addCell(label);
				label = new Label(6,totalLineNum,""+(++eachLineNum),wcfFc2);
				sheet.addCell(label);
				label = new Label(7,totalLineNum,""+(++totalLineNum),wcfFc2);
				sheet.addCell(label);				
				//���-�����͵�֮��Ŀ���
				if(disNum<disInfo.size()){//���һ�����͵������������
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
	
	//�޸ĸ÷�������������ת�� ��������ΪstrΪgbk������ַ�����
    private byte[] cvtToGBK( String str ) {
    	if(str==null){
    		return "".getBytes();
    	}else{
    		return str.getBytes();
    	}
    }
	
	private void setExcelResponse(HttpServletResponse response)	throws Exception {
		String filename = null;
		filename = "���͵���ӡ-��ϸ";
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