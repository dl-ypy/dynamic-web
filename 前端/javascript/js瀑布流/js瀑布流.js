//使得用float做成的排版不随浏览器大小的变化而变化
window.onload = function()
{
	imgLocation("container","box");
	var imgData = {"data":[{"src":"2.jpg"},{"src":"3.jpg"},{"src":"4.jpg"},{"src":"5.jpg"},{"src":"6.jpg"},{"src":"7.jpg"},{"src":"8.jpg"}]};//模拟要加载的数据
	window.onscroll = function(){//监听滚动条
		if (checkFlag())//如果返回true就加载
		{
			var cparent = document.getElementById("container");
			for (var i=0; i<imgData.data.length; i++)
			{
				var ccontent = document.createElement("div");//创建新元素  需要创建三个元素，下面两个与这个相似
				ccontent.className = "box";//名字要与前面对应
				cparent.appendChild(ccontent);//将新元素添加到container中
				var boximg = document.createElement("div");
				boximg.className = "box_img";
				ccontent.appendChild(boximg);
				var img = document.createElement("img");
				img.src = "images/"+imgData.data[i].src;
				boximg.appendChild(img);
			}
			
			imgLocation("container","box");//使得新加载的图片也与原来的图片执行相同的操作
		}
	}
}

function imgLocation(parent,content)
{
	//将parent下的所有的content全部取出
	var cparent = document.getElementById(parent);
	var ccontent = getChildElement(cparent,content);//调用存储box的方法
	var imgWidth = ccontent[0].offsetWidth;//得到图片的宽度
	var cols = Math.floor(document.documentElement.clientWidth / imgWidth);//屏幕宽度/图片宽度=图片个数,要转换成整数-
	cparent.style.cssText = "width:"+imgWidth*cols+"px;margin:0 auto";//设置html的style属性   使得container的宽度固定为计算得到的宽度，并使其居中
	
	var BoxHeightArr = [];
	for (var i=0; i<ccontent.length; i++)
	{
		if (i < cols)//只看第一行的
		{
			BoxHeightArr[i] = ccontent[i].offsetHeight;//得到每张图片的高度并放在数组中
		}
		else
		{
			var minHeight = Math.min.apply(null,BoxHeightArr);//得到图片中高度最小的
			var minIndex = getMinIndex(BoxHeightArr,minHeight);//得到高度最小图片的位置
			ccontent[i].style.position = "absolute";//摆放位置设置成绝对的
			ccontent[i].style.top = minHeight+"px";//这张图片距顶部的距离应该是上面高度最小的那张图片的高度
			ccontent[i].style.left = ccontent[minIndex].offsetLeft+"px";//这张图片距离左边的距离为 上面高度最小的图片距离左边的距离
			BoxHeightArr[minIndex] = BoxHeightArr[minIndex]+ccontent[i].offsetHeight;//放置上后，这个位置的高度就变成原来图片的高度加上新加图片的高度
		}
	}
}

function getChildElement(parent,content)//把box存储到一个数组中
{
	var contentArr = [];
	var allcontent = parent.getElementsByTagName("*");//获得所有的内容
	for (var i=0; i<allcontent.length; i++)
	{
		if (allcontent[i].className == content)//判断是否是box
		{
			contentArr.push(allcontent[i]);//放入数组中
		}
	}
	return contentArr;//返回数组
}

function getMinIndex(BoxHeightArr,minHeight)//得到高度最小图片的位置
{
	for (var i in BoxHeightArr)
	{
		if (BoxHeightArr[i] == minHeight)
		{
			return i;
		}
	}
}

function checkFlag()
{
	var cparent = document.getElementById("container");
	var ccontent = getChildElement(cparent,"box");
	var lastContentHeight = ccontent[ccontent.length-1].offsetTop;//得到最后一张图片距顶部的距离
	var scrollTop = document.documentElement.scrollTop||document.body.scrollTop;//得到滚动的时候所隐藏的部分   浏览器的兼容问题
	var pageHeight = document.documentElement.clientHeight||document.body.clientHeight;//得到页面显示的高度  浏览器兼容问题
	console.log(lastContentHeight+","+scrollTop+","+pageHeight);//使其在控制台能显示出来
	if (lastContentHeight < scrollTop+pageHeight)//如果lastContentHeight < scrollTop+pageHeight时  就需要加载了
	{
		return true;
	}
}