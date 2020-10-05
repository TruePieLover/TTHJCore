/*************************************
 *     TTHJPieCore vTTHDevBuild1.0
 * @author Pie
 * @package com.tth.jcore.gui
 * @copyright: TTH2020
 * @version TTH Development Build 1.0
 * @data 9/25/2020
 * @description This package contains all of the functionality for JCore's GUI window
 ************************************/

package com.tth.jcore.gui;

/* Utilize java swing and awt for GUI */

import com.tth.jcore.JServer;
import com.tth.jcore.file.JFile;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/* Import our file data package */

/**
 *  JWindow.java:
 *      Main window class
 */
public class JWindow   {

    /* Main JWindow class variables */
    protected static GraphicsConfiguration m_gc;
    protected final static String m_frameTitle = "PieCore vTTHJC1.0";
    public JFrame m_mainFrame = null;
    static final int FRAME_WIDTH = 600;
    static final int FRAME_HEIGHT = 600;
    static final int FRAME_X_POS = 250;
    static final int FRAME_Y_POS  = 250;
    private boolean canResize = true;
    private boolean isVisible = true;

    /**
     *  public JWindow():
     *      Main window class constructor, invoked from the external main function and sets up entire window GUI
     */
    public JWindow() {
        this.m_mainFrame = new JFrame(m_frameTitle,m_gc);
        try {
            initGUI(m_mainFrame);
            setupMenu();
        }
        catch(Exception winError)
        {
            System.err.println("Error! " + winError.toString());
        }
    }


    /* Setup window main menu bar */
    /******************************************/
    private JMenuBar mainMenu;
    protected JMenu _fileMenu = new JMenu("File");
    protected JMenuItem _newMenuItem = new JMenuItem("New");
    protected JMenuItem _exitMenuItem = new JMenuItem("Exit");

    private void setupMenu()
    {
        mainMenu = new JMenuBar();
        _exitMenuItem.setToolTipText("Exit application");
        _exitMenuItem.addActionListener((event) -> System.exit(0));
        _fileMenu.add(_newMenuItem);
        _fileMenu.add(_exitMenuItem);
        _newMenuItem.addActionListener(new newFileAction());
        mainMenu.add(_fileMenu);
        m_mainFrame.setJMenuBar(mainMenu);
    }

    /* Setup GUI Component for the frames and panels  */
    /******************************************/
    private boolean showStartPanel;
    private boolean showNewPanel;
    protected static JTextField _tfUsername;
    protected JPanel _startPanel, _newPanel;

    private static void SetupStartPane(Container pane) throws IOException {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        BufferedImage myPicture = ImageIO.read(new File("C:\\TTHJCore\\JCore\\assets\\title.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel l1 = new JLabel("Welcome to PieCore!");
        JLabel l2 = new JLabel("If you need to create an account, go to File-->New or visit www.gotraphouse.com");
        JLabel filler1 = new JLabel("       ");
        l1.setFont(new Font("Cambria", Font.PLAIN, 20));
        l2.setFont(new Font("Cambria", Font.ITALIC, 12));
        l1.setForeground(Color.BLUE);
        l2.setForeground(Color.darkGray);
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        filler1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(picLabel);
        pane.add(l1);
        pane.add(l2);
        pane.add(filler1);

    }

    private void StartPanel(JFrame frame)
    {
        _startPanel = new JPanel();
        JLabel l1 = new JLabel("Welcome");
        _startPanel.add(l1);
        _startPanel.setVisible(false);
        frame.add(_startPanel);
    }


    private void NewPanel(JFrame frame)
    {
        _newPanel = new JPanel();
        _tfUsername = new JTextField();
    }
    /* Init the main GUI */
    private void initGUI(JFrame mainFrame) throws IOException {
        m_mainFrame.setLayout(null); // Default layout null at the start
        SetupStartPane(m_mainFrame.getContentPane());
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\TTHJCore\\JCore\\assets\\ico.png");
        mainFrame.setIconImage(icon);
        StartPanel(m_mainFrame);
        mainFrame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        mainFrame.setLocation(FRAME_X_POS, FRAME_Y_POS);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(!canResize);
        mainFrame.setVisible(isVisible);
    }

    /* Helper fields/functions for window class */
    private void ShowOrHide(JPanel panel, Boolean visible)
    {
        panel.setVisible(visible);
    }


    /* Internal action handler class for GUI controls */
    /***************************************************/
    class newFileAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ShowOrHide(_startPanel,true);
            JServer server = new JServer(true);

        }
    }
    class newUserTxtBoxAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
        }
    }
}