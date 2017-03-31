package intermidia;

import java.io.File;

import org.openimaj.image.ImageUtilities;
import org.openimaj.video.xuggle.XuggleVideo;


public class VideoSlicer 
{
    public static void main( String[] args ) throws Exception 
    {
    	XuggleVideo input = new XuggleVideo(new File(args[0]));
    	
   	
    	int fs = 0;
    	while(input.hasNextFrame() && fs++ < 100)
    	{
    		if(input.nextFrameIsKeyFrame == true)
    		{
    			input.getNextFrame();
    			System.out.println("KF" + input.getCurrentFrameIndex());
    		}
    		else
    		{
    			input.getNextFrame();
    			System.out.println(input.getCurrentFrameIndex());    			
    		}
    		ImageUtilities.write(input.getCurrentFrame().getImage(), new File("fs/" + fs + ".jpg"));
    	}
    	input.close();
    }
}
