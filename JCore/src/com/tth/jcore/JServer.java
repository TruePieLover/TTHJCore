/*************************************
 *     TTHJPieCore vTTHDevBuild1.0
 * @author Pie
 * @module Main JCore GUI
 * @copyright: TTH2020
 * @version TTH Development Build 1.0
 * @created 9/30/2020
 * @package com.tth.jcore
 * @description Main JCore package
 ************************************/
package com.tth.jcore;

import com.jcraft.jsch.*;
import java.awt.*;
import javax.swing.*;

/**
 * JServer.java:
 *  Main access file to the TTH server
 */
public class JServer {

    public Boolean m_run;

    // Constructor asks for information and attempts to establish a connection, if successful the constructor inits the server class var true
    public JServer(Boolean run) {
        try {
            JSch jsch = new JSch();
            String host = null;
            if (!run) {
                System.err.println("Server could not start");
            } else {
                host = JOptionPane.showInputDialog("Enter username@hostname",
                        System.getProperty("user.name") +
                                "@localhost");
            }
        } catch (Exception e) {
            System.err.println("Error to start server!");
        }
    }
}
