from getgauge.python import step, Messages
from step_impl.utils.driver import Driver
from selenium.webdriver.support.ui import WebDriverWait
import os


@step("Launch strapi ecommerce starter")
def launch_strapi_ecommerce_starter():
    URL = os.getenv("BASE_URL")
    Driver.driver.get(URL)


@step("Select <sticker_name> product")
def select_the_sticker(sticker_name):
    Messages.write_message("//h4[contains(text(),\"" + sticker_name + "\")]")
    Driver.driver.find_element_by_xpath(
        "//h4[contains(text(),\"" + sticker_name + "\")]").click()
    WebDriverWait(Driver.driver, timeout=3).until(
        lambda d: d.find_element_by_css_selector("button.snipcart-add-item"))


@step("Click add to cart")
def click_add_to_cart():
    Driver.driver.find_element_by_css_selector(
        "button.snipcart-add-item").click()
    WebDriverWait(Driver.driver, timeout=3).until(
        lambda d: d.find_element_by_css_selector("button.snipcart-cart-button"))


@step("Check out")
def check_out():
    Driver.driver.find_element_by_css_selector(
        "button.snipcart-cart-button").click()


@step("Verify <text> is displayed")
def verify_text_is_displayed(text):
    # Assert billing page is displayed
    WebDriverWait(Driver.driver, timeout=5).until(
        lambda d: d.find_element_by_xpath("//*[contains(text(),'"+text+"')]"))
