package edu.school.calc;

public class ComputeCore {
    CppLib cppLib;
    ComputeCore(String libName) {
        cppLib = new CppLib(libName);
    }
    
    public boolean validExpression(String exp, String x) {
        return cppLib.isValidExpression(exp, x);
    }

    public String computeExpression(String exp, String x) {
        return cppLib.getComputeResult(exp, x).replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
    }
}
