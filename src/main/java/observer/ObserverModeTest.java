package observer;

import observer.impl.ChatThemeImpl;
import observer.impl.ObserverImpl;
import observer.themeinterface.ChatTheme;
import observer.themeinterface.ObserverInterface;

import java.util.stream.IntStream;

public class ObserverModeTest {
    public static void main(String[] args) {

        ChatTheme chatTheme = new ChatThemeImpl();


        ObserverInterface observer1 = new ObserverImpl("observer1",chatTheme);
        ObserverInterface observer2 = new ObserverImpl("observer2",chatTheme);
        ObserverInterface observer3 = new ObserverImpl("observer3",chatTheme);



        IntStream.rangeClosed(0,100).forEach(i->new Thread(){
            @Override
            public void run() {
                ((ChatThemeImpl) chatTheme).sendMessage("哈喽，大家明天准时到场。。。");
            }
        }.run());


    }
}
