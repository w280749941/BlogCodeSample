package bridge;

public abstract class Computer {

    protected ApplicationSet applicationSet;

    public Computer(ApplicationSet applicationSet) {
        this.applicationSet = applicationSet;
    }

    protected abstract void openWebBrowser();
    protected abstract void openCommandTool();
}
