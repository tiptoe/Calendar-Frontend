/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.calendar.frontend;

import cz.muni.fi.pv168.calendar.backend.Person;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jan Smerda
 */
public class PersonTableModel extends AbstractTableModel {
    private List<Person> persons = new ArrayList<Person>();

    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getEmail();
            case 3:
                return person.getNote();
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }
    
     @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Name";
            case 2:
                return "E-mail";
            case 3:
                return "Note";
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }
     
      @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Person person = persons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                person.setId((Integer) aValue);
                break;
            case 1:
                person.setName((String) aValue);
                break;
            case 2:
                person.setEmail((String) aValue);
                break;
            case 3:
                person.setNote((String) aValue);
                break;
            default:
                throw new IllegalArgumentException("columnIndex");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
      
      @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
            case 1:
            case 2:
            case 3:
                return false;
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }
      
       public void addPerson(Person person) {
        persons.add(person);
        int lastRow = persons.size() - 1;
        fireTableRowsInserted(lastRow, lastRow);
    }

    public void deletePerson(Person person) {
        int lastRow = persons.indexOf(person);
        persons.remove(person);
        fireTableRowsDeleted(lastRow, lastRow);
    }

    public void deleteAllPersons() {
        persons.clear();
        fireTableRowsDeleted(0, 0);
    }
}
