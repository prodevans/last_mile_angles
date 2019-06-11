$(document).ready(function () {
	$(".brand-logo").owlCarousel({

		items: 4,
		lazyLoad: true,
		pagination: false,
		navigation: true,
		itemsDesktop: [1199, 4],
		itemsDesktopSmall: [979, 4],
		itemsTablet: [769, 3], // 3 items between 600 and 480
		itemsMobile: [479, 1], // 1 item between 479 and 0
		autoPlay: 3000,
		autoHeight: true

	});

	$(".ads-brand").owlCarousel({

		items: 4,
		lazyLoad: true,
		pagination: false,
		navigation: true,
		itemsDesktop: [1199, 4],
		itemsDesktopSmall: [979, 4],
		itemsTablet: [769, 3], // 3 items between 600 and 480
		itemsMobile: [479, 1], // 1 item between 479 and 0
		autoPlay: 3000,
		autoHeight: true

	});

	$(".happy-costumer").owlCarousel({

		items: 1,
		lazyLoad: true,
		pagination: false,
		navigation: true,
		itemsTablet: [769, 1], // 3 items between 600 and 480
		itemsMobile: [479, 1], // 1 item between 479 and 0
		autoHeight: true

	});
});

// form steps

$(document).ready(function () {
	$('.registration-form fieldset:first-child').fadeIn('slow');

	$('.registration-form input[type="text"], .registration-form input[type="number"],  .registration-form textarea, .registration-form input[type="date"], registration-form  select').on('focus', function () {
		$(this).removeClass('input-error');
	});

	// next step
	$('.registration-form .btn-next').on('click', function () {
		var parent_fieldset = $(this).parents('fieldset');
		var next_step = true;

		parent_fieldset.find('input[type="text"],input[type="email"], input[type="number"], textarea, input[type="date"], select').each(function () {
			if ($(this).val() == "") {
				$(this).addClass('input-error');
				next_step = false;
			} else {
				$(this).removeClass('input-error');
			}
		});

		if (next_step) {
			parent_fieldset.fadeOut(400, function () {
				$(this).next().fadeIn();
			});
		}

	});

	// previous step
	$('.registration-form .btn-previous').on('click', function () {
		$(this).parents('fieldset').fadeOut(400, function () {
			$(this).prev().fadeIn();
		});
	});

	// submit
	$('.registration-form').on('submit', function (e) {

		$(this).find('input[type="text"],input[type="email"]').each(function () {
			if ($(this).val() == "") {
				e.preventDefault();
				$(this).addClass('input-error');
			} else {
				$(this).removeClass('input-error');
			}
		});

	});

	$('.registration-form button').click(function () {
		var tab_id = $(this).attr('data-tab');

		$('#progressbar li').removeClass('tab-active');
		$(this).addClass('tab-active');
		$("#" + tab_id).addClass('tab-active');
	})

});
