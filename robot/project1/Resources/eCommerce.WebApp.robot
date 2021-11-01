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
    [Arguments]
    HomePage.Filter All Back stickers
    HomePage.Select React sticker
    ProductPage.Verify Page Is Displayed
    ProductPage.Add To Cart
    Verify React Sticker Is Added To Cart
Add Another Item
    Cart.Add Another Item
Add Another Product to Cart
    Cart.Continue Shoppping
    HomePage.Filter All Front stickers
    HomePage.Select Python sticker
    ProductPage.Verify Page Is Displayed
    ProductPage.Add To Cart
    Verify React Sticker Is Added To Cart
    Verify Python Sticker Is Added To Cart
Checkout
    Cart.Checkout Cart
Verify Checkout page is displayed
    Checkout.Verify Page Is Displayed
Verify cart is empty
    Cart.Verify Cart Is Empty
