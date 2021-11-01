*** Settings ***
Documentation    Add to cart
Resource    ../../../Resources/Common.robot
Resource    ../../../Resources/eCommerce.WebApp.robot
Suite Setup    Prepare Test Data
Test Setup    Begin Web Test
Test Teardown    End Web Test
Suite Teardown    Cleanup Test Data

*** Variables ***
${BROWSER} =    ff

*** Test Cases ***
Empty cart
    [Tags]    wip
    eCommerce.WebApp.Open Homepage
    eCommerce.WebApp.View Cart
    eCommerce.WebApp.Verify cart is empty
    SeleniumLibrary.capture page screenshot
Add a single product to cart
    [Tags]    regression
    eCommerce.WebApp.Open Homepage
    eCommerce.WebApp.Add Product To Cart
    eCommerce.WebApp.Checkout
    eCommerce.WebApp.Verify Checkout page is displayed

Add two products to cart
    [Tags]    regression
    eCommerce.WebApp.Open Homepage
    eCommerce.WebApp.Add Product To Cart
    eCommerce.WebApp.Add Another Product to Cart
    eCommerce.WebApp.Checkout
    eCommerce.WebApp.Verify Checkout page is displayed

Add multiple items of single product to cart
    [Tags]    regression
    eCommerce.WebApp.Open Homepage
    eCommerce.WebApp.Add Product To Cart
    eCommerce.WebApp.Add Another Item
    eCommerce.WebApp.Add Another Item
    eCommerce.WebApp.Add Another Item
    eCommerce.WebApp.Checkout
    eCommerce.WebApp.Verify Checkout page is displayed