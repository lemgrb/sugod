*** Settings ***
Library    SeleniumLibrary

*** Keywords ***
# TODO: Add assertion for increment
Add Another Item
    click element    css=svg[title="Increment quantity"]
Checkout Cart
    click button    Checkout
Continue Shoppping
    click button    Continue shopping
    click image    home
# TODO: Make generic
Verify Sticker Is Added To Cart
    [Arguments]    ${sticker}
    wait until page contains    ${sticker}
Verify Cart Is Empty
    wait until page contains    Your cart is empty.