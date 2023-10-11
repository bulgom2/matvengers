package CONECT;

import java.sql.Blob;

public class stars {
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getUserid() {
      return userid;
   }
   public void setUserid(String userid) {
      this.userid = userid;
   }
   public double getStar() {
      return star;
   }
   public void setStar(double star) {
      this.star = star;
   }
   public String getCmt() {
      return cmt;
   }
   public void setCmt(String cmt) {
      this.cmt = cmt;
   }

   private String name;
   private String userid;
   private double star;
   private String cmt;

}