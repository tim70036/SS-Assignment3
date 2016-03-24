
public class ShockSkill extends AbstractSkill {

	ShockSkill()
	{
		setType(Type.LIGHT);
		setPower(100);
		setAccuracy(90);
		name = "Shock";
	}
	@Override
	public void launch(AbstractCharacter ch) {
		// TODO Auto-generated method stub
		double mul;
		int remain;
		if(ch.getType() == Type.DARK)
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
