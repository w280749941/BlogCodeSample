package adapter;

import adapter.type.SourceType;

public class VGA extends VideoContent{
    private final String name="VGA";

    public VGA(String content) {
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
        return SourceType.VGA;
    }
}
