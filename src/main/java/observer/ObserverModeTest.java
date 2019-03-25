package observer;

import observer.impl.ChatThemeImpl;
import observer.impl.ObserverImpl;
import observer.themeinterface.ChatTheme;
import observer.themeinterface.ObserverInterface;

public class ObserverModeTest {
    public static void main(String[] args) {

        ChatTheme chatTheme = new ChatThemeImpl();


        ObserverInterface observer1 = new ObserverImpl("observer1",chatTheme);
        ObserverInterface observer2 = new ObserverImpl("observer2",chatTheme);
        ObserverInterface observer3 = new ObserverImpl("observer3",chatTheme);

        ((ChatThemeImpl) chatTheme).sendMessage("哈喽，大家明天准时到场。。。");


    }
}
