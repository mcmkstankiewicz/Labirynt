import java.util.Random;

public class AgilityFightStrategy implements FightStrategy {

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
				if(calculateHitChanceP(player, targetNPC)) {
					hit = calculateHitStrength(player.getStrength());
					showHitMessageP(targetNPC,hit);
					targetNPC.damageTaken(hit);
				}else {
					System.out.println("You didn't hit enemy" + targetNPC.getName());
				}
				Thread.sleep(1500);
				if(calculateHitChanceE(targetNPC, player)) {
					hit = calculateHitStrength(targetNPC.getStrength());	
					showHitMessageE(hit);
					player.damageTaken(hit);
				}else {
					System.out.println(targetNPC.getName()+" missed you");
				}
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
	private boolean calculateHitChanceP(Player player, NPC targetNPC) {
		int rand = new Random().nextInt(20);
		return (targetNPC.getAgility()+rand)>player.getAgility();
	}
	private boolean calculateHitChanceE(NPC targetNPC, Player player) {
		int rand = new Random().nextInt(20);
		return (player.getAgility()+rand)>targetNPC.getAgility();
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


