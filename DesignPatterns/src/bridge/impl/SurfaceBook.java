package bridge.impl;

import bridge.ApplicationSet;
import bridge.Computer;

public class SurfaceBook extends Computer {

    public SurfaceBook(ApplicationSet applicationSet){
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
