package ru.ecodil.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.ServerSocket;

@SpringBootApplication
public class EcodilShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcodilShopApplication.class, args);
        System.out.println("Ecodil Shop Backend part started successfully on hostname");
        try {
            // Получаем локальный адрес хоста (hostname)
            String localhost = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Hostname: " + localhost);
        } catch (Exception e) {
            System.err.println("Error getting app info: " + e.getMessage());
        }
    }

}
