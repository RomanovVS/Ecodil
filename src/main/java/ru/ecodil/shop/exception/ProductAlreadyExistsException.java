package ru.ecodil.shop.exception;

public class ProductAlreadyExistsException extends Throwable {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
