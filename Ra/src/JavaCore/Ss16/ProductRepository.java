package JavaCore.Ss16;

import java.util.*;

public class ProductRepository implements IRepository<Product> {
    private final List<Product> productList = new ArrayList<>();
    private final Map<String, Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || item.getId() == null || productMap.containsKey(item.getId())) {
            return false;
        }
        productList.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        if (id == null) return false;
        Product removed = productMap.remove(id);
        if (removed != null) {
            productList.remove(removed);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(String id) {
        if (id == null) return null;
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    public List<Product> getSortedByPrice() {
        List<Product> sorted = new ArrayList<>(productList);
        sorted.sort(Comparator.comparingDouble(p -> p.calculateFinalPrice()));
        return sorted;
    }

    public Map<String, Integer> getTypeStatistics() {
        Map<String, Integer> stats = new HashMap<>();
        for (Product p : productList) {
            String type = p instanceof ElectronicProduct ? "Electronic" :
                    p instanceof FoodProduct ? "Food" : "Unknown";
            stats.put(type, stats.getOrDefault(type, 0) + 1);
        }
        return stats;
    }
}