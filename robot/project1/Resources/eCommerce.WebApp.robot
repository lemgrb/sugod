*** Settings ***
Library    SeleniumLibrary
Resource    PO/HomePage.robot
Resource    PO/ProductPage.robot
Resource    PO/Cart.robot
Resource    PO/Checkout.robot
*** Variables ***

*** Keywords ***

Open Homepage
    HomePage.load
    HomePage.Verify Page Is Displayed
View Cart
    HomePage.View Cart
Add Product To Cart
    [Arguments]    ${sticker}
    HomePage.Select sticker    ${sticker}
    ProductPage.Verify Page Is Displayed    ${sticker}
    ProductPage.Add To Cart
    Verify Sticker Is Added To Cart    ${sticker}
Add Another Item
    Cart.Add Another Item
Add Another Product to Cart
    [Arguments]    ${another_sticker}
    Cart.Continue Shoppping
    Add Product To Cart    ${another_sticker}
Checkout
    Cart.Checkout Cart
Verify Checkout page is displayed
    Checkout.Verify Page Is Displayed
Verify cart is empty
    Cart.Verify Cart Is Empty
