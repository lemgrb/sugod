*** Settings ***
Library    SeleniumLibrary

*** Keywords ***
Load
    go to    https://strapi-starter-next-ecommerce.vercel.app/

Filter All Back stickers
    click link    Back

Filter All Front stickers
    click link    Front

Select sticker
    [Arguments]    ${sticker}
    click element    xpath=//h4[contains(text(),"${sticker}")]
    wait until page contains    Add to cart


Verify Page Is Displayed
    wait until page contains    Back

View Cart
    click element    css=button.snipcart-checkout
    wait until page contains    Cart summary