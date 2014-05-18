/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.calendar.frontend;

import cz.muni.fi.pv168.calendar.backend.Attendance;
import cz.muni.fi.pv168.calendar.backend.Event;
import cz.muni.fi.pv168.calendar.backend.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jan Smerda
 */
public class AttendanceTableModel extends AbstractTableModel {
    private List<Attendance> attendances = new ArrayList<Attendance>();
    
     @Override
    public int getRowCount() {
        return attendances.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Attendance attendance = attendances.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return attendance.getId();
            case 1:
                return attendance.getEvent().getName();
            case 2:
                return attendance.getPerson().getName();
            case 3:
                return attendance.getPlannedArrivalTime();
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
                return "Event";
            case 2:
                return "Person";
            case 3:
                return "Planned Arrival";
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }
     
      @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         Attendance attendance = attendances.get(rowIndex);
        switch (columnIndex) {
            case 0:
                attendance.setId((Integer) aValue);
                break;
            case 1:
                attendance.setEvent((Event) aValue);
                break;
            case 2:
                attendance.setPerson((Person) aValue);
                break;
            case 3:
                attendance.setPlannedArrivalTime((Date) aValue);
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
      
       public void addAttendance(Attendance attendance) {
        attendances.add(attendance);
        int lastRow = attendances.size() - 1;
        fireTableRowsInserted(lastRow, lastRow);
    }

    public void deleteAttendance(Attendance attendance) {
        int lastRow = attendances.indexOf(attendance);
        attendances.remove(attendance);
        fireTableRowsDeleted(lastRow, lastRow);
    }

    public void deleteAllAttendances() {
        attendances.clear();
        fireTableRowsDeleted(0, 0);
    }
}
