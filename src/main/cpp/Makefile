.PHONY: all clean main
PROJECT_NAME = calc
CC = g++ -std=c++17
OS := $(shell uname -s)
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-18.0.1.1.jdk/Contents/Home
package=edu.school.calc
package_path=edu/school/calc

clean:
	rm -f *.o *.gcno *.gcda *.info *.out */.clang-format .clang-format *.a model/*.gch ./report/ *.dSYM *.so *.dylib *.log
	@clear

jni_header: clean
	javac -h . ../java/$(package_path)/CppLib.java
	# need edit header Java_edu_school_calc_CppLib_isValidExpression after gen, change return type to jboolean

jni_shit: clean
	$(CC) -c -o model.o model.cc
	$(CC) -c -o calcWrapper.o calcWrapper.cc
	$(CC) -c -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/darwin" javawrapper_nativeLib.cc -o javawrapper_nativeLib.o
	$(CC) -dynamiclib -o libcalcNativeLib.dylib javawrapper_nativeLib.o calcWrapper.o model.o
