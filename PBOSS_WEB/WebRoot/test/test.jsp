<%@ page contentType="text/html;charset=GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>List</title>
		<%@include file="/common/meta_allcss.jsp"%>
	</head>
	<body>
		<p><a href="JQList.do">jQuery例子</a></p>
		<FORM name="tst" id="tst" METHOD=POST ACTION="submitAjax.do">
			<INPUT TYPE="text" NAME="query" value="中文"><INPUT TYPE="text" NAME="btest" value="ddd">
			<INPUT TYPE="button" VALUE="提交TEST" ONCLICK="submitThis();"><INPUT TYPE="submit">
		</FORM><!--  //-->
		提交：${query}
	</body>
<%@include file="/common/meta_js.jsp"%>
<SCRIPT LANGUAGE="JavaScript">
<!--
	var submitThis = function(){
		var optn = {
				dataType:'json',
				url:$("#tst").attr("action"),
				success:function(json){
					alert(json["message"]);
				}//success
		}//
		$("#tst").ajaxSubmit(optn);
	}
//-->


</SCRIPT>
</html>
