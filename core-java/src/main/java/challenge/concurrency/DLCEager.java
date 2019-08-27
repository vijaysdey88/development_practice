package challenge.concurrency;

public final class DLCEager {

    private DLCEager() {
        System.out.println("Initializing eager");
    }

    private static final DLCEager INSTANCE = new DLCEager();

    public static DLCEager getInstance() {
        return INSTANCE;
    }

    static {
        System.out.println(" eager static ");
    }
 }
