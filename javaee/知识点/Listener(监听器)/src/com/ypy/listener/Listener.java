package com.ypy.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener implements HttpSessionListener {
	private int counter = 0;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		counter++;
		arg0.getSession().getServletContext().setAttribute("counter", counter);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		counter--;
		arg0.getSession().getServletContext().setAttribute("counter", counter);
	}

}
