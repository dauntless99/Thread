package com.chao.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * classname:&{yunchao}
 * packagename:&{team_name}
 * Description:
 *
 * @Date:2022/3/25 22:01
 * @Author: yunchao@163.com
 */


//练习thread，实现多线程同步下载图片
public class TestThread2 implements Runnable{

    private String url;  //网络图片地址
    private String name;  //保存的文件名

    public TestThread2(String url,String name){
        this.url=url;          //构造方法初始化
        this.name=name;

    }

    //下载图片线程的执行体
    @Override
    public void run(){
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了的文件名为"+name);
    }



    public static void main(String[] args) {
        TestThread2 t1=new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F4k%2Fs%2F02%2F2110021F21V024-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1650810156&t=927701c1ae6042d025b61c5437c23899","1.jpg");
        TestThread2 t2=new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F4k%2Fs%2F02%2F2110021F21V024-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1650810156&t=927701c1ae6042d025b61c5437c23899","2.jpg");
        TestThread2 t3=new TestThread2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F4k%2Fs%2F02%2F2110021F21V024-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1650810156&t=927701c1ae6042d025b61c5437c23899","3.jpg");

//        t1.start();
//        t2.start();
//        t3.start();   继承thread类的start
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}


//下载器，
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){

        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("IO异常，downloader方法出现");
    }
}