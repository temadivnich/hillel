package com.pavlovar.xml.patterns;


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
//    export PATH=/Users/artempavlovskyi/IdeaProjects/apache-maven-3.3.9/bin:$PATH

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