	
function SetWinHeight(obj,b) //obj为目标节点，b表示按页面高度自适应。
	{ var minHeight = 300;//设置最小高度。
		var win=obj; 
		if (document.getElementById) 
		{ 
		if (win && !window.opera) 
		{ 
		if (win.contentDocument && win.contentDocument.body.offsetHeight) {
			if(b){
				win.height = win.contentDocument.body.offsetHeight;
			}else{
				win.height = win.contentDocument.body.offsetHeight>minHeight?win.contentDocument.body.offsetHeight:minHeight; 
			}
			
		}
	
		else if(win.Document && win.Document.body.scrollHeight){
			if(b){
				win.height = win.Document.body.scrollHeight;
			}else{
				win.height = win.Document.body.scrollHeight>minHeight?win.Document.body.scrollHeight:minHeight; 
			}
			
		} 
		} 
		} 
	}
//从外层控制页面的高度
function resetContentWinHeight(iframeDom){ //iframeDom为iframe节点
	if (document.getElementById){
		if (iframeDom && !window.opera){
			if (iframeDom.contentDocument && iframeDom.contentDocument.body.offsetHeight) {
				iframeDom.height = iframeDom.contentDocument.body.offsetHeight;
			}else if(iframeDom.Document && iframeDom.Document.body
					&& iframeDom.Document.body.scrollHeight){
				iframeDom.height = iframeDom.Document.body.scrollHeight;
			}
		} 
	} 
}
//从内层控制页面的高度
function resetParentWinHeight(h){
	if (document.getElementById){
		if(window.frameElement!=null){
			if(h&&h!=""){
				window.frameElement.style.height = document.body.scrollHeight+h;
			}else{
				window.frameElement.style.height = document.body.scrollHeight;
			}
		}
	} 
}

function windowResize(){
	if(window.frameElement!=null&&window.frameElement.parentNode!=null){
		window.frameElement.parentNode.style.height = document.body.scrollHeight;
		window.frameElement.style.height = document.body.scrollHeight;
	}
}

function resetHeight(w){
	if (w.frameElement){
		w.frameElement.style.height = w.document.body.scrollHeight;
		resetHeight(w.parent);
	} 
}

