import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ShockSkill extends AbstractSkill {

	ShockSkill()
	{
		setType(Type.LIGHT);
		setPower(100);
		setAccuracy(80);
		name = "Shock";
		
		try {
			setImage(ImageIO.read(new File("shock.png")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void launch(AbstractCharacter ch) {
		// TODO Auto-generated method stub
		// Animation
		ShockPanel p = new ShockPanel();
		p.setBounds(0, 300, 800, 300);
		ch.gs.add(p);
		
		// Get enemy position, decide the way for animation
		int pos = ch.getPostion();
		x = 0;
		y = -30;
		int shift = 6;
		if(pos == 1)	
		{
			shift = -6;
			x = 500;
		}
		// Start animation
		for(int i = 0 ; i < 80 ; i++)
		{
			x+=shift;
			p.repaint();
			try{
				Thread.sleep(50);
			}catch(Exception ex){}
		}
		
		
		// Different Type , different damage 
		double mul;
		if(ch.getType() == Type.DARK)
			mul = 1.5;
		else
			mul = 1;
		
		// Effect or not ?
		Random r = new Random();
		int randomNum = r.nextInt(100);
		int effect = 0;
		if(randomNum < getAccuracy())	effect = 1;
		
		// Calculate damage
		int damage;
		damage = (int)(getPower() * effect * mul);
		
		// Show message
		String message = "You use " + name + " and cause " + damage + "damage !";
		if(effect == 0)	message = "Enemy avoid the skill ! No damage...";
		JOptionPane.showMessageDialog(ch.gs,message);
		
		// Set Hp
		if( ch.getNowHP() - damage < 0)	 ch.setNowHP(0);
		else ch.setNowHP(ch.getNowHP() - damage);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	class ShockPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			//super.paintComponent(g);
			g.drawImage(getImage(), x, y, null);
		}
	}

}
