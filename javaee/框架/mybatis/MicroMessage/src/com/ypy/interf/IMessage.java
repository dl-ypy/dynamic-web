package com.ypy.interf;

import java.util.List;
import java.util.Map;

import com.ypy.bean.Message;

/**
 * 与Message配置文件相对应的接口
 * 防止调用selectList方法时传入的参数出现错误。
 * 如果所传的参数类型等与接口中定义的不一致，就会错误，所以就能知道错误所在。
 */
public interface IMessage {
	//要代言配置文件中的哪个方法，就用该方法的id作方法名
	//参数的类型也是配置文件中配置的类型
	public List<Message> selectMessage(Message message);
	public List<Message> selectMessageByPage(Map<String, Object> parameter);
	public void insertBatch(List<Message> message);
}
