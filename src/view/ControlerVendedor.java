/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Lfs_vendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u05084603105
 */
public class ControlerVendedor extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public Object getBean(int rowIndex) {
        return lista.get(rowIndex);

    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Lfs_vendedor vendedor = (Lfs_vendedor) lista.get(rowIndex);

        if (columnIndex == 0) {
            return vendedor.getIdlfs_vendedor();
        }
        if (columnIndex == 1) {
            return vendedor.getLfs_nome();
        }
        if (columnIndex == 2) {
            return vendedor.getLfs_cpf();
        }

        return "";

    }

    public String getColumnName(int column) {
        if (column == 0) {
            return "codigo";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "cpf";
        }

        return "";
    }
}
