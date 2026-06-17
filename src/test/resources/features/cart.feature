Feature: Carrito

  Scenario: Agregar producto
    Given usuario logueado
    When agrega un producto al carrito
    Then visualiza producto en carrito