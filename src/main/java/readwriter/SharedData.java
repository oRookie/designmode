package readwriter;

import java.util.Arrays;
import java.util.Optional;

public class SharedData {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size) {
        this.buffer = new char[size];
        for (int i=0;i<buffer.length;i++){
            buffer[i]='*';
        }
    }

    public char[]  read() throws InterruptedException {
        try {
            lock.readLock();
            return doRead();
        }finally {
            lock.readUnLock();
        }
    }

    public void write(char c) throws InterruptedException {
        try {
            lock.writeLock();
            doWrite(c);
            Optional.of(Thread.currentThread().getName()+" write to buffer,The data of write is: "+new String(buffer)).ifPresent(System.out::println);
        }finally {
            lock.writeUnLock();
        }

    }

    private char[] doRead(){
        slowly(50);
        return Arrays.copyOf(buffer,buffer.length);
    }

     private void doWrite(char c){
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly(10);
        }
    }
    public void slowly(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
