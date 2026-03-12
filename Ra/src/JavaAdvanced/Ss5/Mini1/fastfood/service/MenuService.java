package JavaAdvanced.Ss5.Mini1.fastfood.service;

import JavaAdvanced.Ss5.Mini1.fastfood.model.MenuItem;
import JavaAdvanced.Ss5.Mini1.fastfood.repository.MenuRepository;

import java.util.List;
import java.util.stream.Collectors;

public class MenuService {
    private MenuRepository repository;
    public MenuService(MenuRepository repository) {
        this.repository=repository;
    }

    // tim theo ten
    public List<MenuItem> searchByName(String keyword) {
        return repository.getAllMenuItems().stream()
                .filter(item->item.getName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    // tim theo khoang gia
    public List<MenuItem> searchByPriceRange(double min, double max) {
        return repository.getAllMenuItems().stream()
                .filter(item->item.getPrice()>=min && item.getPrice()<=max)
                .collect(Collectors.toList());
    }
}
