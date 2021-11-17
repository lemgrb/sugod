from getgauge.python import before_suite, after_suite
from selenium import webdriver


class Driver(object):
    driver = None

    @before_suite
    def init():
        Driver.driver = webdriver.Chrome()
        Driver.driver.maximize_window()

    @after_suite
    def teardown():
        Driver.driver.close()
