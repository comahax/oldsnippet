/**
 * �˷���ֻ���ڴ�Ӧ����ʹ��
 *
 * �ж� parent �������ѡ���������Ƿ���� child �����õı�ѡ�е� checked ����
 *
 */
var contains = function(parent, child) {
	var result = false;
	$(parent).each(function() {
		//�˴�ֻ���ж�������� value ֵ�Ƿ���ȣ����ҵ�ǰ�������Ķ����Ƿ�ѡ��
		if ($(this).val() == $(child).val()) {
			result = true;
		}
	});
	return result;
}

$(function() {

/**
 * �� .rewardtype �� checkbox �󶨵����¼�
 */
	$('.rewardtype').bind('click', function() {
		/*
		//�ж� .suit ���Ƿ���ڱ�ѡ�е� checkbox
		if (!contains('.suit', this)) {
			$('.suit').each(function() {
				this.checked = false;
			});
		}
		//�ж� .service ���Ƿ���ڱ�ѡ�е� checkbox
		if (!contains('.service', this)) {
			$('.service').each(function() {
				this.checked = false;
			});
		}
		//�ж� .data ���Ƿ���ڱ�ѡ�е� checkbox
		if (!contains('.data', this)) {
			$('.data').each(function() {
				this.checked = false;
			});
		}
		//�ж� .other ���Ƿ���ڱ�ѡ�е� checkbox
		if (!contains('.other', this)) {
			$('.other').each(function() {
				this.checked = false;
			});
		}
		*/
		//����ı����ֵ
		//��ʾ������
		$('#rewardtype').val('');
		//�ύ��ֵ
		$('#realrewardtype').val('');
		
		//���ı������¸�ֵ
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
	//�����������ʾ������ div
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