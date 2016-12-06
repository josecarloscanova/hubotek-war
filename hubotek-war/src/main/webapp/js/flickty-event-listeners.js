$(document).ready(function () {
	var $carousel = $('.carousel').flickity();
	var flkty = $carousel.data('flickity');
	$carousel.on( 'select.flickity', function() {
	  console.log( 'Flickity select ' + flkty.selectedIndex )
	});
});