## Anatomy of framework:
1. Language
2. Scripts
3. Reusable page/entity objects
4. Supporting libraries (web, api, DB, mobile)
5. Abstraction layer for increased readability
6. Test runner with selective run capability (e.g. tags)
7. Suite/test setup and teardown (recovery)
8. Reports
    + Summary
    + Timestamp
    + Drill down
    + Search
    + Embedded screenshot
9. Scheduler/CI
10. Parallel execution
11. Conventions
12. Data driven

## Pre
1. Install Python
2. Install pip: 

```bash
> pip install robotframework-seleniumlibrary
> pip install robotframework-requests
See more on pypi.python.org
> pip list
> Install intellibot (patched) plugin in PyCharm
```

- Inspect using CTRL+B and/or ALT + <-
- Alt + Click : close all to the right

```bash
Directory structure:
/Tests
  /product-1
    - feature1.robot
    - feature2.robot
/Resources -> PO, Keywords
  common.robot (Suite setup, Open browser)
  - feature1.robot
  - feature2.robot
  /page-objects
    - po1.robot
    - po2.robot
/Results
  /product-1
```

## Locating webelements
See [Keyword documentation#Locating elements](https://robotframework.org/SeleniumLibrary/SeleniumLibrary.html#Locating%20elements)

## Run
- To run: `robot -d results tests/script.robot`
- To run with tags: `robot -d results -i sanity Tests\strapi-ecommerce-starter.robot`
- Pass a variable: `robot -d results -v BROWSER:chrome test/test.robot`
- Run all tests: `robot -d results -N "Some new name" tests`
- Run some test: `robot -d results -N "Some new name" tests/Project1`
- Run 1 test: `robot -t "Test test case name" tests/sample.robot" # Specify robot file
- Run 1 test: `robot -t "Test test case name" tests` # Specify folder
- Rerun failed: `robot -d results --rerunfailed Results/output.xml tests" # Specify folder
