package com.ypy.spring;
/**
 * Dao对象的工厂（接口）
 */
public interface BeanFactory {
	public Object getBean(String name);
}
