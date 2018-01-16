//ʹ����float���ɵ��Ű治���������С�ı仯���仯
window.onload = function()
{
	imgLocation("container","box");
	var imgData = {"data":[{"src":"2.jpg"},{"src":"3.jpg"},{"src":"4.jpg"},{"src":"5.jpg"},{"src":"6.jpg"},{"src":"7.jpg"},{"src":"8.jpg"}]};//ģ��Ҫ���ص�����
	window.onscroll = function(){//����������
		if (checkFlag())//�������true�ͼ���
		{
			var cparent = document.getElementById("container");
			for (var i=0; i<imgData.data.length; i++)
			{
				var ccontent = document.createElement("div");//������Ԫ��  ��Ҫ��������Ԫ�أ������������������
				ccontent.className = "box";//����Ҫ��ǰ���Ӧ
				cparent.appendChild(ccontent);//����Ԫ����ӵ�container��
				var boximg = document.createElement("div");
				boximg.className = "box_img";
				ccontent.appendChild(boximg);
				var img = document.createElement("img");
				img.src = "images/"+imgData.data[i].src;
				boximg.appendChild(img);
			}
			
			imgLocation("container","box");//ʹ���¼��ص�ͼƬҲ��ԭ����ͼƬִ����ͬ�Ĳ���
		}
	}
}

function imgLocation(parent,content)
{
	//��parent�µ����е�contentȫ��ȡ��
	var cparent = document.getElementById(parent);
	var ccontent = getChildElement(cparent,content);//���ô洢box�ķ���
	var imgWidth = ccontent[0].offsetWidth;//�õ�ͼƬ�Ŀ��
	var cols = Math.floor(document.documentElement.clientWidth / imgWidth);//��Ļ���/ͼƬ���=ͼƬ����,Ҫת��������-
	cparent.style.cssText = "width:"+imgWidth*cols+"px;margin:0 auto";//����html��style����   ʹ��container�Ŀ�ȹ̶�Ϊ����õ��Ŀ�ȣ���ʹ�����
	
	var BoxHeightArr = [];
	for (var i=0; i<ccontent.length; i++)
	{
		if (i < cols)//ֻ����һ�е�
		{
			BoxHeightArr[i] = ccontent[i].offsetHeight;//�õ�ÿ��ͼƬ�ĸ߶Ȳ�����������
		}
		else
		{
			var minHeight = Math.min.apply(null,BoxHeightArr);//�õ�ͼƬ�и߶���С��
			var minIndex = getMinIndex(BoxHeightArr,minHeight);//�õ��߶���СͼƬ��λ��
			ccontent[i].style.position = "absolute";//�ڷ�λ�����óɾ��Ե�
			ccontent[i].style.top = minHeight+"px";//����ͼƬ�ඥ���ľ���Ӧ��������߶���С������ͼƬ�ĸ߶�
			ccontent[i].style.left = ccontent[minIndex].offsetLeft+"px";//����ͼƬ������ߵľ���Ϊ ����߶���С��ͼƬ������ߵľ���
			BoxHeightArr[minIndex] = BoxHeightArr[minIndex]+ccontent[i].offsetHeight;//�����Ϻ����λ�õĸ߶Ⱦͱ��ԭ��ͼƬ�ĸ߶ȼ����¼�ͼƬ�ĸ߶�
		}
	}
}

function getChildElement(parent,content)//��box�洢��һ��������
{
	var contentArr = [];
	var allcontent = parent.getElementsByTagName("*");//������е�����
	for (var i=0; i<allcontent.length; i++)
	{
		if (allcontent[i].className == content)//�ж��Ƿ���box
		{
			contentArr.push(allcontent[i]);//����������
		}
	}
	return contentArr;//��������
}

function getMinIndex(BoxHeightArr,minHeight)//�õ��߶���СͼƬ��λ��
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
	var lastContentHeight = ccontent[ccontent.length-1].offsetTop;//�õ����һ��ͼƬ�ඥ���ľ���
	var scrollTop = document.documentElement.scrollTop||document.body.scrollTop;//�õ�������ʱ�������صĲ���   ������ļ�������
	var pageHeight = document.documentElement.clientHeight||document.body.clientHeight;//�õ�ҳ����ʾ�ĸ߶�  �������������
	console.log(lastContentHeight+","+scrollTop+","+pageHeight);//ʹ���ڿ���̨����ʾ����
	if (lastContentHeight < scrollTop+pageHeight)//���lastContentHeight < scrollTop+pageHeightʱ  ����Ҫ������
	{
		return true;
	}
}