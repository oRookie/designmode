package templetemethod;

public abstract class TempleteMethod {
    /**
     * 子类需要实现的方法
     */
    public abstract void getData();

    public abstract  void printData();

    public final void print(){
        getData();
        printData();
    };
}
