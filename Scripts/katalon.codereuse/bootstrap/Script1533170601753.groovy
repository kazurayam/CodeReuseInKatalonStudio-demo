import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * bootstrap
 * 
 * This Groovy script downloads some Groovy class source files from
 * my GitHub project 'kazurayam/CodeReuseInKatalonStudio' and
 * save them into the directory './Keywords/katalon/codereuse'
 * 
 * You need to ensure compiling the downloaded Groovy classes.
 * 
 * Once compiled, a Groovy class 'katalon.codereuse.KeywordTransferer' become
 * available to you. This class enables you to include Groovy class source files
 * from any GitHub-hosted repositories.
 * 
 */

// If you are behind Corporate's Proxy, set the configration info here.
System.setProperty("proxySet", "true")
System.setProperty("proxyHost", "172.24.2.10")
System.setProperty("proxyPort", "8080")

Path keywordsDir = Paths.get("Keywords")
Path packageDir  = keywordsDir.resolve("katalon").resolve("codereuse")
Files.createDirectories(packageDir)

List<String> groovySources = [
	'Downloader.groovy',
	'KeywordTransferer.groovy',
	'Version.groovy']

String KATALON_CODEREUSE_VERSION = '0.1'
 
for (String fileName : groovySources) {
	Path p = packageDir.resolve(fileName)
	Files.deleteIfExists(p)
	p.toFile() << new URL(
		"https://raw.githubusercontent.com/kazurayam/CodeReuseInKatalonStudio" + 
			"/${KATALON_CODEREUSE_VERSION}/Keywords/katalon/codereuse/${fileName}"
		).openStream()
}
	
println """

	You must compile the included Groovy source files with Groovy compiler.
	To ensure compiling them, you need to do the following steps:

    1. Press Ctrl+F5 in Katalon Studio to reflesh GUI.
       By this operation you would find the downloaded Groovy files 
       in the Keywords directory.

    2. Open the Groovy source files with Editor.
       Edit somewhere a little bit (insert a new line for example) and save them.
       By this opertion, the Groovy source files would be compiled 
       to *.class files.

    3. If the Groovy source files are not yet compiled,
       you can force Katalon Studio to compile them by
       - Stop Katalon Studio GUI
       - Remove the ${System.getProperty('user.dir')}/bin directory
         by Windows Explorer, Mac Finder or shell commandline
       - Restart Katalon Studio and open the project
       - Retry running this test case 'bootstrap'

"""
