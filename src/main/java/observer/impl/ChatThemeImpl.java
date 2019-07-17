package observer.impl;

import observer.themeinterface.ChatTheme;
import observer.themeinterface.ObserverInterface;

import java.util.ArrayList;
import java.util.List;

public class ChatThemeImpl implements ChatTheme {

    private List<ObserverInterface> observerList  = new ArrayList<>();

    private String message;

    @Override
    public void registeObserver(ObserverInterface observerInterface) {
        observerList.add(observerInterface);
    }

    @Override
    public void removeObserver(ObserverInterface observerInterface) {
        observerList.remove(observerInterface);
    }

    @Override
    public void notifyAllObserver() {
        observerList.stream().forEach(o->o.getMessage(message));
    }

    //主题发送消息
    public void sendMessage(String message){
        System.out.println("主题发送消息："+message);
        this.message = message;
        notifyAllObserver();
    }

}
