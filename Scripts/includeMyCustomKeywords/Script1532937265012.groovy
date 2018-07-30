import codesharing.KeywordPortability
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

println "${CustomKeywords.'codesharing.Downloader.getClass'().getName()} is compiled"
println "${CustomKeywords.'codesharing.KeywordPortability.getClass'().getName()} is compiled"

String url = 'https://github.com/kazurayam/MyCustomKeywords/archive/master.zip'
List<String> packages = ['com.kazurayam.ksbackyard']

def result = CustomKeywords.'codesharing.KeywordPortability.includeCustomKeywords'(
	url,
	'',
	'',
	packages)

if (result) {
	WebUI.comment(">>> Successfully included ${packages} out of ${url} into Keywords")
}