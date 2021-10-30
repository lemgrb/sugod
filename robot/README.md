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

## Pre
Install Python
Install pip: 
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

To run: `robot -d results tests/script.robot`