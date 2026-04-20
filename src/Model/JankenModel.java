package Model;

public class JankenModel {
	public Hand getCpuHand() {
		Hand[] hands=Hand.values();
		int i=(int)(Math.random()*hands.length);
		return hands[i];
	}
	
	public Result judge(Hand player,Hand cpu) {
		if(player==cpu) return Result.DRAW;
		
		switch(player) {
			case GU:
				return (cpu==Hand.CHOKI)?Result.WIN:Result.LOSE;
			case CHOKI:
				return (cpu==Hand.PA)?Result.WIN:Result.LOSE;
			case PA:
				return (cpu==Hand.CHOKI)?Result.WIN:Result.LOSE;
		}
		return Result.DRAW;
	}
}
