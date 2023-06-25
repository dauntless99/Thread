package com.chao.demo01;

/**
 * classname:&{yunchao}
 * packagename:&{team_name}
 * Description:
 *
 * @Date:2022/3/25 23:09
 * @Author: yunchao@163.com
 */
//多个线程同时操作同一个对象
    //买火车票的例子
    //这里多个线程抢票，就出现了紊乱
public class TestThread4 implements Runnable{

    private int ticketNum=10;



    @Override
    public void run(){
        while(true)
        {try {
            if(ticketNum<=0)
                break;
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            System.out.println(Thread.currentThread().getName()+"拿到了第 "+ticketNum--+"票");

        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TestThread4 ticket=new TestThread4();        //创建线程，重写run方法，谁执行了run方法，谁就抢到了资源
        new Thread(ticket,"chao").start();
        new Thread(ticket,"teache").start();
        new Thread(ticket,"yellowcow").start();

    }
}
