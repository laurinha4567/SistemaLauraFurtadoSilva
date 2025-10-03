

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package view;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u05084603105
 */
public class ControlerUsuarios extends AbstractTableModel {
    private List lista;
    
    
    public void setList(List lista){
      this.lista = lista;
    }
    
    public UsuariosBean getBean(int rowIndex){
     return (UsuariosBean) lista.get(rowIndex);
     
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
        
           Usuarios usuarios = (Usuarios) lista.get(rowIndex);
           
           if(columnIndex == 0) return usuarios.getIdusuarios();
           if(columnIndex == 1) return usuarios.getNome();
           if(columnIndex == 2) return usuarios.getCpf();
               
                  return "";

    }
      
    public String getColumnName(int column) {
      if(column == 0) return "codigo";
      if(column == 1) return "Nome";
      if(column == 2) return "cpf";
      
      return "";
    }
}
