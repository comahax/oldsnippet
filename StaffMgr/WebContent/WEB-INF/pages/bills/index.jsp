<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<title>�㶫�ƶ�Ա��ͨѶ�����˵���ѯϵͳ</title>
	
</head>
<body class="easyui-layout">
	<div  class="easyui-tabs" data-options="fit:true,border:false" >
	
	<div id="toptabs" title="Ա���˵���ѯ" data-options="" style="padding: 20px;" >
	<form id="billform" >
    <table class="table_normal">
      <tr>
		<td align="right">Ա������:</td>
		<td align="left">
			<input id="svrnums" class="easyui-validatebox" missingMessage="����дԱ������" invalidMessage="Ա�������ʽ����ȷ"  data-options="required:true,novalidate:true" type="text" name="svrnums" onf="validate(this)"></input>
		</td>
      	<td align="right">����:</td>
      	<td align="left">
      		<div>
				<input id="billcycs" class="date_input easyui-validatebox"  missingMessage="��ѡ������"  data-options="required:true,novalidate:true"  type="text" name="billcycs" ></input>
			</div>
		</td>
		<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-add'" onclick="showquerys()">��ѯ</a></td>
      </tr>
      </table>
      </form>
			<table id="billsId" class="easyui-datagrid" title="Ա���˵���ѯ" 
				data-options="singleSelect:true,pagination:true,method:'post',showfooter:true,fitColumns:true,rownumbers:true">
			</table>
			<div >
			</br>
			��ע</br>
			1�����º������ѣ����¿ɺ���ҵ�񾭹����ۺ�ķ��ã����������������º������Ѷ��(����ͨԱ��350Ԫ)���򳬳����ּ��뱾�³���ѡ�</br>
	        2�����·Ǻ����໰�ѣ���������ҵ���б�֮���ҵ����á�</br>
	        3������Ӧ�ɻ��ѣ������³���ѺͷǺ����໰�ѵ��ܺͣ�ʵ�ʰ��½��㷽ʽ������ͨ����ֵ���ɷѵȷ�ʽ���塣</br>
	        </div>
			<div id="detailedIdss" class="easyui-window" data-options="closed:true,fit:true" title="�����˵�ҵ����ϸ" style="width:300px;height:auto;" >
			 <table id="detailedId"  class="easyui-dialog" data-options="iconCls:'icon-add',
			 border:false,fitColumns:true,pagination:true,showfooter:true,rownumbers:true,
			 singleSelect:false,showfooter:true,url:'<%=request.getContextPath() %>/bills/querysBusiness.do',method:'get'">
			 </table>
			</div>
	  </div>
      </div>

     <script type="text/javascript">
      	initBillForm();
      	
	</script>
  </body>
</html>
