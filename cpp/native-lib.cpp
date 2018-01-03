#include <jni.h>
#include <string>
#include <LightGBM/application.h>
#include <android/log.h>

#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,"native-lib",__VA_ARGS__)
extern "C"
JNIEXPORT jstring JNICALL
Java_com_android_predict_TestJni_stringFromJNI(JNIEnv *env, jclass type) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}extern "C"
JNIEXPORT void JNICALL
Java_com_android_predict_TestJni_trainModelJni(JNIEnv *env, jclass type, jstring path_,
                                               jstring config_, jstring calss_num_) {
    const char *path = env->GetStringUTFChars(path_, 0);
    const char *config = env->GetStringUTFChars(config_, 0);
    const char *class_num = env->GetStringUTFChars(calss_num_, 0);
    char train[] = "train";
    int para_size = 3;
    char *configs[para_size];
    configs[0] = train;
    configs[1] = const_cast<char *> (config);
    configs[2] = const_cast<char *> (class_num);
    LOGW(" start %s", configs[0]);
    LOGW(" transfer in %s", configs[1]);
    LightGBM::Application app(para_size, configs);
    app.Run();
    LOGW("finish train");
    env->ReleaseStringUTFChars(path_, path);
    env->ReleaseStringUTFChars(config_, config);
    env->ReleaseStringUTFChars(calss_num_, class_num);
}extern "C"
JNIEXPORT void JNICALL
Java_com_android_predict_TestJni_predictJni(JNIEnv *env, jclass type, jstring config_) {
    const char *config = env->GetStringUTFChars(config_, 0);
    char predict[] = "predictJni";
    char *configs[2];
    configs[0] = predict;
    configs[1] = const_cast<char *> (config);
    LOGW(" start %s", configs[0]);
    LOGW(" transfer in %s", configs[1]);
    LightGBM::Application app(2, configs);
    app.Run();
    LOGW("finish predictJni");
    env->ReleaseStringUTFChars(config_, config);
}