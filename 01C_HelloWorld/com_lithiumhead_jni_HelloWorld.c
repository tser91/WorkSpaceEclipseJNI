/*
 * com_lithiumhead_jni_HelloWorld.c
 *
 *  Created on: 22/03/2014
 *      Author: Sergio
 */

#include <jni.h>
#include "..\01Java_HelloWorld\bin\com_lithiumhead_jni_HelloWorld.h"
#include <stdio.h>

JNIEXPORT jdouble JNICALL Java_com_lithiumhead_jni_HelloWorld_add(JNIEnv *env, jobject obj, jdouble arg1, jdouble arg2)
{
	jdouble result = (jdouble) arg1 + arg2;
	return result;
}

JNIEXPORT jdouble JNICALL Java_com_lithiumhead_jni_HelloWorld_minus(JNIEnv *env, jobject obj, jdouble arg1, jdouble arg2)
{
	jdouble result = arg1 - arg2;
	return result;
}

JNIEXPORT jdouble JNICALL Java_com_lithiumhead_jni_HelloWorld_mult(JNIEnv *env, jobject obj, jdouble arg1, jdouble arg2)
{
	jdouble result = arg1 * arg2;
	return result;
}

JNIEXPORT jdouble JNICALL Java_com_lithiumhead_jni_HelloWorld_div(JNIEnv *env, jobject obj, jdouble arg1, jdouble arg2)
{
	jdouble result = arg1 / arg2;
	return result;
}

