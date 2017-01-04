package com.pavlovar.xml.patterns;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * Created by artempavlovskyi on 04/01/2017.
 */
public class SingletonPattern {
    public static void main(String[] args) {

        for (int i=1;i<=1000;i++) {
            Singleton s = Singleton.getInstance();
        }
    }
}

class Singleton {
    public int counter;
    private static Singleton instance;

    private Singleton () {
        counter++;
        System.out.println(counter);
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}