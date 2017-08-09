import java.util.Arrays;
import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {

    private int pageCount;
    private int itemsPerPage;

    private List<I> items;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.items = collection;
        this.itemsPerPage = itemsPerPage;

        this.pageCount = collection.size() % itemsPerPage == 0 ? collection.size() / itemsPerPage
                : collection.size() / itemsPerPage + 1;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {

        return items.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return pageCount;

    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= pageCount || pageIndex < 0) {
            return -1;
        }
        int start = pageIndex * itemsPerPage;
        int end = (pageIndex + 1) * itemsPerPage > itemCount() ? itemCount() : (pageIndex + 1) * itemsPerPage;
        return end - start;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex > itemCount() - 1 || itemIndex < 0) {
            return -1;
        } else {
            return itemIndex / itemsPerPage;
        }
    }

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);

        assertEquals(2, helper.pageCount());

        assertEquals(6, helper.itemCount());

        assertEquals(4, helper.pageItemCount(0));

        assertEquals(2, helper.pageItemCount(1));

        assertEquals(-1, helper.pageItemCount(2));

        assertEquals(1, helper.pageIndex(5));

        assertEquals(0, helper.pageIndex(2));
        assertEquals(-1, helper.pageIndex(20));
        assertEquals(-1, helper.pageIndex(-10));






    }
}