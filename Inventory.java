import java.util.*;
public class Inventory {
    private Map<String,Integer> itemMap = new TreeMap<String,Integer>();
    public String toString() { // just use the map's own representation
        return itemMap.toString();
    } // end toString
    /*
     * Adds 1 or more items of the same kind to the inventory.
     * Parameters are the name of the item and
     * the number of these items to add to the inventory.
     * If the map already contains some items with this name, the new
     * amount is added to the current amount. If this is a new item
     * name, the item is added to the map.
     */
    public void addItems(String name, int amount) {
        if (itemMap.containsKey(name))
            itemMap.put(name, itemMap.get(name) + amount);
        else
            itemMap.put(name, amount);
    } // end addItems
    /*
     * When the inventory has fewer than 5 of an item, it should order
     * more. This method returns a set of the names of items that
     * need to be ordered.
     */
    public Set<String> order() {
        Set<String> items = new TreeSet<String>();
        for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
            if (entry.getValue() < 5) {
                items.add(entry.getKey());
            }
        }
        return items;
    } // end order
    /*
     * Removes all items from the inventory whose names start with 'x'.
     */
    public void removeX() {
        Iterator<Map.Entry<String, Integer>> loop = itemMap.entrySet().iterator();
        while (loop.hasNext()) {
            Map.Entry<String, Integer> entry = loop.next();
            if (entry.getKey().charAt(0) == 'x') {
                loop.remove();
            }
        }
    } // end check

    public static void main(String args[]) {
        Inventory groceries = new Inventory();
        groceries.addItems("grapefruit", 15);
        groceries.addItems("pineapple", 10);
        groceries.addItems("xerox", 6);
        groceries.addItems("ham", 3);
        groceries.addItems("grapefruit", 3);
        groceries.addItems("yam", 5);
        groceries.addItems("lettuce", 4);
        groceries.addItems("pineapple", 7);
        groceries.addItems("apple", 2);
        groceries.addItems("pear", 1);
        System.out.println("initial inventory: " + groceries);
        Set<String> needToOrder = groceries.order();
        System.out.println("items that must be ordered: " +
            needToOrder);
        groceries.removeX();
        System.out.println("after removeX: " + groceries);
    } // end main
}