*** Settings ***
Documentation    Suite 1
Library    SeleniumLibrary
Library    SeleniumLibrary

*** Variables ***
${Browser}    chrome

*** Test Cases ***
Guest submits form
    [Documentation]    Some information
    [Tags]    Smoke
    open browser    http://formy-project.herokuapp.com/    ${Browser}    http://10.0.0.38:4444
    wait until page contains    Welcome to Formy
    click link    Form
    sleep    1
    wait until page contains    Complete Web Form
    input text    first-name    LEMUEL
    # execute javascript    window.scrollTo(0, document.body.scrollHeight)
    scroll element into view    css:a.btn
    click element    css:a.btn
    wait until page contains    The form was successfully submitted!
    [Teardown]
    close browser
