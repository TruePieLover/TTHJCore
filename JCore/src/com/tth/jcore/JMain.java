/*************************************
 *     TTHJPieCore vTTHDevBuild1.0
 * @author Pie
 * @module Main JCore GUI
 * @copyright: TTH2020
 * @version TTH Development Build 1.0
 * @data 9/25/2020
 * @package com.tth.jcore
 * @description Main JCore package
 ************************************/
package com.tth.jcore;

import com.tth.jcore.gui.JWindow;

/**
 * JMain.java:
 *  Main app source file/entry point
 */
public class JMain {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JWindow();
            }
        });
    }
}