*** Settings ***
Library               RequestsLibrary

*** Variables ***


*** Keywords ***
Add a book
    Create Session    crudcrud_session    ${ENDPOINT}
    ${body} =    create dictionary     title=Testing    author=Lemuel
    ${header} =    create dictionary    Content-Type=application/json
    ${resp} =    post on session    crudcrud_session    /books    data={body}    headers={header}
    ${json} =    set test variable    ${resp.json()}
    Status Should Be    OK    ${resp}
    Log    ${json}
Get a book
    ${response} =    get on session    crudcrud_session    /books/${json.id}
    status should be    200
    ${json} =    set variable    ${response.json()}
    should be equal as strings    ${json.title}    Testing
    Log    ${json}