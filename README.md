# HKID Validator for Android

This is a Hong Kong ID (HKID) validator design for Android

### How to install
[![](https://jitpack.io/v/seventhmoon/hkid-validator.svg)](https://jitpack.io/#seventhmoon/hkid-validator)

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.seventhmoon:hkid-validator:1.0.1'
	}
	     
### How to use
    
    HkidValidator.isValid("A123456",'3') // true, valid
    HkidValidator.isValid("A123456",'2') // false, invalid
