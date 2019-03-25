package observer.impl;

import observer.themeinterface.ChatTheme;
import observer.themeinterface.ObserverInterface;

public class ObserverImpl implements ObserverInterface {

    private String name;

    @Override
    public void getMessage(String message) {
        System.out.println(name+"收到消息: "+message);
    }

    public ObserverImpl(String name, ChatTheme chatTheme) {
        this.name = name;
        chatTheme.registeObserver(this);
    }
}
