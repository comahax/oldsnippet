<#--
/*
 * $Id: checkboxlist.ftl 720258 2008-11-24 19:05:16Z musachy $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->
<#assign itemCount = 0/>
<#assign checkCount = 0/>
<#if parameters.list??>
<div class="table_div">
	<div class="table_normal">
		<table class="table_style">
			<tr>
    <@s.iterator value="parameters.list">
        <#assign itemCount = itemCount + 1/>
        <#if parameters.listKey??>
            <#assign itemKey = stack.findValue(parameters.listKey)/>
        <#else>
            <#assign itemKey = stack.findValue('top')/>
        </#if>
        <#if parameters.listValue??>
            <#assign itemValue = stack.findString(parameters.listValue)?default("")/>
        <#else>
            <#assign itemValue = stack.findString('top')/>
        </#if>
<#assign itemKeyStr=itemKey.toString() />
<td>
	<input type="checkbox" name="${parameters.name?html}" value="${itemKeyStr?html}" id="${parameters.name?html}-${itemCount}" onclick="javascript:isMultiSelectAll('${parameters.name?html}','${parameters.randomCode?html}');"<#rt/>
	        <#if tag.contains(parameters.nameValue, itemKey)>
	        	<#assign checkCount = checkCount + 1/>
	 checked="checked"<#rt/>
	        </#if>
	        <#if parameters.disabled?default(false)>
	 disabled="disabled"<#rt/>
	        </#if>
	        <#if parameters.title??>
	 title="${parameters.title?html}"<#rt/>
	        </#if>
	        <#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
	        <#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
	/>
	<label for="${parameters.name?html}-${itemCount}" class="checkboxLabel">${itemValue?html}</label>
</td>
<#if itemCount % 4 == 0 >
			</tr>
			<tr>
		</#if>
    </@s.iterator>
    <#if (itemCount > 4)>
			<td colspan="100">
				<input type="checkbox" name="selectAll${parameters.randomCode?html}" onclick="javascript:multiSelectAll(this,'${parameters.name?html}')"
					<#if itemCount == checkCount>
					 checked="checked"<#rt/>
	        		</#if>
	        		<#if parameters.disabled?default(false)>
	 				disabled="disabled"<#rt/>
	 				</#if>
				/>
				<label for="selectAll-Label" class="checkboxLabel">ȫѡ</label>
			</td>
		</tr>
	</#if>
<#else>
  &nbsp;
</#if>
		</table>
	</div>
</div>