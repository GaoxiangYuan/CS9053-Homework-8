package edu.nyu.cs9053.homework8;

public class Jobs {
	private final long s,t;                            // assume time is expressed by long format.
	private final double w;
	public Jobs(long startTime, long finishTime, double weight){
		this.s=startTime;
		this.t=finishTime;
		this.w=weight;
	}
	public long getStartTime(){
		return s;
	}
	public long getFinishTime(){
		return t;
	}
	public double getWeight(){
		return w;
	}
}
