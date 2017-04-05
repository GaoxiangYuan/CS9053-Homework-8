package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LambdaWeightedScheduler {
	static List<Jobs> jobsList = new ArrayList<Jobs>();
	static List<Long> finishTimeList = new ArrayList<Long>();
	static List<Jobs> newJobList = new ArrayList<Jobs>();
	static Jobs job;
	static double money;
	// Make a list which contains all the jobs.
	public static void makeJobsList(Jobs ... jobs){
		for(Jobs job : jobs){
			jobsList.add(job);
		}
	}
	//make a list which contains all the finish times of each job.
	public static List<Long> makeFinishTimeList(List<Jobs> list){
		List<Long> temp = new ArrayList<Long>();
		for(Jobs job : list){
			temp.add(job.getFinishTime());
		}
		return temp;
	}
	//same way to make a list which contains all the start times of each job.
	public static List<Long> makeStartTimeList(List<Jobs> list){
		List<Long> temp = new ArrayList<Long>();
		for(Jobs job : list){
			temp.add(job.getStartTime());
		}
		return temp;
	}
	// this is a method to get the minimum number in a list.
	public static long findMin(List<Long> list){
		return (long) Collections.min(list);
	}
	public static void main(String[] args){
		long lastFinishTime=0l;                                               //at first, the last time number is 0.
		Iterator<Jobs> i = jobsList.iterator();
		while (i.hasNext()){                              
			 Iterator<Jobs> iterator = jobsList.iterator();
			 while (iterator.hasNext()){                                      //firstly, find all the jobs which satisfy the first condition, remove the others.
			    if(iterator.next().getStartTime()<lastFinishTime){ 
			    	iterator.remove();
			    }
			 }
			finishTimeList=makeFinishTimeList(jobsList);                      //use makeFinishTimeList method to get a new jobsList.
			Iterator<Jobs> iterator2 = jobsList.iterator();
			long finishTime=findMin(finishTimeList);                          //find the minimum finish time of the new jobsList.
			while (iterator2.hasNext()){	                                  //secondly, choose the job whose finish time == minimum finish time and remove it from the list.
				job = iterator2.next();
				if(job.getFinishTime()==finishTime){
					lastFinishTime=finishTime;
					iterator2.remove();
					newJobList.add(job);
					break;
				}
			}
		}
        Iterator<Jobs> j = newJobList.iterator();
        while(j.hasNext()){
        	money+=j.next().getWeight();
        }
		System.out.println(money);
	}
}
