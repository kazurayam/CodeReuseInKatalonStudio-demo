import katalon.codesharing.KeywordPortability

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String tag = '0.3'
String url = "https://github.com/kazurayam/MyCustomKeywords/archive/${tag}.zip"
List<String> packages = ['com.kazurayam.ksbackyard']

def result = CustomKeywords.'katalon.codesharing.KeywordPortability.includeCustomKeywords'(
	url,
	'',
	'',
	packages)

if (result) {
	WebUI.comment(">>> Successfully included ${packages} from ${url} into the Keywords directory")
}