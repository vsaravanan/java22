package com.saravanjs.java22.console.designpatterns.singleton;

import java.io.Serializable;

/**
 * @author Sarav on 19 Sep 2023
 * @project govtech
 * @package com.govtech.viswa.designpatterns.singleton
 * @class SerializedSingleton
 */
// Serialization and Singleton

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton(){}

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }
    protected Object readResolve() {
        return getInstance();
    }
}