*** Settings ***
Documentation    Add to cart | No actual checking out
Resource    ../../../Resources/Common.robot
Resource    ../../../Resources/eCommerce.WebApp.robot
Suite Setup    Prepare Test Data
Test Setup    Begin Web Test
Test Teardown    End Web Test
Suite Teardown    Cleanup Test Data

*** Variables ***
${BROWSER} =    ff

*** Test Cases ***
Logged out user should see empty cart by default
    [Tags]    regression
    eCommerce.WebApp.Open Homepage
    eCommerce.WebApp.View Cart
    eCommerce.WebApp.Verify cart is empty
    SeleniumLibrary.capture page screenshot
Logged out should be able to add a single product to cart
    [Tags]    wip
    eCommerce.WebApp.Open Homepage
    ${first_sticker} =    set variable    React
    eCommerce.WebApp.Add Product To Cart    ${first_sticker}
    eCommerce.WebApp.Checkout
    eCommerce.WebApp.Verify Checkout page is displayed

Logged out user should be able to add two products to cart
    [Tags]    regression
    eCommerce.WebApp.Open Homepage
    ${first_sticker} =    set variable    MongoDB
    ${another_sticker} =    set variable    Python
    eCommerce.WebApp.Add Product To Cart    ${first_sticker}
    eCommerce.WebApp.Add Another Product to Cart     ${another_sticker}
    eCommerce.WebApp.Checkout
    eCommerce.WebApp.Verify Checkout page is displayed

Logged out user should be able to add more than quantity of the same product to cart
    [Tags]    regression
    eCommerce.WebApp.Open Homepage
    ${sticker} =    set variable    Docker
    eCommerce.WebApp.Add Product To Cart    ${sticker}
    eCommerce.WebApp.Add Another Item
    eCommerce.WebApp.Add Another Item
    eCommerce.WebApp.Add Another Item
    eCommerce.WebApp.Checkout
    eCommerce.WebApp.Verify Checkout page is displayed