package vv.spoonNumberCall.logger;

public class ShutdownHookLog1 extends Thread {

    public void run() {
        LogWriterNum.writeLog();
    }
}
