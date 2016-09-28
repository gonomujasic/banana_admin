package banana_admin.controller;

<<<<<<< HEAD

import java.util.ArrayList;

import banana_admin.dao.AdminDao;
import banana_admin.domain.AdminDomain;
import banana_admin.view.AlertView;
import banana_admin.view.InsertAdminView;

public class AdminController {

	AdminDao adminDao;
=======
import java.util.ArrayList;

import banana_admin.dao.AdminDao;
import banana_admin.domain.Admin;
import banana_admin.view.AlertView;
import banana_admin.view.InsertAdminView;
import banana_admin.view.MenuAdminView;
import banana_admin.view.deleteAdminView;
import banana_admin.view.selectAllAdminView;
import banana_admin.view.updateAdminView;

public class AdminController {

	private AdminDao adminDao;
>>>>>>> refs/remotes/yuns111/master

	public AdminController() {

		adminDao = new AdminDao();

	}
<<<<<<< HEAD

	public void menuViewToInsertView(){
		InsertAdminView insertAdminView = new InsertAdminView();
		insertAdminView.insertAdminView();
	}

	public void RegisterProcess(AdminDomain adminDomain){

		this.requestRegisterAdmin(adminDomain);

	};

	public void requestRegisterAdmin(AdminDomain adminDomain){
=======
	
	public void goToMenu() {
		
		MenuAdminView menuAdminView = new MenuAdminView();
		menuAdminView.adminMenuView();
		
		
	}

	public void menuViewToInsertView(){
		
	      InsertAdminView insertAdminView = new InsertAdminView();
	      insertAdminView.insertAdminView();
	      
	}

	public void requestRegisterAdmin(Admin adminDomain){
>>>>>>> refs/remotes/yuns111/master

		//dao로 보내기.

		boolean success = adminDao.insertAdmin(adminDomain);

		if(success){
			AlertView alertView = new AlertView();
<<<<<<< HEAD
			alertView.alertView("관리자 등록에 성공했습니다.");
=======
			alertView.alert("관리자 등록에 성공했습니다.");
>>>>>>> refs/remotes/yuns111/master

		} else {
			System.out.println("관리자 등록에 실패했습니다.");
		}
	}

<<<<<<< HEAD
	public ArrayList<AdminDomain> requestSelectAllAdmin(){

		ArrayList<AdminDomain> adminInfo= null;
		//dao에서 정보 받아오기
		adminInfo = adminDao.selectAllAdmin();
		//view에서 호출 받기
		return adminInfo;
	}
}
=======
	//관리자 목록 
	public void requestSelectAllAdmin() {

		ArrayList<Admin> adminSelectAll = adminDao.adminSelectAll();

		selectAllAdminView adminSelectAllView = new selectAllAdminView();
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
		updateAdminView adminUpdateView = new updateAdminView();
		adminUpdateView.searchUpdateAdminNumber();

	}

	//관리자 수정 요청
	public void requestUpdateAdmin(int adminNumber) {

		//수정 입력받는 화면
		updateAdminView adminUpdateView = new updateAdminView();
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

		deleteAdminView adminDeleteView = new deleteAdminView();

		int searchDeleteAdminNumber = adminDeleteView.searchDeleteAdminNumber();

		boolean success = adminDao.deleteAdmin(searchDeleteAdminNumber);

		if(success) {
			new AlertView().alert("관리자 삭제를 성공했습니다.");
		} else {
			new AlertView().alert("관리자 삭제를 실패했습니다.");
		}

	}
	
	

}
>>>>>>> refs/remotes/yuns111/master
