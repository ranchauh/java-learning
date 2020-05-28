package design.pattern.singleton;

import java.util.Objects;

public class ThreadSafeSingleton {

    private ThreadSafeSingleton() {}

    private static ThreadSafeSingleton safeSingleton;

    public static ThreadSafeSingleton getInstance(){
        if(Objects.isNull(safeSingleton)){
            synchronized (ThreadSafeSingleton.class){
                if(Objects.isNull(safeSingleton)){
                    safeSingleton = new ThreadSafeSingleton();
                }
            }
        }
        return safeSingleton;
    }
}

class SafeSingletonTest{
    public static void main(String[] args) {
        System.out.println(ThreadSafeSingleton.getInstance().hashCode());
        System.out.println(ThreadSafeSingleton.getInstance().hashCode());
        System.out.println(ThreadSafeSingleton.getInstance().hashCode());
        System.out.println(ThreadSafeSingleton.getInstance().hashCode());
    }
}
