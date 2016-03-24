import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FatGuy extends AbstractCharacter {
	
	FatGuy(GameStage g)
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
		setMAXHP(1000);
		setNowHP(1000);
		disActive();
		setType(Type.FIRE);
		setSkill(new HotDogSkill());
		try {
			setImage(ImageIO.read(new File("fatguy.jpg")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setName("FatGuy");
	}

}
