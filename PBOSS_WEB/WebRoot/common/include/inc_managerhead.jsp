<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 头部公共导航部分 -->
<c:set var="thisInfo" value ="${pageInfo}"/>
<c:set var="logMem" value ="${_PBOSS_WEB_USER}"/>
<!-- 读取一级菜单项，所有菜单在menuMap中，可一级级定位  -->
<c:set var="ROOT" value="${sessionScope.menuMap['ROOT']}"/>
<jsp:useBean id="role"  class="com.gmcc.pboss.common.dictionary.Role" />
<jsp:useBean id="pageKey" class="com.gmcc.pboss.common.dictionary.PageLoction" />
	<div id="topHead" class="divspan paddingBtn">
	  <table width="100%"  border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
		  <td width="910px" height="121px" valign="top" background="/images/img/header.jpg">
		  <div class="heade" >
		  <c:if test="${logMem != null}">
			<div class="quitbotton"><a href="javascript:void(0)" onclick="f_logout()" class="a5">退出</a></div>
			<div class="font_white">${logMem.officetel}</div>
		  </c:if>
			<div class="font_red"> 欢迎使用广东移动渠道合作伙伴服务平台 </div>
		  </div>
		  </td>
		</tr>
		<c:if test="${logMem!=null && logMem.isnet == role.MANAGER }">
		<tr>
		  <td  width="910px" height="61px" valign="top"  background="/images/img/Memu.jpg" ><!-- menu -->
			<div id="con">
			  <ul id="tags">
				<li class="emptyTag"></li>
				<!-- 一级菜单 -->
			    <c:forEach var="child" items="${ROOT}">
			    	<c:set var="key" value="${child.funcid}"/>
			    		<li class="${key==thisInfo.menuIndex?'selectedTag':'normalTag'}">
				    	   	<c:choose>
				    	    <c:when test="${child.guiobject!=null}">
				    			<a href="${child.guiobject}">
									${child.funcname }
								</a>
				    		</c:when>
				    		<c:otherwise>
				    			<a href="javascript:void(0)" onclick="switchTag('${key}',this)">
									${child.funcname }
								</a>
				    		</c:otherwise>
				    		</c:choose>
			    		</li>
			    </c:forEach>
			  </ul>
			  <div id="tagContent" class="tagContent"> 
			    <!-- 二级菜单 -->
			  	<c:forEach var="child" items="${ROOT}">
					<c:set var="childKey" value="${child.funcid}"/>
					<div id="${child.funcid}" style="display:${childKey==thisInfo.menuIndex?'block':'none'}">
						<ul class="sub">
						<c:forEach var="subChild" items="${sessionScope.menuMap[child.funcid]}">
							<c:set var="subKey" value="${subChild.funcid}"/>
							<c:choose>
							<c:when test="${sessionScope.menuMap[subChild.funcid]==null}"><!-- 无子菜单，对应一个页面 -->
								<li>
								   <a href="${subChild.guiobject}" 
								      class="${subKey==thisInfo.subMenuIndex?'a6_on':'a6'}" 
								      onmouseover="unloadSubMenu3();"
								      >
									 ${subChild.funcname}
									</a>
								</li>
							</c:when>
							<c:otherwise><!-- 尚有下级子菜单 -->
								<li>
									<a href="#" onmouseover="loadSubmenu2('${subChild.funcid}',this);"
									   class="${subKey==thisInfo.subMenuIndex?'a6_on':'a6'}" >
										${subChild.funcname}
									</a>
								</li>
							</c:otherwise>
							</c:choose>
						</c:forEach>
						</ul>
					</div>
				</c:forEach>
			  </div>
			</div>
			</td>
		</tr>
		</c:if>
	  </table>
	</div>
	
	<!-- 三级菜单 -->
	<div id="sub3menu" class="menw3table" onmouseout="this.style.display='none';" onmouseover="this.style.display='block';">
		<c:forEach var="child" items="${ROOT}">
			<c:forEach var="subChild" items="${sessionScope.menuMap[child.funcid]}">
				<!-- 判断该二级菜单是否具有下级子菜单 -->
				<c:if test="${sessionScope.menuMap[subChild.funcid]!=null}">
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="${subChild.funcid}" style ="display:none;">
			<c:forEach var="subChild2" items="${sessionScope.menuMap[subChild.funcid]}">
				<tr onMouseMove="this.bgColor='bfe1e9'" onMouseOut="this.bgColor=''">
				<td>
					<a href="${subChild2.guiobject}"
					   >
					${subChild2.funcname}
					</a>
				</td>
				</tr>
			</c:forEach>
		</table>
				</c:if>
			</c:forEach>
		</c:forEach>
	</div>
	
<SCRIPT LANGUAGE="JavaScript">
//<!--
//显示三级菜单
function loadSubmenu2(menuId,mvObj){
	//debugger;
	unloadSubMenu3();
	var divObj = $("#sub3menu");
	$("#sub3menu table").each(function(){
		var thisObj = $(this);
		if (thisObj.attr("id")==menuId)
			thisObj.show();
		else
			thisObj.hide();
	});
	var lObj = $(mvObj);
	var offset = lObj.offset();
	var offHeight = lObj.height();
	
	//if ( $.browser.msie && /6.0/.test(navigator.userAgent) ){//处理IE6的遮挡问题
	//	$(divObj).bgiframe();
	//}
	divObj.css({"top":offset.top+offHeight-2,"left":offset.left});
	divObj.show();
}

function showMenu(menuId,subMenuId){
	unloadSubMenu3();
	var divObj = $("#sub3menu");
	$("#sub3menu table").each(function(){
		var thisObj = $(this);
		if (thisObj.attr("id")==menuId) 
			thisObj.show();
		else
			thisObj.hide();
	});
}

function unloadSubMenu3(){
	$("#sub3menu").hide();
}
 //切换菜单
function switchTag(tagContent,obj){
	var liObj = $(obj).parent();
	unloadSubMenu3();
	$("#tags li").each(function(){
		//debugger;
		var thisObj = $(this);
		var className = thisObj.attr("class")
		if (className=="normalTag" ||className == 'selectedTag'){
			thisObj.attr("class","normalTag");
		}
	});
	liObj.attr("class","selectedTag");
	//liObj.addClass("selectedTag");
	$("#tagContent div").each(function(){
		var thisObj = $(this)
		if (thisObj.attr("id")!=tagContent){
			thisObj.css("display","none")
		}else{
			thisObj.css("display","block")
		}
	});
}
//-->
</SCRIPT>