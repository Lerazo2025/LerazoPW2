package Model;

import java.util.List;

public class RutasResponse {
    private List<Rutas> items;
    private boolean hasMore;
    private int limit;
    private int count;

    // Getters y setters
    public List<Rutas> getItems() { return items; }
    public void setItems(List<Rutas> items) { this.items = items; }

    public boolean isHasMore() { return hasMore; }
    public void setHasMore(boolean hasMore) { this.hasMore = hasMore; }

    public int getLimit() { return limit; }
    public void setLimit(int limit) { this.limit = limit; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }
}