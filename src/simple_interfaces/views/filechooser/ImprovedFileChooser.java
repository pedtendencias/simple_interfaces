package simple_interfaces.views.filechooser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ImprovedFileChooser extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField target_field;
	private JFileChooser file_chooser;
	private JButton activate_chooser_button;
	private JFrame file_chooser_frame;
	
	private List<File> files;
	
	public ImprovedFileChooser()
	{
		standard_frame();
		adds_textfield();
		adds_activate_chooser_button();
		adds_file_chooser_and_frame();
	}

	private void adds_file_chooser_and_frame()
	{
		file_chooser_frame = new JFrame();
		file_chooser_frame.setBounds(10, 10, 300, 300);
		file_chooser_frame.setBackground(Color.GRAY);
		file_chooser_frame.setVisible(false);
		
		file_chooser = new JFileChooser();
		file_chooser.setBounds(10, 10, 150, 150);
		file_chooser.setMultiSelectionEnabled(true);
		file_chooser.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				files = new ArrayList<File>();
				target_field.setText("");
				
				for(File f: file_chooser.getSelectedFiles())
				{
					files.add(f);
					target_field.setText(target_field.getText() + (target_field.getText().isEmpty() ? "" : ";") + f.getName());
				}
				
				target_field.updateUI();
				file_chooser_frame.setVisible(false);
				activate_chooser_button.setEnabled(true);
			}
		});
		
		file_chooser_frame.add(file_chooser);
	}

	private void adds_activate_chooser_button()
	{
		activate_chooser_button = new JButton("File..");
		activate_chooser_button.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				file_chooser_frame.setVisible(true);
				activate_chooser_button.setEnabled(false);
				
				if(files != null && !files.isEmpty()) 
					file_chooser.setSelectedFiles(files.toArray(new File[files.size()]));
			}
			
		});
		activate_chooser_button.setBounds(220, 10, 70, 20);
		add(activate_chooser_button);
	}

	private void adds_textfield()
	{
		target_field = new JTextField();
		target_field.setBounds(10, 10, 200, 20);
		add(target_field);
	}

	private void standard_frame()
	{
		setBounds(100, 100, 300, 200);
		setBackground(Color.GRAY);
		setLayout(null);
	}
}
