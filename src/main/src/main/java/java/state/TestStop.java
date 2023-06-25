

/**
 * classname:&{yunchao}
 * packagename:&{team_name}
 * Description:
 *
 * @Date:2022/4/24 18:02
 * @Author: yunchao@163.com
 */


//测试STOP
//   建议线程正常停止，利用次数，不建议死循环
//    不使用stop，destory等过时方法
public class TestStop implements Runnable{

    private boolean flag=true;

    @Override
    public void run() {
        int i=0;
        while(flag)
        {
            System.out.println("run。。thread"+i++);
        }

    }

//    设置一个公开的方法,停止线程
    public void stop()
    {
        this.flag=false;
    }


    public static void main(String[] args) {
        TestStop testStop = new TestStop();

        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if (i==900){
//                调用自己设置的stop方法

                testStop.stop();
                System.out.println("it was stopped");
            }
        }


    }
}
