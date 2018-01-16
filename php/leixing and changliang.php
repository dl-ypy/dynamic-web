<?php
/*时间：2016年8月1日10:29:17 
	数据类型之间相互转换
 * 	一种是强制转换：
 * 		setType(变量， "类型");  //类型int, integer, float, double,real, bool, boolena, string, array, object
 *		这个函数将原变量的类型改变，var_dump();
 */
	$a = "100abc";
	setType($a,"int");//字符型转换为整型
	var_dump($a); 
	echo "<br>";
/*		在赋值前使用(类型)的形式, 不会改变原变量的类型
 *
 */		
  $b=(string)$a;
  var_dump($b);
  echo "<br>";
  var_dump($a);    //原来的变量$a没变
  echo "<br>";
/*		
 *		$变量=intval(变量或值);
 *		$变量=floatval(变量或值);
 *		$变量=stringval(变量或值);
 */
  $c = intval("120fwewe442");
  var_dump($c);
  echo "<br>";
/*		注意： 整型在内存中占4个字节，  2.147e9
 *			浮点型在内存中点8个字节
 *
 * 
 * 	一种自动转换 ： 最常用的方式，因为这种我们开发时不用去管理类型，变量会根据运行环境自动转换 
 */
  $a1 = 100;
  $a2 = "200aaa";
  $a3 = true;
  $a4 = 13.255;
  $sum = $a1+$a2;  //结果是整型的300
  var_dump($sum);
  echo "<br>";
  $sum = $a1 + $a3;  //结果是整型的101，bool型的true转换为整型是1
  var_dump($sum);
  echo "<br>"; 
  $sum = $a1+$a4;  //结果是浮点型的113.225
  var_dump($sum);
  echo "<br>"; 
  $sum = $a3+$a2;  //结果是整型的201
  var_dump($sum);
  echo "<br>";
/*
 * 与变量和类型有关的一些常用函数
 *    isset(); 判断变量存在不存在，值如果是null，也表示不存在
 *    empty();  //判断一个变量是否为空， “”  null
 *    unset();  删除变量
 *
 *    setType();  
 *
 *    getType();  //var_dump();
 */
	echo getType($a);  //只得到类型
	echo "<br>"; 
/*    变量类型测试函数
 *    is_bool();
 *    is_int() is_integer() is_long()
 *    is_string();
 *    is_float(), is_double() is_real()
 *    is_array()
 *    is_object()
 *    is_resource()
 *    is_null();
 *
 *    is_scalar()
 *    is_numberic()
 *    is_callable()
 *
 
 
 
 * 常量的声明与使用
 *      1. 常量是一个简单值的标识符
 *      2. 常量定义后不能再改变他的值，也不能使用unset()取消
 *      3.常量可以不用理会变量范围的规则而在任何地方都可以定义和访问
 *      4.常量使用define("常量名"， 值);
 *      5.常量名在声明和使用都不使用"$"
 *      6.常量名称习惯都使用大写
 *      7.常量的值只能用标量类型（int, float, bool, string）
 *      8.常量一定要在声明时就给值
 *      9.defined("常量");  判断常量是否存在
 */
  define("HOME","vsiudhoh");
  echo HOME;
  echo "<br>"; 
  if (defined("HOME"))
  {
  	echo "常量存在";
  }
  else
  {
  	echo "常量不存在";
  }
  echo "<br>";
/*  预定义常量和魔术常量
 */
  echo M_PI."<br>";  //预定义的常量，不需要声明
  echo "<br>";
  echo __FILE__."<br>";//文件路径   根据环境不同，值也不同   就是魔术常量
  echo __LINE__."<br>";//行数
  echo PHP_VERSION."<br>";//php版本
