package adapter;

import adapter.type.SourceType;

public class HDMI extends VideoContent{

    private final String name="HDMI";

    public HDMI(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public SourceType getName() {
        return SourceType.HDMI;
    }
}
