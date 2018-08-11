package bridge.impl;

import bridge.ApplicationSet;
import bridge.Computer;

public class Allienware extends Computer {

    public Allienware(ApplicationSet applicationSet) {
        super(applicationSet);
    }

    @Override
    public void openWebBrowser() {
        applicationSet.openWebBrowser();
    }

    @Override
    public void openCommandTool() {
        applicationSet.openCommandTool();
    }
}
