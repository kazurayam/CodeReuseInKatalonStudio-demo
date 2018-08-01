import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType

// open a browser and navigate to the Google Search page
WebUI.openBrowser('https://www.google.co.jp/')

def testObject = new TestObject()
testObject.addProperty('xpath', ConditionType.EQUALS, "//div[@id='hplogo']/a/img")

WebUI.verifyElementPresent(testObject, 10)

// resolve SRC attribute of <img src=".."> in the Google Search page
def imgSrc = WebUI.getAttribute(testObject, 'src')

// check if the URL responded with HTTP Status 200 OK
def status = CustomKeywords.'com.kazurayam.ksbackyard.MyCustomKeywords.getHttpResponseStatus'(imgSrc)

if (status != 200) {
    KeywordUtil.markFailed(">>> $imgSrc respondes HTTP Status $status")
}

WebUI.closeBrowser()