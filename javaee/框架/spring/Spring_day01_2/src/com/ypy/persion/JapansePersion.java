package com.ypy.persion;

import com.ypy.ball.IBall;

public class JapansePersion {
	private IBall ball;
	
	public JapansePersion(IBall ball) {
		this.ball = ball;
	}
	
	public void play() {
		System.out.println("»’±æ»À");
		ball.play();
	}
}
