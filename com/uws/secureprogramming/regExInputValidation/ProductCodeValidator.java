package com.uws.secureprogramming.regExInputValidation;

public class ProductCodeValidator implements iProductValidator {

    private static final String PRODUCT_CODE_REGEX = "^[A-Z]{3}-[0-9]{4}$";

    @Override
    public boolean isValidProductCode(String productCode) {
        if (productCode == null || productCode.isEmpty()) {
            return false;
        }
       return productCode.matches(PRODUCT_CODE_REGEX);
    }

}
