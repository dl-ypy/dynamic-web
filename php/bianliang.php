<?php
	$a=$b=$c=$d = "value";    //php�������͵ģ����ͻ���ݱ�����ֵȷ��
	if (isset($a))
	{
		echo "�����жϱ����Ƿ���ڵĺ������������ڡ�";
	}
	else
	{
		echo "���������ڣ�";
	}
	echo "<br>";
	unset($b);     //�ͷű����ڴ�
	
	if (isset($b))
	{
		echo "�����жϱ����Ƿ���ڵĺ������������ڡ�";
	}
	else
	{
		echo "���������ڣ�";
	}
	echo "<hr>";
	
	$one = "zero";
	$two = "one";
	$three = "two";
	
	echo $three;     //�ɱ����
	echo "<br>";
	echo $$three;
	echo "<br>";
	echo $$$three;
	echo "<hr>";
	
	$one = "10";
	$two = &$one;     //���ø�ֵ���൱�ڳ�Ϊͬһ������
	$one = "1000000";
	echo $two-"<br>";
	echo "<hr>";
	
	//����������
	$var = 10;
	var_dump($var);    //�鿴����������
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
	
	//һЩ����ı�������
	$str = 'gsgsggsgs';   //���ﵥ���ŵ�Ҳ���ַ�����php�����ʹ�õ�����
	$str=<<<a             //����������ַ����ķ�ʽ
	vsdgerfsdbsg
	vrwgrege
a;
	echo $str;
	
	