package java.state;

/**
 * classname:&{yunchao}
 * packagename:&{team_name}
 * Description:
 *
 * @Date:2022/4/24 19:02
 * @Author: yunchao@163.com
 */
public class TestSleep implements Runnable{
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
        TestSleep ticket=new TestSleep();        //创建线程，重写run方法，谁执行了run方法，谁就抢到了资源
        new Thread(ticket,"chao").start();
        new Thread(ticket,"teache").start();
        new Thread(ticket,"yellowcow").start();

    }
}
