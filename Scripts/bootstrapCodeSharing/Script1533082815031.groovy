import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * bootstrapCodeSharing
 */

// If you are behind Corporate's Proxy, set the configration info here.
System.setProperty("proxySet", "true")
System.setProperty("proxyHost", "172.24.2.10")
System.setProperty("proxyPort", "8080")



def version = '0.1'
println """start bootstrapCodeSharing version ${version}"""

Path keywordsDir = Paths.get("Keywords")
Path packageDir  = keywordsDir.resolve("katalon").resolve("codesharing")
Path downloaderGroovy  = packageDir.resolve("Downloader.groovy")
Path portabilityGroovy = packageDir.resolve("KeywordPortability.groovy")

Files.createDirectories(packageDir)

Files.deleteIfExists(downloaderGroovy)
downloaderGroovy.toFile() << new URL(
	'https://raw.githubusercontent.com/kazurayam/CodeSharingInKatalonStudio/master/Keywords/katalon/codesharing/Downloader.groovy',
	).openStream()

Files.deleteIfExists(portabilityGroovy)
portabilityGroovy.toFile() << new URL(
	'https://raw.githubusercontent.com/kazurayam/CodeSharingInKatalonStudio/master/Keywords/katalon/codesharing/KeywordPortability.groovy'
	).openStream()	
	
println """

	You must compile the included Groovy source files with Groovy compiler.
	To compile them, you need to do the following steps:

    1. Press Ctrl+F5 in Katalon Studio to reflesh GUI;
       by this you can find the downloaded Groovy files in the Keywords directory.

    2. Open the Groovy source files with Editor,
       edit somewhere a little bit (insert a new line for example) and save them;
       by this the Groovy source files would be compiled to *.class files by groovyc

    3. If the Groovy source files are not yet compiled, you can force Katalon Studio
       to compile them by
       - stop Katalon Studio
       - remove the ${System.getProperty('user.dir')}/bin directory
         by Windows Explorer, Mac Finder or shell commandline
       - restart Katalon Studio and open the project
       - retry running this test case

"""
