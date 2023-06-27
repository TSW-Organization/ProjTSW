// AVVIO DEL CAROSELLO CON JQUERY
$(document).ready(function(){
    $('.owl-carousel').owlCarousel({
        loop:true,
        margin:0,
        nav: true,
        dots:false,
        center: false,
        itemElement: "div",
        stageElement: "h2",
        responsive:{
            0:{
                items:1
            },
            600:{
                items:3
            },
            1000:{
                    items:5
            }
        }
    })
});