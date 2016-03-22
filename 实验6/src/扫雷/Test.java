package 扫雷;
/**
 * ����Ϊn*n������
 * ��n����
 */
import java.awt.Container;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
public class Test extends JFrame implements MouseListener{

	Container container=this.getContentPane();
	JButton [][]button;
	boolean [][]mine=null;
	private JLabel time;
	private boolean[][] isVisit;
	private int number=0;
	private int SIZEOFMINE=30;
	private int row;
	public static void main(String[] args) {
		Test test=new Test(new Point(100,50),20);
	}
	public Test(Point point,int row) {

		this.row=row;
		setLayout(null);
		setSize(row*SIZEOFMINE+200,row*SIZEOFMINE+31);
		setLocation(point);
		makeButton(this.row,this.row);
		mine=new boolean[this.row][this.row];
		createMine();
		isVisit=new boolean[this.row][this.row];
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JLabel label=new JLabel("已用时间：");
		label.setBounds(SIZEOFMINE*row+70, 50, 70, 50);
		container.add(label);
		time=new JLabel("as");
		time.setBounds(SIZEOFMINE*row+70, 70, 50, 50);
		time.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(time);
		thread.start();
	}
	Thread thread=new Thread(
			new Runnable() {
				public void run() {
					int s=0;
					while (true) {
						s++;
						time.setText(s+"s");
						System.err.println(s);
						try {
							thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
	public void  createMine() {
		int cou=0;
		while (true) {
			int x=(int)(Math.random()*row);
			int y=(int)(Math.random()*row);
			if(mine[x][y]==false)
			{
				mine[x][y]=true;
				cou++;
			}
			if (cou==row*2) {
				break;
			}
		}
	}
	public void  makeButton(int x,int y) {
		button=new JButton[x][y];
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				button[i][j]=new JButton();
				button[i][j].setName(i+"-"+j);
				button[i][j].addMouseListener(this);
				button[i][j].setBounds(1+i*SIZEOFMINE, 1+j*SIZEOFMINE, SIZEOFMINE,SIZEOFMINE);
				container.add(button[i][j]);
			}
		}
	}
	public void ds(int x,int y) {
		isVisit[x][y]=true;
		int cou=0;

		for(int i=y-1;i<=y+1;i++)
		{
			for(int j=x-1;j<=x+1;j++)
				if ((i<0||j<0)||(i>=row||j>=row)) {
					continue;
				}else {
					if(mine[j][i]==true)
					{
						cou++;
					}
				}
		}
		if(cou!=0)
		{
			button[x][y].setMargin(new Insets(0, 0, 0, 0));
			button[x][y].setText(cou+"");
			button[x][y].setEnabled(false);
			number++;
		}
		else {
			button[x][y].setText("");
			button[x][y].setEnabled(false);
			number++;
			for(int i=x-1;i<=x+1;i++)
			{
				for(int j=y-1;j<=y+1;j++)
				{
					if (i>=0&&i<row&&j>=0&&j<row&&!isVisit[i][j]&&!mine[i][j]) {
						ds(i, j);
					}
				}
			}			
		}
	}
	public void showMine()
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{
				if(mine[i][j])
				{
					button[i][j].setMargin(new Insets(0, 0, 0, 0));
					button[i][j].setText("X");
				}
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();  
		String[] tmp_str = ((JButton) obj).getName().split("-");  
		int x = Integer.parseInt(tmp_str[0]);  
		int y = Integer.parseInt(tmp_str[1]); 
		if(e.getButton()==1)
		{
			if(button[x][y].getText().equals("")&&mine[x][y]!=true)
			{
				ds(x, y);
				if (number==row*(row-1)) {
					showMine();
					thread.stop();
					JOptionPane.showMessageDialog(this, "你赢了!");
				}
			}
			else {
				showMine();
				thread.stop();
				JOptionPane.showMessageDialog(this, "你输了！");
			}
		}
		if(e.getButton()==3)
		{
			if(!button[x][y].getText().equals("*"))
			{
				button[x][y].setMargin(new Insets(0, 0, 0, 0));
				button[x][y].setText("*");
			}
			else {
				button[x][y].setText("");
			}
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
