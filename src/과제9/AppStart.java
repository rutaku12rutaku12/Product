package 과제9;

import 과제9.controller.ProductController;
import 과제9.view.ProductView;

public class AppStart { // class start

    public static void main(String[] args) { // main start

        // 1. 등록 테스트 성공 -> 주석처리
        // boolean result = ProductController.getInstance().productCreate("테스터", "테스터물건", "테스트 내용.", 100, "tpassword");
        // System.out.println(result);


        // * 메인화면 호출
         ProductView.getInstance().index();


    } // main end
} // class end

// 명세서
// https://docs.google.com/spreadsheets/d/1nrr3Jcm32zF558L4eh-wEHm5TN4NoYwewDm5q6EGIjI/edit?gid=1362336950#gid=1362336950