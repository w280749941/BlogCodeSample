package adapter.impl;

import adapter.VGA;
import adapter.VGAMonitor;
import adapter.VideoAdapter;
import adapter.VideoContent;
import adapter.type.SourceType;

public class MyMonitor implements VGAMonitor {

    private VideoContent content;
    private VideoAdapter videoAdapter;
    private final SourceType sourceType = SourceType.VGA;

    public MyMonitor(VideoContent content) {
        this.content = content;
    }

    private void play(VGA content){
        System.out.println(content.getName() + " is displaying " + content.getContent());
    }

    @Override
    public void setAdapter(VideoAdapter videoAdapter){
        this.videoAdapter = videoAdapter;
    }

    @Override
    public void setContent(VideoContent content){
        this.content = content;
    }

    @Override
    public void displayVGAContent() {
        if(this.content.getName() == SourceType.VGA){
            play((VGA) this.content);
            return;
        } else if(videoAdapter != null
            && content.getName() == videoAdapter.getInputType()
            && videoAdapter.getOutputType() == this.sourceType) {
                try{
                    VGA vgaOut = (VGA) videoAdapter.videoSignalConversion(this.content);
                    play(vgaOut);
                } catch (Exception ex){
                    System.out.println("Bad implementation of a videoAdapter");
                }
                return;
        }
        System.out.printf("This monitor doesn't support %s format, please provides a proper adapter\n", content.getName());
    }
}
