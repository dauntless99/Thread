package com.chao.demo01;

/**
 * classname:&{yunchao}
 * packagename:&{team_name}
 * Description:
 *
 * @Date:2022/3/25 22:32
 * @Author: yunchao@163.com
 */

//创建线程方式2，实现runnable方法，重写run方法，执行线程需要丢入runnable接口实现类
public class TestThread3 implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在子线程");
        }
    }


    public static void main(String[] args) {

        TestThread3 testThread3=new TestThread3();
        new Thread(testThread3).start();
//        testThread3.run();


        for (int i = 0; i < 20000; i++) {
            System.out.println("我在多线程"+i);

        }
    }
}
