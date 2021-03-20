package StudentenBeheerDatabase.rash;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Close extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2127418864898654787L;

	static boolean flag = true;
	
	int x = 10;
	int y = 45;
	
	int x1 = 460;
	int y1 = 45;
	
	int x2 = 10;
	int y2 = 460;
	
	int x3 = 460;
	int y3 = 460;

	int x4 = 10;
	int y4 = 250;
	
	int x5 = 460;
	int y5 = 250;

	int x6 = 233;
	int y6 = 460;

	int x7 = 233;
	int y7 = 45;
	int x8 = 233;
	int y8 = 45;

	public Close() {
		initComponents();

	}
	private void initComponents() {
		setTitle("Tot ziens!");
		getContentPane().setBackground(Color.WHITE); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(580, 560));
        this.setLocationRelativeTo(null);
        this.setBackground((Color.BLUE.brighter()));
        this.setVisible(true);
  
}

	private void moveBall() {
		x = x + 1;
		y = y + 1;
		x1 = x1 - 1;
		y1 = y1 + 1;
		x2 = x2 + 1;
		y2 = y2 - 1;
		x3 = x3 - 1;
		y3 = y3 - 1;
		x4 = x4 + 1;
		x5 = x5 - 1;
		y6 = y6 - 1;
		y7 = y7 + 1;
		if (x3 - 1 ==230) {
		

			System.exit(0);

		}
	}

	public void paint(Graphics g) {
		super.paint(g);
	    	Graphics2D g1d = (Graphics2D) g;
	    	Graphics2D g3d = (Graphics2D) g;
			Graphics2D g4d = (Graphics2D) g;
			Graphics2D g5d = (Graphics2D) g;
			Graphics2D g6d = (Graphics2D) g;
			Graphics2D g7d = (Graphics2D) g;
			Graphics2D g8d = (Graphics2D) g;
			Graphics2D g9d = (Graphics2D) g;

			g1d.setPaint(Color.CYAN);
			g1d.fillOval(x, y, 100, 100);
			g3d.setPaint(Color.ORANGE);
			g3d.fillOval(x1, y1, 100, 100);
			g4d.setPaint(Color.PINK);
			g4d.fillOval(x2, y2, 100, 100);
			g5d.setPaint(Color.RED);
			g5d.fillOval(x3, y3, 100, 100);
			g5d.setPaint(Color.magenta);
			g6d.fillOval(x4, y4, 100, 100);
			g5d.setPaint(Color.YELLOW);
			g7d.fillOval(x5, y5, 100, 100);
			g5d.setPaint(Color.GRAY);
			g8d.fillOval(x6, y6, 100, 100);
			g5d.setPaint(Color.BLUE);
			g9d.fillOval(x7, y7, 100, 100);
	    
	    	 Font font = new Font(Font.DIALOG_INPUT, Font.CENTER_BASELINE, 45);
	    	 String s = "      Groetjes van Rachid"; 
	    	  FontRenderContext frc = g1d.getFontRenderContext();
	         GlyphVector gv = font.createGlyphVector (frc, s);
	         int length = gv.getNumGlyphs ();
	         for (int i = 0; i < length; i++) {
	         Point2D p = gv.getGlyphPosition (i);
	         double theta = (double) i / (double) (length - 10) * Math.PI / 2;
	         AffineTransform at = AffineTransform.getTranslateInstance (p.getX (),
	             p.getY ());
	 
	         at.rotate (theta);
	         Shape glyph = gv.getGlyphOutline (i);
	         Shape transformedGlyph = at.createTransformedShape (glyph);
	         g1d.fill (transformedGlyph);
	         }

	        try {
		
			moveBall();
			repaint();
				Thread.sleep(10);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Fout!");
			}
		
	}
}




