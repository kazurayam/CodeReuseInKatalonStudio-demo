Sharing Groovy source codes as Keywords --- a demo
============

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this out onto your PC and run with your Katalon Studio. This demo project was developed using version 5.4.2.

My other GitHub project [CodeReuseInKatalonStudio](https://github.com/kazurayam/CodeReuseInKatalonStudio) provides a set of custom Keywords
`katalon.codereuse.KeywordTransferer#includeCustomKeywords()`. With this keyword, you can download a zip file of a GitHub-hosted Katalon project, and extract Groovy source files as Keywords, copy them into your current local Katalon project.

This CodeReuseInKatalonStudio-demo project shows how you can download the tools (KeywordTransferer and others) into your current local katalon project.

# How to get the tools

1. Start Katalon Studio
2. Open a new WebUI projects
3. In the `Test Cases/` create a folder `katalon.codereuse`
4. In the `Test Cases/katalon.coderesuse` create a Test Case named `bootstrap`
5. Please find [Test Cases/katalon.codereuse/bootstrap](https://github.com/kazurayam/CodeReuseInKatalonStudio-demo/blob/master/Scripts/katalon.codereuse/bootstrap/Script1533170601753.groovy). Please copy this code (about 70 lines) and paste it into your new `Test cases/katalon.coderesuse/bootstrap`. Save it.
6. Run the bootstrap script.
7. The bootstrap script will do the following:
   1. download a ZIP file from My [CodeReuseInKatalonStudio](https://github.com/kazurayam/CodeReuseInKatalonStudio) repository
   2. unzip the downloaded file
   3. extract Groovy sources of package `Keywords/katalon/codereuse`
   4. copy the Keywords into your local `Keywords` folder
   ![]()
