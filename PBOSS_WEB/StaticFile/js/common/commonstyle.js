jQuery(function() {
	$('.text_01').hover(function() {
		this.className='text_01_02';
	}, function() {
		this.className='text_01';
	});
	$('.textarea_01').hover(function() {
		this.className='textarea_01_02';
	}, function() {
		this.className='textarea_01';
	});
	$('.btn_blue_75').hover(function() {
		this.className='btn_blue_75_02';
	}, function() {
		this.className='btn_blue_75';
	}
	);
	$('.btn_blue').hover(function() {
		this.className='btn_blue_02';
	}, function() {
		this.className='btn_blue';
	}
	);
});