package com.focinfi.youzi;

/**
 * Created by Antony on 16/1/22.
 */
public class App {
    private volatile static App singleton;
    private static String DEVELOPMENT_MODE = "DEBUG_MODE";
    private static String TEST_MODE = "TEST_MODE";
    private static String PRODUCT_MODE = "PRODUCTION_MODE";
    private String devMode = TEST_MODE;

    private App() {
    }

    public static App getSingleton() {
        if (singleton == null) {
            synchronized (App.class) {
                if (singleton == null) {
                    singleton = new App();
                }
            }
        }
        return singleton;
    }

    public void setDevMode(String mode) {
        singleton.devMode = mode;
    }

    public static boolean isDevelopmentMode() {
        return singleton.devMode == DEVELOPMENT_MODE;
    }

    public static boolean isTestMode() {
        return singleton.devMode == TEST_MODE;
    }

    public static boolean isProductionMode() {
        return singleton.devMode == PRODUCT_MODE;
    }

}
