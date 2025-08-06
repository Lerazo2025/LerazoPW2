package Model;

import java.util.List;

public class CombustibleResponse {
    private List<Combustible> items;
    private boolean hasMore;
    private int limit;
    private int count;

    public List<Combustible> getItems() {
        return items;
    }

    public void setItems(List<Combustible> items) {
        this.items = items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}