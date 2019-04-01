package templetemethod.t2;

public class TempleteMethodImpl2 extends TempleteMethod2 {
    @Override
    public void getData() {
        System.out.println("获取数据");
    }

    @Override
    public void printData() {
        System.out.println("打印数据");
    }

    //覆盖父类的 处理数据方法，实现控制反转
    @Override
    public void handleData() {
        System.out.println("实现自己" +
                "的处理数据");
    }

}
