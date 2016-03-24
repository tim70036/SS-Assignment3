
public class ReproduceSkill extends AbstractSkill {
	
	ReproduceSkill()
	{
		setType(Type.DARK);
		setPower(100);
		setAccuracy(90);
		name = "Reproduce";
	}
	
	@Override
	public void launch(AbstractCharacter ch) {
		// TODO Auto-generated method stub
		double mul;
		int remain;
		if(ch.getType() == Type.LIGHT)
			mul = 1.5;
		else
			mul = 1;
		remain = ch.getNowHP() - (int)(getPower() * getAccuracy() / 100 * mul);
		if(remain < 0)	remain = 0;
		ch.setNowHP(remain);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
