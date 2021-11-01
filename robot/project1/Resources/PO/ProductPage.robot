*** Settings ***
Library    SeleniumLibrary

*** Keywords ***
Add To Cart
    click button    Add to cart
    wait until page contains    Cart summary
    sleep    3
Verify Page Is Displayed
    wait until page contains    Add to cart
