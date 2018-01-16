import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

	public static void main(String[] args) {
		ResourceBundle res = ResourceBundle.getBundle("app", Locale.CHINA);//第一个参数必须是资源文件的第一个单词	
		System.out.println(res.getString("welcome.msg"));
	}

}
