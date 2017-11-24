<%@ page language="java" contentType="text/html;charset=GBK"%>

<%@ include file="/inc/listhead.inc" %>

<html>
  <head>
    
    <title><bean:message bundle="subscriber" key="selectList"/></title>
    <base target="_self">
 <script language=javascript>
			
			
	function frmSubmit(){
	
		var strChecks = "";
		var isnull = true;
		if (document.all.rdo.length != null) {
			for(var i=0;i<document.all.rdo.length;i++){
			
				if(document.all.rdo[i].checked){
					strChecks = document.all.rdo[i].id;
					isnull = false;
					break;
				}
			}
		}else{
			if(document.all.rdo.checked){
				strChecks = document.all.rdo.id;
				isnull = false;
			}
		}
		
		if(isnull){
			alert('<bean:message bundle="subscriber" key="selectmsg"/>');
		}
		else{
			window.returnValue=strChecks;
			window.close();
		}
	}
	function autoSubmit() {
		if (document.all.rdo != null) {
			if (document.all.rdo.length == null) {
				document.all.rdo.checked = true;
				frmSubmit ();
			}
		}
	}
 </script>
</head>
 
<body>

<html:form action="/commons/subscriber.do?CMD=LIST1" styleId="formList" method="post">
  <c:set var="edtState" scope="request" value="${!empty requestScope.isNull and requestScope.isNull eq 'TRUE'}"/>
 
  	<html:hidden property="_se_servnumber"/>
  	<html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="accounting"/>
    <html:hidden property="cityid"/>
    
    
    <input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">
    
	<div class="table_div">
		<table class="top_table">
			<tr> 
				<td><bean:message bundle="subscriber" key="selectList"/></td>
			</tr>
		</table>
    </div>
    <div class="table_div">
		<table class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>
   	
       
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
				<c:choose>
			    	<c:when test="${edtState}">						
                        	<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                           		onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_submit"/>" onClick="frmSubmit();">                    	
					</c:when> 
				</c:choose> 
				
			        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
			               onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			               value="<bean:message bundle="public" key="button_close"/>" onClick="window.close();">
			    </td>	
			</tr>
		</table>
	</div>

          
     
     <c:choose>
       <c:when test="${edtState}">
       <div class="table_div">	
    	<div class="table_LongTable">
         <table class="table_style" ID="Table2">
            <tr class="table_style_head">                
                <td title="<bean:message bundle="public" key="list_title_select"/>">                    
                </td>
                <td><a href="javascript:doOrderby('subsid')"><bean:message bundle="subscriber" key="subsid"/></a>
                    <s:OrderImg form="/commons/subscriberForm" field="subsid"/>
				</td>
				<td><a href="javascript:doOrderby('acctid')"><bean:message bundle="subscriber" key="acctid"/></a>
                    <s:OrderImg form="/commons/subscriberForm" field="acctid"/>
				</td>                				
				<td><a href="javascript:doOrderby('custid')"><bean:message bundle="subscriber" key="custid"/></a>
                    <s:OrderImg form="/commons/subscriberForm" field="custid"/>
				</td>
				<td><a href="javascript:doOrderby('subsname')"><bean:message bundle="subscriber" key="subsname"/></a>
                    <s:OrderImg form="/commons/subscriberForm" field="subsname"/>
				</td>
                <td><a href="javascript:doOrderby('servnumber')"><bean:message bundle="subscriber" key="servnumber"/></a>
                    <s:OrderImg form="/commons/subscriberForm" field="servnumber"/>
				</td>				 
                <td><a href="javascript:doOrderby('status')"><bean:message bundle="subscriber" key="status"/></a>
                    <s:OrderImg form="/commons/subscriberForm" field="status"/>
				</td>              
            </tr> 
			<c:forEach var="item" items="${requestScope.LIST.datas}">
			<tr class="table_style_content" align="center"  onclick="document.all('<c:out value="${item.subsid}|${item.custid}|${item.userid}|${item.servnumber}|${item.acctid}|${item.status}|${item.proid}|${item.brand}|"/>').checked = true">
                 <td>
                 	<input type=radio id="<c:out value="${item.subsid}|${item.custid}|${item.userid}|${item.servnumber}|${item.acctid}|${item.status}|${item.proid}|${item.brand}|"/>" 
                 		   class="table_checkbox" NAME="rdo">
                 </td>
                 <td><c:out value="${item.subsid}"/></td> 
                 <td><c:out value="${item.acctid}"/></td>                 
                 <td><c:out value="${item.custid}"/></td>
                 <td><c:out value="${item.subsname}"/></td> 
                 <td><c:out value="${item.servnumber}"/></td>                 
                 <td><s:Code2Name code="${item.status}" definition="$US"/></td>                 
              </tr>                         
             </c:forEach>
           </table>
          </div>
          </div>  
          <div class="table_div">
				<s:PageNav dpName="LIST"/>
		  </div> 
		  
         </c:when>
         <c:otherwise>
         <div class="table_div">	
	           	<table class="form_table">	
		              <tr> 		
						<td>
		                 	<bean:message bundle="subscriber" key="errmsg"/>
		                </td>
		              </tr>
				</table>
			</div>				 
          </c:otherwise>
     	</c:choose> 

     	          
  </html:form>       

</body>
</html>
