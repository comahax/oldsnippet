/*---------------------------------------------------------------*\
|              xloadtree扩展,数据量过大的时候需要调用此js               |
|              			@Author: Canigar   			              |
\*---------------------------------------------------------------*/
//重构WebFXLoadTree,tree是构造前面new WebFXLoadTree树的名字,最好都是简单命名
function rebuildWebFXLoadTree(url){
	var parentNode = tree.getSelected().parentNode;
	tree.getSelected().remove();
	//WebFxLoadTree的方法
	startLoadXmlPartTree(url,parentNode);
}
	
/*
 * Helper functions
 */
// creates the xmlhttp object and starts the load of the xml document
function startLoadXmlPartTree(sSrc, jsNode) {
	var xmlHttp = XmlHttp.create();
	xmlHttp.open("GET", sSrc, true);	// async
	xmlHttp.onreadystatechange = function () {
		if (xmlHttp.readyState == 4) {
			xmlPartFileLoaded(xmlHttp.responseXML, jsNode);
		}
	};
	// call in new thread to allow ui to update
	window.setTimeout(function () {
		xmlHttp.send(null);
	}, 10);
}

// Inserts an xml document as a subtree to the provided node
function xmlPartFileLoaded(oXmlDoc, jsParentNode) {
	var bIndent = false;
	var bAnyChildren = false;
	jsParentNode.loaded = true;
	jsParentNode.loading = false;
	// check that the load of the xml file went well
	if( oXmlDoc == null || oXmlDoc.documentElement == null) {		
		jsParentNode.errorText = parseTemplateString(webFXTreeConfig.loadErrorTextTemplate,
							jsParentNode.src);
		//alert( 	jsParentNode.errorText );
	} else {
		// there is one extra level of tree elements
		var root = oXmlDoc.documentElement;

		// loop through all tree children
		var cs = root.childNodes;
		var l = cs.length;
		for (var i = 0; i < l; i++) {
			if (cs[i].tagName == "tree") {
				bAnyChildren = true;
				bIndent = true;
				jsParentNode.add( _xmlTreeToJsTree(cs[i]), true);
			}
		}
	}
}