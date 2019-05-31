package simple_interfaces.views.logconsole;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ConsoleInterface extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea j_ta;
	private Console c;
	
	public ConsoleInterface()
	{
		this(false, false, 25);
	}
	
	public ConsoleInterface(boolean log, boolean catch_out_and_error, int max_lines)
	{
		configure_standard_panel();
		configure_standard_textarea();
		creates_console(max_lines);
		set_logging_mode(log, catch_out_and_error);
	}
	
	@Override
	public void setBounds(int x, int y, int width, int heigth)
	{
		Rectangle r = getBounds();
		
		super.setBounds(x, y, width, heigth);
		j_ta.setBounds(10, 10, (int)(j_ta.getBounds().getWidth() + (width - r.getWidth())), 
							   (int)(j_ta.getBounds().getHeight() + (heigth - r.getHeight())));
	}
	
	private void set_logging_mode(boolean log, boolean catch_out_and_error)
	{
		c.shouldLogFile(log);
		
		if(catch_out_and_error)
		{
			PrintStream ps = new PrintStream(c);
			
			System.setOut(ps);
			System.setErr(ps);
		}
	}

	private void creates_console(int max_lines)
	{
		c = new Console(j_ta, max_lines);
		c.shouldLogFile(false);
	}

	private void configure_standard_textarea()
	{
		j_ta = new JTextArea();
		j_ta.setBounds(10, 10, 290, 190);
		j_ta.setEnabled(false);
		add(j_ta);
	}

	private void configure_standard_panel()
	{
		super.setBounds(100, 100, 300, 200);
		setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		setLayout(null);
	}
}
