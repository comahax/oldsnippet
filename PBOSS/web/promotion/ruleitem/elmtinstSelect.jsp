<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="../elmtinst/content.jsp"%>
<script>
	    //保存完关闭返回
        $(document).ready(function(){
        	$("#top").remove();
        	$("#btnReturn").remove();
        
        	if($("#cmd").val()=="SAVE")
        	{
        		window.returnValue = $("#instid").val();
				window.close();
        	}
        });
</script>
