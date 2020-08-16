package utils

import com.relevantcodes.extentreports.ExtentReports
import com.relevantcodes.extentreports.ExtentTest
import com.relevantcodes.extentreports.LogStatus
import org.testng.ITestResult
import java.io.File

object ExtentReportsManager {
    fun loadConfig(): ExtentReports {
        val extentReports = ExtentReports("target//reports/extentReports.html", true)
        extentReports.loadConfig(File("src/main/resources/reports/extent-config.xml"))
        return extentReports
    }

    fun logExtent(extentReports: ExtentReports, extentTest: ExtentTest, iTestResult: ITestResult) {
        if (iTestResult.status == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, iTestResult.name, "Test was unsuccessful")
        } else if (iTestResult.status == ITestResult.SUCCESS) {
            extentTest.log(LogStatus.PASS, iTestResult.name, "Test was successful")
        } else {
            extentTest.log(LogStatus.SKIP, iTestResult.name, "Test was skipped")
            extentTest.log(LogStatus.SKIP, iTestResult.throwable)
        }
        extentReports.endTest(extentTest)
    }
}
