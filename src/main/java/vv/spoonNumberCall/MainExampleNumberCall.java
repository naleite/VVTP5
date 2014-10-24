package vv.spoonNumberCall;

import vv.spoon.processor.LogProcessor;
import vv.spoonNumberCall.processor.LogProcessorMethodNumber;

import java.io.IOException;


public class MainExampleNumberCall {

    public static void main(String[] args) throws IOException {
        InstruNumberCall instru = new InstruNumberCall(args[0], args[1], new LogProcessorMethodNumber());

        //copy the project (args[0]) in the output directory (args[1])
        instru.initOutputDirectory();

        //instrumentalize the java code of output directory with LogProcessor
        instru.instru();
    }

}
