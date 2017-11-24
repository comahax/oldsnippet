<s:i18n name="public">
<table class=" page_table">
	<tr valign=middle>
		<td align=left height=30>
			<s:if test="(dp.pageNo>1)">
				<a href="javascript:showFirstPage();"><img src="images/first.gif" alt="<s:text name="button_first_page"/>" width="59" height="18" border="0"></a>
				<a href="javascript:showPreviousPage();"><img src="images/preview.gif" alt="<s:text name="button_forward"/>" width="59" height="18" border="0"></a>
			</s:if>
			<s:if test="(dp.pageNo<dp.totalPage)">
				<a href="javascript:showNextPage();"><img src="images/next.gif" alt="<s:text name="button_next"/>" width="59" height="18" border="0"></a>
				<a href="javascript:showLastPage();"><img src="images/last.gif" alt="<s:text name="button_last_page"/>" width="59" height="18" border="0"></a>
			</s:if>
			&nbsp;&nbsp;
		</td>
		<td align=right style="font-size:12px;">
			<s:if test="(dp.totalPage>0)">
				<s:text name="button_total_page" />
				<font color="red"><s:property value="dp.totalPage" /></font>
				<s:text name="button_page" />
			</s:if>
			&nbsp;
			<s:text name="button_current_page" />
			<font color="red"><s:property value="dp.pageNo" /></font>
			<s:text name="button_page" />
			&nbsp; <s:text name="button_goto_page" />
			<input name="param.goto_page" type="text" size="2" ID="goto_page" value="<s:property value="dp.pageNo" />">
			<s:text name="button_page" /><a href="javascript:gotoPage();"><img src="images/go.gif" alt="<s:text name="button_goto_page" />" width="16" height="14" border="0"></a>
		</td>
	</tr>
</table>
</s:i18n>

