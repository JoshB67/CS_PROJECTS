package maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.WindowConstants;

import graph.GraphAlgorithmObserver;
import graph.MazeGraph;

/**
 * <P>The MazeGUI class allows the user to create
 * and display mazes.  It relies on an underlying 
 * MazeGraph, which stores the maze as a Graph, and 
 * can perform various algorithms (DFS, BFS, and 
 * Dijsktra.)</P>
 *
 * @author Fawzi Emad (C) 2016
 */
public class MazeGUI {

	private Maze maze;
	private MazeGraph theGraph;

	/* Containers */
	private JPanel contentPane;
	private JFrame window;
	private JPanel controlsPanel;
	private JPanel mazePanel;

	/* Widgets */
	private JButton drawButton;
	private JLabel widthLabel, heightLabel;
	private JFormattedTextField widthBox, heightBox;
	private JButton DFSButton;
	private JButton BFSButton;
	private JButton DijkstraButton;
	private JSlider speedSlider;
	private JSlider densitySlider;
	private JCheckBox showWeights;

	/* GUI style */
	private final Color WALL_COLOR = Color.BLACK;
	private static int STROKE_WIDTH;
	private final Color[] squareColors = {Color.GRAY, Color.RED, Color.GREEN, Color.BLUE, Color.PINK, 
			Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.WHITE, Color.BLACK};
	
	/* Used during searches */
	private int[][] colorIndex;
	private Collection<Juncture> coloredJunctures;
	private boolean isDFS;

	/** Creates and displays the GUI; constructs 
	 * a maze to start things off.
	 */
	public MazeGUI() {
		createAndDisplayGUI();
		makeNewMaze();
	}
	
