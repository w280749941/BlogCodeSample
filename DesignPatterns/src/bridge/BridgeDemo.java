package bridge;

import bridge.impl.Allienware;
import bridge.impl.MacApplications;
import bridge.impl.MacBook;
import bridge.impl.SurfaceBook;
import bridge.impl.WindowsApplications;

public class BridgeDemo {

    public static void main(String[] args) {
        MacBook macBook = new MacBook(new MacApplications());

        SurfaceBook surfaceBook = new SurfaceBook(new WindowsApplications());

        Allienware allienware = new Allienware(new WindowsApplications());

        System.out.println("MacBook");
        macBook.openCommandTool();
        macBook.openWebBrowser();

        System.out.println("SurfaceBook");
        surfaceBook.openCommandTool();
        surfaceBook.openWebBrowser();

        System.out.println("Allienware");
        allienware.openCommandTool();
        allienware.openWebBrowser();
    }
}
