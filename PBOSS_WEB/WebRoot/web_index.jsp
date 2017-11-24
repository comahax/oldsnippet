<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<link href="/css/index.css" rel="stylesheet" type="text/css">
<jsp:useBean id="pageInfo2" class="com.gmcc.pboss.common.action.PageInfo"/>
<c:set var="pageInfo" value ="${pageInfo2}"/>
</head>
<body>
<!-- ͷ�������� -->
	<%@ include file="/common/include/inc_head.jsp"%>	
<!-- �������� -->
<div class="divspan">
    <div class="divspan1">
  <div class="module3">
  <table border="0" cellspacing="0" cellpadding="0" align="center">
      <tr>
        <td width="275" height="290" valign="top"  class="frameline"><div class="framesubnavbj">
          <div class="frametitle">��������</div>
          <div class="framemore"><a href="/communi/pendingRequestList.do" class="a3">����</a></div>
        </div>
          <div class="framecontent">
            <div class="framelist">
            	
            	<!-- ������������ Begin-->
	            <s:if test="%{bean.pendingRequest.size > 0}">
		            <c:forEach var="info" items="${requestScope.bean.pendingRequest}">
		            	<li><a href="<c:out value="${info.content}"/>" class="a4">
		            		<c:set var="title" value="${fun:fOmit(info.title,15)}"/>
		            		<c:set var="date" value="${fun:getDateTime('yyyy-MM-dd',info.plantime)}"/>
		            		<c:set var="isBeforeRightNow" value="${fun:isBeforeRightNow(info.plantime)}"/>
		            		<span
		            		<c:if test="${isBeforeRightNow}">
		            		class="red_01"
		            		</c:if>
		            		><c:out value="${title}"></c:out>
		            		</span>(<c:out value="${date}"></c:out>)
		            	</a>		            	
		            	</li>
		            </c:forEach>		            
	            </s:if>
	            <s:else>
	            	���޴�������
	            </s:else>
            </div>
          </div></td>
       
      </tr>
    </table>
  </div>
  <div class="module1">
    <div class="framesubnavbj">
      <div class="frametitle">������Ϣ</div>
      <div class="framemore"><a href='/communi/afficheList.do' class="a3">����</a></div>
    </div>
    <div class="framecontent">
		<div class="frameflash">
			<object type="application/x-shockwave-flash" data="${ctx }/flash/bcastr4.swf?xml=${ctx }/flashParameter.do"  
			width="248" height="220" id="vcastr3">
				<param name="movie" value="${ctx }/flash/bcastr4.swf?xml=${ctx }/flashParameter.do" />
			</object>
		</div>

      <div class="framelist1">
      	
      	<!-- ����������Ϣ Begin-->
      	<s:if test="%{bean.affiche.size > 0}">
	       	<c:forEach var="info" items="${bean.affiche}">
	       		<li><a href="javaScript:f_openDetl('/communi/showAffiche.do?parameter.advinfoid=<c:out value="${info.advinfoid}"/>&parameter.type=<c:out value="${info.type}"/>','������Ϣ')"   class="a4">
            		<c:set var="title" value="${fun:fOmit(info.title,40)}" />
	            	<c:out value="${title}"/>
            	</a></li>
	       	</c:forEach>
       	</s:if>
       	<s:else>
       		���޹�����Ϣ
       	</s:else>
       	<!-- ����������Ϣ End-->
       	
      </div>
    </div>
  </div>
