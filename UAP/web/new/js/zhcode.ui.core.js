//����UI���ṹ
zhcode.ui = {
	//factory method for creating component
	createComponent : function(cn, config, domRef){
		var	lastSplitIdx = cn.lastIndexOf("."),
			type = cn.substring(
					lastSplitIdx > 0 ? lastSplitIdx + 1 : lastSplitIdx,
					cn.length),
			ns = cn.substring(0, lastSplitIdx);

		if(lastSplitIdx > 0){
			var package = zhcode.util.parseNamespace(ns);
			if(package!=null&&package[type]!=undefined){
				return package[type](config, domRef);
			}
			else{
				alert("ERROR: Can not find " + cn + " namespace.\n\nDomElement: " + domRef.id );
			}
		}
		else{
			return this[type](config, domRef);
		}
	},
	
	Component : function(){
		var _initCompleted = false,
				_srcElement = null,
				context = null,
				_baseconfig =
				{
					id: config.id,
					resizable: config.resizable ? config.resizable : false,
					cssClass: config.cssClass ? config.cssClass : null
				},
				_initFailure = function(msg){
					alert(msg);
				};
				_buildContext = function(){};
				
			return {
				
			//����HTML��DOM�ṹ
			//����ֵ�� ��������ĸ�Ԫ�ء�
			//overwrite
			parseHTML : function(){
				//return zhcode.get(_baseconfig.id);
			},
			
			//����config�ṹ
			//�ɹ�����true�����ɹ�����false
			analyzeConfig : function(){
				
			},
			//event - ��������Ⱦ
			onRenderCompleted : function(e, c){},
			
			//event - ��������ʼ��
			onInitCompleted : function(e, c){},
			
			//�������
			//overwrite
			buildComponent : function(){},
			
			//��ʼ�����
			init : function(){},
			
			//��Ⱦ���
			//overwrite
			render : function(){
				try{
					
					if(!this.analyzeConfig()){
						_initFailure("component error: failure to analyze config set.");
					}
					
					_srcElement = this.parseHTML();                //�������HTML�ṹ
					context = _buildContext();                  //����������
					this.init(context);                         //��ʼ�����
					_srcElement = this.buildComponent(_srcElement);   //ΪdomԪ�ذ�װ�������
					this.onInitCompleted(_srcElement.event, context);
				}
				catch(e){
					_srcElement = null;
					context = null;
					this.destory();
					_initFailure("component error: failure to construt.");
					return;
				}
			},
			
			//�������
			destory : function(){}
			
		}
	}
}

//��дDOM���getElement����
var baseMethod = zhcode.dom.getElement;
zhcode.dom.getElement = function(id){
	var el = baseMethod(id);
	if(zhcode.ui !== undefined){
		el.component = function(type){
			var config = {};
			if(arguments.length == 1 || arguments[1] == undefined){
				config["domId"] = id;
			}
			else if(arguments.length == 2 || arguments[1] != undefined){
				//��ʼ����������
				config = arguments[1];
				config["domId"] = id;
			}
			return zhcode.ui.createComponent(type, config, this);
		}
	}
	return el;
};

window.$ = zhcode.dom.getElement;