<#--
/*
 * $Id: text.ftl 720258 2008-11-24 19:05:16Z musachy $
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
<#if parameters.get("showOnly")?default(true) == true>

<#if parameters.get("isSensitive")?default(true) == true && parameters.nameValue??>
	<#--*号变量　 -->
        <#assign xinghao="********************************************************************************
        **************************************************************************************************
        **************************************************************************************************
        **************************************************************************************************
        **************************************************************************************************"> 
        
        
         <#assign sensitiveValue="${xinghao?substring(0,parameters.nameValue?length)}">
	
        <#if parameters.otherRight?? && parameters.otherRight == "SensitiveInfoLevelHighMid"><#--中权限开始 -->
        
        <#if parameters.hiddenPosition?? && parameters.hiddenPosition != "0,0,0"><#-- 隐藏不为空-->
			<#assign positionArray=parameters.hiddenPosition?split(",")>
			<#assign totalLength=positionArray[0]?number+positionArray[1]?number+positionArray[2]?number >
		    
                <#if totalLength?default(0) gt parameters.nameValue?length><#-- 隐藏所有-->
                        <#assign sensitiveValue="${xinghao?substring(0,parameters.nameValue?length)}">  
                        <#else> 
                         <#assign sensitiveValue="${parameters.nameValue?substring(0,parameters.nameValue?length)}">
                        <#if positionArray[0]?number != 0><#-- 前置隐藏不为０ -->
                        	<#assign sensitiveValue="${xinghao?substring(0,positionArray[0]?number)+sensitiveValue?substring(positionArray[0]?number,sensitiveValue?length)}"> 
                        </#if>
                        <#if positionArray[1]?number != 0><#--中间隐藏不为０-->
                        	<#assign middle =(sensitiveValue?length/2)?int >
                        	<#assign left=(positionArray[1]?number/2)?int>
                        	<#assign sensitiveValue="${sensitiveValue?substring(0,middle-left)+xinghao?substring(0,positionArray[1]?number)+sensitiveValue?substring(middle+positionArray[1]?number-left,sensitiveValue?length)}"> 
                        </#if>
                        <#if positionArray[2]?number != 0><#--r后置隐藏不为０ -->
                        	<#assign sensitiveValue="${sensitiveValue?substring(0,sensitiveValue?length-positionArray[2]?number)+xinghao?substring(0,positionArray[2]?number)}">
                        </#if>
                </#if>
                
             <#elseif parameters.showPosition?? && parameters.showPosition != "0,0,0"><#-- 显示部分数据　开始-->
             	<#assign positionArray=parameters.showPosition?split(",")>
             	<#assign totalLength=positionArray[0]?number+positionArray[1]?number+positionArray[2]?number >
		    
                <#if totalLength?default(0) gt parameters.nameValue?length><#-- 显示所有-->
                        <#assign sensitiveValue="${parameters.nameValue?substring(0,parameters.nameValue?length)}">  
                        <#else> 
                        <#assign sensitiveValue="${xinghao?substring(0,parameters.nameValue?length)}">  
                        <#if positionArray[0]?number != 0><#-- 前置显示不为０ -->
                        	<#assign sensitiveValue="${parameters.nameValue?substring(0,positionArray[0]?number)+sensitiveValue?substring(positionArray[0]?number,sensitiveValue?length)}"> 
                        </#if>
                        <#if positionArray[1]?number != 0><#--中间显示不为０-->
                        	<#assign middle =(sensitiveValue?length/2)?int >
                        	<#assign left=(positionArray[1]?number/2)?int>
                        	<#assign sensitiveValue="${sensitiveValue?substring(0,middle-left)+parameters.nameValue?substring(middle-left,middle-left+positionArray[1]?number)+sensitiveValue?substring(middle-left+positionArray[1]?number,sensitiveValue?length)}"> 
                        </#if>
                        <#if positionArray[2]?number != 0><#--后置显示不为０ -->
                        	<#assign sensitiveValue="${sensitiveValue?substring(0,sensitiveValue?length-positionArray[2]?number)+parameters.nameValue?substring(parameters.nameValue?length-positionArray[2]?number,parameters.nameValue?length)}">
                        </#if>
                   </#if>
             <#-- 显示部分数据　结束-->
             <#else><#--未配置　隐藏或显示 哪里数据里情况　开始-->
                <#assign sensitiveValue="${sensitiveValue?substring(0,sensitiveValue?length)}">
                
             <#--未配置　隐藏或显示 哪里数据里情况　结束-->
        </#if><#-- 隐藏不为空结束-->
	</#if> <#--中权限结束 -->
       

${sensitiveValue}
<#else>
<@s.property value="parameters.nameValue"/><#t/>
</#if>
<#else>


<#if parameters.get("isSensitive")?default(true) == true><#--敏感信息 -->

<input type="hidden"<#rt/><#-- 隐藏域-->
name="${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength??>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.nameValue??>
 value="<@s.property value="parameters.nameValue"/>"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>

<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
/>

<input type="text"<#rt/>
name="temp_${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength??>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.nameValue??><#-- 只有有数据时才显示*号-->
          
        <#--*号变量　 -->
        <#assign xinghao="********************************************************************************
        **************************************************************************************************
        **************************************************************************************************
        **************************************************************************************************
        **************************************************************************************************"> 
         <#assign sensitiveValue="${xinghao?substring(0,parameters.nameValue?length)}">
        <#if parameters.otherRight?? && parameters.otherRight == "SensitiveInfoLevelHighMid"><#--中权限开始 -->
        <#if parameters.hiddenPosition?? && parameters.hiddenPosition != "0,0,0"><#-- 隐藏不为空-->
			<#assign positionArray=parameters.hiddenPosition?split(",")>
			<#assign totalLength=positionArray[0]?number+positionArray[1]?number+positionArray[2]?number >
		    
                <#if totalLength?default(0) gt parameters.nameValue?length><#-- 隐藏所有-->
                        <#assign sensitiveValue="${xinghao?substring(0,parameters.nameValue?length)}">  
                        <#else> 
                         <#assign sensitiveValue="${parameters.nameValue?substring(0,parameters.nameValue?length)}">
                        <#if positionArray[0]?number != 0><#-- 前置隐藏不为０ -->
                        	<#assign sensitiveValue="${xinghao?substring(0,positionArray[0]?number)+sensitiveValue?substring(positionArray[0]?number,sensitiveValue?length)}"> 
                        </#if>
                        <#if positionArray[1]?number != 0><#--中间隐藏不为０-->
                        	<#assign middle =(sensitiveValue?length/2)?int >
                        	<#assign left=(positionArray[1]?number/2)?int>
                        	<#assign sensitiveValue="${sensitiveValue?substring(0,middle-left)+xinghao?substring(0,positionArray[1]?number)+sensitiveValue?substring(middle+positionArray[1]?number-left,sensitiveValue?length)}"> 
                        </#if>
                        <#if positionArray[2]?number != 0><#--r后置隐藏不为０ -->
                        	<#assign sensitiveValue="${sensitiveValue?substring(0,sensitiveValue?length-positionArray[2]?number)+xinghao?substring(0,positionArray[2]?number)}">
                        </#if>
                </#if>
                
             <#elseif parameters.showPosition?? && parameters.showPosition != "0,0,0"><#-- 显示部分数据　开始-->
             	<#assign positionArray=parameters.showPosition?split(",")>
             	<#assign totalLength=positionArray[0]?number+positionArray[1]?number+positionArray[2]?number >
		    
                <#if totalLength?default(0) gt parameters.nameValue?length><#-- 显示所有-->
                        <#assign sensitiveValue="${parameters.nameValue?substring(0,parameters.nameValue?length)}">  
                        <#else> 
                        <#assign sensitiveValue="${xinghao?substring(0,parameters.nameValue?length)}">  
                        <#if positionArray[0]?number != 0><#-- 前置显示不为０ -->
                        	<#assign sensitiveValue="${parameters.nameValue?substring(0,positionArray[0]?number)+sensitiveValue?substring(positionArray[0]?number,sensitiveValue?length)}"> 
                        </#if>
                        <#if positionArray[1]?number != 0><#--中间显示不为０-->
                        	<#assign middle =(sensitiveValue?length/2)?int >
                        	<#assign left=(positionArray[1]?number/2)?int>
                        	<#assign sensitiveValue="${sensitiveValue?substring(0,middle-left)+parameters.nameValue?substring(middle-left,middle-left+positionArray[1]?number)+sensitiveValue?substring(middle-left+positionArray[1]?number,sensitiveValue?length)}"> 
                        </#if>
                        <#if positionArray[2]?number != 0><#--后置显示不为０ -->
                        	<#assign sensitiveValue="${sensitiveValue?substring(0,sensitiveValue?length-positionArray[2]?number)+parameters.nameValue?substring(parameters.nameValue?length-positionArray[2]?number,parameters.nameValue?length)}">
                        </#if>
                   </#if>
             <#-- 显示部分数据　结束-->
             <#else><#--未配置　隐藏或显示 哪里数据里情况　开始-->
                <#assign sensitiveValue="${sensitiveValue?substring(0,sensitiveValue?length)}">
                
             <#--未配置　隐藏或显示 哪里数据里情况　结束-->
        </#if><#-- 隐藏不为空结束-->
	</#if> <#--中权限结束 -->
 value="${sensitiveValue}"<#rt/> 
</#if>

<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id??>
 id="temp_${parameters.id?html}"<#rt/>
</#if>
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>

<#if parameters.onchange??>
 onchange="${parameters.onchange?html} {var destObj = document.getElementById('${parameters.id?html}'); destObj.value=this.value;destObj.display='';this.display='none'}"<#rt/>
 <#else>
 onchange="{var destObj = document.getElementById('${parameters.id?html}'); destObj.value=this.value;destObj.display='';this.display='none'}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
/>

<#else><#--非敏感信息 -->
<input type="text"<#rt/>
name="${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength??>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.nameValue??>
 value="<@s.property value="parameters.nameValue"/>"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>

<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
/>

</#if><#--敏感信息结束标记 -->
 


</#if>
