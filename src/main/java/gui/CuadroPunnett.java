package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CuadroPunnett extends JFrame {

        public CuadroPunnett(int width, int height, char GEN0, char GEN1) {
                String gen0 = Character.toString(GEN0);
                String gen1 = Character.toString(GEN1);
                setLayout(null);
                setSize(width, height);
                Color bgColor = new Color(255, 255, 255);
                setBackground(bgColor);
                setTitle("Cuadro de punnett");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Font arial20 = new Font("Arial", Font.PLAIN, 20);
                String upperCaseGen0 = gen0.toUpperCase();
                String upperCaseGen1 = gen1.toUpperCase();
                String lowerCaseGen0 = gen0.toLowerCase();
                String lowerCaseGen1 = gen1.toLowerCase();
                String[] columnNames = { "", upperCaseGen0 + upperCaseGen1,
                                upperCaseGen0 + lowerCaseGen1, lowerCaseGen0 + upperCaseGen1,
                                lowerCaseGen0 + lowerCaseGen1 };

                Object[][] rowData = { { upperCaseGen0 + upperCaseGen1,
                                upperCaseGen0 + upperCaseGen0 + upperCaseGen1 + upperCaseGen1,
                                upperCaseGen0 + upperCaseGen0 + upperCaseGen1 + lowerCaseGen1,
                                upperCaseGen0 + lowerCaseGen0 + upperCaseGen1 + upperCaseGen1,
                                upperCaseGen0 + lowerCaseGen0 + upperCaseGen1 + lowerCaseGen1 },
                                { upperCaseGen0 + lowerCaseGen1,
                                upperCaseGen0 + upperCaseGen0 + upperCaseGen1 + lowerCaseGen1,
                                upperCaseGen0 + upperCaseGen0 + lowerCaseGen1 + lowerCaseGen1,
                                upperCaseGen0 + lowerCaseGen0 + upperCaseGen1 + lowerCaseGen1,
                                upperCaseGen0 + lowerCaseGen0 + lowerCaseGen1 + lowerCaseGen1 },
                                { lowerCaseGen0 + upperCaseGen1,
                                upperCaseGen0 + lowerCaseGen0 + upperCaseGen1 + upperCaseGen1,
                                upperCaseGen0 + lowerCaseGen0 + upperCaseGen1 + lowerCaseGen1,
                                lowerCaseGen0 + lowerCaseGen0 + upperCaseGen1 + upperCaseGen1,
                                lowerCaseGen0 + lowerCaseGen0 + upperCaseGen1 + lowerCaseGen1 },
                                { lowerCaseGen0 + lowerCaseGen1,
                                upperCaseGen0 + lowerCaseGen0 + upperCaseGen1 + lowerCaseGen1,
                                upperCaseGen0 + lowerCaseGen0 + lowerCaseGen1 + lowerCaseGen1,
                                lowerCaseGen0 + lowerCaseGen0 + upperCaseGen1 + lowerCaseGen1,
                                lowerCaseGen0 + lowerCaseGen0 + lowerCaseGen1 + lowerCaseGen1 } };
                JTable punnett_table = new JTable(rowData, columnNames) {
                        /**
                        *
                        */
                        private static final long serialVersionUID = 1L;

                        @Override
                        public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                                if (col == 0) {
                                        return this.getTableHeader().getDefaultRenderer().getTableCellRendererComponent(
                                                        this, this.getValueAt(row, col), false, false, row, col);
                                } else {
                                        return super.prepareRenderer(renderer, row, col);
                                }
                        }
                };
                JScrollPane tableScrollPane = new JScrollPane(punnett_table);
                tableScrollPane.setBounds(0, 0, 400, 400);
                add(tableScrollPane);
                setVisible(true);
        }

}