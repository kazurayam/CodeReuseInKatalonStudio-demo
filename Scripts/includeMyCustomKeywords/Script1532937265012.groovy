import codesharing.KeywordPortability
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

println "${CustomKeywords.'katalon.codesharing.Downloader.getClass'().getName()} is compiled"
println "${CustomKeywords.'katalon.codesharing.KeywordPortability.getClass'().getName()} is compiled"

String tag = '0.2'
String url = "https://github.com/kazurayam/MyCustomKeywords/archive/${tag}.zip"

List<String> packages = ['com.kazurayam.ksbackyard']

def result = CustomKeywords.'codesharing.KeywordPortability.includeCustomKeywords'(
	url,
	'',
	'',
	packages)

if (result) {
	WebUI.comment(">>> Successfully included ${packages} from ${url} into the Keywords directory")
}