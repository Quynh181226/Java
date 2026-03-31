package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.CategoryDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.CategoryDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAOImpl();
    }

    public List<Category> getAllCategories() throws SQLException {
        return categoryDAO.findAll();
    }

    public Category getCategoryById(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID danh muc phai lon hon 0");
        }
        return categoryDAO.findById(id);
    }

    public boolean addCategory(String name, String description) throws SQLException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten danh muc khong duoc de trong");
        }

        Category existing = categoryDAO.findByName(name);
        if (existing != null) {
            throw new IllegalArgumentException("Danh muc da ton tai");
        }

        Category category = new Category(name, description);
        return categoryDAO.save(category);
    }

    public boolean updateCategory(int id, String name, String description) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID danh muc khong hop le");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten danh muc khong duoc de trong");
        }

        Category category = categoryDAO.findById(id);
        if (category == null) {
            throw new IllegalArgumentException("Khong tim thay danh muc");
        }

        Category existing = categoryDAO.findByName(name);
        if (existing != null && existing.getId() != id) {
            throw new IllegalArgumentException("Ten danh muc da ton tai");
        }

        category.setName(name);
        category.setDescription(description);
        return categoryDAO.update(category);
    }

    public boolean deleteCategory(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID danh muc khong hop le");
        }

        Category category = categoryDAO.findById(id);
        if (category == null) {
            throw new IllegalArgumentException("Khong tim thay danh muc");
        }

        if (categoryDAO.hasProducts(id)) {
            throw new IllegalArgumentException("Khong the xoa danh muc vi dang co san pham thuoc danh muc nay");
        }

        return categoryDAO.delete(id);
    }
}