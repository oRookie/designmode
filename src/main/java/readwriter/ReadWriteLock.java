package readwriter;

public class ReadWriteLock {
    private int readingReaderSize = 0;
    private int watingReadersSize = 0;
    private int writingWritersSize = 0;
    private int watingWritersSize = 0;
    private boolean preferWriter;

    public ReadWriteLock (){
        this(true);
    }
    public ReadWriteLock(boolean preferWriter){
        this.preferWriter = preferWriter;
    }

    public synchronized  void readLock () throws InterruptedException {
        this.watingReadersSize++;
        try{
            while(this.writingWritersSize > 0 || (this.preferWriter&&this.writingWritersSize>0)){
                this.wait();
            }
            this.readingReaderSize++;
        }finally {
            this.watingReadersSize--;
        }
    }

    public synchronized  void readUnLock() {
        this.readingReaderSize--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.watingWritersSize++;
        try{
            while(this.writingWritersSize>0 || this.readingReaderSize >0){
                this.wait();
            }
            this.writingWritersSize++;
        }finally {
            this.watingWritersSize--;
        }
    }

    public synchronized void writeUnLock(){
        this.writingWritersSize--;
        this.notifyAll();
    }

}
