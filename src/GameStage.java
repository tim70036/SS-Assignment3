import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameStage extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CharacterPanel ch1,ch2;
	private AbstractCharacter[] charaList;
	private int skill;
	public GameStage(){
		setLayout(null);
		setSize(1000,500);
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	@Override
	public void run(){
		// TODO Auto-generated method stub
		// Selecting Character
		int mType=JOptionPane.INFORMATION_MESSAGE;
		String[] option = {"Pica 生命：中 命中率：高 傷害：低(Light)", "Poo 生命：低 命中率：中 傷害：高(Dark)", "FatGuy 生命：高 命中率：低 傷害：高(Fire)"};
		String p1, p2;
		p1 = (String)JOptionPane.showInputDialog(this,"Please choose first player's character","Choose",mType,null,option,"Pica");
		p2 = (String)JOptionPane.showInputDialog(this,"Please choose first player's character","Choose",mType,null,option,"Pica");
		
		
		charaList = new AbstractCharacter[2];
		charaList[0] = choose(p1);
		charaList[1] = choose(p2);
		charaList[0].setPosition(1);
		charaList[1].setPosition(2);
		
		// Initialize
		charaList[0].initial();
		ch1 = new CharacterPanel(charaList[0],this);		
		ch1.setBounds(0, 0, 500, 500);
		add(ch1);
		charaList[1].initial();
		ch2 = new CharacterPanel(charaList[1],this);
		ch2.setBounds(500,0,500,500);
		add(ch2);
		setSkill(-1);
		charaList[0].setActive();
		charaList[1].disActive();
		ch1.update();
		ch2.update();
		
		int isEnding = 0,turn = 0;
		int state = 0;
		while(isEnding == 0){
			
			if(state == 0){	// attack phase
				if(skill != -1){
					state = 1;
				}
			}else if(state == 1){ //effect phase
				charaList[turn].getSkills().get(skill).launch(charaList[1-turn]);
				state = 2;
			}else if(state == 2){ //change phase
				setSkill(-1);
				turn = (1-turn);				
				charaList[turn].setActive();
				charaList[1-turn].disActive();
				ch1.update();
				ch2.update();
				state = 0;
				if(charaList[0].getNowHP() == 0){
					JOptionPane.showMessageDialog(this,charaList[1].getName()+
						    " wins the game.");
					isEnding = 1;
				}
				if(charaList[1].getNowHP() == 0){
					JOptionPane.showMessageDialog(this,charaList[0].getName()+
						    " wins the game.");
					isEnding = 1;
				}
			}
			this.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	public void setSkill(int num){
		skill = num;
	}
	
	public AbstractCharacter choose(String c)
	{
		AbstractCharacter re = null;
		if(c.equals("Pica 生命：中 命中率：高 傷害：低(Light)"))	re = new Pica(this);
		else if(c.equals("Poo 生命：低 命中率：中 傷害：高(Dark)")) re = new Poo(this);
		else if(c.equals("FatGuy 生命：高 命中率：低 傷害：高(Fire)")) re = new FatGuy(this);
		return re;	
	}
}
