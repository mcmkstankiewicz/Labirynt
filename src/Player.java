
public class Player {
	private String name;
	private Location currentLocation;
	private Statistics stats;
	
	public Player(String name) {
		this.name = name;
		this.stats = new Statistics(50,6,20);
	}
	

	public Player(String name, int health, int strength, int agility) {
		this.name = name;
		this.stats = new Statistics(health, strength, agility);
	}


	public String getName() {
		return name;
	}

	public Location getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Location location) {
		this.currentLocation = location;
		
	}
	

	public String getCurrentLocationDescrption() {
		return this.currentLocation.getDescrition();
	}

	public boolean move(Direction direction) {
		Location nextLocation = this.currentLocation.getNextLocation(direction);
		if (nextLocation!=null) {
			this.currentLocation = nextLocation;
			return true;
		}else {
			return false;
		}
	}


	public NPC getNearbyNPC(String nameOfNPC) {
		return this.currentLocation.getNPC(nameOfNPC);
	}


	public boolean IsAlive() {
		return stats.getHealth()>0;
	}


	public int getHealth() {
		return stats.getHealth();
	}


	public int getStrength() {
		return stats.getStrength();
	}


	public void damageTaken(int hit) {
		this.stats.setHealth(this.stats.getHealth()-hit);	
	}


	public boolean IsThereNPCNearby(NPC targetNPC) {
		return this.currentLocation.isThereNPC(targetNPC.getName());
		
	}


	public int getAgility() {
		return stats.getAgility();
	}






}
