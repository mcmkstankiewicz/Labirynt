import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Menu {
	public static void wyswietlMenu() {
		BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("Dialog", Font.PLAIN, 24));
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
		        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString("Menu", 10, 30);

		for (int y = 0; y < 32; y++) {
		    StringBuilder sb = new StringBuilder();
		    for (int x = 0; x < 144; x++)
		        sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
		    if (sb.toString().trim().isEmpty()) continue;
		    System.out.println(sb);
		}
		System.out.println("Wybierz opcjê podaj¹c odpowiedni numer: 1, 2 lub 3");
		System.out.println("#####################");
		System.out.println("# 1. Nowa Gra       #");
		System.out.println("# 2. Pomoc          #");
		System.out.println("# 3. Wyjœcie        #");
		System.out.println("#####################");
	}
	
}

