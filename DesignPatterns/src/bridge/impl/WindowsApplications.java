package bridge.impl;

import bridge.ApplicationSet;

public class WindowsApplications implements ApplicationSet {

    @Override
    public void openWebBrowser() {
        System.out.println("Opening Edge");
    }

    @Override
    public void openCommandTool() {
        System.out.println("Opening Command Prompt");
    }
}
