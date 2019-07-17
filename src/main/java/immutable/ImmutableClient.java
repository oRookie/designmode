package immutable;

import java.util.Date;
import java.util.stream.IntStream;

public class ImmutableClient {
    public static void main(String[] args) {
        //shareData
        Person person = new Person("halen","shanxi");
        IntStream.rangeClosed(1,5).forEach(i->new UsePerson(person).start());

        //Immutable类中有哪些，String System Date
        String str = "1234";
        String ss = str.replace("1","h");
        System.out.println(str.getClass() + " : "+str.hashCode());
        str = "3445";
        System.out.println(str.getClass() + " : "+str.hashCode());
        System.out.println(ss.getClass()+" : "+ss.hashCode());

    }
}
