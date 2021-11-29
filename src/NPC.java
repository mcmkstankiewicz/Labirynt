
public class NPC {
	private String name;
	private Statistics stats;
	
	public NPC(String name, int health, int strength, int agility) {
	
		this.name = name;
		this.stats = new Statistics(health, strength, agility);
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return stats.getHealth();
	}

	public int getStrength() {
		return stats.getStrength();
	}
	public boolean IsAlive() {
		return stats.getHealth()>0;
	}

	public void damageTaken(int hit) {
		this.stats.setHealth(this.stats.getHealth()-hit);
	}

	public int getAgility() {
		return stats.getAgility();
	}
	
	
	
	
	

	
}
