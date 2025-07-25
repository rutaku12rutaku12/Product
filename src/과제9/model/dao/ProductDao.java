package 과제9.model.dao;

import 과제9.model.dto.ProductDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
    // *) 싱글톤
    private ProductDao(){connect();}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance(){
        return instance;
    }

    // (*) DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/assignment9";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    private void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,db_user,db_password);
        }catch (Exception e){System.out.println(e);}
    } // func end

    // (1) 등록기능 구현
    public boolean productCreate( ProductDto productDto) {
        try {
            // 1. SQL 작성
            String sql = "INSERT INTO products (puser, pproduct, pcontent, pprice, ppassword ) VALUES ( ? , ? , ? , ? , ? )";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입 , 현재 ? 5개
            ps.setString(1, productDto.getPuser());     // 매개변수 ProductDto의 puser 받은 값 1번째 ? 대입
            ps.setString(2, productDto.getPproduct());  // 매개변수 ProductDto의 pproduct 받은 값 2번째 ? 대입
            ps.setString(3,productDto.getPcontent());   // 매개변수 ProductDto의 pcontent 받은 값 3번째 ? 대입
            ps.setInt(4, productDto.getPprice());       // 매개변수 ProductDto의 pprice 받은 값 4번째 ? 대입
            ps.setString(5,productDto.getPpassword());  // 매개변수 ProductDto의 ppassword 받은 값 5번째 ? 대입
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count >= 1) return true; // 1개 이상 insert 했으면 저장성공
            return false; // 1개 이상 insert 했으면 저장실패
        } catch (Exception e) {System.out.println(e);}
        return false; // 예외 발생시 저장실패
    } // func end



    // (2) 전체 물품 목록 조회 구현
    public ArrayList<ProductDto> productRead(){
        ArrayList<ProductDto> list = new ArrayList<>(); // 조회된 레코드(DTO) 들을 저장할 리스트 선언
        try {
            // 1. SQL 작성
            String sql = "select * from products";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입 , 매개변수 X
            // 4. SQL 실행
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
                // 1) select 조회 결과를 레코드 하나씩 조회
            while ( rs.next()){
                // 2) 현재 조회중인 레코드의 속성값 호출해서 dto 만들기
                int pno = rs.getInt("pno"); // rs.get타입(가져올 속성명or번호)
                String pproduct = rs.getString("pproduct");
                int pprice = rs.getInt("pprice");
                String puser = rs.getString("puser");
                String pdate = rs.getString("pdate");
                String pstatus = rs.getString("pstatus");
                ProductDto productDto = new ProductDto( pno , pproduct , pprice , puser , pdate , pstatus );
                // 3) 생성된 dto를 리스트에 담아주기
                list.add( productDto );
            } // while end
        }catch (Exception e){System.out.println(e);}
        return list;
    } // func end

    // (3) 물품 정보 수정 구현
    public boolean productUpdate(ProductDto productDto){
        // 1. SQL 작성
        try{String sql = "update products set pproduct = ?, pcontent = ?, pprice = ? ,pstatus = ?  where pno = ? and ppassword = ?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입 , ? 6개
            ps.setString(1,productDto.getPproduct());
            ps.setString(2,productDto.getPcontent());
            ps.setInt(3,productDto.getPprice());
            ps.setString(4,productDto.getPstatus());
            ps.setInt(5,productDto.getPno());
            ps.setString(6,productDto.getPpassword());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 )return true; // 수정 sql 결과가 1개이면 수정성공
            return false; // 수정 sql 결과가 1이 아니면 수정 실패
        }catch (Exception e){System.out.println(e);}
        return false; // 예외발생시 수정실패
    } // func end

    // (4) 등록 물품 삭제 구현
    public boolean productDelete( ProductDto productDto ){
             // 1. SQL 작성
        try { String sql = "delete from products where pno=? and ppassword=?";
            // 2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt(1,productDto.getPno());
            ps.setString(2, productDto.getPpassword());
            // 4. SQL 실행
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) return true; // 삭제 sql 결과가 1이면 삭제 성공
            return false; // 삭제 sql 결과가 1이 아니면 삭제 실패
        }catch (Exception e){System.out.println(e);}
        return false; // 예외발생시 삭제실패
    }



} // class end



















