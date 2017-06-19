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

package coda.plot2.datafig;

import coda.plot.CoDaDisplayConfiguration;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author marc
 */
public class FilledSquare implements CoDaShape{
    Color interior;
    Color contour;
    double size;
    public FilledSquare(){
        CoDaDisplayConfiguration config = new CoDaDisplayConfiguration();
        this.interior = config.getColor("data0");
        this.contour = Color.BLACK;
        this.size = config.getSize("data");
    }
    public FilledSquare(Color interior, Color contour, double size){
        this.interior = interior;
        this.contour = contour;
        this.size = size;
    }
    public void plot(Graphics2D g2, Point2D p) {
        double cx = p.getX();
        double cy = p.getY();

        Rectangle2D.Double rect = new Rectangle2D.Double(cx-size, cy-size, 2 * size, 2 * size);
        g2.setColor( interior );
        g2.fill(rect);
        g2.setColor( contour );
        g2.draw(rect);
    }

    public Color getColor() {
        return interior;
    }
    public void setColor(Color color) {
        interior = color;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

}
