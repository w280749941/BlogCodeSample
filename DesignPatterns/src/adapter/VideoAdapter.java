package adapter;

import adapter.type.SourceType;

public interface VideoAdapter<A,B> {

    A videoSignalConversion(B content);

    SourceType getInputType();

    SourceType getOutputType();
}
