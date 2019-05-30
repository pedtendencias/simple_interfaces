package simple_interfaces.views.filechooser;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewImprovedFileChooser extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImprovedFileChooser ifc = new ImprovedFileChooser();
	private static JPanel main_panel; 
	
	public ViewImprovedFileChooser()
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
		
		ifc = new ImprovedFileChooser();
		main_panel.add(ifc);
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ViewImprovedFileChooser frame = new ViewImprovedFileChooser();
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
