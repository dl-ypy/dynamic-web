<?php
/*ʱ�䣺2016��8��1��10:29:17 
	��������֮���໥ת��
 * 	һ����ǿ��ת����
 * 		setType(������ "����");  //����int, integer, float, double,real, bool, boolena, string, array, object
 *		���������ԭ���������͸ı䣬var_dump();
 */
	$a = "100abc";
	setType($a,"int");//�ַ���ת��Ϊ����
	var_dump($a); 
	echo "<br>";
/*		�ڸ�ֵǰʹ��(����)����ʽ, ����ı�ԭ����������
 *
 */		
  $b=(string)$a;
  var_dump($b);
  echo "<br>";
  var_dump($a);    //ԭ���ı���$aû��
  echo "<br>";
/*		
 *		$����=intval(������ֵ);
 *		$����=floatval(������ֵ);
 *		$����=stringval(������ֵ);
 */
  $c = intval("120fwewe442");
  var_dump($c);
  echo "<br>";
/*		ע�⣺ �������ڴ���ռ4���ֽڣ�  2.147e9
 *			���������ڴ��е�8���ֽ�
 *
 * 
 * 	һ���Զ�ת�� �� ��õķ�ʽ����Ϊ�������ǿ���ʱ����ȥ�������ͣ�������������л����Զ�ת�� 
 */
  $a1 = 100;
  $a2 = "200aaa";
  $a3 = true;
  $a4 = 13.255;
  $sum = $a1+$a2;  //��������͵�300
  var_dump($sum);
  echo "<br>";
  $sum = $a1 + $a3;  //��������͵�101��bool�͵�trueת��Ϊ������1
  var_dump($sum);
  echo "<br>"; 
  $sum = $a1+$a4;  //����Ǹ����͵�113.225
  var_dump($sum);
  echo "<br>"; 
  $sum = $a3+$a2;  //��������͵�201
  var_dump($sum);
  echo "<br>";
/*
 * ������������йص�һЩ���ú���
 *    isset(); �жϱ������ڲ����ڣ�ֵ�����null��Ҳ��ʾ������
 *    empty();  //�ж�һ�������Ƿ�Ϊ�գ� ����  null
 *    unset();  ɾ������
 *
 *    setType();  
 *
 *    getType();  //var_dump();
 */
	echo getType($a);  //ֻ�õ�����
	echo "<br>"; 
/*    �������Ͳ��Ժ���
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
 
 
 
 * ������������ʹ��
 *      1. ������һ����ֵ�ı�ʶ��
 *      2. ������������ٸı�����ֵ��Ҳ����ʹ��unset()ȡ��
 *      3.�������Բ�����������Χ�Ĺ�������κεط������Զ���ͷ���
 *      4.����ʹ��define("������"�� ֵ);
 *      5.��������������ʹ�ö���ʹ��"$"
 *      6.��������ϰ�߶�ʹ�ô�д
 *      7.������ֵֻ���ñ������ͣ�int, float, bool, string��
 *      8.����һ��Ҫ������ʱ�͸�ֵ
 *      9.defined("����");  �жϳ����Ƿ����
 */
  define("HOME","vsiudhoh");
  echo HOME;
  echo "<br>"; 
  if (defined("HOME"))
  {
  	echo "��������";
  }
  else
  {
  	echo "����������";
  }
  echo "<br>";
/*  Ԥ���峣����ħ������
 */
  echo M_PI."<br>";  //Ԥ����ĳ���������Ҫ����
  echo "<br>";
  echo __FILE__."<br>";//�ļ�·��   ���ݻ�����ͬ��ֵҲ��ͬ   ����ħ������
  echo __LINE__."<br>";//����
  echo PHP_VERSION."<br>";//php�汾
