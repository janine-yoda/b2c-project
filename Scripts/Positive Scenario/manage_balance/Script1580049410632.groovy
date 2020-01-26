import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

txt_balance = WebUI.getText(findTestObject('Agent List/my_balance'))

WebUI.setText(findTestObject(null), '1000')

WebUI.setText(findTestObject(null), 'Transfer 1000 through manage balance.')

WebUI.click(findTestObject(null))

WebUI.verifyElementPresent(findTestObject(null), 3)

WebUI.click(findTestObject(null))

WebUI.click(findTestObject(null))

float f_bal = Float.parseFloat(txt_bal)

System.out.println(f_bal)

bal_credit = (f_bal + 1000.00)

new_txt_bal = WebUI.getText(findTestObject('Agent List/my_balance'))

float new_f_bal = Float.parseFloat(txt_bal)

WebUI.verifyEqual(bal_credit, f_new_bal)

WebUI.setText(findTestObject(null), '1000')

WebUI.click(findTestObject(null))

WebUI.setText(findTestObject(null), 'Deduct 1000 through manage balance.')

WebUI.click(findTestObject(null))

WebUI.verifyElementPresent(findTestObject(null), 0)

WebUI.click(findTestObject(null))

WebUI.click(findTestObject(null))

