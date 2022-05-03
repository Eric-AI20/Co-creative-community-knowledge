#!/bin/bash

# Install the pre-requirment software(Java & curl & unzip)
sudo apt-get update -y
sudo apt-get install curl openjdk-11-jre unzip git -y

# Preparing & Installing Jenkins
cd ~/
curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/ | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins -y

# Enable & Start the Jenkins Service
sudo systemctl enable jenkins
sudo systemctl start jenkins
sudo systemctl status jenkins

# Install the Gradle
cd ~/
curl -O https://downloads.gradle-dn.com/distributions/gradle-7.4-bin.zip
sudo mkdir /opt/gradle
sudo unzip -d /opt/gradle gradle-7.4-bin.zip

# Install the MariaDB
sudo apt-get install mariadb-server -y
sudo systemctl start mariadb
sudo systemctl status mariadb
sudo systemctl enable mariadb
sudo mysql -u root -e "USE mysql; UPDATE user SET password=PASSWORD('comsc'),plugin='mysql_native_password' WHERE User='root' AND Host='localhost'; FLUSH PRIVILEGES;"

# Display the Initial Admin Password
echo "Jenkins Inital Admin Password is:"
sudo cat /var/lib/jenkins/secrets/initialAdminPassword