function resetAllWinHeight(iframeDom){
	iframeDom.style.height = iframeDom.Document.body.scrollHeight;
	resetHeight(iframeDom.contentWindow.parent);
}
function resetModalHeight(){
	window.dialogHeight = document.body.scrollHeight+"px"; 
}
function blankHadle(tableid,rownum,colnum){
    	var table = document.getElementById(tableid);
   		if(table&&table.getElementsByTagName("tbody")[0].childNodes.length==0){
   			var l = table.getElementsByTagName("thead")[0].firstChild.childNodes.length;
   			if(colnum != '' && colnum != null) {
   				l = colnum;
   			}
   			for(var j=0;j<rownum;j++){
  				var newTR = table.insertRow(table.rows.length);
  				var newNameTD=newTR.insertCell(0);
   				newNameTD.colSpan=l>1?l:1;
   				var bodyHeight = table.getElementsByTagName("tbody")[0].childNodes.length;
   				if((bodyHeight%2)==0){
   					newNameTD.className="trbg_2";
   				}
   				if(j==(Math.round(rownum/2)-1)){
   					//newNameTD.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
   					newNameTD.innerHTML = '<div style="padding-left:'+(table.parentNode.clientWidth/2-40)+';height:10px;">'+
   					'<font color="gray" size=2><em>无&nbsp;数&nbsp;据&nbsp;</em></font></div>';
   				}else{
   					
   					newNameTD.innerHTML = "&nbsp;&nbsp;";
   				}
   			}
		}else if(table&&table.getElementsByTagName("tbody")[0].childNodes.length<rownum){
   			var num = rownum - table.getElementsByTagName("tbody")[0].childNodes.length;
   			var l=0;
   			if(colnum != '' && colnum != null) {
   				l = colnum;
   			} else {
   				l = table.getElementsByTagName("thead")[0].firstChild.childNodes.length;
   			}
   			for(var j=0;j<num;j++){
  				var newTR = table.insertRow(table.rows.length);
  				var newNameTD=newTR.insertCell(0);
   				newNameTD.colSpan=l>1?l:1;
   				var bodyHeight = table.getElementsByTagName("tbody")[0].childNodes.length;
   				if((bodyHeight%2)==0){
   					newNameTD.className="trbg_2";
   				}
				newNameTD.innerHTML = "&nbsp;&nbsp;";//alert(bodyHeight);
   			}
		}else if(table==null){
			alert("页面没有"+tableid+"节点！");
		}
}
//var treeurl = {
//		opermanager:{url:basePath+"safeperiod_doQueryAllWaitTask.do",name:"待办任务"},
//		rolemanager:{url:basePath+"pages/task/taskManager.jsp",name:"工作流配置"},
//		rgmanager:{url:basePath+"pages/task/redlist/applyForm.jsp",name:"工单创建"},
//		ghjssz:{url:basePath+"safeperiod/puboperator_list.do",name:"工号角色设置"},
//		redlistcsgz:{url:basePath+"safeperiod/safeperiodfst_list.do",name:"集团红名单初审规则"},
//		redlistspgz:{url:basePath+"safeperiod/safeperiodsec_list.do",name:"集团红名单审批规则"},
//		creditadjseatch:{url:basePath+"safeperiod/creditadj_doFindAll.do?flag=1",name:"信用等级调整查询"},
//		creditadjsq:{url:basePath+"pages/task/creditadj/applyForm.jsp",name:"信用等级申请"},
//		specialOpen:{url:basePath+"pages/task/specialopen/applyForm.jsp",name:"特殊开机"},
//		reportarrear:{url:basePath+"pages/report/report-arrear.jsp?action=getArrearCollect",name:"欠费情况"},
//		reportarrearratio:{url:basePath+"pages/report/report-arrearratio.jsp?action=getArrearDynamicRatioCompany",name:"欠费率分析"},
//		reportarrearhigh:{url:basePath+"pages/report/report-arrearhigh.jsp?action=getHighArrearArea",name:"高额欠费"},
//		reportarrearkey:{url:basePath+"pages/report/report-arrearkey.jsp?action=getKeyArrearProduct",name:"重点欠费"},
//		reportarrearage:{url:basePath+"pages/report/report-arrearage.jsp?action=getArrearAge",name:"欠费账龄"},
//		reportarrearreturn:{url:basePath+"pages/report/report-arrearreturn.jsp?action=getArrearReturnDate",name:"欠费回收"},
//		reportredlist:{url:basePath+"pages/report/report-redlist.jsp?action=getRedlistQuota",name:"红名单分析"},
//		reportcontrolcredit:{url:basePath+"pages/report/report-creditcontrol.jsp?action=getCreditControlWhole",name:"信控分析"},
//		reportworkflow:{url:basePath+"pages/report/report-workflow.jsp?action=getWorklist",name:"工单分析"},
//		reportcontrollevel:{url:basePath+"pages/report/report-creditlevel.jsp?action=getCreditLevel",name:"信用等级分析"},
//		tkjgdsjcx:{url:basePath+"safeperiod/stopopen_list.do",name:"停/开机工单数据查询"},
//		//pttkjjgdr:{url:basePath+"/business/stopopen/importExcel.jsp",name:"平台停/开机结果导入"}, //平台停/开机结果导入
//		tkjczrzcx:{url:basePath+"safeperiod/esopcreditlog_doSqlEsopcreditlogList.do",name:"停/开机操作日志查询"}, //停/开机操作日志查询
//		qfsjcx:{url:basePath+"safeperiod/unwoffcust_list.do",name:"欠费数据查询"},//欠费数据查询
//		jftkjgd:{url:basePath+"safeperiod_doQueryChargeOrder.do",name:"信控停开机审批"},//信控停开机审批
//		jfkjsp:{url:basePath+"safeperiod_doQueryWaitTaskByTypeAndOprCode.do?param._se_type=CHARGESTART",name:"缴费开机审批"},//缴费开机审批
//		xktjsp:{url:basePath+"safeperiod_doQueryWaitTaskByTypeAndOprCode.do?param._se_type=HALTMAC",name:"信控停机审批"},//信控停机审批
//		qfsjsscx:{}, //欠费数据实时查询
//		qfsjffjz:{}, //欠费数据分发校正
//		qfsjffpz:{},//欠费数据分发配置
//		zqgdgl:{url:basePath+"safeperiod/zqtask_doList.do",name:"追欠工单管理"},  //追欠工单管理
//		zqgdcy:{url:"",name:"追欠工单审阅"},  //追欠工单审阅
//		zqgdsy:{},  //追欠轨迹查询/追欠工单查询
//		zqgdgzsz:{url:basePath+"safeperiod/zqrule_doList.do",name:"追欠规则管理"},//追欠工单规则设置/追欠规则管理
//		hzsjfx:{},  //坏账数据分析
//		tskjgd:{url:basePath+"pages/task/specialopen/applyForm.jsp",name:"特殊开机申请"},//特殊开机工单
//		tskjsp:{url:basePath+"safeperiod_doQueryWaitTaskByTypeAndOprCode.do?param._se_type=SPECIALOPEN",name:"特殊开机审批"},//特殊开机审批
//		tskjspgzsz:{url:basePath+"safeperiod/openrule_doList.do",name:"特殊开机审批规则设置"},//特殊开机审批规则设置
//		jtkhxydjcx:{url:basePath+"safeperiod/creditadj_doListByWorkid.do",name:"集团客户信用等级查询"},//集团客户信用等级查询
//		xydjtzsq:{url:basePath+"pages/task/creditadj/applyForm.jsp",name:"信用等级调整申请"},//信用等级调整申请/信用等级调整工单
//		xydjtzsp:{url:basePath+"safeperiod_doQueryWaitTaskByTypeAndOprCode.do?param._se_type=CREDITADJ",name:"信用等级调整审批"},//信用等级调整审批
//		jtxydjtzgdcx:{url:basePath+"safeperiod_doQueryOrderByStarter.do?param._se_type=CREDITADJ",name:"集团信用等级调整工单查询"},//集团信用等级调整工单查询
//		BIxtxydjsjcx:{url:basePath+"safeperiod/bicredit_list.do",name:"BI系统信用等级数据查询"},//BI系统信用等级数据查询
//		xydjtzcsgz:{},//信用等级调整初审规则
//		hmdsq:{url:basePath+"pages/task/redlist/applyForm.jsp",name:"红名单申请/新增工单"},//红名单申请/新增工单
//		hmdsp:{url:basePath+"safeperiod_doQueryWaitTaskByTypeAndOprCode.do?param._se_type=SAFEPERIOD",name:"红名单审批"},//红名单审批
//		hmdys:{},//红名单预审
//		hmddqyj:{},//红名单到期预警
//		jthmdsjgl:{},//集团红名单数据管理/集团红名单
//		jthmdczrzcx:{},//集团红名单操作日志查询
//		jthmdcsgz:{url:basePath+"safeperiod/safeperiodfst_list.do",name:"集团红名单初审规则"},//集团红名单初审规则
//		jthmdspgz:{url:basePath+"safeperiod/safeperiodsec_list.do",name:"集团红名单审批规则"},//集团红名单审批规则
//		sqyygl:{url:basePath+"safeperiod/safeperiodsec_list.do",name:"申请原因管理"},//申请原因管理,
//		dbrw:{url:basePath+"safeperiod_doQueryAllWaitTask.do",name:"待办任务"},//"待办任务
//		//lct:{url:basePath+"safeperiod_doManagerImage.do",name:"测试"},
//		gzlpz:{url:basePath+"pages/task/taskManager.jsp",name:"工作流配置"},//"工作流配置
//		
//		//gdcj:{url:basePath+"pages/task/redlist/applyForm.jsp",name:"工单创建"},//"工单创建
//		gdcx:{url:basePath+"safeperiod_doOrderLogQuery.do",name:"工单查询"},
//		
//		
//		
//		jtqfl:{url:basePath+"flash/map/cityStaOwefeeRate.jsp",name:"静态欠费率"},//静态欠费率
//		dtqfl:{url:basePath+"flash/map/cityDynOwefeeRate.jsp",name:"动态欠费率"},//动态欠费率
//		qfltjdt:{url:basePath+"flash/map/esopMap.jsp",name:"欠费率统计地图"},//欠费率统计地图
//		zwsjtx:{url:basePath+"/owefeerate_doQueryProvWarnData.do",name:"账务数据提醒"},//账务数据提醒
//		qflcpqs:{url:basePath+"/owefeerate_doQueryQFProductTop10.do",name:"全省重点欠费集团产品"},//全省重点欠费集团产品
//		qfljtqs:{url:basePath+"/owefeerate_doQueryQFCustomerTop10.do",name:"全省重点欠费集团客户"}//全省重点欠费集团客户
//	}

	//实例化dom管理器，并添加“工作台”tab的id，并且工作台不允许删除。
	var domManager = new Array();
	domManager.push("zcryzw");
	
	var domManager2 = new Array();
	domManager2.push("zcryzw2");
	
	var domManager3 = new Array();
	domManager3.push("zcryzw3");
	
	var domManager4 = new Array();
	domManager4.push("zcryzw4");

	function contentDivDisplay(id,cid,uid){
		var uldom = document.getElementById(uid);
		//var liList = uldom.getElementsByTagName("li");
		var liList = uldom.childNodes;
		for(var i=0;i<liList.length;i++){
			liList[i].className = "tab_b";
		}
		document.getElementById("li"+id).className = "tab_a";
		
		var contentDivChilds = document.getElementById(cid).childNodes;
		for(var i=0;i<contentDivChilds.length;i++){
			contentDivChilds[i].style.display = "none";
		}
		document.getElementById("div"+id).style.display = "";
		resetAllWinHeight(document.getElementById("div"+id).getElementsByTagName("iframe")[0]);
	}
	function removeDom(id,cid,uid,managerid){
		if(managerid=="domManager"){
			var panelmanager = domManager;
		}else if(managerid=="domManager2"){
			var panelmanager = domManager2;
		}else if(managerid=="domManager3"){
			var panelmanager = domManager3;
		}else if(managerid=="domManager4"){
			var panelmanager = domManager4;
		}
		var cursor ;
		document.getElementById(uid).removeChild(document.getElementById("li"+id));
		document.getElementById(cid).removeChild(document.getElementById("div"+id));
		for(var i=0;i<panelmanager.length;i++){
			if(panelmanager[i]==id){
				cursor = i;
				//从管理器移除。
				panelmanager.splice(i,1);
				break;
			}
		}
		
		var uldom = document.getElementById(uid);
		//var liList = uldom.getElementsByTagName("li");
		var liList = uldom.childNodes;
		for(var i=0;i<liList.length;i++){
			liList[i].className = "tab_b";
		}
		var li = document.getElementById("li"+panelmanager[cursor-1]);
		li.className = "tab_a";
		
		var contentDivChilds = document.getElementById(cid).childNodes;
		for(var i=0;i<contentDivChilds.length;i++){
			contentDivChilds[i].style.display = "none";
		}
		document.getElementById("div"+panelmanager[cursor-1]).style.display = "";
		resetAllWinHeight(document.getElementById("div"+panelmanager[cursor-1]).getElementsByTagName("iframe")[0]);
	}
	function tonclick(id,cid,uid,managerid,url,name){
		if(managerid=="domManager"){
			var panelmanager = domManager;
		}else if(managerid=="domManager2"){
			var panelmanager = domManager2;
		}else if(managerid=="domManager3"){
			var panelmanager = domManager3;
		}else if(managerid=="domManager4"){
			var panelmanager = domManager4;
		}
		//if(!treeurl[id] || url==null) return;
		if(url!=null){id=id+Math.round(Math.random()*10000)+new Date().getTime()}
		if(document.getElementById("li"+id)){
			var uldom = document.getElementById(uid);
			//var liList = uldom.getElementsByTagName("li");
			var liList = uldom.childNodes;
			for(var i=0;i<liList.length;i++){
				liList[i].className = "tab_b";
			}
			var li = document.getElementById("li"+id);
			li.className = "tab_a";
			
			var contentDivChilds = document.getElementById(cid).childNodes;
			for(var i=0;i<contentDivChilds.length;i++){
				contentDivChilds[i].style.display = "none";
			}
			document.getElementById("div"+id).style.display = "";
			
		}else{
			var uldom = document.getElementById(uid);
			//var liList = uldom.getElementsByTagName("li");
			var liList = uldom.childNodes;
			for(var i=0;i<liList.length;i++){
				liList[i].className = "tab_b";
			}
			var li = document.createElement("li");
			li.setAttribute("id","li"+id);
			li.className = "tab_a";
			if(name==null){
				li.innerHTML = "<span class=\"tab_a1\" onMouseOver=\"this.className='tab_a2';\"" +
				"onMouseOut=\"this.className='tab_a1';\" onclick=removeDom('"+id+"','"+cid+"','"+uid+"','"+managerid+"') ></span>"+treeurl[id].name;
			}else{
				li.innerHTML = "<span class=\"tab_a1\" onMouseOver=\"this.className='tab_a2';\"" +
				"onMouseOut=\"this.className='tab_a1';\" onclick=removeDom('"+id+"','"+cid+"','"+uid+"','"+managerid+"') ></span>"+name;
			}
			//li.innerHTML = "<span class=\"tab_a1\" onMouseOver=\"this.className='tab_a2';\"" +
				//"onMouseOut=\"this.className='tab_a1';\" onclick=removeDom('"+id+"','"+cid+"','"+uid+"','"+managerid+"') ></span>"+treeurl[id].name;
			uldom.appendChild(li);
			
			if (window.attachEvent)
			{
			    //IE 的事件代码
				document.getElementById("li"+id).attachEvent("onclick", function(){contentDivDisplay(id,cid,uid);});
			}
			else
			{
			    //其它浏览器的事件代码
				obj.addEventListener("click", contentDivDisplay(id,cid,uid), false);
			}
			//document.getElementById("li"+id).setAttribute('onclick',document.all ? eval_r(contentDivDisplay("li"+id)) : 'javascript:contentDivDisplay('+("li"+id)+')');
			//document.getElementById("li"+id).onclick = contentDivDisplay("li"+id);
			
			var contentDivChilds = document.getElementById(cid).childNodes;
			for(var i=0;i<contentDivChilds.length;i++){
				contentDivChilds[i].style.display = "none";
			}
			var newContentDiv = document.createElement("div");
			newContentDiv.setAttribute("id","div"+id);
			if(url){
				//newContentDiv.innerHTML = "<iframe frameborder='0' width='665' height='500' src='"+url+"'></iframe>";
				newContentDiv.innerHTML = "<iframe onload='Javascript:SetWinHeight(this)'  id='"+id+"' src='"+basePath+url+"' width='666' height='888' frameborder='0' scrolling='no'></iframe>";
					//"<iframe frameborder='0' width='100%' height='100%' src='"+url+"'></iframe>";
				//<iframe src='list.html' width='666' height='888' frameborder='0' scrolling='no'></iframe>
			}else{
				//newContentDiv.innerHTML = "<iframe frameborder='0' width='665' height='500' src='"+treeurl[id].url+"'></iframe>";
				newContentDiv.innerHTML = "<iframe  onload='Javascript:SetWinHeight(this)' id='"+id+"' src='"+treeurl[id].url+"' width='666' height='500' frameborder='0' scrolling='no'></iframe>";
			}
			document.getElementById(cid).appendChild(newContentDiv);
			
			//模仿dom管理器，把tab的id进行管理。
			panelmanager.push(id);
			//window.frames[0].Document.window.parent.scrollTo(0,window.scrollHeight);
		}
	};
	
	function openTab(multi,id,name,url){
		var v = document.getElementById("dmanager").value;
		var vs = v.split("|");
		
		var cid = vs[0];
		var uid = vs[1];
		var managerid = vs[2];
		var formerid = id;
		
		if(managerid=="domManager"){
			var panelmanager = domManager;
		}else if(managerid=="domManager2"){
			var panelmanager = domManager2;
		}else if(managerid=="domManager3"){
			var panelmanager = domManager3;
		}else if(managerid=="domManager4"){
			var panelmanager = domManager4;
		}
		//if(treeurl[formerid]==null&&url==null) return;
		if(multi){id=id+Math.round(Math.random()*10000)+new Date().getTime()}
		if(document.getElementById("li"+id)){
			var uldom = document.getElementById(uid);
			//var liList = uldom.getElementsByTagName("li");
			var liList = uldom.childNodes;
			for(var i=0;i<liList.length;i++){
				liList[i].className = "tab_b";
			}
			var li = document.getElementById("li"+id);
			li.className = "tab_a";
			
			var contentDivChilds = document.getElementById(cid).childNodes;
			for(var i=0;i<contentDivChilds.length;i++){
				contentDivChilds[i].style.display = "none";
			}
			document.getElementById("div"+id).style.display = "";
			
		}else{
			var uldom = document.getElementById(uid);
			//var liList = uldom.getElementsByTagName("li");
			var liList = uldom.childNodes;
			for(var i=0;i<liList.length;i++){
				liList[i].className = "tab_b";
			}
			var li = document.createElement("li");
			li.setAttribute("id","li"+id);
			li.className = "tab_a";
			if(name==null){
				li.innerHTML = "<span class=\"tab_a1\" onMouseOver=\"this.className='tab_a2';\"" +
				"onMouseOut=\"this.className='tab_a1';\" onclick=removeDom('"+id+"','"+cid+"','"+uid+"','"+managerid+"') ></span>"+treeurl[formerid].name;
			}else{
				li.innerHTML = "<span class=\"tab_a1\" onMouseOver=\"this.className='tab_a2';\"" +
				"onMouseOut=\"this.className='tab_a1';\" onclick=removeDom('"+id+"','"+cid+"','"+uid+"','"+managerid+"') ></span>"+name;
			}
			//li.innerHTML = "<span class=\"tab_a1\" onMouseOver=\"this.className='tab_a2';\"" +
				//"onMouseOut=\"this.className='tab_a1';\" onclick=removeDom('"+id+"','"+cid+"','"+uid+"','"+managerid+"') ></span>"+treeurl[id].name;
			uldom.appendChild(li);
			
			if (window.attachEvent)
			{
			    //IE 的事件代码
				document.getElementById("li"+id).attachEvent("onclick", function(){contentDivDisplay(id,cid,uid);});
			}
			else
			{
			    //其它浏览器的事件代码
				obj.addEventListener("click", contentDivDisplay(id,cid,uid), false);
			}
			//document.getElementById("li"+id).setAttribute('onclick',document.all ? eval_r(contentDivDisplay("li"+id)) : 'javascript:contentDivDisplay('+("li"+id)+')');
			//document.getElementById("li"+id).onclick = contentDivDisplay("li"+id);
			
			var contentDivChilds = document.getElementById(cid).childNodes;
			for(var i=0;i<contentDivChilds.length;i++){
				contentDivChilds[i].style.display = "none";
			}
			var newContentDiv = document.createElement("div");
			newContentDiv.setAttribute("id","div"+id);
			if(url){
				newContentDiv.innerHTML = "<iframe onload='Javascript:SetWinHeight(this)'  id='"+id+"' src='"+url+"' width='666' height='888' frameborder='0' scrolling='no'></iframe>";
			}else{
				newContentDiv.innerHTML = "<iframe  onload='Javascript:SetWinHeight(this)' id="+id+" src='"+treeurl[formerid].url+"' width='666' height='500' frameborder='0' scrolling='no'></iframe>";
			}
			document.getElementById(cid).appendChild(newContentDiv);
			
			//模仿dom管理器，把tab的id进行管理。
			panelmanager.push(id);
			//window.frames[0].Document.window.parent.scrollTo(0,window.scrollHeight);
		}
	}
	
	function shutTab(id){
		var v = document.getElementById("dmanager").value;
		var vs = v.split("|");
		removeDom(id,vs[0],vs[1],vs[2]);
	}
