package design.pattern.singleton;

public class SingletonPatternUsingInnerStatic {

    private SingletonPatternUsingInnerStatic() {}

    private static class SingletonPatternBuilder {
        private static final SingletonPatternUsingInnerStatic INSTANCE = new SingletonPatternUsingInnerStatic();
    }

    public static SingletonPatternUsingInnerStatic getInstance(){
        return SingletonPatternBuilder.INSTANCE;
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println(SingletonPatternUsingInnerStatic.getInstance().hashCode());
        System.out.println(SingletonPatternUsingInnerStatic.getInstance().hashCode());
        System.out.println(SingletonPatternUsingInnerStatic.getInstance().hashCode());
        System.out.println(SingletonPatternUsingInnerStatic.getInstance().hashCode());
    }
}
