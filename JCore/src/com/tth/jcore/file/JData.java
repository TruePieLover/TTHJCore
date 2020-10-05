/*************************************
 *     TTHJPieCore vTTHDevBuild1.0
 * @author Pie
 * @module com.tth.jcore.file
 * @copyright: TTH2020
 * @version TTH Development Build 1.0
 * @data 9/25/2020
 * @description Handle all data needed to be read/saved and serialized with JSON for app
 ************************************/
package com.tth.jcore.file;

import java.math.*;
import java.util.*;

/**
 * JData.java:
 *  Handle all the data needed to be parsed into JSON for our application
 */
public class JData {

    private String username;
    private String password;
    /* Use constructor to init all data needed to be parsed */

    public JData(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    /* Getters and setters */
    public String GetUsername()
    {
        return username;
    }
    public String GetPassword()
    {
        return password ;
    }





}
