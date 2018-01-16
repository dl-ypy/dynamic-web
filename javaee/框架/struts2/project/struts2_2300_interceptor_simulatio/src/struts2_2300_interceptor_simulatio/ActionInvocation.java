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
		if (index >= this.inter.size()){//确定调完所有的interecptor才执行execute方法
			a.execute();
		}else{
			this.inter.get(index).intercept(this);
		}
	}
}




















