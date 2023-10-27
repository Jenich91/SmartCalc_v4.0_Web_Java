package edu.school.calc;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CppLib {
    CppLib(String libName) {
        System.load(GetLibPath(libName));
    }

    String GetLibPath(String resourceName) {
        Path resourceDirectory = Paths.get("src","test","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        
        return absolutePath+"/lib/"+resourceName;
    };
    
    native String getComputeResult(String exp, String x);
    native boolean isValidExpression(String exp, String x);
}
