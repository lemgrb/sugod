*** Settings ***
Library    SeleniumLibrary

*** Variables ***

*** Keywords ***
Begin Web Test
    open browser    about:blank    ${BROWSER}    http://10.0.0.38:4444
    maximize browser window
End Web Test
    close browser
Prepare Test Data
    log    Preparing test data (TBD)
Cleanup Test Data
    log    Cleaning up test data (TBD)