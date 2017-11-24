<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
    var packSizeMap = new Map();//��Ʒ�������СMAP
    var comcateNamemap = new Map();//��Ʒ��������MAP
    <s:iterator value="dp.datas">
    packSizeMap.put('<s:property value="comcategory"/>','<s:property value="packSize"/>');
    comcateNamemap.put('<s:property value="comcategory"/>','<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/>');
    </s:iterator>
    
    	var checkFlag = true;
    
        function ev_check() {
        if(checkFlag){
        	return check_adjustScale();
        }else{
        	return true;	
            //return checkval(window);
            }
        }
        
        function doPrev(){
        	checkFlag = false;
        	doQuery('/resource/compack_goUploadresource.do');
        }
        
        function doNext(){
        	checkFlag = true;
        	doQuery('/resource/compack_toolSetScale.do');
        }
        
        //�����Ʒ������ı����Ƿ���ȷ����Ʒ�¸��������͵����������Ƿ������С��ȣ�
        function check_adjustScale(){
	        var totlaScaleMap = new Map();//��Ʒ���������ı����ܺ�MAP��
	        var elements = document.getElementsByTagName("input");
			for(var i = 0;i<elements.length;i++){
				var element = elements[i];
				if("text" == element.type ){//ע��Ҫ��ҳ��ֻ����Ʒ�������͵ĵ�������������ΪTEXT
				var name=element.name;
				
				var value = element.value;
				var names = name.split('@');//ÿ���������͵������������Ϊ��Ʒ����+'@'+��������
					if(!totlaScaleMap.containsKey(names[0])){
						totlaScaleMap.put(names[0],element.value);
					}else{
						var scale = totlaScaleMap.get(names[0]);
						scale = parseFloat(scale)+parseFloat(element.value);
						totlaScaleMap.put(names[0],scale);
					}					
				}	
			}
		
			var keys = packSizeMap.keys();
			for(var i = 0;i<keys.length;i++){			
				if(parseFloat(packSizeMap.get(keys[i])) != parseFloat(totlaScaleMap.get(keys[i])).toFixed(2)){
		 //ԭ����if(parseFloat(packSizeMap.get(keys[i])) != parseFloat(totlaScaleMap.get(keys[i]).toFixed(2))){
				var msg = '<span class=\'errorkey\' style=\'font-size:12px;\'><span style=\'color:#F00; font-size:12px;\'>[' + comcateNamemap.get(keys[i]) + ']</span>: ���������������󣬸����͵��������֮��Ӧ����ÿ���׿���������������д</span>';
				errorMessageShow(msg);
				return false;
				}
			}
			return true;
        }
        
        function validate(aValue){
        var reg = /^[0-9]+.[0-9]{0,2}$/;
        if(!reg.test(aValue)){
        alert('������ʽΪ����λС������ֵ��00.##��');
        }
        }
    </script>
	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="compack_list.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<%
					//����Ŀؼ���Action�ṩ���ݣ�������ҳ
				%>
				<s:hidden name="param._pageno" />
				<s:hidden name="filepath"></s:hidden>
				<s:hidden name="paramMap.comcategory" />
				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<span class="table_toparea_h"><s:text name="title_setscale" />
						</span>

					</div>
				</div>

				<aa:zone name="errorZone">
					<div class="error_text">
						<table class="error_text">
							<s:actionerror />
							<s:actionmessage />
						</table>
					</div>
				</aa:zone>


				<div class="table_div">
					<s:iterator id="tt" value="dp.datas">
						<table class="table_style">
							<tr class="table_style_head">
								<td align="left"
									colspan='<s:property value="#tt.numberTypeInfo.size+1"/>'>
									<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory" />
									ÿ���׿��������ף�
									<s:property value="packSize" />
								</td>
							</tr>
							<tr class="table_style_head">
								<td></td>
								<s:iterator value="numberTypeInfo">
									<td>
										<j:code2Name definition="#Numtypedef" code="type" />
									</td>
								</s:iterator>
							</tr>
							<tr class="table_style_content" align="center">
								<td>
									���ͷֲ�
								</td>
								<s:iterator value="numberTypeInfo">
									<td>
										<s:property value="quantity" />
									</td>
								</s:iterator>
							</tr>
							<tr class="table_style_content" align="center">
								<td>
									Ĭ�ϱ���
								</td>
								<s:iterator value="numberTypeInfo">
									<td>
										<s:property value="scale" />
									</td>
								</s:iterator>
							</tr>
							<tr class="table_style_content" align="center">
								<td>
									���������
								</td>
								<s:iterator value="numberTypeInfo">
									<td>
										<input style="width: 100%"
											name='<s:property value="comcategory"/>@<s:property value="type"/>'
											value="<s:property value="scale"/>"
											onchange="validate(this.value);" />
									</td>
								</s:iterator>
							</tr>
						</table>
					</s:iterator>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" align="center">
								<s:i18n name="public">
									<input type="button" id="btnSave" name="btnNext"
										class="button4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="��һ��" onclick="doPrev()" />
									<input type="button" id="btnSave" name="btnNext"
										class="button4" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="��һ��" onclick="doNext()" />
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	//ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
	</body>
</html>
