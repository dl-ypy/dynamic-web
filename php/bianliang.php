<?php
	$a=$b=$c=$d = "value";    //php是弱类型的，类型会根据变量的值确定
	if (isset($a))
	{
		echo "这是判断变量是否存在的函数，变量存在。";
	}
	else
	{
		echo "变量不存在！";
	}
	echo "<br>";
	unset($b);     //释放变量内存
	
	if (isset($b))
	{
		echo "这是判断变量是否存在的函数，变量存在。";
	}
	else
	{
		echo "变量不存在！";
	}
	echo "<hr>";
	
	$one = "zero";
	$two = "one";
	$three = "two";
	
	echo $three;     //可变变量
	echo "<br>";
	echo $$three;
	echo "<br>";
	echo $$$three;
	echo "<hr>";
	
	$one = "10";
	$two = &$one;     //引用赋值，相当于成为同一个变量
	$one = "1000000";
	echo $two-"<br>";
	echo "<hr>";
	
	//变量的类型
	$var = 10;
	var_dump($var);    //查看变量的类型
	echo "<br>";
	$var = 35.5;
	var_dump($var); 
	echo "<br>";
	$var = "aaa";
	var_dump($var); 
	echo "<br>";
	$var = array(1,2,3);
	var_dump($var); 
	echo "<br>";
	$var = true;
	var_dump($var); 
	echo "<br>";
	$var = fopen("bianliang.php", "r");
	var_dump($var); 
	echo "<br>";
	$var = null;
	var_dump($var); 
	echo "<br>";
	
	//一些特殊的变量声明
	$str = 'gsgsggsgs';   //这里单引号的也是字符串，php中最好使用单引号
	$str=<<<a             //特殊的声明字符串的方式
	vsdgerfsdbsg
	vrwgrege
a;
	echo $str;
	
	