
	//-->
	//png 透明设置

	function correctPNG()
		{
		  for(var i=0; i<document.images.length; i++)
		  {
		   var img = document.images[i]
		   var imgName = img.src.toUpperCase()
		   if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
		   {
		   var imgID = (img.id) ? "id='" + img.id + "' " : ""
		   var imgClass = (img.className) ? "class='" + img.className + "' " : ""
		   var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
		   var imgStyle = "display:inline-block;" + img.style.cssText
		   if (img.align == "left") imgStyle = "float:left;" + imgStyle
		   if (img.align == "right") imgStyle = "float:right;" + imgStyle
		   if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle 
		   var strNewHTML = "<span " + imgID + imgClass + imgTitle
		   + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
		   + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
		   + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>"
		   img.outerHTML = strNewHTML
		   i = i-1
		   };
		  };
		};

		if(navigator.userAgent.indexOf("MSIE")>-1)
		{
		 window.attachEvent("onload", correctPNG);
		};

	//-->
	//图片滚动代码

	i=18;
	function ProImgScroll(a){
	if(i)	{
		ProImg.scrollLeft+=20*a;
		i--;
		setTimeout(function(){ProImgScroll(a)},5);
	}
	else {
		i=18;
		if (ProImg.scrollLeft==0)prev.src="images/slide_prev_disable.gif"
		else prev.src="images/slide_prev.gif"
		if(ProImg.scrollLeft+ProImg.offsetWidth>=ProImg.getElementsByTagName("table")[0].offsetWidth)next.src="images/slide_next_disable.gif"
		else next.src="images/slide_next.gif"
	}
}




function boxmove(d1,d2,d3,e,obj){ 

    var speed=30; 

    var demo=document.getElementById(d1);  

    var demo1=document.getElementById(d2);  

    var demo2=document.getElementById(d3); 

    demo2.innerHTML=demo1.innerHTML; 

    function boxTop(){ 

            if(demo2.offsetHeight-demo.scrollTop<=0){demo.scrollTop-=demo1.offsetHeight} 

            else{demo.scrollTop++} 

        } 

    function boxRight(){ 

            if(demo.scrollLeft<=0){demo.scrollLeft+=demo2.offsetWidth} 

            else{demo.scrollLeft--} 

        } 

    function boxBottom(){  

            if(demo1.offsetHeight-demo.scrollTop>=0){demo.scrollTop+=demo2.offsetHeight} 

            else{demo.scrollTop--} 

        } 

    function boxLeft(){ 

            if(demo2.offsetWidth-demo.scrollLeft<=0){demo.scrollLeft-=demo1.offsetWidth} 

            else{demo.scrollLeft++} 

        } 

    if(e==1){ 

            var MoveTop=setInterval(boxTop,speed); 

            demo.onmouseover=function(){clearInterval(MoveTop);} 

            demo.onmouseout=function(){MoveTop=setInterval(boxTop,speed)} 

        } 

    if(e==2){ 

            var MoveRight=setInterval(boxRight,speed); 

            demo.onmouseover=function(){clearInterval(MoveRight)} 

            demo.onmouseout=function(){MoveRight=setInterval(boxRight,speed)} 

        } 

    if(e==3){ 

            var MoveBottom=setInterval(boxBottom,speed); 

            demo.onmouseover=function(){clearInterval(MoveBottom);} 

            demo.onmouseout=function(){MoveBottom=setInterval(boxBottom,speed)} 

        } 

    if(e==4){ 

            var MoveLeft=setInterval(boxLeft,speed) 

            demo.onmouseover=function(){clearInterval(MoveLeft)} 

            demo.onmouseout=function(){MoveLeft=setInterval(boxLeft,speed)} 

        } 

    if(e=="top"){ 

            MoveTop=setInterval(boxTop,speed) 

            obj.onmouseout=function(){clearInterval(MoveTop);} 

        } 

    if(e=="right"){ 

            MoveRight=setInterval(boxRight,speed) 

            obj.onmouseout=function(){clearInterval(MoveRight);} 

        } 

    if(e=="bottom"){ 

            MoveBottom=setInterval(boxBottom,speed) 

            obj.onmouseout=function(){clearInterval(MoveBottom);} 

        } 

    if(e=="left"){ 

            MoveLeft=setInterval(boxLeft,speed) 

            obj.onmouseout=function(){clearInterval(MoveLeft);} 

        } 

    }


