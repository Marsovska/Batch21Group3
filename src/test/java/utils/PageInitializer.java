package utils;

import pages.*;

public class PageInitializer {
    public static LoginPage loginPage;
    public static essDashboardPage ESS_dashboard_Page;
    public static essUserUpdatePage ESS_user_update_Page;
    public static CreatingLogCredentialsPage creatingLogCredentialsPage;
    public static drDashboardPage drDashboardPage;
    public static EmployeeDependentsPage employeeDependentsPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddingEmployeePage addingEmployeePage;

    public static void activatePageObjects() {

        ESS_dashboard_Page = new essDashboardPage();
        ESS_user_update_Page = new essUserUpdatePage();
        loginPage = new LoginPage();
        creatingLogCredentialsPage = new CreatingLogCredentialsPage();
        drDashboardPage = new drDashboardPage();
        employeeDependentsPage = new EmployeeDependentsPage();
        employeeSearchPage = new EmployeeSearchPage();
        addingEmployeePage = new AddingEmployeePage();

    }
}
