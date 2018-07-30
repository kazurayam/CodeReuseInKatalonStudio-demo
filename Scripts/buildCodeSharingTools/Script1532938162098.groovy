import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


// If you are behind Proxy, set the configration info here.
// If you are not behind Proxy, comment the following 3 lines
System.setProperty("proxySet", "true")
System.setProperty("proxyHost", "172.24.2.10")
System.setProperty("proxyPort", "8080")


Path keywords    = Paths.get("Keywords")
Path codesharing = keywords.resolve("codesharing")
Path downloader  = codesharing.resolve("Downloader.groovy")
Path portability = codesharing.resolve("KeywordPortability.groovy")

Files.createDirectories(codesharing)

Files.deleteIfExists(downloader)
downloader.toFile() << new URL(
	'https://raw.githubusercontent.com/kazurayam/CodeSharingInKatalonStudio/master/Keywords/codesharing/Downloader.groovy',
	).openStream()

Files.deleteIfExists(portability)
portability.toFile() << new URL(
	'https://raw.githubusercontent.com/kazurayam/CodeSharingInKatalonStudio/master/Keywords/codesharing/KeywordPortability.groovy'
	).openStream()	

	
	
println """

	You must refresh Katalon Studio with Ctrl+F5 to see the downloaded artifacts.
	You must compile ${downloader} and ${portability} with Groovy compiler.
	Open 2 files with Keyword Editor and save.

"""
