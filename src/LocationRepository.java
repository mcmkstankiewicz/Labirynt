

public class LocationRepository {
	
	private Location startLoc;
	
	public LocationRepository() {
		startLoc = new Location("Ma³a Komnata", "Jesteœ w malo oœwietlonej murowanej komnacie");
		Location secondLoc = new Location("Ciemny Korytarz", "Ciemnoœæ prowadzi w dó³ jaskini");
		Location thirdLoc = new Location("Opis komnaty", "D³ugi opis");
		Location fourthLoc = new Location("Opis komnaty", "D³ugi opis");
		Location firstDeadEnd = new Location("Œlepy zau³ek", "Nic tu nie ma musisz zawrociæ");
		Location fifthLoc = new Location("Opis komnaty", "D³ugi opis");
		Location sixthLoc = new Location("Opis komnaty", "D³ugi opis");
		Location seventhLoc = new Location("Opis komnaty", "D³ugi opis");
		Location secondDeadEnd = new Location("Œlepy zau³ek", "Nic tu nie ma musisz zawrociæ");
		Location eighthLoc = new Location("Opis komnaty", "D³ugi opis");
		Location ninthLoc = new Location("Opis komnaty", "D³ugi opis");
		Location tenthLoc = new Location("Opis komnaty", "D³ugi opis");
		Location thirdDeadEnd = new Location("Œlepy zau³ek", "Nic tu nie ma musisz zawrociæ");
		Location eleventhLoc = new Location("Opis komnaty", "D³ugi opis");
		Location tvelvethLoc = new Location("Opis komnaty", "D³ugi opis");
		Location exitLoc = new Location("Opis komnaty", "D³ugi opis");
		Location outsideLoc = new Location("Widzisz œwiat³o", "Brawo!!! Uda³o ci siê uciec z labiryntu zwyciêstwo. Nacisnij x aby wyjsc z gry");
		
		startLoc.addExit(Direction.w, secondLoc);
		
		secondLoc.addExit(Direction.e, startLoc);
		secondLoc.addExit(Direction.n, thirdLoc);
		
		thirdLoc.addExit(Direction.w, fourthLoc);
		thirdLoc.addExit(Direction.e, fifthLoc);
		thirdLoc.addExit(Direction.s, secondLoc);
		
		fourthLoc.addExit(Direction.e, thirdLoc);
		fourthLoc.addExit(Direction.s, firstDeadEnd);
		
		firstDeadEnd.addExit(Direction.n, fourthLoc);
		
		fifthLoc.addExit(Direction.w, thirdLoc);
		fifthLoc.addExit(Direction.n, sixthLoc);
		
		sixthLoc.addExit(Direction.s, fifthLoc);
		sixthLoc.addExit(Direction.n, seventhLoc);
		sixthLoc.addExit(Direction.w, tenthLoc);
		sixthLoc.addExit(Direction.e, eighthLoc);
		
		seventhLoc.addExit(Direction.s, sixthLoc);
		seventhLoc.addExit(Direction.e, secondDeadEnd);
		
		secondDeadEnd.addExit(Direction.w, seventhLoc);
		
		eighthLoc.addExit(Direction.w, sixthLoc);
		eighthLoc.addExit(Direction.s, ninthLoc);
		
		ninthLoc.addExit(Direction.n, eighthLoc);
		ninthLoc.addExit(Direction.s, thirdDeadEnd);
		
		thirdDeadEnd.addExit(Direction.n, ninthLoc);
		
		tenthLoc.addExit(Direction.e, sixthLoc);
		tenthLoc.addExit(Direction.w, eleventhLoc);
		
		eleventhLoc.addExit(Direction.e, tenthLoc);
		eleventhLoc.addExit(Direction.n, tvelvethLoc);
		
		tvelvethLoc.addExit(Direction.s, eleventhLoc);
		tvelvethLoc.addExit(Direction.e, exitLoc);
		
		exitLoc.addExit(Direction.w, tvelvethLoc);
		exitLoc.addExit(Direction.n, outsideLoc);
		
		NPC minotaur = new NPC("Minotaur", 25, 2, 10);
		exitLoc.addNPC(minotaur);
	}

	public Location getStartLocation() {
		return this.startLoc;
	}
	
	
}
