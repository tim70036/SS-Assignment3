import java.util.Random;

import javax.swing.JOptionPane;

public class ReproduceSkill extends AbstractSkill {
	
	ReproduceSkill()
	{
		setType(Type.DARK);
		setPower(100);
		setAccuracy(50);
		name = "Reproduce";
	}
	
	@Override
	public void launch(AbstractCharacter ch) {
		// TODO Auto-generated method stub
				// Different Type , different damage 
				double mul;
				if(ch.getType() == Type.LIGHT)
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
				String message = "You use Shock and cause " + damage + "damage !";
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

}
