package cz.muni.fi.pv168.calendar.frontend;

import cz.muni.fi.pv168.calendar.backend.Person;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Jiri Stary
 */
public class PersonComboBoxModel extends DefaultComboBoxModel {
    private List<Person> persons = new ArrayList<Person>();
    
    @Override
    public Object getElementAt(int index) {
        if (index >= persons.size())
            throw new IllegalArgumentException("index");
        
        return persons.get(index).getName();
    }
    
    @Override
    public Object getSelectedItem() {
        //TODO Vratit objekt podle indexu vybraneho prvku nebo alespon podle jmena
        if (persons.size() == 0)
            return null;
        return persons.get(0);
    }
    
    public void addPerson(Person person) {
        persons.add(person);
        int lastElement = persons.size() - 1;
        
        //TODO: Jak se zbavit nasledujiciho radku?
        this.addElement(person.getName());
        
        fireIntervalAdded(this, lastElement, lastElement);
    }
    
    public void deleteAllPersons() {
        persons.clear();
        fireIntervalRemoved(this, 0, 0);
    }
}
