package coda.gui.menu;

import coda.CoDaStats;
import coda.DataFrame;
import coda.gui.CoDaPackMain;
import coda.gui.output.OutputILRPartition;
import coda.gui.utils.BinaryPartitionSelect;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author mcomas
 */
public class TransformationILRMenu extends AbstractMenuDialogWithILR{
    public static final long serialVersionUID = 1L;
    JRadioButton ri;
    JRadioButton ir;



    public TransformationILRMenu(final CoDaPackMain mainApp){
        super(mainApp, "ILR Transform Menu", false);

        JButton defaultPart = new JButton("Default Partition");
        JButton manuallyPart = new JButton("Define Manually");
        optionsPanel.add(defaultPart);
        defaultPart.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(ri.isSelected())
                    setPartition(CoDaStats.defaultPartition(ds.getSelectedData().length));
                if(ir.isSelected())
                    setPartition(CoDaStats.defaultPartition(ds.getSelectedData().length+1));
            }
        });
        optionsPanel.add(manuallyPart);
        manuallyPart.addActionListener(new java.awt.event.ActionListener() {
            
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initiatePartitionMenu();
            }
        });

        JPanel opt = new JPanel();
        //opt.setPreferredSize(new Dimension(200,50));
        ri = new JRadioButton("Raw-ILR");
        ri.setSelected(true);
        ir = new JRadioButton("ILR-Raw");
        ButtonGroup group2 = new ButtonGroup();
        group2.add(ir);
        group2.add(ri);

        opt.add(ri);
        opt.add(ir);
        optionsPanel.add(opt);
        

    }
    public void initiatePartitionMenu(){
        BinaryPartitionSelect binaryMenu = new BinaryPartitionSelect(this, ds.getSelectedData() );
        binaryMenu.setVisible(true);
    }

    @Override
    public void acceptButtonActionPerformed() {
        int [][] partition = getPartition();
        if(partition != null){
            if(ri.isSelected()){
                DataFrame df = mainApplication.getActiveDataFrame();
                String[] sel_names = ds.getSelectedData();
                int m = sel_names.length-1;
                String[] new_names = new String[m];

                for(int i=0;i<m;i++) new_names[i] = "ilr." + Integer.toString(i+1);
                boolean selection[] = df.getValidCompositions(sel_names);
                double data[][] = df.getNumericalData(sel_names);
                double vdata[][] = coda.Utils.reduceData(data, selection);

                double ilr[][] = CoDaStats.transformRawILR(vdata, partition);
                df.addData(new_names, coda.Utils.recoverData(ilr, selection));
                //CoDaPack.transformRawILR(df.getNumericalDataZeroFree(sel_names), partition);
                // mainApplication.outputPanel.writeILRPartition(sel_names, partition);
                CoDaPackMain.outputPanel.addOutput(
                        new OutputILRPartition(sel_names, partition));
                //df.addData(new_names, CoDaPack.transformRawILR(getValidCompositionData(sel_names), partition));
                mainApplication.updateDataFrame(df);
            }else if(ir.isSelected()){
                DataFrame df = mainApplication.getActiveDataFrame();
                String[] sel_names = ds.getSelectedData();
                int m = sel_names.length+1;
                String[] new_names = new String[m];

                for(int i=0;i<m;i++) new_names[i] = "inv.ilr." + Integer.toString(i+1);
                //CoDaPack.transformRawILR(df.getNumericalDataZeroFree(sel_names), partition);


                df.addData(new_names, CoDaStats.closure(
                        CoDaStats.transformILRRaw(df.getNumericalData(sel_names), partition), 1));
                mainApplication.updateDataFrame(df);
            }
            setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "<html>You must define a partition</html>");
        }
    }
}

