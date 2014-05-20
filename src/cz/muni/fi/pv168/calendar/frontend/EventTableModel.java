/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pv168.calendar.frontend;

import cz.muni.fi.pv168.calendar.backend.Event;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cael
 */
public class EventTableModel extends AbstractTableModel {

    private List<Event> events = new ArrayList<Event>();

    @Override
    public int getRowCount() {
        return events.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Event event = events.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return event.getId();
            case 1:
                return event.getName();
            case 2:
                return event.getStartDate();
            case 3:
                return event.getEndDate();
            case 4:
                return event.getNote();
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
                return Strings.getString("name_event");
            case 2:
                return Strings.getString("start_date");
            case 3:
                return Strings.getString("end_date");
            case 4:
                return Strings.getString("note");
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Event event = events.get(rowIndex);
        switch (columnIndex) {
            case 0:
                event.setId((Integer) aValue);
                break;
            case 1:
                event.setName((String) aValue);
                break;
            case 2:
                event.setStartDate((Date) aValue);
                break;
            case 3:
                event.setEndDate((Date) aValue);
                break;
            case 4:
                event.setNote((String) aValue);
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
            case 4:
                return false;
            default:
                throw new IllegalArgumentException("columnIndex");
        }
    }

    public void addEvent(Event event) {
        events.add(event);
        int lastRow = events.size() - 1;
        fireTableRowsInserted(lastRow, lastRow);
    }

    public void deleteEvent(Event event) {
        int lastRow = events.indexOf(event);
        events.remove(event);
        fireTableRowsDeleted(lastRow, lastRow);
    }

    public void deleteAllEvents() {
        events.clear();
        fireTableRowsDeleted(0, 0);
    }
}
