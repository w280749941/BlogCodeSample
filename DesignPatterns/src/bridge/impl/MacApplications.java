package bridge.impl;

import bridge.ApplicationSet;

public class MacApplications implements ApplicationSet {

    @Override
    public void openWebBrowser() {
        System.out.println("Opening Safari");
    }

    @Override
    public void openCommandTool() {
        System.out.println("Opening Terminal");
    }
}
