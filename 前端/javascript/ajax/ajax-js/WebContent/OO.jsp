<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//js中类的定义，需要用function模拟
	/* function Teacher() {
		
	} */
	//建议用下面的形式来定义一个js中的类,类名首字母大写
	var Teacher = function() {
		
	}
	
	//定义一个Book类，相当于构造函数
	//在使用new创建Book类对象时，这个function中的代码会被执行
	var Book = function(name) {
		//定义公有属性  在构造方法中定义  不能在原型对象中定义，否则创建多个对象时，属性可能会覆盖
		this.name = name;
		/* //定义公有方法
		this.getName = function() {
			return this.name;
		}; */
		if (typeof Book._init == undefined) {//保证只执行一次
			//定义公有方法   在原型对象中定义  更节省内存空间
			Book.prototype.getName = function() {
				return this.name;
			};
		}
		Book._init = true;
	};
	
	function test() {
		var teacher = new Teacher();
		alert(teacher instanceof Teacher);//判断该类是否创建了该对象，若返回true，则是
		var book1 = new Book("AJAX");
		var book2 = new Book("JAVA");
		
		/* //function上面都有一个原型对象
		var proto = Book.prototype;//原型对象
		proto.str = "String";
		proto.hello = function() {
			alert("hello");
		}; 
		//原型对象定义了属性后，拥有这个原型对象的function，它所对应的类创建出的对象也都拥有了这些属性*/
	}
</script>
</head>
<body>
	<input type="button" value="面向对象演示" onclick="test()"/>
</body>
</html>