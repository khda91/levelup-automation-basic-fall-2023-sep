Feature: Register new user on usersbugred.ru
    In order to .....
    As a user
    I want to ....

    @smoke
    Scenario: Register new user
        Given I open UsersBugRed site
        And I click to Войти button in the Header on the Main page
        When I set 'Tyhyhhhbbvb' to the Имя text field in Registration section on the Login Registration page
        When I set 'tyhyhhhbbb@mail.ru' to the Email text field in Registration section on the Login Registration page
        When I set '123456789' to the Пароль text field in Registration section on the Login Registration page
        When I click to Зарегистрироваться button in Registration section on the Login Registration page
        Then username in the header should be equal to the 'Tyhyhhhbbvb' on the Main page

    Scenario Outline: Register multiple users
        Given I open UsersBugRed site
        And I click to Войти button in the Header on the Main page
        When I register user with following parameters
            | username   | email   | password   |
            | <username> | <email> | <password> |
        Then username in the header should be equal to the '<username>' on the Main page

        Examples:
            | username | email             | password |
            | kkijjsds | kkijjsds@sds.sd   | 123456   |
            | sadfasd  | advadsvasd@sds.sd | 123456   |

    Scenario Outline: Register new use1r
        Given I open UsersBugRed site
        And I click to Войти button in the Header on the Main page
        When I set '<username>' to the Имя text field in Registration section on the Login Registration page
        When I set '<email>' to the Email text field in Registration section on the Login Registration page
        When I set '<password>' to the Пароль text field in Registration section on the Login Registration page
        When I click to Зарегистрироваться button in Registration section on the Login Registration page
        Then username in the header should be equal to the '<username>' on the Main page

        Examples:
            | username | email             | password |
            | kkijjsds | kkijjsds@sds.sd   | 123456   |
            | sadfasd  | advadsvasd@sds.sd | 123456   |
