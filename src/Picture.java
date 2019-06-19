import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;

public class Picture {

	//static Image platform, ball;
	URL url;
	static GameIntro gd;
	static AudioClip music, bounce;
	static int level = 1;
	
	public Picture(GameIntro gd) {
		try {
			url = gd.getDocumentBase();
		}
		catch (Exception e) {
		}
		
		music = gd.getAudioClip(url, "pirate.wav");
		//bounce = sp.getAudioClip(url, "music/jump.au");
		
		//platform = sp.getImage(url, "images/platform.png");
		this.gd = gd;
	}
}