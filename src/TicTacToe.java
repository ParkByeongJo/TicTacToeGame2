import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JPanel implements ActionListener {

	JButton[][] buttons=new JButton[3][3];
	private char turn='X';

	public TicTacToe() {
		this.setLayout(new GridLayout(3, 3, 5, 5));
		Font f=new Font("Dialog",Font.ITALIC, 50);
		//��ư�� ���� ������� ��ġ
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				buttons[i][j]=new JButton(" ");
				buttons[i][j].setFont(f);
				buttons[i][j].addActionListener(this);
				this.add(buttons[i][j]);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				//�ؽ�Ʈ�� " "�� ��ư�� Ŭ���Ǹ� ���忡 ǥ���Ѵ�.
				if(e.getSource()==buttons[i][j] && buttons[i][j].getText().equals(" ")==true) {
					//���� X�� �� �����̸� �� �κ��� �����Ѵ�.
					if(turn=='X') {
						buttons[i][j].setText("X");
						turn='O';
						if(checkWin("X",i,j))
							System.out.println("X�� �̱�!!");
						else if(isDraw())
							System.out.println("���!!");
					}
					else {
						buttons[i][j].setText("O");
						turn='X';
						if(checkWin("O",i,j))
							System.out.println("O�� �̱�!!");
						else if(isDraw())
							System.out.println("���!!");
					}
				}
			}
		}
	}

	/*������ �˻��ϴ� �޼ҵ�*/
	public boolean isDraw() {
		for(int row=0;row<3;++row) {
			for(int col=0;col<3;++col) {
				if(buttons[row][col].getText().equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}
	/*�̰���� �˻��ϴ� �޼ҵ�*/
	public boolean checkWin(String mark, int r, int c) {
		return (buttons[r][0].getText().equals(mark)
				&& buttons[r][1].getText().equals(mark)
				&& buttons[r][2].getText().equals(mark)
				|| buttons[0][c].getText().equals(mark)
				&& buttons[1][c].getText().equals(mark)
				&& buttons[2][c].getText().equals(mark)
				|| buttons[0][0].getText().equals(mark)
				&& buttons[1][1].getText().equals(mark)
				&& buttons[2][2].getText().equals(mark)
				|| buttons[0][2].getText().equals(mark)
				&& buttons[1][1].getText().equals(mark)
				&& buttons[2][0].getText().equals(mark));
	}
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new TicTacToe());
		f.setSize(300, 300);
		f.setVisible(true);
	}

}