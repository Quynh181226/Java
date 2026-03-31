package JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.service;

import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.FlashSaleDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.FlashSaleDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.interfaces.ProductDAO;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.dao.imps.ProductDAOImpl;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.FlashSale;
import JavaAdvanced.Project_JavaAdvanced.SmartPhoneStore.src.model.entity.Product;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class FlashSaleService {
    private FlashSaleDAO flashSaleDAO;
    private ProductDAO productDAO;

    public FlashSaleService() {
        this.flashSaleDAO = new FlashSaleDAOImpl();
        this.productDAO = new ProductDAOImpl();
    }

    public List<FlashSale> getAllFlashSales() throws SQLException {
        return flashSaleDAO.findAll();
    }

    public List<FlashSale> getActiveFlashSales() throws SQLException {
        List<FlashSale> flashSales = flashSaleDAO.findActiveFlashSales();
        for (FlashSale fs : flashSales) {
            Product product = productDAO.findById(fs.getProductId());
            if (product != null) {
                fs.setProductName(product.getName());
            }
        }
        return flashSales;
    }

    public FlashSale getFlashSaleByProduct(int productId) throws SQLException {
        return flashSaleDAO.findByProductId(productId);
    }

    public boolean addFlashSale(int productId, BigDecimal flashPrice, int flashQuantity, LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
        if (productId <= 0) {
            throw new IllegalArgumentException("ID san pham khong hop le");
        }
        if (flashPrice == null || flashPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Gia flash phai lon hon 0");
        }
        if (flashQuantity <= 0) {
            throw new IllegalArgumentException("So luong flash phai lon hon 0");
        }
        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("Thoi gian khong hop le");
        }
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Thoi gian bat dau phai truoc thoi gian ket thuc");
        }

        Product product = productDAO.findById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Khong tim thay san pham");
        }

        if (flashPrice.compareTo(product.getPrice()) >= 0) {
            throw new IllegalArgumentException("Gia flash phai thap hon gia goc");
        }

        if (flashQuantity > product.getStock()) {
            throw new IllegalArgumentException("So luong flash vuot qua ton kho");
        }

        FlashSale existing = flashSaleDAO.findByProductId(productId);
        if (existing != null && existing.isActive()) {
            throw new IllegalArgumentException("San pham dang co chuong trinh flash sale");
        }

        FlashSale flashSale = new FlashSale();
        flashSale.setProductId(productId);
        flashSale.setFlashPrice(flashPrice);
        flashSale.setFlashQuantity(flashQuantity);
        flashSale.setStartTime(startTime);
        flashSale.setEndTime(endTime);

        return flashSaleDAO.save(flashSale);
    }

    public boolean updateFlashSale(int id, BigDecimal flashPrice, int flashQuantity, LocalDateTime startTime, LocalDateTime endTime) throws SQLException {
        FlashSale flashSale = flashSaleDAO.findById(id);
        if (flashSale == null) {
            throw new IllegalArgumentException("Khong tim thay chuong trinh flash sale");
        }

        flashSale.setFlashPrice(flashPrice);
        flashSale.setFlashQuantity(flashQuantity);
        flashSale.setStartTime(startTime);
        flashSale.setEndTime(endTime);

        return flashSaleDAO.update(flashSale);
    }

    public boolean deleteFlashSale(int id) throws SQLException {
        FlashSale flashSale = flashSaleDAO.findById(id);
        if (flashSale == null) {
            throw new IllegalArgumentException("Khong tim thay chuong trinh flash sale");
        }
        return flashSaleDAO.delete(id);
    }

    public boolean purchaseFlashSale(int flashSaleId, int quantity) throws SQLException {
        FlashSale flashSale = flashSaleDAO.findById(flashSaleId);
        if (flashSale == null) {
            throw new IllegalArgumentException("Khong tim thay chuong trinh flash sale");
        }

        if (!flashSale.isActive()) {
            throw new IllegalArgumentException("Chuong trinh flash sale khong con hieu luc");
        }

        if (quantity > flashSale.getFlashQuantity()) {
            throw new IllegalArgumentException("So luong flash khong du");
        }

        return flashSaleDAO.updateFlashQuantity(flashSaleId, quantity);
    }

    public FlashSale getFlashSaleById(int id) throws SQLException {
        return flashSaleDAO.findById(id);
    }
}