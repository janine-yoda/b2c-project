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

//store the current balance of agent/player
bal = WebUI.getText(findTestObject('Agent List/Action Buttons/Manage Balance/my_balance'))

//convert stored balance to float
float f_bal = Float.parseFloat(bal)

System.out.println(f_bal)

//input the amount to be transferred
WebUI.setText(findTestObject(null), '1000')

//add note
WebUI.setText(findTestObject(null), 'Transfer 1000 through manage balance.')

//click submit
WebUI.click(findTestObject(null))

//verify if success message is present
WebUI.verifyElementPresent(findTestObject(null), 3)

//click action button
WebUI.click(findTestObject(null))

//click manage balance
WebUI.click(findTestObject(null))

//add input balance to stored balance 
expected_afterCredit_bal = (f_bal + 1000.00)

//store the new balance of agent/player
afterCredit_bal = WebUI.getText(findTestObject('Agent List/Action Buttons/Manage Balance/my_balance'))

//convert to float the stored string
float f_afterCredit_bal = Float.parseFloat(afterCredit_bal)

//compare the stored value and the computed expected value (CREDIT)
res = WebUI.verifyEqual(f_afterCredit_bal, expected_afterCredit_bal)

//check if equal
if (res == true) {
	println ("New balance is correct!");
}else{
	println ("New balance is incorrect!");
}

//input the amount to be deducted
WebUI.setText(findTestObject(null), '1000')

//check debit
WebUI.click(findTestObject(null))

//input note
WebUI.setText(findTestObject(null), 'Deduct 1000 through manage balance.')

//click submit
WebUI.click(findTestObject(null))

//verify if success message is present
WebUI.verifyElementPresent(findTestObject(null), 3)

//click action button
WebUI.click(findTestObject(null))

//click manage balance
WebUI.click(findTestObject(null))

//store current balance after debit
afterDebit_bal = WebUI.getText(findTestObject('Agent List/Action Buttons/Manage Balance/my_balance'))

//subtract the amount deducted from new balance
expected_afterDebit_bal = (f_afterCredit_bal - 1000.00)

//compare the stored value and the computed expected value (DEBIT)
res_ii = WebUI.verifyEqual(afterDebit_bal, expected_afterDebit_bal)

//check if equal
if (res_ii == true) {
	println ("New balance is correct!");
}else{
	println ("New balance is incorrect!");
}
