#include "edu_school_calc_CppLib.h"
#include "calcWrapper.h"
#include <iostream>
#include <string>

std::string jstringToString(JNIEnv *env, jstring jStr) {
    jboolean isCopy;
    const char *convertedValue = (env)->GetStringUTFChars(jStr, &isCopy);
    return (std::string)convertedValue;
}

jstring stringToJstring(JNIEnv *env, std::string nativeString) {
    return env->NewStringUTF(nativeString.c_str());
}

JNIEXPORT jstring JNICALL Java_edu_school_calc_CppLib_getComputeResult(JNIEnv* env, jobject obj, jstring exp, jstring x) {
    std::string stdString = computeExpression(
        jstringToString(env, exp),
        jstringToString(env, x)
    );

    return stringToJstring(env, stdString);
}

JNIEXPORT jboolean JNICALL Java_edu_school_calc_CppLib_isValidExpression(JNIEnv* env, jobject obj, jstring exp, jstring x) {
    bool valid_result = validExpression(
        jstringToString(env, exp),
        jstringToString(env, x)
    );

    return (unsigned)valid_result;
}