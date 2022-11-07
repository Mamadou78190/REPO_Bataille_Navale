package BN_View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.FlowView;

public class Window extends JFrame {
    
    public Window()
    {
        super("WarShip game of Aziz");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(300, 300);
        this.setExtendedState(MAXIMIZED_BOTH);
        // this.setLocationRelativeTo(null); //Positionne la fenetre au milieu du bureau (null)
        JPanel header = new JPanel();
        JPanel contentPanel = (JPanel) this.getContentPane();
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));


        // Put this call in Controler or Model
        JLabel Titre = new JLabel("WarShip game of ECE");
        Titre.setSize(400, 200);
        header.add(Titre, BorderLayout.NORTH);

        JButton btnStart = new JButton ( "Start New Game" );
        JButton btnLoad = new JButton ( "Load Game" );
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ///////////////////////////////////////////////////////

        // contentPanel.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 10));
        btnStart.setPreferredSize(new Dimension(300,40));
        contentPanel.add ( btnStart );
        btnLoad.setPreferredSize(new Dimension(300,40));
        contentPanel.add ( btnLoad );
        btnExit.setPreferredSize(new Dimension(300,40));
        contentPanel.add ( btnExit );

    }

    
    public static void main(String[] args) throws UnsupportedLookAndFeelException 
    {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        Window window = new Window();
        window.setVisible(true);
        
        
    }
}
