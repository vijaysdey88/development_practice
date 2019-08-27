package challenge.concurrency;

public class DCLLazy {

    private DCLLazy() {
        System.out.println("Initializing DCLLazy");
    }

    private static class DCLLazyHolder {
        private static final DCLLazy INSTANCE = new DCLLazy();
    }

    public static final DCLLazy getInstance() {
        return DCLLazyHolder.INSTANCE;
    }
}
