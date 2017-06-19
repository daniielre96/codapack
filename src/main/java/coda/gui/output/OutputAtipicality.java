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

package coda.gui.output;

import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author marc
 */
public class OutputAtipicality implements OutputElement{
    double threshold;
    int[] atipic;
    
    public OutputAtipicality(double threshold, int atipic[]){
        this.threshold = threshold;
        this.atipic = atipic;
    }
    public String printHTML(String html) {
        html += "<b>Atipicality index if a composition</b><br>";
        if(atipic.length > 0){
            html += "Indices greater than " + decimalFormat.format(threshold) + ": <table><tr>";
            for(int i=0;i<atipic.length;i++){
                html += "<td>" + atipic[i] + " </td>";
            }
            html += "</tr></table>";
        }else{
            html += "No atipicality found<br>";
        }
        return html;
    }
    public void printText(Writer b) throws IOException{


    }
}
