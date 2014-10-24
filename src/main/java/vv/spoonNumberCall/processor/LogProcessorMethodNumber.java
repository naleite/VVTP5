package vv.spoonNumberCall.processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtStatement;
import spoon.reflect.cu.CompilationUnit;
import spoon.reflect.cu.SourceCodeFragment;
import spoon.reflect.cu.SourcePosition;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.reference.CtExecutableReference;

import java.beans.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LogProcessorMethodNumber extends AbstractProcessor<CtMethod>  {





    //check if executable is java.io.PrintStream.println(...) or java.io.PrintStream.print(...) method
    protected boolean isPrint(CtExecutableReference executable) {
        String toString = executable.toString();
        return toString.startsWith("java.io.PrintStream.println(")
                || toString.startsWith("java.io.PrintStream.print(");
    }



    @Override
    public void process(CtMethod ctMethod) {

        CtBlock ctblock = ctMethod.getBody();
        List<CtStatement> lstat =ctblock.getStatements();
        //ecrire logWriteer iciiii, premiere ligne

    }

}
