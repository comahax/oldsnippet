/**
 * 此方法只能在此应用中使用
 *
 * 判断 parent 所代表的选择器里面是否存在 child 所引用的被选中的 checked 对象
 *
 */
var contains = function(parent, child) {
	var result = false;
	$(parent).each(function() {
		//此处只能判断两对象的 value 值是否相等，并且当前遍历到的对象是否被选中
		if ($(this).val() == $(child).val()) {
			result = true;
		}
	});
	return result;
}

$(function() {

/**
 * 给 .rewardtype 的 checkbox 绑定单击事件
 */
	$('.rewardtype').bind('click', function() {
		/*
		//判断 .suit 中是否存在被选中的 checkbox
		if (!contains('.suit', this)) {
			$('.suit').each(function() {
				this.checked = false;
			});
		}
		//判断 .service 中是否存在被选中的 checkbox
		if (!contains('.service', this)) {
			$('.service').each(function() {
				this.checked = false;
			});
		}
		//判断 .data 中是否存在被选中的 checkbox
		if (!contains('.data', this)) {
			$('.data').each(function() {
				this.checked = false;
			});
		}
		//判断 .other 中是否存在被选中的 checkbox
		if (!contains('.other', this)) {
			$('.other').each(function() {
				this.checked = false;
			});
		}
		*/
		//清空文本框的值
		//显示的文字
		$('#rewardtype').val('');
		//提交的值
		$('#realrewardtype').val('');
		
		//给文本框重新赋值
		$('.rewardtype').each(function() {
			if (this.checked) {
				if ($('#realrewardtype').val() == '') {
					$('#realrewardtype').val(this.value);
					$('#rewardtype').val($(this).attr('title'));
				} else {
					$('#realrewardtype').val($('#realrewardtype').val() + ',' + this.value);
					$('#rewardtype').val($('#rewardtype').val() + ',' + $(this).attr('title'));
				}
			}
		});
	});
	/*
	//捕获鼠标来显示或隐藏 div
	$('#rewardtype').hover(function() {
		$('.reward').css('display', 'block');
	}, function() {
		$('.reward').css('display', 'none');
		$('.reward').hover(function() {
			$(this).css('display', 'block');
		}, function() {
			$(this).css('display', 'none');
		});
	});

	$('#rewardopnid').hover(function() {
		$('#opn_query').css('display', 'block');
	}, function() {
		$('#opn_query').css('display', 'none');
		$('#opn_query').hover(function() {
			$(this).css('display', 'block');
		}, function() {
			$(this).css('display', 'none');
		});
	});
	*/
});