package observer.themeinterface;

/**
 * 所有的主题需要实现该接口
 */
public interface ChatTheme {
    //注册观察者
    public void registeObserver(ObserverInterface observerInterface);

    //移除观察者
    public void removeObserver(ObserverInterface observerInterface);

    //通知所有观察者
    public void notifyAllObserver();

}
