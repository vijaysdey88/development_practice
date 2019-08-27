package challenge.concurrency;

public class DCLTEST {

    public static void main(String[] args) {
        System.out.println("main Getting DCL eager");
        DLCEager.getInstance();

        System.out.println("main Getting DCL lazy");
        DCLLazy.getInstance();
    }
}
