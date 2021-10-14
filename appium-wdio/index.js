const wdio = require("webdriverio");
const assert = require("assert");

const opts = {
  path: '/wd/hub',
  port: 4723,
  capabilities: {
    platformName: "Android",
    platformVersion: "10",
    deviceName: "3441e22",
    app: "C:/Users/testersnotes/Downloads/surveymonkey.apk",
    automationName: "UiAutomator2"
  }
};

(async () => {
  const client = await wdio.remote(opts);

  const selector = 'new UiSelector().resourceId("com.surveymonkey:id/app_ranking")'
  const signInButtonPromise = await client.$(`android=${selector}`)
  const isDisplayed = await signInButtonPromise.isDisplayed();
  assert.strictEqual(isDisplayed, true);

  await client.deleteSession();
})();