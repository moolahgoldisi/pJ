package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;
import utils.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    AddEmployeePage addEmployeePage = new AddEmployeePage();

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        //WebElement firstNameField = driver.findElement(By.id("firstName"));
        //firstNameField.sendKeys("mark");
        sendText("mark", addEmployeePage.firstNameField);
        //WebElement lastNameField = driver.findElement(By.id("lastName"));
        //lastNameField.sendKeys("jacob");
        sendText("jacob", addEmployeePage.lastNameField);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveButton = driver.findElement(By.id("btnSave"));
        //saveButton.click();
        click(addEmployeePage.saveButton);
    }

    @Then("user is able to see employee added successfully")
    public void user_is_able_to_see_employee_added_successfully() {
        System.out.println("Steps will be implemented later");
    }

    @When("user enters firstname and middlename and lastname and ID")
    public void user_enters_firstname_and_middlename_and_lastname_and_id() {
        //WebElement firstNameField = driver.findElement(By.id("firstName"));
        //firstNameField.sendKeys("mark");
        sendText("mark", addEmployeePage.firstNameField);

        //WebElement middleNameField = driver.findElement(By.id("middleName"));
        //middleNameField.sendKeys("ms");
       sendText("ms", addEmployeePage.middleNameField);

        //WebElement lastNameField = driver.findElement(By.id("lastName"));
        //lastNameField.sendKeys("jacob");
        sendText("jacob", addEmployeePage.lastNameField);
        //WebElement idField = driver.findElement(By.id("employeeId"));
        //idField.sendKeys("50423397");
        sendText("50423397", addEmployeePage.idField);
    }




    @When("user enters {string} and {string} and {string} and {string}")
    public void user_enters_and_and_and(String firstName, String middleName, String lastName, String employeeId) {
       // WebElement firstNameField = driver.findElement(By.id("firstName"));
        //firstNameField.sendKeys(firstName);
        sendText(firstName, addEmployeePage.firstNameField);


       // WebElement middleNameField = driver.findElement(By.id("middleName"));
       // middleNameField.sendKeys(middleName);
        sendText(middleName, addEmployeePage.middleNameField);

        //WebElement lastNameField = driver.findElement(By.id("lastName"));
        //lastNameField.sendKeys(lastName);
        sendText(lastName, addEmployeePage.lastNameField);

        //WebElement idField = driver.findElement(By.id("employeeId"));
        //idField.sendKeys(employeeId);
        sendText(employeeId, addEmployeePage.idField);
    }

    @When("user add {string} ,{string} , {string} and {string}")
    public void user_add_and(String fn, String mn, String ln, String id) {
       // WebElement firstNameField = driver.findElement(By.id("firstName"));
       // firstNameField.sendKeys(fn);
        sendText(fn, addEmployeePage.firstNameField);

       // WebElement middleNameField = driver.findElement(By.id("middleName"));
       // middleNameField.sendKeys(mn);
        sendText(mn, addEmployeePage.middleNameField);

        //WebElement lastNameField = driver.findElement(By.id("lastName"));
        //lastNameField.sendKeys(ln);
        sendText(ln, addEmployeePage.lastNameField);

        //WebElement idField = driver.findElement(By.id("employeeId"));
        //idField.sendKeys(id);
        sendText(id, addEmployeePage.idField);



    }

    @When("user adds multiple employees using data table and save them")
    public void user_adds_multiple_employees_using_data_table_and_save_them
            (io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames = dataTable.asMaps();

        for (Map<String, String> employee : employeeNames
        ) {

           // WebElement firstNameField = driver.findElement(By.id("firstName"));
            //WebElement middleNameField = driver.findElement(By.id("middleName"));
            //WebElement lastNameField = driver.findElement(By.id("lastName"));
            //WebElement idField = driver.findElement(By.id("employeeId"));

            //firstNameField.sendKeys(employee.get("firstName"));
            //middleNameField.sendKeys(employee.get("middleName"));
           // lastNameField.sendKeys(employee.get("lastName"));
           // idField.sendKeys(employee.get("employeeId"));
            addEmployeePage.firstNameField.sendKeys(employee.get("firstName"));
            addEmployeePage.middleNameField.sendKeys(employee.get("middleName"));
            addEmployeePage.lastNameField.sendKeys(employee.get("lastName"));
            addEmployeePage.idField.sendKeys(employee.get("employeeId"));

            //WebElement saveButton = driver.findElement(By.id("btnSave"));
           // saveButton.click();
            addEmployeePage.saveButton.click();

            WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmpOption.click();


        }
    }

    @When("user adds multiple employees from excel file")
    public void user_adds_multiple_employees_from_excel_file() throws IOException {
        List<Map<String, String>> newEmployees = ExcelReader.read();
        for (Map<String, String> employee : newEmployees
        ) {
            //WebElement firstNameField = driver.findElement(By.id("firstName"));
           // WebElement middleNameField = driver.findElement(By.id("middleName"));
           // WebElement lastNameField = driver.findElement(By.id("lastName"));
           // WebElement idField = driver.findElement(By.id("employeeId"));

            //firstNameField.sendKeys(employee.get("firstName"));
           // middleNameField.sendKeys(employee.get("middleName"));
            //lastNameField.sendKeys(employee.get("lastName"));
            //idField.sendKeys(employee.get("employeeId"));
            addEmployeePage.firstNameField.sendKeys(employee.get("firstName"));
            addEmployeePage.middleNameField.sendKeys(employee.get("middleName"));
            addEmployeePage.lastNameField.sendKeys(employee.get("lastName"));
            addEmployeePage.idField.sendKeys(employee.get("employeeId"));

            //WebElement saveButton = driver.findElement(By.id("btnSave"));
            //saveButton.click();
            addEmployeePage.saveButton.click();

            WebElement addEmpOption = driver.findElement(By.id("menu_pim_addEmployee"));
            addEmpOption.click();

        }
    }
}

