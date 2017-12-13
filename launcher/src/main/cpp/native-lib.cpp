#include <jni.h>
#include <string>
#include <LightGBM/application.h>
#include <android/log.h>
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,"native-lib",__VA_ARGS__)
extern "C"
JNIEXPORT jstring JNICALL
Java_com_android_launcher3_TestJni_stringFromJNI(JNIEnv *env, jclass type) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}extern "C"
JNIEXPORT void JNICALL
Java_com_android_launcher3_TestJni_trainModel(JNIEnv *env, jclass type, jstring path_) {
    const char *path = env->GetStringUTFChars(path_, 0);
    char train[] = "train";
    char* configs[2];
    configs[0] = train;
    configs[1] = const_cast<char *> (path);

    LOGW(" start %s", configs[0]);
    LOGW(" transfer in %s", configs[1]);

    LightGBM::Application app(2, configs);
    app.Run();

    LOGW("FINISH TRAIN");
    env->ReleaseStringUTFChars(path_, path);

}