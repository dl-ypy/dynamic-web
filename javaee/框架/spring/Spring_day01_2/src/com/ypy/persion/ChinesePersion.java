package com.ypy.persion;

import com.ypy.ball.IBall;

public class ChinesePersion {
	private IBall ball;
	
	public void setBall(IBall ball) {
		this.ball = ball;
	}

	public void play() {
		System.out.println("ÖÐ¹úÈË");
		ball.play();
	}
}
