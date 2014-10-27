package vv.spoonNumberCall.logger;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class LogWriterNum {

    static HashMap< String,Integer> callmethod= new HashMap<String,Integer>();

    private static PrintWriter fileWriter;

    static ShutdownHookLog1 shutdownHook;

    public static void writeLog() {

        out();
        fileWriter.close();

    }

    public static  void out() {

        try {
            PrintWriter writer = getWriter();

            Iterator<Map.Entry<String, Integer>> entries=(callmethod.entrySet()).iterator();
            while(entries.hasNext()){
                Map.Entry entry=entries.next();
                String st=entry.getKey()+"\t"+entry.getValue();
                writer.write(st + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            fileWriter.close();
        }
    }

    protected static PrintWriter getWriter() throws FileNotFoundException {
        if(fileWriter == null) {
            //ShutdownHookLog1 shutdownHook = new ShutdownHookLog1();
            //Runtime.getRuntime().addShutdownHook(shutdownHook);
            fileWriter = new PrintWriter("logCompter");
        }
        return fileWriter;
    }


    public static void addEntry(String key){
        addHook();
        if (callmethod.containsKey(key)){
            int value=callmethod.get(key);
            value++;
            callmethod.put(key,value);

        }
        else {
            callmethod.put(key,1);
        }

    }

    public static void addHook(){
        if(shutdownHook==null){
            shutdownHook=new ShutdownHookLog1();
            Runtime.getRuntime().addShutdownHook(shutdownHook);
        }

    }
}
