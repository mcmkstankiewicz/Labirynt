
public enum Direction {
	n("North"),s("South"),e("East"),w("West");
	
	private String directionDescrition;

	private Direction(String directionDescrition) {
		this.directionDescrition = directionDescrition;
	}

	public String getDirectionDescrition() {
		return directionDescrition;
	}
}
