package com.chao.demo01;



//先创建一个类继承thread，然后 重写run方法，run方法就是线程执行体
//总结：注意，线程开启不一定立即执行，由cpu调度

public class TestThread extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在子线程");
        }
    }


    public static void main(String[] args) {

        TestThread testThread=new TestThread();
        testThread.start();

        for (int i = 0; i < 20000; i++) {
            System.out.println("我在多线程"+i);

        }
    }
}
