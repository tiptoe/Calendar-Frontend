package cz.muni.fi.pv168.calendar.frontend;

import cz.muni.fi.pv168.calendar.backend.Person;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Jiri Stary
 */
public class PersonComboBoxModel extends DefaultComboBoxModel {
    private List<Person> persons = new ArrayList<Person>();
    private static final Logger logger =
            LoggerFactory.getLogger(PersonComboBoxModel.class);
    
    @Override
    public Object getElementAt(int index) {
        if (index >= persons.size() || index < 0) {
            String msg = "Trying to display invalid data at: "+index;
            logger.error(msg);
            throw new RuntimeException(msg);
            //throw new IllegalArgumentException("index is " + index);
        }
        return persons.get(index).getName();
    }

    public Person getSelectedPerson(int index) {
        if (index >= persons.size() || index < 0) {
            String msg = "Trying to display invalid data at: "+index;
            logger.error(msg);
            throw new RuntimeException(msg);
            //throw new IllegalArgumentException("index is " + index);
        }
        return persons.get(index);
    }
    
    public void removePerson(Person person) {
        if (person == null)
            throw new NullPointerException("person");
        int index = persons.indexOf(person);
        this.removeElement(index);
        persons.remove(person);
        fireIntervalRemoved(this, index, index);        
    }
    
    public void addPerson(Person person) {
        if (persons.contains(person) || person == null) 
            return;
        persons.add(person);    
        int lastElement = persons.size() - 1;        
        this.addElement(person.getName());        
        fireIntervalAdded(this, lastElement, lastElement);
    }
    
    public void deleteAllPersons() {
        persons.clear();
        this.removeAllElements();
        fireIntervalRemoved(this, 0, 0);
    }
}
