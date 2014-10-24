package vv.spoonNumberCall.logger;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;


public class LogWriterNum {

    HashMap< String,Integer> callmethod= new HashMap<String,Integer>();

    private static PrintWriter fileWriter;

    public static void writeLog() {
        fileWriter.close();
    }

    public static  void out(String string, boolean error) {

        try {
            PrintWriter writer = getWriter();

            if(error) {
                writer.write("ERROR: ");
            } else {
                writer.write("INFO: ");
            }
            writer.write(string + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static PrintWriter getWriter() throws FileNotFoundException {
        if(fileWriter == null) {
            ShutdownHookLog1 shutdownHook = new ShutdownHookLog1();
            Runtime.getRuntime().addShutdownHook(shutdownHook);
            fileWriter = new PrintWriter("log");
        }
        return fileWriter;
    }

    /** affiche le nombre de fois la methode est appelee **/
    public static  void count(String string, int number) {
        try {
            PrintWriter writer = getWriter();
            writer.write(string +" "+number+"\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addCallNumber(String argument)
    {
        if(callmethod.containsKey(argument))
        {
            Integer i = callmethod.get(argument);
            i = i +1;//call number +1
            callmethod.replace(argument,i);
        }
        else
        {
            callmethod.put(argument,1);
        }
    }
}
