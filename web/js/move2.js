function getStyle(obj, attr)
{
    if(obj.currentStyle)
    {
        return obj.currentStyle[attr];
    }
    else
    {
        return getComputedStyle(obj, false)[attr];
    }
}
var timer=null;
function startMove(obj, json, fn)
{
    clearInterval(obj.timer);
    obj.timer=setInterval(function (){
        var Stop=true;
        for(var attr in json) {
            var iCur = 0;

            if (attr == 'opacity') {
                iCur = parseInt(parseFloat(getStyle(obj, attr) * 100));
            } else {
                iCur = parseInt(getStyle(obj, attr));
            }
            var iSpeed = (json[attr] - iCur) / 8;
            iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);

            //检测停止
            if(iCur!=json[attr]){
                Stop=false;
            }

            if (attr == 'opacity') {
                obj.style.filter = 'alpha(opacity:' + (iSpeed + iCur) + '';
                obj.style.opacity = (iSpeed + iCur) / 100;

            }

            else {
                obj.style[attr] = iCur + iSpeed + 'px';

            }
            if(Stop){
                clearInterval(obj.timer);
                if (fn) {
                    fn();
                }
            }

        }
    }, 30);
}