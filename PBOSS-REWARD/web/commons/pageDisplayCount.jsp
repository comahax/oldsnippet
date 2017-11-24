<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<table class="page_table">
	<tr valign=middle>
		<td align=left height=30>
				<a href="javascript:firstPageHis();" id="_firstPageHis"><img src="images/first.gif" alt="<bean:message bundle="public" key="button_first_page"/>" width="59" height="18" border="0"></a>			 
				<a href="javascript:previousPageHis();" id="_showPreviousPageHis"><img src="images/preview.gif" alt="<bean:message bundle="public" key="button_forward"/>" width="59" height="18" border="0"></a>
			<c:choose>
				<c:when test="${ !empty _isHIS and _isHIS eq 'TRUE' and totalPage eq currentPage}">
				</c:when>
				<c:otherwise>
				<a href="javascript:nextPageHis();"><img src="images/next.gif" alt="<bean:message bundle="public" key="button_next"/>" width="59" height="18" border="0"></a>
			&nbsp;&nbsp;
				</c:otherwise>
			</c:choose>
		</td>
		<c:if test="${!empty requestScope._isLVM and requestScope._isLVM eq 'TRUE'}">
			<td><font color="red">ע��LVM�ӹ��У�����ѯ��ʷ����</font></td>
		</c:if>
		<td align=right style="font-size:12px;">		
	               <c:choose>
				<c:when test="${ !empty _isHIS and _isHIS eq 'TRUE'}" >						
	            	��ʷ������  
	                <bean:message bundle="public" key="button_total_page" />
					<font color="red"><c:out value="${totalPage}" /></font>
					<bean:message bundle="public" key="button_page" />
					&nbsp; 	                  	
				</c:when> 
				<c:when test="${ !empty _isHIS and _isHIS eq 'FALSE'}" >						
					����������
	                <bean:message bundle="public" key="button_total_page" />
					<font color="red"><c:out value="${totalPage}" /></font>
					<bean:message bundle="public" key="button_page" />
					&nbsp;   	                  	
				</c:when>
			</c:choose>	                  	
			
			
			<bean:message bundle="public" key="button_current_page" />
			<font color="red" id="_currentPage"></font> 
			<bean:message bundle="public" key="button_page" />
			&nbsp;
			</td>
	</tr>
    <script language="JavaScript" type="text/JavaScript">
    if (isNaN(parseInt(document.formList._pageno.value))){
    	pageno = 0;
    }else{
    	pageno = parseInt(document.formList._pageno.value);
    }
    if (isNaN(parseInt(document.formList._pageno.value))){	
    	hispageno = -1;
    }else{
    	hispageno = parseInt(document.formList._hispageno.value);
    }
     
	ishis = '<c:out value="${_isHIS}"/>';
	if(null != ishis &&��ishis��== 'TRUE'){
		currentPage = hispageno;
		if(hispageno==-1){
    		currentPage += 1;
    	}
    	if(currentPage<1){
    		currentPage = 1;
    	}
	}else if (null != ishis &&��ishis��== 'FALSE'){
		currentPage = pageno;
		
	}else{
		currentPage = pageno + hispageno;
		if(hispageno==-1){
    	currentPage += 1;
    	}
    	if(currentPage<1){
    		currentPage = 1;
    	}
	}
    
    if(currentPage<2){
		if(hispageno == -1){
			document.getElementById("_firstPageHis").style.display= "none"; 
			document.getElementById("_showPreviousPageHis").style.display= "none";
		}
	}
	document.getElementById("_currentPage").innerHTML = currentPage;
	</script>
</table>