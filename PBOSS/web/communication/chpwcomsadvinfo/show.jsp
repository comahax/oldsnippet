<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
<title><s:text name="titleUpdate"/></title>
<script language="JavaScript">
window.opener.document.formList.submit();

function doAffixDownload() {
    formItem.action = "<%=contextPath %>/communication/chpwcomsadvinfo_affixDownload.do";
    formItem.submit();
}
</script>
</head>
<body>
<div class="table_container">
<s:form action="" cssStyle="formList" key="formItem" method="post" theme="simple">
	<s:hidden name="form.affixpath" id="affixpath"/>
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
		</div>
	</div>
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right" width="200px"><s:text name="title"/>:&nbsp</td>
                <td align="left"><s:property value="form.title" /></td>
            </tr>
            <tr>
                <td align="right"><s:text name="content"/>:&nbsp</td>
                <td align="left"><s:property value="form.content" escape="false"/></td>
            </tr>
            <tr>
                <td align="right"><s:text name="affix"/>:&nbsp</td>
                <td align="left">
					<a href="javascript:doAffixDownload();"><s:property value="form.affixname" /></a>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="releasetime"/>:&nbsp</td>
                <td align="left"><s:date name="form.releasetime" format="yyyy-MM-dd"/></td>
            </tr>
            <tr>
                <td align="right"><s:text name="releasecode"/>:&nbsp</td>
                <td align="left"><j:code2Name definition="#OPERATOR" code="form.releasecode" /></td>
            </tr>
            <tr>
                <td align="right"><s:text name="rcvobjtype"/>:&nbsp</td>
                <td align="left"><j:code2Name definition="COMSRCVOBJ_RCVOBJTYPE" code="form.rcvobjtype" /></td>
            </tr>
            <tr>
                <td align="right"><s:text name="smsnotify"/>:&nbsp</td>
                <td align="left"><j:code2Name definition="SMSNOTIFY" code="form.smsnotify" /></td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_close"/>" onClick="window.close();">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>