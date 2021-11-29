
public class CommandParser {

	public static void wyborMenu(String menu_choice) {
		
		
	}
	public static void actOnCommand(String command, Player player) {
		command = command.toLowerCase();
		String[] sp = command.split(" "); //dzielimy stinga na tab stringow np. sp[0]=kill sp[1] =goblin
		switch (sp[0]) {
		case "n":
			move(Direction.n, player);
			break;
		case "s":
			move(Direction.s, player);
			break;
		case "e":
			move(Direction.e, player);
			break;
		case "w":
			move(Direction.w, player);
			break;
		case "kill":
			attack(sp[1], player);
			break;
		case "x":
			System.out.println("koniec gry");
			break;
		default:
			System.out.println("Bledna komenda");
			break;
		}
	}
	private static void attack(String target, Player player) {
		NPC targetNPC = player.getNearbyNPC(target);
		if(target!=null) {
			beginCombat(player,targetNPC);
		}else {
			System.out.println("There is no one around");
		}
		
	}

	private static void beginCombat(Player player, NPC targetNPC) {
		//FightStrategy fs = new ClassicFightStrategy();
		FightStrategy fs = new AgilityFightStrategy();
		FightThread ft = new FightThread(player, targetNPC, fs);
		Thread t = new Thread(ft);
		t.start();
	}


	
	private static void move(Direction direction, Player player) {
		boolean hasMoved = player.move(direction);
		if (hasMoved) {
			System.out.println(player.getCurrentLocationDescrption());
		}else {
			System.out.println("Nie mo¿esz przejsc");
		}
		
	}
}
