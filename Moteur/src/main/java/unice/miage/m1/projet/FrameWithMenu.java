package unice.miage.m1.projet;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Action;
import javax.swing.border.EmptyBorder;


public class FrameWithMenu {
	
	FenetreF frame;
	
	public FrameWithMenu() {
			this.frame = new FenetreF();
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			frame.setContentPane(contentPane);
			this.buildMenu();
	}

	private JPanel contentPane;

	@SuppressWarnings("serial")
	void buildMenu() {
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		JMenu fileM = new JMenu("Fichier");
		bar.add(fileM);
		fileM.add(new AbstractAction("Save", new ImageIcon("res/save-icon16.png")) {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("DoSaveAction:" + arg0);
			}

			@Override
			public Object getValue(String arg0) {
				if (arg0 == Action.ACCELERATOR_KEY) // cannot be changed later
													// (use putValue when
													// possible - not anonymous)
					return KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
				return super.getValue(arg0);
			}
		});
	}

	public static void main(String[] args) {
		new FrameWithMenu().buildMenu();
	}
}
