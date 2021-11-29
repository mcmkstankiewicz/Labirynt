import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {

	private String longDesc;
	private String shortDesc;
	private Map<Direction,Location> exit;
	private List<NPC> npcs;
	
	public Location(String shortDesc, String longDesc) {
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.exit = new HashMap<Direction,Location>(); //typy mo¿na pomin¹æ od javy 7
		this.npcs = new ArrayList<>();
	}

	public String getLongDesc() {
		return longDesc;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public String getDescrition() {
		return this.shortDesc + "\n" 
				+ this.longDesc + "\n" 
				+ "Visible exits: " + getExitString() +"\n"
				+ "Wrogowie: " + getNPCString();
		
	}

	private String getNPCString() {
		String result = "";
		for (NPC npc : this.npcs) {
			result = result + npc.getName()+ " ";
		}
		return result;
	}

	private String getExitString() {
		String exitsString = "";
		for (Direction d : exit.keySet()) {
			exitsString += d.getDirectionDescrition() + " ";
		}
		return exitsString;
	}

	public void addExit (Direction direction, Location location) {
		this.exit.put(direction, location);
	}

	public Location getNextLocation(Direction direction) {
		boolean istnieje = this.exit.containsKey(direction); //sprawdzamy czy istnieje wyjscie
		if (istnieje) {
			return this.exit.get(direction);
			
		}else {
			return null;
		}
	}
	
	public void addNPC(NPC npc) {
		this.npcs.add(npc);
	}

	boolean isThereNPC(String nameOfNPC) {
		for(NPC npc : this.npcs) {
			if (npc.getName().equalsIgnoreCase(nameOfNPC)) {
				return true;
			}
		}
		return false;
	}

	NPC getNPC(String nameOfNPC) {
		for(NPC npc : this.npcs) {
			if (npc.getName().equalsIgnoreCase(nameOfNPC)) {
				return npc;
			}
		}
		return null;
		
	}


	
}
