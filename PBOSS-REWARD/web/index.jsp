<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.ui.commons.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
String contextPath = request.getContextPath(); 
User user = (User)session.getAttribute("_USER");
%>
<html>
	<head>
		<title>index</title>
		<script>
		contextPath = "<%=contextPath%>/";
		</script>
		<link rel="stylesheet" href="css/dtree.css" type="text/css" />
		<script type="text/javascript" src="js/dtree.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK" />

		<style type="text/css">
<!--
.style1 {
	font-size: large;
	font-weight: bold;g
}
--> 
</style>
	</head> 
	<body style="margin:0px; padding:0px;">
		<table cellpadding=0 cellspacing=0 border=0 width=100% height=100%>
			<tr style="height:76px; width:100%;">
				<td colspan=2 style="border-bottom:#e3e3e3 solid 2px; background:url(images/Index_Middle.gif); padding-left:200px; padding-top:10px; font-size:14px;">
					BOSS2.0��ϵͳ��������ҳ�����ɻ�Ϊ������������ֱ��ҵ��ģ�������������<br/><br/>
					<p style="color:#ffffff">���ţ�<%=user.getOpercode() %> ������<%=user.getWayid() %> �б�ʶ��<%=user.getCityid() %>
					<a href="admin/logincase.do?CMD=LIST">���ٵ�¼</a>
					</p>
				</td>
			</tr>
			<tr>
				<td width=195 style="border-right:#e3e3e3 solid 2px; font-size:12px; background:#FFFFFF; color:#000000;">
					BOSS2.0ʾ������
					<br />
					<a style="color:#000;" href="<%= contextPath %>/example/example1.do">ʾ������</a>&nbsp;
					<a style="color:#000;" href="<%= contextPath %>/example/example1.do?CMD=LISTNOCOUNT">����ʾ��ҳ��</a>&nbsp; 
					<a style="color:#000;" href="http://10.200.26.36:9080/jmbboss/login.jsp?opercode=admin">����ģ�� </a>
					<br />
					<div style="width:195px; height:484px; overflow:auto; background:#fff; border-top:#e3e3e3 solid 2px;">
						<script type="text/javascript">
          target = "mywin"
          //d.add('100', 10, 'ϵͳ����', '','',target); 
          d = new dTree('d');
          d.add('1', -1, 'ϵͳ�˵�', '');                      
          d.add('20', 1, '��������', '');
          		d.add('200', 20, '�������Ϲ���', '','',target);
          			d.add('20027', 200, '����ҵ����Ӫ����', '','',target); 
	          			d.add('2002701', 20027, 'ʡ��������Ϣ����', 'cms/waypro.do?CMD=LIST','',target);
	                 	d.add('2002702', 20027, '�ƹ�רԱ��Ϣ����', 'cms/wayproemployee.do?CMD=LIST','',target);
                 	d.add('20028', 200, 'רԱ��־��ѯ', 'cms/employeelogquery.do?CMD=LIST','',target);
                 	d.add('20029', 200, 'רԱ��������ȷ�ϲ�������', 'cms/chadtdictparam.do?CMD=LIST','',target);
				d.add('209', 20, '������Ч����', '','',target);
             		d.add('20909', 209, '��������׿����۹���','cms/resale.do?CMD=SHOW','',target);
				    d.add('20910', 209, '���������ֵ�����۹���','cms/costcard.do?CMD=SHOW','',target);
					d.add('20911', 209, '���������Դ��˹���','cms/waitaudit.do?CMD=LIST','',target);
					d.add('20912', 209, 'IODƽ̨���Ż�����ϸ��ѯ','cms/iodaudit.do?CMD=SHOW','',target);
                    d.add('20913', 209, '�ɼ�ƽ̨���Ż��˲�ѯ','cms/mpsaudit.do?CMD=LIST','',target);
                    d.add('20914', 209, '������Ϣ��ѯ','cms/reward/registersimvw/frame.jsp','',target);
                    
                    d.add('20916', 209, '��̨�ļ�����','cms/reward/backgroundfileexport/frame.jsp','',target);
               	d.add('215', 20, '�������ҵ�����', '','',target);
               		d.add('21501', 215, '�������ȫҵ�������Ϣ����','','',target);
               			d.add('2150101', 21501, 'ȫʡͳһҵ�����','cms/operation.do?CMD=LIST','',target);
               			d.add('2150102', 21501, 'ȫʡͳһҵ�����������','cms/operation/tree/frame.jsp','',target);
               			d.add('2150103', 21501, 'ȫʡҵ�����õ����ϼ�','cms/busicityload.do?CMD=SHOW','',target);
               		d.add('21502',215,'������Ч�Թ���','','',target);
               			d.add('2150201', 21502, '��Ч�Թ������','cms/reward/rule.do?CMD=LIST','',target);
               			d.add('2150202', 21502, 'ҵ�������Ч�Թ����ѯ','cms/reward/rule2.do?CMD=LIST','',target);
               			//d.add('2150203', 21502,'������Чҵ�����ݵ���','cms/citydata/batchintask.do?CMD=Querydict','',target); 
               			d.add('2150204', 21502, 'Ӫ��������ȫʡͳһҵ���������','cms/reward/busyxplan.do?CMD=SHOW','',target);
               			d.add('2150205', 21502, 'У��ʧ�����ݲ�ѯ','cms/reward/faildataquery.do?CMD=SHOW','',target);
               			d.add('2150206', 21502, 'ҵ��������������','cms/reward/cbopnacctmap.do?CMD=SHOW','',target);
               			d.add('2150207', 21502, 'ҵ����Ƴ���������','cms/reward/busiwayrel.do?CMD=LIST','',target);
               			d.add('2150208', 21502, 'ҵ������Ʒ��Դ��������','cms/reward/busitocom.do?CMD=LIST','',target);
               			d.add('2150209', 21502, 'ҵ�����׿���Դ��������','cms/reward/busitosmp.do?CMD=LIST','',target);
               			d.add('2150210', 21502, 'ҵ�������������ϵ��ѯ','cms/chadtbusitoapprove.do?CMD=LIST','',target);
               		d.add('21503', 215, '����������','','',target);
               			d.add('2150301', 21503, '���ع������','cms/rewardpoolr.do?CMD=SHOW','',target);
               			d.add('2150302', 21503, '�Ǽ�����׼��������','cms/stdrewardbs.do?CMD=LIST','',target);
               			d.add('2150303', 21503, '�Ǽ�����Ч����','cms/reward/salecredit/frame.jsp','',target);
               			//d.add('2150303', 21503, '��Ŀ�������׼��������','cms/stdrewardbp.do?CMD=SHOW','',target);
               			d.add('2150304', 21503, '�������޽���׼����','cms/stdrewardhz.do?CMD=LIST','',target);
               			d.add('2150305', 21503, 'ͳһ����ģʽ����׼����','cms/reward/stdrewardut/frame.jsp','',target);
               			d.add('2150306', 21503, '�ź�������ֵ��������������','cms/salereward.do?CMD=LIST','',target);
               			d.add('2150307', 21503, '�����Ǽ�����׼����','cms/waystrarewardstd.do?CMD=LIST','',target);
               			d.add('2150308', 21503, '�й�˾���Ի��������ƹ���','cms/chadtdictidname.do?CMD=VIEW','',target);
               			d.add('2150309', 21503, '��Ȧ�ŵ겹����������','','',target);
               				d.add('215030901', 2150309, '��Ȧ�ŵ겹������ϵ������','cms/chadtwaymod/list.jsp','',target);
               			
               		d.add('21504', 215, '������','','',target);
               			d.add('2150401', 21504, '����������ѯ','','',target);
               				d.add('215040101', 2150401, 'Ӧ�������ϸ��ѯ','cms/rewardrecord.do?CMD=SHOW','',target);
               				d.add('215040102', 2150401, '�������ܱ��ѯ','cms/reward/rewardtotal.do?CMD=SHOW','',target);
               				d.add('215040105', 2150401, '����������','cms/rewardadjust.do','',target);
               			d.add('2150402', 21504, '��𿼺�ϵ������', 'cms/rewardasse.do?CMD=LIST','',target);
               			d.add('2150403', 21504, '���ж���������ݵ���', 'cms/cityrewardad.do?CMD=LIST','',target);
             			d.add('2150404', 21504, '�������޽�����', 'cms/wayhznx.do?CMD=LIST','',target);
             			d.add('2150405', 21504, '������ȷ��', 'cms/reward/rewardconf.do?CMD=Aglist','',target);
             			d.add('2150406', 21504, '��������³�������Ϣ���� ', 'cms/reward/waysnpt.do?CMD=SHOW','',target);
             			d.add('2150407', 21504, '�������������̼�� ', 'cms/reward/taskstate.do?CMD=SET','',target);
             			d.add('2150408', 21504, '�Ǽ�����������','cms/waystarmonth.do?CMD=STARLIST','',target);
             			d.add('2150409', 21504, '�����֧������','cms/rewardsms/frame.jsp','',target);
             			d.add('2150410', 21504, '˰�ʹ����������','cms/reward/tax.do?CMD=LIST','',target);
             			d.add('2150411', 21504, '�й�˾����Υ�����㵼��','cms/wayhzwg.do?CMD=LIST','',target);
               	 d.add('216', 20, '��վ����ҵ�����', '','',target);
               		d.add('21601', 216, 'ҵ�������Ϣ����','','',target);	
               			d.add('2160101', 21601, 'ȫʡͳһҵ�����','cms/bbc/operation.do?CMD=LIST','',target);
               			d.add('2160102', 21601, 'MMҵ�����','cms/bbc/mmopn.do?CMD=LIST','',target);		
               			d.add('2160103', 21601, '�������ֹ���','cms/bbc/music/list.jsp','',target);		
           			d.add('21602', 216, '�����ܷ����Ӧ��ϵ����','cms/bbc/opnacctmap.do?CMD=LIST','',target);	
           			d.add('21603', 216, 'B2Mҵ���������ҵ�����Ӧ��ϵ����','cms/bbc/jfopnmap.do?CMD=LIST','',target);
           			d.add('21604', 216, 'B2M��վ����������ϸ��ѯ','cms/bbc/bbcrewardrecord.do?CMD=SHOW','',target);
               		d.add('21605', 216, 'B2M��վ���������ܱ��ѯ','cms/bbc/bbcrewardtotal.do?CMD=SHOW','',target);
               		d.add('21606', 216, 'B2M��վ������ȷ��','cms/reward/rewardconf.do?CMD=B2mlist','',target);
               		d.add('21607', 216, '��Ч��У��ʧ�����ݲ�ѯ','cms/bbc/bbcfaildataquery.do?CMD=SHOW','',target);
               		d.add('21608', 216, 'Ӫ��������ҵ���������','cms/bbc/yxplan.do?CMD=LIST','',target);
               		d.add('21609', 216, 'B2M���˳���������ѯ','cms/nasrwdtotal.do?CMD=SHOW','',target);
               		d.add('21610', 216, 'B2M��վ����������','cms/bbc/bbcadjust.do?CMD=LIST','',target);
               		d.add('21611', 216, '������','','',target);
               			d.add('2161101', 21611, '����������ѯ','','',target);
	               			d.add('216110101', 2161101, 'ȫԱ�������������ϸ��ѯ','cms/bbc/unvrewardrecord.do?CMD=SHOW','',target);
	               			d.add('216110102', 2161101, 'ȫԱ������������ܱ��ѯ','cms/bbc/unvrewardtotal.do?CMD=SHOW','',target);
	               			d.add('216110103', 2161101, 'ȫԱ����Ƴ���Ƽ�ʧ�ܼ�¼��ѯ','cms/bbc/unvfaildataquery.do?CMD=LIST','',target);
	               			d.add('216110104', 2161101, '������վ�����ϸ��ѯ','cms/bbc/bbcyzrewarddet.do?CMD=SHOW','',target);
               		d.add('21612', 216, '�϶���ҵ������ѯ','cms/bbc/hdnetsales.do?CMD=LIST','',target);
               		d.add('21613', 216, '�����̲㼶��Ϣ��ѯ','cms/bbc/bbcwaylevel.do?CMD=LIST','',target);
               		d.add('21614', 216, 'ȫԱ�������������','cms/bbc/bbcadjust.do?CMD=UNPBLIST','',target);
               		d.add('21615', 216, '����ҵ��˼���������','cms/bbc/subtract/frame.jsp','',target);
	             d.add('217', 20, '�������˹���', '','',target); 
	                 d.add('21705', 217, 'ָ�����','cms/examine/examinestd.do?CMD=LIST','',target);
	               	 d.add('21706', 217, '���˹���','cms/examine/examine.do?CMD=LIST','',target);	
	               	 d.add('21707', 217, '����ӳ��','cms/examine/mapping.do?CMD=LIST','',target);
	               	 d.add('21708', 217, '��������','cms/examine/itemgraded.do?CMD=Showexmnpage','',target);
	               	 d.add('21709', 217, '���˽��','cms/examine/exmnrslt.do?CMD=LIST','',target);
	               	 d.add('21710', 217, '����ϵ��','cms/examine/coefficient.do?CMD=LIST','',target);
	               	 d.add('21711', 217, 'ϵ������','cms/examine/coefrevision.do?CMD=LIST','',target);
	           		 d.add('21712', 217, '����������Ȩ', 'cms/examine/oprnwayid.do?CMD=LIST','', target);
	               	 d.add('21713', 217, '������־��ѯ', 'cms/examine/logquery/logQueryFrame.jsp','', target);	
		document.write(d);

        </script> 
					</div>
				</td>
				<td width=900>
					<iframe framespacing="0" frameborder="NO" Scrolling="auto" width=806 height=510 name="mywin" id="IFRM_LEFT_BOTTOM" src="new.html"></iframe>
				</td>
			</tr>
		</table>
	</body>
</html>