	private void createAndDisplayGUI() {
		widthLabel = new JLabel("Width");
		heightLabel = new JLabel("Height");
		drawButton = new JButton("New Maze");
		DijkstraButton = new JButton("Dijkstra");
		densitySlider = new JSlider();
		DFSButton = new JButton("DFS");
		BFSButton = new JButton("BFS");
		showWeights = new JCheckBox("Weights");
		drawButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				makeNewMaze();
				speedSlider.requestFocusInWindow();
			}
		});
		DijkstraButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				changeButtonStatus(false);
				showWeights.setSelected(true);
				Thread thread = new Thread(new Runnable() {
					public void run() {
						theGraph.DoDijsktra(new Juncture(0,0), new Juncture(maze.getMazeWidth() - 1, maze.getMazeHeight() - 1));
					}
				});
				thread.start();
			}

		});
		DFSButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showWeights.setSelected(false);
				changeButtonStatus(false);
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						theGraph.DoDFS(new Juncture(0,0), 
								new Juncture(maze.getMazeWidth() - 1, maze.getMazeHeight() - 1));
					}
				});
				thread.start();
			}
		});

		BFSButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changeButtonStatus(false);
				showWeights.setSelected(false);
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {
						theGraph.DoBFS(new Juncture(0,0), 
								new Juncture(maze.getMazeWidth() - 1, maze.getMazeHeight() - 1));
					}
				});
				thread.start();
			}
		});
		showWeights.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mazePanel.updateUI();
			}
		});
		speedSlider = new JSlider();
		speedSlider.setValue(40);
		NumberFormat nf = NumberFormat.getIntegerInstance();
		nf.setMaximumFractionDigits(0);
		widthBox = new JFormattedTextField(nf);
		widthBox.setColumns(3);
		widthBox.setText("60");
		widthBox.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				widthBox.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});

		heightBox = new JFormattedTextField(nf);
		heightBox.setColumns(3);
		heightBox.setText("30");
		heightBox.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				heightBox.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});

		controlsPanel = new JPanel();
		controlsPanel.add(widthLabel);
		controlsPanel.add(widthBox);
		controlsPanel.add(heightLabel);
		controlsPanel.add(heightBox);
		controlsPanel.add(new JLabel("   Density"));
		densitySlider.setValue(100);
		controlsPanel.add(densitySlider);
		controlsPanel.add(drawButton);
		controlsPanel.add(showWeights);
		controlsPanel.add(DFSButton);
		controlsPanel.add(BFSButton);
		controlsPanel.add(DijkstraButton);
		controlsPanel.add(new JLabel("   Speed"));
		controlsPanel.add(speedSlider);

		mazePanel = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				int height = maze.getMazeHeight() + 1;
				int width = maze.getMazeWidth() + 1;
				int paneWidth = getWidth();
				int paneHeight = getHeight();
				double widthMultiplier = (double)(paneWidth) / (width + 1);
				double heightMultiplier = (double)(paneHeight) / (height + 1);
				STROKE_WIDTH = (int)(widthMultiplier / 10);
				if (STROKE_WIDTH < 2) {
					STROKE_WIDTH = 2;
				}
				g.setColor(Color.GREEN);
				g.fillRect((int)(STROKE_WIDTH + widthMultiplier), (int)(STROKE_WIDTH + heightMultiplier),
						(int)widthMultiplier, (int)heightMultiplier);
				g.setColor(Color.RED);
				g.fillRect((int)(STROKE_WIDTH + (width - 1) * widthMultiplier), (int)(STROKE_WIDTH + (height - 1) * heightMultiplier),
						(int)widthMultiplier, (int)heightMultiplier);

				for (int row = 0; row < height - 1; row++) {
					for (int col = 0; col < width - 1; col++) {
						g.setColor(squareColors[colorIndex[row][col]]);
						g.fillRect((int)((col + 1.3) * widthMultiplier) + STROKE_WIDTH / 2, (int)((row + 1.3) * heightMultiplier) + STROKE_WIDTH / 2,
								(int)(widthMultiplier * 0.4) + STROKE_WIDTH / 2, (int)(heightMultiplier * 0.4) + STROKE_WIDTH / 2); 
					}
				}
				g.setColor(WALL_COLOR);
				for (int row = 0; row < height - 1; row++) {
					for (int col = 0; col < width - 1; col++) {
						if (maze.isWallAbove(new Juncture(col, row))) {
							drawHorizontalLine(g, (int)((col + 1) * widthMultiplier), (int)((row + 1) * heightMultiplier),
									(int)((col + 2) * widthMultiplier));						
						}
						if (maze.isWallToLeft(new Juncture(col, row))) {
							drawVerticalLine(g, (int)((col + 1) * widthMultiplier),  (int)((row + 1) * heightMultiplier),
									(int)((row + 2) * heightMultiplier));
						}
					}
				}
				for (int x = 1; x < width; x++) { 
					for (int y = 1; y < height; y++) {
						int a = (int)(x * widthMultiplier);
						int b = (int)(y * heightMultiplier);
						for (int i = a; i <= a + STROKE_WIDTH; i++) {
							g.drawLine(i, b, i, b + STROKE_WIDTH);
						}
					}
				}
				for (int row = 0; row < height - 1; row++) {
					if (maze.isWallToRight(new Juncture(width - 2, row))) {
						int col = width - 1;
						drawVerticalLine(g, (int)((col + 1) * widthMultiplier),  (int)((row + 1) * heightMultiplier),
								(int)((row + 2) * heightMultiplier));
					}
				}
				for (int col = 0; col < width - 1; col++) {
					if (maze.isWallBelow(new Juncture(col, height - 2))) {
						int row = height - 1;
						drawHorizontalLine(g, (int)((col + 1) * widthMultiplier), (int)((row + 1) * heightMultiplier),
								(int)((col + 2) * widthMultiplier));
					}
				}
				g.setFont(new Font("Arial", Font.BOLD, (int)(0.5 * heightMultiplier)));
				if (showWeights.isSelected()) {
					g.setColor(Color.BLACK);
					for (int row = 0; row < height - 2; row++) {
						for (int col = 0; col < width - 1 ; col++) {
							Juncture juncture = new Juncture(col, row);
							if (!maze.isWallBelow(juncture)) {
								g.drawString(String.valueOf(maze.getWeightBelow(juncture)), (int)((col + 1.37) * widthMultiplier + STROKE_WIDTH), (int)((row + 2.15) * heightMultiplier + STROKE_WIDTH));
							}
						}
					}
					for (int row = 0; row < height - 1; row++) {
						for (int col = 0; col < width - 2; col++) {
							Juncture juncture = new Juncture(col, row);
							if (!maze.isWallToRight(juncture)) {
								g.drawString(String.valueOf(maze.getWeightToRight(juncture)), (int)((col + 1.85) * widthMultiplier + STROKE_WIDTH), (int)((row + 1.65) * heightMultiplier + STROKE_WIDTH));
							}
						}
					}
				}
			}
		};
		
		mazePanel.setBackground(Color.GRAY);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(mazePanel, BorderLayout.CENTER);
		contentPane.add(controlsPanel, BorderLayout.NORTH);

		window = new JFrame();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setContentPane(contentPane);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.pack();
		speedSlider.requestFocusInWindow();
		window.setVisible(true);
	}

	private void changeButtonStatus(boolean setting) {
		DFSButton.setEnabled(setting);
		BFSButton.setEnabled(setting);
		drawButton.setEnabled(setting);
		DijkstraButton.setEnabled(setting);
	}
	
	private int getSliderDelayMS() {
		int v = 109 - speedSlider.getValue();
		return (v * v * v) / 1000;
	}

	private void drawHorizontalLine(Graphics g, int x1, int y, int x2) {
		for (int j = y; j <= y + STROKE_WIDTH; j++) {
			g.drawLine(x1, j, x2 + STROKE_WIDTH, j);
		}
	}

	private void drawVerticalLine(Graphics g, int x, int y1, int y2) {
		for (int i = x; i <= x + STROKE_WIDTH; i++) {
			g.drawLine(i, y1, i, y2 + STROKE_WIDTH);
		}
	}

	private void makeNewMaze() {
		int height = Integer.parseInt(heightBox.getText());
		int width = Integer.parseInt(widthBox.getText());
		maze = new Maze(height, width, 100 - densitySlider.getValue());
		colorIndex = new int[height][width];
		resetColorsOfSquares();
		theGraph = new MazeGraph(maze);
		theGraph.addObserver(new GraphAlgorithmObserver<Juncture>() {
			@Override
			public void notifyBFSHasBegun() {
				coloredJunctures = new ArrayList<Juncture>();
				resetColorsOfSquares();
				isDFS = false;
			}

			@Override
			public void notifyDFSHasBegun() {
				coloredJunctures = new Stack<Juncture>();
				resetColorsOfSquares();
				isDFS = true;
			}

			@Override
			public void notifyDijkstraHasBegun() {
				coloredJunctures = new Stack<Juncture>();
				resetColorsOfSquares();
			}

			@Override
			public void notifySearchIsOver() {
				changeButtonStatus(true);
				controlsPanel.updateUI();
			}

			@Override
			public void notifyDijkstraVertexFinished(Juncture p, Integer pathCost) {
				colorIndex[p.getY()][p.getX()] = 5;
				mazePanel.updateUI();
				try {
					Thread.sleep(getSliderDelayMS());
				} catch(InterruptedException e) {

				}
			}
			
			@Override
			public void notifyDijkstraIsOver(List<Juncture> path) {
				for (int i = 0; i < maze.getMazeHeight(); i++) {
					for (int j = 0; j < maze.getMazeWidth(); j++) {
						colorIndex[i][j] = 0;
					}
				}
				for (Juncture p : path) {
					colorIndex[p.getY()][p.getX()] = 3;
				}
				changeButtonStatus(true);
				mazePanel.updateUI();
			}

			@Override
			public void notifyVisit(Juncture juncture) {
				if (isDFS) {
					/* Go through and remove all of the points from the end
					 * of the path back to the last point that was adjacent
					 * to this one
					 */
					while(!coloredJunctures.isEmpty()) {
						Juncture p = ((Stack<Juncture>)coloredJunctures).peek();
						if (theGraph.getWeight(p, juncture) != null) {
							break;
						}
						colorIndex[p.getY()][p.getX()] = 0;
						mazePanel.updateUI();
						try {
							Thread.sleep(getSliderDelayMS());
						} catch(InterruptedException e) {

						}
						((Stack<Juncture>)coloredJunctures).pop();
					}

					colorIndex[juncture.getY()][juncture.getX()] = 3;
					mazePanel.updateUI();
					try {
						Thread.sleep(getSliderDelayMS());
					} catch(InterruptedException e) {

					}
					((Stack<Juncture>)coloredJunctures).push(juncture);
				} else {   // BFS
					int c = 1;
					for (int i = coloredJunctures.size() - 1; i >=0; i--) {
						Juncture p = ((ArrayList<Juncture>)coloredJunctures).get(i);

						if (theGraph.getWeight(p, juncture) != null) {

							int old = colorIndex[p.getY()][p.getX()];
							c = old + 1;
							if (c >= squareColors.length) {
								c = 1;
							}
							break;
						}
					}
					colorIndex[juncture.getY()][juncture.getX()] = c;
					mazePanel.updateUI();
					try {
						Thread.sleep(getSliderDelayMS());
					} catch(InterruptedException e) {

					}
					coloredJunctures.add(juncture);
				}
			}

		});
		DFSButton.setEnabled(true);
		BFSButton.setEnabled(true);
		controlsPanel.updateUI();
	}

	private void resetColorsOfSquares() {
		for (int row = 0; row < maze.getMazeHeight(); row++) {
			for (int col = 0; col < maze.getMazeWidth(); col++) {
				colorIndex[row][col] = 0;
			}
		}
		mazePanel.updateUI();
	}

	/** Request to the Event Dispatching Thread to create and
	 * display this GUI.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MazeGUI();
			}
		});

	}
}
