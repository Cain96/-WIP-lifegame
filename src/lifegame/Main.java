package lifegame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * Created by kuro on 2016/10/13.
 */
public class Main implements Runnable {
	private static Settings settings;

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Main());
	}

	public void run() {
		settings = new Settings();
		BoardModel model = new BoardModel(settings.getCols(), settings.getRows());
		model.addlistener(new ModelPrinter());

		model.changeCellState(1, 1);
		model.changeCellState(2, 2);
		model.changeCellState(0, 3);
		model.changeCellState(1, 3);
		model.changeCellState(2, 3);
		model.changeCellState(4, 4);
		model.changeCellState(4, 4);

		//ウィンドウの作成
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Lifegame");

		//ウィンドウ内部のベースパネルの作成
		JPanel base = new JPanel();
		frame.setContentPane(base);
		frame.setPreferredSize(new Dimension(400, 300)); //希望サイズの指定
		frame.setMinimumSize(new Dimension(300, 200)); //最小サイズの指定

		base.setLayout(new BorderLayout());
		BoardView view = new BoardView(new Settings());
		BoardView view = new BoardView(new Settings(), model);
		base.add(view, BorderLayout.CENTER); //baseの中心にviewを配置

		frame.pack();
		frame.setVisible(true);
	}
}
