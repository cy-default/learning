package com.rm13.base;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ChanFi
 * @Date: 2021/2/1 上午10:07
 */
public class DelayQueueTest {

	public static void main(String[] args) {
		DelayQueue<Message> delayQueue = new DelayQueue();
		long now = System.currentTimeMillis();
		delayQueue.add(new Message(now+5000));
		delayQueue.add(new Message(now+8000));
		delayQueue.add(new Message(now+2000));
		delayQueue.add(new Message(now+1000));
		delayQueue.add(new Message(now+7000));

		Executors.newFixedThreadPool(1).submit(()->{
			while (true){
				System.out.println(delayQueue.take().deadline-now);
			}
		});


	}
}

class Message implements Delayed {
	long deadline;

	public Message(long deadline) {
		this.deadline = deadline;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return deadline- System.currentTimeMillis();
	}

	@Override
	public int compareTo(Delayed o) {
		return (int) (getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
	}
}
