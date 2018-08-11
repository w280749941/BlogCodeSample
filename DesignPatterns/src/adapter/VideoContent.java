package adapter;

import adapter.type.SourceType;

public abstract class VideoContent {

    protected String content;

    public abstract SourceType getName();
    public abstract String getContent();
}
