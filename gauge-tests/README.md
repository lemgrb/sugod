# Gauge + Python

+ Gauge is for '[userjourneytest](https://martinfowler.com/bliki/UserJourneyTest.html)'. (StoryTests vs UserJourneyTests)
+ Gauge is a cli
+ Specs are written in Markdown
+ [taiko](https://taiko.gauge.org) for browser automation (Not Se). taiko has REPL
+ I like gauge data-driven test! It has automatic CSV reader! Better use CSV (can be versioned)

## Install
1. [Installing Gauge](https://docs.gauge.org/getting_started/installing-gauge.html?os=windows&language=python&ide=vscode). During install you can select **language plugins**(I chose Java, JS, and Python) and **reporting plugings** (e.g. HTML, XML, Spectacle)
2. Setup plugin in VSCode
3. Check gauge cli version: `$ gauge -v`

## Initialize a gauge js project from cli
$ gauge init js

+ `.code $filename` after running commands from cli

## Initialize a gauge project from VS Code
Run `ctrl + shift + p` then '*Gauge*`

## Some issues encountered
+ [Gauge could not initialize. Install 'ms-python.python' extension for code insights. #1895](https://github.com/getgauge/gauge/issues/1895). Resolved using `'C:\Program Files\Python37\python.exe" -m pip install getgauge==0.3.17 --user"`
+ `Error Message: error reading from server: read tcp 127.0.0.1:49762->127.0.0.1:49761: wsarecv: An existing connection was forcibly closed by the remote host.
  Stacktrace:` -> Check imports and gauge.log

## Run
Run with `gauge run specs`

## REFERENCE
+ [taiko](https://taiko.gauge.org)
+ Run `.api` or `.api click`
+ [taiko.dev](https://taiko.dev)
+ [gauge.org](https://gauge.org)
+ [getgauge/gauge github repo](https://github.com/getgauge/gauge)
+ [stackoverflow #getgauge](https://stackoverflow.com/questions/tagged/getgauge)

## Others
+ Check python version: `$ python --version`
+ Check pip version: `$ pip --version`
+ PIP List: `pip list`

## What i like about gauge and other tools
+ gauge: "Plugins"
+ gauge: Specs are written in markdown
+ cypress: use of data- and cy attribute. Video recording
+ robot: drill down report + automatic screenshots

## TODO:
+ Tag 'flaky' tests for re-run

## Next:
+ https://docs.gauge.org/troubleshooting.html?os=windows&language=python&ide=vscode
+ https://github.com/angb/gauge-magento-test/tree/master/step_impl
+ https://github.com/hamcrest/PyHamcrest
+ https://www.w3schools.com/python/python_lists_comprehension.asp

## More
What assertion library to use?


