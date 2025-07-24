package 과제9.controller;

import 과제9.model.dao.ProductDao;
import 과제9.model.dto.ProductDto;

public class ProductController {
    // *) 싱글톤
    private ProductController(){}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance(){
        return instance;
    }

    // (*) 싱글톤 가져오기
    private ProductDao productDao = ProductDao.getInstance();

    // (1) 등록 기능 구현
    public boolean productCreate( String puser, String pproduct, String pcontent, int pprice, String ppassword){
        // 1.유효성검사 pass
        // 2.객체화
        ProductDto productDto = new ProductDto(puser, pproduct, pcontent, pprice, ppassword );
        // 3. dto를  dao에게 전달후 결과를 받는다.
        boolean result = productDao.productCreate(productDto);
        // 4. 결과를 view에게 리턴한다.
        return result;

    }
} //class end
