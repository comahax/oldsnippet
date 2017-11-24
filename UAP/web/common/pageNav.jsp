<%@ page  import="com.sunrise.jop.infrastructure.db.DataPackage"%>
<s:i18n name="public">
  <div class="page tal">
    <div class="left">&nbsp;&nbsp;
<s:if test="(dp.pageNo>1)">
	  <a href="javascript:showFirstPage();">&lt;&lt;</a> 
	  <a href="javascript:showPreviousPage();">&lt;</a>
</s:if>
<s:else>
<a class="disabled">&lt;&lt;</a>
<a class="disabled">&lt;</a>
</s:else>
<s:text name="button_order" />
<input type="hidden" name="totalPage" value="${dp.totalPage}"/>
<input name="param.goto_page"  class="tac" type="text" onkeydown="javascript:if(event.keyCode==13){goPage();}" id="goto_page" value='<s:property value="dp.pageNo"/>' />
<s:text name="button_page" />
<s:if test="(dp.pageSize > 0 && dp.pageNo<dp.totalPage)">
	  <a href="javascript:showNextPage();">&gt;</a> 
	  <a href="javascript:showLastPage();">&gt;&gt;</a>
</s:if>
<s:else>
<a class="disabled">&gt;</a>
<a class="disabled">&gt;&gt;</a>
</s:else>
    </div>
    <div class="right">
    <s:text name="button_total_page" />
<s:if test="(dp.pageSize > 0)">
	<span class="red">
	<s:property value="dp.totalPage" />
	</span>
</s:if><s:else>1</s:else>
	<s:text name="button_page" />
	&nbsp;&nbsp;&nbsp;&nbsp;
	<s:text name="button_total_page" />
	 <span class="red">
	 <s:property value="dp.rowCount" />
	 </span>
	<s:text name="button_record" />
	&nbsp;&nbsp;
	</div>
  </div>

</s:i18n>

