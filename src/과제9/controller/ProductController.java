package 과제9.controller;

import 과제9.model.dao.ProductDao;
import 과제9.model.dto.ProductDto;

import java.util.ArrayList;

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
    } // func end

    // (2) 전체 물품 목록 조회 구현
    public ArrayList<ProductDto> productRead(){
        // dao에게 전달후 결과 받는다.
        ArrayList<ProductDto> result = productDao.productRead();
        // 결과를 view에게 리턴
        return result;
    } // func end

    // (3) 물품 정보 수정 기능 구현
    public boolean productUpdate( int pno , String ppassword, String pproduct , String pcontent , int pprice , String pstatus){
        // 1.유효성검사
        // 2.객체화
        ProductDto productDto = new ProductDto( pno , ppassword , pproduct , pcontent , pprice , pstatus);
        // 3. dao 에게 수정할 번호 전달후 결과 받기
        boolean result = productDao.productUpdate(productDto);
        // 4. 결과를 view 에게 리턴
        return result;
    }

    // (4) 등록 물품 삭제 구현
    public boolean productDelete( int pno, String ppassword){
        // 1.유효성검사
        // 2.객체화
        ProductDto productDto = new ProductDto(pno , ppassword);
        // 3. dao 에게 삭제할 번호 전달후 결과를 받는다.
        boolean result = productDao.productDelete(productDto);
        // 4. 결과를 view에 리턴한다.
        return result;
    } // func end

    // (7) 랭킹 조회기능 구현
    public ArrayList<ProductDto> rankPrint(){
        // dao 에게 전달 받는다
        ArrayList<ProductDto> result = productDao.rankPrint();
        // 결과를 view 에게 리턴
        return result;
    } // func end

} //class end































