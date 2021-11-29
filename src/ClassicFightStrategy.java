import java.util.Random;

public class ClassicFightStrategy implements FightStrategy {

	public ClassicFightStrategy() {
		
	}

	@Override
	public void fight(Player player, NPC targetNPC) {
		int hit = 0;
		while(player.IsAlive() && targetNPC.IsAlive()) {
			boolean targetStillHere = player.IsThereNPCNearby(targetNPC);
			if(!targetStillHere) {
				System.out.println("Target is no longer here");
				return;
			}
			try {
				hit = calculateHitStrength(player.getStrength());
				showHitMessageP(targetNPC,hit);
				targetNPC.damageTaken(hit);
				Thread.sleep(1500);
				hit = calculateHitStrength(targetNPC.getStrength());	
				showHitMessageE(hit);
				player.damageTaken(hit);
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		if (player.IsAlive() && !targetNPC.IsAlive()) {
			System.out.println("Enemy Defeated");
		}else if (!player.IsAlive() && targetNPC.IsAlive()) {
			System.out.println("You have been defeated");
		}else {
			System.out.println("You ran awa fom a fight");
		}
		
	} 
	private  void showHitMessageP(NPC targetNPC, int hit) {
		System.out.println("You hit " + targetNPC.getName() + " for " + hit + " damage" );		
	}
	
	private  void showHitMessageE(int hit) {
		System.out.println("You are hit for " + hit + " damage" );		
	}

	private  int calculateHitStrength(int strength) {
		Random r = new Random();
		return strength + r.nextInt(4);
	}

}
