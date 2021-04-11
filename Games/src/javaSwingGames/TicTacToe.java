package javaSwingGames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class TicTacToe implements ActionListener {

	private JFrame frame;
	Random random = new Random();
	JPanel panel_title = new JPanel(); 
	JPanel panel_button = new JPanel();
	JLabel textField = new JLabel();
	JButton[] button = new JButton[9];
	boolean player1_turn;
	private final JButton btnReset = new JButton("Reset");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TicTacToe() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setVisible(true);
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free",Font.BOLD,75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		
		panel_title.setLayout(new BorderLayout());
		panel_title.setBounds(0, 0, 800, 100);
		panel_title.add(textField);
		frame.getContentPane().add(panel_title,BorderLayout.NORTH);
		btnReset.setForeground(Color.BLACK);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<9;i++) {
					button[i].setEnabled(true);
					//panel_button.setLayout(new GridLayout(3,3));
					//panel_button.setBackground(new Color(150,150,150));
					//button[i].setFont(new Font("MV Boli",Font.BOLD,120));
					//panel_button.setBackground(new Color(150,150,150));
					//button[i].setBackground(new Color(150,150,150));
					button[i].setBackground(Color.WHITE);
					button[i].setText("");					
				}
				textField.setText("Tic Tac Toe");
			}
		});
		
		btnReset.setBackground(Color.LIGHT_GRAY);		
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 22));		
		panel_title.add(btnReset, BorderLayout.EAST);
		
		panel_button.setLayout(new GridLayout(3,3));
		panel_button.setBackground(new Color(150,150,150));
		frame.getContentPane().add(panel_button);
		
		for(int i=0;i<9;i++) {
			button[i] = new JButton();
			panel_button.add(button[i]);
			button[i].setFont(new Font("MV Boli",Font.BOLD,120));
			button[i].setBackground(Color.WHITE);
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		
		firstTrun();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==button[i]) {
				if(player1_turn) {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(255,0,0));
						button[i].setText("X");
						player1_turn=false;
						textField.setText("O turn");
						check();
					}
				}else {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(0,0,255));
						button[i].setText("O");
						player1_turn=true;
						textField.setText("X turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void firstTrun() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textField.setText("X turn");
		}else {
			player1_turn=false;
			textField.setText("O turn");
		}
	}
	
	public void check() {
		if(
				(button[0].getText()=="X") &&
				(button[1].getText()=="X") &&
				(button[2].getText()=="X")
				){
			xWins(0,1,2);
		}
		if(
				(button[3].getText()=="X") &&
				(button[4].getText()=="X") &&
				(button[5].getText()=="X")
				){
			xWins(3,4,5);
		}
		if(
				(button[6].getText()=="X") &&
				(button[7].getText()=="X") &&
				(button[8].getText()=="X")
				){
			xWins(6,7,8);
		}
		if(
				(button[0].getText()=="X") &&
				(button[3].getText()=="X") &&
				(button[6].getText()=="X")
				){
			xWins(0,3,6);
		}
		if(
				(button[1].getText()=="X") &&
				(button[4].getText()=="X") &&
				(button[7].getText()=="X")
				){
			xWins(1,4,7);
		}
		if(
				(button[2].getText()=="X") &&
				(button[5].getText()=="X") &&
				(button[8].getText()=="X")
				){
			xWins(2,5,8);
		}
		if(
				(button[0].getText()=="X") &&
				(button[4].getText()=="X") &&
				(button[8].getText()=="X")
				){
			xWins(0,4,8);
		}
		if(
				(button[2].getText()=="X") &&
				(button[4].getText()=="X") &&
				(button[6].getText()=="X")
				){
			xWins(2,4,6);
		}
		
		//validation for O
		
		if(
				(button[0].getText()=="O") &&
				(button[1].getText()=="O") &&
				(button[2].getText()=="O")
				){
			oWins(0,1,2);
		}
		if(
				(button[3].getText()=="O") &&
				(button[4].getText()=="O") &&
				(button[5].getText()=="O")
				){
			oWins(3,4,5);
		}
		if(
				(button[6].getText()=="O") &&
				(button[7].getText()=="O") &&
				(button[8].getText()=="O")
				){
			oWins(6,7,8);
		}
		if(
				(button[0].getText()=="O") &&
				(button[3].getText()=="O") &&
				(button[6].getText()=="O")
				){
			oWins(0,3,6);
		}
		if(
				(button[1].getText()=="O") &&
				(button[4].getText()=="O") &&
				(button[7].getText()=="O")
				){
			oWins(1,4,7);
		}
		if(
				(button[2].getText()=="O") &&
				(button[5].getText()=="O") &&
				(button[8].getText()=="O")
				){
			oWins(2,5,8);
		}
		if(
				(button[0].getText()=="O") &&
				(button[4].getText()=="O") &&
				(button[8].getText()=="O")
				){
			oWins(0,4,8);
		}
		if(
				(button[2].getText()=="O") &&
				(button[4].getText()=="O") &&
				(button[6].getText()=="O")
				){
			oWins(2,4,6);
		}
	}
	
	public void xWins(int a,int b,int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textField.setText("X Win");
	}
	public void oWins(int a,int b,int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			button[i].setEnabled(false);
		}
		textField.setText("O Win");
	}	

}
