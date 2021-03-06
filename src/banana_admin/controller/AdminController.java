package banana_admin.controller;

import java.util.ArrayList;

import banana_admin.dao.AdminDao;
import banana_admin.domain.Admin;
import banana_admin.view.AlertView;
import banana_admin.view.DeleteAdminView;
import banana_admin.view.InsertAdminView;
import banana_admin.view.MenuAdminView;
import banana_admin.view.SelectAllAdminView;
import banana_admin.view.UpdateAdminView;

public class AdminController {

   private AdminDao adminDao;

   public AdminController() {

      adminDao = new AdminDao();

   }
   
   public void goToMenu() {
      
      MenuAdminView menuAdminView = new MenuAdminView();
      menuAdminView.adminMenuView();
      
      
   }

   public void menuViewToInsertView(){
      
         InsertAdminView insertAdminView = new InsertAdminView();
         insertAdminView.insertAdminView();
         
   }

   public void requestRegisterAdmin(Admin adminDomain){

      //dao로 보내기.

      boolean success = adminDao.insertAdmin(adminDomain);

      if(success){
         AlertView alertView = new AlertView();
         alertView.alert("관리자 등록에 성공했습니다.");

      } else {
         System.out.println("관리자 등록에 실패했습니다.");
      }
   }

   //관리자 목록 
   public void requestSelectAllAdmin() {

      ArrayList<Admin> adminSelectAll = adminDao.adminSelectAll();

      SelectAllAdminView adminSelectAllView = new SelectAllAdminView();
      adminSelectAllView.adminSelectAll(adminSelectAll);

   }

   public void requestSearchNumberQuery(int searchAdminNumber){
      boolean success = adminDao.searchNumberQuery(searchAdminNumber);
      
      if(success){
         AlertView alertView = new AlertView();
         alertView.alert("관리자가 존재하지 않습니다.");
      } else if(!success){
         
         this.requestUpdateAdmin(searchAdminNumber);
      }
      
   }

   //관리자 수정 번호 요청
   public void requestUpdateAdminNumber() {

      //관리자번호 입력받는 화면
      UpdateAdminView adminUpdateView = new UpdateAdminView();
      adminUpdateView.searchUpdateAdminNumber();
   }

   //관리자 수정 요청
   public void requestUpdateAdmin(int adminNumber) {

		//수정 입력받는 화면
		UpdateAdminView adminUpdateView = new UpdateAdminView();
		adminUpdateView.adminUpdateInfo(adminNumber);

   }

   //관리자 수정
   public void requestUpdateInfo(Admin adminUpdateInfo) {

      //수정 dao 호출
      boolean success = adminDao.updateAdmin(adminUpdateInfo);

      if(success) {
         new AlertView().alert("관리자 수정을 성공했습니다.");
      } else {
         new AlertView().alert("관리자 수정을 실패했습니다.");
      }

   }

   //관리자 삭제
   public void requestDelete() {

		DeleteAdminView adminDeleteView = new DeleteAdminView();

      int searchDeleteAdminNumber = adminDeleteView.searchDeleteAdminNumber();

      boolean success = adminDao.deleteAdmin(searchDeleteAdminNumber);

      if(success) {
         new AlertView().alert("관리자 삭제를 성공했습니다.");
      } else {
         new AlertView().alert("관리자 삭제를 실패했습니다.");
      }

   }
   

}