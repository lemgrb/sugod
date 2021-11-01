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
# TODO: Make generic
Verify React Sticker Is Added To Cart
    wait until page contains    React
Verify Python Sticker Is Added To Cart
    wait until page contains    React
Verify Cart Is Empty
    wait until page contains    Your cart is empty.