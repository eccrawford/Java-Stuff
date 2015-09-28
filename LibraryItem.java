import java.util.*;
public class LibraryItem {
    protected boolean inLibrary = true;
    protected String title;
    protected static int totalTime = 0;
    
    protected boolean checkIn() {
        inLibrary = true;
        return inLibrary;
    }
    protected boolean checkOut() {
        inLibrary = false;
        return inLibrary;
    }
    protected boolean inLibrary() {
        return inLibrary;
    }
    protected static int getTotalMinutes() {
        return totalTime;
    }
    protected String getTitle() {
        return title;
    }
    
    public void addToCatalog(Map<Integer, LibraryItem> catalog, Integer callNumber, LibraryItem newItem) {
        catalog.put(callNumber, newItem);
    }
    
    public String searchByNum(Map<Integer, LibraryItem> catalog, Integer callNumber) {
        for (Map.Entry<Integer, LibraryItem> entry : catalog.entrySet()) {
            Integer callNum = entry.getKey();
            LibraryItem title = entry.getValue();
            if (callNum == callNumber)
                return title.getTitle();
        }
        return "not found";
    }
    
    public Set<Integer> searchByTitle(Map<Integer, LibraryItem> catalog, String itemTitle) {
        Set<Integer> matches = new TreeSet<Integer>();
        
        for (Map.Entry<Integer, LibraryItem> entry : catalog.entrySet()) {
            Integer callNum = entry.getKey();
            LibraryItem title = entry.getValue();
            if (itemTitle.equals(title)) 
                matches.add(callNum);
        }
        return matches;
    }
}