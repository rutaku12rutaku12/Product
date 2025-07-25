package 과제9.view;

import 과제9.controller.ProductController;
import 과제9.model.dto.ProductDto;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {
    // *) 싱글톤
    private ProductView(){}
    private static final ProductView instance = new ProductView();
    public static ProductView getInstance(){
        return instance;
    }

    // (*) 모든 메소드가 사용 가능하도록 메소드 밖에 입력객체 생성
    private Scanner scan = new Scanner(System.in);
    // (*) 싱글톤 가져오기
    private ProductController productController = ProductController.getInstance();

    // (*) 메인화면
    public void index(){
        for( ; ; ){
            try{
                System.out.println(" ================ 뚝딱마켓 ================");
                System.out.println(" 1.물품등록 2.물품조회 3.물품수정 4.물품삭제 ");
                System.out.println(" 5.물품문의 6.상세조회 7.랭킹조회 8.검색조회");
                System.out.println(" ========================================");
                System.out.println("선택>");
                int choose=scan.nextInt();
                if( choose == 1 ){productCreate();}
                else if( choose == 2){productRead();}
                else if( choose == 3){productUpdate();}
                else if( choose == 4){productDelete();}
                else if( choose == 7){}
                else{System.out.println("[경고] 존재하지 않는 번호 입니다.");}
            }catch (InputMismatchException e){
                System.out.println("[경고] 숫자 타입이 아닙니다. <다시 입력>");
                scan = new Scanner(System.in); // 입력객체 초기화
            }catch (Exception e){System.out.println("[오류] 관리자에게 문의");}
        } // for end
    } // func end

    // (1) 등록화면 구현
    public void productCreate(){
        // 1. 입력받기
        System.out.println("닉네임을 입력하세요. : "); String puser = scan.next();
        System.out.println("물품명을 입력하세요. : "); String pproduct = scan.next();
        System.out.println("물품 설명을 입력하세요. : "); String pcontent = scan.next();
        System.out.println("가격을 입력하세요. : "); int pprice = scan.nextInt();
        System.out.println("비밀번호을 입력하세요. : "); String ppassword = scan.next();
        // 2. controller 전달 // 3. 전달후 리턴값 저장
        boolean result = productController.productCreate( puser, pproduct , pcontent , pprice, ppassword);
        // 4. 리턴된 값 에 따른 출력
        if( result ){System.out.println("[안내] 물품등록 성공");}
        else {System.out.println("[경고] 물품등록 실패 ");}
    } // func end

    // (2) 전체 물품 목록 조회화면 구현
    public void productRead(){
        // 1. controller 에게 요청후 결과 받기
        ArrayList<ProductDto> result = productController.productRead();
        System.out.println("==============  판매 물품 목록  ==============");
        for(ProductDto dto : result ){
            // 2. 결과에 따른 화면 구현
            System.out.println("번호: "+dto.getPno());
            System.out.println("물품명: "+dto.getPproduct());
            System.out.println("가격: "+dto.getPprice());
            System.out.println("닉네임: "+dto.getPuser());
            System.out.println("등록일: "+dto.getPdate());
            System.out.println("판매여부: "+dto.getPstatus());
            System.out.println("--------------------------------------------");
        } // for end
    } // func end

    // (3) 물품 정보 수정화면 구현
    public void productUpdate(){
        // 1. 입력받기
        System.out.println("수정할 번호: "); int pno = scan.nextInt();
        System.out.println("비밀번호: ");    String ppassword = scan.next();
        System.out.println("물품명: "); String pproduct = scan.next();
        System.out.println("설명: "); String pcontent = scan.next();
        System.out.println("가격: "); int pprice = scan.nextInt();
        System.out.println("판매여부: "); String pstatus = scan.next();
        // 2. controller 전달하기 // 3. 전달후 리턴값 저장
        boolean result = productController.productUpdate( pno , ppassword , pproduct , pcontent , pprice, pstatus);
        // 4. 리턴 값에 따른 출력
        if( result ) System.out.println("[안내] 수정 성공");
        else {System.out.println("[경고] 번호가 없거나 비밀번호가 다릅니다.");}
    }// func end

    // (4) 등록 물품 삭제화면 구현
    public void productDelete(){
        // 1. 입력받기
        System.out.println("삭제할 번호: "); int pno = scan.nextInt();
        System.out.println("비밀번호: "); String ppassword = scan.next();
        // 2. controller 전달하기 // 3. 전달후 리턴값 저장
        boolean result = productController.productDelete(pno, ppassword);
        // 4. 리턴 값에 따른 출력
        if( result ){ System.out.println("[안내]삭제 성공");}
        else {System.out.println("[경고] 번호가 없거나 비밀번호가 다릅니다.");}
    }

    // (7) 랭킹 조회기능 구현
    public void rankPrint(){
        System.out.println("==============  등록 랭킹 조회  ==============");
        System.out.println("\uD83E\uDD471위: 회");
        System.out.println("\uD83E\uDD482위: 회");
        System.out.println("\uD83E\uDD493위: 회");
        System.out.println("4위: 회");
        System.out.println("5위: 회");
        System.out.println("6위: 회");
        System.out.println("7위: 회");
        System.out.println("8위: 회");
        System.out.println("9위: 회");
        System.out.println("10위: 회");
    }

} // class end
