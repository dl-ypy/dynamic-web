(function(){//相当于封装
	var n = "ypy";//只能在本类中使用
	function People(name)//相当于一个类
	{
		this._name = name;
	}
	People.prototype.say = function()//相当于类的一个方法
	{
		alert("peo-hello:"+this._name+" and "+n);
	}
	window.People = People;//给外界公开一个接口
}());

(function()
{
	function Student(name)
	{
		this._name = name;
	}
	Student.prototype = new People();//相当于Student继承了People
	var superSsay = Student.prototype.say;
	Student.prototype.say = function()//子类重写say方法
	{
		superSsay.call(this);//调用了父类的方法
		alert("stu-hello:"+this._name);
	}
	window.Student = Student;
}());

var s = new Student("syf");
s.say();