package struts2_2300_interceptor_simulatio;

import java.util.ArrayList;
import java.util.List;

public class ActionInvocation {
	List<Interceptor> inter = new ArrayList<Interceptor>();
	int index = -1;
	Action a = new Action();
	public ActionInvocation(){
		this.inter.add(new FirstInterceptor());
		this.inter.add(new SecondInterceptor());
	}
	public void invoke(){
		index++;
		if (index >= this.inter.size()){//ȷ���������е�interecptor��ִ��execute����
			a.execute();
		}else{
			this.inter.get(index).intercept(this);
		}
	}
}




















