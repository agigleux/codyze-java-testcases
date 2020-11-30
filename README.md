# codyze-java-testcases
Java Test Cases inspired from Codyze that can be compiled and be scanned with SonarCloud.

# Generate the Codyze Results
```
~/Softwares/codyze-1.4.1/bin/codyze -c -s=src/main/java/ -m=.../Softwares/codyze-1.4.1/mark/bouncycastle/ --no-good-findings
```

# Convert Codyze Results into SonarQube Format
```
node transform-codyze-sq.js
```

# Scan and Load Results into SonarQube
```
mvn clean veerify sonar:sonar \
 -Dsonar.projectKey=codyze-java-testcases \
 -Dsonar.host.url=http://localhost:9000 \
 -Dsonar.login=... \
 -Dsonar.externalIssuesReportPaths=sq.json
```

# Expected Rules from SonarQube

* https://rules.sonarsource.com/java/RSPEC-5542
* https://rules.sonarsource.com/java/RSPEC-5547
* https://rules.sonarsource.com/java/RSPEC-3329
