$(document).ready(function(){
	
	MM_preloadImages('../img/ticon1_1.png','../img/ticon2_1.png','../img/ticon3_1.png');
	var pic="<img>";
	
	for(i=0; i<$(".navbar-right>.tgicon").length; i++){
		resrc[i]=$(".navbar-right>.tgicon:eq("+i+")>a>img").attr("src");
		
	}
	
	$(".navbar-right>.tgicon").mouseenter(function(){
		if(!$(this).hasClass("open")){
		$(this).children("a").children("img").attr("src",a[$(this).index()]);}
		$(this).find("ul").slideDown(300);
	});
	
	$(".navbar-right>.tgicon").mouseleave(function(){
		if(!$(this).hasClass("open")){
			$(this).children("a").children("img").attr("src",resrc[$(this).index()]);
		}
		$(this).find("ul").hide();
	});

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	setBodySmall();
	
	$('.hide-menu').click(function(event){
        event.preventDefault();
        if ($(window).width() < 1025) {
            $("body").toggleClass("show-sidebar");
        } else {
            $("body").toggleClass("hide-sidebar");
        }
    });
	
	
	
 $(window).bind("load", function () {
    // Remove splash screen after load
     $('.splash').css('display', 'none');
 });
});
$(window).bind("resize click", function () {

    // Add special class to minimalize page elements when screen is less than 768px
    setBodySmall();

   
});
function setBodySmall() {
    if ($(this).width() < 1025) {
        $('body').addClass('page-small');
    } else {
        $('body').removeClass('page-small');
        $('body').removeClass('show-sidebar');
    }
}
  var a;
  var resrc=new Array();
function MM_preloadImages() { //v3.0

  var d=document; 
  if(d.images){ 
     if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length;
	a=MM_preloadImages.arguments; 
	for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ 
	   d.MM_p[j]=new Image; 
	   d.MM_p[j++].src=a[i];
	   }
	   }
}