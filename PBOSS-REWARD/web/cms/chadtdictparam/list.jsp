<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    
%>
<html>
<head>
    <title><bean:message bundle="chadtdictparam" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doKeep(){
        	var url='cms/chadtdictparam.do?CMD=SAVE';
        	formList.action=url;
        	formList.submit();
        }
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtdictparam.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
   
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtdictparam/ChAdtDictparamForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			רԱ��������ȷ�ϲ�������
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
    			<td width="10%" height="20" align="right" class="form_table_right" >
                	 <html:checkbox property="checked" value="form.checked" />
                	<!--<input type="checkbox" name="checked">  -->
            	</td>
            	<td width="90%" class="form_table_left">
               	���ö���ȷ�����ѹ���
            	</td>
            </tr>
            <tr>
    			<td width="10%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="90%" class="form_table_left">
               	 ��ע:�����ѡ���ö���ȷ�Ϲ���,רԱ�������"����","�޸�","ɾ��","����"����������漰�޸���רԱ��״̬����רԱ��������Ϣ,����������ȷ������.
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doKeep()" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="ȷ��" />
                        </s:PurChk>
                </td>
			</tr>
		</table>
	</div>

    

  
</html:form>
</div>
</body>
</html>