//文字滚动

function ScrollText(content,btnPrevious,btnNext,autoStart)
{
    this.Delay = 10;
    this.LineHeight = 15;
	this.Amount = 1;//注意:LineHeight一定要能整除Amount.
	this.Direction = "up";
    this.Timeout = 500;
    this.ScrollContent = this.$(content);
    this.ScrollContent.innerHTML += this.ScrollContent.innerHTML;
    //this.ScrollContent.scrollTop = 0;
    if(btnNext)
    {
        this.NextButton = this.$(btnNext);
        this.NextButton.onclick = this.GetFunction(this,"Next");
        this.NextButton.onmouseover = this.GetFunction(this,"Stop");
        this.NextButton.onmouseout = this.GetFunction(this,"Start");
    }
    if(btnPrevious)
    {
        this.PreviousButton = this.$(btnPrevious);
        this.PreviousButton.onclick = this.GetFunction(this,"Previous");
        this.PreviousButton.onmouseover = this.GetFunction(this,"Stop");
        this.PreviousButton.onmouseout = this.GetFunction(this,"Start");
    }
    this.ScrollContent.onmouseover = this.GetFunction(this,"Stop");
    this.ScrollContent.onmouseout = this.GetFunction(this,"Start");
    if(autoStart)
    {
        this.Start();
    }
}

ScrollText.prototype.$ = function(element)
{
    return document.getElementById(element);
}

ScrollText.prototype.Previous = function()
{
    clearTimeout(this.AutoScrollTimer);
    clearTimeout(this.ScrollTimer);
    this.Scroll("up");
}

ScrollText.prototype.Next = function()
{
    clearTimeout(this.AutoScrollTimer);
    clearTimeout(this.ScrollTimer);
    this.Scroll("down");
}

ScrollText.prototype.Start = function()
{
    clearTimeout(this.AutoScrollTimer);
    this.AutoScrollTimer = setTimeout(this.GetFunction(this,"AutoScroll"), this.Timeout);
}

ScrollText.prototype.Stop = function()
{
    clearTimeout(this.ScrollTimer);
    clearTimeout(this.AutoScrollTimer);
}

ScrollText.prototype.AutoScroll = function()
{
    if(this.Direction == "up")
    {
        if(parseInt(this.ScrollContent.scrollTop) >= parseInt(this.ScrollContent.scrollHeight) / 2)
        {
            this.ScrollContent.scrollTop = 0;
        }
        this.ScrollContent.scrollTop += this.Amount;
    }
    else
    {
        if(parseInt(this.ScrollContent.scrollTop) <= 0)
        {
            this.ScrollContent.scrollTop = parseInt(this.ScrollContent.scrollHeight) / 2;
        }
        this.ScrollContent.scrollTop -= this.Amount;
    }
    if(parseInt(this.ScrollContent.scrollTop) % this.LineHeight != 0)
    {
        this.ScrollTimer = setTimeout(this.GetFunction(this,"AutoScroll"), this.Delay);
    }
    else
    {
        this.AutoScrollTimer = setTimeout(this.GetFunction(this,"AutoScroll"), this.Timeout);
    }
}

ScrollText.prototype.Scroll = function(direction)
{
    if(direction=="up")
    {
        if(this.ScrollContent.scrollTop == 0)
        {
            this.ScrollContent.scrollTop = parseInt(this.ScrollContent.scrollHeight) / 2;
        }
        this.ScrollContent.scrollTop -= this.Amount;
    }
    else
    {
        this.ScrollContent.scrollTop += this.Amount;
    }
    if(parseInt(this.ScrollContent.scrollTop) >= parseInt(this.ScrollContent.scrollHeight) / 2)
        {
            this.ScrollContent.scrollTop = 0;
        }
    if(parseInt(this.ScrollContent.scrollTop) % this.LineHeight != 0)
    {
        this.ScrollTimer = setTimeout(this.GetFunction(this,"Scroll",direction), this.Delay);
    }
}

ScrollText.prototype.GetFunction = function(variable,method,param)
{
    return function()
    {
        variable[method](param);
    }
}