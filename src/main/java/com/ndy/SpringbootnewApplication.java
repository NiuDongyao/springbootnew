package com.ndy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootnewApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootnewApplication.class, args);
    }

}

class Singleton{
    private Singleton(){};

    private volatile static Singleton singleton;

    public static Singleton getSingleton(){
        if(null ==singleton){
            synchronized(Singleton.class){
                if(null == singleton){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}
