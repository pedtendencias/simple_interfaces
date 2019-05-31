package simple_interfaces.views.logconsole;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JTextArea;

/*
 * Took from https://stackoverflow.com/questions/342990/create-java-console-inside-a-gui-panel
 * 
 * Derive McNeill answer
 * */

/**
 * Represents a console viewable through a <code>JTextArea</code>.
 * 
 * <p>
 *  Implementation:
 *  <code>
 *      System.setOut(new PrintStream(new Console( ... )));
 *  </code>
 *  </p>
 * 
 * @author Derive McNeill
 *
 */
public class Console extends OutputStream 
{
    /**
     * Represents the data written to the stream.
     */
    ArrayList <Byte> data = new ArrayList<Byte>();

    /**
     * Represents the text area that will be showing the written data.
     */
    private JTextArea output;
    
    private FileOutputStream out;
    
    private int max_lines = 250;

    /**
     * Creates a console context.
     * @param output
     *      The text area to output the consoles text.
     */
    public Console(JTextArea output, int max_lines) 
    {
        this.output = output;
        this.max_lines = max_lines;
        out = null;
    }
    
    public void shouldLogFile(boolean v)
    {
    	if(v) try
		{
			out = new FileOutputStream(new File("./log.txt"));
		}
		catch (FileNotFoundException e)
		{
			out = null;
			e.printStackTrace();
		}
    	else
    	{
    		if(out != null) try
			{
				out.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
    		out = null;
    	}
    }

    @Override
    public void write(int i) throws IOException 
    {
        // Append the piece of data to our array of data.
        data.add((byte) i);
        
        if(out != null) out.write(i);

        // Indicate that data has just been written.
        fireDataWritten();
    }

    /**
     * Called when data has been written to the console.
     */
    private void fireDataWritten() 
    {
        // First we loop through our written data counting the lines.
        int lines = 0;
        
        for (int i = 0; i < data.size(); i++) 
        {
            byte b = data.get(i);

            // Specifically we look for 10 which represents "\n".
            if (b == 10)  lines++;

            // If the line count exceeds max_lines we remove older lines.
            // modified to a changeable value
            if (lines >= max_lines)
            {
            	lines = 0;
            	data = new ArrayList<Byte>(data.subList(i, data.size()));
            }
        }

        // We then create a string builder to append our text data.
        StringBuilder bldr = new StringBuilder();

        // We loop through the text data appending it to the string builder.
        for (byte b : data) bldr.append((char) b);

        // Finally we set the outputs text to our built string.
        output.setText(bldr.toString());
    }

	/**
	 * @return the out
	 */
	public FileOutputStream getOut()
	{
		return out;
	}

	/**
	 * @param out the out to set
	 */
	public void setOut(FileOutputStream out)
	{
		this.out = out;
	}
}