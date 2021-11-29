import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Gra {

	public static void main(String[] args) {
		LocationRepository locationRepository = new LocationRepository();
		Menu.wyswietlMenu();
		String menu_choice = "";
		while(!menu_choice.equals("x")) {
			menu_choice = wczytajKomende();
			switch(menu_choice) {
			case "1":
				String imieGracza = podajImie();
				Player player = new Player(imieGracza, 40, 4, 20);
				player.setCurrentLocation(locationRepository.getStartLocation());
				System.out.println(player.getCurrentLocationDescrption());
				String command = "";
				while(!command.equals("x")) {
					command = wczytajKomende();
					CommandParser.actOnCommand(command, player);
				}
				break;
			case "2":
				System.out.println("Aby poruszaæ siê po labiryncie wpisz literê oznaczaj¹c¹ kierunek: np. n, s , e lub w.");
				System.out.println("Aby zaatakowaæ przeciwnika u¿yj komendy kill + nazwa przeciwnika np. kill goblin.");
				break;
			case "3":
				System.out.println("Koniec Gry");
				break;
			default:
				System.out.println("Blêdna komenda");
				break;	
			}
		}

		/*
		String imieGracza = podajImie();
		Player player = new Player(imieGracza, 40, 4, 20);
		player.setCurrentLocation(locationRepository.getStartLocation());
		System.out.println(player.getCurrentLocationDescrption());
		
		String command = "";
		while(!command.equals("x")) {
			command = wczytajKomende();
			CommandParser.actOnCommand(command, player);
		}
		*/
	}

	static String podajImie() {
		System.out.println("Podaj swoje imie:"); 
		Scanner s = new Scanner(System.in);
		String imie = s.nextLine();
		System.out.println("Witaj " + imie +".");
		return imie;
	}
	
	static String wczytajKomende() {
		System.out.print(">");
		Scanner s = new Scanner(System.in);
		String komenda = s.nextLine();
		System.out.println("Komenda: "+komenda);
		return komenda;
	}

}
