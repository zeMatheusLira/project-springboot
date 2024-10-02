package com.teteuweb.project.config;

import com.teteuweb.project.dtos.CategoryRequestDTO;
import com.teteuweb.project.dtos.CategoryResponseDTO;
import com.teteuweb.project.dtos.ProductRequestDTO;
import com.teteuweb.project.dtos.UserRequestDTO;
import com.teteuweb.project.entities.*;
import com.teteuweb.project.entities.enums.OrderStatus;
import com.teteuweb.project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired //o spring vai resolver a independencia e associar a uma instancia de UserRepository
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        CategoryRequestDTO dtoCat1 = new CategoryRequestDTO("Electronics");
        CategoryRequestDTO dtoCat2 = new CategoryRequestDTO("Books");
        CategoryRequestDTO dtoCat3 = new CategoryRequestDTO("Computers");

        Category cat1 = new Category(dtoCat1);
        Category cat2 = new Category(dtoCat2);
        Category cat3 = new Category(dtoCat3);

        ProductRequestDTO dtoP1 = new ProductRequestDTO("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "", null);
        ProductRequestDTO dtoP2 = new ProductRequestDTO( "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "",null);
        ProductRequestDTO dtoP3 = new ProductRequestDTO( "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "", null);
        ProductRequestDTO dtoP4 = new ProductRequestDTO( "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "", null);
        ProductRequestDTO dtoP5 = new ProductRequestDTO( "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "", null);

        Product p1 = new Product(dtoP1);
        Product p2 = new Product(dtoP2);
        Product p3 = new Product(dtoP3);
        Product p4 = new Product(dtoP4);
        Product p5 = new Product(dtoP5);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        UserRequestDTO dto1 = new UserRequestDTO(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserRequestDTO dto2 = new UserRequestDTO(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        User u1 = new User(dto1);
        User u2 = new User(dto2);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1,u2)); //salva a lista no banco de dados
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
        o1.setPayment(pay1);

        orderRepository.save(o1);


    }
}
