Feature: Login SauceDemo

  Scenario: Login exitoso
    Given el usuario abre SauceDemo
    When ingresa usuario "standard_user" y password "secret_sauce"
    Then visualiza la página de productos

  Scenario: Usuario bloqueado
    Given el usuario abre SauceDemo
    When ingresa usuario "locked_out_user" y password "secret_sauce"
    Then visualiza mensaje de error