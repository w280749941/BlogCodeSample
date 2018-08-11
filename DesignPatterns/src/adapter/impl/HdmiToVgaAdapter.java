package adapter.impl;

import adapter.HDMI;
import adapter.VGA;
import adapter.VideoAdapter;
import adapter.type.SourceType;

public class HdmiToVgaAdapter implements VideoAdapter<VGA, HDMI> {

    @Override
    public VGA videoSignalConversion(HDMI content) {

        return new VGA(content.getContent());
    }

    @Override
    public SourceType getInputType() {
        return SourceType.HDMI;
    }

    @Override
    public SourceType getOutputType() {
        return SourceType.VGA;
    }
}