</div>
	<div class="divspan3">
    <div class="module3">
    <table  border="0" cellspacing="0" cellpadding="0" align="center">
      <tr>
        <td width="275" height="599" rowspan="5" valign="top" class="frameline"><div class="framesubnavbj">
          <div class="frametitle">ҵ����Ϣ</div>
          <div class="framemore"><a href='/communi/operationList.do' class="a3">����</a></div>
        </div>
          
          <!-- ����ҵ����Ϣ Begin-->
          <s:if test="%{bean.operationinfo.size > 0}">
          	<c:forEach items="${bean.operationinfo}" var="info" varStatus="status" begin="0" end="3">
	          <div class="frametitle2">
	          	<c:set var="title" value="${fun:fOmit(info.title,20)}" />
	          	<a href="javaScript:f_openDetl('/communi/showOperation.do?parameter.advinfoid=<c:out value="${info.advinfoid}"/>&parameter.type=<c:out value="${info.type}"/>','ҵ����Ϣ')" class="a1"><c:out value="${title}"/></a>
	          	<img src="/images/img/new.GIF" width="21" height="11" />
	          </div>
          	  <div class="framecontent2">
            	<table border="0" cellspacing="0" cellpadding="0">
              	<tr>
                	<td valign="top">
                	<c:choose>
                		<c:when test="${stuts.index == 0}">
                			<img src="/images/img/image.JPG" width="68" height="68" />
                		</c:when>
                		<c:when test="${stuts.index == 1}">
                			<img src="/images/img/image-1.JPG" width="68" height="68" />
                		</c:when>
                		<c:when test="${stuts.index == 2}">
                			<img src="/images/img/image-2.JPG" width="68" height="68" />
                		</c:when>
                		<c:when test="${stuts.index == 3}">
                			<img src="/images/img/image-3.JPG" width="68" height="68" />
                		</c:when>
                	</c:choose>
                	</td>
                	<td valign="top">
                	<div class="framelist5">
                		<c:set var="content" value="${fun:moveHTML(info.content,40)}" />
                		<li><c:out value="${content}"/></li>
                	</div>
                	</td>
              	</tr>
            	</table>
          	</div>
          </c:forEach>
          </s:if>
          <s:else>
          	����ҵ����Ϣ
          </s:else>
          <!-- ����ҵ����Ϣ End-->
          
          <div class="frametitle1"></div></td>
      </tr>
      <tr>
        <td height="12"></td>
      </tr>
    </table>
    
    </div>
    
    <div class="module4">
    
    <div class="divspan4">
      <table width="622"  height="210px" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td  valign="top" class="frameline"><div class="framesubnavbj">
            <div class="frametitle">֪ʶ��</div>
            <div class="framemore"><a href='/communi/knowledgeList.do' class="a3">����</a></div>
          </div>
            
            <div class="framecontent">
          
          <!-- ����֪ʶ����Ϣ Begin-->
          <s:if test="%{bean.knowledge.size > 0}">
              <div class="framelist2">
              	<c:forEach items="${bean.knowledge}" var="info" varStatus="status" end="4">
	                <li>
	                	<a href="javaScript:f_openDetl('/communi/showKnowledge.do?parameter.advinfoid=<c:out value="${info.advinfoid}"/>&parameter.type=<c:out value="${info.type}"/>','֪ʶ��')"  class="a4">
	            		<c:set var="title" value="${fun:fOmit(info.title,30)}" />
		            	<c:out value="${title}"/>
	            		</a>
	            	</li>
	            </c:forEach>
              </div>
              
              <div class="framelist3">
                <c:forEach items="${bean.knowledge}" var="info" varStatus="stuts" begin="5">
	                <li>
	                	<a href="javaScript:f_openDetl('/communi/showKnowledge.do?parameter.advinfoid=<c:out value="${info.advinfoid}"/>&parameter.type=<c:out value="${info.type}"/>','֪ʶ��')"  class="a4">
	            		<c:set var="title" value="${fun:fOmit(info.title,30)}" />
		            	<c:out value="${title}"/>
	            		</a>
	            	</li>
	            </c:forEach>
              </div>
           
          </s:if>
          <s:else>
          	֪ʶ��������Ϣ
          </s:else>
           <!-- ����֪ʶ����Ϣ End-->
            
            </div>
           
           </td>
        </tr>
      </table>
    </div>
    
    <div class="divspan4">
      <table width="622"   height="184px" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td  valign="top" class="frameline"><div class="framesubnavbj">
            <div class="frametitle">�ҵ�����</div>
            <div class="framemore"><a href='/interlocution/myQuestion.do' class="a3">����</a></div>
          </div>
          <div class="framecontent">
              
              
              <!-- �����ҵ�������Ϣ Begin-->
          <s:if test="%{bean.interlocution.size > 0}">
              <div class="framelist2">
              	<c:forEach items="${bean.interlocution}" var="info" varStatus="stuts" end="4">
	                <li>
	                	<a href="javaScript:f_openDetl('/interlocution/showInterlocution.do?parameter.advinfoid=<c:out value="${info.advinfoid}"/>&parameter.type=<c:out value="${info.type}"/>','�ҵ�����')"  class="a4">
	            		<c:set var="title" value="${fun:fOmit(info.title,30)}" />
		            	<c:out value="${title}"/>
	            		</a>
	            	</li>
	            </c:forEach>
              </div>
              <div class="framelist3">
                <c:forEach items="${bean.interlocution}" var="info" varStatus="stuts" begin="5">
	                <li>
	                	<a href="javaScript:f_openDetl('/interlocution/showInterlocution.do?parameter.advinfoid=<c:out value="${info.advinfoid}"/>&parameter.type=<c:out value="${info.type}"/>','�ҵ�����')"  class="a4">
	            		<c:set var="title" value="${fun:fOmit(info.title,30)}" />
		            	<c:out value="${title}"/>
	            		</a>
	            	</li>
	            </c:forEach>
              </div>
          </s:if>
          <s:else>
          	֪ʶ��������Ϣ
          </s:else>
           <!-- �����ҵ�������Ϣ End-->
              
              
            </div>
            <div class="framecontent"></div></td>
        </tr>
      </table>
    </div>
    
    <div class="divspan4">
      <table width="622"  height="184px"border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td  valign="top" class="frameline"><div class="framesubnavbj">
            <div class="frametitle">�����ʾ�</div>
            <div class="framemore"></div>
          </div>
          <div class="framecontent">
           
           <!-- ���������ʾ���Ϣ Begin-->
          <s:if test="%{bean.questionnaire.size > 0}">
              <div class="framelist2">
              	<c:forEach items="${bean.questionnaire}" var="info" varStatus="stuts" end="4">
	                <li>
	                	<a href="javaScript:f_openDetl('/communi/showQuestionnaire.do?parameter.advinfoid=<c:out value="${info.advinfoid}"/>&parameter.type=<c:out value="${info.type}"/>','�����ʾ�')"  class="a4">
	            		<c:set var="title" value="${fun:fOmit(info.title,30)}" />
		            	<c:out value="${title}"/>
	            		</a>
	            	</li>
	            </c:forEach>
              </div>
              
              <div class="framelist3">
                <c:forEach items="${bean.questionnaire}" var="info" varStatus="stuts" begin="5">
	                <li>
	                	<a href="javaScript:f_openDetl('/communi/showQuestionnaire.do?parameter.advinfoid=<c:out value="${info.advinfoid}"/>&parameter.type=<c:out value="${info.type}"/>','�����ʾ�')"  class="a4">
	            		<c:set var="title" value="${fun:fOmit(info.title,30)}" />
		            	<c:out value="${title}"/>
	            		</a>
	            	</li>
	            </c:forEach>
              </div>
           
          </s:if>
          <s:else>
          	���޵����ʾ���Ϣ
          </s:else>
           <!-- ���������ʾ���Ϣ End-->
           
            <div class="framecontent"></div></td>
        </tr>
      </table>
    </div>
    
    
    
    </div>
  </div>
</div>
<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<%@include file="/common/meta_js.jsp"%>
</html>
<script type="text/javascript">
function f_openDetl2(id){
	f_openDetl(contextRootPath+"/communi/showAffiche.do?parameter.advinfoid="+id+"&parameter.type=1",'������Ϣ');
}
</script>