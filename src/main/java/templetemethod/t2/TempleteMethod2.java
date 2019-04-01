package templetemethod.t2;

public abstract  class TempleteMethod2 {
    //start 子类需要实现的方法
    public abstract  void getData();

    public abstract  void printData();
    //end
    public void handleData(){
        System.out.println("处理数据");
    };

    //模板方法
    public final void print(){
        getData();
        handleData();
        printData();
    };
}
