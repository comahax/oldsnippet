<input type="text"<#rt/>
<#if parameters.name?exists>
 name="${parameters.name?default("")?html}"<#rt/>
</#if>
<#if parameters.id?exists>
 id="${parameters.id?html}_text"<#rt/>
</#if>
<#if parameters.get("size")?exists>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength?exists>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.nameText?exists>
 value="<@s.property value="parameters.nameValue"/>"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="true"<#rt/>
</#if>
<#if parameters.tabindex?exists>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>

<#if parameters.cssClass?exists>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle?exists>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title?exists>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
/><input type="button"<#rt/>
<#if parameters.name?exists>
 name="${parameters.name?html}_button"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
 class="picker_button"
 value="..."
 onclick="javascript:openPicker(this,'${parameters.definition?html}','${parameters.condition?html}');
 <#if parameters.onclick?exists>
 	${parameters.onclick?html}
 </#if>
 "
/>
