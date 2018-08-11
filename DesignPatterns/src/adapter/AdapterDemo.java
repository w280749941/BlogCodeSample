package adapter;

import adapter.impl.HdmiToVgaAdapter;
import adapter.impl.MyMonitor;

public class AdapterDemo {

    public static void main(String[] args) {
        VGA vgaConent = new VGA("A movie in VGA");
        HDMI hdmiContent = new HDMI("B movie in HDMI");

        VGAMonitor myMonitor = new MyMonitor(vgaConent);
        myMonitor.displayVGAContent();
        myMonitor.setContent(hdmiContent);
        myMonitor.displayVGAContent();

        VideoAdapter videoAdapter = new HdmiToVgaAdapter();
        myMonitor.setAdapter(videoAdapter);
        myMonitor.displayVGAContent();
    }
}
