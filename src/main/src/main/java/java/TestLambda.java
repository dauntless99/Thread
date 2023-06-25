package java;

public class TestLambda {


    static class Like2 implements ILike{
        //     3静态内部类, 在大类类里面声明类,static
        @Override
        public void Lambda() {
            System.out.println("i like lambda2");

        }

    }

    public static void main(String[] args) {
        ILike like=new Like();
        like.Lambda();


        like=new Like2();    //上面的静态类
        like.Lambda();



        //4局部内部类，定义在方法里面
        class Like3 implements ILike{

            @Override
            public void Lambda() {
                System.out.println("i like lambda3");

            }

        }

        like=new Like3();
        like.Lambda();


        //5匿名内部类, 没有类的名称，必须借助接口或父类
        like=new ILike() {
            @Override
            public void Lambda() {
                System.out.println("i like lambda4");

            }
        };

        like.Lambda();



//      6  用lambda简化,直接省略类和方法的声明， 用()->方法体内容，来代替，适用于函数式接口，就只有一个方法那种

        like = ()->{
                System.out.println("i like lambda5");
            };
        like.Lambda();





    }
}


interface ILike{
    void Lambda();
}



class Like implements ILike{

    @Override
    public void Lambda() {
        System.out.println("i like lambda");

    }

}