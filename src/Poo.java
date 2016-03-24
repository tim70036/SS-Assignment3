import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.imageio.ImageIO;
import java.io.*;

public class Poo extends AbstractCharacter {

//	private int MAX_HP,now_HP;
//	private boolean isActive;
//	private Type type;
//	private Vector<AbstractSkill> skills = new Vector<AbstractSkill>();
//	private BufferedImage image;
//	protected GameStage gs;
	Poo(GameStage g)
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
		setType(Type.DARK);
		setSkill(new ReproduceSkill());
		
		try {
			setImage(ImageIO.read(new File("poo.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setName("Poo");
	}

}
