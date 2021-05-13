[![Build Status](https://www.travis-ci.com/Relesi/inteligent-integrated.svg?branch=master)](https://www.travis-ci.com/Relesi/inteligent-integrated)
## Integrated Guide

**Using gradle?** See [gradle example](https://github.com/Relesi)

### Travis Setup

Add to your `.travis.yml` file.
```yml
language: java
after_success:
  - bash <(curl -s https://codecov.io/bash)
```
### Produce Coverage Reports
#### Add Jacoco plugin
```xml
<plugin>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <version>0.7.9</version>
  <executions>
    <execution>
      <goals>
        <goal>prepare-agent</goal>
      </goals>
    </execution>
    <execution>
      <id>report</id>
      <phase>test</phase>
      <goals>
        <goal>report</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```

### Private Repos
Add to your `.travis.yml` file.
```yml


Development...


