/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.calendar.frontend;

import cz.muni.fi.pv168.calendar.backend.Person;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Jan Smerda
 */
public class PersonTableModel extends AbstractTableModel {
    private List<Person> persons = new ArrayList<Person>();
    private static final Logger logger =
            LoggerFactory.getLogger(PersonTableModel.class);

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
                String msg = "Trying to display invalid column: "+columnIndex;
                logger.error(msg);
                throw new RuntimeException(msg);
                //throw new IllegalArgumentException("columnIndex");
        }
    }
    
     @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return Strings.getString("name_person");
            case 2:
                return Strings.getString("email");
            case 3:
                return Strings.getString("note");
            default:
                String msg = "Trying to display invalid column: "+columnIndex;
                logger.error(msg);
                throw new RuntimeException(msg);
                //throw new IllegalArgumentException("columnIndex");
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
                String msg = "Trying to display invalid column: "+columnIndex;
                logger.error(msg);
                throw new RuntimeException(msg);
                //throw new IllegalArgumentException("columnIndex");
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
                String msg = "Trying to display invalid column: "+columnIndex;
                logger.error(msg);
                throw new RuntimeException(msg);
                //throw new IllegalArgumentException("columnIndex");
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
