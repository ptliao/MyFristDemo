package com.androidtest2;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

public class ListActivity {
	
	private static List<Activity> list=new LinkedList<Activity>();
	private static ListActivity listActivity;
	//单例模式(先私有化无参构造方法)
	private ListActivity(){
		
	}
	public static ListActivity getListActivity(){
		if(listActivity==null){
			return new ListActivity();
		}
		return listActivity;
	}
//	添加页面到链表中
	public void addActibity(Activity act){
		if(act!=null){
			list.add(act);
		}
	}
//	删除所有的页面
	public void delAll(){
		for(Activity a:list){
			a.finish();
		}
	}
}
