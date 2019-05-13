package com.dev.Model;

public enum Delivery {

	one(1), two(2), three(3), four(4), six(6), na(-1), out(-2), wide(-3), no(-4),  ;

	private int value;

	private Delivery(int value){  
	this.value=value;  
	}
}
