package simple_interfaces.views.logconsole;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewConsoleInterface extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel main_panel; 
	private static ConsoleInterface console;
	
	public ViewConsoleInterface()
	{
		setBackground(Color.WHITE);
		setTitle("Atualizador de grandes volumes de planilha");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		
		main_panel = new JPanel();
		main_panel.setBackground(Color.WHITE);
		main_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main_panel);
		main_panel.setLayout(null);
		
		console = new ConsoleInterface(false, true, 11);
		main_panel.add(console);
		
		JButton b_1 = new JButton("ping");
		
		b_1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Ping");
			}
		});
		b_1.setBounds(10, 300, 50, 25);
		main_panel.add(b_1);
		
		JButton b_2 = new JButton("pong");
		
		b_2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Pong");
			}
		});
		b_2.setBounds(10, 360, 50, 25);
		main_panel.add(b_2);
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ViewConsoleInterface frame = new ViewConsoleInterface();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}
