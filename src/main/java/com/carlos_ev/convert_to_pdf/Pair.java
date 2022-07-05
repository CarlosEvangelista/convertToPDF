package com.carlos_ev.convert_to_pdf;

public class Pair<E, O> {
	private E left;
	private O right;
	public Pair(E left, O right) {
		super();
		this.left = left;
		this.right = right;
	}
	public E getLeft() {
		return left;
	}
	public void setLeft(E left) {
		this.left = left;
	}
	public O getRight() {
		return right;
	}
	public void setRight(O right) {
		this.right = right;
	}
	
}
