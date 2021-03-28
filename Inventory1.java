import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L410-S01
 */
public class Inventory1 {

    List<String> product_name = new ArrayList<>();
    List<Integer> product_count = new ArrayList<>();

    /**
     * This method should return the total count of products in inventory.
     *
     * @return total number of products.
     */
    int getTotalProductsCount() {
        int total = 0;
        for (int i = 0; i < product_count.size(); i++) {
            total += product_count.get(i);
        }
        return total;
    }

    /**
     * This method should return the count of the product in inventory.
     *
     * @param item product you want to get the total count.
     */
    int getProductCount(String item) {
        int count = product_name.indexOf(item);
        int p_count = product_count.get(count);
        return p_count;
    }

    /**
     * This method should be able to add new product in the inventory.
     *
     * @param item product name to be added.
     * @param count number of items in the inventory.
     */
    void addNewProduct(String item, int count) {
        product_name.add(item);
        product_count.add(count);
    }

    /**
     * This method should be able to edit the product count in the inventory.
     *
     * @param item product name that will be edited.
     */
    void updateProductCount(String item, int count) {
        int index = product_name.indexOf(item);
        product_count.set(index,count);
    }

    /**
     * This method should be able to delete product in the inventory.
     *
     * @param item product name that will be deleted.
     *
     * @return the product and its corresponding count in the inventory.
     */
    
    // should be string return type
    String deleteProduct(String item) {
        int index = product_name.indexOf(item);
        product_name.remove(index);
        product_count.remove(index);
        
        return "Deleted file successfully";
    }
    
    void getCountAllProduct() {
        for(int i = 0; i < product_count.size(); i++) {
            System.out.println("Product Count: " + getProductCount(product_name.get(i)));
        }
    }
    public static void main(String[] args) {

        Inventory1 inv = new Inventory1();
        inv.product_name.add("guitar");
        inv.product_name.add("bass");
        inv.product_name.add("keyboard");
        inv.product_name.add("drums");
        inv.product_count.add(2);
        inv.product_count.add(4);
        inv.product_count.add(3);
        inv.product_count.add(5);
        
        
        //inv.addNewProduct("Ukelele", 5);
        inv.updateProductCount("drums", 8);
        //inv.deleteProduct("Ukelele");
        System.out.println("Items: " + inv.product_name);
        System.out.println("Count: " + inv.product_count);
        System.out.println("Count: " + inv.getProductCount("drums"));
        //System.out.println("Total Products Count: " + inv.getTotalProductsCount());
    }

}