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

package test;

import coda.CoDaStats;
import coda.ext.jama.Matrix;

/**
 *
 * @author mcomas
 */
public class testNormalityTest {
    public static void main(String args[]) {
        double raw[][] = new Matrix(data).transpose().getArray();
        double alr[][] = CoDaStats.transformRawALR(raw);
        System.out.println(CoDaStats.radiusTest(alr)[0] + " " +  CoDaStats.radiusTest(alr)[1] + " " + CoDaStats.radiusTest(alr)[2]);
    }
    static double data[][] =
    {{48.8,31.7,3.8,6.4,9.3},
    {48.2,23.8,9,9.2,9.8},
    {37,9.100001,34.2,9.5,10.2},
    {50.9,23.8,7.2,10.1,8},
    {44.2,38.3,2.9,7.7,6.9},
    {52.3,26.2,4.2,12.5,4.8},
    {44.6,33,4.6,12.2,5.6},
    {34.6,5.2,42.9,9.600001,7.7},
    {41.2,11.7,26.7,9.600001,10.8},
    {42.6,46.6,0.7,5.6,4.5},
    {49.9,19.5,11.4,9.5,9.7},
    {45.2,37.3,2.7,5.5,9.3},
    {32.7,8.5,38.9,8,11.9},
    {41.4,12.9,23.4,15.8,6.5},
    {46.2,17.5,15.8,8.3,12.2},
    {32.3,7.3,40.9,12.9,6.6},
    {43.2,44.3,1,7.8,3.7},
    {49.5,32.3,3.1,8.7,6.3},
    {42.3,15.8,20.4,8.3,13.2},
    {44.6,11.5,23.8,11.6,8.5},
    {45.8,16.6,16.8,12,8.8},
    {49.9,25,6.8,10.9,7.4},
    {48.6,34,2.5,9.399999,5.5},
    {45.5,16.6,17.6,9.600001,10.7},
    {45.9,24.9,9.7,9.8,9.7}};
}
