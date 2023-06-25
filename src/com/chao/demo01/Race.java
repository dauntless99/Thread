package com.chao.demo01;

/**
 * classname:&{yunchao}
 * packagename:&{team_name}
 * Description:
 *
 * @Date:2022/3/25 23:28
 * @Author: yunchao@163.com
 */
//模拟龟兔赛跑

public class Race implements Runnable{
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
        if(Thread.currentThread().getName().equals("兔子")) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            boolean flag=gameOver(i);
            if(flag)
                break;
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");

    }
    }

    private boolean gameOver(int steps) {
        if (winner != null)
            return true;
        if (steps >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("Winner is" + winner);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Race race=new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();

    }
}
