package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Product;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<Integer, CartItem> cart;

    public CartService() {
        this.cart = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("So luong phai lon hon 0");
        }
        if (quantity > product.getStock()) {
            throw new IllegalArgumentException("So luong vuot qua ton kho");
        }

        int productId = product.getId();
        if (cart.containsKey(productId)) {
            CartItem item = cart.get(productId);
            int newQuantity = item.getQuantity() + quantity;
            if (newQuantity > product.getStock()) {
                throw new IllegalArgumentException("Tong so luong vuot qua ton kho");
            }
            item.setQuantity(newQuantity);
        } else {
            cart.put(productId, new CartItem(product, quantity));
        }
    }

    public void updateQuantity(int productId, int quantity) {
        if (quantity <= 0) {
            removeFromCart(productId);
        } else {
            CartItem item = cart.get(productId);
            if (item != null) {
                if (quantity > item.getProduct().getStock()) {
                    throw new IllegalArgumentException("So luong vuot qua ton kho");
                }
                item.setQuantity(quantity);
            }
        }
    }

    public void removeFromCart(int productId) {
        cart.remove(productId);
    }

    public void clearCart() {
        cart.clear();
    }

    public Map<Integer, CartItem> getCart() {
        return cart;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : cart.values()) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }

    public int getTotalItems() {
        int total = 0;
        for (CartItem item : cart.values()) {
            total += item.getQuantity();
        }
        return total;
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public static class CartItem {
        private Product product;
        private int quantity;

        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() { return product; }
        public void setProduct(Product product) { this.product = product; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public BigDecimal getSubtotal() {
            return product.getPrice().multiply(BigDecimal.valueOf(quantity));
        }
    }
}