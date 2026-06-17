Feature: Checkout

  Scenario: Compra exitosa
    Given usuario con producto en carrito
    When completa el checkout
    Then visualiza confirmación