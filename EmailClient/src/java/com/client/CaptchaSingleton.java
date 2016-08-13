
package com.client;

public class CaptchaSingleton {
private static final CaptchaGenerate obj = new CaptchaGenerate();
public static CaptchaGenerate getInstance(){
    return obj;
}
}
