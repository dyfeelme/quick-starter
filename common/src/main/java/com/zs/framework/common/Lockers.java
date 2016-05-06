package com.zs.framework.common;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Lockers {
	
	public static class LockTest{
		Lock lock = new ReentrantLock();
		
		double value = 0d;
		int addtimes = 0;
		
		public void addValue(double v){
			lock.lock();
			System.out.println("LockTest to addValue"+v+" "+System.currentTimeMillis());
			
			try {
				Thread.sleep(1*1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.value += v;
			this.addtimes++;
			lock.unlock();
		}
		
		public Double getValue(){
			return this.value;
		}
	}
	
	public static void testLock() throws InterruptedException, ExecutionException{
		final LockTest lockTest = new LockTest();
		
		Runnable task1 = new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				lockTest.addValue(5.5);
			}
		};
		
		Runnable task2 = new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("get value:"+lockTest.getValue());
			}
		};
		
		ExecutorService cacheService = Executors.newCachedThreadPool();
		Future future = null;
		for(int i=0;i<3;i++){
			future = cacheService.submit(task1);
		}
		future.get();
		
		future = cacheService.submit(task2);
		
		future.get();
		
		cacheService.shutdown();
	}
	
	public static class ReadWriteLockTest{
		ReadWriteLock lock = new ReentrantReadWriteLock();
		
		double value = 0d;
		int addtimes = 0;
		
		public void addValue(double v){
			Lock writeLock = lock.writeLock();
			System.out.println("ReadWirteLockTest to addValue:"+v+" "+System.currentTimeMillis());
			
			try {
				Thread.sleep(1*1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.value+=v;
				this.addtimes++;
			} finally{
				writeLock.unlock();
			}
		}
		
		public String getValue(){
			Lock readLock = lock.readLock();
			readLock.lock();
			
			System.out.println("ReadWriteLockTest to getValue"+System.currentTimeMillis());
			
			try {
				Thread.sleep(1*1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				return this.value+":"+this.addtimes;
			} finally{
				readLock.unlock();
			}
		}
	}
	
	public static void testReadWriteLockTest() throws Exception{
		
		final ReadWriteLockTest test = new ReadWriteLockTest();
		
		Runnable task1 = new Runnable() {
			
			public void run() {
				test.addValue(5.5);
				
			}
		};
		
		Runnable task2 = new Runnable() {
			
			public void run() {
				System.out.println("info:"+test.getValue());
				
			}
		};
		
		ExecutorService cacheService = Executors.newCachedThreadPool();
		Future future = null;
		
		for(int i=0;i<2;i++){
			future = cacheService.submit(task1);
		}
		
		for(int i=0;i<2;i++){
			future = cacheService.submit(task2);
		}
		
		future = cacheService.submit(task1);
		
		future.get();
		
		cacheService.shutdownNow();
	}
	
	public static void main(String[] args) throws Exception {
		//Lockers.testLock();
		Lockers.testReadWriteLockTest();
	}

}
