package 과제9.view;

import 과제9.controller.ProductController;

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
                System.out.println(" 1.물품등록|2.물품조회|3.물품수정|4.물품삭제 ");
                System.out.println(" ========================================");
                System.out.println("선택>");
                int choose=scan.nextInt();
                if( choose == 1 ){productCreate();}
                else if( choose == 2){}
                else if( choose == 3){}
                else if( choose == 4){}
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

} // class end
