var weescroller = function(idUl, options) {
    var self = this;  	
  	this.pausetimer = null;
  	this.steptimer = null;
    this.oUl = $(idUl);
    this.oOUl = this.oUl.clone();
    this.CTL = 0;
    //����Ĭ������
   	this.options = {	//Ĭ��ֵ
   		row: 5,			//��ʾ����
  		time: 15,		//�ٶ�(Խ��Խ��)
      	pause: 2000		//ͣ��ʱ��      	
   	};
   	this.options = $.extend(self.options, options || {});   	
    //��һ��
    this.Next = function() {
    	if (!self.canscroll) return false;
    	clearTimeout(self.pausetimer);
    	clearInterval(self.steptimer);
    	var height = self.oUl.find("li:first").height();
    	self.steptimer = setInterval(function(){
    		if (self.CTL >= height) {
    			self.CTL = 0;
    			clearInterval(self.steptimer);
    			self.oUl.find("li:first").appendTo(self.oUl);
    			self.oUl.get(0).scrollTop = 0;
    			self.pausetimer = setTimeout(self.Next, self.options.pause);
    		} else {
    			self.CTL++;
    			self.oUl.get(0).scrollTop++;
    		}
    	}, self.options.time);
    }
    //��һ��
    this.GoPrev = function() {
    	if (!self.canscroll) return false;
    	if (self.CTL > 0) {
    		self.CTL = 0;
    		self.oUl.get(0).scrollTop = 0;
    	} else {
    		self.oUl.find("li:last").prependTo(self.oUl);
    	}
    }
    //������һ��
    this.GoFirst = function() {
    	if (!self.canscroll) return false;
    	while(!self.oUl.find("li:first").hasClass("first")) {
    		this.GoPrev();
    	}
    }
  	//ֹͣ
  	this.Stop = function() {
    	clearTimeout(self.pausetimer);
    	clearInterval(self.steptimer);
  	}
    //����һ��LI
    this.Append = function(li, limit, type) {
    	limit = limit - 1;
    	self.oOUl.find(".first").removeClass("first").before(li);
    	if (type == 'new') {
    		self.oOUl.find(".speaker_new").remove();
    		self.oOUl.find("li.mine:gt("+(limit)+")").remove();
    	} else {
    		self.oOUl.find(".speaker_user").remove();
    		self.oOUl.find(".first").nextAll("li:gt("+(limit-1)+")").find(".speaker_new").remove();
    	}
    	self.oOUl.find("li.nohas").remove();
    	self.Stop();
    	self.Start();
    }
    this.Start = function() {
	    //�����Ƿ񹻹���
	    self.canscroll = (self.oOUl.find('li').length > self.options.row);    
	  	if (self.canscroll) {
	   		self.oUl.html(self.oOUl.html()+self.oOUl.html());
	   	} else {
	   		self.oUl.html(self.oOUl.html());
	   	}
	   	self.pausetimer = setTimeout(self.Next, self.options.pause);
   	}
   	this.oUl.mouseover(function(){self.Stop();});
   	this.oUl.mouseout(function(){self.Next();});
   	this.Start();   	
}