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

package coda.gui.menu;

import coda.CoDaStats;
import coda.DataFrame;
import coda.gui.CoDaPackMain;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author mcomas
 */
public class TransformationALRMenu extends AbstractMenuDialog{
    public static final long serialVersionUID = 1L;
    JRadioButton ra;
    JRadioButton ar;
    JTextField closure = new JTextField("1.0");

    public TransformationALRMenu(final CoDaPackMain mainApp){
        super(mainApp, "ALR Transform Menu", false);

        JPanel opt = new JPanel();
        ra = new JRadioButton("Raw-ALR");
        ra.setSelected(true);
        ar = new JRadioButton("ALR-Raw");
        ButtonGroup group = new ButtonGroup();
        group.add(ar);
        group.add(ra);

        opt.add(ra);
        opt.add(ar);
        optionsPanel.add(opt);
    }
    @Override
    public void acceptButtonActionPerformed() {
        if(ra.isSelected()){
            DataFrame df = mainApplication.getActiveDataFrame();
            String[] sel_names = ds.getSelectedData();
            int m = sel_names.length-1;
            String[] new_names = new String[m];
            for(int i=0;i<m;i++) new_names[i] = "alr." + sel_names[i] + "_" + sel_names[m];
            boolean selection[] = df.getValidCompositions(sel_names);
            double data[][] = df.getNumericalData(sel_names);
            double vdata[][] = coda.Utils.reduceData(data, selection);

            double alr[][] = CoDaStats.transformRawALR(vdata);
            df.addData(new_names, coda.Utils.recoverData(alr, selection));
            mainApplication.updateDataFrame(df);
        }else{
            DataFrame df = mainApplication.getActiveDataFrame();
            String[] sel_names = ds.getSelectedData();
            int m = sel_names.length+1;
            String[] new_names = new String[m];
            for(int i=0;i<m;i++) new_names[i] = "inv.alr." + (i+1);
            df.addData(new_names, CoDaStats.closure(
                    CoDaStats.transformALRRaw(df.getNumericalData(sel_names)), 1));
            mainApplication.updateDataFrame(df);
        }
        setVisible(false);
    }
}

