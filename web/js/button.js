$('#register').click(function () {
    $('.content-login').css('transform','translate(-100%)');
    $('.content-login').css('opacity','0');
    $('.content-register').css('transform','translate(0)');
    $('.content-register').css('opacity','1');
    setTimeout(function () {
        $('.content-login').css('display','none');
    },800);
    return false;
});

$('#login').hover(function () {
    $('.content-login').css('display','block');
});

$('#login').click(function () {
    $('.content-register').css('transform','translate(300%)');
    $('.content-register').css('opacity','0');
    $('.content-login').css('opacity','1');
    $('.content-login').css('transform','translate(0)');
    return false;
})