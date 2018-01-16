<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册页面</title>
	<style>
        	.zc{
			width:1002px;
			height:500px;
			margin:0px auto;
			background-color:#EDEDED;
		}
	</style>
        <script language="javascript">
            function check(ZC)
            {
                var yonghu = ZC.yonghu.value;
                var mima1 = ZC.mima1.value;
                var mima2 = ZC.mima2.value;
                var dianhua = ZC.dianhua.value;
                var youxiang = ZC.youxiang.value;
                if(yonghu == "")
                {
                    alert("用户名为空！");
                    ZC.yonghu.focus();
                    ZC.yonghu.select();
                    return false;
                }
		if(mima1 == "")
		{
			alert("密码为空！");
			ZC.mima1.focus();
			ZC.mima1.select();
			return false;
		}
		if(mima2 == "")
		{
			alert("确认密码为空！");
			ZC.mima2.focus();
			ZC.mima2.select();
			return false;
		}
		if(mima1 != mima2)
		{
			alert("密码不一致！");
			ZC.mima2.focus();
			ZC.mima2.select();
			return false;
		}
		if(!/^1[3,4,5,7,8][0-9]\d{8}$/.test(dianhua))
		{
			alert("电话格式不对！");
			ZC.dianhua.focus();
			ZC.dianhua.select();
			return false;
		}
		if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(youxiang))
		{
			alert("邮箱格式不对！");
			ZC.youxiang.focus();
			ZC.youxiang.select();
			return false;
		}
		return true;
            }
        </script>
</head>
<body>
	<div class="zc">
        <form name="ZC" action="Tijiao.jsp" method="post" onSubmit="return check(this)">
            <table>
                <tr><td>用户名:</td> <td><input type="text" name="username" value=""/></td></tr>
                <tr><td>密码:</td> <td><input type="password" name="password" value=""/></td></tr>
                <tr><td>确认密码:</td> <td><input type="password" name="password2" value=""></td></tr>
                <tr><td>电话号码:</td> <td><input type="text" name="phone" value=""></td></tr>
                <tr><td>邮箱:</td> <td><input type="text" name="youxiang" value=""></td></tr>
                <tr><td>性别:</td> <td><input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女</td></tr>
                <tr><td>居住地：</td> <td>
					<select name="address">
						<option value="北京">北京</option>
						<option value="山西">山西</option>
						<option value="河南">河南</option>
						<option value="山东">山东</option>
						<option value="广东">广东</option>
						<option value="上海">上海</option>
						<option value="东北">东北</option>

					</select></td></tr>
				<tr><td>爱好：</td><td>
					<input type="checkbox" name="like[]" value="打篮球">打篮球
					<input type="checkbox" name="like[]" value="看电影">看电影
					<input type="checkbox" name="like[]" value="玩游戏">玩游戏
				</td></tr>
                <tr><td valign="top">个人简介:</td> <td><textarea cols="20" rows="5" name="jianjie"></textarea></td></tr>
                <tr><td><input type="submit" value="提交"></td> <td><input type="reset" value="重置"></td></tr>
            </table>
        </form>
	</div>
</body>
</html>