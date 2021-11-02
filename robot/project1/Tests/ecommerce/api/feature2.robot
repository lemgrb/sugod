*** Settings ***
Resource    ../../../Resources/CrudCrud.API.robot
Library    Collections
*** Variables ***
${ENDPOINT}  https://crudcrud.com/api/28bc4d2b0688405fb31ed20d8e5fbf1d
# NOTE: For refactoring. Need to move some Keywords to Resources
# robot -d results/api tests/ecommerce/api/feature2.robot

*** Test Cases ***
Add a book
    [Tags]    api
    Create Session    crudcrud_session    ${ENDPOINT}
    ${body} =    create dictionary     title=Testing    author=Lemuel
    ${header} =    create dictionary    Content-Type=application/json
    ${resp} =    post on session    crudcrud_session    /books    json=${body}    headers=${header}
    ${json} =    set variable  ${resp.json()}
    Status Should Be    201    ${resp}
    Log    ${json}
    ${resp} =   GET On Session    crudcrud_session    /books/${json['_id']}    expected_status=200
    Status Should Be    200    ${resp}