(function(){
    myCarousel = function (){
        var carousel = {
            containerCarousel: document.querySelector('.container .carousel'),
            listCarousel: document.querySelectorAll('.container .carousel li'),
            rightIndex:3,//默认right所在位置,从1开始编号
            timer:null //定时器对象
        };
        function move() {
            var left = document.querySelector('.container .left');
            var center = document.querySelector('.container .center');
            var right = document.querySelector('.container .right');
            var nextRight=document.querySelector(".container li:nth-child("+(carousel.rightIndex+1)+")");
            //重新更新class值
            left.className='unset';
            center.className="left";
            right.className='center';
            nextRight.className='right';
            carousel.rightIndex++;
            if(carousel.rightIndex===carousel.listCarousel.length){
                //不设置0，则第一张图会缺失。
                carousel.rightIndex=0;//必须设置为0，nth-child(carousel.rightIndex+1)
            }
        }
        function buildCarousel() {
            //最少2张图进行轮播
            if (carousel.listCarousel.length > 2) {
                for (var i = 3;i<carousel.listCarousel.length;i++) {
                    carousel.listCarousel[0].className = 'left';
                    carousel.listCarousel[1].className = 'center';
                    carousel.listCarousel[2].className = 'right';
                    carousel.listCarousel[i].className='unset';
                }
            }
        }
        /*function cancel(){
            carousel.listCarousel.forEach(function(o,i){
                o.onmouseover=function(){
                    //注意，不能直接写timer,否则无法清除定时器
                    clearInterval(carousel.timer);
                    var center = document.querySelector('.container .center');

                }
                o.onmouseout=function(){
                    carousel.timer=setInterval(move, 7000);
                }
            });
        }*/
        function start() {
            buildCarousel();
            //cancel();
            carousel.timer=setInterval(move, 10000);
        }
        start();
    };
    myCarousel();
})();