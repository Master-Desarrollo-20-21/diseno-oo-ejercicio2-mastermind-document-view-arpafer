package mastermind_documentview.views.graphics;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mastermind_documentview.utils.GestorIO;

public class RenderDevice {
    
    private static RenderDevice renderDevice;    
    private JFrame frame;
    private JTextField textField;
    private int row;

    public RenderDevice() {

    }
    public static RenderDevice getInstance() {
        if (RenderDevice.renderDevice == null) {
            RenderDevice.renderDevice = new RenderDevice();
            RenderDevice.renderDevice.frame = new JFrame();
            RenderDevice.renderDevice.configFrame();                         
            RenderDevice.renderDevice.row = 0;
        }
        return RenderDevice.renderDevice;
    }
    
    private void configFrame() {
        Container container = this.renderDevice.frame.getContentPane();
        container.setLayout(new GridBagLayout());
        renderDevice.frame.setSize(400, 500);
        renderDevice.frame.setLocationRelativeTo(null);
        renderDevice.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        renderDevice.frame.setVisible(true);
    }
    
    public void write(String message) {
        assert(message != null);               
        this.getContentPane().add(new JLabel(message), this.getPosition());       
        this.getContentPane().setVisible(true);
    }

    public void writeln() {                        
        this.getContentPane().add(new JLabel(""), this.getPosition());
        this.row++;    
        this.getContentPane().setVisible(true);
    }    
    
    public void refresh() {        
        this.renderDevice.frame.setVisible(true);
    }
            
    public void writeln(String message) {
        assert(message != null);               
        this.getContentPane().add(new JLabel(message), this.getPosition());
        this.row++;
        this.getContentPane().setVisible(true);
    }
    
    private Container getContentPane() {
        return renderDevice.frame.getContentPane();
    }
    
    private GridBagConstraints getPosition() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = this.row;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        return constraints;
    }
    private GridBagConstraints setPositionX(int posX) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = this.row;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        return constraints;
    }

    public String read(String message) {
        assert(message != null);        
        this.getContentPane().add(new JLabel(message), this.setPositionX(0));
        this.row++;
        this.textField = new JTextField(message);
        this.getContentPane().add(this.textField, this.setPositionX(1));    
        this.row++;
        this.getContentPane().setVisible(true);
       //  this.textField.addActionListener(new ActionListener() { this.onChangeTextField(); });
        return "";
    }
           
    public String read() {                
        this.getContentPane().add(new JTextField());        
        return "";
    }

    public String readRespond(String message) {
        
        return "";
    }
}
