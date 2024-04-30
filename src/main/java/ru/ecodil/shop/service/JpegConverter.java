package ru.ecodil.shop.service;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ecodil.shop.dao.model.Product;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JpegConverter {

    @Autowired
    ProductService productService;

    public void convert() {
        try {
            Long id = 46L;
            File file = new File("D:\\Project\\" + id + ".jpeg");
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];

            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }

            byte[] imageData = bos.toByteArray();

            fis.close();
            bos.close();
//            adding BLOB to db for product_id = 42;
            Optional<Product> product = productService.getProductById(id);

            if (product.isPresent()) {
                Product product1 = product.get();
                product1.setImageJPEG(imageData);
                productService.updateProduct(id, product1);
            }

//            System.out.println(Arrays.toString(imageData));
            System.out.println("Image successfully converted to BLOB and added to product with id: " + id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void postConstruct() {
        convert();
    }
}
