package 과제9.model.dto;

import java.time.LocalDateTime;

public class ProductDto {
    // 1. 멤버변수
    // 1) private
    private int pno;
    private String puser;
    private String pproduct;
    private String pcontent;
    private int pprice;
    private String ppassword;
    private String pdate = LocalDateTime.now().toString();
    private String pstatus = "판매중" ;

    // 2. 생성자
    // 1) 기본생성자

    public ProductDto() {
    }
    // 2) 전체생성자

    public ProductDto(int pno, String puser, String pproduct, String pcontent, int pprice, String ppassword, String pdate, String pstatus) {
        this.pno = pno;
        this.puser = puser;
        this.pproduct = pproduct;
        this.pcontent = pcontent;
        this.pprice = pprice;
        this.ppassword = ppassword;
        this.pdate = pdate;
        this.pstatus = pstatus;
    }

    public ProductDto(String puser, String pproduct, String pcontent, int pprice, String ppassword) {
        this.puser = puser;
        this.pproduct = pproduct;
        this.pcontent = pcontent;
        this.pprice = pprice;
        this.ppassword = ppassword;
        this.pdate = LocalDateTime.now().toString();
        this.pstatus = "판매중" ;
    }

    public ProductDto(int pno, String pproduct, int pprice, String puser, String pdate, String pstatus) {
        this.pno = pno;
        this.puser = puser;
        this.pproduct = pproduct;
        this.pprice = pprice;
        this.pdate = pdate;
        this.pstatus = pstatus;
    }

    public ProductDto(int pno, String ppassword, String pproduct, String pcontent, int pprice, String pstatus) {
        this.pno = pno;
        this.pproduct = pproduct;
        this.pcontent = pcontent;
        this.pprice = pprice;
        this.ppassword = ppassword;
        this.pstatus = pstatus;
    }

    public ProductDto(int pno, String ppassword) {
        this.pno = pno;
        this.ppassword = ppassword;
    }

    public ProductDto(String puser) {
        this.puser = puser;
    }


    // 3. 메소드
    // 1.) setter
    // 2.) getter

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPuser() {
        return puser;
    }

    public void setPuser(String puser) {
        this.puser = puser;
    }

    public String getPproduct() {
        return pproduct;
    }

    public void setPproduct(String pproduct) {
        this.pproduct = pproduct;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent;
    }

    public int getPprice() {
        return pprice;
    }

    public void setPprice(int pprice) {
        this.pprice = pprice;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    // 3.) toString


    @Override
    public String toString() {
        return "ProductDto{" +
                "pno=" + pno +
                ", puser='" + puser + '\'' +
                ", pproduct='" + pproduct + '\'' +
                ", pcontent='" + pcontent + '\'' +
                ", pprice=" + pprice +
                ", ppassword='" + ppassword + '\'' +
                ", pdate='" + pdate + '\'' +
                ", pstatus='" + pstatus + '\'' +
                '}';
    }
}
