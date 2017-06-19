/**	
 *	Copyright 2011-2016 Marc Comas - Santiago Thió
 *
 *	This file is part of CoDaPack.
 *
 *  CoDaPack is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  CoDaPack is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with CoDaPack.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WindowTernaryPlot.java
 *
 * Created on Sep 9, 2010, 12:11:02 PM
 */
package test;

import coda.plot.TernaryPlotUtilitySelector;
import coda.plot.window.CoDaPlotWindow;
import java.awt.Dimension;
import javax.swing.JFrame;


/**
 *
 * @author marc
 */
public class TernaryPlotUtilityWindow{
    public static void main(String[] args){
        TernaryPlotUtilitySelector display = new TernaryPlotUtilitySelector();
        JFrame frame = new CoDaPlotWindow(null, display, "Window");
        frame.add(display);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
    

}
