(function(){//�൱�ڷ�װ
	var n = "ypy";//ֻ���ڱ�����ʹ��
	function People(name)//�൱��һ����
	{
		this._name = name;
	}
	People.prototype.say = function()//�൱�����һ������
	{
		alert("peo-hello:"+this._name+" and "+n);
	}
	window.People = People;//����繫��һ���ӿ�
}());

(function()
{
	function Student(name)
	{
		this._name = name;
	}
	Student.prototype = new People();//�൱��Student�̳���People
	var superSsay = Student.prototype.say;
	Student.prototype.say = function()//������дsay����
	{
		superSsay.call(this);//�����˸���ķ���
		alert("stu-hello:"+this._name);
	}
	window.Student = Student;
}());

var s = new Student("syf");
s.say();