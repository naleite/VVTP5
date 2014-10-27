package vv.spoonNumberCall.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.*;
import spoon.reflect.cu.CompilationUnit;
import spoon.reflect.cu.SourceCodeFragment;
import spoon.reflect.cu.SourcePosition;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtExecutableReference;
import spoon.support.reflect.code.CtCodeSnippetStatementImpl;
import vv.spoonNumberCall.logger.LogWriterNum;

import java.beans.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LogProcessorMethodNumber extends AbstractProcessor<CtMethod>  {



    @Override
    public void process(CtMethod element) {

        SourcePosition sp = element.getPosition();
        CompilationUnit compileUnit = sp.getCompilationUnit();

        //add /** before the invocation
        //SourceCodeFragment before = new SourceCodeFragment(compileUnit.beginOfLineIndex(sp.getSourceStart()), "/**", 0);
        //compileUnit.addSourceCodeFragment(before);

        //add **/ vv.spoon.logger.LogWriter.out( argument, newline, error); after the invocation
        //Object argument = element.getArguments().get(0);
       // String snippet = "**/\n\t\tvv.spoon.logger.LogWriter.out(" + argument
               // + "," + isError(element.getTarget()) + ");\n";

        String classname=element.getDeclaringType().getQualifiedName();
        String methodSign=classname+"."+element.getSignature();



        String snippet = "\n\t\tvv.spoonNumberCall.logger.LogWriterNum.addEntry(\""+methodSign+"\");\n";
        SourceCodeFragment after = new SourceCodeFragment(compileUnit.nextLineIndex(sp.getSourceEnd()), snippet, 0);

        compileUnit.addSourceCodeFragment(after);


        CtCodeSnippetStatement ctcode=getFactory().Core().createCodeSnippetStatement();
        ctcode.setValue(snippet);
        element.getBody().addStatement(ctcode);
    }

}
