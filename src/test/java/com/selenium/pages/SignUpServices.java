package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class SignUpServices  extends  BasePage{

    @Autowired
    public SignUpServices(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath =" //input[@ng-model='FirstName']" )
    private WebElement firstNameTextBox;
    @FindBy(xpath ="//input[@ng-model='LastName']")
    private WebElement lastNameTextBox;
    @FindBy(tagName ="textarea")
    private WebElement addressTextBox;
    @FindBy(xpath ="//input[@type='email']")
    private WebElement emailTextBox;
    @FindBy(xpath ="//input[@type='tel']")
    private WebElement phoneTextBox;
    @FindBy(xpath ="//input[@value='Male']")
    private WebElement GenderMaleRadioButton;
    @FindBy(id ="countries")
    private WebElement countries;
    @FindBy(id ="yearbox")
    private WebElement year;
    @FindBy(xpath ="//select[@placeholder='Month']")
    private WebElement month;
    @FindBy(id ="daybox")
    private WebElement day;
    @FindBy(id ="firstpassword")
    private WebElement password;
    @FindBy(id ="secondpassword")
    private WebElement confirmPassword;
    @FindBy(id ="submitbtn")
    private WebElement submitbutton;

    //private WebDriver driver;

    public void go(String url) {
        webDriver.get(url);
    }

    public void closeDriver(){
        webDriver.quit();
    }

    long theRandomNum;
    long number1 = 9000000000L;

    {
        theRandomNum = Long.valueOf((long) (Math.floor(Math.random() * number1) + 1000000000));
    }

    String phoneNumber = String.valueOf(theRandomNum);


    public void writeFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOf(firstNameTextBox));
        firstNameTextBox.sendKeys(firstname);
    }
/*
    public void writeLastName(String lastName) {
        this.signUpPageObject.getLastNameTextBox().sendKeys(lastName);
    }

    public void writeAddress(String address) {
        this.signUpPageObject.getAddressTextBox().sendKeys(address);
    }

    public void writeEmail(String email) {
        this.signUpPageObject.getEmailTextBox().sendKeys(email);
    }

    public void writePhone() {
        this.signUpPageObject.getPhoneTextBox().sendKeys(phoneNumber);
    }

    public void clickGender() {
        this.signUpPageObject.getGenderMaleRadioButton().click();
    }

    public void selectCountry(String country) {
        new Select(this.signUpPageObject.getCountries()).selectByValue(country);
    }

    public void selectYear(String year) {
        new Select(this.signUpPageObject.getYear()).selectByValue(year);
    }

    public void selectMonth(String month) {
        new Select(this.signUpPageObject.getMonth()).selectByValue(month);
    }

    public void selectDay(String day) {
        new Select(this.signUpPageObject.getDay()).selectByValue(day);
    }

    public void writePassword(String password) {
        this.signUpPageObject.getPassword().sendKeys(password);
    }

    public void writeConfirmPassword(String password) {
        this.signUpPageObject.getConfirmPassword().sendKeys(password);
    }

    public void clickSubmitButton() {
        this.signUpPageObject.getSubmitbutton().click();
    }*/

}
