'use strict';

const fs = require('fs');

let issues = [];

console.log('begin transform Codyze to SQ format');

fs.readFile('findings.json', (err, data) => {
    if (err) throw err;
    let findings = JSON.parse(data);

    findings.forEach(handleFinding);

    var allIssues = {
        issues: issues
    }
    var sqFormat = JSON.stringify(allIssues);

    fs.writeFile('sq.json', sqFormat, (err) => {
        if (err) {
            throw err;
        }
    });

    //console.log(allIssues);
});

function handleFinding(finding, index, array) {
    let issueMessage = finding.onfailIdentifier + " " + finding.logMsg;

    var issue = {
        engineId: "Codyze",
        ruleId: finding.onfailIdentifier,
        severity: "BLOCKER",
        type: "VULNERABILITY",
        primaryLocation: {
            message: issueMessage,
            filePath: finding.locations[0].artifactLocation.uri.substring(finding.locations[0].artifactLocation.uri.indexOf("src"), finding.locations[0].artifactLocation.uri.length),
            textRange: {
                startLine: finding.locations[0].region.startLine + 1,
                endLine: finding.locations[0].region.endLine + 1,
                startColumn: finding.locations[0].region.startColumn,
                endColumn: finding.locations[0].region.endColumn
            }
        }
    };
    //console.log(issue);
    issues.push(issue);
}

console.log('end transform Codyze to SQ format');
