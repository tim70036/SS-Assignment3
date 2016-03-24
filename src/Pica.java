import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pica extends AbstractCharacter {
	
	Pica(GameStage g)
	{
		
		gs = g;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		setMAXHP(666);
		setNowHP(666);
		disActive();
		setType(Type.LIGHT);
		setSkill(new ShockSkill());
		try {
			setImage(ImageIO.read(new File("pica.jpg")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setName("Pica");
	}

}
