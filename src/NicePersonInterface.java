public interface NicePersonInterface {
public void setName(String firstName, String lastName);
    public String getName();
    public void setFirst(String firstName);
    public String getFirst();
    public void setLast(String lastName);
    public String getLast();
    public void giveLastNameTo(NicePersonInterface aName);
    public void addPresent(String present);
    public void removePresent(String present);
    public void removeAllPresents();
    public String[] getPresents();
    public String toString();
}
