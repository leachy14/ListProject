import java.util.ArrayList;

public class NicePerson extends Name implements NicePersonInterface {

    private Name name;
    private ArrayList<String> presents;

    public NicePerson() {
        name = new Name();
        presents = new ArrayList<String>();
    }

    public NicePerson(String firstName, String lastName) {
        name = new Name(firstName, lastName);
        presents = new ArrayList<String>();
    }

    public void setName(String firstName, String lastName) {
        name.setName(firstName, lastName);
    }

    public String getName() {
        return name.getName();
    }

    public void setFirst(String firstName) {
        name.setFirst(firstName);
    }

    public String getFirst() {
        return name.getFirst();
    }

    public void setLast(String lastName) {
        name.setLast(lastName);
    }

    public String getLast() {
        return name.getLast();
    }

    public void giveLastNameTo(NicePersonInterface aName) {
        name.setLast(String.valueOf(aName));
    }

    public void addPresent(String present) {
        presents.add(present);
    }

    public void removePresent(String present) {
        presents.remove(present);
    }

    public void removeAllPresents() {
        presents.clear();
    }

    public String[] getPresents() {
        String[] presentArray = new String[presents.size()];
        for (int i = 0; i < presents.size(); i++) {
            presentArray[i] = presents.get(i);
        }
        return presentArray;
    }

    public String toString() {
        String result = name.toString() + " has " + presents.size() + " presents: ";
        for (int i = 0; i < presents.size(); i++) {
            result += presents.get(i) + " ";
        }
        return result;
    }



}
