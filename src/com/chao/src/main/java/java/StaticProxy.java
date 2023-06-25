package java;

/**
 * classname:&{yunchao}
 * packagename:&{team_name}
 * Description:
 *
 * @Date:2022/3/30 14:11
 * @Author: yunchao@163.com
 */

//静态代理
public class StaticProxy {

    WeddingCompany weddingCompany=new WeddingCompany(new You());
//    待续
}







interface Marry{    //接口，一开始做的事, 后面是实现
    void Happy();
}

//  真实角色,你去结婚
class You implements Marry{

    @Override
    public void Happy() {
        System.out.println("要结婚了");
    }
}

//代理角色，帮你结婚
class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target)
    {
        this.target=target;
    }

    @Override
    public void Happy() {
        before();
        after();

    }

    private void after() {
        System.out.println("结婚之后收尾款");
    }

    private void before() {
        System.out.println("结婚之前布置现场");

    }
}