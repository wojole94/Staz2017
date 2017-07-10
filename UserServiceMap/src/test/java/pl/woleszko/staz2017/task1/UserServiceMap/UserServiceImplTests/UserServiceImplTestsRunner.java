package pl.woleszko.staz2017.task1.UserServiceMap.UserServiceImplTests;
import pl.woleszko.staz2017.task1.UserServiceMap.Service.*;
public class UserServiceImplTestsRunner {

	public static void main(String[] args) {
		UserServiceImplTests tests = new UserServiceImplTests();
		
		tests.testAddUser();
		tests.testGetSingle();
		tests.testGetList();
		tests.testDeleteUser();
		tests.testEditUser();

	}

}
